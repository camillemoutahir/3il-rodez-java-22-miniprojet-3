import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.*;

public class PenduModel {
    private String motAdeviner;
    private TreeMap<String, String> map;
    private char lettreProposee;
    private Set<Character> lettresProposees;
    private int tentativesRestantes = 7;

    public PenduModel(char lettreProposee) {
        this.lettreProposee = lettreProposee;
    }

    public PenduModel(String cheminFichier) {
        // Initialise le modèle avec le mot à deviner
        initialiserMotAdeviner(cheminFichier);
        lettresProposees = new HashSet<>();
    }

    public String getMotAdeviner() {
        return motAdeviner;
    }

    public Map.Entry<String, String> initialiserMotAdeviner(String cheminFichier) {
        Map.Entry<String, String> motAleatoireEntry = obtenirMotAleatoire(cheminFichier);
        motAdeviner = motAleatoireEntry.getKey();
        return motAleatoireEntry;
    }
    private static Map.Entry<String, String> obtenirMotAleatoire(String cheminFichier) {
        Random random = new Random();
        TreeMap<String, String> map = new TreeMap<>();

        // Lecture du fichier et remplissage de la map
        try (BufferedReader br = Files.newBufferedReader(Paths.get(cheminFichier))) {
            String line = br.readLine();
            while (line != null) {
                String[] bouts = line.split(" ", 2);
                map.put(bouts[0], bouts[1]);
                line = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Obtention d'une entrée de carte (mot, définition) de manière aléatoire
        List<Map.Entry<String, String>> liste = new ArrayList<>(map.entrySet());
        return liste.get(random.nextInt(liste.size()));
    }
    public static void main(String[] args) {
        // Spécifiez le chemin vers votre fichier
        String cheminFichier = "mots.txt";

        // Crée une instance de PenduModel en passant le chemin du fichier
        PenduModel penduModel = new PenduModel(cheminFichier);

        // Obtient le mot à deviner en appelant la méthode initialiserMotAdeviner
        String motAdeviner = penduModel.getMotAdeviner();

        // Affiche le mot à deviner
        System.out.println("Mot à deviner : " + motAdeviner);
    }
    public char lettreProposer(String mot){
        //pour proposer des lettres à l'utilisateur (indice)
        Random random = new Random();
        return mot.charAt(random.nextInt(mot.length()));
    }

    public boolean verificationLettre(char lettreProposee) {
        boolean verif = false;
        for (int i = 0; i < motAdeviner.length(); i++) {
            if (motAdeviner.toUpperCase().charAt(i) == Character.toUpperCase(lettreProposee)) {
                verif = true;
                break; // Sortir de la boucle dès qu'on a trouvé la lettre
            }
        }
        return verif;
    }

    public int miseJourTentativesRestantes (char lettreProposee){
        if (!verificationLettre(lettreProposee)){
            tentativesRestantes--;
        }
        return tentativesRestantes;
    }

    public boolean statutJeu(Set<Character> lettresProposees, int tentativesRestantes) {
        boolean victoire = false;

        if (tentativesRestantes > 0 && lettresProposees.containsAll(stringToSet(motAdeviner))) {
            victoire = true;
        }

        return victoire;
    }

    private Set<Character> stringToSet(String str) {
        Set<Character> charSet = new HashSet<>();
        for (char c : str.toCharArray()) {
            charSet.add(Character.toUpperCase(c));
        }
        return charSet;
    }


    public int getTentativesRestantes() {
        return tentativesRestantes;
    }

    public Set<Character> getLettresProposees() {
        return lettresProposees;
    }
}
