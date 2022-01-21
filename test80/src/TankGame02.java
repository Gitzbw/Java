import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

@SuppressWarnings({"all"})
public class TankGame02 extends JFrame {
    MyPanel mp = null;
    public static void main(String[] args) {
        new TankGame02();
    }
    public TankGame02()
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


