/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DB;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Lada
 */
public class DBTools {
    private EntityManager em;
    
    public boolean connect() {
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("Zavody_kone_dbPU");
        EntityManager em = emf.createEntityManager();
        return em.isOpen();
    }
    
}
