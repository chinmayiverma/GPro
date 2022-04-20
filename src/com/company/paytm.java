package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class paytm extends JFrame {
    paytm(){

        JEditorPane editorPane = new JEditorPane();
        //editorPane.setEditable(false);

        try {
            editorPane.setPage("https://paytm.com/online-payments");
        }catch (Exception e) {
            editorPane.setContentType("text/html");
            editorPane.setText("<html>Could not load</html>");
        }

        JScrollPane scrollPane = new JScrollPane(editorPane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(scrollPane);
        setPreferredSize(new Dimension(800,600));

        JButton button1 = new JButton("Back");
        button1.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        button1.setForeground(Color.BLACK);
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        button1.setBounds(1350, 30, 80, 40);
        editorPane.add(button1);

        setBounds(0,0,1920,1080);
        setVisible(true);
    }
}
