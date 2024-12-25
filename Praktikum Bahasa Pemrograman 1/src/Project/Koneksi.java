/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project;

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
        url = "jdbc:mysql://localhost:3306/db_animanga";
        
        try{
            Class.forName(driver).newInstance();
            con = DriverManager.getConnection(url, id, pass);
            JOptionPane.showMessageDialog(null, "Database Berhasil Terkoneksi!");
        } catch(Exception e){
            System.out.println("" + e.getLocalizedMessage());
        }
    }
    public static void main(String[] args){
        Koneksi k = new Koneksi();
    }
}
