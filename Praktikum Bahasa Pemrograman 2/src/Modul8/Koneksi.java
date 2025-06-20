/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modul8;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Pongo
 */
public class Koneksi {
    static Connection con;
    public Koneksi(){
        String id, pass, driver, url;
        id = "root";
        pass = "";
        driver = "com.mysql.cj.jdbc.Driver";
        url = "jdbc:mysql://localhost:3306/db_kasir";
        
        try{
            Class.forName(driver).newInstance();
            con = DriverManager.getConnection(url, id, pass);
            JOptionPane.showMessageDialog(null, "Koneksi Berhasil!");
        } catch(Exception e){
            System.out.println("" + e.getLocalizedMessage());
        }
    }
    public static Connection getKoneksi() {
        return con;
    }
    public static void main(String[] args){
        Koneksi k = new Koneksi();
    }
}
