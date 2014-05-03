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
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.postgresql.util.PGInterval;

/**
 *
 * @author Lada
 */
@Entity
@Table(name = "tymy")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tymy.findAll", query = "SELECT t FROM Tymy t"),
    @NamedQuery(name = "Tymy.findByTymId", query = "SELECT t FROM Tymy t WHERE t.tymId = :tymId"),
    @NamedQuery(name = "Tymy.findByNazev", query = "SELECT t FROM Tymy t WHERE t.nazev = :nazev"),
    @NamedQuery(name = "Tymy.findByStartovniCislo", query = "SELECT t FROM Tymy t WHERE t.startovniCislo = :startovniCislo"),
    @NamedQuery(name = "Tymy.findByPenalizacePrvniKolo", query = "SELECT t FROM Tymy t WHERE t.penalizacePrvniKolo = :penalizacePrvniKolo"),
    @NamedQuery(name = "Tymy.findByPenalizaceDruheKolo", query = "SELECT t FROM Tymy t WHERE t.penalizaceDruheKolo = :penalizaceDruheKolo"),
    @NamedQuery(name = "Tymy.findByDojel", query = "SELECT t FROM Tymy t WHERE t.dojel = :dojel")})
public class Tymy implements Serializable {
    @Basic(optional = false)
    @Lob
    @Column(name = "cas_prvniho_kola")
    private Object casPrvnihoKola;
    @Basic(optional = false)
    @Lob
    @Column(name = "cas_druheho_kola")
    private Object casDruhehoKola;
    @Column(name = "startovni_cislo")
    private Integer startovniCislo;
    @ManyToMany(mappedBy = "tymyCollection")
    private Collection<Kone> koneCollection;
    @JoinColumn(name = "zavod_id", referencedColumnName = "zavod_id")
    @ManyToOne
    private Zavod zavodId;
    @JoinColumn(name = "kategorie_id", referencedColumnName = "kategorie_id")
    @ManyToOne(optional = false)
    private Kategorie kategorieId;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tym_id")
    private Integer tymId;
    @Basic(optional = false)
    @Column(name = "nazev")
    private String nazev;
    @Basic(optional = false)
    @Column(name = "penalizace_prvni_kolo")
    private int penalizacePrvniKolo;
    @Basic(optional = false)
    @Column(name = "penalizace_druhe_kolo")
    private int penalizaceDruheKolo;
    @Basic(optional = false)
    @Column(name = "dojel")
    private boolean dojel;
//    @ManyToMany(mappedBy = "tymyCollection")
//    private Collection<Kone> koneCollection;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tymy")
//    private Collection<TymyHasOsoby> tymyHasOsobyCollection;
//    @JoinColumn(name = "zavod_id", referencedColumnName = "zavod_id")
//    @ManyToOne
//    private Zavod zavodId;
    @JoinColumn(name = "kategorie_id", referencedColumnName = "kategorie_id")
    @ManyToOne(optional = false)
    private Kategorie kategorieId;

    public Tymy() {
    }

    public Tymy(Integer tymId) {
        this.tymId = tymId;
    }

    public Tymy(Integer tymId, String nazev, int startovniCislo, PGInterval casPrvnihoKola, PGInterval casDruhehoKola, int penalizacePrvniKolo, int penalizaceDruheKolo, boolean dojel) {
        this.tymId = tymId;
        this.nazev = nazev;
        this.startovniCislo = startovniCislo;
        this.casPrvnihoKola = casPrvnihoKola;
        this.casDruhehoKola = casDruhehoKola;
        this.penalizacePrvniKolo = penalizacePrvniKolo;
        this.penalizaceDruheKolo = penalizaceDruheKolo;
        this.dojel = dojel;
    }

    public Integer getTymId() {
        return tymId;
    }

    public void setTymId(Integer tymId) {
        this.tymId = tymId;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public int getStartovniCislo() {
        return startovniCislo;
    }

    public void setStartovniCislo(int startovniCislo) {
        this.startovniCislo = startovniCislo;
    }

    public Object getCasPrvnihoKola() {
        return casPrvnihoKola;
    }

    public void setCasPrvnihoKola(PGInterval casPrvnihoKola) {
        this.casPrvnihoKola = casPrvnihoKola;
    }

    public Object getCasDruhehoKola() {
        return casDruhehoKola;
    }

    public void setCasDruhehoKola(PGInterval casDruhehoKola) {
        this.casDruhehoKola = casDruhehoKola;
    }

    public int getPenalizacePrvniKolo() {
        return penalizacePrvniKolo;
    }

    public void setPenalizacePrvniKolo(int penalizacePrvniKolo) {
        this.penalizacePrvniKolo = penalizacePrvniKolo;
    }

    public int getPenalizaceDruheKolo() {
        return penalizaceDruheKolo;
    }

    public void setPenalizaceDruheKolo(int penalizaceDruheKolo) {
        this.penalizaceDruheKolo = penalizaceDruheKolo;
    }

    public boolean getDojel() {
        return dojel;
    }

    public void setDojel(boolean dojel) {
        this.dojel = dojel;
    }

//    @XmlTransient
//    public Collection<Kone> getKoneCollection() {
//        return koneCollection;
//    }
//
//    public void setKoneCollection(Collection<Kone> koneCollection) {
//        this.koneCollection = koneCollection;
//    }
//
//    @XmlTransient
//    public Collection<TymyHasOsoby> getTymyHasOsobyCollection() {
//        return tymyHasOsobyCollection;
//    }
//
//    public void setTymyHasOsobyCollection(Collection<TymyHasOsoby> tymyHasOsobyCollection) {
//        this.tymyHasOsobyCollection = tymyHasOsobyCollection;
//    }
//
//    public Zavod getZavodId() {
//        return zavodId;
//    }
//
//    public void setZavodId(Zavod zavodId) {
//        this.zavodId = zavodId;
//    }
//
//    public Kategorie getKategorieId() {
//        return kategorieId;
//    }
//
//    public void setKategorieId(Kategorie kategorieId) {
//        this.kategorieId = kategorieId;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tymId != null ? tymId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tymy)) {
            return false;
        }
        Tymy other = (Tymy) object;
        if ((this.tymId == null && other.tymId != null) || (this.tymId != null && !this.tymId.equals(other.tymId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Tymy[ tymId=" + tymId + " ]";
    }

//    public Integer getStartovniCislo() {
//        return startovniCislo;
//    }

    public void setStartovniCislo(Integer startovniCislo) {
        this.startovniCislo = startovniCislo;
    }

//    public PGInterval getCasPrvnihoKola() {
//        return casPrvnihoKola;
//    }
//
//    public void setCasPrvnihoKola(PGInterval casPrvnihoKola) {
//        this.casPrvnihoKola = casPrvnihoKola;
//    }
//
//    public PGInterval getCasDruhehoKola() {
//        return casDruhehoKola;
//    }
//
//    public void setCasDruhehoKola(PGInterval casDruhehoKola) {
//        this.casDruhehoKola = casDruhehoKola;
//    }

    @XmlTransient
    public Collection<Kone> getKoneCollection() {
        return koneCollection;
    }

    public void setKoneCollection(Collection<Kone> koneCollection) {
        this.koneCollection = koneCollection;
    }

    public Zavod getZavodId() {
        return zavodId;
    }

    public void setZavodId(Zavod zavodId) {
        this.zavodId = zavodId;
    }

    public Kategorie getKategorieId() {
        return kategorieId;
    }

    public void setKategorieId(Kategorie kategorieId) {
        this.kategorieId = kategorieId;
    }

    public Object getCasPrvnihoKola() {
        return casPrvnihoKola;
    }

    public void setCasPrvnihoKola(Object casPrvnihoKola) {
        this.casPrvnihoKola = casPrvnihoKola;
    }

    public Object getCasDruhehoKola() {
        return casDruhehoKola;
    }

    public void setCasDruhehoKola(Object casDruhehoKola) {
        this.casDruhehoKola = casDruhehoKola;
    }
    
}
