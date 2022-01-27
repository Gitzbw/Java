public class Bomb {
    int x;
    int y;
    int life = 9;
    boolean loop = true;

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void LifeDown()
    {
        if(life > 0)
        {
            life--;
        }
        else
        {
            loop = false;
        }
    }
}
