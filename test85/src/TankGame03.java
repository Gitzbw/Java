import javax.swing.*;

@SuppressWarnings({"all"})
public class TankGame03 extends JFrame {
    MyPanel mp = null;
    public static void main(String[] args) {
        new TankGame03();
    }
    public TankGame03()
    {
        mp = new MyPanel();
        Thread thread = new Thread(mp);
        thread.start();
        this.addKeyListener(mp);
        this.add(mp);
        this.setSize(1000,750);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}


