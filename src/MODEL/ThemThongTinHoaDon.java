package MODEL;

import static MODEL.PhieuThuePhong.converUtilDateToSqlDate;
import VIEW.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ThemThongTinHoaDon extends javax.swing.JFrame {

    public ThemThongTinHoaDon() {
        initComponents();
        LoadCB();
        loadMa();
    }

public void LoadCB(){
        try{
            Connect a = new Connect();
            Connection conn = a.getConnection();
            PreparedStatement ps = conn.prepareStatement("select MaPhieuThue from PHIEUTHUE");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                cbMaPhieuThue.addItem(rs.getString("MaPhieuThue"));
            }
            PreparedStatement ps1 = conn.prepareStatement("select TILEPHUTHU from THAMSO");
            ResultSet rs1 = ps1.executeQuery();
            while(rs1.next()){
                cbTyLePhuThu.addItem(rs1.getString("TILEPHUTHU"));
            }
            PreparedStatement ps2 = conn.prepareStatement("select HeSoLoaiKhach from LOAIKHACH");
            ResultSet rs2 = ps2.executeQuery();
            while(rs2.next()){
                cbHeSo.addItem(rs2.getString("HeSoLoaiKhach"));
            }
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
    }
public static java.sql.Date converUtilDateToSqlDate(java.util.Date date){
        if (date != null){
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            return sqlDate;
        }
        return null;
    }
public void loadMa(){
        try{
            Connect a = new Connect();
            Connection conn = a.getConnection();
            PreparedStatement ps = conn.prepareStatement("select MaHoaDon from HOADON");
            ResultSet rs = ps.executeQuery();
            txtMHD.setEnabled(false);
            while(rs.next()){
                txtMHD.setText(rs.getString("MaHoaDon"));
            }
            
        }catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
        
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTTHD = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtDonGia = new javax.swing.JTextField();
        txtSL = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        cbTyLePhuThu = new javax.swing.JComboBox<>();
        cbHeSo = new javax.swing.JComboBox<>();
        cbMaPhieuThue = new javax.swing.JComboBox<>();
        txtMaPhong = new javax.swing.JTextField();
        txtMHD = new javax.swing.JTextField();
        bThem = new javax.swing.JButton();
        bThoat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbTTHD.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbTTHD.setForeground(new java.awt.Color(51, 51, 255));
        lbTTHD.setText("Thêm thông tin hóa đơn");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 204));
        jLabel2.setText("Thông tin chi tiết hóa đơn:");

        jLabel3.setText("Mã phiếu thuê");

        jLabel4.setText("Mã phòng");

        jLabel6.setText("Ngày trả phòng");

        jLabel9.setText("Đơn giá");

        jLabel10.setText("Số lượng khách");

        jLabel11.setText("Tỉ lệ phụ thu");

        jLabel13.setText("Hệ số loại khách");

        cbMaPhieuThue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMaPhieuThueActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbMaPhieuThue, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 190, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSL, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbTyLePhuThu, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbHeSo, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 74, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtMHD, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(cbHeSo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(cbMaPhieuThue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtSL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(cbTyLePhuThu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40))))
        );

        bThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/svn_added.png"))); // NOI18N
        bThem.setText("Thêm");
        bThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bThemActionPerformed(evt);
            }
        });

        bThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/001_23.gif"))); // NOI18N
        bThoat.setText("Thoát");
        bThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bThoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(bThem, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bThoat)
                .addGap(131, 131, 131))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(213, 213, 213)
                        .addComponent(lbTTHD)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbTTHD)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bThem)
                    .addComponent(bThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bThemActionPerformed
        int ret = JOptionPane.showConfirmDialog(this, "Bạn có muốn lập phiếu không?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (ret != JOptionPane.YES_OPTION) {
            return;
        }
        try{
            Connect a = new Connect();
            Connection conn = a.getConnection();
            PreparedStatement ps = conn.prepareStatement( "UPDATE PHIEUTHUE set NgayTraPhong = '"+ converUtilDateToSqlDate(jDateChooser1.getDate()) + "',TyLePhuThuThucTe='"+cbTyLePhuThu.getSelectedItem().toString()+"',MaHoaDon='"+ txtMHD.getText() + "' where MaPhieuThue=?");
            ps.setString(1, cbMaPhieuThue.getSelectedItem().toString());
            PreparedStatement ps1 = conn.prepareStatement( "UPDATE PHIEUTHUE set SoNgayThue= (case when convert(int,NgayTraPhong-NgayBatDauThue)>0 then convert(int,NgayTraPhong-NgayBatDauThue) else 1  end ) where MaPhieuThue=?");
            ps1.setString(1, cbMaPhieuThue.getSelectedItem().toString());
            PreparedStatement ps2 = conn.prepareStatement( "UPDATE PHIEUTHUE set ThanhTien=SoNgayThue*DonGiaThucTe*TyLePhuThuThucTe where MaPhieuThue=?");
            ps2.setString(1, cbMaPhieuThue.getSelectedItem().toString());
            ret = ps.executeUpdate();  
            ps1.executeUpdate();  
            ps2.executeUpdate(); 
            if (ret > 0) {
                JOptionPane.showMessageDialog(this, "Thêm Thành Công");
            } else {
                JOptionPane.showMessageDialog(this,"Thêm Thất Bại");
                        }
                setVisible(false);
        }catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_bThemActionPerformed

    private void bThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bThoatActionPerformed
        setVisible(false);
    }//GEN-LAST:event_bThoatActionPerformed

    private void cbMaPhieuThueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMaPhieuThueActionPerformed
        // TODO add your handling code here:
try{
            Connect c = new Connect();
            Connection co = c.getConnection();
            PreparedStatement ps = co.prepareStatement("select * from PHIEUTHUE");
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                if(cbMaPhieuThue.getSelectedItem().toString().equalsIgnoreCase(rs.getString("MaPhieuThue"))){
                    txtMaPhong.setText(rs.getString("MaPhong"));
                    txtDonGia.setText(rs.getString("DonGiaThucTe"));
                }
            }
            PreparedStatement ps1 = co.prepareStatement("select C.MaPhieuThue,count(C.MaPhieuThue) as SL from CHITIETPHIEUTHUE C,PHIEUTHUE P  where C.MaPhieuThue=P.MaPhieuThue group by C.MaPhieuThue");
            ResultSet rs1 = ps1.executeQuery();
            while(rs1.next())
            {
                if(cbMaPhieuThue.getSelectedItem().toString().equalsIgnoreCase(rs1.getString("MaPhieuThue"))){
                    txtSL.setText(rs1.getString("SL"));
                    
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThemThongTinHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cbMaPhieuThueActionPerformed

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
            java.util.logging.Logger.getLogger(ThemThongTinHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThemThongTinHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThemThongTinHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThemThongTinHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThemThongTinHoaDon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bThem;
    private javax.swing.JButton bThoat;
    private javax.swing.JComboBox<String> cbHeSo;
    private javax.swing.JComboBox<String> cbMaPhieuThue;
    private javax.swing.JComboBox<String> cbTyLePhuThu;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbTTHD;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtMHD;
    private javax.swing.JTextField txtMaPhong;
    private javax.swing.JTextField txtSL;
    // End of variables declaration//GEN-END:variables
}
