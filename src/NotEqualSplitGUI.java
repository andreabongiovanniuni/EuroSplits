import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class NotEqualSplitGUI extends JFrame implements ActionListener {

    Group g;
    Shop sh;
    HashMap<User, Double> m;
    JButton assegnaButton;
    JButton indietroButton;
    JButton endButton;
    JTextField usernameText;
    JTextField priceText;

    public NotEqualSplitGUI(Group g, Shop sh, HashMap<User, Double> m){

        this.g = g;
        this.sh = sh;
        this.m = m;

        usernameText = new JTextField("Username");
        usernameText.setFont(new Font(null, Font.PLAIN, 20));

        priceText = new JTextField("Cifra");
        priceText.setFont(new Font(null, Font.PLAIN, 20));

        JPanel panel = new JPanel();
        panel.add(usernameText);
        panel.add(priceText);
        panel.setBackground(Color.cyan);
        panel.setBorder(BorderFactory.createLineBorder(Color.blue, 3));


        JLabel label = new JLabel("Assegna la cifra da Pagare");
        label.setFont(new Font(null, Font.BOLD, 75));
        label.setForeground(Color.cyan);

        endButton = new JButton("Fine");
        endButton.addActionListener(this);
        endButton.setFont(new Font(null, Font.BOLD, 20));

        indietroButton = new JButton("Indietro");
        indietroButton.addActionListener(this);
        indietroButton.setFont(new Font(null, Font.BOLD, 15));

        assegnaButton = new JButton("Assegna");
        assegnaButton.addActionListener(this);
        assegnaButton.setFont(new Font(null, Font.BOLD, 20));

        this.setLayout(null);
        this.setVisible(true);
        this.setSize(1080, 720);
        this.setTitle("Scegli Modalità");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.darkGray);
        ImageIcon icon = new ImageIcon("euro.png");
        this.setIconImage(icon.getImage());
        this.setResizable(false);
        this.add(assegnaButton);
        this.add(label);
        this.add(indietroButton);
        this.add(panel);
        this.add(endButton);

        assegnaButton.setBounds(700, 350, 200, 50);
        label.setBounds(75, 0, 1000, 150);
        indietroButton.setBounds(5, 625, 150, 50);
        panel.setBounds(250, 350, 400, 100);
        endButton.setBounds(800, 625, 150, 50);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == assegnaButton){
            if(g.IsInGroup(usernameText.getText())){
                m.put(g.getUser(usernameText.getText()), Double.parseDouble(priceText.getText()));
                new NotEqualSplitGUI(g, sh, m);

            }
           else{
               JOptionPane.showMessageDialog(null, "Non è presente nessun " + usernameText.getText() +
                        " nel gruppo", "Assente", JOptionPane.WARNING_MESSAGE);
            }
        }
        else if(e.getSource() == indietroButton){
            new SplitModGUI(g, sh);
            this.setVisible(false);
        }
        else if(e.getSource() == endButton){
            sh.NotEqualSplit(m);
            System.out.println("La Spesa è stata splittata!");
            new LaunchPageGUI(g);
            this.setVisible(false);
        }

    }
}
