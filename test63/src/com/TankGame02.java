package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

@SuppressWarnings({"all"})
public class TankGame02 extends JFrame{
    MyPanel mp = null;
    public static void main(String[] args) {
        new TankGame02();
    }
    public TankGame02()
    {
        mp = new MyPanel();
        this.addKeyListener(mp);
        this.add(mp);
        this.setSize(1000,750);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
@SuppressWarnings({"all"})
class MyPanel extends JPanel implements KeyListener
{
    MyTank myTank = null;
    Vector<EnemyTank> enemyTanks = new Vector<>();
    int Enemysize = 3;
    boolean loop;
    public MyPanel()
    {
        myTank = new MyTank(100, 100,0,5);
        for(int i =0;i<Enemysize;i++)
        {
            enemyTanks.add( new EnemyTank((100 * (i + 1)), 0,2,1));
        }
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,1000,750);
        DrawTank(myTank.getX(), myTank.getY(), g,myTank.getDirect(), myTank.getType());
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            DrawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), enemyTank.getType());
        }
        if(loop)
        {
            Bullet bullet = new Bullet(myTank.getX(), myTank.getY(),g);
            bullet.start();
            loop = false;
        }
    }

    public void DrawTank(int x,int y,Graphics g,int direct,int type)
    {
        switch (type)
        {
            case 0: //敌人的坦克
                g.setColor(Color.cyan);
                break;
            case 1: //我的坦克
                g.setColor(Color.yellow);
                break;
        }

        //direct 表示方向(0: 向上 1 向右 2 向下 3 向左 )
        switch (direct)
        {
            case 0: //表示向上
                g.fill3DRect(x, y, 10, 60, false);//画出坦克左边轮子
                g.fill3DRect(x + 30, y, 10, 60, false);//画出坦克右边轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//画出坦克盖子
                g.fillOval(x + 10, y + 20, 20, 20);//画出圆形盖子
                g.drawLine(x + 20, y + 30, x + 20, y);//画出炮筒
                break;
            case 1: //表示向右
                g.fill3DRect(x, y, 60, 10, false);//画出坦克上边轮子
                g.fill3DRect(x, y + 30, 60, 10, false);//画出坦克下边轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//画出坦克盖子
                g.fillOval(x + 20, y + 10, 20, 20);//画出圆形盖子
                g.drawLine(x + 30, y + 20, x + 60, y + 20);//画出炮筒
                break;
            case 2: //表示向下
                g.fill3DRect(x, y, 10, 60, false);//画出坦克左边轮子
                g.fill3DRect(x + 30, y, 10, 60, false);//画出坦克右边轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//画出坦克盖子
                g.fillOval(x + 10, y + 20, 20, 20);//画出圆形盖子
                g.drawLine(x + 20, y + 30, x + 20, y + 60);//画出炮筒
                break;
            case 3: //表示向左
                g.fill3DRect(x, y, 60, 10, false);//画出坦克上边轮子
                g.fill3DRect(x, y + 30, 60, 10, false);//画出坦克下边轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//画出坦克盖子
                g.fillOval(x + 20, y + 10, 20, 20);//画出圆形盖子
                g.drawLine(x + 30, y + 20, x, y + 20);//画出炮筒
                break;
        }


    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            myTank.setDirect(0);
            myTank.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            myTank.setDirect(1);
            myTank.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            myTank.setDirect(2);
            myTank.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            myTank.setDirect(3);
            myTank.moveLeft();
        }
          else if(e.getKeyCode() == KeyEvent.VK_J)
        {
            loop = true;
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    class Bullet extends Thread
    {
        Graphics g;
        int x;
        int y;
        int num1 = 55;
        int num2 = 15;
        public Bullet(int x,int y,Graphics g)
        {
            this.x = x;
            this.y = y;
            this.g = g;
        }
        @Override
        public void run() {
            while(true)
            {
                synchronized (this)
                {
                    g.setColor(Color.RED);
                    g.fillOval(x+(num1++),y+(num2++),10,10);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}