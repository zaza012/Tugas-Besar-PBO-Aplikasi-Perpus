/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package perpus;

import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author asus
 */
public class Admin extends javax.swing.JFrame {

    /**
     * Creates new form Admin
     */
    public Admin() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem8 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuItem = new javax.swing.JMenu();
        logout = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        DataAnggota = new javax.swing.JMenuItem();
        DataBuku = new javax.swing.JMenuItem();
        DataPeminjaman = new javax.swing.JMenuItem();
        DataPengembalian = new javax.swing.JMenuItem();
        HistoriPeminjaman = new javax.swing.JMenuItem();
        HistoriPengembalian = new javax.swing.JMenuItem();

        jMenuItem8.setText("jMenuItem8");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 204, 255));

        jLabel1.setFont(new java.awt.Font("Arial Narrow", 3, 36)); // NOI18N
        jLabel1.setText("FORM LOGIN ADMIN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(230, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(220, 220, 220))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(242, 242, 242)
                .addComponent(jLabel1)
                .addContainerGap(286, Short.MAX_VALUE))
        );

        MenuItem.setText("File");
        MenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemActionPerformed(evt);
            }
        });

        logout.setText("LogOut");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        MenuItem.add(logout);

        jMenuBar1.add(MenuItem);

        jMenu2.setText("Data");
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        DataAnggota.setText("Data Anggota");
        DataAnggota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DataAnggotaActionPerformed(evt);
            }
        });
        jMenu2.add(DataAnggota);

        DataBuku.setText("Data Buku");
        DataBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DataBukuActionPerformed(evt);
            }
        });
        jMenu2.add(DataBuku);

        DataPeminjaman.setText("Data Peminjaman");
        DataPeminjaman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DataPeminjamanActionPerformed(evt);
            }
        });
        jMenu2.add(DataPeminjaman);

        DataPengembalian.setText("Data Pengembalian");
        DataPengembalian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DataPengembalianActionPerformed(evt);
            }
        });
        jMenu2.add(DataPengembalian);

        HistoriPeminjaman.setText("Histori Peminjaman");
        HistoriPeminjaman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HistoriPeminjamanActionPerformed(evt);
            }
        });
        jMenu2.add(HistoriPeminjaman);

        HistoriPengembalian.setText("Histori Pengembalian");
        HistoriPengembalian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HistoriPengembalianActionPerformed(evt);
            }
        });
        jMenu2.add(HistoriPengembalian);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
    // TODO add your handling code here:
        int keluar=JOptionPane.showOptionDialog(this, 
               "        Keluar dari Aplikasi",
               "EXIT",
               JOptionPane.YES_NO_OPTION,
               JOptionPane.QUESTION_MESSAGE,
               null,null,null);
        if(keluar==JOptionPane.YES_NO_OPTION){
            new Login().show();
            this.dispose();
        } 
    }//GEN-LAST:event_logoutActionPerformed

    private void MenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MenuItemActionPerformed

    private void DataAnggotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DataAnggotaActionPerformed
        // TODO add your handling code here:
        new DataAnggota().show();
        this.dispose();
    }//GEN-LAST:event_DataAnggotaActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void DataBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DataBukuActionPerformed
        // TODO add your handling code here:
        new DataBuku().show();
        this.dispose();
    }//GEN-LAST:event_DataBukuActionPerformed

    private void DataPeminjamanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DataPeminjamanActionPerformed
        // TODO add your handling code here:
        new DataPeminjaman().show();
        this.dispose();
    }//GEN-LAST:event_DataPeminjamanActionPerformed

    private void DataPengembalianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DataPengembalianActionPerformed
        // TODO add your handling code here:
        new DataPengembalian().show();
        this.dispose();
    }//GEN-LAST:event_DataPengembalianActionPerformed

    private void HistoriPengembalianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HistoriPengembalianActionPerformed
        // TODO add your handling code here:
        new HistoriPengembalianAdmin().show();
        this.dispose();
    }//GEN-LAST:event_HistoriPengembalianActionPerformed

    private void HistoriPeminjamanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HistoriPeminjamanActionPerformed
        // TODO add your handling code here:
        new HistoriPeminjamanAdmin().show();
        this.dispose();
    }//GEN-LAST:event_HistoriPeminjamanActionPerformed

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
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem DataAnggota;
    private javax.swing.JMenuItem DataBuku;
    private javax.swing.JMenuItem DataPeminjaman;
    private javax.swing.JMenuItem DataPengembalian;
    private javax.swing.JMenuItem HistoriPeminjaman;
    private javax.swing.JMenuItem HistoriPengembalian;
    private javax.swing.JMenu MenuItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem logout;
    // End of variables declaration//GEN-END:variables
}
