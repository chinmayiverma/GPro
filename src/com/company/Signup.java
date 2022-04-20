package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;



public class Signup extends JFrame implements ActionListener {
    JButton button1, button2;
    JTextField tf1, tf2, tf5;
    JPasswordField tf3;
    Choice choice1;

    Signup() {
        setBounds(300, 250, 900, 400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JPanel panel1 = new JPanel();
        panel1.setBackground(new Color(46, 43, 70));
        panel1.setBounds(0, 0, 500, 400);
        panel1.setLayout(null);
        add(panel1);

        JLabel label1 = new JLabel("Username:");
        label1.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        label1.setBounds(20, 20, 100, 30);
        label1.setForeground(Color.WHITE);
        panel1.add(label1);

        tf1 = new JTextField();
        tf1.setBounds(190, 20, 250, 25);
        add(tf1);

        JLabel label2 = new JLabel("Name:");
        label2.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        label2.setForeground(Color.WHITE);
        label2.setBounds(20, 60, 100, 25);
        panel1.add(label2);

        tf2 = new JTextField();
        tf2.setBounds(190, 60, 250, 25);
        add(tf2);

        JLabel label3 = new JLabel("Password:");
        label3.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        label3.setForeground(Color.WHITE);
        label3.setBounds(20, 100, 100, 25);
        panel1.add(label3);

        tf3 = new JPasswordField();
        tf3.setBounds(190, 100, 250, 25);
        add(tf3);

        JLabel label4 = new JLabel("Security Question:");
        label4.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        label4.setForeground(Color.WHITE);
        label4.setBounds(20, 140, 150, 25);
        panel1.add(label4);

        choice1 = new Choice();
        choice1.add("Choose your option.");
        choice1.add("Your final percentage in class 12th exams.");
        choice1.add("Your favourite food.");
        choice1.add("Your childhood superhero.");
        choice1.add("Your favourite place for chilling.");
        choice1.add("Your favourite number.");
        choice1.setBounds(190, 140, 250, 25);
        panel1.add(choice1);

        JLabel label5 = new JLabel("Answer:");
        label5.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        label5.setForeground(Color.WHITE);
        label5.setBounds(20, 180, 100, 25);
        panel1.add(label5);

        tf5 = new JTextField();
        tf5.setBounds(190, 180, 250, 25);
        add(tf5);

        button1 = new JButton("Create");
        button1.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        button1.setForeground(new Color(46, 43, 70));
        button1.setBounds(70, 250, 100, 30);
        button1.addActionListener(this);
        panel1.add(button1);

        button2 = new JButton("Back");
        button2.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        button2.setForeground(new Color(46, 43, 70));
        button2.setBounds(300, 250, 100, 30);
        button2.addActionListener(e -> GoToLoginPage(e));
        panel1.add(button2);

        URL resource = this.getClass().getResource("templates/Signup.png");
        if (resource != null) {
            ImageIcon imageIcon1 = new ImageIcon(resource);
            Image image2 = imageIcon1.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
            ImageIcon imageIcon3 = new ImageIcon(image2);
            JLabel label6 = new JLabel(imageIcon3);
            label6.setBounds(500, 0, 400, 400);
            add(label6);
        } else {
            System.out.println("Image Not Found!");
        }
    }

    private void GoToLoginPage(ActionEvent e)
    {
        if(e.getSource() == button2)
        {
            this.setVisible(false);
            new Login().setVisible(true);
        }
    }
    public void actionPerformed(ActionEvent ae) {
        if(tf1.getText().length() == 0 || tf2.getText().length() == 0 || tf3.getText().length() == 0 || tf5.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Empty Fields!");
        } else if (ae.getSource() == button1) {

            if(choice1.getSelectedItem() == "Choose your option.")
            {
                JOptionPane.showMessageDialog(null,"Select your security question.");
            }
            else {
                String username = tf1.getText();
                String name = tf2.getText();
                String password = tf3.getText();
                String question = choice1.getSelectedItem();
                String answer = tf5.getText();
                insertDetailsIntoAccountTable(username, name, password, question, answer);
                addEntryIntoProfileTable(username);
            }
        }
    }

    private void insertDetailsIntoAccountTable(String username, String name, String password, String question, String answer) {
        String query = "insert into account(username,name,password,question,answer) values(?,?,?,?,?)";
        try {
            Connection conn = Connect.getConnection();
            System.out.println("Getting MySql connection" + conn);
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, question);
            preparedStatement.setString(5, answer);

            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, "Accounted Created Successfully!");

            this.setVisible(false);
            new Login().setVisible(true);
            conn.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Username: "+username+" already exists" );

            e.printStackTrace();
        }

    }

    private void addEntryIntoProfileTable(String username) {
        String query = "insert into profile(username) values(?)";
        try {
            Connection conn = Connect.getConnection();
            System.out.println("Getting MySql connection" + conn);
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, username);

            preparedStatement.execute();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
