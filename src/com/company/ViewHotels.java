package com.company;
import javax.swing.*;
import java.awt.*;
import java.net.URL;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class ViewHotels extends JFrame {
        ViewHotels() {
            setBounds(380, 150, 980, 660);

            JTabbedPane tabbedPane = new JTabbedPane();
            JPanel panel1 = new JPanel();
            JPanel panel2 = new JPanel();
            JPanel panel3 = new JPanel();

            tabbedPane.addTab("7 STAR", null, panel1);
            tabbedPane.addTab("5 STAR", null, panel2);
            tabbedPane.addTab("3 STAR", null, panel3);
            add(tabbedPane, BorderLayout.CENTER);

            URL resource1 = this.getClass().getResource("templates/7starhotel.png");
            if (resource1 != null) {
                ImageIcon imageIcon1 = new ImageIcon(resource1);
                Image image2 = imageIcon1.getImage().getScaledInstance(1000, 570, Image.SCALE_DEFAULT);
                ImageIcon imageIcon3 = new ImageIcon(image2);
                JLabel label1 = new JLabel(imageIcon3);
                label1.setBounds(0, 0, 1000, 660);
                panel1.add(label1);
            } else {
                System.out.println("Image Not Found!");
            }

            URL resource2 = this.getClass().getResource("templates/5starhotel.png");
            if (resource2 != null) {
                ImageIcon imageIcon1 = new ImageIcon(resource2);
                Image image2 = imageIcon1.getImage().getScaledInstance(1000, 570, Image.SCALE_DEFAULT);
                ImageIcon imageIcon3 = new ImageIcon(image2);
                JLabel label1 = new JLabel(imageIcon3);
                label1.setBounds(0, 0, 1000, 660);
                panel2.add(label1);
            } else {
                System.out.println("Image Not Found!");
            }

            URL resource3 = this.getClass().getResource("templates/3starhotel.png");
            if (resource3 != null) {
                ImageIcon imageIcon1 = new ImageIcon(resource3);
                Image image2 = imageIcon1.getImage().getScaledInstance(1000, 570, Image.SCALE_DEFAULT);
                ImageIcon imageIcon3 = new ImageIcon(image2);
                JLabel label1 = new JLabel(imageIcon3);
                label1.setBounds(0, 0, 1000, 660);
                panel3.add(label1);
            } else {
                System.out.println("Image Not Found!");
            }
    }

//    public static void main(String[] args) {
//        new ViewHotels().setVisible(true);
//    }
}