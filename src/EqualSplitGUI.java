import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EqualSplitGUI extends JFrame implements ActionListener {

    public EqualSplitGUI(Shop sh){




        JButton split = new JButton("split");


        this.setLayout(null);
        this.setVisible(true);
        this.setSize(1080, 720);
        this.setTitle("EqualSplit");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.darkGray);
        ImageIcon icon = new ImageIcon("euro.png");
        this.setIconImage(icon.getImage());
        this.setResizable(false);
        this.add(split);

        split.setBounds(400, 400, 200, 50);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
