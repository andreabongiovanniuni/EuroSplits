import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class ShowParticipantsGUI extends JFrame implements ActionListener {

    Group g;
    Shop sh;
    ArrayList<Double> p;
    LinkedHashMap<Integer, LinkedList<User>> us;
    LinkedList<User> u ;
    JButton indietroButton;


    public ShowParticipantsGUI(Group g, Shop sh, ArrayList<Double> p, LinkedHashMap<Integer, LinkedList<User>> us,
                               LinkedList<User> u){
        this.g = g;
        this.sh = sh;
        this.p = p;
        this.us = us;
        this.u = u;

        JLabel label = new JLabel();
        label.setText("<html>" + u.toString().replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n",
                "<br/>")
                + "</html>");
        label.setFont(new Font(null, Font.BOLD, 15));
        label.setForeground(Color.cyan);

        JPanel panel = new JPanel();
        panel.add(label);
        panel.setOpaque(false);

        indietroButton = new JButton("Indietro");
        indietroButton.addActionListener(this);
        indietroButton.setFont(new Font(null, Font.BOLD, 15));


        this.setLayout(null);
        this.setVisible(true);
        this.setSize(1080, 720);
        this.setTitle("Mostra Gruppo");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.darkGray);
        ImageIcon icon = new ImageIcon("euro.png");
        this.setIconImage(icon.getImage());
        this.setResizable(false);
        this.add(indietroButton);
        this.add(panel);

        indietroButton.setBounds(5, 625, 150, 50);
        panel.setBounds(50, 50, 975, 500);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == indietroButton){
            new ParticipantsGUI(g, sh, p, us, u);
            this.setVisible(false);
        }

    }
}
