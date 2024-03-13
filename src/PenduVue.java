import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PenduVue extends JFrame {
    private JButton commencerPartieButton;
    private JButton proposerlettre;
    private JLabel motLabel;
    private JLabel imagePenduLabel;
    private JLabel tentativesLabel;

    public PenduVue() {
        // Initialisation de la fenêtre Swing, des composants, etc.
        initialiserInterface();
    }

    private void initialiserInterface() {
        setTitle("Jeu du Pendu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLayout(new BorderLayout());

        // Image du pendu
        imagePenduLabel = new JLabel();
        imagePenduLabel.setHorizontalAlignment(JLabel.CENTER);
        add(imagePenduLabel, BorderLayout.CENTER);

        // Tentatives restantes
        tentativesLabel = new JLabel("Tentatives restantes : ");
        tentativesLabel.setHorizontalAlignment(JLabel.CENTER);
        add(tentativesLabel, BorderLayout.NORTH);

        // Bouton pour commencer la partie
        commencerPartieButton = new JButton("Commencer la partie");
        commencerPartieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Réagir au clic sur le bouton (commencer la partie)
                // Vous pouvez déclencher ici l'initialisation d'une nouvelle partie
            }
        });
        add(commencerPartieButton, BorderLayout.SOUTH);

        // Rafraîchir l'interface (ajuster l'image du pendu, les tentatives, etc.) ici
        // ...

        // Assurez-vous d'avoir les images du pendu dans le bon chemin
        // Remplacez "chemin/vers/bonhomme0.png" par le chemin réel de vos images
        imagePenduLabel.setIcon(new ImageIcon("chemin/vers/bonhomme0.png"));

    }

    public Button getProposerButton() {
        return null;
    }

    // Ajoutez des méthodes pour mettre à jour l'interface en fonction des changements dans le modèle
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PenduVue().setVisible(true);
            }
        });
    }
}

