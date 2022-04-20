package com.company;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import java.net.URL;


public class Tour_Planner {
    public static void main(String[] args) {
        TourFrame frame = new TourFrame();
        frame.setVisible(true);
        int x=1;
        for(int i=2;i<=600;i=i+10,x=x+7)   // x and y
        {

            frame.setLocation(800-(x+i)/2,500-(i/2));
            frame.setSize(x+i,i);
            try{
                Thread.sleep(10);

            }
            catch(Exception e){}
        }

        frame.setVisible(true);

    }
}

class TourFrame extends JFrame implements Runnable {
    Thread thread1;
    TourFrame()
    {
        URL resource = this.getClass().getResource("templates/IntroPage.png");
        if(resource!=null) {
            ImageIcon imageIcon1 = new ImageIcon(resource);
            Image image2 = imageIcon1.getImage().getScaledInstance(1030,600, Image.SCALE_DEFAULT);
            ImageIcon imageIcon3 = new ImageIcon(image2);
            JLabel jLabel = new JLabel(imageIcon3);
            add(jLabel);

            setUndecorated(true);
            thread1 = new Thread(this);
            thread1.start();
        }
        else {
            System.out.println("Image Not Found!");
        }
    }
    public void run(){    //override
        try {
            Thread.sleep(7000);
            this.setVisible(false);

            new Login().setVisible(true);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}