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
public class Frame_PembayaranKas extends javax.swing.JFrame {

    ArrayList<Mahasiswa> listMahasiswa;
    ArrayList<KasReport> listReportKas;
    DefaultTableModel reportKasTable;
    
    DatabaseInstance db;
    public Frame_PembayaranKas() {
        initComponents();
        setLocationRelativeTo(null);
        db = new DatabaseInstance();
        getMahasiswa();
        getReportKas();
        setTitle("Manajemen Kas Kelas By 3E Informatika Unsika");
    };
    
    public void getReportKas() {
        listReportKas = db.getKasReport().data;
        showDataTable();
    }

    public void showDataTable(){
        String[] headerTableColumns = {"No", "Tanggal", "Nama", "Pemasukkan", "Pengeluaran", "Keterangan"};
        Object[][] listReportKasValue = new Object[listReportKas.size()][headerTableColumns.length];
        int i = 0;
        
        for(KasReport report: listReportKas ) {
            String roomData[] = {report.id+"", report.date, report.name, report.income+"", report.expanse+"", report.desc};
            switch (report.type) {
                case "income":
                    roomData[4] = "-";
                    break;
                
                case "expanse":
                    roomData[3] = "-";
                    break;
                default:
                    throw new AssertionError();
            };
            
            listReportKasValue[i] = roomData;
            i++;
        };
        
        
        reportKasTable = new DefaultTableModel(listReportKasValue, headerTableColumns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            };        
        };
        
        tablePembayaranKas.setModel(reportKasTable);
    };        
    
    public void getMahasiswa() {
        listMahasiswa = db.getMahasiswa().data;
        for(Mahasiswa mhs: listMahasiswa) {
            npmComboBox.addItem(mhs.nim);
        };
    }
    
    public void clearField() {
        npmComboBox.setSelectedIndex(0);
        txtNAMA.setText("");
        txtDate.setText("");
        txtKETERANGAN.setText("");
        txtPEMASUKAN.setText("0");
        txtPENGELUARAN.setText("0");
    };
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnEDIT = new javax.swing.JButton();
        btnKEMBALI = new javax.swing.JButton();
        btnHAPUS = new javax.swing.JButton();
        btnSIMPAN = new javax.swing.JButton();
        txtKETERANGAN = new javax.swing.JTextField();
        radiobuttonPEMASUKAN = new javax.swing.JRadioButton();
        radiobuttonPENGELUARAN = new javax.swing.JRadioButton();
        txtNAMA = new javax.swing.JTextField();
        txtDate = new javax.swing.JTextField();
        txtPEMASUKAN = new javax.swing.JTextField();
        txtPENGELUARAN = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePembayaranKas = new javax.swing.JTable();
        npmComboBox = new javax.swing.JComboBox<>();
        LabelPembayaranKas = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEDIT.setBackground(new java.awt.Color(218, 218, 218));
        btnEDIT.setFont(new java.awt.Font("Sylfaen", 1, 22)); // NOI18N
        btnEDIT.setText("EDIT");
        btnEDIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEDITActionPerformed(evt);
            }
        });
        getContentPane().add(btnEDIT, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 410, 160, 50));

        btnKEMBALI.setBackground(new java.awt.Color(218, 218, 218));
        btnKEMBALI.setFont(new java.awt.Font("Sylfaen", 1, 22)); // NOI18N
        btnKEMBALI.setText("KEMBALI");
        btnKEMBALI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKEMBALIActionPerformed(evt);
            }
        });
        getContentPane().add(btnKEMBALI, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 410, 150, 50));

        btnHAPUS.setBackground(new java.awt.Color(218, 218, 218));
        btnHAPUS.setFont(new java.awt.Font("Sylfaen", 1, 22)); // NOI18N
        btnHAPUS.setText("HAPUS");
        btnHAPUS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHAPUSActionPerformed(evt);
            }
        });
        getContentPane().add(btnHAPUS, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 410, 160, 50));

        btnSIMPAN.setBackground(new java.awt.Color(218, 218, 218));
        btnSIMPAN.setFont(new java.awt.Font("Sylfaen", 1, 22)); // NOI18N
        btnSIMPAN.setText("SIMPAN");
        btnSIMPAN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSIMPANActionPerformed(evt);
            }
        });
        getContentPane().add(btnSIMPAN, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 410, 150, 50));

        txtKETERANGAN.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtKETERANGAN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKETERANGANActionPerformed(evt);
            }
        });
        getContentPane().add(txtKETERANGAN, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 260, 40));

        radiobuttonPEMASUKAN.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        radiobuttonPEMASUKAN.setText("PEMASUKAN");
        radiobuttonPEMASUKAN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiobuttonPEMASUKANActionPerformed(evt);
            }
        });
        getContentPane().add(radiobuttonPEMASUKAN, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 110, 110, 40));

        radiobuttonPENGELUARAN.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        radiobuttonPENGELUARAN.setText("PENGELUARAN");
        radiobuttonPENGELUARAN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiobuttonPENGELUARANActionPerformed(evt);
            }
        });
        getContentPane().add(radiobuttonPENGELUARAN, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 170, -1, -1));

        txtNAMA.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtNAMA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNAMAActionPerformed(evt);
            }
        });
        getContentPane().add(txtNAMA, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 240, 260, 40));

        txtDate.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        getContentPane().add(txtDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 260, 40));

        txtPEMASUKAN.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtPEMASUKAN.setText("0");
        txtPEMASUKAN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPEMASUKANActionPerformed(evt);
            }
        });
        getContentPane().add(txtPEMASUKAN, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 110, 240, 40));

        txtPENGELUARAN.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtPENGELUARAN.setText("0");
        getContentPane().add(txtPENGELUARAN, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 170, 240, 40));

        tablePembayaranKas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N O", "Tanggal", "Nama", "Pemasukan", "Pengeluaran", "Keterangan"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablePembayaranKas);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 510, 980, 190));

        npmComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih NIM Mahasiswa" }));
        npmComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                npmComboBoxItemStateChanged(evt);
            }
        });
        npmComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                npmComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(npmComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 260, 40));

        LabelPembayaranKas.setFont(new java.awt.Font("Sylfaen", 1, 22)); // NOI18N
        LabelPembayaranKas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI_componen_asset/pembayaran kas.png"))); // NOI18N
        getContentPane().add(LabelPembayaranKas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHAPUSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHAPUSActionPerformed
        int selectedRow = tablePembayaranKas.getSelectedRow();
        
        if(selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Pilih data yang ingin dihapus!");
            return;
        };
        
        String name = tablePembayaranKas.getValueAt(selectedRow, 2).toString();
        String date = tablePembayaranKas.getValueAt(selectedRow, 1).toString();
        int confirm = JOptionPane.showConfirmDialog(this, "Yakin ingin menghapus report kas\n" + name + "\nTanggal " + date, "Confirm Delete", JOptionPane.YES_NO_OPTION);
        
        if(confirm == JOptionPane.YES_OPTION) {
            try {
                int id = Integer.parseInt(tablePembayaranKas.getValueAt(selectedRow, 0).toString());
                DatabaseResultResponse response = db.deleteKasReport(id);
                if(response.status == 200) {
                    JOptionPane.showMessageDialog(this, "Berhasil menghapus report kas!");
                    getReportKas();
                } else {
                    JOptionPane.showMessageDialog(this, "Gagal menghapus report kas!");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }//GEN-LAST:event_btnHAPUSActionPerformed

    private void radiobuttonPEMASUKANActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiobuttonPEMASUKANActionPerformed
        
    }//GEN-LAST:event_radiobuttonPEMASUKANActionPerformed

    private void radiobuttonPENGELUARANActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiobuttonPENGELUARANActionPerformed
//        category = "Pengeluaran"; 
//    JOptionPane.showMessageDialog(null, "Kategori: Pengeluaran dipilih.");
    }//GEN-LAST:event_radiobuttonPENGELUARANActionPerformed

    private void txtNAMAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNAMAActionPerformed
//       String name = txtNAMA.getText();
//    if (!name.isEmpty()) {
//        JOptionPane.showMessageDialog(null, "Nama diinput: " + name);
//    } else {
//        JOptionPane.showMessageDialog(null, "Nama tidak boleh kosong!");
//    }
    }//GEN-LAST:event_txtNAMAActionPerformed

    private void txtPEMASUKANActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPEMASUKANActionPerformed
        
    }//GEN-LAST:event_txtPEMASUKANActionPerformed

    private void txtKETERANGANActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKETERANGANActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKETERANGANActionPerformed

    private void btnKEMBALIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKEMBALIActionPerformed
        new Frame_MenuUtama().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnKEMBALIActionPerformed

    private void npmComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_npmComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_npmComboBoxActionPerformed

    private void npmComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_npmComboBoxItemStateChanged
        String npm = npmComboBox.getSelectedItem().toString();
        for(Mahasiswa mhs: listMahasiswa) {
            if(npm.equals(mhs.nim)) {
                txtNAMA.setText(mhs.name);
            }
        }
        if(npm.equals("Pilih NIM Mahasiswa")) {
            txtNAMA.setText("");
        }
    }//GEN-LAST:event_npmComboBoxItemStateChanged

    private void btnSIMPANActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSIMPANActionPerformed
        String nim = npmComboBox.getSelectedItem().toString();
        String date = txtDate.getText();
        String name = txtNAMA.getText();
        String desc = txtKETERANGAN.getText();
        boolean income = radiobuttonPEMASUKAN.isSelected();
        boolean expanse = radiobuttonPENGELUARAN.isSelected();
        double incomeAmount;
        double expanseAmount;
        
        if(nim.equals("Pilih NIM Mahasiswa") || date.equals("") || name.equals("")) {
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
                DatabaseResultResponse response = db.addKasTransaction(nim, date, name, incomeAmount, 0, desc, "income");
                if(response.status == 200) {
                    JOptionPane.showMessageDialog(this, response.message);
                    clearField();
                    getReportKas();
                } else {
                    JOptionPane.showMessageDialog(this, "Gagal Menambahkan Pembayaran Kas");
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
            DatabaseResultResponse response = db.addKasTransaction(nim, date, name, 0, expanseAmount, desc, "expanse");
            if(response.status == 200) {
                JOptionPane.showMessageDialog(this, response.message);
                clearField();
                getReportKas();
            } else {
                JOptionPane.showMessageDialog(this, "Gagal Menambahkan Pembayaran Kas");
            }
            } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, e.getMessage());
            }     
        };   
       
    }//GEN-LAST:event_btnSIMPANActionPerformed

    private void btnEDITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEDITActionPerformed
        int selectedRow = tablePembayaranKas.getSelectedRow();
        
        if(selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Pilih data yang ingin diedit!");
            return;
        };
        
        int id = Integer.parseInt(tablePembayaranKas.getValueAt(selectedRow, 0).toString());
        
        new Frame_EditPembayaranKas(id).setVisible(true);
        dispose();
        
    }//GEN-LAST:event_btnEDITActionPerformed

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
            java.util.logging.Logger.getLogger(Frame_PembayaranKas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame_PembayaranKas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame_PembayaranKas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame_PembayaranKas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame_PembayaranKas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelPembayaranKas;
    private javax.swing.JButton btnEDIT;
    private javax.swing.JButton btnHAPUS;
    private javax.swing.JButton btnKEMBALI;
    private javax.swing.JButton btnSIMPAN;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> npmComboBox;
    private javax.swing.JRadioButton radiobuttonPEMASUKAN;
    private javax.swing.JRadioButton radiobuttonPENGELUARAN;
    private javax.swing.JTable tablePembayaranKas;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtKETERANGAN;
    private javax.swing.JTextField txtNAMA;
    private javax.swing.JTextField txtPEMASUKAN;
    private javax.swing.JTextField txtPENGELUARAN;
    // End of variables declaration//GEN-END:variables
}
