package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Draw extends JFrame{
    MyPanel mp;
    public static void main(String[] args) {
        new Draw();
    }
    public Draw()
    {
        mp = new MyPanel();
        this.add(mp);
        this.setSize(1000,1000);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(mp);
    }
}

class MyPanel extends JPanel implements KeyListener
{
    int x = 0;
    int y = 0;
    @Override
    public void paint(Graphics g) {

        g.fillRect(0,0,1000,1000);
        g.setColor(Color.red);
        g.fillOval(x,y,50,50);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode)
        {
            case KeyEvent.VK_W :
                y--;
                break;
            case KeyEvent.VK_S :
                y++;
                break;
            case KeyEvent.VK_A :
                x--;
                break;
            case KeyEvent.VK_D :
                x++;
                break;
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
