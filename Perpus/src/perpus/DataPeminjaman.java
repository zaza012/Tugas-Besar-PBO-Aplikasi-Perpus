/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package perpus;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author asus
 */
public class DataPeminjaman extends javax.swing.JFrame {

    /**
     * Creates new form DataPeminjaman
     */
    public DataPeminjaman() {
        initComponents();
        load_data();
        IDOtomatis();
        
        edit.setEnabled(false);
        delete.setEnabled(false);
    }

    private void load_data(){
        Connection Kon=Koneksi.KoneksiDb();
        Object header[]={"ID PEMINJAM","NAMA","NIS","PEGAWAI","ID BUKU","JUDUL BUKU","TANGGAL PEMINJAMAN","TANGGAL KEMBALI"};
        DefaultTableModel data = new DefaultTableModel(null,header);
        TabelPeminjaman.setModel(data);
        String sql_data="SELECT * FROM tbl_peminjaman";
        try{
            Statement st=Kon.createStatement();
            ResultSet rs=st.executeQuery(sql_data);
            while(rs.next()){
                String d1=rs.getString(1);
                String d2=rs.getString(2);
                String d3=rs.getString(3);
                String d4=rs.getString(4);
                String d5=rs.getString(5);
                String d6=rs.getString(6);
                String d7=rs.getString(7);
                String d8=rs.getString(8);
                String d[]={d1,d2,d3,d4,d5,d6,d7,d8};
                data.addRow(d);
            }
            
        }catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null, e);
            
        }
    }
    
    //ID Anggoto otomatis
    private void IDOtomatis(){
        
        try{
            Connection Kon=Koneksi.KoneksiDb();
            Statement st=Kon.createStatement();
            String sql_id="SELECT * FROM tbl_peminjaman order by id_peminjam desc";
            ResultSet rs=st.executeQuery(sql_id);
            if(rs.next()){
                String id_anggota=rs.getString("id_peminjam").substring(1);
                String AN=""+(Integer.parseInt(id_anggota)+1);
                String Nol="";
                if(AN.length()==1){
                    Nol="000";
                }else if(AN.length()==2){
                    Nol="00";
                }else if(AN.length()==3){
                    Nol="0";
                }
                ID.setText("P"+Nol+AN);
            }else{
                ID.setText("P0001");
            }
            
        }catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
        }
    }
            
    private void input_data(){
        
        String tampilan = "yyyy-MM-dd";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String tanggal = String.valueOf(fm.format(TP.getDate()));
        String tgl = String.valueOf(fm.format(TK.getDate()));
        
        try{
            Connection Kon=Koneksi.KoneksiDb();
            Statement st=Kon.createStatement();
            String sql="INSERT INTO tbl_peminjaman values('"+ID.getText()
                    +"', '"+NAMA.getText()
                    +"', '"+NIS.getText()
                    +"', '"+PEGAWAI.getText()
                    +"', '"+IDBUKU.getText()
                    +"', '"+JUDUL.getText()
                    +"', '"+tanggal
                    +"', '"+tgl
                    +"')";
            st.execute(sql);
            JOptionPane.showMessageDialog(null, "Data Peminjaman Berhasil Dimasukan");
        }catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void clear(){
        NAMA.setText(null);
        NIS.setText(null);
        PEGAWAI.setText(null);
        IDBUKU.setText(null);
        JUDUL.setText(null);
        TP.setDate(null);
        TK.setDate(null);      
    }
    
    private void update(){    
//        String tampilan = "yyyy-MM-dd";
//        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
//        String tanggal = String.valueOf(fm.format(TP.getDate()));
//        String tgl = String.valueOf(fm.format(TK.getDate()));
        
        try{
            Connection Kon=Koneksi.KoneksiDb();
            Statement st=Kon.createStatement();
            String sql_update="UPDATE tbl_peminjaman SET nama='"+NAMA.getText()
                    +"',nis='"+NIS.getText()
                    +"',pegawai='"+PEGAWAI.getText()
                    +"',id_buku='"+IDBUKU.getText()
                    +"',judul='"+JUDUL.getText()
                    +"'WHERE id_peminjam='"+ID.getText()+"'";
            st.execute(sql_update);
            JOptionPane.showMessageDialog(null, "Data Berhasil Di Update");
        
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void delete(){
//        String tampilan = "yyyy-MM-dd";
//        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
//        String tanggal = String.valueOf(fm.format(TP.getDate()));
//        String tgl = String.valueOf(fm.format(TK.getDate()));
        
        try{
            Connection Kon=Koneksi.KoneksiDb();
            Statement st=Kon.createStatement();
            String sql_delete="DELETE from tbl_peminjaman WHERE "
                    + "id_peminjam='"+ID.getText()+"'";
             st.execute(sql_delete);
            JOptionPane.showMessageDialog(null, "Data Berhasil Di Hapus");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        ID = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        NAMA = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        NIS = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        PEGAWAI = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        IDBUKU = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        JUDUL = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        TP = new com.toedter.calendar.JDateChooser();
        jLabel17 = new javax.swing.JLabel();
        TK = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        TabelPeminjaman = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        input = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        keluar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 204, 255));

        jLabel10.setText("ID PEMINJAM");

        ID.setEditable(false);
        ID.setEnabled(false);

        jLabel11.setText("NAMA");

        NAMA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NAMAActionPerformed(evt);
            }
        });

        jLabel12.setText("NIS");

        jLabel13.setText("PEGAWAI");

        jLabel14.setText("ID BUKU");

        jLabel15.setText("JUDUL BUKU");

        jLabel16.setText("TANGGAL PINJAM");

        jLabel17.setText("TANGGAL KEMBALI");

        TabelPeminjaman.setBackground(new java.awt.Color(153, 153, 153));
        TabelPeminjaman.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TabelPeminjaman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelPeminjamanMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TabelPeminjaman);

        jLabel18.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel18.setText("DATA PEMINJAMAN BUKU");

        input.setText("INPUT");
        input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputActionPerformed(evt);
            }
        });

        edit.setText("UPDATE");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        delete.setText("DELETE");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        keluar.setText("Keluar");
        keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NAMA)
                            .addComponent(NIS)
                            .addComponent(PEGAWAI)
                            .addComponent(IDBUKU)
                            .addComponent(JUDUL)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(TP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(TK, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(input)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(edit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(delete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(keluar)))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 706, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel18)
                .addGap(393, 393, 393))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(NAMA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(NIS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(PEGAWAI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(IDBUKU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(JUDUL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(TP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(TK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(input)
                            .addComponent(edit)
                            .addComponent(delete)
                            .addComponent(keluar)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2)))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NAMAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NAMAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NAMAActionPerformed

    private void TabelPeminjamanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelPeminjamanMouseClicked
        // TODO add your handling code here:
        int bar = TabelPeminjaman.getSelectedRow();
        String a = TabelPeminjaman.getValueAt(bar, 0).toString();
        String b = TabelPeminjaman.getValueAt(bar, 1).toString();
        String c = TabelPeminjaman.getValueAt(bar, 2).toString();
        String d = TabelPeminjaman.getValueAt(bar, 3).toString();
        String e = TabelPeminjaman.getValueAt(bar, 4).toString();
        String f = TabelPeminjaman.getValueAt(bar, 5).toString();
        String g = TabelPeminjaman.getValueAt(bar, 6).toString();
        String h = TabelPeminjaman.getValueAt(bar, 7).toString();
        
        ID.setText(a);
        NAMA.setText(b);
        NIS.setText(c);
        PEGAWAI.setText(d);
        IDBUKU.setText(e);
        JUDUL.setText(f);
//        TP.setDateFormatString(g);
//        TK.setDateFormatString(h);
        
        //set disable input
        input.setEnabled(false);
        edit.setEnabled(true);
        delete.setEnabled(true);
    }//GEN-LAST:event_TabelPeminjamanMouseClicked

    private void keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarActionPerformed
        // TODO add your handling code here:
        int keluar=JOptionPane.showOptionDialog(this, 
               "        Keluar dari Data Peminjaman",
               "EXIT",
               JOptionPane.YES_NO_OPTION,
               JOptionPane.QUESTION_MESSAGE,
               null,null,null);
        if(keluar==JOptionPane.YES_NO_OPTION){
            new Admin().show();
            this.dispose();
        } 
    }//GEN-LAST:event_keluarActionPerformed

    private void inputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputActionPerformed
        // TODO add your handling code here:
        int simpan=JOptionPane.showOptionDialog(this, 
               "Apakah Data Sudah Benar? SIMPAN ?",
               "Simpan Data",
               JOptionPane.YES_NO_OPTION,
               JOptionPane.QUESTION_MESSAGE,
               null,null,null);
        if(simpan==JOptionPane.YES_NO_OPTION){
            input_data();
            load_data();
            clear();
            IDOtomatis();
        }
    }//GEN-LAST:event_inputActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        // TODO add your handling code here:
        int update=JOptionPane.showOptionDialog(this, 
               "Apakah Data Akan Di Update? Update ?",
               "Update",
               JOptionPane.YES_NO_OPTION,
               JOptionPane.QUESTION_MESSAGE,
               null,null,null);
        if(update==JOptionPane.YES_NO_OPTION){
            update();
            load_data();
            clear();
            IDOtomatis();
        }
        //setEnable
        input.setEnabled(true);
        edit.setEnabled(false);
        delete.setEnabled(false);
    }//GEN-LAST:event_editActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        int update=JOptionPane.showOptionDialog(this, 
               "Apakah Data Akan Di Delete? Delete ?",
               "Update",
               JOptionPane.YES_NO_OPTION,
               JOptionPane.QUESTION_MESSAGE,
               null,null,null);
        if(update==JOptionPane.YES_NO_OPTION){
            delete();
            load_data();
            clear();
            IDOtomatis();
        }
        //setEnable
        input.setEnabled(true);
        edit.setEnabled(false);
        delete.setEnabled(false);
    }//GEN-LAST:event_deleteActionPerformed

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
            java.util.logging.Logger.getLogger(DataPeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataPeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataPeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataPeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataPeminjaman().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ID;
    private javax.swing.JTextField IDBUKU;
    private javax.swing.JTextField JUDUL;
    private javax.swing.JTextField NAMA;
    private javax.swing.JTextField NIS;
    private javax.swing.JTextField PEGAWAI;
    private com.toedter.calendar.JDateChooser TK;
    private com.toedter.calendar.JDateChooser TP;
    private javax.swing.JTable TabelPeminjaman;
    private javax.swing.JButton delete;
    private javax.swing.JButton edit;
    private javax.swing.JButton input;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton keluar;
    // End of variables declaration//GEN-END:variables
}
