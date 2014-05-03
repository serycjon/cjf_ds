/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Lada
 */
@Entity
@Table(name = "zavod")
public class Zavod implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long zavod_id;
    @Column(nullable=false, length=20)
    private String nazev;
    private Date datum;
    @Column(nullable=false, length=50)
    private String misto_konani;
   
    public static Zavod createZavod(String nazev,Date datum,String misto_konani){
        Zavod zavod = new Zavod();
        zavod.setNazev(nazev);
        zavod.setDatum(datum);
        zavod.setDatum(datum);
        zavod.setMisto_konani(misto_konani);
        return zavod;
    }

    public Long getZavod_id() {
        return zavod_id;
    }

    public void setZavod_id(Long zavod_id) {
        this.zavod_id = zavod_id;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getMisto_konani() {
        return misto_konani;
    }

    public void setMisto_konani(String misto_konani) {
        this.misto_konani = misto_konani;
    }
   
    
}
