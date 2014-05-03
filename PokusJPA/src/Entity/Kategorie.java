/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Lada
 */
@Entity
@Table(name = "kategorie")
//@XmlRootElement
//@NamedQueries({
 //   @NamedQuery(name = "Kategorie.findAll", query = "SELECT k FROM Kategorie k"),
 //   @NamedQuery(name = "Kategorie.findByKategorieId", query = "SELECT k FROM Kategorie k WHERE k.kategorieId = :kategorieId"),
  //  @NamedQuery(name = "Kategorie.findByNazev", query = "SELECT k FROM Kategorie k WHERE k.nazev = :nazev"),
  //  @NamedQuery(name = "Kategorie.findByPocetKoni", query = "SELECT k FROM Kategorie k WHERE k.pocetKoni = :pocetKoni"),
  //  @NamedQuery(name = "Kategorie.findByPocetPrisedicich", query = "SELECT k FROM Kategorie k WHERE k.pocetPrisedicich = :pocetPrisedicich")})
public class Kategorie implements Serializable {
    @JoinTable(name = "zavod_has_kategorie", joinColumns = {
        @JoinColumn(name = "kategorie_kategorie_id", referencedColumnName = "kategorie_id")}, inverseJoinColumns = {
        @JoinColumn(name = "zavod_zavod_id", referencedColumnName = "zavod_id")})
    @ManyToMany
    private Collection<Zavod> zavodCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kategorieId")
    private Collection<Tymy> tymyCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "kategorie_id")
    private Long kategorieId;
    @Basic(optional = false)
    @Column(name = "nazev")
    private String nazev;
    @Column(name = "pocet_koni")
    private Integer pocetKoni;
    @Column(name = "pocet_prisedicich")
    private Integer pocetPrisedicich;
    //@JoinTable(name = "zavod_has_kategorie", joinColumns = {
     //   @JoinColumn(name = "kategorie_kategorie_id", referencedColumnName = "kategorie_id")}, inverseJoinColumns = {
    //    @JoinColumn(name = "zavod_zavod_id", referencedColumnName = "zavod_id")})
   // @ManyToMany
   // private Collection<Zavod> zavodCollection;
   // @OneToMany(cascade = CascadeType.ALL, mappedBy = "kategorieId")
   // private Collection<Tymy> tymyCollection;

    public Kategorie() {
    }

    public Kategorie(Long kategorieId) {
        this.kategorieId = kategorieId;
    }

    public Kategorie(Long kategorieId, String nazev) {
        this.kategorieId = kategorieId;
        this.nazev = nazev;
    }

    public Long getKategorieId() {
        return kategorieId;
    }

    public void setKategorieId(Long kategorieId) {
        this.kategorieId = kategorieId;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public Integer getPocetKoni() {
        return pocetKoni;
    }

    public void setPocetKoni(Integer pocetKoni) {
        this.pocetKoni = pocetKoni;
    }

    public Integer getPocetPrisedicich() {
        return pocetPrisedicich;
    }

    public void setPocetPrisedicich(Integer pocetPrisedicich) {
        this.pocetPrisedicich = pocetPrisedicich;
    }

//    @XmlTransient
//    public Collection<Zavod> getZavodCollection() {
//        return zavodCollection;
//    }
//
//    public void setZavodCollection(Collection<Zavod> zavodCollection) {
//        this.zavodCollection = zavodCollection;
//    }
//
//    @XmlTransient
//    public Collection<Tymy> getTymyCollection() {
//        return tymyCollection;
//    }
//
//    public void setTymyCollection(Collection<Tymy> tymyCollection) {
//        this.tymyCollection = tymyCollection;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kategorieId != null ? kategorieId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kategorie)) {
            return false;
        }
        Kategorie other = (Kategorie) object;
        if ((this.kategorieId == null && other.kategorieId != null) || (this.kategorieId != null && !this.kategorieId.equals(other.kategorieId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Kategorie[ kategorieId=" + kategorieId + " ]";
    }

    @XmlTransient
    public Collection<Zavod> getZavodCollection() {
        return zavodCollection;
    }

    public void setZavodCollection(Collection<Zavod> zavodCollection) {
        this.zavodCollection = zavodCollection;
    }

    @XmlTransient
    public Collection<Tymy> getTymyCollection() {
        return tymyCollection;
    }

    public void setTymyCollection(Collection<Tymy> tymyCollection) {
        this.tymyCollection = tymyCollection;
    }
    
}
