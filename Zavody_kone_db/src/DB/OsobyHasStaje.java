/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Lada
 */
@Entity
@Table(name = "osoby_has_staje")
@IdClass(OsobyHasStajeID.class)
public class OsobyHasStaje implements Serializable {
    
    @Id
    private long osoby_osoba_id;
    @Id
    private long staje_staj_id;
    @Id
    private Date platne_od;
    @Id
    private Date platne_do;
    
    @ManyToOne
    @PrimaryKeyJoinColumn(name="osoby_osoba_id", referencedColumnName="osoba_id")
    private Osoba osoba;
    
    @ManyToOne
    @PrimaryKeyJoinColumn(name="staje_staj_id", referencedColumnName="staj_id")
    private Staj staj;

    public static OsobyHasStaje createOsobyHasStaje(long osoby_osoba_id, long staje_staj_id, Date platne_od, Date platne_do){
        OsobyHasStaje ohs = new OsobyHasStaje();
        ohs.setOsoby_osoba_id(osoby_osoba_id);
        ohs.setStaje_staj_id(staje_staj_id);
        ohs.setPlatne_do(platne_do);
        ohs.setPlatne_od(platne_od);
        return ohs;
    }

    public Osoba getOsoba() {
        return osoba;
    }
    
/**
 * 
 * @param osoba 
 */
    public void setOsoba(Osoba osoba) {
        this.osoba = osoba;
    }

    public Staj getStaj() {
        return staj;
    }

    public void setStaj(Staj staj) {
        this.staj = staj;
    }

    public Date getPlatne_od() {
        return platne_od;
    }

    public void setPlatne_od(Date platne_od) {
        this.platne_od = platne_od;
    }

    public Date getPlatne_do() {
        return platne_do;
    }

    public void setPlatne_do(Date platne_do) {
        this.platne_do = platne_do;
    }
    
    
    public long getOsoby_osoba_id() {
        return osoby_osoba_id;
    }

    public void setOsoby_osoba_id(long osoby_osoba_id) {
        this.osoby_osoba_id = osoby_osoba_id;
    }

    public long getStaje_staj_id() {
        return staje_staj_id;
    }

    public void setStaje_staj_id(long staje_staj_id) {
        this.staje_staj_id = staje_staj_id;
    }



   

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (int) (this.osoby_osoba_id ^ (this.osoby_osoba_id >>> 32));
        hash = 59 * hash + (int) (this.staje_staj_id ^ (this.staje_staj_id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OsobyHasStaje other = (OsobyHasStaje) obj;
        if (this.osoby_osoba_id != other.osoby_osoba_id) {
            return false;
        }
        if (this.staje_staj_id != other.staje_staj_id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OsobyHasStaje{" + "osoby_osoba_id=" + osoby_osoba_id + ", staje_staj_id=" + staje_staj_id + '}';
    }

    

   
    
}
