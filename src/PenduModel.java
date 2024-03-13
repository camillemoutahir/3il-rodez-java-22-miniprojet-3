import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class PenduModel {
    private Random random = new Random();
    private TreeMap<String, String> map;
    private char lettreProposee;
    private Set<Character> lettresProposees;
    private int tentativesRestantes = 7;
    public void MotAleatoire(String fichier) {
        map = new TreeMap<String, String>();
        lireFichier(Paths.get(fichier));
    }

    private void lireFichier(Path fichier){
        try (BufferedReader br = Files.newBufferedReader(fichier)) {
            String line = br.readLine();
            while (line != null){
                String[] bouts = line.split(" ",2);
                map.put(bouts[0], bouts[1]);
                line = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Map.Entry<String, String> getMot(){
        List<Map.Entry<String, String>> liste = new ArrayList<>(map.entrySet());
        return liste.get(random.nextInt(liste.size()));
    }

    public PenduModel() {
        this.lettresProposees = new HashSet<>();
        // Initialisation d'autres attributs et chargement du mot depuis le fichier

    }
    public char lettreProposer(String mot){
        return mot.charAt(random.nextInt(mot.length()));
    }

    public boolean verificationLettre (String mot, char lettreProposee){
        boolean verif = false;
        int occurence = 0;

        for (int i=0; i<=mot.length(); i++){
            if(mot.toUpperCase().contains(String.valueOf(lettreProposee))
        ){
                verif = true;
                occurence ++;
            }
        }
        return verif;
    }
    public int miseJourTentativesRestantes (String mot, char lettreProposee){
        if (!verificationLettre(mot, lettreProposee)){
            tentativesRestantes--;
        }
        return tentativesRestantes;
    }
    public boolean statutJeu (int tentativesRestantes){
        boolean victoire = true;
        if (tentativesRestantes == 8){
            victoire = false;
            System.out.println("GameOver");
        }
        return victoire;
    }




    // Implémentez les méthodes nécessaires pour le jeu, par exemple : 
    // - Vérification de la proposition d'une lettre
    // - Mise à jour du pendu et du nombre de tentatives restantes
    // - Vérification de la victoire ou de la défaite
    // - etc.
}