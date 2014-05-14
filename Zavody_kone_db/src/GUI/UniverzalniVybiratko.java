/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DB.DBTools;
import DB.Kun;
import DB.Osoba;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.Iterator;
import java.util.List;
import javax.persistence.Query;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

/**
 *
 * @author jonas
 */
public class UniverzalniVybiratko extends javax.swing.JDialog {

    public static final int TYP_KUN = 1;
    public static final int TYP_OSOBA = 2;
    private int typ;
    private Long result;

    /**
     * Creates new form UniverzalniVybiratko
     */
    public UniverzalniVybiratko(java.awt.Frame parent, boolean modal, int typ_okna) {
        super(parent, modal);
        typ = typ_okna;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings({"unchecked", "empty-statement"})
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//BLOKOVANE-GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        jTextField1.setText("");

        jButton1.setText("Hledat");
        String[][] data = new String[0][4];
        
        if (typ == TYP_KUN) {
            columnNames[0] = "hidden Id";
            columnNames[1] = "Jméno";
            columnNames[2] = "Plemeno";
            columnNames[3] = "Majitel";
        } else {
            columnNames[0] = "hidden Id";
            columnNames[1] = "Jméno";
            columnNames[2] = "Příjmení";
            columnNames[3] = "Datum narození";
        }

        jButton1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                TableModel nastaveniTabulky;
                if(typ==TYP_KUN){
                    nastaveniTabulky=nastavTAbulceHledaniHodnotyKoni(jTextField1);
                }else{
                    nastaveniTabulky=nastavTAbulceHledaniHodnotyOsob(jTextField1);
                }
                
                jTable1.setModel(nastaveniTabulky);
                TableColumnModel cm = jTable1.getColumnModel();
                TableColumn id_column = cm.getColumn(0);
                cm.removeColumn(id_column);
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            
        });

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        jTable1.setModel(model);
        
        TableColumnModel cm = jTable1.getColumnModel();
        TableColumn id_column = cm.getColumn(0);
        cm.removeColumn(id_column);
        jScrollPane1.setViewportView(jTable1);

        jButton2.setText("Vybrat");
        jButton2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int vybranyRadek = jTable1.getSelectedRow();
                if(vybranyRadek<0){
                    System.out.println("Nebzlo vybrano zadne pole");
                }else{
                System.out.println("Vybrany radek: "+vybranyRadek);
                    System.out.println(jTable1.getModel().getValueAt(vybranyRadek, 1));
                    result=(Long)jTable1.getModel().getValueAt(vybranyRadek, 0);
                    UniverzalniVybiratko.this.dispose();
                }
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        jButton3.setText("Storno");
        jButton3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                result=null;
                 UniverzalniVybiratko.this.dispose();
                System.out.println("zavrit a nevratit nic...");
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        if (typ == TYP_KUN) {
            jLabel1.setText("Výběr kone");
        } else {
            jLabel1.setText("Výběr osoby");
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addGap(82, 82, 82))
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jButton1))
                                                .addComponent(jLabel1))
                                        .addGap(0, 131, Short.MAX_VALUE)))
                        .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton2)
                                .addComponent(jButton3))
                        .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UniverzalniVybiratko.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UniverzalniVybiratko.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UniverzalniVybiratko.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UniverzalniVybiratko.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UniverzalniVybiratko dialog = new UniverzalniVybiratko(new javax.swing.JFrame(), true, TYP_OSOBA);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    private TableModel nastavTAbulceHledaniHodnotyOsob(JTextField jTextField1) {
       String hledaneSlovo = "%" + jTextField1.getText() + "%";
                String sql2 = "select * from osoby where jmeno ilike ? or prijmeni ilike ? or datum_narozeni::text like ?";
                Query query2 = DBTools.getInstance().getEm().createNativeQuery(sql2, Osoba.class);
                query2.setParameter(1, hledaneSlovo);
                query2.setParameter(2, hledaneSlovo);
                query2.setParameter(3, hledaneSlovo);
                List<Osoba> oslistik = query2.getResultList();
                Object[][] NovaData = new Object[oslistik.size()][6];
                for (int i = 0; i < oslistik.size(); i++) {
                    NovaData[i][0] = oslistik.get(i).getOsoba_id();
                    NovaData[i][1] = oslistik.get(i).getJmeno();
                    NovaData[i][2] = oslistik.get(i).getPrijmeni();
                    NovaData[i][3] = oslistik.get(i).getDatum_narozeni();

                }
                TableModel table= new DefaultTableModel(NovaData, columnNames);
                return table;
    }
     private TableModel nastavTAbulceHledaniHodnotyKoni(JTextField jTextField1) {
       String hledaneSlovo = "%" + jTextField1.getText() + "%";
                String sql2 = "select * from kone where jmeno ilike ? or plemeno ilike ? or majitel ilike ?";
                Query query2 = DBTools.getInstance().getEm().createNativeQuery(sql2, Kun.class);
                query2.setParameter(1, hledaneSlovo);
                query2.setParameter(2, hledaneSlovo);
                query2.setParameter(3, hledaneSlovo);
                List<Kun> oslistik = query2.getResultList();
                Object[][] NovaData = new Object[oslistik.size()][6];
                for (int i = 0; i < oslistik.size(); i++) {
                    NovaData[i][0] = oslistik.get(i).getKun_id();
                    NovaData[i][1] = oslistik.get(i).getJmeno();
                    NovaData[i][2] = oslistik.get(i).getPlemeno();
                    NovaData[i][3] = oslistik.get(i).getMajitel();
                }
                TableModel table= new DefaultTableModel(NovaData, columnNames);
                return table;
    }
     public Long showDialog(){
         setVisible(true);
         return result;
     }
    // Variables declaration - do not modify//BLOKOVANE-GEN-BEGIN:variables
    private String[] columnNames = new String[4];
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration                   
}
