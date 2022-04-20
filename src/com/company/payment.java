package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URL;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class payment extends JFrame{
    JButton button1, button2;
    payment()
    {
        setBounds(500, 180, 800, 600);
        getContentPane().setBackground(Color.WHITE);

        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.WHITE);
        panel1.setBounds(0, 0, 700, 450);
        panel1.setLayout(null);
        add(panel1);

        button1 = new JButton("PAY");
        button1.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        button1.setForeground(Color.BLACK);
        button1.setBounds(680, 20, 100, 50);
        button1.addActionListener(e1 -> GoToPayDetails(e1));
        panel1.add(button1);

        URL resource1 = this.getClass().getResource("templates/paytm.png");
        if (resource1 != null) {
            ImageIcon imageIcon1 = new ImageIcon(resource1);
            Image image2 = imageIcon1.getImage().getScaledInstance(350, 500, Image.SCALE_DEFAULT);
            ImageIcon imageIcon3 = new ImageIcon(image2);
            JLabel label1 = new JLabel(imageIcon3);
            label1.setBounds(250, 40, 350, 500);
            panel1.add(label1);
        } else {
            System.out.println("Image Not Found!");
        }
    }

    private void GoToPayDetails(ActionEvent e1) {
        if(e1.getSource() == button1)
        {
            this.setVisible(false);
            new paytm().setVisible(true);
        }
    }
}
