/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modul4;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author Pongo
 */

public class Applet_Gif extends Applet {
    private Image gmbr;

    @Override
    public void init() {
        gmbr = getImage(getClass().getResource("larry.gif"));
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(gmbr, 15, 10, this);
    }
}

