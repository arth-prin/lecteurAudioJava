import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Morceau {
    String nom;
    String auteur;
    String fichier;
    String album;

    private JLabel texte;
    private JButton bouton = new JButton("Go");
    private JButton bouton2 = new JButton("Stop");
    private boolean animated = true;

    private AudioMp3 audioMp3;

    public Morceau(String file, String nom, String album, String auteur){
        this.nom=nom;
        this.fichier=file;
        this.auteur=auteur;
        this.album=album;
        audioMp3 = new AudioMp3(file);
        texte = new JLabel(nom);
    }

    public void ajouteMorceau(JPanel panel){
        Border blackline = BorderFactory.createLineBorder(Color.blue);

        texte.setBackground(Color.CYAN);
        texte.setBorder(blackline);
        texte.setHorizontalAlignment(JLabel.CENTER);
        panel.add(texte);
        bouton.addActionListener(new BoutonListener());
        bouton.setEnabled(true);
        bouton2.addActionListener(new Bouton2Listener());
        bouton2.setEnabled(false);

        panel.add(bouton);
        panel.add(bouton2);
    }

    class BoutonListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            animated = true;
            bouton.setEnabled(false);
            bouton2.setEnabled(true);
            audioMp3.joue();
        }
    }

    class Bouton2Listener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            animated = false;
            bouton.setEnabled(true);
            bouton2.setEnabled(false);
            audioMp3.stop();
        }
    }

    @Override
    public String toString() {
        return "Morceau{" +
                "nom='" + nom + '\'' +
                ", auteur='" + auteur + '\'' +
                ", fichier='" + fichier + '\'' +
                '}';
    }
}
