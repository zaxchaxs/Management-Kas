/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package BASE;

import DataModels.KasReport;
import Database.DatabaseInstance;
import java.util.ArrayList;

/**
 *
 * @author 23106
 */
public class Frame_JumlahSaldo extends javax.swing.JFrame {

    ArrayList<KasReport> listReportKas;
    DatabaseInstance db;
    private double totalAmount;
    
    public Frame_JumlahSaldo() {
        initComponents();
        setLocationRelativeTo(null);
        db = new DatabaseInstance();
        listReportKas = db.getKasReport().data;
        calculateKas();
        setTitle("Manajemen Kas Kelas By 3E Informatika Unsika");
    }

    public void calculateKas() {
        double income = 0.0;
        double expanse = 0.0;
        
        for(KasReport report: listReportKas) {
            if(report.type.equals("income")) {
                income+= report.income;
            } else if(report.type.equals("expanse")) {
                expanse += report.expanse;
            }
        };
        
        totalAmount = income - expanse;
    };
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnHITUNG = new javax.swing.JButton();
        btnLOGOUT = new javax.swing.JButton();
        total = new javax.swing.JLabel();
        LabelJumlahSaldo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnHITUNG.setBackground(new java.awt.Color(141, 80, 199));
        btnHITUNG.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        btnHITUNG.setText("HITUNG");
        btnHITUNG.setBorder(null);
        btnHITUNG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHITUNGActionPerformed(evt);
            }
        });
        getContentPane().add(btnHITUNG, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 510, 110, 50));

        btnLOGOUT.setBackground(new java.awt.Color(0, 0, 204));
        btnLOGOUT.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnLOGOUT.setForeground(new java.awt.Color(255, 255, 255));
        btnLOGOUT.setText("KEMBALI");
        btnLOGOUT.setBorder(new javax.swing.border.MatteBorder(null));
        btnLOGOUT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLOGOUTActionPerformed(evt);
            }
        });
        getContentPane().add(btnLOGOUT, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 510, 150, 50));

        total.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        total.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        total.setText("Klik hitung untuk melihat jumlah kas");
        getContentPane().add(total, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 710, 90));

        LabelJumlahSaldo.setBackground(new java.awt.Color(141, 80, 199));
        LabelJumlahSaldo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI_componen_asset/jumlah saldo.png"))); // NOI18N
        getContentPane().add(LabelJumlahSaldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 1040, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHITUNGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHITUNGActionPerformed
        total.setText("RP. " + totalAmount);
    }//GEN-LAST:event_btnHITUNGActionPerformed

    private void btnLOGOUTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLOGOUTActionPerformed
        new Frame_MenuUtama().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnLOGOUTActionPerformed

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
            java.util.logging.Logger.getLogger(Frame_JumlahSaldo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame_JumlahSaldo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame_JumlahSaldo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame_JumlahSaldo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame_JumlahSaldo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelJumlahSaldo;
    private javax.swing.JButton btnHITUNG;
    private javax.swing.JButton btnLOGOUT;
    private javax.swing.JLabel total;
    // End of variables declaration//GEN-END:variables
}
