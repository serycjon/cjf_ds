/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Lada
 */

public class ZavodHasKategorieID implements Serializable {
  private long zavod_zavod_id;
  private long kategorie_kategorie_id;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + (int) (this.zavod_zavod_id ^ (this.zavod_zavod_id >>> 32));
        hash = 47 * hash + (int) (this.kategorie_kategorie_id ^ (this.kategorie_kategorie_id >>> 32));
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
        final ZavodHasKategorieID other = (ZavodHasKategorieID) obj;
        if (this.zavod_zavod_id != other.zavod_zavod_id) {
            return false;
        }
        if (this.kategorie_kategorie_id != other.kategorie_kategorie_id) {
            return false;
        }
        return true;
    }

    public long getZavod_zavod_id() {
        return zavod_zavod_id;
    }

    public void setZavod_zavod_id(long zavod_zavod_id) {
        this.zavod_zavod_id = zavod_zavod_id;
    }

    public long getKategorie_kategorie_id() {
        return kategorie_kategorie_id;
    }

    public void setKategorie_kategorie_id(long kategorie_kategorie_id) {
        this.kategorie_kategorie_id = kategorie_kategorie_id;
    }


    
}
