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

public class ViewBookingDetails extends JFrame{

    JPanel panel1 = new JPanel();
    ViewBookingDetails(String username)
    {
        getBookingDetails(username);
        setBounds(490, 170, 900, 600);
        getContentPane().setBackground(Color.WHITE);

        panel1.setBackground(new Color(	54, 168, 190));
        panel1.setBounds(0, 0, 700, 450);
        panel1.setLayout(null);
        add(panel1);

        JLabel label0 = new JLabel("V I E W  B O O K I N G  D E T A I L S");
        label0.setBounds(250, 10, 500, 30);
        label0.setForeground(Color.BLACK);
        label0.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        panel1.add(label0);



        URL resource = this.getClass().getResource("templates/ViewBookingDetails.png");
        if (resource != null) {
            ImageIcon imageIcon1 = new ImageIcon(resource);
            Image image2 = imageIcon1.getImage().getScaledInstance(700, 350, Image.SCALE_DEFAULT);
            ImageIcon imageIcon3 = new ImageIcon(image2);
            JLabel label = new JLabel(imageIcon3);
            label.setBounds(300, 210, 700, 350);
            panel1.add(label);
        } else {
            System.out.println("Image Not Found!");
        }

    }

    private void getBookingDetails(String username) {
        BookHotel bookHotel = new BookHotel(username);
        String hotel_name = bookHotel.checkIfHotelIsAlreadyBooked(username);

        Connection connection = null;
        try {
            String query = "select guests,checkin,checkout,destination,package_name,price from booking_package where username=?";
            connection = Connect.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,username);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                String guests = resultSet.getString("guests");
                String checkin = resultSet.getString("checkin");
                String checkout = resultSet.getString("checkout");
                String destination = resultSet.getString("destination");
                String package_name = resultSet.getString("package_name");
                String price = resultSet.getString("price");

                JLabel label1 = new JLabel("Username: "+username );
                label1.setBounds(50, 80, 300, 20);
                label1.setForeground(Color.BLACK);
                label1.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
                panel1.add(label1);

                JLabel label2 = new JLabel("Package Selected: "+package_name);
                label2.setBounds(50, 130, 300, 20);
                label2.setForeground(Color.BLACK);
                label2.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
                panel1.add(label2);

                JLabel label3 = new JLabel("Total Guests: "+guests);
                label3.setBounds(50, 180, 300, 20);
                label3.setForeground(Color.BLACK);
                label3.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
                panel1.add(label3);

                JLabel label4 = new JLabel("Destination: "+destination);
                label4.setBounds(50, 230, 300, 20);
                label4.setForeground(Color.BLACK);
                label4.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
                panel1.add(label4);

                JLabel label5 = new JLabel("Hotel Name: "+hotel_name);
                label5.setBounds(50, 280, 300, 20);
                label5.setForeground(Color.BLACK);
                label5.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
                panel1.add(label5);

                JLabel label6 = new JLabel("Check-In: "+checkin);
                label6.setBounds(50, 330, 300, 20);
                label6.setForeground(Color.BLACK);
                label6.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
                panel1.add(label6);

                JLabel label7 = new JLabel("Check-Out: "+checkout);
                label7.setBounds(50, 380, 300, 20);
                label7.setForeground(Color.BLACK);
                label7.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
                panel1.add(label7);

                JLabel label8 = new JLabel("Price: Rs."+ Integer.parseInt(price)*Integer.parseInt(guests));
                label8.setBounds(50, 430, 300, 20);
                label8.setForeground(Color.BLACK);
                label8.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
                panel1.add(label8);

                getContentPane().add(panel1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        new ViewBookingDetails("cv").setVisible(true);
//    }
}
