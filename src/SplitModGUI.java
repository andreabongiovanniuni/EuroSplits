import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SplitModGUI extends JFrame implements ActionListener {
    Shop sh1;
    Group g1;
    JButton equalSplitButton;
    JButton notEqualSplitButton;
    JButton specialSplitButton;
    public SplitModGUI(Shop sh, Group g){
        sh1 = sh;
        g1 = g;

        JLabel label = new JLabel();
        label.setText("Scegli la Modalità");
        label.setFont(new Font("boh", Font.BOLD, 100));
        label.setForeground(Color.cyan);
        label.setBounds(200, 1, 800, 200);

        JLabel label2 = new JLabel();
        label2.setText("per dividere la spesa");
        label2.setFont(new Font(null, Font.BOLD, 75));
        label2.setForeground(Color.cyan);
        label2.setBounds(300, 75, 900, 150);

        equalSplitButton = new JButton("EqualSplit");
        equalSplitButton.addActionListener(this);

        notEqualSplitButton = new JButton("NotEqualSplit");
        notEqualSplitButton.addActionListener(this);

        specialSplitButton = new JButton("SpecialSplit");
        specialSplitButton.addActionListener(this);


        this.setLayout(null);
        this.setVisible(true);
        this.setSize(1080, 720);
        this.setTitle("Scegli Modalità");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.darkGray);
        ImageIcon icon = new ImageIcon("euro.png");
        this.setIconImage(icon.getImage());
        this.setResizable(false);
        this.add(label);
        this.add(label2);
        this.add(equalSplitButton);
        this.add(notEqualSplitButton);
        this.add(specialSplitButton);

        equalSplitButton.setBounds(50, 350, 200, 75);
        notEqualSplitButton.setBounds(400, 350, 200, 75);
        specialSplitButton.setBounds(750, 350, 200, 75);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == equalSplitButton){
            System.out.println("spesa splittata");
            sh1.EqualSplit();
            new LaunchPageGUI(g1);
            this.setVisible(false);

            //new EqualSplitGUI(sh1);
        }
        else if(e.getSource() == notEqualSplitButton){
            new NotEqualSplitGUI();
        }
        else if( e.getSource() == specialSplitButton){
            new SpecialSplitGUI();
        }
    }
}
