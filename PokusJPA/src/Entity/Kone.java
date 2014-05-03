/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Lada
 */
@Entity
@Table(name = "kone")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Kone.findAll", query = "SELECT k FROM Kone k"),
//    @NamedQuery(name = "Kone.findByKunId", query = "SELECT k FROM Kone k WHERE k.kunId = :kunId"),
//    @NamedQuery(name = "Kone.findByJmeno", query = "SELECT k FROM Kone k WHERE k.jmeno = :jmeno"),
//    @NamedQuery(name = "Kone.findByPlemeno", query = "SELECT k FROM Kone k WHERE k.plemeno = :plemeno"),
//    @NamedQuery(name = "Kone.findByMajitel", query = "SELECT k FROM Kone k WHERE k.majitel = :majitel")})
public class Kone implements Serializable {
    @JoinTable(name = "tymy_has_kone", joinColumns = {
        @JoinColumn(name = "kone_kun_id", referencedColumnName = "kun_id")}, inverseJoinColumns = {
        @JoinColumn(name = "tymy_tym_id", referencedColumnName = "tym_id")})
    @ManyToMany
    private Collection<Tymy> tymyCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "kun_id")
    private Integer kunId;
    @Basic(optional = false)
    @Column(name = "jmeno")
    private String jmeno;
    @Basic(optional = false)
    @Column(name = "plemeno")
    private String plemeno;
    @Basic(optional = false)
    @Column(name = "majitel")
    private String majitel;
//    @JoinTable(name = "tymy_has_kone", joinColumns = {
//        @JoinColumn(name = "kone_kun_id", referencedColumnName = "kun_id")}, inverseJoinColumns = {
//        @JoinColumn(name = "tymy_tym_id", referencedColumnName = "tym_id")})
//    @ManyToMany
//    private Collection<Tymy> tymyCollection;

    public Kone() {
    }

    public Kone(Integer kunId) {
        this.kunId = kunId;
    }

    public Kone(Integer kunId, String jmeno, String plemeno, String majitel) {
        this.kunId = kunId;
        this.jmeno = jmeno;
        this.plemeno = plemeno;
        this.majitel = majitel;
    }

    public Integer getKunId() {
        return kunId;
    }

    public void setKunId(Integer kunId) {
        this.kunId = kunId;
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getPlemeno() {
        return plemeno;
    }

    public void setPlemeno(String plemeno) {
        this.plemeno = plemeno;
    }

    public String getMajitel() {
        return majitel;
    }

    public void setMajitel(String majitel) {
        this.majitel = majitel;
    }

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
        hash += (kunId != null ? kunId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kone)) {
            return false;
        }
        Kone other = (Kone) object;
        if ((this.kunId == null && other.kunId != null) || (this.kunId != null && !this.kunId.equals(other.kunId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Kone[ kunId=" + kunId + " ]";
    }

    @XmlTransient
    public Collection<Tymy> getTymyCollection() {
        return tymyCollection;
    }

    public void setTymyCollection(Collection<Tymy> tymyCollection) {
        this.tymyCollection = tymyCollection;
    }
    
}
