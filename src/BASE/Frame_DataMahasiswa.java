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
public class Frame_DataMahasiswa extends javax.swing.JFrame {

    DatabaseInstance db;
    
    public Frame_DataMahasiswa() {
        initComponents();
        setLocationRelativeTo(null);
        db = new DatabaseInstance();
        setTitle("Manajemen Kas Kelas By 3E Informatika Unsika");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNIM = new javax.swing.JTextField();
        txtNOHP = new javax.swing.JTextField();
        txtNAMA = new javax.swing.JTextField();
        ComboboxJenisKelamin = new javax.swing.JComboBox<>();
        btnSIMPAN = new javax.swing.JButton();
        btnKEMBALI = new javax.swing.JButton();
        btnKEMBALI1 = new javax.swing.JButton();
        labelDataMahasiswa = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNIM.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtNIM.setBorder(null);
        getContentPane().add(txtNIM, new org.netbeans.lib.awtextra.AbsoluteConstraints(181, 170, 250, 50));

        txtNOHP.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtNOHP.setBorder(null);
        getContentPane().add(txtNOHP, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 250, 50));

        txtNAMA.setFont(new java.awt.Font("Times New Roman", 0, 19)); // NOI18N
        txtNAMA.setBorder(null);
        txtNAMA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNAMAActionPerformed(evt);
            }
        });
        getContentPane().add(txtNAMA, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 170, 250, 50));

        ComboboxJenisKelamin.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        ComboboxJenisKelamin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laki-laki", "Perempuan", " " }));
        getContentPane().add(ComboboxJenisKelamin, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 270, 270, 50));

        btnSIMPAN.setBackground(new java.awt.Color(204, 204, 204));
        btnSIMPAN.setFont(new java.awt.Font("SansSerif", 3, 18)); // NOI18N
        btnSIMPAN.setText("SIMPAN");
        btnSIMPAN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSIMPANActionPerformed(evt);
            }
        });
        getContentPane().add(btnSIMPAN, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 550, 140, 60));

        btnKEMBALI.setBackground(new java.awt.Color(204, 204, 255));
        btnKEMBALI.setFont(new java.awt.Font("Sylfaen", 3, 18)); // NOI18N
        btnKEMBALI.setText("KEMBALI");
        btnKEMBALI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKEMBALIActionPerformed(evt);
            }
        });
        getContentPane().add(btnKEMBALI, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 560, 140, 50));

        btnKEMBALI1.setBackground(new java.awt.Color(204, 204, 255));
        btnKEMBALI1.setFont(new java.awt.Font("Sylfaen", 3, 18)); // NOI18N
        btnKEMBALI1.setText("Rekap Mahasiswa");
        btnKEMBALI1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKEMBALI1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnKEMBALI1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 450, 180, 60));

        labelDataMahasiswa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI_componen_asset/frame Data Mahasiswa.png"))); // NOI18N
        getContentPane().add(labelDataMahasiswa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNAMAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNAMAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNAMAActionPerformed

    private void btnKEMBALIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKEMBALIActionPerformed
        new Frame_MenuUtama().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnKEMBALIActionPerformed

    private void btnSIMPANActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSIMPANActionPerformed
        String nim = txtNIM.getText();
        String name = txtNAMA.getText();
        String noPhone = txtNOHP.getText();
        String gender = ComboboxJenisKelamin.getSelectedItem().toString().toLowerCase();
        
        if(nim.equals("") || noPhone.equals("") || name.equals("") || gender.equals("")) {
            JOptionPane.showMessageDialog(this, "Tolong Isi Form dengan Benar!");
            return;
        };
        
        try {
            DatabaseResultResponse response = db.addMahasiswa(nim, name, noPhone, gender);
            if(response.status == 200) {
                JOptionPane.showMessageDialog(this, response.message);
                txtNIM.setText("");
                txtNAMA.setText("");
                txtNOHP.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Gagal Menambahkan Data\nMahasiswa!");
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(this, e.getMessage());
        }
        
        
    }//GEN-LAST:event_btnSIMPANActionPerformed

    private void btnKEMBALI1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKEMBALI1ActionPerformed
        new Frame_RekapMahasiswa().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnKEMBALI1ActionPerformed

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
            java.util.logging.Logger.getLogger(Frame_DataMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame_DataMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame_DataMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame_DataMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame_DataMahasiswa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboboxJenisKelamin;
    private javax.swing.JButton btnKEMBALI;
    private javax.swing.JButton btnKEMBALI1;
    private javax.swing.JButton btnSIMPAN;
    private javax.swing.JLabel labelDataMahasiswa;
    private javax.swing.JTextField txtNAMA;
    private javax.swing.JTextField txtNIM;
    private javax.swing.JTextField txtNOHP;
    // End of variables declaration//GEN-END:variables
}
