package com;

import javax.swing.*;
import java.awt.*;

public class draw extends JFrame{
    public MyPanel mp;
    public static void main(String[] args) {
        new draw();
    }
    public draw()
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
        g.fillOval(0,0,30,30);
    }
}
