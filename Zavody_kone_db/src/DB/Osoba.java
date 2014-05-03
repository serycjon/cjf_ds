/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DB;

import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.postgresql.util.PGInterval;

/**
 *
 * @author jonas
 */
@Entity
@Table(name="osoby")
public class Osoba implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long osoba_id;
  @Column(nullable=false, length=20)
  private String jmeno;
  @Column(length=20)
  private String prijmeni;
  private Date datum_narozeni;
  @OneToMany(mappedBy="osoba")
  private List<TymyHasOsoby> tymy;
  @OneToMany( mappedBy = "osoba")
  private Collection<OsobyHasStaje> staje;
 
  public static Osoba createOsoba(String jmeno, String prijmeni, Date datum_narozeni) {
        Osoba osoba = new Osoba();
        osoba.setJmeno(jmeno);
        osoba.setPrijmeni(prijmeni);
        osoba.setDatum_narozeni(datum_narozeni);
        return osoba;
  }
  
  @Override
  public String toString(){
      return jmeno+" "+prijmeni;
  }

    /**
     * @return the osoba_id
     */
    public Long getOsoba_id() {
        return osoba_id;
    }


    /**
     * @return the jmeno
     */
    public String getJmeno() {
        return jmeno;
    }

    /**
     * @param jmeno the jmeno to set
     */
    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    /**
     * @return the prijmeni
     */
    public String getPrijmeni() {
        return prijmeni;
    }

    /**
     * @param prijmeni the prijmeni to set
     */
    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    /**
     * @return the datum_narozeni
     */
    public Date getDatum_narozeni() {
        return datum_narozeni;
    }

    /**
     * @param datum_narozeni the datum_narozeni to set
     */
    public void setDatum_narozeni(Date datum_narozeni) {
        this.datum_narozeni = datum_narozeni;
    }

    /**
     * @return the tymy
     */
    public List<TymyHasOsoby> getTymy() {
        return tymy;
    }

    /**
     * @param tymy the tymy to set
     */
    public void setTymy(List<TymyHasOsoby> tymy) {
        this.tymy = tymy;
    }

    public Collection<OsobyHasStaje> getStaje() {
        return staje;
    }

    public void setStaje(Collection<OsobyHasStaje> staje) {
        this.staje = staje;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.osoba_id);
        hash = 37 * hash + Objects.hashCode(this.jmeno);
        hash = 37 * hash + Objects.hashCode(this.prijmeni);
        hash = 37 * hash + Objects.hashCode(this.datum_narozeni);
        hash = 37 * hash + Objects.hashCode(this.tymy);
        hash = 37 * hash + Objects.hashCode(this.staje);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Osoba other = (Osoba) obj;
        if (!Objects.equals(this.osoba_id, other.osoba_id)) {
            return false;
        }
        if (!Objects.equals(this.jmeno, other.jmeno)) {
            return false;
        }
        if (!Objects.equals(this.prijmeni, other.prijmeni)) {
            return false;
        }
        if (!Objects.equals(this.datum_narozeni, other.datum_narozeni)) {
            return false;
        }
        if (!Objects.equals(this.tymy, other.tymy)) {
            return false;
        }
        if (!Objects.equals(this.staje, other.staje)) {
            return false;
        }
        return true;
    }
 
}
