package com.company;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.BorderFactory;

public class UpdateDetails extends JFrame {
    JTextField tf1, tf3, tf4, tf6, tf7, tf8, tf9;
    Choice choice;
    JRadioButton radioButton1, radioButton2, radioButton3;
    JButton button1, button2;

    UpdateDetails() {
        setBounds(350, 160, 850, 620);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JPanel panel1 = new JPanel();
        panel1.setBackground(new Color(46, 43, 70));
        panel1.setBounds(0, 0, 850, 620);
        panel1.setLayout(null);
        add(panel1);

        JLabel label0 = new JLabel("P E R S O N A L   D E T A I L S ");
        label0.setBounds(85, 10, 500, 30);
        label0.setForeground(Color.WHITE);
        label0.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        panel1.add(label0);


        JLabel label1 = new JLabel("Username:");
        label1.setBounds(50, 70, 200, 20);
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        panel1.add(label1);

        tf1 = new JTextField();
        tf1.setBounds(200, 70, 250, 25);
        tf1.setBorder(BorderFactory.createEmptyBorder());
        add(tf1);

        JLabel label2 = new JLabel("ID Proof:");
        label2.setBounds(50, 120, 100, 20);
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        panel1.add(label2);

        choice = new Choice();
        choice.add("Choose your option.");
        choice.add("Passport");
        choice.add("Aadhaar Card");
        choice.add("Pan Card");
        choice.setBounds(200, 120, 250, 20);
        panel1.add(choice);

        JLabel label3 = new JLabel("ID Number:");
        label3.setBounds(50, 170, 150, 20);
        label3.setForeground(Color.WHITE);
        label3.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        panel1.add(label3);

        tf3 = new JTextField();
        tf3.setBounds(200, 170, 250, 25);
        tf3.setBorder(BorderFactory.createEmptyBorder());
        add(tf3);

        JLabel label4 = new JLabel("Name:");
        label4.setBounds(50, 220, 150, 20);
        label4.setForeground(Color.WHITE);
        label4.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        panel1.add(label4);

        tf4 = new JTextField();
        tf4.setBounds(200, 220, 250, 25);
        tf4.setBorder(BorderFactory.createEmptyBorder());
        add(tf4);

        JLabel label5 = new JLabel("Gender");
        label5.setBounds(50, 270, 150, 20);
        label5.setForeground(Color.WHITE);
        label5.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        panel1.add(label5);

        radioButton1 = new JRadioButton("Male");
        radioButton1.setBackground(new Color(46, 43, 70));
        radioButton1.setBounds(200, 270, 70, 25);
        radioButton1.setForeground(Color.WHITE);
        radioButton1.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        panel1.add(radioButton1);

        radioButton2 = new JRadioButton("Female");
        radioButton2.setBackground(new Color(46, 43, 70));
        radioButton2.setBounds(280, 270, 100, 25);
        radioButton2.setForeground(Color.WHITE);
        radioButton2.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        panel1.add(radioButton2);

        radioButton3 = new JRadioButton("Others");
        radioButton3.setBackground(new Color(46, 43, 70));
        radioButton3.setBounds(380, 270, 100, 25);
        radioButton3.setForeground(Color.WHITE);
        radioButton3.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        panel1.add(radioButton3);

        JLabel label6 = new JLabel("Country:");
        label6.setBounds(50, 320, 150, 20);
        label6.setForeground(Color.WHITE);
        label6.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        panel1.add(label6);

        tf6 = new JTextField();
        tf6.setBounds(200, 320, 250, 25);
        tf6.setBorder(BorderFactory.createEmptyBorder());
        add(tf6);

        JLabel label7 = new JLabel("Address:");
        label7.setBounds(50, 370, 150, 20);
        label7.setForeground(Color.WHITE);
        label7.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        panel1.add(label7);

        tf7 = new JTextField();
        tf7.setBounds(200, 370, 250, 25);
        tf7.setBorder(BorderFactory.createEmptyBorder());
        add(tf7);

        JLabel label8 = new JLabel("Contact Number:");
        label8.setBounds(50, 420, 150, 20);
        label8.setForeground(Color.WHITE);
        label8.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        panel1.add(label8);

        tf8 = new JTextField();
        tf8.setBounds(200, 420, 250, 25);
        tf8.setBorder(BorderFactory.createEmptyBorder());
        add(tf8);

        JLabel label9 = new JLabel("Email:");
        label9.setBounds(50, 470, 150, 20);
        label9.setForeground(Color.WHITE);
        label9.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        panel1.add(label9);

        tf9 = new JTextField();
        tf9.setBounds(200, 470, 250, 25);
        tf9.setBorder(BorderFactory.createEmptyBorder());
        add(tf9);

        button1 = new JButton("Update");
        button1.setForeground(new Color(46, 43, 70));
        button1.setBounds(100, 525, 100, 25);
        button1.setFont(new Font("SAN_SERIF", Font.BOLD, 12));
        button1.setBorder(new LineBorder(new Color(46, 43, 70)));
        button1.addActionListener(e -> UpdateProfile(e));
        panel1.add(button1);

        button2 = new JButton("Back");
        button2.setForeground(new Color(46, 43, 70));
        button2.setBounds(290, 525, 100, 25);
        button2.setFont(new Font("SAN_SERIF", Font.BOLD, 12));
        button2.setBorder(new LineBorder(new Color(46, 43, 70)));
        button2.addActionListener(e -> GoToDashboard(e));
        panel1.add(button2);

        URL resource = this.getClass().getResource("templates/AddDetails.png");
        if (resource != null) {
            ImageIcon imageIcon1 = new ImageIcon(resource);
            Image image2 = imageIcon1.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
            ImageIcon imageIcon3 = new ImageIcon(image2);
            JLabel label10 = new JLabel(imageIcon3);
            label10.setBounds(450, 130, 400, 400);
            panel1.add(label10);
        } else {
            System.out.println("Image Not Found!");
        }
    }

    private void UpdateProfile(ActionEvent e) {
        if(tf1.getText().length() == 0 || tf3.getText().length() == 0 || tf4.getText().length() == 0 || tf6.getText().length() == 0 || tf7.getText().length() == 0
                || tf8.getText().length() == 0 || tf9.getText().length() == 0)
        {
            JOptionPane.showMessageDialog(null,"Enter your credentials.");
        }

        if(!radioButton1.isSelected() && !radioButton2.isSelected() && !radioButton3.isSelected()) {
            JOptionPane.showMessageDialog(null,"Please select gender");
        }

        if(e.getSource() == button1)
        {
            try{
                String query = "update profile set name =?,id_proof=?,id_number=?,gender=?,country=?,address=?,contact_number=?,email=? where username=?";
                Connection connection = Connect.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, tf4.getText());
                preparedStatement.setString(2, choice.getSelectedItem());
                preparedStatement.setString(3, tf3.getText());

                if(radioButton1.isSelected()) {
                    preparedStatement.setString(4, radioButton1.getText());
                }
                if(radioButton2.isSelected()) {
                    preparedStatement.setString(4, radioButton2.getText());
                }
                if(radioButton3.isSelected()) {
                    preparedStatement.setString(4, radioButton3.getText());
                }

                preparedStatement.setString(5, tf6.getText());
                preparedStatement.setString(6, tf7.getText());
                preparedStatement.setString(7, tf8.getText());
                preparedStatement.setString(8, tf9.getText());
                preparedStatement.setString(9, tf1.getText());
                preparedStatement.executeUpdate();
                JOptionPane.showMessageDialog(null,"Profile successfully updated.");
                dispose();
                connection.close();
            }catch(Exception exception) {
                JOptionPane.showMessageDialog(null,"Error occurred during Profile update.");
                exception.printStackTrace();
            }
        }
    }

    private void GoToDashboard(ActionEvent e) {
        if (e.getSource() == button2) {
            this.setVisible(false);
            new Dashboard(null).setVisible(true);
        }
    }
}