/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Lada
 */
@Embeddable
public class TymyHasOsobyPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "tymy_tym_id")
    private int tymyTymId;
    @Basic(optional = false)
    @Column(name = "osoby_osoba_id")
    private int osobyOsobaId;

    public TymyHasOsobyPK() {
    }

    public TymyHasOsobyPK(int tymyTymId, int osobyOsobaId) {
        this.tymyTymId = tymyTymId;
        this.osobyOsobaId = osobyOsobaId;
    }

    public int getTymyTymId() {
        return tymyTymId;
    }

    public void setTymyTymId(int tymyTymId) {
        this.tymyTymId = tymyTymId;
    }

    public int getOsobyOsobaId() {
        return osobyOsobaId;
    }

    public void setOsobyOsobaId(int osobyOsobaId) {
        this.osobyOsobaId = osobyOsobaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) tymyTymId;
        hash += (int) osobyOsobaId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TymyHasOsobyPK)) {
            return false;
        }
        TymyHasOsobyPK other = (TymyHasOsobyPK) object;
        if (this.tymyTymId != other.tymyTymId) {
            return false;
        }
        if (this.osobyOsobaId != other.osobyOsobaId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.TymyHasOsobyPK[ tymyTymId=" + tymyTymId + ", osobyOsobaId=" + osobyOsobaId + " ]";
    }
    
}
