package com.company;
import javax.swing.*;
import java.awt.*;
import java.net.URL;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class ViewPackages extends JFrame {
    ViewPackages() {
        setBounds(470, 190, 850, 640);

        JTabbedPane tabbedPane = new JTabbedPane();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();

        tabbedPane.addTab("Package 1",null,panel1);
        tabbedPane.addTab("Package 2",null,panel2);
        tabbedPane.addTab("Package 3",null,panel3);

        add(tabbedPane, BorderLayout.CENTER);

        URL resource1 = this.getClass().getResource("templates/Platinum.png");
        if (resource1 != null) {
            ImageIcon imageIcon1 = new ImageIcon(resource1);
            Image image2 = imageIcon1.getImage().getScaledInstance(850, 570, Image.SCALE_DEFAULT);
            ImageIcon imageIcon3 = new ImageIcon(image2);
            JLabel label1 = new JLabel(imageIcon3);
            label1.setBounds(470, 190, 850, 570);
            panel1.add(label1);
        } else {
            System.out.println("Image Not Found!");
        }

        URL resource2 = this.getClass().getResource("templates/Gold.png");
        if (resource2 != null) {
            ImageIcon imageIcon1 = new ImageIcon(resource2);
            Image image2 = imageIcon1.getImage().getScaledInstance(850, 570, Image.SCALE_DEFAULT);
            ImageIcon imageIcon3 = new ImageIcon(image2);
            JLabel label2 = new JLabel(imageIcon3);
            label2.setBounds(470, 190, 850, 570);
            panel2.add(label2);
        } else {
            System.out.println("Image Not Found!");
        }

        URL resource3 = this.getClass().getResource("templates/Silver.png");
        if (resource3 != null) {
            ImageIcon imageIcon1 = new ImageIcon(resource3);
            Image image2 = imageIcon1.getImage().getScaledInstance(840, 570, Image.SCALE_DEFAULT);
            ImageIcon imageIcon3 = new ImageIcon(image2);
            JLabel label3 = new JLabel(imageIcon3);
            label3.setBounds(470, 190, 840, 570);
            panel3.add(label3);
        } else {
            System.out.println("Image Not Found!");
        }
    }

//    public static void main(String[] args) {
//        new ViewPackages().setVisible(true);
//    }
}
