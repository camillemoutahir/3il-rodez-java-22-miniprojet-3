import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PenduControleur {
    private PenduModel model;
    private PenduVue view;

    public PenduControleur(PenduModel model, PenduVue view) {
        this.model = model;
        this.view = view;

    }
}
