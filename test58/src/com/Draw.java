package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Draw extends JFrame{
    private MyPanel mp = null;
    public static void main(String[] args) {
        new Draw();
    }
    public Draw()
    {
        mp = new MyPanel();
        this.addKeyListener(mp);
        this.add(mp);
        this.setSize(500,500);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MyPanel extends JPanel implements KeyListener
{
    int x = 10;
    int y = 10;
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x,y,100,100);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch(keyCode)
        {
            case KeyEvent.VK_W:
                y--;
                repaint();
                break;
            case KeyEvent.VK_S:
                y++;
                repaint();
                break;
            case KeyEvent.VK_A:
                x--;
                repaint();
                break;
            case KeyEvent.VK_D:
                x++;
                repaint();
                break;

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
