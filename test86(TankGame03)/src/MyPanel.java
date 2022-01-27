import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

class MyPanel extends JPanel implements KeyListener,Runnable
{
    MyTank myTank = null;
    Vector<Bomb> bombs = new Vector<>();
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;
    Vector<EnemyTank> enemyTanks = new Vector<>();
    Vector<Node> nodes = new Vector<>();
    int Enemysize = 3;

    public MyPanel(String key) throws IOException {
        File file = new File(Recorder.getRecordFile());
        if(file.exists())
        {
            nodes = Recorder.GetNodesAndEnemyTankRec();
        }
        else
        {
            System.out.println("文件不存在 只能开始新游戏");
            key = "1";
        }

        Recorder.setEnemyTanks(enemyTanks);
        myTank = new MyTank(200, 200,0,5);

        switch (key)
        {
            case "1":
                Recorder.setAllEnemyTankNum(0);
                for(int i =0;i<Enemysize;i++)
                {
                    enemyTanks.add( new EnemyTank((100 * (i + 1)), 0,2,1));
                    enemyTanks.get(i).setEnemyTanks(enemyTanks);
                    new Thread(enemyTanks.get(i)).start();
                    Bullet bullet = new Bullet(enemyTanks.get(i).getX()+20,enemyTanks.get(i).getY()+60,enemyTanks.get(i).getDirect());
                    enemyTanks.get(i).bullet.add(bullet);
                    new Thread(bullet).start();
                }
                break;
            case "2":
                for(int i =0;i<nodes.size();i++)
                {
                    Node node = nodes.get(i);
                    enemyTanks.add( new EnemyTank(node.getX(), node.getY(),node.getDirect(),1));
                    enemyTanks.get(i).setEnemyTanks(enemyTanks);
                    new Thread(enemyTanks.get(i)).start();
                    Bullet bullet = new Bullet(enemyTanks.get(i).getX()+20,enemyTanks.get(i).getY()+60,enemyTanks.get(i).getDirect());
                    enemyTanks.get(i).bullet.add(bullet);
                    new Thread(bullet).start();
                }
                break;
            default:
                System.out.println("你的输入有误");
        }
        image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.gif"));
        image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2.gif"));
        image3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.gif"));

        new AePlayWave("src\\111.wav").start();
    }

    public void ShowInfo(Graphics g)
    {
        g.setColor(Color.BLACK);
        Font font = new Font("宋体", Font.BOLD, 25);
        g.setFont(font);
        g.drawString("您累积击毁敌方坦克",1020,30);
        DrawTank(1020,60,g,0,0);
        g.setColor(Color.BLACK);
        g.drawString(Recorder.getAllEnemyTankNum()+"",1080,100);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,1000,750);
        ShowInfo(g);
        if(myTank != null && myTank.loop){
            DrawTank(myTank.getX(), myTank.getY(), g,myTank.getDirect(), myTank.getType());
        }
        if(myTank.bullet != null && myTank.bullet.loop == true)
        {
            g.draw3DRect(myTank.bullet.x,myTank.bullet.y,1,1,false);
        }
//        for (int i = 0; i < myTank.bullets.size(); i++) {
//            Bullet bullet = myTank.bullets.get(i);
//            if(myTank.bullet != null && myTank.bullet.loop == true) {
//           g.draw3DRect(bullet.x,bullet.y,1,1,false);
//            }
//            else
//            {
//                myTank.bullets.remove(bullet);
//            }
//        }

        for (int i = 0; i < bombs.size(); i++) {
            Bomb bomb = bombs.get(i);
            if(bomb.life > 6)
            {
                g.drawImage(image1,bomb.x,bomb.y,60,60,this);
            }
            else if (bomb.life > 3)
            {
                g.drawImage(image2,bomb.x,bomb.y,60,60,this);
            }
            else
            {
                g.drawImage(image3,bomb.x,bomb.y,60,60,this);
            }
            bomb.LifeDown();
            if(bomb.life == 0)
            {
                bombs.remove(bomb);
            }
        }

        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            if(enemyTank.loop){
            DrawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), enemyTank.getType());
            for (int j = 0; j < enemyTank.bullet.size(); j++) {
                Bullet bullet = enemyTank.bullet.get(j);
                if (bullet.loop) {
                    g.draw3DRect(bullet.x, bullet.y, 1, 1, false);
                } else {
                    enemyTank.bullet.remove(bullet);
                }
            }
            }
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



    public void HitTank(Bullet s,Tank Tank)
    {
        switch(Tank.getDirect())
        {
            case 0:
            case 2:
            if(s.x > Tank.getX() && s.x < Tank.getX()+40
                    && s.y > Tank.getY() && s.y < Tank.getY()+60)
            {
                s.loop = false;
                Tank.loop = false;
                if(!(Tank == myTank))
                {
                    enemyTanks.remove(Tank);
                    Recorder.AddAllEnemyTank();
                }
                Bomb bomb = new Bomb(Tank.getX(), Tank.getY());
                bombs.add(bomb);
            }
            break;
            case 1:
            case 3:
                if(s.x > Tank.getX() && s.x < Tank.getX()+60
                        && s.y > Tank.getY() && s.y < Tank.getY()+40)
                {
                    s.loop = false;
                    Tank.loop = false;
                    if(!(Tank == myTank))
                    {
                        enemyTanks.remove(Tank);
                        Recorder.AddAllEnemyTank();
                    }
                    Bomb bomb = new Bomb(Tank.getX(), Tank.getY());
                    bombs.add(bomb);
                }
                break;
        }
    }


    public void HitEnemy()
    {
        for (int i = 0; i < myTank.bullets.size(); i++) {
            Bullet bullet = myTank.bullets.get(i);
            if(bullet != null && bullet.loop)
            {
                for (int j = 0; j < enemyTanks.size(); j++) {
                    EnemyTank enemyTank = enemyTanks.get(j);
                    HitTank(bullet,enemyTank);
                }
            }
        }

    }

    public void HitMyTank()
    {
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            for (int j = 0; j < enemyTank.bullet.size(); j++) {
                Bullet bullet = enemyTank.bullet.get(j);
                if(myTank.loop && bullet.loop)
                {
                    HitTank(bullet,myTank);
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            myTank.setDirect(0);
            if(myTank.getY()>0)
            {
                myTank.moveUp();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            myTank.setDirect(1);
            if(myTank.getX()+60<1000)
            {
                myTank.moveRight();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            myTank.setDirect(2);
            if(myTank.getY()+60<750)
            {
                myTank.moveDown();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            myTank.setDirect(3);
            if(myTank.getX()>0)
            {
                myTank.moveLeft();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_J) {
            if(myTank.bullet == null || myTank.bullet.loop == false){
                myTank.Shots();
            }
//            myTank.Shots();
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while(true)
        {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            HitEnemy();
            HitMyTank();
            this.repaint();
        }
    }
}
