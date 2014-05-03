/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author Lada
 */

public class OsobyHasStajeID implements Serializable {
    private long staje_staj_id;
    private long osoby_osoba_id;
    private Date platne_od;
    private Date platne_do;

 
    public long getStaje_staj_id() {
        return staje_staj_id;
    }

    public void setStaje_staj_id(long staje_staj_id) {
        this.staje_staj_id = staje_staj_id;
    }

    public long getOsoby_osoba_id() {
        return osoby_osoba_id;
    }

    public void setOsoby_osoba_id(long osoby_osoba_id) {
        this.osoby_osoba_id = osoby_osoba_id;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (int) (this.staje_staj_id ^ (this.staje_staj_id >>> 32));
        hash = 23 * hash + (int) (this.osoby_osoba_id ^ (this.osoby_osoba_id >>> 32));
        hash = 23 * hash + Objects.hashCode(this.platne_od);
        hash = 23 * hash + Objects.hashCode(this.platne_do);
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
        final OsobyHasStajeID other = (OsobyHasStajeID) obj;
        if (this.staje_staj_id != other.staje_staj_id) {
            return false;
        }
        if (this.osoby_osoba_id != other.osoby_osoba_id) {
            return false;
        }
        if (!Objects.equals(this.platne_od, other.platne_od)) {
            return false;
        }
        if (!Objects.equals(this.platne_do, other.platne_do)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OsobyHasStajeID{" + "staje_staj_id=" + staje_staj_id + ", osoby_osoba_id=" + osoby_osoba_id + ", platne_od=" + platne_od + ", platne_do=" + platne_do + '}';
    }

    
  
    
}
