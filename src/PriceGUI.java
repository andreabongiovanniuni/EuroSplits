import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class PriceGUI extends JFrame implements ActionListener {

    Group g1;
    Shop sh1;
    JTextField priceText;
    JButton indietroButton;
    JButton aggiungiButton;
    ArrayList<Double> p1;

    public PriceGUI(Group g, Shop sh, ArrayList<Double> p){
        g1 = g;
        sh1 = sh;
        p1 = p;

        indietroButton = new JButton("Indietro");
        indietroButton.setFont(new Font(null, Font.PLAIN, 20));
        indietroButton.setBounds(5, 625, 150, 50);

        aggiungiButton = new JButton("Aggiungi");
        aggiungiButton.setFont(new Font(null, Font.PLAIN, 20));
        aggiungiButton.setBounds(750, 275, 200, 50);

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
        this.setTitle("Scegli Modalità");
        this.getContentPane().setBackground(Color.darkGray);
        ImageIcon icon = new ImageIcon("euro.png");
        this.setIconImage(icon.getImage());
        this.setResizable(false);
        this.add(panel);
        this.add(indietroButton);
        this.add(aggiungiButton);
        this.add(label);

        panel.setBounds(400, 275, 300, 70);
        label.setBounds(100, 5, 900, 150);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == aggiungiButton){
            p1.add(Double.parseDouble(priceText.getText()));
            new ParticipantsGUI(g1, sh1, p1, new LinkedHashMap<>());
            this.setVisible(false);
        }
        else if (e.getSource() == indietroButton){
            new SplitModGUI(g1, sh1);
            this.setVisible(false);
        }
    }
}
