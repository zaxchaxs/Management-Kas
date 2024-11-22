/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package BASE;

import DataModels.KasReport;
import Database.DatabaseInstance;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 23106
 */
public class Frame_RekapMahasiswaDetail extends javax.swing.JFrame {

    ArrayList<KasReport> listReportKas;
    DefaultTableModel reportKasTable;
    String nim;
    
    DatabaseInstance db;
    
    public Frame_RekapMahasiswaDetail(String nim) {
        this.nim = nim;
        initComponents();
        setLocationRelativeTo(null);
        db = new DatabaseInstance();
        getReport();
        setTitle("Manajemen Kas Kelas By 3E Informatika Unsika");
    }
    
    public void getReport() {
        listReportKas = db.getKasReportDetail(nim).data;
        showDataTable();
    }

    public void showDataTable(){
        String[] headerTableColumns = {"ID", "Tanggal", "Perihal", "Pemasukkan", "Pengeluaran", "Keterangan"};
        Object[][] listReportKasValue = new Object[listReportKas.size()][headerTableColumns.length];
        int i = 0;
        
        for(KasReport report: listReportKas ) {
            String reportData[] = {report.id+"", report.date, report.name, report.income+"", report.expanse+"", report.desc};
            listReportKasValue[i] = reportData;
            i++;
        };
        
        
        reportKasTable = new DefaultTableModel(listReportKasValue, headerTableColumns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            };        
        };
        
        tableREKAPMAHASISWA.setModel(reportKasTable);
    };    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableREKAPMAHASISWA = new javax.swing.JTable();
        btnBACK = new javax.swing.JButton();
        mhsName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(822, 529));
        setPreferredSize(new java.awt.Dimension(822, 529));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableREKAPMAHASISWA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tanggal", "Perihal", "Pemasukkan", "Pengeluaran", "Keterangan"
            }
        ));
        jScrollPane1.setViewportView(tableREKAPMAHASISWA);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 730, 270));

        btnBACK.setBackground(new java.awt.Color(51, 255, 204));
        btnBACK.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        btnBACK.setText("BACK");
        btnBACK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBACKActionPerformed(evt);
            }
        });
        getContentPane().add(btnBACK, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 400, 110, 40));

        mhsName.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        mhsName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mhsName.setText("Nama Mahasiswa");
        getContentPane().add(mhsName, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, 260, 70));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBACKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBACKActionPerformed
        
        dispose();
    }//GEN-LAST:event_btnBACKActionPerformed

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
            java.util.logging.Logger.getLogger(Frame_RekapMahasiswaDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame_RekapMahasiswaDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame_RekapMahasiswaDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame_RekapMahasiswaDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame_RekapMahasiswaDetail("Default Nim").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBACK;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel mhsName;
    private javax.swing.JTable tableREKAPMAHASISWA;
    // End of variables declaration//GEN-END:variables
}
