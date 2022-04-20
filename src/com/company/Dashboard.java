package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URL;


public class Dashboard extends JFrame {
    JButton button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11;
    String username;

    Dashboard(String username) {
        this.username=username;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);

        URL resource = this.getClass().getResource("templates/Dashboard.png");
        if (resource != null) {

            JPanel panel1 = new JPanel();
            panel1.setLayout(null);
            panel1.setBackground(new Color(46, 43, 70));
            panel1.setBounds(0, 0, 1920, 40);
            add(panel1);

            JPanel panel2 = new JPanel();
            panel2.setLayout(null);
            panel2.setBackground(new Color(46, 43, 70));
            panel2.setBounds(0, 0, 300, 1080);
            add(panel2);

            ImageIcon imageIcon1 = new ImageIcon(resource);
            Image image2 = imageIcon1.getImage().getScaledInstance(1760, 1000, Image.SCALE_DEFAULT);
            ImageIcon imageIcon3 = new ImageIcon(image2);

            JLabel label1 = new JLabel(imageIcon3);
            label1.setBounds(0, 0, 1760, 1000);
            add(label1);

            setBounds(0, 0, 1920, 1080);
            getContentPane().setBackground(Color.WHITE);
            setLayout(null);

            JLabel label2 = new JLabel("D A S H B O A R D");
            label2.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
            label2.setForeground(Color.WHITE);
            label2.setBounds(40, 10, 300, 30);
            panel1.add(label2);

            button1 = new JButton("Profile");
            button1.setBackground(new Color(46, 43, 70));
            button1.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
            button1.setForeground(Color.WHITE);
            button1.setBounds(0, 60, 300, 50);
            button1.addActionListener(e1 -> GoToUpdateDetails(e1));
            panel2.add(button1);

            button2 = new JButton("View Profile");
            button2.setBackground(new Color(46, 43, 70));
            button2.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
            button2.setForeground(Color.WHITE);
            button2.setBounds(0, 120, 300, 50);
            button2.addActionListener(e2 -> GoToViewDetails(e2));
            panel2.add(button2);

            button3 = new JButton("Basic Packages");
            button3.setBackground(new Color(46, 43, 70));
            button3.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
            button3.setForeground(Color.WHITE);
            button3.setBounds(0, 180, 300, 50);
            button3.addActionListener(e3 -> GoToSelectPackage(e3));
            panel2.add(button3);

            button6 = new JButton("Destination Packages");
            button6.setBackground(new Color(46, 43, 70));
            button6.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
            button6.setForeground(Color.WHITE);
            button6.setBounds(0, 240, 300, 50);
            button6.addActionListener(e6 -> GoToDestinationPackages(e6));
            panel2.add(button6);

            button4 = new JButton("Book Package");
            button4.setBackground(new Color(46, 43, 70));
            button4.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
            button4.setForeground(Color.WHITE);
            button4.setBounds(0, 300, 300, 50);
            button4.addActionListener(e4 -> GoToBookPackage(e4));
            panel2.add(button4);

            button5 = new JButton("View Hotels");
            button5.setBackground(new Color(46, 43, 70));
            button5.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
            button5.setForeground(Color.WHITE);
            button5.setBounds(0, 360, 300, 50);
            button5.addActionListener(e5 -> GoToViewHotels(e5));
            panel2.add(button5);

            button7 = new JButton("Book Hotel");
            button7.setBackground(new Color(46, 43, 70));
            button7.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
            button7.setForeground(Color.WHITE);
            button7.setBounds(0, 420, 300, 50);
            button7.addActionListener(e7 -> GoToBookHotel(e7));
            panel2.add(button7);

            button8 = new JButton("View Booking Details");
            button8.setBackground(new Color(46, 43, 70));
            button8.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
            button8.setForeground(Color.WHITE);
            button8.setBounds(0, 480, 300, 50);
            button8.addActionListener(e8 -> GoToViewBookHotel(e8));
            panel2.add(button8);

            button9 = new JButton("Destinations Pictures");
            button9.setBackground(new Color(46, 43, 70));
            button9.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
            button9.setForeground(Color.WHITE);
            button9.setBounds(0, 540, 300, 50);
            button9.addActionListener(e9 -> GoToDestination(e9));
            panel2.add(button9);

            button10 = new JButton("Payment");
            button10.setBackground(new Color(46, 43, 70));
            button10.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
            button10.setForeground(Color.WHITE);
            button10.setBounds(0, 600, 300, 50);
            button10.addActionListener(e10 -> GoToPayment(e10));
            panel2.add(button10);

            button11 = new JButton("Sign Out");
            button11.setBackground(new Color(46, 43, 70));
            button11.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
            button11.setForeground(Color.WHITE);
            button11.setBounds(0, 660, 300, 50);
            button11.addActionListener(e11 -> GoToSignInPage(e11));
            panel2.add(button11);

        }
    }

    private void GoToUpdateDetails(ActionEvent e1) {
        if (e1.getSource() == button1) {
            new UpdateDetails().setVisible(true);
        }
    }

    private void GoToViewDetails(ActionEvent e2) {
        if (e2.getSource() == button2) {
            new ViewDetails(username).setVisible(true);
        }
    }

    private void GoToSelectPackage(ActionEvent e3) {
        if (e3.getSource() == button3) {
            new ViewPackages().setVisible(true);
        }
    }

    private void GoToBookPackage(ActionEvent e4) {
        if (e4.getSource() == button4) {
            new BookPackage(username).setVisible(true);
        }
    }

    private void GoToDestinationPackages(ActionEvent e6)
    {
        if(e6.getSource() == button6)
        {
            new Destination_Packages().setVisible(true);
        }
    }

    private void GoToViewHotels(ActionEvent e5) {
        if (e5.getSource() == button5) {
            new ViewHotels().setVisible(true);
        }
    }

    private void GoToBookHotel(ActionEvent e7) {
        if(e7.getSource() == button7)
        {
            new BookHotel(username).setVisible(true);
        }
    }

    private void GoToViewBookHotel(ActionEvent e8)
    {
        if(e8.getSource() == button8)
        {
            new ViewBookingDetails(username).setVisible(true);
        }
    }

    private void GoToDestination(ActionEvent e9)
    {
        if(e9.getSource() == button9)
        {
            new Destination().setVisible(true);
        }
    }

    private void GoToPayment(ActionEvent e10) {
        if(e10.getSource() == button10)
        {
            new payment().setVisible(true);
        }
    }

    private void GoToSignInPage(ActionEvent e11)
    {
        if(e11.getSource() == button11)
        {
            this.setVisible(false);
            new Login().setVisible(true);
        }
    }

//    public static void main(String[] args) {
//        new Dashboard(null).setVisible(true);
//    }
}