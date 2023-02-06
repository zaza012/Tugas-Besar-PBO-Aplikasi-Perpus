/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package perpus;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author asus
 */
public class DataBuku extends javax.swing.JFrame {

    /**
     * Creates new form DataBuku
     */
    public DataBuku() {
        initComponents();
        load_data();
        IDOtomatis();
        LoadLokasiRak();
        
        edit.setEnabled(false);
        delete.setEnabled(false);
    }
    
    private void load_data(){
        Connection Kon=Koneksi.KoneksiDb();
        Object header[]={"ID BUKU","JUDUL","PENGARANG","PENERBIT","TAHUN","LOKASI"};
        DefaultTableModel data = new DefaultTableModel(null,header);
        TabelBuku.setModel(data);
        String sql_data="SELECT * FROM tbl_buku";
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
                String d[]={d1,d2,d3,d4,d5,d6};
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
            String sql_id="SELECT * FROM tbl_buku order by id_buku desc";
            ResultSet rs=st.executeQuery(sql_id);
            if(rs.next()){
                String id_anggota=rs.getString("id_buku").substring(1);
                String AN=""+(Integer.parseInt(id_anggota)+1);
                String Nol="";
                if(AN.length()==1){
                    Nol="000";
                }else if(AN.length()==2){
                    Nol="00";
                }else if(AN.length()==3){
                    Nol="0";
                }
                ID.setText("B"+Nol+AN);
            }else{
                ID.setText("B0001");
            }
            
        }catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void LoadLokasiRak(){
        try{
            Connection Kon=Koneksi.KoneksiDb();
            Statement st=Kon.createStatement();
            String sql_lokasi="SELECT id_lokasi FROM tbl_lokasi";
            ResultSet rs=st.executeQuery(sql_lokasi);
            while(rs.next()){
                KLOKASI.addItem(rs.getString("id_lokasi"));
            }
            rs.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
            
    private void input_data(){
        
        try{
            Connection Kon=Koneksi.KoneksiDb();
            Statement st=Kon.createStatement();
            String sql="INSERT INTO tbl_buku values('"+ID.getText()
                    +"', '"+JUDUL.getText()
                    +"', '"+PENGARANG.getText()
                    +"', '"+PENERBIT.getText()
                    +"', '"+TAHUN.getText()
                    +"', '"+KLOKASI.getSelectedItem()
                    +"')";
            st.execute(sql);
            JOptionPane.showMessageDialog(null, "Data Buku Berhasil Dimasukan");
        }catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
    }
    
    public void clear(){
        JUDUL.setText(null);
        PENGARANG.setText(null);
        PENERBIT.setText(null);
        TAHUN.setText(null);
        KLOKASI.setSelectedItem(null);
                
    }
    
    private void update(){
        try{
            Connection Kon=Koneksi.KoneksiDb();
            Statement st=Kon.createStatement();
            String sql_update="UPDATE tbl_buku SET judul='"+JUDUL.getText()
                    +"',pengarang='"+PENGARANG.getText()
                    +"',penerbit='"+PENERBIT.getText()
                    +"',tahun='"+TAHUN.getText()
                    +"',id_lokasi='"+KLOKASI.getSelectedItem()
                    +"'WHERE id_buku='"+ID.getText()+"'";
            st.execute(sql_update);
            JOptionPane.showMessageDialog(null, "Data Berhasil Di Update");
        
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void delete(){
        try{
            Connection Kon=Koneksi.KoneksiDb();
            Statement st=Kon.createStatement();
            String sql_delete="DELETE from tbl_buku WHERE "
                    + "id_buku='"+ID.getText()+"'";
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TAHUN = new javax.swing.JTextField();
        PENGARANG = new javax.swing.JTextField();
        PENERBIT = new javax.swing.JTextField();
        ID = new javax.swing.JTextField();
        KLOKASI = new javax.swing.JComboBox<>();
        JUDUL = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelBuku = new javax.swing.JTable();
        input = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        keluar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 204, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel1.setText("KELOLA DATA BUKU");

        jLabel2.setText("ID BUKU");

        jLabel3.setText("JUDUL");

        jLabel4.setText("PENGARANG");

        jLabel5.setText("PENERBIT");

        jLabel6.setText("TAHUN");

        jLabel7.setText("LOKASI RAK");

        ID.setEnabled(false);

        TabelBuku.setModel(new javax.swing.table.DefaultTableModel(
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
        TabelBuku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelBukuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelBuku);

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
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(input)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(KLOKASI, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(edit)
                                .addGap(18, 18, 18)
                                .addComponent(delete)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addComponent(keluar))
                    .addComponent(JUDUL, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PENGARANG)
                    .addComponent(PENERBIT)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TAHUN, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(418, 418, 418))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(JUDUL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(PENGARANG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(PENERBIT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(TAHUN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(KLOKASI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(delete)
                            .addComponent(edit)
                            .addComponent(input)
                            .addComponent(keluar)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarActionPerformed
        // TODO add your handling code here:
        int keluar=JOptionPane.showOptionDialog(this, 
               "        Keluar dari Data Buku",
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

    private void TabelBukuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelBukuMouseClicked
        // TODO add your handling code here:
        int bar = TabelBuku.getSelectedRow();
        String a = TabelBuku.getValueAt(bar, 0).toString();
        String b = TabelBuku.getValueAt(bar, 1).toString();
        String c = TabelBuku.getValueAt(bar, 2).toString();
        String d = TabelBuku.getValueAt(bar, 3).toString();
        String e = TabelBuku.getValueAt(bar, 4).toString();
        String f = TabelBuku.getValueAt(bar, 5).toString();
        
        
        ID.setText(a);
        JUDUL.setText(b);
        PENGARANG.setText(c);
        PENERBIT.setText(d);
        TAHUN.setText(e);
        KLOKASI.setSelectedItem(f);
        
        //set disable input
        input.setEnabled(false);
        edit.setEnabled(true);
        delete.setEnabled(true);
    }//GEN-LAST:event_TabelBukuMouseClicked

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
            java.util.logging.Logger.getLogger(DataBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataBuku().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ID;
    private javax.swing.JTextField JUDUL;
    private javax.swing.JComboBox<String> KLOKASI;
    private javax.swing.JTextField PENERBIT;
    private javax.swing.JTextField PENGARANG;
    private javax.swing.JTextField TAHUN;
    private javax.swing.JTable TabelBuku;
    private javax.swing.JButton delete;
    private javax.swing.JButton edit;
    private javax.swing.JButton input;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton keluar;
    // End of variables declaration//GEN-END:variables
}
