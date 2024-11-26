package Modul2;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class BP1_M2_PT1_Rio_AppleteMouse extends Applet implements MouseListener {
    private String tap = "Muehehehehehe!?";
    private Color clr = Color.BLACK;
    @Override
    public void init() {
        setSize(600, 400); 
        addMouseListener(this); 
    }
    @Override
    public void paint(Graphics g) {
        g.setColor(clr);
        g.drawString(tap, 260, 200); 
        g.drawString(tap, 250, 180); 
        g.drawString(tap, 240, 160); 
        g.drawString(tap, 230, 140); 
        g.drawString(tap, 220, 120); 
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        clr = clr == Color.BLACK ? Color.GREEN : Color.BLACK;
        repaint();
    }
    @Override public void mousePressed(MouseEvent e) {}
    @Override public void mouseReleased(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}
}

