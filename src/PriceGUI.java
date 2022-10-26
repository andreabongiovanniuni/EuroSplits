import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class PriceGUI extends JFrame implements ActionListener {

    Group g;
    Shop sh;
    ArrayList<Double> p;
    LinkedHashMap<Integer, LinkedList<User>> us;
    JTextField priceText;
    JButton indietroButton;
    JButton aggiungiButton;
    JButton fineButton;

    public PriceGUI(Group g, Shop sh, ArrayList<Double> p, LinkedHashMap<Integer, LinkedList<User>> us){
        this.g = g;
        this.sh = sh;
        this.p = p;
        this.us = us;

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

        priceText = new JTextField("Prezzo");
        priceText.setPreferredSize(new Dimension(275, 50));
        priceText.setFont(new Font(null, Font.PLAIN, 18));

        JLabel label = new JLabel();
        label.setText("Inserisci prezzo prodotto Speciale");
        label.setForeground(Color.cyan);
        label.setFont(new Font(null, Font.BOLD, 50));

        JPanel panel = new JPanel();
        panel.setBackground(Color.cyan);
        panel.setBorder(BorderFactory.createLineBorder(Color.blue, 3));
        panel.add(priceText);

        this.setLayout(null);
        this.setVisible(true);
        this.setSize(1080, 720);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Prezzo Prodotto");
        this.getContentPane().setBackground(Color.darkGray);
        ImageIcon icon = new ImageIcon("euro.png");
        this.setIconImage(icon.getImage());
        this.setResizable(false);
        this.add(panel);
        this.add(indietroButton);
        this.add(aggiungiButton);
        this.add(label);
        this.add(fineButton);

        panel.setBounds(400, 275, 300, 70);
        label.setBounds(100, 5, 900, 150);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == aggiungiButton){
            p.add(Double.parseDouble(priceText.getText()));
            new ParticipantsGUI(g, sh, p, us, new LinkedList<>());
            this.setVisible(false);
        }
        else if (e.getSource() == indietroButton){
            new SplitModGUI(g, sh);
            this.setVisible(false);
        }
        else if(e.getSource() == fineButton){
            sh.SpecialSplit(p, us);
            new LaunchPageGUI(g);
            this.setVisible(false);
        }
    }
}
