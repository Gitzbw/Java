import java.util.Vector;

public class MyTank extends Tank {
    Bullet bullet = null;
    Vector<Bullet> bullets = new Vector<>();
    public MyTank(int x, int y, int direct, int speed) {
        super(x, y, direct, speed);
    }
    private int type = 1;
    public int getType() {
        return type;
    }
    public void Shots()
    {
        if(bullets.size() == 5)
        {
            return;
        }
        switch (getDirect())
        {
            case 0 :
                bullet = new Bullet(getX()+20,getY(),0);
                break;
            case 1 :
                bullet = new Bullet(getX()+60,getY()+20,1);
                break;
            case 2 :
                bullet = new Bullet(getX()+20,getY()+60,2);
                break;
            case 3 :
                bullet = new Bullet(getX(),getY()+20,3);
                break;
        }
        bullets.add(bullet);
        new Thread(bullet).start();
    }
}
