package MODEL;

import static MODEL.PhieuThuePhong.converUtilDateToSqlDate;
import VIEW.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class HoaDonThanhToan extends javax.swing.JFrame {
    private String header[] = {"Mã Hóa Đơn","Mã Phiếu Thuê", "Mã Phòng", "Số Ngày Thuê", "Thành Tiền","Tỷ Lệ Phụ Thu","Hệ Số Loại Khách"};
    private DefaultTableModel HD = new DefaultTableModel(header, 0);
    
    public HoaDonThanhToan() {
        initComponents();
        LoadData();
        LoadCB();
    }
public void LoadCB(){
        try{
            Connect a = new Connect();
            Connection conn = a.getConnection();
            PreparedStatement ps1 = conn.prepareStatement("select KhachHang from PHIEUTHUE where KhachHang  not in(select HoTenKhachHangThucTe from HOADON)");
            ResultSet rs1 = ps1.executeQuery();
            while(rs1.next()){
                cbKH.addItem(rs1.getString("KhachHang"));
            }   
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
    }
    public void LoadData(){
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try{
            Connect a = new Connect();
            conn = a.getConnection();
            st = conn.createStatement();
            String sql = "select MaHoaDon,C.MaPhieuThue,MaPhong,SoNgayThue,ThanhTien,TyLePhuThuThucTe,HeSoLoaiKhach from PHIEUTHUE T,CHITIETPHIEUTHUE C,LOAIKHACH K where MaHoaDon is not null and C.MaPhieuThue=T.MaPhieuThue and C.MaLoaiKhach=K.MaLoaiKhach group by MaHoaDon,C.MaPhieuThue,MaPhong,SoNgayThue,ThanhTien,TyLePhuThuThucTe,HeSoLoaiKhach";
            rs = st.executeQuery(sql);
            Vector data = null;
            HD.setRowCount(0);
            while (rs.next()) {
                data = new Vector();
                data.add(rs.getString("MaHoaDon"));
                data.add(rs.getString("MaPhieuThue"));
                data.add(rs.getString("MaPhong"));
                data.add(rs.getLong("SoNgayThue"));
                data.add(rs.getString("ThanhTien"));
                data.add(rs.getString("TyLePhuThuThucTe"));
                data.add(rs.getString("HeSoLoaiKhach"));
                HD.addRow(data);
            }
            tbCTHD.setModel(HD);
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (st != null) {
                    st.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbHDThanhToan = new javax.swing.JLabel();
        lbTTHoaDon = new javax.swing.JLabel();
        lbKHCQ = new javax.swing.JLabel();
        lbDCLH = new javax.swing.JLabel();
        lbCTHD = new javax.swing.JLabel();
        lbMaHD = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        txtMaHoaDon = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCTHD = new javax.swing.JTable();
        bThemPhieuThue = new javax.swing.JButton();
        bThoat = new javax.swing.JButton();
        bHuy = new javax.swing.JButton();
        bThem = new javax.swing.JButton();
        cbKH = new javax.swing.JComboBox<>();
        bLamMoi = new javax.swing.JButton();

        lbHDThanhToan.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbHDThanhToan.setForeground(new java.awt.Color(0, 0, 255));
        lbHDThanhToan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbHDThanhToan.setText("Lập Hóa Đơn Thanh Toán");

        lbTTHoaDon.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbTTHoaDon.setForeground(new java.awt.Color(204, 0, 204));
        lbTTHoaDon.setText("Thông tin hóa đơn");

        lbKHCQ.setText("Khách hàng/Cơ quan");

        lbDCLH.setText("Địa chỉ liên hệ");

        lbCTHD.setText("Chi tiết hóa đơn");

        lbMaHD.setText("Mã hóa đơn");

        tbCTHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã phiếu thuê", "Mã phòng", "Số ngày thuê", "Đơn giá", "Hệ số loại khách", "Tỷ lệ phụ thu", "Thành viên"
            }
        ));
        jScrollPane1.setViewportView(tbCTHD);

        bThemPhieuThue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/001_01.gif"))); // NOI18N
        bThemPhieuThue.setText("Thêm Thông Tin Hóa Đơn");
        bThemPhieuThue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bThemPhieuThueActionPerformed(evt);
            }
        });

        bThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/001_23.gif"))); // NOI18N
        bThoat.setText("Thoát");
        bThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bThoatActionPerformed(evt);
            }
        });

        bHuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/svn_deleted.png"))); // NOI18N
        bHuy.setText("Xóa");
        bHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bHuyActionPerformed(evt);
            }
        });

        bThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/svn_added.png"))); // NOI18N
        bThem.setText("Thêm");
        bThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bThemActionPerformed(evt);
            }
        });

        cbKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbKHActionPerformed(evt);
            }
        });

        bLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/001_39.gif"))); // NOI18N
        bLamMoi.setText("Làm Mới");
        bLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLamMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 703, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbKHCQ)
                            .addComponent(lbDCLH))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbKH, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbMaHD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbTTHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbCTHD)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(bThemPhieuThue)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(bThem)
                                .addGap(67, 67, 67)
                                .addComponent(bHuy)
                                .addGap(74, 74, 74)
                                .addComponent(bThoat)
                                .addGap(168, 168, 168))))))
            .addComponent(lbHDThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbHDThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbTTHoaDon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbKHCQ)
                        .addComponent(lbMaHD)
                        .addComponent(cbKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDCLH)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(lbCTHD, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bThemPhieuThue)
                    .addComponent(bLamMoi))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bThoat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bThem, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bThoatActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_bThoatActionPerformed

    private void bThemPhieuThueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bThemPhieuThueActionPerformed
        ThemThongTin tk = new ThemThongTin();
        tk.setVisible(true);
    }//GEN-LAST:event_bThemPhieuThueActionPerformed

    private void bThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bThemActionPerformed
        // TODO add your handling code here:
        int ret = JOptionPane.showConfirmDialog(this, "Bạn có muốn lập hóa đơn không?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (ret != JOptionPane.YES_OPTION) {
            return;
        }
        try{
            Connect a = new Connect();
            Connection conn = a.getConnection();
            PreparedStatement ps = conn.prepareStatement( "INSERT INTO HOADON (MaHoaDon,HoTenKhachHangThucTe,DiaChiThucTe) VALUES(?,?,?)");
            ps.setString(1, txtMaHoaDon.getText());
            ps.setString(2, cbKH.getSelectedItem().toString());
            ps.setString(3, txtDiaChi.getText());
            ret = ps.executeUpdate();
            if (ret > 0) {
                JOptionPane.showMessageDialog(this, "Thêm Thành Công");
            } else {
                JOptionPane.showMessageDialog(this,"Thêm Thất Bại");
                        }
            LoadData();
        }catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_bThemActionPerformed

    private void cbKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbKHActionPerformed
          try{
            Connect c = new Connect();
            Connection co = c.getConnection();
            PreparedStatement ps = co.prepareStatement("select * from CHITIETPHIEUTHUE,PHIEUTHUE");
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                if(cbKH.getSelectedItem().toString().equalsIgnoreCase(rs.getString("KhachHang"))){
                    txtDiaChi.setText(rs.getString("DiaChi"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucPhong.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cbKHActionPerformed

    private void bLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLamMoiActionPerformed
        LoadData();
    }//GEN-LAST:event_bLamMoiActionPerformed

    private void bHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHuyActionPerformed
        // TODO add your handling code here:
        try {
            Connect a = new Connect();
            Connection conn = a.getConnection();
            PreparedStatement pre1 = conn.prepareStatement("delete HOADON where MaHoaDon=?");
            pre1.setString(1,tbCTHD.getValueAt(tbCTHD.getSelectedRow(),0).toString());
            PreparedStatement pre2 = conn.prepareStatement( "Update PHIEUTHUE set NgayTraPhong=null,SoNgayThue=null,ThanhTien=null,MaHoaDon=null,TyLePhuThuThucTe=null from PHIEUTHUE where MaHoaDon=?");
            pre2.setString(1,tbCTHD.getValueAt(tbCTHD.getSelectedRow(),0).toString());
            if(JOptionPane.showConfirmDialog(this,"Xác Nhận Xóa?","Ðồng Ý",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
            {
                pre2.executeUpdate();
                pre1.executeUpdate();
                HD.setRowCount(0);
                LoadData();
                setVisible(false);
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_bHuyActionPerformed

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
            java.util.logging.Logger.getLogger(HoaDonThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HoaDonThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HoaDonThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HoaDonThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HoaDonThanhToan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bHuy;
    private javax.swing.JButton bLamMoi;
    private javax.swing.JButton bThem;
    private javax.swing.JButton bThemPhieuThue;
    private javax.swing.JButton bThoat;
    private javax.swing.JComboBox<String> cbKH;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbCTHD;
    private javax.swing.JLabel lbDCLH;
    private javax.swing.JLabel lbHDThanhToan;
    private javax.swing.JLabel lbKHCQ;
    private javax.swing.JLabel lbMaHD;
    private javax.swing.JLabel lbTTHoaDon;
    private javax.swing.JTable tbCTHD;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtMaHoaDon;
    // End of variables declaration//GEN-END:variables
}
