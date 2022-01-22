import java.util.Vector;

public class EnemyTank extends Tank implements Runnable{
    Vector<Bullet> bullet = new Vector<>();
    boolean loop = true;
    public EnemyTank(int x, int y, int direct, int speed) {
        super(x, y, direct, speed);
    }
    private int type = 0;
    public int getType() {
        return type;
    }

    @Override
    public void run() {
        while(true)
        {
            if(bullet.size() == 0 && loop)
            {
                Bullet s = null;
                switch (getDirect())
                {
                    case 0 :
                        s = new Bullet(getX()+20,getY(),0);
                        break;
                    case 1 :
                        s = new Bullet(getX()+60,getY()+20,1);
                        break;
                    case 2 :
                        s = new Bullet(getX()+20,getY()+60,2);
                        break;
                    case 3 :
                        s = new Bullet(getX(),getY()+20,3);
                        break;
                }
                bullet.add(s);
                new Thread(s).start();
            }
            switch (getDirect())
            {
                case 0 :
                    for (int i = 0; i < 30; i++) {
                        if(getY()>0)
                        {
                            moveUp();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 1 :
                    for (int i = 0; i < 30; i++) {
                        if(getX()+60<1000)
                        {
                            moveRight();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 2 :
                    for (int i = 0; i < 30; i++) {
                        if(getY()+60<750)
                        {
                            moveDown();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 3 :
                    for (int i = 0; i < 30; i++) {
                        if(getX()>0)
                        {
                            moveLeft();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            setDirect((int)(Math.random()*4));
            if(!loop)
            {
                break;
            }
        }
    }
}
