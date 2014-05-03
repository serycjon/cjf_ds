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

/**
 *
 * @author Lada
 */

public class TymyHasKoneID implements Serializable {
    private Long tymy_tym_id;
    private Long kone_kun_id;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + Objects.hashCode(this.tymy_tym_id);
        hash = 11 * hash + Objects.hashCode(this.kone_kun_id);
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
        final TymyHasKoneID other = (TymyHasKoneID) obj;
        if (!Objects.equals(this.tymy_tym_id, other.tymy_tym_id)) {
            return false;
        }
        if (!Objects.equals(this.kone_kun_id, other.kone_kun_id)) {
            return false;
        }
        return true;
    }
    

    
    
}
