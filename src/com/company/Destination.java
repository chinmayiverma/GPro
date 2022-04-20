package com.company;
import javax.swing.*;
import java.awt.*;
import java.net.URL;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Destination extends JFrame {
    Destination()
    {
        setBounds(440, 170, 1000, 640);

        JTabbedPane tabbedPane = new JTabbedPane();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();
        JPanel panel6 = new JPanel();

        tabbedPane.addTab("Kashmir", null, panel1);
        tabbedPane.addTab("Maldives", null, panel2);
        tabbedPane.addTab("Dubai", null, panel3);
        tabbedPane.addTab("A&N", null, panel4);
        tabbedPane.addTab("Goa", null, panel5);
        tabbedPane.addTab("Udaipur", null, panel6);
        add(tabbedPane, BorderLayout.CENTER);

        URL resource1 = this.getClass().getResource("templates/Kashmir.png");
        if (resource1 != null) {
            ImageIcon imageIcon1 = new ImageIcon(resource1);
            Image image2 = imageIcon1.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);
            ImageIcon imageIcon3 = new ImageIcon(image2);
            JLabel label1 = new JLabel(imageIcon3);
            label1.setBounds(470, 190, 850, 570);
            panel1.add(label1);
        } else {
            System.out.println("Image Not Found!");
        }

        URL resource2 = this.getClass().getResource("templates/Maldives.png");
        if (resource2 != null) {
            ImageIcon imageIcon1 = new ImageIcon(resource2);
            Image image2 = imageIcon1.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);
            ImageIcon imageIcon3 = new ImageIcon(image2);
            JLabel label1 = new JLabel(imageIcon3);
            label1.setBounds(470, 190, 850, 570);
            panel2.add(label1);
        } else {
            System.out.println("Image Not Found!");
        }

        URL resource3 = this.getClass().getResource("templates/Dubai.png");
        if (resource3 != null) {
            ImageIcon imageIcon1 = new ImageIcon(resource3);
            Image image2 = imageIcon1.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);
            ImageIcon imageIcon3 = new ImageIcon(image2);
            JLabel label1 = new JLabel(imageIcon3);
            label1.setBounds(470, 190, 850, 570);
            panel3.add(label1);
        } else {
            System.out.println("Image Not Found!");
        }

        URL resource4 = this.getClass().getResource("templates/A&N.png");
        if (resource4 != null) {
            ImageIcon imageIcon1 = new ImageIcon(resource4);
            Image image2 = imageIcon1.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);
            ImageIcon imageIcon3 = new ImageIcon(image2);
            JLabel label1 = new JLabel(imageIcon3);
            label1.setBounds(470, 190, 850, 570);
            panel4.add(label1);
        } else {
            System.out.println("Image Not Found!");
        }

        URL resource5 = this.getClass().getResource("templates/Goa.png");
        if (resource5 != null) {
            ImageIcon imageIcon1 = new ImageIcon(resource5);
            Image image2 = imageIcon1.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);
            ImageIcon imageIcon3 = new ImageIcon(image2);
            JLabel label1 = new JLabel(imageIcon3);
            label1.setBounds(470, 190, 850, 570);
            panel5.add(label1);
        } else {
            System.out.println("Image Not Found!");
        }

        URL resource6 = this.getClass().getResource("templates/Udaipur.png");
        if (resource6 != null) {
            ImageIcon imageIcon1 = new ImageIcon(resource6);
            Image image2 = imageIcon1.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);
            ImageIcon imageIcon3 = new ImageIcon(image2);
            JLabel label1 = new JLabel(imageIcon3);
            label1.setBounds(470, 190, 850, 570);
            panel6.add(label1);
        } else {
            System.out.println("Image Not Found!");
        }

    }
}
