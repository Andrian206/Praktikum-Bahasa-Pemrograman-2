package Modul2;

import java.applet.Applet;
import java.awt.*;

public class BP1_M2_Tugas2_Rio_AppleteAnimasi extends Applet implements Runnable {
    private int x1, x2, x3;
    private int s1 = 6, s2 = 5, s3 = 4;
    private Thread thread;
    @Override
    public void init() {
        setSize(600, 50);
        thread = new Thread(this);
        thread.start();
    }
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillOval(x1, 10, 40, 30);
        g.setColor(Color.DARK_GRAY);
        g.fillOval(x2, 10, 45, 30);
        g.setColor(Color.GRAY);
        g.fillOval(x3, 10, 50, 30);
    }
    @Override
    public void run() {
        while (true) {
            x1 += s1;
            x2 += s2;
            x3 += s3;
            if (x1 < 0 || x1 > getWidth() - 39) {
                s1 = -s1;
            }
            if (x2 < 0 || x2 > getWidth() - 44) {
                s2 = -s2;
            }
            if (x3 < 0 || x3 > getWidth() - 49) {
                s3 = -s3;
            }
            repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
