public class MainPendu {
    public static void main(String[] args) {
        PenduModel model = new PenduModel();
        PenduVue view = new PenduVue();
        PenduControleur controller = new PenduControleur(model, view);

        // Configurez la fenêtre principale, etc.
    }
}