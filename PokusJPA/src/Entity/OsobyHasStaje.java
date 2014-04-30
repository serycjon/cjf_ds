/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "osoby_has_staje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OsobyHasStaje.findAll", query = "SELECT o FROM OsobyHasStaje o"),
    @NamedQuery(name = "OsobyHasStaje.findByOsobyOsobaId", query = "SELECT o FROM OsobyHasStaje o WHERE o.osobyHasStajePK.osobyOsobaId = :osobyOsobaId"),
    @NamedQuery(name = "OsobyHasStaje.findByStajeStajId", query = "SELECT o FROM OsobyHasStaje o WHERE o.osobyHasStajePK.stajeStajId = :stajeStajId"),
    @NamedQuery(name = "OsobyHasStaje.findByPlatneOd", query = "SELECT o FROM OsobyHasStaje o WHERE o.osobyHasStajePK.platneOd = :platneOd"),
    @NamedQuery(name = "OsobyHasStaje.findByPlatneDo", query = "SELECT o FROM OsobyHasStaje o WHERE o.osobyHasStajePK.platneDo = :platneDo")})
public class OsobyHasStaje implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OsobyHasStajePK osobyHasStajePK;
    @JoinColumn(name = "staje_staj_id", referencedColumnName = "staj_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Staje staje;
    @JoinColumn(name = "osoby_osoba_id", referencedColumnName = "osoba_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Osoby osoby;

    public OsobyHasStaje() {
    }

    public OsobyHasStaje(OsobyHasStajePK osobyHasStajePK) {
        this.osobyHasStajePK = osobyHasStajePK;
    }

    public OsobyHasStaje(int osobyOsobaId, int stajeStajId, Date platneOd, Date platneDo) {
        this.osobyHasStajePK = new OsobyHasStajePK(osobyOsobaId, stajeStajId, platneOd, platneDo);
    }

    public OsobyHasStajePK getOsobyHasStajePK() {
        return osobyHasStajePK;
    }

    public void setOsobyHasStajePK(OsobyHasStajePK osobyHasStajePK) {
        this.osobyHasStajePK = osobyHasStajePK;
    }

    public Staje getStaje() {
        return staje;
    }

    public void setStaje(Staje staje) {
        this.staje = staje;
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
        hash += (osobyHasStajePK != null ? osobyHasStajePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OsobyHasStaje)) {
            return false;
        }
        OsobyHasStaje other = (OsobyHasStaje) object;
        if ((this.osobyHasStajePK == null && other.osobyHasStajePK != null) || (this.osobyHasStajePK != null && !this.osobyHasStajePK.equals(other.osobyHasStajePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.OsobyHasStaje[ osobyHasStajePK=" + osobyHasStajePK + " ]";
    }
    
}
