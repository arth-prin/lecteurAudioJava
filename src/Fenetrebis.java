import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;

public class Fenetrebis extends JFrame{

    private JPanel container = new JPanel();
    private JLabel label = new JLabel("Les titres");
    private JLabel bouton = new JLabel();
    private int nbMorceaux=9;
    private LecteurCSV morceaux;
    private JButton btnTriTitre = new JButton("Trier par Titres");
    private JButton btnTriTitreR = new JButton("Trier par Titres R");
    private JButton btnTriAlbum = new JButton("Trier par Album");
    private JButton btnTriAlbumR = new JButton("Trier par Album R");
    private JButton btnTriAuteur = new JButton("Trier par Artites");
    private JButton btnTriAuteurR = new JButton("Trier par Artites R");



    public Fenetrebis() throws IOException {
        morceaux = new LecteurCSV("./music/listeMorceaux.csv");
        this.setTitle("Mes musiques");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        JPanel north = new JPanel();
        Font police = new Font("Tahoma", Font.BOLD, 16);
        label.setFont(police);
        label.setForeground(Color.blue);
        label.setHorizontalAlignment(JLabel.CENTER);
        north.setLayout(new GridLayout(3,1));
        north.add(label);
        north.add(bouton);
        north.add(container);

        container.setBackground(Color.white);
        container.setLayout(new GridLayout(nbMorceaux,3));
        bouton.setLayout(new GridLayout(1,6));

        for(Morceau morceau : morceaux.getMorceaux()){
            morceau.ajouteMorceau(container);
        }

        btnTriTitre.addActionListener(new BoutonTriTitreListener());
        btnTriTitre.setEnabled(true);
        bouton.add(btnTriTitre);

        btnTriTitreR.addActionListener(new BoutonTriTitreRListener());
        btnTriTitreR.setEnabled(true);
        bouton.add(btnTriTitreR);

        btnTriAlbum.addActionListener(new BoutonTriAlbumListener());
        btnTriAlbum.setEnabled(true);
        bouton.add(btnTriAlbum);

        btnTriAlbumR.addActionListener(new BoutonTriAlbumRListener());
        btnTriAlbumR.setEnabled(true);
        bouton.add(btnTriAlbumR);

        btnTriAuteur.addActionListener(new BoutonTriAlbumRListener());
        btnTriAuteur.setEnabled(true);
        bouton.add(btnTriAuteur);

        btnTriAuteurR.addActionListener(new BoutonTriAlbumRListener());
        btnTriAuteurR.setEnabled(true);
        bouton.add(btnTriAuteurR);

        this.setContentPane(north);
        this.setVisible(true);
    }

    public void reloadMorceaux(){
        container.removeAll();
        container.revalidate();
        container.repaint();
        for(Morceau morceau : morceaux.getMorceaux()){
            morceau.ajouteMorceau(container);
        }
    }

    class BoutonTriTitreListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            morceaux.sortNomsMorceaux();
            reloadMorceaux();
        }
    }

    class BoutonTriTitreRListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            morceaux.sortNomsMorceauxR();
            reloadMorceaux();
        }
    }

    class BoutonTriAlbumListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            morceaux.sortNomsAlbum();
        }
    }

    class BoutonTriAlbumRListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            morceaux.sortNomsAlbumR();
        }
    }

    class BoutonTriArtiste implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            morceaux.sortNomsAuteur();
        }
    }

    class BoutonTriArtitesR implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            morceaux.sortNomsAuteurR();
        }
    }
}