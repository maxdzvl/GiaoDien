/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import VIEW.Connect;
import com.sun.org.apache.xpath.internal.operations.Quo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Huu Dat
 */
public class TraCuuPhong extends javax.swing.JFrame {
    DefaultTableModel t = new DefaultTableModel();
    
    /**
     * Creates new form TraCuuPhong
     */
    public TraCuuPhong() {
        initComponents();
        loadcb();
        LoadData();
    }

     public void loadcb(){
        try{
            Connect a = new Connect();
            Connection conn = a.getConnection();
            PreparedStatement ps = conn.prepareStatement("select MaLoaiPhong from PHONG group by MaLoaiPhong");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                CBMALOAI.addItem(rs.getString("MaLoaiPhong"));
            }
            
        }catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
    }
         public void LoadData(){
        try{
            Connect a = new Connect();
            Connection conn = a.getConnection();
            int number;
            Vector row,column ;
            column = new Vector();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select P.TenPhong [Tên Phòng], P.MaPhong [Mã Phòng], TenLoaiPhong [Tên Loại Phòng], DonGia [Đơn Giá], TinhTrang [Tình Trạng], NgayBatDauThue [Ngày Thuê], NgayTraPhong [Ngày Trả],HoTenKhachHang [Họ Tên Khách] "
                    + "from PHONG P,LOAIPHONG LP,CHITIETPHIEUTHUE, PHIEUTHUE "
                    + "WHERE P.MALOAIPHONG=LP.MALOAIPHONG GROUP BY P.MaPhong,TenPhong,HoTenKhachHang,TenLoaiPhong,DonGia,TinhTrang, NgayBatDauThue, NgayTraPhong");
            ResultSetMetaData metadata = rs.getMetaData();
            number = metadata.getColumnCount();//tra ve so cot
            for(int i = 1 ;i <= number; i++){
                column.add(metadata.getColumnName(i));
            }
            t.setColumnIdentifiers(column);
            while(rs.next()){
                row = new Vector();
                /*for(int i=1;i<= number; i++){
                    row.addElement(rs.getString(i));
                }*/
                t.addRow(row);
                tbTim.setModel(t);     
            }
                  
        } catch(SQLException ex){
            System.out.println(ex.toString());
        }
    }

     

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        lbTCPhong = new javax.swing.JLabel();
        lbTTPhongCT = new javax.swing.JLabel();
        lbMaPhong = new javax.swing.JLabel();
        lbTenPhong = new javax.swing.JLabel();
        lbKhachHang = new javax.swing.JLabel();
        lbMaLoaiPhong = new javax.swing.JLabel();
        lbTenLoaiPhong = new javax.swing.JLabel();
        lbDonGia = new javax.swing.JLabel();
        lbNgayThue = new javax.swing.JLabel();
        bThoat = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtMaPhong = new javax.swing.JTextField();
        txtTenPhong = new javax.swing.JTextField();
        txtKhachHang = new javax.swing.JTextField();
        CBMALOAI = new javax.swing.JComboBox<>();
        rbNgayThue = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbTim = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        txtGia2 = new javax.swing.JTextField();
        DCNgayThue = new com.toedter.calendar.JDateChooser();
        txtTenLoai = new javax.swing.JTextField();
        txtGia1 = new javax.swing.JTextField();
        bTim = new javax.swing.JButton();
        bXoa = new javax.swing.JButton();
        DCNgayTra = new com.toedter.calendar.JDateChooser();

        jScrollPane2.setViewportView(jTextPane1);

        lbTCPhong.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbTCPhong.setForeground(new java.awt.Color(51, 51, 255));
        lbTCPhong.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTCPhong.setText("Tra Cứu Phòng");

        lbTTPhongCT.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbTTPhongCT.setForeground(new java.awt.Color(255, 0, 255));
        lbTTPhongCT.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbTTPhongCT.setText("Thông tin phòng cần tìm");

        lbMaPhong.setText("Mã phòng");

        lbTenPhong.setText("Tên phòng");

        lbKhachHang.setText("Khách hàng");

        lbMaLoaiPhong.setText("Mã loại phòng");

        lbTenLoaiPhong.setText("Tên loại phòng");

        lbDonGia.setText("Đơn giá");

        lbNgayThue.setText("Ngày thuê");

        bThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/001_23.gif"))); // NOI18N
        bThoat.setText("Thoát");
        bThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bThoatActionPerformed(evt);
            }
        });

        jLabel11.setText("đến");

        CBMALOAI.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Chọn--" }));
        CBMALOAI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBMALOAIActionPerformed(evt);
            }
        });

        rbNgayThue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbNgayThueActionPerformed(evt);
            }
        });

        tbTim.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Phòng", "Mã phòng", "Loại phòng", "Đơn giá", "Tình trạng", "Ngày thuê", "Ngày trả", "Khách hàng"
            }
        ));
        jScrollPane1.setViewportView(tbTim);
        if (tbTim.getColumnModel().getColumnCount() > 0) {
            tbTim.getColumnModel().getColumn(6).setResizable(false);
        }

        jLabel12.setText("đến");

        txtTenLoai.setEditable(false);

        bTim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/svn_added.png"))); // NOI18N
        bTim.setText("Tìm Kiếm");
        bTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTimActionPerformed(evt);
            }
        });
        bTim.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bTimKeyPressed(evt);
            }
        });

        bXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/svn_deleted.png"))); // NOI18N
        bXoa.setText("Xóa");
        bXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbTCPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbTenPhong)
                            .addComponent(lbMaPhong)
                            .addComponent(lbKhachHang))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtKhachHang)
                                    .addComponent(txtMaPhong, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(77, 77, 77)
                                        .addComponent(lbMaLoaiPhong))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(70, 70, 70)
                                        .addComponent(lbDonGia)
                                        .addGap(6, 6, 6)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txtTenPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                                .addComponent(rbNgayThue)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbNgayThue)
                                .addGap(10, 10, 10)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(CBMALOAI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbTenLoaiPhong))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtGia1, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                            .addComponent(DCNgayThue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(DCNgayTra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                                    .addComponent(txtGia2)
                                    .addComponent(txtTenLoai)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bTim)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(120, 120, 120)
                                        .addComponent(bThoat))
                                    .addComponent(bXoa)))))
                    .addComponent(lbTTPhongCT, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbTCPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbTTPhongCT, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMaPhong)
                    .addComponent(txtMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbMaLoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CBMALOAI, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTenLoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lbTenPhong)
                                        .addComponent(txtTenPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lbNgayThue, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(DCNgayThue, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(rbNgayThue)))
                                .addGap(10, 10, 10))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbDonGia)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtGia1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtGia2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbKhachHang)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bThoat, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                            .addComponent(bTim, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                            .addComponent(bXoa, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(DCNgayTra, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbNgayThueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbNgayThueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbNgayThueActionPerformed

    private void bThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bThoatActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_bThoatActionPerformed

    private void CBMALOAIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBMALOAIActionPerformed
        // TODO add your handling code here:
        try{
            Connect c = new Connect();
            Connection co = c.getConnection();
            PreparedStatement ps = co.prepareStatement("select * from LOAIPHONG");
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                if(CBMALOAI.getSelectedItem().toString().equalsIgnoreCase(rs.getString("MaLoaiPhong"))){
                    txtTenLoai.setText(rs.getString("TenLoaiPhong"));
                    //txtDonGia.setText(rs.getString("DonGia"));
                    
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(TraCuuPhong.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_CBMALOAIActionPerformed

    private void bTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTimActionPerformed
        // TODO add your handling code here:
        
        try {
            
            Connect c = new Connect();
            Connection co = c.getConnection();
            Statement st = co.createStatement();    
            Vector data = null;
            t.setRowCount(0);
            
            String maP = "";
            maP = txtMaPhong.getText();
            String tracuuMaP = "exec MaP '%"+maP+"%'";
            
            String MLP = "";
            MLP = CBMALOAI.getSelectedItem().toString();
            String tracuuMaL = "exec MaL '"+MLP+"'";
            
            String TenP = "";
            TenP = txtTenPhong.getText();
            String tracuuTenP = "exec TenP '%"+TenP+"%'";
            
            String KH = "";
            KH = txtKhachHang.getText();
            String tracuuKH = "exec KH '%"+KH+"%'";
            String Tam = "";
            String Tam2 ="";
        if (maP.isEmpty() == true && TenP.isEmpty() == true && KH.isEmpty() == true && txtTenLoai.getText().isEmpty() == true ) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập dữ liệu trước khi tìm kiếm!!!");
                //JOptionPane.showMessageDialog(this, "Không tìm thấy!!!");
            } else {
                if(maP.isEmpty() == false && TenP.isEmpty() == false && KH.isEmpty() == true && txtTenLoai.getText().isEmpty() == true )
                    {
                        Tam=tracuuMaP;
                        Tam2=tracuuTenP;
                        
                    }
                if(maP.isEmpty() == true && TenP.isEmpty() == true && KH.isEmpty() == false && txtTenLoai.getText().isEmpty() == false ){
                        Tam=tracuuKH;
                        Tam2=tracuuMaL;
                    }
                if(maP.isEmpty() == false && TenP.isEmpty() == true && KH.isEmpty() == false && txtTenLoai.getText().isEmpty() == true ){
                        Tam=tracuuMaP;
                        Tam2=tracuuKH;
                    }
                if(maP.isEmpty() == true && TenP.isEmpty() == false && KH.isEmpty() == true && txtTenLoai.getText().isEmpty() == false ){
                        Tam=tracuuTenP;
                        Tam2=tracuuMaL;
                    }
                if(maP.isEmpty() == false && TenP.isEmpty() == true && KH.isEmpty() == true && txtTenLoai.getText().isEmpty() == false ){
                        Tam=tracuuMaP;
                        Tam2=tracuuMaL;
                    }
                if(maP.isEmpty() == true && TenP.isEmpty() == false && KH.isEmpty() == false && txtTenLoai.getText().isEmpty() == true ){
                        Tam=tracuuTenP;
                        Tam2=tracuuKH;
                    }
                
                if(maP.isEmpty() == false && TenP.isEmpty() == true && KH.isEmpty() == true && txtTenLoai.getText().isEmpty() == true )
                {
                    Tam=tracuuMaP;
                    Tam2=null;
                }
                if(maP.isEmpty() == true && TenP.isEmpty() == false && KH.isEmpty() == true && txtTenLoai.getText().isEmpty() == true )
                {
                    Tam=tracuuTenP;
                    Tam2=null;
                }
                if(maP.isEmpty() == true && TenP.isEmpty() == true && KH.isEmpty() == false && txtTenLoai.getText().isEmpty() == true )
                {
                    Tam=tracuuKH;
                    Tam2=null;
                }
                if(maP.isEmpty() == true && TenP.isEmpty() == true && KH.isEmpty() == true && txtTenLoai.getText().isEmpty() == false )
                {
                    Tam=tracuuMaL;
                    Tam2=null;
                }
                //cùng có
                
             
                //JOptionPane.showMessageDialog(this, "Chương Trình Chưa Hỗ Trợ!!!");
                
                }
                String tracuu = Tam;
                ResultSet rs = st.executeQuery(tracuu);
                // mở cái này là chạy dc tìm 2 cái
                    //String tracuu2 = Tam2;
                    //rs = st.executeQuery(tracuu2);
             
                
            while (rs.next()){
                data = new Vector();
                data.add(rs.getString("TenPhong"));
                data.add(rs.getString("MaPhong"));
                data.add(rs.getString("TenLoaiPhong"));
                data.add(rs.getString("DonGia"));
                data.add(rs.getString("TinhTrang"));
                data.add(rs.getString("NgayBatDauThue"));
                data.add(rs.getString("NgayTraPhong"));
                data.add(rs.getString("HoTenKhachHang"));
                t.addRow(data);
                }
            
        } catch (Exception e) {
          } 
        
    }//GEN-LAST:event_bTimActionPerformed

    private void bXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bXoaActionPerformed
        // TODO add your handling code here:
        txtMaPhong.setText("");
        txtTenPhong.setText("");
        txtKhachHang.setText("");
        txtTenLoai.setText("");
        txtGia1.setText("");
        txtGia2.setText("");
        t.setRowCount(0);
    }//GEN-LAST:event_bXoaActionPerformed

    private void bTimKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bTimKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_bTimKeyPressed

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
            java.util.logging.Logger.getLogger(TraCuuPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TraCuuPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TraCuuPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TraCuuPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new TraCuuPhong().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CBMALOAI;
    private com.toedter.calendar.JDateChooser DCNgayThue;
    private com.toedter.calendar.JDateChooser DCNgayTra;
    private javax.swing.JButton bThoat;
    private javax.swing.JButton bTim;
    private javax.swing.JButton bXoa;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JLabel lbDonGia;
    private javax.swing.JLabel lbKhachHang;
    private javax.swing.JLabel lbMaLoaiPhong;
    private javax.swing.JLabel lbMaPhong;
    private javax.swing.JLabel lbNgayThue;
    private javax.swing.JLabel lbTCPhong;
    private javax.swing.JLabel lbTTPhongCT;
    private javax.swing.JLabel lbTenLoaiPhong;
    private javax.swing.JLabel lbTenPhong;
    private javax.swing.JRadioButton rbNgayThue;
    private javax.swing.JTable tbTim;
    private javax.swing.JTextField txtGia1;
    private javax.swing.JTextField txtGia2;
    private javax.swing.JTextField txtKhachHang;
    private javax.swing.JTextField txtMaPhong;
    private javax.swing.JTextField txtTenLoai;
    private javax.swing.JTextField txtTenPhong;
    // End of variables declaration//GEN-END:variables
}
