package com.company;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Login extends JFrame {
    JButton button1, button2, button3;
    JPasswordField tf2;
    JTextField tf1;

    Login() {
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setBounds(500, 300, 700, 400);

        JPanel panel1 = new JPanel();
        panel1.setBackground(new Color(46, 43, 70));
        panel1.setBounds(0, 0, 350, 400);
        panel1.setLayout(null);
        add(panel1);

        URL resource = this.getClass().getResource("templates/Login.png");
        if (resource != null) {
            ImageIcon imageIcon1 = new ImageIcon(resource);
            Image image2 = imageIcon1.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
            ImageIcon imageIcon3 = new ImageIcon(image2);

            JLabel label1 = new JLabel(imageIcon3);
            label1.setBounds(10, 30, 300, 300);
            panel1.add(label1);

            JPanel panel2 = new JPanel();
            panel2.setLayout(null);
            panel2.setBounds(350, 30, 450, 300);
            add(panel2);

            JLabel label2 = new JLabel("Username");
            label2.setBounds(30, 20, 100, 25);
            label2.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
            panel2.add(label2);

            tf1 = new JTextField();
            tf1.setBounds(30, 60, 300, 30);
            panel2.add(tf1);

            JLabel label3 = new JLabel("Password");
            label3.setBounds(30, 100, 100, 25);
            label3.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
            panel2.add(label3);

            tf2 = new JPasswordField();
            tf2.setBounds(30, 140, 300, 30);
            panel2.add(tf2);

            button1 = new JButton("Login");
            button1.setForeground(new Color(46, 43, 70));
            button1.setBounds(40, 200, 100, 30);
            button1.setBorder(new LineBorder(new Color(46, 43, 70)));
            button1.addActionListener(e -> jButton1ActionPerformed(e));
            panel2.add(button1);

            button2 = new JButton("Sign Up");
            button2.setForeground(new Color(46, 43, 70));
            button2.setBounds(200, 200, 100, 30);
            button2.setBorder(new LineBorder(new Color(46, 43, 70)));
            button2.addActionListener(e -> hideLoginPageAndShowSignupPage(e));
            panel2.add(button2);

            button3 = new JButton("Forgot Password");
            button3.setForeground(new Color(46, 43, 70));
            button3.setBounds(100, 250, 150, 30);
            button3.setBorder(new LineBorder(new Color(46, 43, 70)));
            button3.addActionListener(e -> showForgotPasswordPage(e));
            panel2.add(button3);
        } else {
            System.out.println("Image Not Found!");
        }
        setVisible(true);
    }


    private void jButton1ActionPerformed(ActionEvent e) {
        if (tf1.getText().length() == 0 || tf2.getPassword().length == 0) {
            JOptionPane.showMessageDialog(null, "Empty Username and password. Please enter it now.");
        } else if (e.getSource() == button1) {
            try {
                String username = tf1.getText();
                String password = tf2.getText();

                String query = "select username from account where username=? AND password=?";
                Connection conn = Connect.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setString(1, tf1.getText());
                preparedStatement.setString(2, tf2.getText());
                ResultSet resultSet1 = preparedStatement.executeQuery();
                if (resultSet1.next()) {
                    String username_res = resultSet1.getString("username");
                    this.setVisible(false);
                    new Loading(username_res).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password.");
                }
            } catch (SQLException ex) {

                ex.printStackTrace();
            }
        }

    }

    private void hideLoginPageAndShowSignupPage(ActionEvent e) {
        if (e.getSource() == button2) {
            this.setVisible(false);
            new Signup().setVisible(true);
        }
    }

    private void showForgotPasswordPage(ActionEvent e) {
        if (e.getSource() == button3) {
            this.setVisible(false);
            new ForgotPass().setVisible(true);
        }

    }
}
