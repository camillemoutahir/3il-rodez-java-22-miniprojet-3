import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class main {

        public static void main(String[] args) {
            // Spécifiez le chemin vers votre fichier
            String cheminFichier = "mots.txt";

            // Crée une instance de MotAleatoire en passant le chemin du fichier
            MotAleatoire motAleatoire = new MotAleatoire(cheminFichier);

            // Utilisez la méthode lireMotDef pour obtenir une paire clé-valeur aléatoire
            Map<String, String> resultat = motAleatoire.lireMotDef(new Random(), (TreeMap<String, String>) MotAleatoire.map);

            // Affiche le résultat
            System.out.println("Mot aléatoire : " + resultat);
        }
    }