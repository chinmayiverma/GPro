package com.company;

import java.awt.*;
import java.net.URL;
import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Loading extends JFrame implements Runnable {

    private JPanel contentPane;
    private JProgressBar progressBar;
    String username;
    int s;
    Thread th;

    public void setUploading() {
        setVisible(false);
        th.start();
    }

    public void run() {
        try {
            for (int i = 0; i < 100; i++) {
                s = s + 1;
                int m = progressBar.getMaximum();
                int v = progressBar.getValue();
                if (v < m) {
                    progressBar.setValue(progressBar.getValue() + 1);
                } else {
                    i = 101;
                }

                Thread.sleep(50);

            }
            this.setVisible(false);
            new Dashboard(username).setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Loading(String username) {
        this.username = username;
        th = new Thread((Runnable) this);

        setBounds(500, 300, 600, 400);

        contentPane = new JPanel();
        contentPane.setBackground(new Color(46, 43, 70));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        URL resource = this.getClass().getResource("templates/loading.png");
        if (resource != null) {
            ImageIcon imageIcon1 = new ImageIcon(resource);
            Image image2 = imageIcon1.getImage().getScaledInstance(650,200 , Image.SCALE_DEFAULT);
            ImageIcon imageIcon3 = new ImageIcon(image2);

            JLabel label2 = new JLabel(imageIcon3);
            label2.setBounds(35, 60, 530, 200);
            add(label2);

            JLabel label1 = new JLabel("EASEMYTRIP");
            label1.setForeground(new Color(46, 43, 70));
            label1.setFont(new Font("SAN_SERIF", Font.BOLD, 30));
            label1.setBounds(200, 20, 700, 35);
            contentPane.add(label1);

        progressBar = new JProgressBar();
        progressBar.setFont(new Font("SAN_SERIF", Font.BOLD, 12));
        progressBar.setStringPainted(true);
        progressBar.setBounds(160, 270, 300, 25);
        contentPane.add(progressBar);

        JLabel label3 = new JLabel("Loading...");
        label3.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        label3.setForeground(new Color(46, 43, 70));
        label3.setBounds(40, 350, 150, 30);
        contentPane.add(label3);

            JPanel panel = new JPanel();
            panel.setBackground(Color.WHITE);
            panel.setBounds(20, 20, 560, 360);
            contentPane.add(panel);

            setUndecorated(true);
            setUploading();
        }
    }
}
