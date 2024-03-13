public class MainPendu {
    public static void main(String[] args) {
        String cheminFichier = "mots.txt";
        PenduModel model = new PenduModel(cheminFichier);
        PenduVue view = new PenduVue();
        PenduControleur controller = new PenduControleur(model, view);

        // Configurez la fenêtre principale, etc.
    }
}
