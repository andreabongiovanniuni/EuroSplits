import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class ParticipantsGUI extends JFrame implements ActionListener {
    /**contiene i partecipanti della spesa*/
    Group g;
    /**contiene la spesa interessata*/
    Shop sh;
    /**contiene i prezzi*/
    ArrayList<Double> p;
    /**contiene i sottogruppi*/
    LinkedHashMap<Integer, LinkedList<User>> us;
    /**contiene il sottogruppo da aggiungere*/
    LinkedList<User> u ;
    JTextField userText;
    JButton indietroButton;
    JButton aggiungiButton;
    JButton fineButton;
    JButton showButton;
    public ParticipantsGUI(Group g, Shop sh, ArrayList<Double> p, LinkedHashMap<Integer, LinkedList<User>> us,
                           LinkedList<User> u){

        this.g = g;
        this.sh = sh;
        this.p = p;
        this.us = us;
        this.u = u;

        showButton = new JButton("Partecipanti Gruppo");
        showButton.addActionListener(this);
        showButton.setFont(new Font(null, Font.BOLD, 15));
        showButton.setBounds(100, 275, 200, 70);

        indietroButton = new JButton("Indietro");
        indietroButton.addActionListener(this);
        indietroButton.setFont(new Font(null, Font.PLAIN, 20));
        indietroButton.setBounds(5, 625, 150, 50);

        aggiungiButton = new JButton("Aggiungi");
        aggiungiButton.addActionListener(this);
        aggiungiButton.setFont(new Font(null, Font.PLAIN, 20));
        aggiungiButton.setBounds(750, 275, 200, 50);

        fineButton = new JButton("Fine");
        fineButton.addActionListener(this);
        fineButton.setFont(new Font(null, Font.PLAIN, 20));
        fineButton.setBounds(400, 400, 150, 50);
        
        userText = new JTextField("Username");
        userText.setPreferredSize(new Dimension(275, 50));
        userText.setFont(new Font(null, Font.PLAIN, 18));

        JLabel label = new JLabel();
        label.setText("Inserisci partecipante al prodotto");
        label.setForeground(Color.cyan);
        label.setFont(new Font(null, Font.BOLD, 50));

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
        this.add(showButton);

        panel.setBounds(400, 275, 300, 70);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == aggiungiButton){
            u.add(g.getUser(userText.getText()));
            this.setVisible(false);
            new ParticipantsGUI(g, sh, p, us, u);
        }
        else if(e.getSource() == showButton){
            new ShowParticipantsGUI(g, sh, p, us, u);
            this.setVisible(false);
        }
        else if(e.getSource() == fineButton){
            this.setVisible(false);
            Integer key = us.size() + 1;
            us.put(key, u);
            new PriceGUI(g, sh, p, us);
        }
        else if(e.getSource() == indietroButton){
            new PriceGUI(g, sh, p, us);
            this.setVisible(false);
        }
    }
}
