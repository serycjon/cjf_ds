/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pok2;

import Entity.Osoby;
import java.awt.print.Book;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Lada
 */
public class mainSpusteni {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Entity manager and transaction
EntityManagerFactory emf = Persistence.createEntityManagerFactory("PokusJPAPU");
//EntityManager em = Persistence.createEntityManagerFactory("PokusJPAPU").createEntityManager();
EntityManager em = emf.createEntityManager();
EntityTransaction tx = em.getTransaction();

Osoby booka = em.find(Osoby.class, 14);
System.out.println("Finding book> "+booka.getOsobyHasStajeCollection());

//create new entity and persist it to the database
//Osoby osoby = new Osoby( "Adam2", "Horacek2", new Date(1588, 2, 9));
//tx.begin();
//em.persist(osoby);
//tx.commit();


    }
}
