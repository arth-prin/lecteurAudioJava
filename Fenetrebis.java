import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Fenetrebis extends JFrame{

    private JPanel container = new JPanel();
    private JLabel label = new JLabel("Les titres");
    Morceau morceau1,morceau2;
    private int nbMorceaux=2;

    public Fenetrebis(){
        this.setTitle("Mes musiques");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        JPanel north = new JPanel();
        Font police = new Font("Tahoma", Font.BOLD, 16);
        label.setFont(police);
        label.setForeground(Color.blue);
        label.setHorizontalAlignment(JLabel.CENTER);
        north.setLayout(new GridLayout(nbMorceaux+1,1));
        north.add(label);
        north.add(container);

        container.setBackground(Color.white);
        container.setLayout(new GridLayout(nbMorceaux,3));
        morceau1 = new Morceau("/Users/scoste/essai.mp3","Inconnu");
        morceau1.ajouteMorceau(container);
        morceau2 = new Morceau("/Users/scoste/Compte/Exposes/BeamerAvecSons/paganini.wav","Paganini");
        morceau2.ajouteMorceau(container);

        this.setContentPane(north);
        this.setVisible(true);
    }


}