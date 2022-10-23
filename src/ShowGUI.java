import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowGUI extends JFrame implements ActionListener {

    Group g;
    JButton indietroButton;


    public ShowGUI(Group g){

        this.g = g;

        JLabel label = new JLabel();
        label.setText("<html>" + g.toStringOnlyName().replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>")
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
            new AddUserGUI(g);
            this.setVisible(false);
        }

    }
}
