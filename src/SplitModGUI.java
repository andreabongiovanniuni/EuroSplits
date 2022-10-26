import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class SplitModGUI extends JFrame implements ActionListener {
    Shop sh;
    Group g;
    JButton indietroButton;
    JButton equalSplitButton;
    JButton notEqualSplitButton;
    JButton specialSplitButton;
    public SplitModGUI(Group g, Shop sh){
        this.sh = sh;
        this.g = g;

        indietroButton = new JButton("Indietro");
        indietroButton.addActionListener(this);
        indietroButton.setFont(new Font(null, Font.BOLD, 15));

        JLabel label = new JLabel();
        label.setText("Scegli la Modalità");
        label.setFont(new Font(null, Font.BOLD, 100));
        label.setForeground(Color.cyan);
        label.setBounds(100, 0, 900, 150);

        JLabel label2 = new JLabel();
        label2.setText("per dividere la spesa");
        label2.setFont(new Font(null, Font.BOLD, 75));
        label2.setForeground(Color.cyan);
        label2.setBounds(155, 100, 900, 150);

        equalSplitButton = new JButton("EqualSplit");
        equalSplitButton.addActionListener(this);
        equalSplitButton.setFont(new Font(null, Font.BOLD, 20));

        notEqualSplitButton = new JButton("NotEqualSplit");
        notEqualSplitButton.addActionListener(this);
        notEqualSplitButton.setFont(new Font(null, Font.BOLD, 20));

        specialSplitButton = new JButton("SpecialSplit");
        specialSplitButton.addActionListener(this);
        specialSplitButton.setFont(new Font(null, Font.BOLD, 20));


        this.setLayout(null);
        this.setVisible(true);
        this.setSize(1080, 720);
        this.setTitle("Scegli Modalità");
        this.getContentPane().setBackground(Color.darkGray);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon("euro.png");
        this.setIconImage(icon.getImage());
        this.setResizable(false);
        this.add(label);
        this.add(label2);
        this.add(equalSplitButton);
        this.add(notEqualSplitButton);
        this.add(specialSplitButton);
        this.add(indietroButton);

        equalSplitButton.setBounds(75, 350, 200, 75);
        notEqualSplitButton.setBounds(425, 350, 200, 75);
        specialSplitButton.setBounds(775, 350, 200, 75);
        indietroButton.setBounds(5, 625, 150, 50);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == equalSplitButton){
            System.out.println("spesa splittata");
            sh.EqualSplit();
            new LaunchPageGUI(g);
            this.setVisible(false);
        }
        else if(e.getSource() == notEqualSplitButton){
            new NotEqualSplitGUI(g, sh, new HashMap<>());
            this.setVisible(false);
        }
        else if( e.getSource() == specialSplitButton){
            new PriceGUI(g, sh, new ArrayList<>(), new LinkedHashMap<>());
            this.setVisible(false);
        }
        else if(e.getSource() == indietroButton){
            new AddShopGUI(g);
            this.setVisible(false);
        }
    }
}
