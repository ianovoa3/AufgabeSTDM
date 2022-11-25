/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Datenbank.DBKlasse;
import VO.PersonVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author novoa
 */
public class Backend {
    
    Connection        cnn;
    ResultSet         result;
    Statement         Befehl;
    PreparedStatement BefehlVor;
    String Vorname;
    String Nachname;
    String Geburtsdatum;
    
    
    public Backend() {
        try{
            //
        }catch(Exception e){
         Logger.getLogger(DAO.Backend.class.getName()).log(Level.SEVERE,null,e); 
        }
           
           
    }
    
    public ArrayList<PersonVO> readTable() throws SQLException  {
        
        PersonVO person = new PersonVO();
        DBKlasse Database = new DBKlasse();
        ArrayList<PersonVO> liste = new ArrayList();
        try{
           cnn    =  Database.DBKlasse();
           Befehl = cnn.createStatement();
           result = Befehl.executeQuery("SELECT * FROM kunde");
           while(result.next()){
               Vorname        = result.getString("Vorname");
               Nachname       = result.getString("Nachname");
               Geburtsdatum   = result.getString("Geburtsdatum");
               person.setVorname(Vorname);
               person.setNachname(Nachname);
               person.setDatum(Geburtsdatum);
               liste.add(person);
               
           }
        
        }catch(Exception e){
            Logger.getLogger(DAO.Backend.class.getName()).log(Level.SEVERE,null,e);
            cnn.close();
        }
        
    
        return liste;
    }
    
    public boolean AddPerson(String Vorname,String Nachname,String Geburtsdatum) throws SQLException {
    
        DBKlasse Database = new DBKlasse();
        PersonVO person = new PersonVO();
        boolean transaction;
        try{
            person.setVorname(Vorname);
            person.setNachname(Nachname);
            person.setDatum(Nachname);
            
            cnn       = Database.DBKlasse();
            BefehlVor = cnn.prepareStatement("INSERT INTO Kunde(Vorname,Nachname,Geburtsdatum) VALUES(?,?,?)");
            BefehlVor.setString(1, person.getVorname());
            BefehlVor.setString(2, person.getNachname());
            BefehlVor.setString(1, person.getDatum());
            BefehlVor.executeUpdate();
            transaction = true;
        
        }catch(Exception e){
            Logger.getLogger(DAO.Backend.class.getName()).log(Level.SEVERE,null,e);  
            cnn.close();
            transaction = false;
        }
    
        return transaction;
            
    }
    
    
    
    
    
    
    
}
