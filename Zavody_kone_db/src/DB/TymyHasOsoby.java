/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DB;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author jonas
 */

@Entity
@Table(name="tymy_has_osoby")
@IdClass(TymyHasOsoby_ID.class)
public class TymyHasOsoby implements Serializable{
  @Id
  private Long tymy_tym_id;
  @Id
  private Long osoby_osoba_id;
  private boolean je_jezdec;
  @ManyToOne
  @PrimaryKeyJoinColumn(name="tymy_tym_id", referencedColumnName="tym_id")
  /* if this JPA model doesn't create a table for the "PROJ_EMP" entity,
  *  please comment out the @PrimaryKeyJoinColumn, and use the ff:
  *  @JoinColumn(name = "employeeId", updatable = false, insertable = false)
  * or @JoinColumn(name = "employeeId", updatable = false, insertable = false, referencedColumnName = "id")
  */
  private Tym tym;
  @ManyToOne
  @PrimaryKeyJoinColumn(name="osoby_osoba_id", referencedColumnName="osoba_id")
  /* the same goes here:
  *  if this JPA model doesn't create a table for the "PROJ_EMP" entity,
  *  please comment out the @PrimaryKeyJoinColumn, and use the ff:
  *  @JoinColumn(name = "projectId", updatable = false, insertable = false)
  * or @JoinColumn(name = "projectId", updatable = false, insertable = false, referencedColumnName = "id")
  */
  private Osoba osoba;
  
  public static TymyHasOsoby createTymMaOsobu(Long tym_id,Long osoba_id){
      TymyHasOsoby tho = new TymyHasOsoby();
      tho.setTymy_tym_id(tym_id);
      tho.setOsoby_osoba_id(osoba_id);
      return tho;
  }

    /**
     * @return the je_jezdec
     */
    public boolean isJe_jezdec() {
        return je_jezdec;
    }

    /**
     * @param je_jezdec the je_jezdec to set
     */
    public void setJe_jezdec(boolean je_jezdec) {
        this.je_jezdec = je_jezdec;
    }

    /**
     * @return the tym
     */
    public Tym getTym() {
        return tym;
    }

    /**
     * @param tym the tym to set
     */
    public void setTym(Tym tym) {
        this.tym = tym;
    }

    /**
     * @return the osoba
     */
    public Osoba getOsoba() {
        return osoba;
    }

    /**
     * @param osoba the osoba to set
     */
    public void setOsoba(Osoba osoba) {
        this.osoba = osoba;
    }

    public long getTymy_tym_id() {
        return tymy_tym_id;
    }

    public void setTymy_tym_id(long tymy_tym_id) {
        this.tymy_tym_id = tymy_tym_id;
    }

    public long getOsoby_osoba_id() {
        return osoby_osoba_id;
    }

    public void setOsoby_osoba_id(long osoby_osoba_id) {
        this.osoby_osoba_id = osoby_osoba_id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (int) (this.tymy_tym_id ^ (this.tymy_tym_id >>> 32));
        hash = 89 * hash + (int) (this.osoby_osoba_id ^ (this.osoby_osoba_id >>> 32));
        hash = 89 * hash + (this.je_jezdec ? 1 : 0);
        hash = 89 * hash + Objects.hashCode(this.tym);
        hash = 89 * hash + Objects.hashCode(this.osoba);
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
        final TymyHasOsoby other = (TymyHasOsoby) obj;
        if (this.tymy_tym_id != other.tymy_tym_id) {
            return false;
        }
        if (this.osoby_osoba_id != other.osoby_osoba_id) {
            return false;
        }
        if (this.je_jezdec != other.je_jezdec) {
            return false;
        }
        if (!Objects.equals(this.tym, other.tym)) {
            return false;
        }
        if (!Objects.equals(this.osoba, other.osoba)) {
            return false;
        }
        return true;
    }
    
}
