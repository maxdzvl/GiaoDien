package MODEL;

import VIEW.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class PhieuThuePhong extends javax.swing.JFrame {
    private String header[] = {"Mã Phiếu Thuê", "Khách Hàng", "CMND", "Địa Chỉ", "Loại Khách","Tên Phòng","Mã Phòng","Đơn Giá","Ngày Thuê"};
    private DefaultTableModel PT = new DefaultTableModel(header, 0);

    public PhieuThuePhong() {
        initComponents();
        LoadData();
        LoadCB();
    }
    public void LoadCB(){
        try{
            Connect a = new Connect();
            Connection conn = a.getConnection();
            PreparedStatement ps1 = conn.prepareStatement("select MaLoaiKhach from LOAIKHACH group by MaLoaiKhach ");
            ResultSet rs1 = ps1.executeQuery();
            while(rs1.next()){
                cbLoaiKhach.addItem(rs1.getString("MaLoaiKhach"));
            }   
            PreparedStatement ps = conn.prepareStatement("select MaPhong from PHONG where TinhTrang=N'Trống' group by MaPhong ");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                cbMaPhong.addItem(rs.getString("MaPhong"));
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
            String sql = "select C.MaPhieuThue,HoTenKhachHang,CMND,DiaChi,TenLoaiKhach,TenPhong,MaLoaiPhong,DonGiaThucTe,NgayBatDauThue from CHITIETPHIEUTHUE C,PHIEUTHUE T,PHONG P,LOAIKHACH K WHERE  P.MAPHONG=T.MAPHONG AND T.MAPHIEUTHUE=C.MAPHIEUTHUE AND C.MALOAIKHACH=K.MALOAIKHACH";
            rs = st.executeQuery(sql);
            Vector data = null;
            PT.setRowCount(0);
            while (rs.next()) {
                data = new Vector();
                data.add(rs.getString("MaPhieuThue"));
                data.add(rs.getString("HoTenKhachHang"));
                data.add(rs.getLong("CMND"));
                data.add(rs.getString("DiaChi"));
                data.add(rs.getString("TenLoaiKhach"));
                data.add(rs.getString("TenPhong"));
                data.add(rs.getString("MaLoaiPhong"));
                data.add(rs.getString("DonGiaThucTe"));
                data.add(rs.getDate("NgayBatDauThue"));
                PT.addRow(data);
            }
            tbDSKH.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent lse) {
                  // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                   if(tbDSKH.getSelectedRow() >= 0){
                       txtMaPhieuThue.setText(tbDSKH.getValueAt(tbDSKH.getSelectedRow(), 0) + "");
                       txtKhachHang.setText(tbDSKH.getValueAt(tbDSKH.getSelectedRow(), 1) + "");
                       txtCMND.setText(tbDSKH.getValueAt(tbDSKH.getSelectedRow(), 2) + "");
                       txtDiaChi.setText(tbDSKH.getValueAt(tbDSKH.getSelectedRow(), 3) + "");
                       cbLoaiKhach.setSelectedItem(tbDSKH.getValueAt(tbDSKH.getSelectedRow(), 4) + "");
                       cbMaPhong.setSelectedItem(tbDSKH.getValueAt(tbDSKH.getSelectedRow(), 5) + "");
                       txtLoaiPhong.setText(tbDSKH.getValueAt(tbDSKH.getSelectedRow(), 6) + "");
                       txtDonGia.setText(tbDSKH.getValueAt(tbDSKH.getSelectedRow(), 7) + "");
                //       jDateChooser1.setDate(tbDSKH.getValueAt(tbDSKH.getSelectedRow(), 8) + "");
                   }
                }
            });  
            tbDSKH.setModel(PT);
            
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
public static java.sql.Date converUtilDateToSqlDate(java.util.Date date){
        if (date != null){
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            return sqlDate;
        }
        return null;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lbMaPhieuThue = new javax.swing.JLabel();
        lbKhachHang = new javax.swing.JLabel();
        lbCMND = new javax.swing.JLabel();
        lbLoaiKhach = new javax.swing.JLabel();
        lbTenPhong = new javax.swing.JLabel();
        lbMaPhong = new javax.swing.JLabel();
        lbDonGia = new javax.swing.JLabel();
        lbNgayThue = new javax.swing.JLabel();
        txtMaPhieuThue = new javax.swing.JTextField();
        txtKhachHang = new javax.swing.JTextField();
        txtCMND = new javax.swing.JTextField();
        lbDiaChi = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        cbLoaiKhach = new javax.swing.JComboBox<>();
        cbMaPhong = new javax.swing.JComboBox<>();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        txtLoaiPhong = new javax.swing.JTextField();
        txtDonGia = new javax.swing.JTextField();
        lbDSKH = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDSKH = new javax.swing.JTable();
        bThem = new javax.swing.JButton();
        bXoa = new javax.swing.JButton();
        bThoat = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        bThemKhach = new javax.swing.JButton();

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lập Phiếu Thuê Phòng", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(0, 0, 255))); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin phòng thuê", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(255, 0, 255))); // NOI18N

        lbMaPhieuThue.setText("Mã phiếu thuê:");

        lbKhachHang.setText("Khách Hàng:");

        lbCMND.setText("CMND:");

        lbLoaiKhach.setText("Loại Khách:");

        lbTenPhong.setText("Mã phòng:");

        lbMaPhong.setText("Loại Phòng:");

        lbDonGia.setText("Đơn giá:");

        lbNgayThue.setText("Ngày thuê:");

        lbDiaChi.setText("Địa Chỉ:");

        cbMaPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMaPhongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbNgayThue)
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbLoaiKhach, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbTenPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbLoaiKhach, 0, 110, Short.MAX_VALUE)
                            .addComponent(cbMaPhong, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbMaPhong)
                            .addComponent(lbDonGia))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbKhachHang)
                            .addComponent(lbCMND)
                            .addComponent(lbMaPhieuThue)
                            .addComponent(lbDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtCMND, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                            .addComponent(txtKhachHang, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaPhieuThue, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDiaChi))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMaPhieuThue)
                    .addComponent(txtMaPhieuThue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbKhachHang)
                    .addComponent(txtKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCMND)
                    .addComponent(txtCMND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDiaChi)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbLoaiKhach, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbLoaiKhach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTenPhong)
                    .addComponent(cbMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMaPhong)
                    .addComponent(txtLoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDonGia)
                    .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbNgayThue)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lbDSKH.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbDSKH.setForeground(new java.awt.Color(153, 0, 153));
        lbDSKH.setText("Danh sách phiếu thuê:");

        tbDSKH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Phiếu Thuê", "Khách hàng", "CMND", "Địa chỉ", "Loại khách", "Mã Phòng", "Loại Phòng", "Ngày Thuê"
            }
        ));
        jScrollPane1.setViewportView(tbDSKH);

        bThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/svn_added.png"))); // NOI18N
        bThem.setText("Thêm ");
        bThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bThemActionPerformed(evt);
            }
        });

        bXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/svn_deleted.png"))); // NOI18N
        bXoa.setText("Xóa");
        bXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bXoaActionPerformed(evt);
            }
        });

        bThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/001_23.gif"))); // NOI18N
        bThoat.setText("Thoát");
        bThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bThoatActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/001_39.gif"))); // NOI18N
        jButton1.setText("Làm Mới");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        bThemKhach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/001_01.gif"))); // NOI18N
        bThemKhach.setText("Thêm Khách");
        bThemKhach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bThemKhachActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(bThem, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(lbDSKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(506, 506, 506))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(169, 169, 169)
                                .addComponent(bXoa, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                                .addGap(169, 169, 169)
                                .addComponent(bThoat, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(76, 76, 76)
                        .addComponent(bThemKhach)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lbDSKH, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bThemKhach)
                    .addComponent(jButton1))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bThem)
                    .addComponent(bXoa)
                    .addComponent(bThoat))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bXoaActionPerformed
        // TODO add your handling code here:
        try {
            Connect a = new Connect();
            Connection conn = a.getConnection();
            PreparedStatement pre = conn.prepareStatement("delete CHITIETPHIEUTHUE where MaPhieuThue=?");
            pre.setString(1,tbDSKH.getValueAt(tbDSKH.getSelectedRow(),0).toString());
            PreparedStatement pre1 = conn.prepareStatement("delete PHIEUTHUE where MaPhieuThue=?");
            pre1.setString(1,tbDSKH.getValueAt(tbDSKH.getSelectedRow(),0).toString());
            PreparedStatement pre2 = conn.prepareStatement( "Update PHONG set TinhTrang=N'Trống' from PHONG,PHIEUTHUE where PHONG.MaPhong=PHIEUTHUE.MaPhong and MaPhieuThue=?");
            pre2.setString(1,tbDSKH.getValueAt(tbDSKH.getSelectedRow(),0).toString());
            if(JOptionPane.showConfirmDialog(this,"Xác Nhận Xóa?","Ðồng Ý",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
            {
                pre2.executeUpdate();
                pre.executeUpdate();
                pre1.executeUpdate();
                PT.setRowCount(0);
                LoadData();
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_bXoaActionPerformed

    private void bThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bThemActionPerformed
        // TODO add your handling code here:
        int ret = JOptionPane.showConfirmDialog(this, "Bạn có muốn lập phiếu không?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (ret != JOptionPane.YES_OPTION) {
            return;
        }
        try{
            Connect a = new Connect();
            Connection conn = a.getConnection();
            PreparedStatement ps = conn.prepareStatement( "INSERT INTO PHIEUTHUE (MaPhieuThue,MaPhong,DonGiaThucTe,NgayBatDauThue) VALUES(?,?,?,?)");
            ps.setString(1, txtMaPhieuThue.getText());       
            ps.setString(2, cbMaPhong.getSelectedItem().toString());
            ps.setString(3, txtDonGia.getText());
            ps.setDate(4, converUtilDateToSqlDate(jDateChooser1.getDate()));
            PreparedStatement ps1 = conn.prepareStatement( "INSERT INTO CHITIETPHIEUTHUE (MaChiTietPhieuThue,MaPhieuThue,HoTenKhachHang,CMND,DiaChi,MaLoaiKhach) VALUES(0,?,?,?,?,?)");
            ps1.setString(1, txtMaPhieuThue.getText());
            char []ten = txtKhachHang.getText().toCharArray();
            for(int i=0; i<ten.length; i++)
            {
                if(Character.isWhitespace(ten[i])==false && Character.isAlphabetic(ten[i])==false )
                {
                    JOptionPane.showMessageDialog(this,"Vui lòng nhập tên đúng cú pháp \nXin cảm ơn");
                    return;
                }
            }
            ps1.setString(2,txtKhachHang.getText());
            char []cmnd = txtCMND.getText().toCharArray();
            for(int i=0; i<cmnd.length; i++)
            {
                if(Character.isDigit(cmnd[i])==false)
                {
                    JOptionPane.showMessageDialog(this,"CMND Vui lòng nhập các ký tự số!!");
                    return;
                }
            }
            if(cmnd.length!=9 && cmnd.length!=12)
            {
                JOptionPane.showMessageDialog(this,"Vui lòng nhập đúng CMND!!");
                return;
            }
            ps1.setString(3,txtCMND.getText());
            ps1.setString(4,txtDiaChi.getText());
            ps1.setString(5, cbLoaiKhach.getSelectedItem().toString());
            PreparedStatement pre = conn.prepareStatement( "Update PHONG set TinhTrang=N'Đã Thuê' where MaPhong=?");
            pre.setString(1, cbMaPhong.getSelectedItem().toString());
            ret = ps.executeUpdate();
            ps1.executeUpdate();
            pre.executeUpdate();
            if (ret > 0) {
                JOptionPane.showMessageDialog(this, "Thêm Thành Công");
            } else {
                JOptionPane.showMessageDialog(this,"Thêm Thất Bại");
                        }
                PT.setRowCount(0);
                LoadData();
        }catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_bThemActionPerformed

    private void bThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bThoatActionPerformed
       
        setVisible(false);
    }//GEN-LAST:event_bThoatActionPerformed

    private void bThemKhachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bThemKhachActionPerformed
       
        ThemKhach tk = new ThemKhach();
        tk.setVisible(true);
    }//GEN-LAST:event_bThemKhachActionPerformed

    private void cbMaPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMaPhongActionPerformed
        try{
            Connect c = new Connect();
            Connection co = c.getConnection();
            PreparedStatement ps = co.prepareStatement("select * from PHONG,LOAIPHONG");
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                if(cbMaPhong.getSelectedItem().toString().equalsIgnoreCase(rs.getString("MaPhong"))){
                    txtLoaiPhong.setText(rs.getString("MaLoaiPhong"));
                    txtDonGia.setText(rs.getString("DonGia"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucPhong.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_cbMaPhongActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        LoadData();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(PhieuThuePhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PhieuThuePhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PhieuThuePhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PhieuThuePhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PhieuThuePhong().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bThem;
    private javax.swing.JButton bThemKhach;
    private javax.swing.JButton bThoat;
    private javax.swing.JButton bXoa;
    private javax.swing.JComboBox<String> cbLoaiKhach;
    private javax.swing.JComboBox<String> cbMaPhong;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbCMND;
    private javax.swing.JLabel lbDSKH;
    private javax.swing.JLabel lbDiaChi;
    private javax.swing.JLabel lbDonGia;
    private javax.swing.JLabel lbKhachHang;
    private javax.swing.JLabel lbLoaiKhach;
    private javax.swing.JLabel lbMaPhieuThue;
    private javax.swing.JLabel lbMaPhong;
    private javax.swing.JLabel lbNgayThue;
    private javax.swing.JLabel lbTenPhong;
    private javax.swing.JTable tbDSKH;
    private javax.swing.JTextField txtCMND;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtKhachHang;
    private javax.swing.JTextField txtLoaiPhong;
    private javax.swing.JTextField txtMaPhieuThue;
    // End of variables declaration//GEN-END:variables

    private void converUtilDateToSqlDate(Date date, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
