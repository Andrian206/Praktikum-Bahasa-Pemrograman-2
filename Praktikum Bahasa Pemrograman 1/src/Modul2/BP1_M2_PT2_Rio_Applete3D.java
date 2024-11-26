package Modul2;

import java.applet.Applet;
import java.awt.*;

public class BP1_M2_PT2_Rio_Applete3D extends Applet {
    @Override
    public void init() {
        setSize(350, 320); 
    }
    @Override
    public void paint(Graphics g) {
        int x1 = 100, y1 = 200;  
        int x2 = 300, y2 = 200; 
        int x3 = 250, y3 = 270; 
        int x4 = 50, y4 = 270;
        int x5 = 175, y5 = 235;
        int topx = 175; int topy = 20;  
        
        g.drawLine(x1, y1, x2, y2); 
        g.drawLine(x2, y2, x3, y3); 
        g.drawLine(x3, y3, x4, y4); 
        g.drawLine(x4, y4, x1, y1); 

        g.drawLine(x1, y1, topx, topy); 
        g.drawLine(x2, y2, topx, topy); 
        g.drawLine(x3, y3, topx, topy); 
        g.drawLine(x4, y4, topx, topy); 
        g.drawLine(x5, y5, topx, topy); 
    }
}
