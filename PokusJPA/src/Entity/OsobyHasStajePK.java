/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Lada
 */
@Embeddable
public class OsobyHasStajePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "osoby_osoba_id")
    private int osobyOsobaId;
    @Basic(optional = false)
    @Column(name = "staje_staj_id")
    private int stajeStajId;
    @Basic(optional = false)
    @Column(name = "platne_od")
    @Temporal(TemporalType.DATE)
    private Date platneOd;
    @Basic(optional = false)
    @Column(name = "platne_do")
    @Temporal(TemporalType.DATE)
    private Date platneDo;

    public OsobyHasStajePK() {
    }

    public OsobyHasStajePK(int osobyOsobaId, int stajeStajId, Date platneOd, Date platneDo) {
        this.osobyOsobaId = osobyOsobaId;
        this.stajeStajId = stajeStajId;
        this.platneOd = platneOd;
        this.platneDo = platneDo;
    }

    public int getOsobyOsobaId() {
        return osobyOsobaId;
    }

    public void setOsobyOsobaId(int osobyOsobaId) {
        this.osobyOsobaId = osobyOsobaId;
    }

    public int getStajeStajId() {
        return stajeStajId;
    }

    public void setStajeStajId(int stajeStajId) {
        this.stajeStajId = stajeStajId;
    }

    public Date getPlatneOd() {
        return platneOd;
    }

    public void setPlatneOd(Date platneOd) {
        this.platneOd = platneOd;
    }

    public Date getPlatneDo() {
        return platneDo;
    }

    public void setPlatneDo(Date platneDo) {
        this.platneDo = platneDo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) osobyOsobaId;
        hash += (int) stajeStajId;
        hash += (platneOd != null ? platneOd.hashCode() : 0);
        hash += (platneDo != null ? platneDo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OsobyHasStajePK)) {
            return false;
        }
        OsobyHasStajePK other = (OsobyHasStajePK) object;
        if (this.osobyOsobaId != other.osobyOsobaId) {
            return false;
        }
        if (this.stajeStajId != other.stajeStajId) {
            return false;
        }
        if ((this.platneOd == null && other.platneOd != null) || (this.platneOd != null && !this.platneOd.equals(other.platneOd))) {
            return false;
        }
        if ((this.platneDo == null && other.platneDo != null) || (this.platneDo != null && !this.platneDo.equals(other.platneDo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.OsobyHasStajePK[ osobyOsobaId=" + osobyOsobaId + ", stajeStajId=" + stajeStajId + ", platneOd=" + platneOd + ", platneDo=" + platneDo + " ]";
    }
    
}
