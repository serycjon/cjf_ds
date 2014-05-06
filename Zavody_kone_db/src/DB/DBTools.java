/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DB;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Lada
 */
public class DBTools {
    private static DBTools instance;
    private static  EntityManagerFactory emf ;
    private static    EntityManager em ;
    private static EntityTransaction tx;
    
    private DBTools(){
         emf = Persistence.createEntityManagerFactory("Zavody_kone_dbPU");
          em = emf.createEntityManager();
          tx = em.getTransaction();
    }
    
public static DBTools getInstance() {
     //Je-li promenna instance null, tak se vytvori objekt
         if (instance == null) {
             instance = new DBTools();
         }
         //Vratime jedinacka
         return instance;
     }

    public  EntityManager getEm() {
        return em;
    }

    public  EntityTransaction getTx() {
        return tx;
    }

  

    
   
    
   
    
}
