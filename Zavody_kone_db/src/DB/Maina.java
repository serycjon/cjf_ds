/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author jonas
 */
public class Maina {

    public static void main(String[] args) {
        //Entity manager and transaction
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Zavody_kone_dbPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

//create new entity and persist it to the database
/*
         Osoba os = Osoba.createOsoba("Jon", "Serych", Date.valueOf("1992-12-02"));
         tx.begin();
         em.persist(os);
         tx.commit();
         */
        TypedQuery queryS = em.createQuery("Select s from Tym s", Tym.class);
        List<Tym> listS = queryS.getResultList();

        for (Iterator<Tym> itT = listS.iterator(); itT.hasNext();){
            
            Tym t = itT.next();
            System.out.println("###########");
            System.out.println(t.getNazev());
            System.out.println("###########");
            for (Iterator<TymyHasOsoby> itS = t.getOsoby().iterator(); itS.hasNext();) {
                TymyHasOsoby store = itS.next();
                System.out.println(store.getOsoba()+"\t\t"+(store.isJe_jezdec()?"jezdec":"prisedici"));
            }
            System.out.println("-----------");
        }
        
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        TypedQuery queryO = em.createQuery("Select s from Osoba s", Osoba.class);
        List<Osoba> listO = queryO.getResultList();

        for (Iterator<Osoba> itT = listO.iterator(); itT.hasNext();){
            
            Osoba t = itT.next();
            System.out.println("###########");
            System.out.println(t.getJmeno());
            System.out.println("###########");
            for (Iterator<TymyHasOsoby> itS = t.getTymy().iterator(); itS.hasNext();) {
                TymyHasOsoby store = itS.next();
                System.out.println(store.getTym().getNazev()+"\t\t");
            }
            System.out.println("-----------");
        }
    }
}
