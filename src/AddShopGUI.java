import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddShopGUI extends JFrame implements ActionListener {
    Group g1;
    Shop sh;
    JTextField totaltext;
    JTextField ntext;
    JTextField nametext;
    JTextField datatext;
    JButton create;
    public AddShopGUI(Group g){

        g1 = g;

        JPanel panel = new JPanel();
        panel.setBackground(Color.cyan);
        panel.setBorder(BorderFactory.createLineBorder(Color.blue, 3));

        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.cyan);
        panel1.setBorder(BorderFactory.createLineBorder(Color.blue, 3));

        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.cyan);
        panel2.setBorder(BorderFactory.createLineBorder(Color.blue, 3));

        JPanel panel3 = new JPanel();
        panel3.setBackground(Color.cyan);
        panel3.setBorder(BorderFactory.createLineBorder(Color.blue, 3));

        create = new JButton("CREATE");
        create.addActionListener(this);
        create.setFont(new Font(null, Font.BOLD, 25));
        totaltext = new JTextField("Totale");
        totaltext.setPreferredSize(new Dimension(180, 50));
        totaltext.setFont(new Font(null, Font.PLAIN, 20));
        ntext = new JTextField("Numero partecipanti");
        ntext.setPreferredSize(new Dimension(180, 50));
        ntext.setFont(new Font(null, Font.PLAIN, 18));
        nametext = new JTextField("Nome spesa");
        nametext.setPreferredSize(new Dimension(180, 50));
        nametext.setFont(new Font(null, Font.PLAIN, 20));
        datatext = new JTextField("gg/mm/aaaa");
        datatext.setPreferredSize(new Dimension(180, 50));
        datatext.setFont(new Font(null, Font.PLAIN, 20));




        panel.add(nametext);
        panel1.add(totaltext);
        panel2.add(ntext);
        panel3.add(datatext);

        JLabel label2 = new JLabel();
        label2.setText("Aggiungi Spesa");
        label2.setFont(new Font(null, Font.BOLD, 100));
        label2.setForeground(Color.cyan);
        label2.setBounds(150, 3, 900, 150);

        JLabel label3 = new JLabel();
        label3.setText("Inserisci i dati");
        label3.setFont(new Font(null, Font.BOLD, 50));
        label3.setForeground(Color.cyan);
        label3.setBounds(350, 150, 900, 150);

        this.setLayout(null);
        this.setVisible(true);
        this.setSize(1080, 720);
        this.setTitle("Aggiungi Spesa");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.darkGray);
        ImageIcon icon = new ImageIcon("euro.png");
        this.setIconImage(icon.getImage());
        this.setResizable(false);
        this.add(panel);
        this.add(panel1);
        this.add(panel2);
        this.add(panel3);
        this.add(create);
        this.add(label2);
        this.add(label3);

        create.setBounds(450, 550, 150, 50);
        panel.setBounds(50, 300, 200, 200);
        panel1.setBounds(300, 300, 200, 200);
        panel2.setBounds(550, 300, 200, 200);
        panel3.setBounds(800, 300, 200, 200);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == create){

            sh = new Shop(Double.parseDouble(totaltext.getText()), new User(nametext.getText()), g1.getGroup());

            System.out.println("Aggiunta la spesa di importo " + totaltext.getText() + " divisa in " + ntext.getText() +
                    ", " +
                    "per gli amici " + nametext.getText() + ", effettuata il " + datatext.getText() );
            create.setEnabled(false);
            totaltext.setEnabled(false);
            ntext.setEnabled(false);
            nametext.setEnabled(false);
            datatext.setEnabled(false);
            new SplitModGUI(sh, g1);
            this.setVisible(false);

        }
    }
}
