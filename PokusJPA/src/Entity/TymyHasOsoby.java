/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lada
 */
@Entity
@Table(name = "tymy_has_osoby")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TymyHasOsoby.findAll", query = "SELECT t FROM TymyHasOsoby t"),
    @NamedQuery(name = "TymyHasOsoby.findByTymyTymId", query = "SELECT t FROM TymyHasOsoby t WHERE t.tymyHasOsobyPK.tymyTymId = :tymyTymId"),
    @NamedQuery(name = "TymyHasOsoby.findByOsobyOsobaId", query = "SELECT t FROM TymyHasOsoby t WHERE t.tymyHasOsobyPK.osobyOsobaId = :osobyOsobaId"),
    @NamedQuery(name = "TymyHasOsoby.findByJeJezdec", query = "SELECT t FROM TymyHasOsoby t WHERE t.jeJezdec = :jeJezdec")})
public class TymyHasOsoby implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TymyHasOsobyPK tymyHasOsobyPK;
    @Basic(optional = false)
    @Column(name = "je_jezdec")
    private boolean jeJezdec;
    @JoinColumn(name = "tymy_tym_id", referencedColumnName = "tym_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tymy tymy;
    @JoinColumn(name = "osoby_osoba_id", referencedColumnName = "osoba_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Osoby osoby;

    public TymyHasOsoby() {
    }

    public TymyHasOsoby(TymyHasOsobyPK tymyHasOsobyPK) {
        this.tymyHasOsobyPK = tymyHasOsobyPK;
    }

    public TymyHasOsoby(TymyHasOsobyPK tymyHasOsobyPK, boolean jeJezdec) {
        this.tymyHasOsobyPK = tymyHasOsobyPK;
        this.jeJezdec = jeJezdec;
    }

    public TymyHasOsoby(int tymyTymId, int osobyOsobaId) {
        this.tymyHasOsobyPK = new TymyHasOsobyPK(tymyTymId, osobyOsobaId);
    }

    public TymyHasOsobyPK getTymyHasOsobyPK() {
        return tymyHasOsobyPK;
    }

    public void setTymyHasOsobyPK(TymyHasOsobyPK tymyHasOsobyPK) {
        this.tymyHasOsobyPK = tymyHasOsobyPK;
    }

    public boolean getJeJezdec() {
        return jeJezdec;
    }

    public void setJeJezdec(boolean jeJezdec) {
        this.jeJezdec = jeJezdec;
    }

    public Tymy getTymy() {
        return tymy;
    }

    public void setTymy(Tymy tymy) {
        this.tymy = tymy;
    }

    public Osoby getOsoby() {
        return osoby;
    }

    public void setOsoby(Osoby osoby) {
        this.osoby = osoby;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tymyHasOsobyPK != null ? tymyHasOsobyPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TymyHasOsoby)) {
            return false;
        }
        TymyHasOsoby other = (TymyHasOsoby) object;
        if ((this.tymyHasOsobyPK == null && other.tymyHasOsobyPK != null) || (this.tymyHasOsobyPK != null && !this.tymyHasOsobyPK.equals(other.tymyHasOsobyPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.TymyHasOsoby[ tymyHasOsobyPK=" + tymyHasOsobyPK + " ]";
    }
    
}
