/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Generovani;

import static Generovani.Generovani.randBetween;
import java.util.GregorianCalendar;
import java.util.Random;

/**
 *
 * @author Lada
 */
public class GenerovaniKone {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String kun;
        for (int i = 0; i < 10; i++) {
            kun = dejString()+","+dejString()+","+dejString();
            System.out.println(kun);
        }
    }
    private static String dejDatum() {
        GregorianCalendar gc = new GregorianCalendar();

        int year = randBetween(1900, 2010);

        gc.set(gc.YEAR, year);

        int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));

        gc.set(gc.DAY_OF_YEAR, dayOfYear);
        int  y=gc.get(gc.DAY_OF_MONTH);
        String ye;
       if(y<10){
            ye= "0"+y;
            if(y==0){
                y=1;
            }
            ye= "0"+y;
       }
       else{
          ye= ""+y; 
       }
       String me;
       int m=gc.get(gc.MONTH);
        if(m<10){
            if(m==0){
                m=1;
            }
            me= "0"+m;
       }
       else{
          me= ""+m; 
       }
        String stt=    gc.get(gc.YEAR) + "-" + me + "-" + ye;

       return stt;
    }
      private static String dejString() {
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
StringBuilder sb = new StringBuilder();
Random random = new Random();
for (int i = 0; i < 10; i++) {
    char c = chars[random.nextInt(chars.length)];
    sb.append(c);
}
String output = sb.toString();
//System.out.println(output);
return output;
    }
    
       public static int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }
}
