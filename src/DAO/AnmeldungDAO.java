/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Datenbank.DBKlasse;
import VO.LoginVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author novoa
 */
public class AnmeldungDAO {
    Connection cnn;
    Statement Befehl;
    PreparedStatement BefehlVO;
    ResultSet result;
    public AnmeldungDAO() {
    }
    
    public boolean Login(String Username,String Password){
        
        LoginVO  login     = new LoginVO(Username,Password);
        DBKlasse database  = new DBKlasse();
        boolean transaction = false;
        try{
            cnn = database.DBKlasse();
            BefehlVO = cnn.prepareStatement("SELECT Username,Password FROM LoginDaten WHERE Username=? AND Password = MD5(?)");
            BefehlVO.setString(1,login.getUsername());
            BefehlVO.setString(2,login.getPassword());
            result = BefehlVO.executeQuery();
            while(result.next()){
                transaction = true;
            }
            
        }catch(Exception e){
            Logger.getLogger(AnmeldungDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return transaction;
    } 
    
    
}
