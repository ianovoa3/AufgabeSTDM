/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;

/**
 *
 * @author novoa
 */
public class PersonVO {
    
    String Vorname;
    String Nachname;
    String Datum;

    public PersonVO() {
    }

    public PersonVO(String Vorname, String Nachname, String Datum) {
        this.Vorname = Vorname;
        this.Nachname = Nachname;
        this.Datum = Datum;
    }

    public String getVorname() {
        return Vorname;
    }

    public void setVorname(String Vorname) {
        this.Vorname = Vorname;
    }

    public String getNachname() {
        return Nachname;
    }

    public void setNachname(String Nachname) {
        this.Nachname = Nachname;
    }

    public String getDatum() {
        return Datum;
    }

    public void setDatum(String Datum) {
        this.Datum = Datum;
    }
    
    
    
}
