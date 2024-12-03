package Modul7;

import Modul6.*;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Pongo
 */
public class BP1_M7_P1 {
    static Connection con;
    public BP1_M7_P1(){
        String id, pass, driver, url;
        id = "root";
        pass = "";
        driver = "com.mysql.cj.jdbc.Driver";
        url = "jdbc:mysql://localhost:3306/db_mhs";
        
        try{
            Class.forName(driver).newInstance();
            con = DriverManager.getConnection(url, id, pass);
            JOptionPane.showMessageDialog(null, "Koneksi Berhasil");
        } catch(Exception e){
            System.out.println("" + e.getLocalizedMessage());
        }
    }
    public static void main(String[] args){
        BP1_M7_P1 k = new BP1_M7_P1();
    }
}
