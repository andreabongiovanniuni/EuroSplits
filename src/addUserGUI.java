import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addUserGUI extends JFrame implements ActionListener {

    public addUserGUI(){


        this.setLayout(null);
        this.setVisible(true);
        this.setSize(1080, 720);
        this.setTitle("Aggiungi Utente");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.darkGray);
        ImageIcon icon = new ImageIcon("euro.png");
        this.setIconImage(icon.getImage());
        this.setResizable(false);
    }




    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
