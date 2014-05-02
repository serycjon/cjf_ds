/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DB;

import java.io.Serializable;
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
  private long tymy_tym_id;
  @Id
  private long osoby_osoba_id;
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
}