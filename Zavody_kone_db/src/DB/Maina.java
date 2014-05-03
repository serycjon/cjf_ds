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

//         OsobyHasStaje st = OsobyHasStaje.createOsobyHasStaje(2, 1, Date.valueOf("1992-12-02"),Date.valueOf("1992-12-02"));
        Zavod za = Zavod.createZavod("Zavod, kdz je zatazeno", Date.valueOf("2014-03-05"), "doma");
         tx.begin();
         em.persist(za);
         tx.commit();
 
        
        
         
         
         
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
            for (Iterator<OsobyHasStaje> itS = t.getStaje().iterator(); itS.hasNext();) {
                OsobyHasStaje store = itS.next();
                System.out.println(store.getStaj().getJmeno()+"\t\t");
            }
            System.out.println("-----------");
        }
    }
}
