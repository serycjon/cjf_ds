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
@Table(name="tymy_has_kone")
@IdClass(TymyHasKoneID.class)
public class TymyHasKone implements Serializable {
    @Id
    private Long tymy_tym_id;
    @Id
    private Long kone_kun_id;

    @ManyToOne
   @PrimaryKeyJoinColumn(name="kone_kun_id", referencedColumnName="kun_id")
   private Kun kunn; 
    
    @ManyToOne
    @PrimaryKeyJoinColumn(name="tymy_tym_id", referencedColumnName="tym_id")
    private Tym tym;
//    
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.tymy_tym_id);
        hash = 29 * hash + Objects.hashCode(this.kone_kun_id);
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
        final TymyHasKone other = (TymyHasKone) obj;
        if (!Objects.equals(this.tymy_tym_id, other.tymy_tym_id)) {
            return false;
        }
        if (!Objects.equals(this.kone_kun_id, other.kone_kun_id)) {
            return false;
        }
        return true;
    }

    

   
    
}
