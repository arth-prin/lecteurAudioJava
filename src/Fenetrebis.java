import java.awt.*;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Fenetrebis extends JFrame{

    private JPanel container = new JPanel();
    private JLabel label = new JLabel("Les titres");
    Morceau morceau1,morceau2;
    private int nbMorceaux=9;
    private LecteurCSV morceaux;

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
        north.setLayout(new GridLayout(2,1));
        north.add(label);
        north.add(container);

        container.setBackground(Color.white);
        container.setLayout(new GridLayout(nbMorceaux,3));
        morceaux.sortNomsMorceauxR();
        for(Morceau morceau : morceaux.getMorceaux()){
            morceau.ajouteMorceau(container);
        }

        this.setContentPane(north);
        this.setVisible(true);
    }


}