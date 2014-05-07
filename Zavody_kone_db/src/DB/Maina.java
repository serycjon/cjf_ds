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
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author jonas
 */
public class Maina {

    private static EntityManagerFactory emf ;
    private static EntityManager em ;
    private static EntityTransaction tx;

    
    public static void main(String[] args) {
        //Entity manager and transaction

//        EntityTransaction tx = em.getTransaction();

        em=DBTools.getInstance().getEm();
        tx=DBTools.getInstance().getTx();
        
//create new entity and persist it to the database
//         OsobyHasStaje st = OsobyHasStaje.createOsobyHasStaje(2, 1, Date.valueOf("1992-12-02"),Date.valueOf("1992-12-02"));
//       Zavod za = Zavod.createZavod("Zavod, kdz je zatazeno", Date.valueOf("2014-03-05"), "doma");
//       Kategorie kat =Kategorie.createKategorie("VtipneSprezi", 5, 10);
//       OsobyHasStaje book = OsobyHasStaje.createOsobyHasStaje(1L, 1L, Date.valueOf("2012-01-01"), Date.valueOf("2013-12-12"));
//tx.begin();
//em.persist(book);
//tx.commit();
        
        
        
        
        Tym tym = em.find(Tym.class, 3L);
        System.out.println("Finding kategorie " + tym);
        Zavody za = em.find(Zavody.class, 2L);
        Kategorie kat = em.find(Kategorie.class, 1L);
        Kun k1 = em.find(Kun.class, 1L);
        Osoba o1 = em.find(Osoba.class, 1L);
        System.out.println("-+++-+-+-+-+-");
        
        System.out.println(o1);
        Osoba o2 = em.find(Osoba.class, 2L);
        
        Tym tym2 = Tym.createTym("zkousimudelattym", kat);
        em.persist(tym2);
        
        tx.begin();
        System.out.println("TID: " + tym2.getTym_id());
        TymyHasKone thk = TymyHasKone.createTymMaKone(tym2.getTym_id(), k1.getKun_id());
        TymyHasOsoby tho1 = TymyHasOsoby.createTymMaOsobu(tym2.getTym_id(), 1L);
        tho1.setJe_jezdec(true);
        TymyHasOsoby tho2 = TymyHasOsoby.createTymMaOsobu(tym2.getTym_id(), 2L);
        System.out.println(tym2);
        tym2.setZavodId(za);
        tx.commit();
        //tx.begin();
        Query queryN = em.createNativeQuery("select prirad_startovni_cisla(?)");
        queryN.setParameter(1, 2);
        List<Object[]> listN = queryN.getResultList();
        for (Iterator<Object[]> itN = listN.iterator(); itN.hasNext();) {
            Object obj = itN.next();
            System.out.println(obj);
        }
        //tx.commit();

////        Kun k = Kun.createKun("jak", "generovat", "id2");
        System.out.println("tym " + tym2);
//         tx.begin();
//         em.persist(tym2);
//         tx.commit();
//        System.out.println("tym "+tym2);
//        

        TypedQuery queryS = em.createQuery("Select s from Tym s", Tym.class);
        List<Tym> listS = queryS.getResultList();

        for (Iterator<Tym> itT = listS.iterator(); itT.hasNext();) {

            Tym t = itT.next();
            System.out.println("###########");
            System.out.println(t.getNazev());
            System.out.println("###########");
            for (Iterator<TymyHasOsoby> itS = t.getOsoby().iterator(); itS.hasNext();) {
                TymyHasOsoby store = itS.next();
                System.out.println(store.getOsoba() + "\t\t" + (store.isJe_jezdec() ? "jezdec" : "prisedici"));
            }
            System.out.println("-----------");
        }

        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        TypedQuery queryO = em.createQuery("Select a from Zavody a", Zavody.class);
        List<Zavody> listO = queryO.getResultList();

        for (Iterator<Zavody> itT = listO.iterator(); itT.hasNext();) {

            Zavody t = itT.next();
            System.out.println("###########");
            System.out.println(t.getNazev());
            System.out.println("###########");
            for (Iterator<Tym> itS = t.getCollTymy().iterator(); itS.hasNext();) {
                Tym store = itS.next();
                System.out.println(store.getNazev() + "\t\t");
            }
            System.out.println("-----------");
        }
    }
}
