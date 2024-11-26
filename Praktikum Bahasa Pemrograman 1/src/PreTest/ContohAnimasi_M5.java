/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PreTest;

import Modul5.BP1_M5_Tugas1_Rio;
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
public class ContohAnimasi_M5 extends JPanel {
    private static final int L = 600, T = 100;
    private int x1;
    private int s1 = 6;

    public ContohAnimasi_M5() {
        setBackground(Color.WHITE);
        Timer timer = new Timer(10, e -> {
            x1 += s1;

            if (x1 < 0 || x1 > getWidth() - 40) s1 = -s1;
            repaint();
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillOval(x1, 30, 40, 30);
    }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(L, T);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame();
            frame.getContentPane().add(new ContohAnimasi_M5());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("Animasi Sederhana");
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}

