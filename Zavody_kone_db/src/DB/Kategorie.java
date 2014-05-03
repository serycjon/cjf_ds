/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Lada
 */
@Entity
@Table(name = "kategorie")
public class Kategorie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long kategorie_id;
    @Column(nullable = false, length = 20)
    private String nazev;
    private int pocet_koni;
    private int pocet_prisedicich;

    
    public static Kategorie createKategorie(String nazev, int pocet_koni, int pocet_prisedicich){
        Kategorie kategorie = new Kategorie();
        kategorie.setNazev(nazev);
        kategorie.setPocet_koni(pocet_koni);
        kategorie.setPocet_prisedicich(pocet_prisedicich);
        return kategorie;
    }
    
    public Long getKategorie_id() {
        return kategorie_id;
    }

    public void setKategorie_id(Long kategorie_id) {
        this.kategorie_id = kategorie_id;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public int getPocet_koni() {
        return pocet_koni;
    }

    public void setPocet_koni(int pocet_koni) {
        this.pocet_koni = pocet_koni;
    }

    public int getPocet_prisedicich() {
        return pocet_prisedicich;
    }

    public void setPocet_prisedicich(int pocet_prisedicich) {
        this.pocet_prisedicich = pocet_prisedicich;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.kategorie_id);
        hash = 83 * hash + Objects.hashCode(this.nazev);
        hash = 83 * hash + this.pocet_koni;
        hash = 83 * hash + this.pocet_prisedicich;
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
        final Kategorie other = (Kategorie) obj;
        if (!Objects.equals(this.kategorie_id, other.kategorie_id)) {
            return false;
        }
        if (!Objects.equals(this.nazev, other.nazev)) {
            return false;
        }
        if (this.pocet_koni != other.pocet_koni) {
            return false;
        }
        if (this.pocet_prisedicich != other.pocet_prisedicich) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Kategorie{" + "kategorie_id=" + kategorie_id + ", nazev=" + nazev + ", pocet_koni=" + pocet_koni + ", pocet_prisedicich=" + pocet_prisedicich + '}';
    }


}
