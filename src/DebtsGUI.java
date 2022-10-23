import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DebtsGUI extends JFrame implements ActionListener {

    JButton indietro;
    Group g;

   public DebtsGUI(Group g){
       this.g = g;

       indietro = new JButton("Indietro");
       indietro.addActionListener(this);
       indietro.setFont(new Font(null, Font.BOLD, 15));

       JLabel label = new JLabel();
       label.setText("<html>" + g.toString().replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") +
               "</html>");
       label.setFont(new Font(null, Font.PLAIN, 25));
       label.setForeground(Color.cyan);


       JPanel panel = new JPanel();
       panel.add(label);
       panel.setBackground(Color.darkGray);

       this.setLayout(null);
       this.setVisible(true);
       this.setSize(1080, 720);
       this.setTitle("Debiti");
       this.getContentPane().setBackground(Color.darkGray);
       ImageIcon icon = new ImageIcon("euro.png");
       this.setIconImage(icon.getImage());
       this.setResizable(false);
       this.add(indietro);
       this.add(panel);

       indietro.setBounds(5, 625, 150, 50);
       panel.setBounds(50, 50, 975, 500);

   }


    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==indietro){
           new LaunchPageGUI(g);
           this.setVisible(false);
       }
    }
}
