package com;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings({"all"})
public class DrawCirlce extends JFrame {
    private MyPanel mp = null;
    public static void main(String[] args) {
         new DrawCirlce();
    }
     public DrawCirlce()
     {
         mp = new MyPanel();
         this.add(mp);
         this.setSize(500,500);
         this.setVisible(true);
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }


}

class MyPanel extends JPanel
{
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.blue);
        g.drawOval(10,10,100,100);
        g.setColor(Color.red);
        g.drawOval(100,100,100,100);
    }
}
