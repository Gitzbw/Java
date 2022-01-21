import java.util.Vector;

public class EnemyTank extends Tank{
    Vector<Bullet> bullet = new Vector<>();
    boolean loop = true;
    public EnemyTank(int x, int y, int direct, int speed) {
        super(x, y, direct, speed);
    }
    private int type = 0;
    public int getType() {
        return type;
    }
}
