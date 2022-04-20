package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.BorderFactory;

public class ForgotPass extends JFrame {
    JTextField tf1, tf2;
    JPasswordField tf3, tf4;
    JButton button1, button2, button3;
    JPanel panel1 = new JPanel();
    JLabel label3 = new JLabel();

    ForgotPass() {
        label3.setVisible(false);
        setBounds(400, 225, 850, 380);
        getContentPane().setBackground(new Color(46, 43, 70));
        setLayout(null);

        URL resource = this.getClass().getResource("templates/ForgotPass.png");
        if (resource != null) {
            ImageIcon imageIcon1 = new ImageIcon(resource);
            Image image2 = imageIcon1.getImage().getScaledInstance(650, 650, Image.SCALE_DEFAULT);
            ImageIcon imageIcon3 = new ImageIcon(image2);

            JLabel label1 = new JLabel(imageIcon3);
            label1.setBounds(515, 20, 300, 300);
            add(label1);

            panel1.setLayout(null);
            panel1.setBounds(0, 0, 500, 800);
            add(panel1);

            JLabel label2 = new JLabel("Username");
            label2.setBounds(20, 40, 100, 25);
            label2.setFont(new Font("SAN_SERIF", Font.BOLD, 14));
            panel1.add(label2);

            tf1 = new JTextField();
            tf1.setBounds(230, 40, 150, 25);
            tf1.setBorder(BorderFactory.createEmptyBorder());
            panel1.add(tf1);


            button1 = new JButton("Search");
            button1.setBackground(Color.GRAY);
            button1.setForeground(Color.WHITE);
            button1.setBounds(390, 40, 95, 25);
            button1.addActionListener(e -> checkIfUserNameExistsInDatabase(e));
            panel1.add(button1);

            JLabel label5 = new JLabel("New Password");
            label5.setBounds(20, 120, 150, 25);
            label5.setFont(new Font("SAN_SERIF", Font.BOLD, 14));
            panel1.add(label5);

            tf3 = new JPasswordField();
            tf3.setBounds(230, 120, 150, 25);
            tf3.setBorder(BorderFactory.createEmptyBorder());
            tf3.addActionListener(e -> checkIfPasswordIsNull(e));
            panel1.add(tf3);

            JLabel label6 = new JLabel("Confirm Password");
            label6.setBounds(20, 160, 150, 25);
            label6.setFont(new Font("SAN_SERIF", Font.BOLD, 14));
            panel1.add(label6);

            tf4 = new JPasswordField();
            tf4.setBounds(230, 160, 150, 25);
            tf4.setBorder(BorderFactory.createEmptyBorder());
            tf4.addActionListener(e -> checkIfPasswordIsNull(e));
            panel1.add(tf4);

            button2 = new JButton("Back");
            button2.setBackground(Color.GRAY);
            button2.setForeground(Color.WHITE);
            button2.setBounds(110, 270, 100, 25);
            button2.addActionListener(e -> GoToLoginPageBack(e));
            panel1.add(button2);

            button3 = new JButton("Submit");
            button3.setBackground(Color.GRAY);
            button3.setForeground(Color.WHITE);
            button3.setBounds(290, 270, 100, 25);
            button3.addActionListener(e -> checkIfAnswerMatchInDatabase(e));
            panel1.add(button3);

        }
    }

    private void GoToLoginPageBack(ActionEvent e) {
        if (e.getSource() == button2) {
            this.setVisible(false);
            new Login().setVisible(true);
        }
    }

    private void checkIfAnswerMatchInDatabase(ActionEvent e) {

        if (tf2.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Empty Fields.Enter it now.");

        } else if (tf3.getPassword().length == 0) {
            JOptionPane.showMessageDialog(null, "Please Enter New Password.");
        } else if (tf4.getPassword().length == 0) {
            JOptionPane.showMessageDialog(null, "Please Enter Confirmed Password.");
        } else {


            try {
                String query1 = "select answer from account where username=?  and answer=?";
                Connection conn = Connect.getConnection();
                PreparedStatement pst1 = conn.prepareStatement(query1);
                pst1.setString(1, tf1.getText());
                pst1.setString(2, tf2.getText());
                ResultSet resultSet1 = pst1.executeQuery();

                if (resultSet1.next()) {
                    String answer = resultSet1.getString(1);

                    if (!tf2.getText().equalsIgnoreCase(answer)) {
                        JOptionPane.showMessageDialog(null, "Answer is not correct");

                    } else if (!Arrays.equals(tf3.getPassword(),tf4.getPassword())) {
                        JOptionPane.showMessageDialog(null, "Password and Confirm password is not same.");

                    } else {
                        String query = "update account set password=? where username=?";
                        try {
                            System.out.println("Getting MySql connection" + conn);
                            PreparedStatement pst2 = conn.prepareStatement(query);
                            pst2.setString(1, String.valueOf(tf4.getPassword()));
                            pst2.setString(2, tf1.getText());
                            pst2.executeUpdate();

                            JOptionPane.showMessageDialog(null, "Password changed Successfully!");
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }

                    System.out.println(answer);
                }  else {JOptionPane.showMessageDialog(null, "Answer is not correct");
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void checkIfPasswordIsNull(ActionEvent e) {
        if (tf2.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Please Enter your answer.");
        }
    }

    private void checkIfUserNameExistsInDatabase(ActionEvent ae) {
        if (tf1.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Please Enter Username");

        } else {
            try {
                String query = "select username,question from account where username=?";
                Connection conn = Connect.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setString(1, tf1.getText());
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    String question = resultSet.getString(2);
                    label3.setText(question);
                    label3.setBounds(20, 80, 200, 25);
                    label3.setFont(new Font("SAN_SERIF", Font.BOLD, 14));
                    panel1.add(label3);
                    label3.setVisible(true);

                    tf2 = new JTextField();
                    tf2.setBounds(230, 80, 150, 25);
                    tf2.setBorder(BorderFactory.createEmptyBorder());
                    tf2.addActionListener(e1 -> checkIfAnswerIsNull(e1));
                    panel1.add(tf2);

                    tf1.setEditable(false);
                    button1.setEnabled(false);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void checkIfAnswerIsNull(ActionEvent e) {
        if (tf2.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Please Enter Answer!");
        }
    }
}


