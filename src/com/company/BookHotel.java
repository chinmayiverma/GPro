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

public class BookHotel extends JFrame{
    Choice choice;
    JButton button1, button2;

    BookHotel(String username)
    {
        setBounds(490, 170, 900, 650);
        getContentPane().setBackground(Color.WHITE);

        JPanel panel1 = new JPanel();
        panel1.setBackground(new Color(46,43,70));
        panel1.setBounds(0, 0, 850, 640);
        panel1.setLayout(null);
        add(panel1);

        URL resource = this.getClass().getResource("templates/BookHotel.png");
        if (resource != null) {
            ImageIcon imageIcon1 = new ImageIcon(resource);
            Image image2 = imageIcon1.getImage().getScaledInstance(700, 350, Image.SCALE_DEFAULT);
            ImageIcon imageIcon3 = new ImageIcon(image2);
            JLabel label1 = new JLabel(imageIcon3);
            label1.setBounds(110, 210, 700, 350);
            panel1.add(label1);
        } else {
            System.out.println("Image Not Found!");
        }

        JLabel label1 = new JLabel("B O O K  H O T E L");
        label1.setBounds(300, 10, 500, 30);
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("SAN_SERIF", Font.BOLD, 30));
        panel1.add(label1);

        JLabel label2 = new JLabel("Username:  "+username);
        label2.setBounds(40, 80, 250, 20);
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
        panel1.add(label2);

        JLabel label3 = new JLabel("Select Hotel:");
        label3.setBounds(390, 80, 170, 20);
        label3.setForeground(Color.WHITE);
        label3.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
        panel1.add(label3);

        choice = new Choice();
        choice.add("Choose your Hotel.");
        choice.add("Hotel Taj Falaknuma");
        choice.add("Hotel President Wilson");
        choice.add("Hotel Taj Palace");
        choice.add("Hotel Leela Ambience");
        choice.add("Hotel Radisson");
        choice.add("Neemrana Fort");
        choice.add("Hotel Neelesh Inn");
        choice.add("Hotel Lagao Azul");
        choice.add("Hotel La Vie Woods");
        choice.setBounds(570, 80, 200, 30);
        panel1.add(choice);

        button1 = new JButton("Book");
        button1.setForeground(new Color(46, 43, 70));
        button1.setBounds(380, 570, 150, 25);
        button1.setFont(new Font("SAN_SERIF", Font.BOLD, 12));
        button1.setBorder(new LineBorder(new Color(46, 43, 70)));
        button1.addActionListener(e -> BookingHotel(e,username));
        panel1.add(button1);

    }

    private void BookingHotel(ActionEvent e,String username) {
        if(e.getSource() ==  button1)
        {
            if(choice.getSelectedItem() == "Choose your Hotel.")
            {
                JOptionPane.showMessageDialog(null,"Select your Hotel.");
            }
            else {
                Connection connection = null;

                String hotel_name = checkIfHotelIsAlreadyBooked(username);
                if(hotel_name!=null) {
                    JOptionPane.showMessageDialog(null, hotel_name + " has already Booked.");
                    dispose();
                }
                try {
                    String query = "insert into booking_hotel(username,hotel_name) values(?,?)";
                    connection = Connect.getConnection();
                    PreparedStatement preparedStatement = connection.prepareStatement(query);

                    preparedStatement.setString(1,username);
                    preparedStatement.setString(2,choice.getSelectedItem());
                    preparedStatement.execute();
                    String hotel = checkIfHotelIsAlreadyBooked(username);
                    if(!hotel.equalsIgnoreCase(hotel_name)) {
                        JOptionPane.showMessageDialog(null, hotel + " is Successfully Booked.");
                        dispose();
                    }

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public String checkIfHotelIsAlreadyBooked(String username) {
        Connection connection;
        try {
            String query = "select username,hotel_name from booking_hotel where username=?";
            connection = Connect.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                String hotel_name = resultSet.getString("hotel_name");
           return hotel_name;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
//    public static void main(String[] args) {
//        new BookHotel("cv").setVisible(true);
//    }
}
