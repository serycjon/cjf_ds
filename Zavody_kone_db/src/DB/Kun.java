/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
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
@Table(name="kone")
public class Kun implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long kun_id;
     @Column(nullable=false, length=20)
     private String jmeno;
     @Column(nullable=false, length=50)
     private String plemeno;
     @Column(nullable=false, length=35)
     private String majitel;
     
     @OneToMany(mappedBy="kunn")
     private List<TymyHasKone> tymy;
     
     
     public static Kun createKun(String jmeno, String plemeno, String majitel){
         Kun kun = new Kun();
         kun.setJmeno(jmeno);
         kun.setMajitel(majitel);
         kun.setPlemeno(plemeno);
       
         return kun;
     }

    public Long getKun_id() {
        return kun_id;
    }

    public void setKun_id(Long kun_id) {
        this.kun_id = kun_id;
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.kun_id);
        hash = 67 * hash + Objects.hashCode(this.jmeno);
        hash = 67 * hash + Objects.hashCode(this.plemeno);
        hash = 67 * hash + Objects.hashCode(this.majitel);
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
        final Kun other = (Kun) obj;
        if (!Objects.equals(this.kun_id, other.kun_id)) {
            return false;
        }
        if (!Objects.equals(this.jmeno, other.jmeno)) {
            return false;
        }
        if (!Objects.equals(this.plemeno, other.plemeno)) {
            return false;
        }
        if (!Objects.equals(this.majitel, other.majitel)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Kun{" + "kun_id=" + kun_id + ", jmeno=" + jmeno + ", plemeno=" + plemeno + ", majitel=" + majitel + '}';
    }
  

  
    
}
