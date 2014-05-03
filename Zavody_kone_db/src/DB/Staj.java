/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Lada
 */
@Entity
@Table(name = "staje")
public class Staj implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long staj_id;
    @Column(nullable=false, length=20)
    private String jmeno;
    @Column(nullable=false, length=20)
    private String mesto;
     @OneToMany(mappedBy = "staj")
    private Collection<OsobyHasStaje> osobyHasStajeCollection;
    
     public static Staj createStaj(String jmeno,String mesto){
         Staj staj = new Staj();
         staj.setJmeno(jmeno);
         staj.setMesto(mesto);
         return staj;
     }
   

    public Long getStaj_id() {
        return staj_id;
    }

    public Collection<OsobyHasStaje> getOsobyHasStajeCollection() {
        return osobyHasStajeCollection;
    }

    public void setOsobyHasStajeCollection(Collection<OsobyHasStaje> osobyHasStajeCollection) {
        this.osobyHasStajeCollection = osobyHasStajeCollection;
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

 

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (staj_id != null ? staj_id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the staj_id fields are not set
        if (!(object instanceof Staj)) {
            return false;
        }
        Staj other = (Staj) object;
        if ((this.staj_id == null && other.staj_id != null) || (this.staj_id != null && !this.staj_id.equals(other.staj_id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DB.Staj[ id=" + staj_id + " ]";
    }
    
}
