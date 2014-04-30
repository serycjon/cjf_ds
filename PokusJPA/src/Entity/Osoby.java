/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "osoby")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Osoby.findAll", query = "SELECT o FROM Osoby o"),
    @NamedQuery(name = "Osoby.findByOsobaId", query = "SELECT o FROM Osoby o WHERE o.osobaId = :osobaId"),
    @NamedQuery(name = "Osoby.findByJmeno", query = "SELECT o FROM Osoby o WHERE o.jmeno = :jmeno"),
    @NamedQuery(name = "Osoby.findByPrijmeni", query = "SELECT o FROM Osoby o WHERE o.prijmeni = :prijmeni"),
    @NamedQuery(name = "Osoby.findByDatumNarozeni", query = "SELECT o FROM Osoby o WHERE o.datumNarozeni = :datumNarozeni")})
public class Osoby implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "osoba_id")
    private Integer osobaId;
    @Basic(optional = false)
    @Column(name = "jmeno")
    private String jmeno;
    @Basic(optional = false)
    @Column(name = "prijmeni")
    private String prijmeni;
    @Basic(optional = false)
    @Column(name = "datum_narozeni")
    @Temporal(TemporalType.DATE)
    private Date datumNarozeni;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "osoby")
    private Collection<TymyHasOsoby> tymyHasOsobyCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "osoby")
    private Collection<OsobyHasStaje> osobyHasStajeCollection;

    public Osoby() {
    }

    public Osoby(Integer osobaId) {
        this.osobaId = osobaId;
    }

    public Osoby(Integer osobaId, String jmeno, String prijmeni, Date datumNarozeni) {
        this.osobaId = osobaId;
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.datumNarozeni = datumNarozeni;
    }

    public Integer getOsobaId() {
        return osobaId;
    }

    public void setOsobaId(Integer osobaId) {
        this.osobaId = osobaId;
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    public Date getDatumNarozeni() {
        return datumNarozeni;
    }

    public void setDatumNarozeni(Date datumNarozeni) {
        this.datumNarozeni = datumNarozeni;
    }

    @XmlTransient
    public Collection<TymyHasOsoby> getTymyHasOsobyCollection() {
        return tymyHasOsobyCollection;
    }

    public void setTymyHasOsobyCollection(Collection<TymyHasOsoby> tymyHasOsobyCollection) {
        this.tymyHasOsobyCollection = tymyHasOsobyCollection;
    }

    @XmlTransient
    public Collection<OsobyHasStaje> getOsobyHasStajeCollection() {
        return osobyHasStajeCollection;
    }

    public void setOsobyHasStajeCollection(Collection<OsobyHasStaje> osobyHasStajeCollection) {
        this.osobyHasStajeCollection = osobyHasStajeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (osobaId != null ? osobaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Osoby)) {
            return false;
        }
        Osoby other = (Osoby) object;
        if ((this.osobaId == null && other.osobaId != null) || (this.osobaId != null && !this.osobaId.equals(other.osobaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Osoby[ osobaId=" + osobaId + " ]";
    }
    
}
