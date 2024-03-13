import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.util.Map;

public class PenduVue extends JFrame {
    private JButton commencerPartieButton;
    private JTextField lettreProposeeTextField;
    private JButton proposerLettreButton;
    private JLabel motLabel;
    private JLabel imagePenduLabel;
    private JLabel tentativesRestantesLabel;
    private PenduModel model;

    public PenduVue() {
        String cheminFichier = "mots.txt";
        model = new PenduModel(cheminFichier);
        initialiserInterface();
    }

    private void initialiserInterface() {
        setTitle("Jeu du Pendu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLayout(new BorderLayout());

        imagePenduLabel = new JLabel();
        add(imagePenduLabel, BorderLayout.CENTER);

        // Bouton pour commencer la partie
        commencerPartieButton = new JButton("Commencer la partie");
        commencerPartieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commencerPartie();
            }
        });
        add(commencerPartieButton, BorderLayout.NORTH);
        lettreProposeeTextField = new JTextField();
        add(lettreProposeeTextField, BorderLayout.CENTER);

        proposerLettreButton = new JButton("Proposer une lettre");
        proposerLettreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                proposerLettre();
            }
        });
        add(proposerLettreButton, BorderLayout.SOUTH);

        tentativesRestantesLabel = new JLabel("Tentatives restantes : ");
        add(tentativesRestantesLabel, BorderLayout.EAST);
    }

    private void commencerPartie() {
        String cheminFichier = "mots.txt";
        model.initialiserMotAdeviner(cheminFichier);

        lettreProposeeTextField.setEnabled(true);
        proposerLettreButton.setEnabled(true);
        tentativesRestantesLabel.setText("Tentatives restantes : " + model.getTentativesRestantes());

        String mot = model.getMotAdeviner();
        System.out.println("Mot choisi : " + mot);
        afficherImagePendu(model.getTentativesRestantes());
    }

    private void proposerLettre() {
        String lettreProposeeText = lettreProposeeTextField.getText();
        if (lettreProposeeText.length() > 0) {
            char lettre = lettreProposeeText.charAt(0);
            if (model.verificationLettre(lettre)) {
                System.out.println("Lettre correcte : " + lettre);
            } else {
                System.out.println("Lettre incorrecte : " + lettre);
                model.miseJourTentativesRestantes(lettre);
                int tentativesRestantes = model.getTentativesRestantes();
                tentativesRestantesLabel.setText("Tentatives restantes : " + tentativesRestantes);

                // Mettre à jour le statut du jeu
                if (!model.statutJeu(model.getLettresProposees(), tentativesRestantes)) {
                    System.out.println("Game Over");
                    ImageIcon gameover = new ImageIcon("gameover.png");
                    imagePenduLabel.setIcon(gameover);
                } else if (model.statutJeu(model.getLettresProposees(), tentativesRestantes)) {
                    System.out.println("Vous avez gagné !");
                    ImageIcon victoire = new ImageIcon("victoire.png");
                    imagePenduLabel.setIcon(victoire);
                }
            }
        }
    }
    private void afficherImagePendu(int tentativesRestantes) {
        // Charger l'image correspondante
        ImageIcon image = new ImageIcon("pendu" +  tentativesRestantes + ".png");
        imagePenduLabel.setIcon(image);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PenduVue().setVisible(true);
            }
        });
    }
}
