public class EnemyTank extends Tank{
    public EnemyTank(int x, int y, int direct, int speed) {
        super(x, y, direct, speed);
    }
    private int type = 0;

    public int getType() {
        return type;
    }
}
