/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package BASE;

import DataModels.Mahasiswa;
import Database.DatabaseInstance;
import Database.DatabaseResultResponse;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 23106
 */
public class Frame_RekapMahasiswa extends javax.swing.JFrame {

    DefaultTableModel mahasiswaTableModel;
    ArrayList<Mahasiswa> listMahasiswa;
    DatabaseInstance db;
    
    public Frame_RekapMahasiswa() {
        initComponents();
        setLocationRelativeTo(null);
        db = new DatabaseInstance();
        getListMahasiswa();
        setTitle("Manajemen Kas Kelas By 3E Informatika Unsika");
    }
    
    public void getListMahasiswa() {
        listMahasiswa = db.getMahasiswa().data;
        showDataTable();
    };

    public void showDataTable(){
        String[] headerTableColumns = {"NIM", "Nama", "No Handphone", "Jenis Kelamin"};
        Object[][] listMahasiswaValue = new Object[listMahasiswa.size()][headerTableColumns.length];
        int i = 0;
        
        for(Mahasiswa mhs: listMahasiswa ) {
            String roomData[] = {mhs.nim, mhs.name, mhs.noPhone, mhs.gender};
            listMahasiswaValue[i] = roomData;
            i++;
        };
        
        
        mahasiswaTableModel = new DefaultTableModel(listMahasiswaValue, headerTableColumns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            };        
        };
        
        tableREKAPMAHASISWA.setModel(mahasiswaTableModel);
    };    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnPILIHMAHASISWA = new javax.swing.JButton();
        btnPEMBAYARANKAS = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableREKAPMAHASISWA = new javax.swing.JTable();
        btnBACK = new javax.swing.JButton();
        btnBACK1 = new javax.swing.JButton();
        LabelRekapMahasiswa = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnPILIHMAHASISWA.setBackground(new java.awt.Color(46, 144, 232));
        btnPILIHMAHASISWA.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        btnPILIHMAHASISWA.setText("Pilih Mahasiswa");
        btnPILIHMAHASISWA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPILIHMAHASISWAActionPerformed(evt);
            }
        });
        getContentPane().add(btnPILIHMAHASISWA, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 550, 190, 50));

        btnPEMBAYARANKAS.setBackground(new java.awt.Color(233, 174, 200));
        btnPEMBAYARANKAS.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnPEMBAYARANKAS.setText("Pembayaran Kas");
        btnPEMBAYARANKAS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPEMBAYARANKASActionPerformed(evt);
            }
        });
        getContentPane().add(btnPEMBAYARANKAS, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 550, 150, 40));

        tableREKAPMAHASISWA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "N I M", "N A M A", "No Handphone", "Jenis Kelamin"
            }
        ));
        jScrollPane1.setViewportView(tableREKAPMAHASISWA);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 730, 270));

        btnBACK.setBackground(new java.awt.Color(51, 255, 204));
        btnBACK.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        btnBACK.setText("BACK");
        btnBACK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBACKActionPerformed(evt);
            }
        });
        getContentPane().add(btnBACK, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 550, 110, 40));

        btnBACK1.setBackground(new java.awt.Color(204, 0, 0));
        btnBACK1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        btnBACK1.setForeground(new java.awt.Color(255, 255, 255));
        btnBACK1.setText("Hapus");
        btnBACK1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBACK1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnBACK1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 550, 110, 40));

        LabelRekapMahasiswa.setBackground(new java.awt.Color(46, 144, 232));
        LabelRekapMahasiswa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI_componen_asset/frame rekap mahasiswa.png"))); // NOI18N
        getContentPane().add(LabelRekapMahasiswa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBACKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBACKActionPerformed
        new Frame_DataMahasiswa().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnBACKActionPerformed

    private void btnPEMBAYARANKASActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPEMBAYARANKASActionPerformed
        new Frame_PembayaranKas().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnPEMBAYARANKASActionPerformed

    private void btnBACK1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBACK1ActionPerformed
        int selectedRow = tableREKAPMAHASISWA.getSelectedRow();
        
        if(selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Pilih data yang ingin dihapus!");
            return;
        };
        
        String name = tableREKAPMAHASISWA.getValueAt(selectedRow, 1).toString();
        int confirm = JOptionPane.showConfirmDialog(this, "Yakin ingin menghapus " + name + " ?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
        
        if(confirm == JOptionPane.YES_OPTION) {
            try {
                String nim = tableREKAPMAHASISWA.getValueAt(selectedRow, 0).toString();
                DatabaseResultResponse response = db.deleteMahasiswa(nim);
                if(response.status == 200) {
                    JOptionPane.showMessageDialog(this, "Berhasil menghapus " + name + "!");
                    getListMahasiswa();
                } else {
                    JOptionPane.showMessageDialog(this, "Gagal menghapus " + name + "!");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }//GEN-LAST:event_btnBACK1ActionPerformed

    private void btnPILIHMAHASISWAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPILIHMAHASISWAActionPerformed
        int selectedRow = tableREKAPMAHASISWA.getSelectedRow();
        
        if(selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Pilih Mahasiswa yang ingin dilihat!");
            return;
        };
        
        String nim = tableREKAPMAHASISWA.getValueAt(selectedRow, 0).toString();
        
        new Frame_RekapMahasiswaDetail(nim).setVisible(true);
        
    }//GEN-LAST:event_btnPILIHMAHASISWAActionPerformed

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
            java.util.logging.Logger.getLogger(Frame_RekapMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame_RekapMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame_RekapMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame_RekapMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame_RekapMahasiswa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelRekapMahasiswa;
    private javax.swing.JButton btnBACK;
    private javax.swing.JButton btnBACK1;
    private javax.swing.JButton btnPEMBAYARANKAS;
    private javax.swing.JButton btnPILIHMAHASISWA;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableREKAPMAHASISWA;
    // End of variables declaration//GEN-END:variables
}
