import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddUserGUI extends JFrame implements ActionListener {

    Group g1;
    JButton create;
    JButton indietro;
    JTextField usernametext;
    public AddUserGUI(Group g){
        g1 = g;

        JLabel label = new JLabel();
        label.setText("Aggiungi un nuovo utente al Gruppo");
        label.setForeground(Color.cyan);
        label.setFont(new Font(null, Font.BOLD, 50));

        JLabel label1 = new JLabel();
        ImageIcon image = new ImageIcon("user.png");
        label1.setIcon(image);

        JLabel label2 = new JLabel();
        ImageIcon image2 = new ImageIcon("user1.png");
        label2.setIcon(image2);

        JLabel label3 = new JLabel();
        label3.setIcon(image2);

        JLabel label4 = new JLabel();
        label4.setIcon(image2);

        JLabel label5 = new JLabel();
        label5.setIcon(image2);

        JLabel label6 = new JLabel();
        label6.setIcon(image2);


        JPanel panel = new JPanel();
        panel.setBackground(Color.cyan);
        panel.setBorder(BorderFactory.createLineBorder(Color.blue, 3));



        create = new JButton("AGGIUNGI");
        create.addActionListener(this);
        create.setFont(new Font(null, Font.BOLD, 15));

        indietro = new JButton("indietro");
        indietro.addActionListener(this);


        usernametext = new JTextField("Username");
        usernametext.setPreferredSize(new Dimension(275, 50));
        usernametext.setFont(new Font(null, Font.PLAIN, 18));

        panel.add(usernametext);

        this.setLayout(null);
        this.setVisible(true);
        this.setSize(1080, 720);
        this.setTitle("Aggiungi Utente");
        this.getContentPane().setBackground(Color.darkGray);
        ImageIcon icon = new ImageIcon("euro.png");
        this.setIconImage(icon.getImage());
        this.setResizable(false);
        this.add(create);
        this.add(panel);
        this.add(label);
        this.add(label1);
        this.add(label2);
        this.add(label3);
        this.add(label4);
        this.add(label5);
        this.add(label6);
        this.add(indietro);

        indietro.setBounds(150, 575, 200, 50);
        create.setBounds(650, 250, 200, 50);
        panel.setBounds(275, 250, 300, 70);
        label.setBounds(100, 5, 900, 150);
        label1.setBounds(350, 475, 50, 50);
        label2.setBounds(500, 375, 50, 50);
        label3.setBounds(700, 375, 50, 50);
        label4.setBounds(600, 475, 50, 50);
        label5.setBounds(500, 575, 50, 50);
        label6.setBounds(700, 575, 50, 50);


    }




    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == create) {
            g1.addUser(new User(usernametext.getText()));
            System.out.println("L'utente " + usernametext.getText() + " è stato aggiunto al gruppo!");
        }
        else if(e.getSource() == indietro){
            new LaunchPageGUI(g1);
            this.setVisible(false);
        }
    }
}
