package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

public class Page1 extends JFrame{
    private JPanel p1;
    private JButton button1;

    public Page1() {


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("helloidiots");
            }
        });
    }
}
