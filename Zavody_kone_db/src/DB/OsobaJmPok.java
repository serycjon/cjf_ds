/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DB;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Lada
 */
@Entity
public class OsobaJmPok implements Serializable {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     
    private Long osoba_id;
    private String jmeno; 

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    

   
    
}
