/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import VIEW.Connect;
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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Huu Dat
 */
public class DanhMucPhong extends javax.swing.JFrame {
    DefaultTableModel T = new DefaultTableModel();
    /**
     * Creates new form DanhMucPhong
     */
    public DanhMucPhong() {
        initComponents();
        LoadData();
        LoadCB();
        LoadCB1();
//        LoadTF();
    }
    public void LoadCB(){
        try{
            Connect a = new Connect();
            Connection conn = a.getConnection();
            PreparedStatement ps = conn.prepareStatement("select MaLoaiPhong from LOAIPHONG group by MaLoaiPhong");
            ResultSet rs = ps.executeQuery();
      //      Vector data = null;
     //        DefaultComboBoxModel cmbModel = new DefaultComboBoxModel();

            while(rs.next()){
             // data = new Vector();
             // data.add(rs.getString("MaLoaiPhong"));
             //  cmbModel.addElement(data);
                cbMaLoaiPhong.addItem(rs.getString("MaLoaiPhong"));
            }
            
            /*    else if(cbMaLoaiPhong.getSelectedItem().toString().equalsIgnoreCase("B")){
                    txtTenLoaiPhong.setText(rs.getString("TenLoaiPhong"));
                    txtDonGia.setText(rs.getFloat("DonGia")+"");
                }*/
            //cbMaLoaiPhong.setModel(cmbModel);
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
    }
    public void LoadCB1(){
        try{
            Connect a = new Connect();
            Connection conn = a.getConnection();
            PreparedStatement ps = conn.prepareStatement("select TinhTrang from PHONG group by TinhTrang");
            ResultSet rs = ps.executeQuery();
         //   Vector data = null;
         //    DefaultComboBoxModel cmbModel = new DefaultComboBoxModel();

            while(rs.next()){
             // data = new Vector();
             // data.add(rs.getString("MaLoaiPhong"));
             //  cmbModel.addElement(data);
                cbTinhTrang.addItem(rs.getString("TinhTrang"));
            }
            //cbMaLoaiPhong.setModel(cmbModel);
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
    }
   /*public void LoadTF(){
       int index = cbMaLoaiPhong.getSelectedIndex();
        if(index <0) // khong kho nao duoc chon.
            return;
       String  TenLoaiPhong ="";
        Vector item = (Vector)cbMaLoaiPhong.getSelectedItem();
         TenLoaiPhong= item.get(0).toString();
          System.out.print(TenLoaiPhong);
        try{
            
            Connect a = new Connect();
            Connection conn = a.getConnection();
            PreparedStatement ps = conn.prepareStatement("select TenLoaiPhong from LOAIPHONG where MaLoaiPhong ='"+TenLoaiPhong+"'");
            ResultSet rs = ps.executeQuery();
          //  System.out.print(rs.getString("TenLoaiPhong"));
            while(rs.next()){
                txtTenLoaiPhong.setText(rs.getString("TenLoaiPhong"));
            }
            
                //txtTenLoaiPhong.setText("select MaPhong from PHONG group by MaPhong");
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
    } */
    public void LoadData(){
        try{
            Connect a = new Connect();
            Connection conn = a.getConnection();
            int number;
            Vector row,column ;
            column = new Vector();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select MaPhong, TenPhong, P.MaLoaiPhong, TenLoaiPhong, DonGia, TinhTrang, GhiChu from PHONG P,LOAIPHONG LP WHERE P.MALOAIPHONG=LP.MALOAIPHONG ");
            ResultSetMetaData metadata = rs.getMetaData();
            number = metadata.getColumnCount();//tra ve so cot
            for(int i = 1 ;i <= number; i++){
                column.add(metadata.getColumnName(i));
            }
            T.setColumnIdentifiers(column);
            while(rs.next()){
                row = new Vector();
                for(int i=1;i<= number; i++){
                    row.addElement(rs.getString(i));
                }
                T.addRow(row);
                tbDMP.setModel(T);     
            }
            tbDMP.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent lse) {
                  // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                   if(tbDMP.getSelectedRow() >= 0){
                       txtMaPhong.setText(tbDMP.getValueAt(tbDMP.getSelectedRow(), 0) + "");
                       txtTenPhong.setText(tbDMP.getValueAt(tbDMP.getSelectedRow(), 1) + "");
                       cbMaLoaiPhong.setSelectedItem(tbDMP.getModel().getValueAt(tbDMP.getSelectedRow(), 2) + "");
                       txtTenLoaiPhong.setText(tbDMP.getValueAt(tbDMP.getSelectedRow(), 3) + "");
                       txtDonGia.setText(tbDMP.getValueAt(tbDMP.getSelectedRow(), 4) + "");
                       cbTinhTrang.setSelectedItem(tbDMP.getModel().getValueAt(tbDMP.getSelectedRow(), 5) + "");
                       txtGhiChu.setText(tbDMP.getValueAt(tbDMP.getSelectedRow(), 6) + "");
                   }
                }
            });      
        } catch(SQLException ex){
            System.out.println(ex.toString());
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

        TieuDeLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lbMaPhong = new javax.swing.JLabel();
        lbTenPhong = new javax.swing.JLabel();
        lbMaLoaiPhong = new javax.swing.JLabel();
        lbDonGia = new javax.swing.JLabel();
        lbTinhTrang = new javax.swing.JLabel();
        lbGhiChu = new javax.swing.JLabel();
        txtMaPhong = new javax.swing.JTextField();
        txtTenPhong = new javax.swing.JTextField();
        txtDonGia = new javax.swing.JTextField();
        txtGhiChu = new javax.swing.JTextField();
        cbMaLoaiPhong = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtTenLoaiPhong = new javax.swing.JTextField();
        cbTinhTrang = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDMP = new javax.swing.JTable();
        bThem = new javax.swing.JButton();
        bSua = new javax.swing.JButton();
        bXoa = new javax.swing.JButton();
        bThoat = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        TieuDeLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        TieuDeLabel.setForeground(new java.awt.Color(0, 51, 255));
        TieuDeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TieuDeLabel.setText("Danh Mục Phòng");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin phòng", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(255, 0, 204)))); // NOI18N

        lbMaPhong.setText("Mã phòng");

        lbTenPhong.setText("Tên phòng");

        lbMaLoaiPhong.setText("Mã loại phòng");

        lbDonGia.setText("Đơn giá");

        lbTinhTrang.setText("Tình trạng");

        lbGhiChu.setText("Ghi chú");

        txtMaPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaPhongActionPerformed(evt);
            }
        });

        txtTenPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenPhongActionPerformed(evt);
            }
        });

        txtDonGia.setEditable(false);

        cbMaLoaiPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMaLoaiPhongActionPerformed(evt);
            }
        });

        jLabel3.setText("Tên loại phòng");

        txtTenLoaiPhong.setEditable(false);

        cbTinhTrang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTinhTrangActionPerformed(evt);
            }
        });

        jLabel2.setText("Vd: P001.....");

        jLabel4.setText("Vd: PHÒNG 1.....");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbTinhTrang)
                            .addComponent(lbDonGia)
                            .addComponent(jLabel3)
                            .addComponent(lbGhiChu))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtGhiChu)
                            .addComponent(txtTenLoaiPhong)
                            .addComponent(txtDonGia)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 134, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbMaLoaiPhong)
                            .addComponent(lbMaPhong)
                            .addComponent(lbTenPhong))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaPhong)
                            .addComponent(txtTenPhong, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(cbMaLoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jLabel2)
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTenPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jLabel4)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbMaLoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbMaLoaiPhong))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTenLoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDonGia)
                    .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTinhTrang)
                    .addComponent(cbTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbGhiChu)
                    .addComponent(txtGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 0, 153));
        jLabel10.setText("Danh mục phòng");

        tbDMP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbDMP);

        bThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/svn_added.png"))); // NOI18N
        bThem.setText("Thêm");
        bThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bThemActionPerformed(evt);
            }
        });

        bSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fixed.png"))); // NOI18N
        bSua.setText("Sửa");
        bSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSuaActionPerformed(evt);
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

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hot.png"))); // NOI18N
        jButton1.setText("Hủy");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                            .addComponent(jLabel10)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton1))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(bThem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bSua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bXoa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bThoat)
                        .addGap(125, 125, 125)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(271, 271, 271)
                .addComponent(TieuDeLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TieuDeLabel)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bThem)
                    .addComponent(bSua)
                    .addComponent(bXoa)
                    .addComponent(bThoat))
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbMaLoaiPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMaLoaiPhongActionPerformed
        // TODO add your handling code here:
        try{
            Connect c = new Connect();
            Connection co = c.getConnection();
            PreparedStatement ps = co.prepareStatement("select * from LOAIPHONG");
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                if(cbMaLoaiPhong.getSelectedItem().toString().equalsIgnoreCase(rs.getString("MaLoaiPhong"))){
                    txtTenLoaiPhong.setText(rs.getString("TenLoaiPhong"));
                    txtDonGia.setText(rs.getString("DonGia"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DanhMucPhong.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cbMaLoaiPhongActionPerformed
   
    private void bThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bThemActionPerformed
        // TODO add your handling code here:
 //        int index = cbMaLoaiPhong.getSelectedIndex();
  //      if(index <0) // khong kho nao duoc chon.
   //         return;
  //      Vector item = (Vector)cbMaLoaiPhong.getSelectedItem();
  //      String maloai = item.get(0).toString();
  //      txtTenLoaiPhong.setText(MaLoaiPhong);
   /*     if(txtMaPhong.getText().length() != 0 && txtTenPhong.getText().length() !=0){
            if(txtMaPhong.getText().matches("^//d+$.,")){
                int id = 100;
                while (true){
                    if()
                }
            }*/
         //   if(txtTenLoaiPhong.getText().length() != 0 && txtDonGia.getText().length() != 0){
        try{
            Connect a = new Connect();
            Connection conn = a.getConnection();
            PreparedStatement ps = conn.prepareStatement("insert into PHONG values (?,?,?,?,?)");
            
            char []maPhong=txtMaPhong.getText().toCharArray();
            //check character first is Uppercase?
            System.out.println(maPhong[0]);
            if(txtMaPhong.getText().length() <= 5){
            if( maPhong[0]!='P')
            {
                //error report and not save
                JOptionPane.showMessageDialog(this,"Vui lòng nhập ký tự đầu là P ở Mã Phòng!!");
                return;
            }
            //check 3 character after
            for(int i=1; i<maPhong.length; i++)
            {
                //check character is Digit?
                if(Character.isDigit(maPhong[i])==false)
                {
                    //error report and not save
                    JOptionPane.showMessageDialog(this,"Vui lòng nhập ký tự số ở Mã Phòng!!");
                    return;
                }
            }
            } else {
                JOptionPane.showMessageDialog(this, "Mã phòng nhập quá 5 ký tự");
                return;
            }
            ps.setString(1, txtMaPhong.getText());
            char []TP=txtTenPhong.getText().toCharArray();
            if(txtTenPhong.getText().length() <0 && txtTenPhong.getText().length() <10){
            for(int i=1; i<TP.length; i++)
            {
                //check character is Digit?
                if(Character.isUpperCase(TP[i])==false && Character.isWhitespace(TP[i])==false && Character.isDigit(TP[TP.length-1])== false)
                {
                    JOptionPane.showMessageDialog(this,"Tên Phòng vui lòng nhập đúng cú pháp!!");
                    return;
                }
            }
            } else {
                JOptionPane.showMessageDialog(this, "Bạn nhập quá 10 ký tự ở Tên phòng");
                return;
            }
            ps.setString(2, txtTenPhong.getText());  
            ps.setString(3, cbMaLoaiPhong.getSelectedItem().toString());
            //getstring();
            //"select TenLoaiPhong from LoaiPhong" // load ten loai phong len text field
            ps.setString(4, cbTinhTrang.getSelectedItem().toString());
           // System.out.println(txtTinhTrang.getText());
            ps.setString(5, txtGhiChu.getText());
            PreparedStatement ps1 = conn.prepareStatement("insert into LOAIPHONG values (?,?,?)");
            ps1.setString(1, cbMaLoaiPhong.getSelectedItem().toString());
            ps1.setString(2, txtTenLoaiPhong.getText());
            ps1.setString(3, txtDonGia.getText());
            int chk = ps.executeUpdate();
            if (chk > 0) {
                JOptionPane.showMessageDialog(this, "Them Thanh Cong");
                T.setRowCount(0);
                LoadData();
            } else {
                JOptionPane.showMessageDialog(this,"Thêm Thất Bại");
                        }
                T.setRowCount(0);
                LoadData();
        } catch (Exception ex) {
            System.out.println(ex.toString());
             }                                  
    }//GEN-LAST:event_bThemActionPerformed

    private void bSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSuaActionPerformed
        // TODO add your handling code here:
        int ret = JOptionPane.showConfirmDialog(this, "Bạn có sửa không?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (ret != JOptionPane.YES_OPTION) {
            return;
        }
        try {
            Connect a = new Connect();
            Connection conn = a.getConnection();
            int index=tbDMP.getSelectedRow();
            String value=tbDMP.getModel().getValueAt(index,0).toString();
            PreparedStatement pre = conn.prepareStatement("Update PHONG set TenPhong=?,MaLoaiPhong=?, TinhTrang=?,GhiChu=? where MaPhong=?");
            char []maPhong=txtMaPhong.getText().toCharArray();
            //check character first is Uppercase?
            if(Character.isUpperCase(maPhong[0])==false)
            {
                //error report and not save
                JOptionPane.showMessageDialog(this,"Vui lòng nhập ký tự đầu in hoa ở Mã Phòng!!");
                return;
            }
            //check 3 character after
            for(int i=1; i<maPhong.length; i++)
            {
                //check character is Digit?
                if(Character.isDigit(maPhong[i])==false)
                {
                    
                    JOptionPane.showMessageDialog(this,"Vui lòng nhập ký tự số ở Mã Phòng!!");
                    return;
                }
            }
            pre.setString(5, txtMaPhong.getText());
            char []TP=txtTenPhong.getText().toCharArray();
            for(int i=1; i<TP.length; i++)
                if(Character.isUpperCase(TP[i])==false && Character.isWhitespace(TP[i])==false && Character.isDigit(TP[TP.length-1])== false)
                {
                    if(Character.isDigit(TP[i])==false)
                    {
                        JOptionPane.showMessageDialog(this,"Vui lòng nhập ký tự số ở ô Tên Phòng!!");
                        return;
                    }
                }
            pre.setString(1, txtTenPhong.getText());
            pre.setString(2, cbMaLoaiPhong.getSelectedItem().toString());
            pre.setString(3, cbTinhTrang.getSelectedItem().toString());
            pre.setString(4, txtGhiChu.getText());
      //      pre.executeUpdate();
            PreparedStatement pr = conn.prepareStatement("Update LOAIPHONG set TenLoaiPhong=?,DonGia=? where MaLoaiPhong=?");
            pr.setString(3, cbMaLoaiPhong.getSelectedItem().toString());
            pr.setString(1, txtTenLoaiPhong.getText());
            pr.setString(2, txtDonGia.getText());
            pre.executeUpdate();
            T.setRowCount(0);
            LoadData();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_bSuaActionPerformed

    private void txtTenPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenPhongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenPhongActionPerformed

    private void bXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bXoaActionPerformed
        // TODO add your handling code here:
        try {
            Connect a = new Connect();
            Connection conn = a.getConnection();
            PreparedStatement pre = conn.prepareStatement("delete PHONG where MaPhong=?");
            pre.setString(1,tbDMP.getValueAt(tbDMP.getSelectedRow(),0).toString());
            if(JOptionPane.showConfirmDialog(this,"Xác Nhận Xóa?","Ðồng Ý",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
            {
                pre.executeUpdate();
                T.setRowCount(0);
                LoadData();
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_bXoaActionPerformed

    private void bThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bThoatActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_bThoatActionPerformed

    private void cbTinhTrangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTinhTrangActionPerformed
        // TODO add your handling code here:
     /*   if(cbTinhTrang.getSelectedItem().toString().equalsIgnoreCase("Đã Thuê")){
            cbTinhTrang.addItem("Trống");
        }
        else if(cbTinhTrang.getSelectedItem().toString().equalsIgnoreCase("Trống")){
            cbTinhTrang.addItem("Đã thuê");
        }*/
    }//GEN-LAST:event_cbTinhTrangActionPerformed

    private void txtMaPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaPhongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaPhongActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        txtMaPhong.setText("");
        txtTenPhong.setText("");
        txtGhiChu.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(DanhMucPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DanhMucPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DanhMucPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DanhMucPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DanhMucPhong().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TieuDeLabel;
    private javax.swing.JButton bSua;
    private javax.swing.JButton bThem;
    private javax.swing.JButton bThoat;
    private javax.swing.JButton bXoa;
    private javax.swing.JComboBox<String> cbMaLoaiPhong;
    private javax.swing.JComboBox<String> cbTinhTrang;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbDonGia;
    private javax.swing.JLabel lbGhiChu;
    private javax.swing.JLabel lbMaLoaiPhong;
    private javax.swing.JLabel lbMaPhong;
    private javax.swing.JLabel lbTenPhong;
    private javax.swing.JLabel lbTinhTrang;
    private javax.swing.JTable tbDMP;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtGhiChu;
    private javax.swing.JTextField txtMaPhong;
    private javax.swing.JTextField txtTenLoaiPhong;
    private javax.swing.JTextField txtTenPhong;
    // End of variables declaration//GEN-END:variables
}
