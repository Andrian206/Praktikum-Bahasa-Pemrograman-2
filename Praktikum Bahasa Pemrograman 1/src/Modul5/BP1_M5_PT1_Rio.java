/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modul5;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/**
 *
 * @author Rio
 */
public class BP1_M5_PT1_Rio extends JPanel {
    private static final int L = 600, T = 100;
    private int x1, x2, x3;
    private int s1 = 6, s2 = 5, s3 = 4;

    public BP1_M5_PT1_Rio() {
        setBackground(Color.WHITE);
        Timer timer = new Timer(10, e -> {
            x1 += s1;
            x2 += s2;
            x3 += s3;

            if (x1 < 0 || x1 > getWidth() - 40) s1 = -s1;
            if (x2 < 0 || x2 > getWidth() - 45) s2 = -s2;
            if (x3 < 0 || x3 > getWidth() - 50) s3 = -s3;
            repaint();
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillOval(x1, 20, 40, 30);
        g.setColor(Color.DARK_GRAY);
        g.fillOval(x2, 20, 45, 30);
        g.setColor(Color.GRAY);
        g.fillOval(x3, 20, 50, 30);
    }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(L, T);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame();
            frame.getContentPane().add(new BP1_M5_PT1_Rio());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("Animasi 3 Bola");
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}

