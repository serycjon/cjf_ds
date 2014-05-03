/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Lada
 */
@Entity
@Table(name = "zavod_has_kategorie")
@IdClass(ZavodHasKategorieID.class)
public class ZavodHasKategorie implements Serializable {

    @Id
    private Long zavod_zavod_id;
    @Id
    private Long kategorie_kategorie_id;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "zavod_zavod_id", referencedColumnName = "zavod_id")
    private Zavody zavody;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "kategorie_kategorie_id", referencedColumnName = "kategorie_id")
    private Kategorie kategorie;

    public Zavody getZavody() {
        return zavody;
    }

    public void setZavody(Zavody zavody) {
        this.zavody = zavody;
    }

    public Zavody getZavod() {
        return zavody;
    }

    public void setZavod(Zavody zavod) {
        this.zavody = zavod;
    }

    public Kategorie getKategorie() {
        return kategorie;
    }

    public void setKategorie(Kategorie kategorie) {
        this.kategorie = kategorie;
    }

    public Long getZavod_zavod_id() {
        return zavod_zavod_id;
    }

    public void setZavod_zavod_id(Long zavod_zavod_id) {
        this.zavod_zavod_id = zavod_zavod_id;
    }

    public Long getKategorie_kategorie_id() {
        return kategorie_kategorie_id;
    }

    public void setKategorie_kategorie_id(Long kategorie_kategorie_id) {
        this.kategorie_kategorie_id = kategorie_kategorie_id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.zavod_zavod_id);
        hash = 97 * hash + Objects.hashCode(this.kategorie_kategorie_id);
        hash = 97 * hash + Objects.hashCode(this.zavody);
        hash = 97 * hash + Objects.hashCode(this.kategorie);
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
        final ZavodHasKategorie other = (ZavodHasKategorie) obj;
        if (!Objects.equals(this.zavod_zavod_id, other.zavod_zavod_id)) {
            return false;
        }
        if (!Objects.equals(this.kategorie_kategorie_id, other.kategorie_kategorie_id)) {
            return false;
        }
        if (!Objects.equals(this.zavody, other.zavody)) {
            return false;
        }
        if (!Objects.equals(this.kategorie, other.kategorie)) {
            return false;
        }
        return true;
    }
    
}
