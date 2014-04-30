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
@Table(name = "staje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Staje.findAll", query = "SELECT s FROM Staje s"),
    @NamedQuery(name = "Staje.findByStajId", query = "SELECT s FROM Staje s WHERE s.stajId = :stajId"),
    @NamedQuery(name = "Staje.findByJmeno", query = "SELECT s FROM Staje s WHERE s.jmeno = :jmeno"),
    @NamedQuery(name = "Staje.findByMesto", query = "SELECT s FROM Staje s WHERE s.mesto = :mesto")})
public class Staje implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "staj_id")
    private Integer stajId;
    @Basic(optional = false)
    @Column(name = "jmeno")
    private String jmeno;
    @Basic(optional = false)
    @Column(name = "mesto")
    private String mesto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "staje")
    private Collection<OsobyHasStaje> osobyHasStajeCollection;

    public Staje() {
    }

    public Staje(Integer stajId) {
        this.stajId = stajId;
    }

    public Staje(Integer stajId, String jmeno, String mesto) {
        this.stajId = stajId;
        this.jmeno = jmeno;
        this.mesto = mesto;
    }

    public Integer getStajId() {
        return stajId;
    }

    public void setStajId(Integer stajId) {
        this.stajId = stajId;
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
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
        hash += (stajId != null ? stajId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Staje)) {
            return false;
        }
        Staje other = (Staje) object;
        if ((this.stajId == null && other.stajId != null) || (this.stajId != null && !this.stajId.equals(other.stajId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Staje[ stajId=" + stajId + " ]";
    }
    
}
