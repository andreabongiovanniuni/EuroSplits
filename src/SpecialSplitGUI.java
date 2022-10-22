import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SpecialSplitGUI extends JFrame implements ActionListener {

    public SpecialSplitGUI(Group g){


        this.setLayout(null);
        this.setVisible(true);
        this.setSize(1080, 720);
        this.setTitle("Scegli Modalità");
        this.getContentPane().setBackground(Color.darkGray);
        ImageIcon icon = new ImageIcon("euro.png");
        this.setIconImage(icon.getImage());
        this.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
