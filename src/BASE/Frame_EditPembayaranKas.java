/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package BASE;

import DataModels.KasReport;
import DataModels.Mahasiswa;
import Database.DatabaseInstance;
import Database.DatabaseResultResponse;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 23106
 */
public class Frame_EditPembayaranKas extends javax.swing.JFrame {

    ArrayList<KasReport> listReportKas;
    private int id;
    
    DatabaseInstance db;
    public Frame_EditPembayaranKas(int id) {
        this.id = id;
        initComponents();
        setLocationRelativeTo(null);
        db = new DatabaseInstance();
        listReportKas = db.getKasReportDetail(id).data;
        setTitle("Manajemen Kas Kelas By 3E Informatika Unsika");
        
        txtDate.setText(listReportKas.getFirst().date);
        txtKETERANGAN.setText(listReportKas.getFirst().desc);
        txtNAMA.setText(listReportKas.getFirst().name);
        txtPEMASUKAN.setText(listReportKas.getFirst().income+"");
        txtPENGELUARAN.setText(listReportKas.getFirst().expanse+"");
    };
    
    public void clearField() {
        txtNAMA.setText("");
        txtDate.setText("");
        txtKETERANGAN.setText("");
        txtPEMASUKAN.setText("0");
        txtPENGELUARAN.setText("0");
    };
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnKEMBALI = new javax.swing.JButton();
        btnSIMPAN = new javax.swing.JButton();
        txtKETERANGAN = new javax.swing.JTextField();
        radiobuttonPEMASUKAN = new javax.swing.JRadioButton();
        radiobuttonPENGELUARAN = new javax.swing.JRadioButton();
        txtNAMA = new javax.swing.JTextField();
        txtDate = new javax.swing.JTextField();
        txtPEMASUKAN = new javax.swing.JTextField();
        txtPENGELUARAN = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(895, 394));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnKEMBALI.setBackground(new java.awt.Color(218, 218, 218));
        btnKEMBALI.setFont(new java.awt.Font("Sylfaen", 1, 22)); // NOI18N
        btnKEMBALI.setText("KEMBALI");
        btnKEMBALI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKEMBALIActionPerformed(evt);
            }
        });
        getContentPane().add(btnKEMBALI, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 270, 150, 50));

        btnSIMPAN.setBackground(new java.awt.Color(218, 218, 218));
        btnSIMPAN.setFont(new java.awt.Font("Sylfaen", 1, 22)); // NOI18N
        btnSIMPAN.setText("SIMPAN");
        btnSIMPAN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSIMPANActionPerformed(evt);
            }
        });
        getContentPane().add(btnSIMPAN, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 270, 150, 50));

        txtKETERANGAN.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtKETERANGAN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKETERANGANActionPerformed(evt);
            }
        });
        getContentPane().add(txtKETERANGAN, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 260, 40));

        radiobuttonPEMASUKAN.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        radiobuttonPEMASUKAN.setText("PEMASUKAN");
        radiobuttonPEMASUKAN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiobuttonPEMASUKANActionPerformed(evt);
            }
        });
        getContentPane().add(radiobuttonPEMASUKAN, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, 110, 40));

        radiobuttonPENGELUARAN.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        radiobuttonPENGELUARAN.setText("PENGELUARAN");
        radiobuttonPENGELUARAN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiobuttonPENGELUARANActionPerformed(evt);
            }
        });
        getContentPane().add(radiobuttonPENGELUARAN, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, -1, -1));

        txtNAMA.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtNAMA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNAMAActionPerformed(evt);
            }
        });
        getContentPane().add(txtNAMA, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 260, 40));

        txtDate.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        getContentPane().add(txtDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 260, 40));

        txtPEMASUKAN.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtPEMASUKAN.setText("0");
        txtPEMASUKAN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPEMASUKANActionPerformed(evt);
            }
        });
        getContentPane().add(txtPEMASUKAN, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 70, 240, 40));

        txtPENGELUARAN.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtPENGELUARAN.setText("0");
        getContentPane().add(txtPENGELUARAN, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 130, 240, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNAMAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNAMAActionPerformed

    }//GEN-LAST:event_txtNAMAActionPerformed

    private void txtPEMASUKANActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPEMASUKANActionPerformed
        
    }//GEN-LAST:event_txtPEMASUKANActionPerformed

    private void txtKETERANGANActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKETERANGANActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKETERANGANActionPerformed

    private void btnKEMBALIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKEMBALIActionPerformed
        new Frame_PembayaranKas().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnKEMBALIActionPerformed

    private void btnSIMPANActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSIMPANActionPerformed
        String date = txtDate.getText();
        String name = txtNAMA.getText();
        String desc = txtKETERANGAN.getText();
        boolean income = radiobuttonPEMASUKAN.isSelected();
        boolean expanse = radiobuttonPENGELUARAN.isSelected();
        double incomeAmount;
        double expanseAmount;
        
        if(date.equals("") || name.equals("")) {
           JOptionPane.showMessageDialog(this, "Tolong masukkan data dengan benar!");
           return;
        };
        
        try {
            LocalDate LocalPaymentDate = LocalDate.parse(date);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Tolong masukkan tanggal\n Dengan format YYYY-MM-DD!");
            return;
        };
       
        if(income && expanse) {
            JOptionPane.showMessageDialog(this, "Tolong pilih antara\npemasukan atau pengeluaran!");
            return;
        };
        
        if(!income && !expanse) {
            JOptionPane.showMessageDialog(this, "Tolong pilih antara\npemasukan atau pengeluaran!");
            return;
        };

        if(income) {
            try {
                incomeAmount = Double.parseDouble(txtPEMASUKAN.getText());
                if(incomeAmount <= 0) {
                    throw new Exception();
                };
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Masukkan pemasukkan dengan benar!");
                return;
            };
            
            try {
                DatabaseResultResponse response = db.updateReportKas(id, date, name, incomeAmount, 0, desc, "income");
                if(response.status == 200) {
                    JOptionPane.showMessageDialog(this, response.message);
                    clearField();
                    new Frame_PembayaranKas().setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Gagal Mengupdate Pembayaran Kas");
                }
            } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, e.getMessage());
            }
        };
        
        if(expanse) {
            try {
                expanseAmount = Double.parseDouble(txtPENGELUARAN.getText());
                if(expanseAmount <= 0) {
                    throw new Exception();
                };
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Masukkan pengeluaran dengan benar!");
                return;
            };
            
            try {
                DatabaseResultResponse response = db.updateReportKas(id, date, name, 0, expanseAmount, desc, "expanse");
                if(response.status == 200) {
                    JOptionPane.showMessageDialog(this, response.message);
                    clearField();
                    new Frame_PembayaranKas().setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Gagal Menambahkan Pembayaran Kas");
                }
            } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, e.getMessage());
            }     
        };   
       
    }//GEN-LAST:event_btnSIMPANActionPerformed

    private void radiobuttonPENGELUARANActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiobuttonPENGELUARANActionPerformed
        //        category = "Pengeluaran";
        //    JOptionPane.showMessageDialog(null, "Kategori: Pengeluaran dipilih.");
    }//GEN-LAST:event_radiobuttonPENGELUARANActionPerformed

    private void radiobuttonPEMASUKANActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiobuttonPEMASUKANActionPerformed

    }//GEN-LAST:event_radiobuttonPEMASUKANActionPerformed

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
            java.util.logging.Logger.getLogger(Frame_EditPembayaranKas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame_EditPembayaranKas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame_EditPembayaranKas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame_EditPembayaranKas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame_EditPembayaranKas(0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKEMBALI;
    private javax.swing.JButton btnSIMPAN;
    private javax.swing.JRadioButton radiobuttonPEMASUKAN;
    private javax.swing.JRadioButton radiobuttonPENGELUARAN;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtKETERANGAN;
    private javax.swing.JTextField txtNAMA;
    private javax.swing.JTextField txtPEMASUKAN;
    private javax.swing.JTextField txtPENGELUARAN;
    // End of variables declaration//GEN-END:variables
}
