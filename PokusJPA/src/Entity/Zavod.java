/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Lada
 */
@Entity
@Table(name = "zavod")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zavod.findAll", query = "SELECT z FROM Zavod z"),
    @NamedQuery(name = "Zavod.findByZavodId", query = "SELECT z FROM Zavod z WHERE z.zavodId = :zavodId"),
    @NamedQuery(name = "Zavod.findByNazev", query = "SELECT z FROM Zavod z WHERE z.nazev = :nazev"),
    @NamedQuery(name = "Zavod.findByDatum", query = "SELECT z FROM Zavod z WHERE z.datum = :datum"),
    @NamedQuery(name = "Zavod.findByMistoKonani", query = "SELECT z FROM Zavod z WHERE z.mistoKonani = :mistoKonani")})
public class Zavod implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "zavod_id")
    private Integer zavodId;
    @Basic(optional = false)
    @Column(name = "nazev")
    private String nazev;
    @Basic(optional = false)
    @Column(name = "datum")
    @Temporal(TemporalType.DATE)
    private Date datum;
    @Basic(optional = false)
    @Column(name = "misto_konani")
    private String mistoKonani;
    @ManyToMany(mappedBy = "zavodCollection")
    private Collection<Kategorie> kategorieCollection;
    @OneToMany(mappedBy = "zavodId")
    private Collection<Tymy> tymyCollection;

    public Zavod() {
    }

    public Zavod(Integer zavodId) {
        this.zavodId = zavodId;
    }

    public Zavod(Integer zavodId, String nazev, Date datum, String mistoKonani) {
        this.zavodId = zavodId;
        this.nazev = nazev;
        this.datum = datum;
        this.mistoKonani = mistoKonani;
    }

    public Integer getZavodId() {
        return zavodId;
    }

    public void setZavodId(Integer zavodId) {
        this.zavodId = zavodId;
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

    public String getMistoKonani() {
        return mistoKonani;
    }

    public void setMistoKonani(String mistoKonani) {
        this.mistoKonani = mistoKonani;
    }

    @XmlTransient
    public Collection<Kategorie> getKategorieCollection() {
        return kategorieCollection;
    }

    public void setKategorieCollection(Collection<Kategorie> kategorieCollection) {
        this.kategorieCollection = kategorieCollection;
    }

    @XmlTransient
    public Collection<Tymy> getTymyCollection() {
        return tymyCollection;
    }

    public void setTymyCollection(Collection<Tymy> tymyCollection) {
        this.tymyCollection = tymyCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (zavodId != null ? zavodId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zavod)) {
            return false;
        }
        Zavod other = (Zavod) object;
        if ((this.zavodId == null && other.zavodId != null) || (this.zavodId != null && !this.zavodId.equals(other.zavodId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Zavod[ zavodId=" + zavodId + " ]";
    }
    
}
