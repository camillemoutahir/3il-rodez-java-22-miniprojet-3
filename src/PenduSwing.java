import javax.swing.*;

public class PenduSwing {
    // Méthode principale main, point d'entrée du programme
    public static void main(String[] args) {
        // Utilisation de SwingUtilities.invokeLater pour garantir l'exécution dans le thread de l'interface graphique
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            // Méthode run qui sera exécutée dans le thread de l'interface graphique
            public void run() {
                // Création d'une instance de JFrame (fenêtre graphique) avec le titre "Bonjour Swing"
                JFrame fenetre = new JFrame("Bonjour Joueur");
                // Création d'une étiquette (JLabel) avec le texte "Bonjour, monde !"
                JLabel etiquette = new JLabel("Bienvenue!");
                // Ajout de l'étiquette au contenu de la fenêtre
                fenetre.getContentPane().add(etiquette);
                // Définition de l'opération à effectuer lorsquela fenêtre est fermée fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                // Ajustement automatique de la taille de la fenêtre en fonction de son contenu
                fenetre.pack();
                // Rendre la fenêtre visible
                fenetre.setVisible(true);
            }
        });
    }
}
/*Patron SingletonPatron MVC*/
/* — Zones de texte : JTextField, JTextArea
Panneaux : JPanel
— Fenêtres : JFrame*/

