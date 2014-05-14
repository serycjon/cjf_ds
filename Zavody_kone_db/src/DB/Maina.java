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
import javax.persistence.criteria.CriteriaQuery;

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
        
//        tx.begin();
//        System.out.println("TID: " + tym2.getTym_id());
//        TymyHasKone thk = TymyHasKone.createTymMaKone(tym2.getTym_id(), k1.getKun_id());
//        TymyHasOsoby tho1 = TymyHasOsoby.createTymMaOsobu(tym2.getTym_id(), 1L);
//        tho1.setJe_jezdec(true);
//        TymyHasOsoby tho2 = TymyHasOsoby.createTymMaOsobu(tym2.getTym_id(), 2L);
//        System.out.println(tym2);
//        tym2.setZavodId(za);
//        tx.commit();
//        //tx.begin();
//        Query queryN = em.createNativeQuery("select prirad_startovni_cisla(?)");
//        queryN.setParameter(1, 2);
//        List<Object[]> listN = queryN.getResultList();
//        for (Iterator<Object[]> itN = listN.iterator(); itN.hasNext();) {
//            Object obj = itN.next();
//            System.out.println(obj);
//        }
//        //tx.commit();

////        Kun k = Kun.createKun("jak", "generovat", "id2");
        System.out.println("tym " + tym2);
//         tx.begin();
//         em.persist(tym2);
//         tx.commit();
//        System.out.println("tym "+tym2);
//        

        TypedQuery queryS = em.createQuery("Select s from Tym s", Tym.class);
        List<Tym> listS = queryS.getResultList();
        
        
        
        //dotaz na poradi tymu v zavode a kategorii
        //String sql = "SELECT *,cas_prvniho_kola+cas_druheho_kola+(penalizace_prvni_kolo+penalizace_druhe_kolo) AS cas FROM tymy WHERE zavod_id = ? AND kategorie_id= ? ORDER BY cas ASC; "; 
/*       
//upraveni predchoziho, abych mela i statictiu jezdcu
        String sql = "SELECT *,cas_prvniho_kola+cas_druheho_kola+(penalizace_prvni_kolo+penalizace_druhe_kolo) AS cas FROM tymy WHERE zavod_id = ? AND kategorie_id= ? ORDER BY cas ASC; "; 
        Query query = em.createNativeQuery(sql, Tym.class);
       query.setParameter(1,1);
       query.setParameter(2,1);
       List<Tym> lkat =  query.getResultList();
       
      for(Iterator<Tym> kkkt = lkat.iterator();kkkt.hasNext();){
          Tym kkk = kkkt.next();
          System.out.println("----------++");
          System.out.println(kkk.getNazev());
          int cas = kkk.getCas_prvniho_kola()+kkk.getCas_druheho_kola()+kkk.getPenalizace_prvni_kolo()+kkk.getPenalizace_druhe_kolo();
          System.out.println("cas: "+cas);
          System.out.println("------------++");
      }
     */  
      
//      String sql2 ="SELECT *  FROM  osoby  WHERE  ILIKE osoby\n" +
//"       JOIN tymy_has_osoby ON osoby.osoba_id=tymy_has_osoby.osoby_osoba_id \n" ;//+
         String hledaneSlovo= "%an%";
      String sql2 = "select * from osoby where jmeno ilike ?";// or prijmeni ilike '%?%' or datum_narozeni::text like '%?%'";
//"      JOIN tymy ON tymy_has_osoby.tymy_tym_id=tymy.tym_id\n" +
//"      WHERE tymy_has_osoby.je_jezdec=true AND tymy.kategorie_id=1 AND --tymy.dojel=true;\n" +
//"      ORDER BY tymy.cas_prvniho_kola+tymy.cas_druheho_kola+(tymy.penalizace_prvni_kolo+tymy.penalizace_druhe_kolo) ASC";
      Query query2 = em.createNativeQuery(sql2, Osoba.class);
     
      query2.setParameter(1,hledaneSlovo);
//      query2.setParameter(2,hledaneSlovo);
//      query2.setParameter(3,hledaneSlovo);
        System.out.println("qv"+query2.toString());
      List<Osoba> oslistik =  query2.getResultList();
      for(Iterator<Osoba> osobla  = oslistik.iterator();osobla.hasNext();){
          Osoba os = osobla.next();
          System.out.println("----------++");
          System.out.println(os.getJmeno());
          System.out.println("------------++");
      }
//        for (Iterator<Tym> itT = listS.iterator(); itT.hasNext();) {
//
//            Tym t = itT.next();
//            System.out.println("###########");
//            System.out.println(t.getNazev());
//            System.out.println("###########");
//            for (Iterator<TymyHasOsoby> itS = t.getOsoby().iterator(); itS.hasNext();) {
//                TymyHasOsoby store = itS.next();
//                System.out.println(store.getOsoba() + "\t\t" + (store.isJe_jezdec() ? "jezdec" : "prisedici"));
//            }
//            System.out.println("-----------");
//        }
//
//        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
//        TypedQuery queryO = em.createQuery("Select a from Zavody a", Zavody.class);
//        List<Zavody> listO = queryO.getResultList();
//
//        for (Iterator<Zavody> itT = listO.iterator(); itT.hasNext();) {
//
//            Zavody t = itT.next();
//            System.out.println("###########");
//            System.out.println(t.getNazev());
//            System.out.println("###########");
//            for (Iterator<Tym> itS = t.getCollTymy().iterator(); itS.hasNext();) {
//                Tym store = itS.next();
//                System.out.println(store.getNazev() + "\t\t");
//            }
//            System.out.println("-----------");
//        }
    }
}
