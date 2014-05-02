/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DB;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author jonas
 */
@Entity
@Table(name="tymy")
public class Tym implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long tym_id;
  @Column(nullable=false, length=50)
  private String nazev;
  private Integer startovni_cislo;
   @OneToMany(mappedBy="tym")
  private List<TymyHasOsoby> osoby;
 /*@ManyToMany
  @JoinTable(
      name="tymy_has_osoby",
      joinColumns={@JoinColumn(name="tymy_tym_id", referencedColumnName="tym_id")},
      inverseJoinColumns={@JoinColumn(name="osoby_osoba_id", referencedColumnName="osoba_id")})
  private List<Osoba> osoby;
  */

    /**
     * @return the tym_id
     */
    public Long getTym_id() {
        return tym_id;
    }

    /**
     * @param tym_id the tym_id to set
     */
    public void setTym_id(Long tym_id) {
        this.tym_id = tym_id;
    }

    /**
     * @return the nazev
     */
    public String getNazev() {
        return nazev;
    }

    /**
     * @param nazev the nazev to set
     */
    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    /**
     * @return the startovni_cislo
     */
    public Integer getStartovni_cislo() {
        return startovni_cislo;
    }

    /**
     * @param startovni_cislo the startovni_cislo to set
     */
    public void setStartovni_cislo(Integer startovni_cislo) {
        this.startovni_cislo = startovni_cislo;
    }

    /**
     * @return the osoby
     */
    public List<TymyHasOsoby> getOsoby() {
        return osoby;
    }

    /**
     * @param osoby the osoby to set
     */
    public void setOsoby(List<TymyHasOsoby> osoby) {
        this.osoby = osoby;
    }
}
