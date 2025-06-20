/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modul4;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Pongo
 */

public class Perhitungan extends Applet implements ActionListener {
    Label lblA, lblB, lblHasil;
    TextField txtA, txtB, txtHasil;
    Button btnTambah;

    public void init() {
        setLayout(new GridLayout(4, 2));

        lblA = new Label("Bilangan Ke-1: ");
        txtA = new TextField(10);

        lblB = new Label("Bilangan Ke-2: ");
        txtB = new TextField(10);

        lblHasil = new Label("Hasil: ");
        txtHasil = new TextField(10);
        txtHasil.setEditable(false);

        btnTambah = new Button("Kali");
        btnTambah.addActionListener(this);

        add(lblA);
        add(txtA);
        add(lblB);
        add(txtB);
        add(lblHasil);
        add(txtHasil);
        add(btnTambah);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            int a = Integer.parseInt(txtA.getText());
            int b = Integer.parseInt(txtB.getText());
            int hasil = a * b;
            txtHasil.setText(Integer.toString(hasil));
        } catch (NumberFormatException ex) {
            txtHasil.setText("Input Tidak Valid");
        }
    }
}

