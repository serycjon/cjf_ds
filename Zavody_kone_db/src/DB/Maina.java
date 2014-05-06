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
//       Zavod za = Zavod.createZavod("Zavod, kdz je zatazeno", Date.valueOf("2014-03-05"), "doma");
//       Kategorie kat =Kategorie.createKategorie("VtipneSprezi", 5, 10);
        Tym tym = em.find(Tym.class, 3L);
        System.out.println("Finding kategorie "+tym);
       Zavody za = em.find(Zavody.class, 2L);
        Kategorie kat = em.find(Kategorie.class, 1L);
//        Tym tym2 = Tym.createTym("zkousimudelattym", za, kat);
////        Kun k = Kun.createKun("jak", "generovat", "id2");
//        System.out.println("tym "+tym2);
//         tx.begin();
//         em.persist(tym2);
//         tx.commit();
//        System.out.println("tym "+tym2);
//        
        
         
         
         
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
        TypedQuery queryO = em.createQuery("Select a from Zavody a", Zavody.class);
        List<Zavody> listO = queryO.getResultList();

        for (Iterator<Zavody> itT = listO.iterator(); itT.hasNext();){
            
            Zavody t = itT.next();
            System.out.println("###########");
            System.out.println(t.getNazev());
            System.out.println("###########");
            for (Iterator<Tym> itS = t.getCollTymy().iterator(); itS.hasNext();) {
                Tym store = itS.next();
                System.out.println(store.getNazev()+"\t\t");
            }
            System.out.println("-----------");
        }
    }
}
