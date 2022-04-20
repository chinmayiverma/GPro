package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.border.LineBorder;

public class BookPackage extends JFrame {
    Choice choice,choice1;
    JTextField tf,tf1,tf2;
    JButton button1, button2, button3;
    JLabel label8= new JLabel();
    private String totalPrice;
    JPanel panel1 = new JPanel();
    String username;

    BookPackage(String username) {
        this.username=username;
        setBounds(470, 190, 850, 640);
        getContentPane().setBackground(Color.WHITE);


        panel1.setBackground(new Color(24, 110, 125));
        panel1.setBounds(0, 0, 850, 640);
        panel1.setLayout(null);
        add(panel1);

        JLabel label1 = new JLabel("B O O K  P A C K A G E");
        label1.setBounds(275, 10, 500, 30);
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        panel1.add(label1);

        JLabel label3 = new JLabel("Select Package:");
        label3.setBounds(450, 100, 150, 20);
        label3.setForeground(Color.WHITE);
        label3.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
        panel1.add(label3);

        choice = new Choice();
        choice.add("Choose your package.");
        choice.add("Platinium");
        choice.add("Gold");
        choice.add("Silver");
        choice.setBounds(600, 100, 200, 30);
        panel1.add(choice);

        JLabel label4 = new JLabel("Total Guests:");
        label4.setBounds(20, 100, 170, 20);
        label4.setForeground(Color.WHITE);
        label4.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
        panel1.add(label4);

        tf = new JTextField();
        tf.setBounds(200, 100, 200, 20);
        tf.setBorder(BorderFactory.createEmptyBorder());
        panel1.add(tf);

        JLabel label5 = new JLabel("Check-In :");
        label5.setBounds(450, 150, 150, 20);
        label5.setForeground(Color.WHITE);
        label5.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
        panel1.add(label5);

        tf1 = new JTextField();
        tf1.setBounds(600, 150, 200, 20);
        tf1.setBorder(BorderFactory.createEmptyBorder());
        panel1.add(tf1);

        JLabel label6 = new JLabel("Check-out:");
        label6.setBounds(450, 200, 150, 20);
        label6.setForeground(Color.WHITE);
        label6.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
        panel1.add(label6);

        tf2 = new JTextField();
        tf2.setBounds(600, 200, 200, 20);
        tf2.setBorder(BorderFactory.createEmptyBorder());
        panel1.add(tf2);

        JLabel label7 = new JLabel("Destination:");
        label7.setBounds(20, 150, 150, 20);
        label7.setForeground(Color.WHITE);
        label7.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
        panel1.add(label7);

        choice1 = new Choice();
        choice1.add("Choose your Destination.");
        choice1.add("Kashmir");
        choice1.add("Maldives");
        choice1.add("Dubai");
        choice1.add("Goa");
        choice1.add("Andaman and Nicobar");
        choice1.add("Udaipur");
        choice1.setBounds(200, 150, 200, 30);
        panel1.add(choice1);

        button1 = new JButton("Check Price");
        button1.setForeground(new Color(46, 43, 70));
        button1.setBounds(120, 320, 150, 25);
        button1.setFont(new Font("SAN_SERIF", Font.BOLD, 12));
        button1.setBorder(new LineBorder(new Color(46, 43, 70)));
        button1.addActionListener(e -> CalculateTotalPrice(e));
        panel1.add(button1);

        button2 = new JButton("Book Package");
        button2.setForeground(new Color(46, 43, 70));
        button2.setBounds(340, 320, 150, 25);
        button2.setFont(new Font("SAN_SERIF", Font.BOLD, 12));
        button2.setBorder(new LineBorder(new Color(46, 43, 70)));
        button2.addActionListener(e -> ClickBookPackage(e));
        button2.setEnabled(false);
        panel1.add(button2);

        button3 = new JButton("Back");
        button3.setForeground(new Color(46, 43, 70));
        button3.setBounds(560, 320, 150, 25);
        button3.setFont(new Font("SAN_SERIF", Font.BOLD, 12));
        button3.setBorder(new LineBorder(new Color(46, 43, 70)));
        button3.addActionListener(e -> GoToDashboard(e));
        panel1.add(button3);

        URL resource = this.getClass().getResource("templates/Bookpackages.png");
        if (resource != null) {
            ImageIcon imageIcon1 = new ImageIcon(resource);
            Image image2 = imageIcon1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
            ImageIcon imageIcon3 = new ImageIcon(image2);
            JLabel label10 = new JLabel(imageIcon3);
            label10.setBounds(135, 280, 600, 400);
            panel1.add(label10);
        } else {
            System.out.println("Image Not Found!");
        }
    }
        private void CalculateTotalPrice(ActionEvent e)
        {

            if(choice.getSelectedItem().equalsIgnoreCase("Choose your package.")) {
                JOptionPane.showMessageDialog(null, "Please Select Package");
            } else {
                try {
                    String query = "select price from package where package_name=? and destination=?";
                    Connection connection = Connect.getConnection();
                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                    preparedStatement.setString(1, choice.getSelectedItem());
                    preparedStatement.setString(2, choice1.getSelectedItem());
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while(resultSet.next()) {
                        totalPrice = resultSet.getString("price");

                        label8.setText("Total Price: " +totalPrice + " x " +tf.getText() +" = Rs." +Integer.parseInt(totalPrice)*Integer.parseInt(tf.getText()) );
                        label8.setBounds(80, 200, 600, 20);
                        label8.setForeground(Color.WHITE);
                        label8.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
                        panel1.add(label8);
                        getContentPane().remove(panel1);
                        getContentPane().add(panel1);
                        button2.setEnabled(true);

                    }
                    connection.close();

                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }

        private void ClickBookPackage(ActionEvent e)
        {
            if (e.getSource() == button2) {
                if(choice.getSelectedItem() == "Choose your package.")
                {
                    JOptionPane.showMessageDialog(null,"Choose your Package.");
                }
                else {

                    String query = "insert into booking_package(username,guests,checkin,checkout,destination,package_name,price) values(?,?,?,?,?,?,?) ";
                    Connection connection = null;
                    try {
                        connection = Connect.getConnection();
                        PreparedStatement preparedStatement = connection.prepareStatement(query);
                        preparedStatement.setString(1,username);
                        preparedStatement.setString(2,tf.getText());
                        preparedStatement.setString(3,tf1.getText());
                        preparedStatement.setString(4,tf2.getText());
                        preparedStatement.setString(5,choice1.getSelectedItem());
                        preparedStatement.setString(6,choice.getSelectedItem());
                        preparedStatement.setString(7,totalPrice);
                        preparedStatement.execute();
                        JOptionPane.showMessageDialog(null, "Package Booked successfully.");
                        dispose();

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }

        private void GoToDashboard (ActionEvent e)
        {
            if (e.getSource() == button3) {
                this.setVisible(false);
                new Dashboard(null).setVisible(true);
            }
        }
    //
}
