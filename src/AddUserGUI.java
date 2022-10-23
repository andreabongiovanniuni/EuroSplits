import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddUserGUI extends JFrame implements ActionListener {
    Group g;
    JButton create;
    JButton removeButton;
    JButton showButton;
    JButton indietro;
    JTextField usernametext;

    public AddUserGUI(Group g) {
        this.g = g;
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

        showButton = new JButton("Partecipanti Gruppo");
        showButton.addActionListener(this);
        showButton.setFont(new Font(null, Font.BOLD, 15));

        removeButton = new JButton("Rimuovi");
        removeButton.addActionListener(this);
        removeButton.setFont(new Font(null, Font.BOLD, 15));

        create = new JButton("Aggiungi");
        create.addActionListener(this);
        create.setFont(new Font(null, Font.BOLD, 15));

        indietro = new JButton("Indietro");
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
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        this.add(removeButton);
        this.add(showButton);
        indietro.setBounds(5, 625, 150, 50);
        showButton.setBounds(100, 275, 200, 70);
        removeButton.setBounds(750, 250, 200, 50);
        create.setBounds(750, 310, 200, 50);
        panel.setBounds(400, 275, 300, 70);
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
        if (e.getSource() == create) {
            if (g.IsInGroup(usernametext.getText())) {
                JOptionPane.showMessageDialog(null, "L'utente " + usernametext.getText() + " è già presente nel " + "gruppo", "Aggiunta Utente", JOptionPane.ERROR_MESSAGE);
            } else {
                g.addUser(new User(usernametext.getText()));
                System.out.println("L'utente " + usernametext.getText() + " è stato aggiunto al gruppo!");
                this.setVisible(false);
                new AddUserGUI(g);
            }
        } else if (e.getSource() == indietro) {
            new LaunchPageGUI(g);
            this.setVisible(false);
        } else if (e.getSource() == showButton) {
            new ShowGUI(g);
            this.setVisible(false);
        } else if (e.getSource() == removeButton) {
            if (!g.IsInGroup(usernametext.getText())) {
                JOptionPane.showMessageDialog(null, "L'utente " + usernametext.getText() + " non è presente nel " +
                        "gruppo", "Rimozione utente", JOptionPane.ERROR_MESSAGE);
            } else {
                int answer = JOptionPane.showConfirmDialog(null,
                        "Sei sicuro di voler cancellare " + usernametext.getText() + " dal " + "gruppo?", "Rimozione " +
                                "Utente", JOptionPane.YES_NO_OPTION);
                if (answer == 0) {
                    g.removeUser(usernametext.getText());
                    System.out.println("L'utente " + usernametext.getText() + " è stato rimosso dal gruppo!");
                    this.setVisible(false);
                    new AddUserGUI(g);
                }
            }
        }
    }
}
