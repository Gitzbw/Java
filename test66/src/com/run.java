package com;

import javax.swing.*;
import java.awt.*;

public class run extends JFrame{
    Mypanel mypanel = null;
    public static void main(String[] args) {
        new run();
    }
    public run()
    {
        mypanel = new Mypanel();
        this.add(mypanel);
        this.setSize(500,500);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class Mypanel extends JPanel
{
    @Override
    public void paint(Graphics g) {
        g.fillOval(20,20,20,20);
    }
}
