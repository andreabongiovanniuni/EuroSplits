
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LaunchPageGUI extends JFrame implements ActionListener {
    Group g;
    JButton button = new JButton();
    JButton button2 = new JButton();
    JButton debtsButton= new JButton();
    JButton adduserbutton = new JButton();

    public LaunchPageGUI(Group g){
        this.g = g;
        ImageIcon icon = new ImageIcon("euro.png");


        button.setBounds(150, 425, 350, 100);
        button.addActionListener(this);
        button.setText("Dividi la Spesa");
        button.setFont(new Font(null, Font.BOLD, 25));
        button.setBorder(BorderFactory.createLineBorder(Color.blue, 2));
        
        button2.setBounds(550, 425, 350, 100);
        button2.addActionListener(this);
        button2.setText("Storia delle Spese");
        button2.setFont(new Font(null, Font.BOLD, 25));
        button2.setBorder(BorderFactory.createLineBorder(Color.blue, 2));

        adduserbutton.setBounds(150, 550, 350, 50);
        adduserbutton.addActionListener(this);
        adduserbutton.setText("Aggiungi al Gruppo");
        adduserbutton.setFont(new Font(null, Font.BOLD, 20));
        adduserbutton.setBorder(BorderFactory.createLineBorder(Color.blue, 2));

        debtsButton.setBounds(550, 550, 350, 50);
        debtsButton.addActionListener(this);
        debtsButton.setText("Mostra i Debiti");
        debtsButton.setFont(new Font(null, Font.BOLD, 20));
        debtsButton.setBorder(BorderFactory.createLineBorder(Color.blue, 2));




        JLabel label = new JLabel();
        label.setText("Dividi la tua Spesa!");
        label.setFont(new Font("boh", Font.BOLD, 50));
        label.setForeground(Color.cyan);
        label.setBounds(300, 160, 1000, 100);

        JLabel label2 = new JLabel();
        label2.setText("EuroSplit");
        label2.setFont(new Font("boh", Font.BOLD, 150));
        label2.setForeground(Color.orange);
        label2.setBounds(200, 3, 800, 200);

        ImageIcon cartImage = new ImageIcon("carrello.png");
        JLabel cartLabel = new JLabel("");
        cartLabel.setIcon(cartImage);
        cartLabel.setBounds(300, 320, 400, 100);

        ImageIcon shopsImage = new ImageIcon("storiaspese.png");
        JLabel shopsLabel = new JLabel();
        shopsLabel.setIcon(shopsImage);
        shopsLabel.setBounds(700, 320, 400, 100);

        ImageIcon userImage = new ImageIcon("adduser.png");
        JLabel userLabel = new JLabel();
        userLabel.setIcon(userImage);
        userLabel.setBounds(325, 590, 400, 100);

        ImageIcon bookImage = new ImageIcon("book.png");
        JLabel bookLabel = new JLabel();
        bookLabel.setIcon(bookImage);
        bookLabel.setBounds(700, 590, 400, 100);


        this.setLayout(null);
        this.setVisible(true);
        this.setSize(1080, 720);
        this.setTitle("EuroSplit");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.darkGray);
        this.setIconImage(icon.getImage());
        this.setResizable(false);
        this.add(button);
        this.add(button2);
        this.add(adduserbutton);
        this.add(label);
        this.add(label2);
        this.add(cartLabel);
        this.add(shopsLabel);
        this.add(userLabel);
        this.add(debtsButton);
        this.add(bookLabel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
           if(g.getGroup().isEmpty()){
               JOptionPane.showMessageDialog(null, "Aggiungi persone al gruppo prima di dividere una spesa!",
                       "Nessuna persona nel gruppo", JOptionPane.ERROR_MESSAGE);
           }
           else{
            new AddShopGUI(g);
            this.setVisible(false);
           }
        }
        else if(e.getSource() == button2){
            System.out.println("ciao");

        }
        else if(e.getSource() == adduserbutton){
            new AddUserGUI(g);
            this.setVisible(false);
        }
        else if(e.getSource() == debtsButton){
            new DebtsGUI(g);
            this.setVisible((false));
        }
    }
}
