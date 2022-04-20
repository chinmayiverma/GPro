package com.company;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class ViewDetails extends JFrame {
    String id_proof;
    String id_number;
    String country;
    String address;
    String contact_number;
    String email;
    String name;
    String gender;

    ViewDetails(String username) {

        getUserDetails(username);

        setBounds(350, 160, 850, 620);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JPanel panel1 = new JPanel();
        panel1.setBackground(new Color(46, 43, 70));
        panel1.setBounds(0, 0, 425, 620);
        panel1.setLayout(null);
        add(panel1);

        JLabel label0 = new JLabel("V I E W   D E T A I L S ");
        label0.setBounds(85, 10, 500, 30);
        label0.setForeground(Color.WHITE);
        label0.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        panel1.add(label0);

        JLabel label1 = new JLabel("Username:" + "    "+username);
        label1.setBounds(50, 70, 250, 20);
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        panel1.add(label1);


        JLabel label2 = new JLabel("ID Proof:" + "    "+id_proof);
        label2.setBounds(50, 120, 250, 20);
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        panel1.add(label2);

        JLabel label3 = new JLabel("ID Number:" + "    "+id_number);
        label3.setBounds(50, 170, 250, 20);
        label3.setForeground(Color.WHITE);
        label3.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        panel1.add(label3);

        JLabel label4 = new JLabel("Name:" + "    "+name);
        label4.setBounds(50, 220, 250, 20);
        label4.setForeground(Color.WHITE);
        label4.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        panel1.add(label4);

        JLabel label5 = new JLabel("Gender:" + "    "+gender);
        label5.setBounds(50, 270, 250, 20);
        label5.setForeground(Color.WHITE);
        label5.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        panel1.add(label5);

        JLabel label6 = new JLabel("Country:" + "    "+country);
        label6.setBounds(50, 320, 250, 20);
        label6.setForeground(Color.WHITE);
        label6.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        panel1.add(label6);

        JLabel label7 = new JLabel("Address:" + "    "+address);
        label7.setBounds(50, 370, 250, 20);
        label7.setForeground(Color.WHITE);
        label7.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        panel1.add(label7);

        JLabel label8 = new JLabel("Contact Number:" + "    "+contact_number);
        label8.setBounds(50, 420, 250, 20);
        label8.setForeground(Color.WHITE);
        label8.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        panel1.add(label8);

        JLabel label9 = new JLabel("Email:" + "    "+email);
        label9.setBounds(50, 470, 300, 20);
        label9.setForeground(Color.WHITE);
        label9.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        panel1.add(label9);

        URL resource = this.getClass().getResource("templates/ViewDetails.png");
        if (resource != null) {
            ImageIcon imageIcon1 = new ImageIcon(resource);
            Image image2 = imageIcon1.getImage().getScaledInstance(550, 350, Image.SCALE_DEFAULT);
            ImageIcon imageIcon3 = new ImageIcon(image2);
            JLabel label10 = new JLabel(imageIcon3);
            label10.setBounds(355, 80, 550, 350);
            add(label10);
        } else {
            System.out.println("Image Not Found!");
        }
    }

    private void getUserDetails(String username) {

        try {
            String query = "select id_proof,id_number,name,gender,country,address,contact_number,email from profile where username=?";
            Connection connection = Connect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,username);

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                id_proof = resultSet.getString("id_proof");
                id_number = resultSet.getString("id_number");
                name = resultSet.getString("name");
                gender = resultSet.getString("gender");
                country = resultSet.getString("country");
                address = resultSet.getString("address");
                contact_number = resultSet.getString("contact_number");
                email = resultSet.getString("email");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}