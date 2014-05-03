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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.postgresql.util.PGInterval;

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
//  private  PGInterval cas_prvniho_Kola;
//  private PGInterval cas_druheho_Kola;
  private int penalizace_prvni_kolo;
  private int penalizace_druhe_kolo;
  private boolean dojel;
  
 
  @ManyToOne
  @JoinColumn(name = "kategorie_id", referencedColumnName = "kategorie_id")
  private Kategorie kategorieId;
  
   @ManyToOne
  @JoinColumn(name = "zavod_id", referencedColumnName = "zavod_id")
  private Zavody zavodId;
  
  @OneToMany(mappedBy="tym")
  private List<TymyHasOsoby> osoby;
  
  @OneToMany(mappedBy="tym")
  private List<TymyHasKone> kone;

    /*@ManyToMany
    @JoinTable(
    name="tymy_has_osoby",
    joinColumns={@JoinColumn(name="tymy_tym_id", referencedColumnName="tym_id")},
    inverseJoinColumns={@JoinColumn(name="osoby_osoba_id", referencedColumnName="osoba_id")})
    private List<Osoba> osoby;
     */
   
    public int getPenalizace_prvni_kolo() {
        return penalizace_prvni_kolo;
    }

    public void setPenalizace_prvni_kolo(int penalizace_prvni_kolo) {
        this.penalizace_prvni_kolo = penalizace_prvni_kolo;
    }

    public int getPenalizace_druhe_kolo() {
        return penalizace_druhe_kolo;
    }

    public void setPenalizace_druhe_kolo(int penalizace_druhe_kolo) {
        this.penalizace_druhe_kolo = penalizace_druhe_kolo;
    }

    public List<TymyHasKone> getKone() {
        return kone;
    }

    public void setKone(List<TymyHasKone> kone) {
        this.kone = kone;
    }

    public Kategorie getKategorieId() {
        return kategorieId;
    }

    public void setKategorieId(Kategorie kategorieId) {
        this.kategorieId = kategorieId;
    }

    public Zavody getZavodId() {
        return zavodId;
    }

    public void setZavodId(Zavody zavodId) {
        this.zavodId = zavodId;
    }

  

   

    public boolean isDojel() {
        return dojel;
    }

    public void setDojel(boolean dojel) {
        this.dojel = dojel;
    }


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
