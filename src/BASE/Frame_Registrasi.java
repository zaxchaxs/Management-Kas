/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package BASE;

import Database.DatabaseInstance;
import Database.DatabaseResultResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author 23106
 */
public class Frame_Registrasi extends javax.swing.JFrame {

    DatabaseInstance db;
    
    public Frame_Registrasi() {
        initComponents();
        setLocationRelativeTo(null);
        db = new DatabaseInstance();
        setTitle("Manajemen Kas Kelas By 3E Informatika Unsika");
    }
    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNAMA = new javax.swing.JTextField();
        txtUSERNAME = new javax.swing.JTextField();
        btnDAFTAR = new javax.swing.JButton();
        btnBATAL = new javax.swing.JButton();
        txtNIM = new javax.swing.JTextField();
        txtPASSWORD = new javax.swing.JPasswordField();
        LabelRegistrasi = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNAMA.setBackground(new java.awt.Color(7, 48, 97));
        txtNAMA.setForeground(new java.awt.Color(255, 255, 255));
        txtNAMA.setBorder(null);
        txtNAMA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNAMAActionPerformed(evt);
            }
        });
        getContentPane().add(txtNAMA, new org.netbeans.lib.awtextra.AbsoluteConstraints(571, 242, 260, 30));

        txtUSERNAME.setBackground(new java.awt.Color(7, 48, 97));
        txtUSERNAME.setForeground(new java.awt.Color(255, 255, 255));
        txtUSERNAME.setBorder(null);
        txtUSERNAME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUSERNAMEActionPerformed(evt);
            }
        });
        getContentPane().add(txtUSERNAME, new org.netbeans.lib.awtextra.AbsoluteConstraints(571, 322, 260, 30));

        btnDAFTAR.setBackground(new java.awt.Color(170, 214, 195));
        btnDAFTAR.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btnDAFTAR.setText("DAFTAR");
        btnDAFTAR.setBorder(null);
        btnDAFTAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDAFTARActionPerformed(evt);
            }
        });
        getContentPane().add(btnDAFTAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 470, 160, 50));

        btnBATAL.setBackground(new java.awt.Color(233, 174, 200));
        btnBATAL.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBATAL.setText("BATAL");
        btnBATAL.setBorder(null);
        btnBATAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBATALActionPerformed(evt);
            }
        });
        getContentPane().add(btnBATAL, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 480, 110, 30));

        txtNIM.setBackground(new java.awt.Color(7, 48, 97));
        txtNIM.setForeground(new java.awt.Color(255, 255, 255));
        txtNIM.setBorder(null);
        txtNIM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNIMActionPerformed(evt);
            }
        });
        getContentPane().add(txtNIM, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 160, 260, 30));

        txtPASSWORD.setBackground(new java.awt.Color(7, 48, 97));
        txtPASSWORD.setBorder(null);
        getContentPane().add(txtPASSWORD, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 402, 270, 30));

        LabelRegistrasi.setBackground(new java.awt.Color(245, 168, 195));
        LabelRegistrasi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI_componen_asset/frame registrasi.png"))); // NOI18N
        getContentPane().add(LabelRegistrasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDAFTARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDAFTARActionPerformed
       String nama = txtNAMA.getText();
       String nim = txtNIM.getText();
       String username = txtUSERNAME.getText();
       String password = txtPASSWORD.getText();
        
        if(username.equals("") || password.equals("") || nama.equals("") || nim.equals("")) {
            JOptionPane.showMessageDialog(this, "Tolong Isi Form dengan Benar!");
            return;
        };
        
        
        try {
            DatabaseResultResponse response = db.registUser(nim, nama, username, password);
            if(response.status == 200) {
                JOptionPane.showMessageDialog(this, response.message);
                new Frame_login().setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, response.message);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnDAFTARActionPerformed

    private void txtUSERNAMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUSERNAMEActionPerformed
//    JOptionPane.showMessageDialog(this, "Kolom Username telah diisi: " + txtUSERNAME.getText());
    }//GEN-LAST:event_txtUSERNAMEActionPerformed

    private void btnBATALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBATALActionPerformed
        new Frame_login().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnBATALActionPerformed

    private void txtNAMAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNAMAActionPerformed
//    JOptionPane.showMessageDialog(this, "Kolom Nama telah diisi: " + txtNAMA.getText());                                           
    }//GEN-LAST:event_txtNAMAActionPerformed

    private void txtNIMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNIMActionPerformed
//     JOptionPane.showMessageDialog(this, "Kolom NIM telah diisi: " + txtNIM.getText());
    }//GEN-LAST:event_txtNIMActionPerformed

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
            java.util.logging.Logger.getLogger(Frame_Registrasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame_Registrasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame_Registrasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame_Registrasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame_Registrasi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelRegistrasi;
    private javax.swing.JButton btnBATAL;
    private javax.swing.JButton btnDAFTAR;
    private javax.swing.JTextField txtNAMA;
    private javax.swing.JTextField txtNIM;
    private javax.swing.JPasswordField txtPASSWORD;
    private javax.swing.JTextField txtUSERNAME;
    // End of variables declaration//GEN-END:variables
}
