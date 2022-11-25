/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datenbank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author novoa
 */
public class DBKlasse {
    
    public String driver,url,user,password,bd;
    public Connection cnn;
    
    
    public Connection DBKlasse(){
    driver="com.mysql.jdbc.Driver";
    user="root";
    password="";
    bd="Aufgabe1";
    url="jdbc:mysql://localhost:3306/"+bd;
        try {
            Class.forName(driver).newInstance();
            cnn=DriverManager.getConnection(url, user, password);
            System.out.println("CONEXION OK ");
        } catch (Exception e) {
            System.out.println("ERROR AL CONECTAR" + e);
        }
      return cnn;  
    }
    
    public Connection DBKlasseClose() {
        try {
            cnn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBKlasse.class.getName()).log(Level.SEVERE, null, ex);
        }
        cnn = null;
        return cnn;
    }
    
    
    
}
