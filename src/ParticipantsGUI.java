import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class ParticipantsGUI extends JFrame implements ActionListener {
    
    Group g1;
    Shop sh1; 
    ArrayList<Double> p1;
    LinkedHashMap<Integer, List<User>> u1;
    JTextField userText;
    JButton indietroButton;
    JButton aggiungiButton;
    JButton fineButton;
    public ParticipantsGUI(Group g, Shop sh, ArrayList<Double> p, LinkedHashMap<Integer, List<User>> u){
       
        g1 = g;
        sh1 = sh;
        p1 = p;
        u1 = u;

        indietroButton = new JButton("Indietro");
        indietroButton.setFont(new Font(null, Font.PLAIN, 20));
        indietroButton.setBounds(5, 625, 150, 50);

        aggiungiButton = new JButton("Aggiungi");
        aggiungiButton.setFont(new Font(null, Font.PLAIN, 20));
        aggiungiButton.setBounds(750, 275, 200, 50);

        fineButton = new JButton("Fine");
        fineButton.setFont(new Font(null, Font.PLAIN, 20));
        fineButton.setBounds(800, 625, 150, 50);
        
        userText = new JTextField("Username");
        userText.setPreferredSize(new Dimension(275, 50));
        userText.setFont(new Font(null, Font.PLAIN, 18));

        JPanel panel = new JPanel();
        panel.setBackground(Color.cyan);
        panel.setBorder(BorderFactory.createLineBorder(Color.blue, 3));
        panel.add(userText);

        this.setLayout(null);
        this.setVisible(true);
        this.setSize(1080, 720);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Scegli Modalità");
        this.getContentPane().setBackground(Color.darkGray);
        ImageIcon icon = new ImageIcon("euro.png");
        this.setIconImage(icon.getImage());
        this.setResizable(false);
        this.add(indietroButton);
        this.add(aggiungiButton);
        this.add(panel);
        this.add(fineButton);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == aggiungiButton){
            System.out.println("hello");
        }
        else if(e.getSource() == fineButton){
            System.out.println("hello");

        }
        else if(e.getSource() == indietroButton){
            System.out.println("hello");

        }
    }
}
