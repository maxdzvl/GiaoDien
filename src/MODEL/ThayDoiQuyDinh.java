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
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Huu Dat
 */
public class ThayDoiQuyDinh extends javax.swing.JFrame {
  DefaultTableModel T = new DefaultTableModel();
  DefaultTableModel T1 = new DefaultTableModel();
    /**
     * Creates new form ThayDoiQuyDinh
     */
    public ThayDoiQuyDinh() {
        initComponents();
        LoadData();
        LoadData1();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    public void LoadData(){
        try{
            Connect a = new Connect();
            Connection conn = a.getConnection();
            int number;
            Vector row,column ;
            column = new Vector();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select * from LOAIPHONG");
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
                tbLP.setModel(T);     
            }
            tbLP.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent lse) {
                  // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                   if(tbLP.getSelectedRow() >= 0){
                       txtMLP.setText(tbLP.getValueAt(tbLP.getSelectedRow(), 0) + "");
                       txtTLP.setText(tbLP.getValueAt(tbLP.getSelectedRow(), 1) + "");
                       txtDonGia.setText(tbLP.getValueAt(tbLP.getSelectedRow(), 2) + "");
                   }
                }
            });      
        } catch(SQLException ex){
            System.out.println(ex.toString());
        }
    }
    public void LoadData1(){
        try{
            Connect a = new Connect();
            Connection conn = a.getConnection();
            int number;
            Vector row,column ;
            column = new Vector();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select * from LOAIKHACH");
            ResultSetMetaData metadata = rs.getMetaData();
            number = metadata.getColumnCount();//tra ve so cot
            for(int i = 1 ;i <= number; i++){
                column.add(metadata.getColumnName(i));
            }
            T1.setColumnIdentifiers(column);
            while(rs.next()){
                row = new Vector();
                for(int i=1;i<= number; i++){
                    row.addElement(rs.getString(i));
                }
                T1.addRow(row);
                tbLK.setModel(T1);     
            }
            tbLK.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent lse) {
                  // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                   if(tbLK.getSelectedRow() >= 0){
                       txtMLK.setText(tbLK.getValueAt(tbLK.getSelectedRow(), 0) + "");
                       txtTLK.setText(tbLK.getValueAt(tbLK.getSelectedRow(), 1) + "");
                       txtHSLK.setText(tbLK.getValueAt(tbLK.getSelectedRow(), 2) + "");
                   }
                 
                }
            });      
        } catch(SQLException ex){
            System.out.println(ex.toString());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbLP = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbLK = new javax.swing.JTable();
        bThoat = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lbMaLoaiKhach = new javax.swing.JLabel();
        txtDonGia = new javax.swing.JTextField();
        lbHSLoaiKhach = new javax.swing.JLabel();
        bThem = new javax.swing.JButton();
        bSua = new javax.swing.JButton();
        bXoa = new javax.swing.JButton();
        txtMLP = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtTLP = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lbMaLoaiKhach1 = new javax.swing.JLabel();
        txtHSLK = new javax.swing.JTextField();
        lbHSLoaiKhach1 = new javax.swing.JLabel();
        bThem1 = new javax.swing.JButton();
        bSua1 = new javax.swing.JButton();
        bXoa1 = new javax.swing.JButton();
        txtMLK = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTLK = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thay Đổi Quy Định", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(0, 51, 255))); // NOI18N

        jLayeredPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        tbLP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tbLP);

        tbLK.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tbLK);

        jLayeredPane2.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jScrollPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        bThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/001_23.gif"))); // NOI18N
        bThoat.setText("Thoát");
        bThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bThoatActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin loại phòng", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(255, 0, 255))); // NOI18N

        lbMaLoaiKhach.setText("Mã loại phòng");

        lbHSLoaiKhach.setText("Đơn giá");

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

        jLabel1.setText("Tên Loại phòng");

        jLabel4.setText("Vd: A");

        jLabel5.setText("Vd: LOẠI PHÒNG A");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(bThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(8, 8, 8)
                        .addComponent(bSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(8, 8, 8)
                        .addComponent(bXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbHSLoaiKhach)
                            .addComponent(jLabel1)
                            .addComponent(lbMaLoaiKhach, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtDonGia)
                                        .addComponent(txtMLP))
                                    .addComponent(txtTLP))
                                .addContainerGap())))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMaLoaiKhach, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMLP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jLabel4)
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTLP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jLabel5)
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbHSLoaiKhach, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bSua)
                    .addComponent(bXoa)
                    .addComponent(bThem)))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin loại khách", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(255, 0, 255))); // NOI18N

        lbMaLoaiKhach1.setText("Mã loại khách");

        lbHSLoaiKhach1.setText("Hệ số loại khách");

        bThem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/svn_added.png"))); // NOI18N
        bThem1.setText("Thêm");
        bThem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bThem1ActionPerformed(evt);
            }
        });

        bSua1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fixed.png"))); // NOI18N
        bSua1.setText("Sửa");
        bSua1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSua1ActionPerformed(evt);
            }
        });

        bXoa1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/svn_deleted.png"))); // NOI18N
        bXoa1.setText("Xóa");
        bXoa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bXoa1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Tên Loại khách");

        jLabel6.setText("Vd: ND");

        jLabel7.setText("Vd: NỘI ĐỊA");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(bThem1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bSua1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(8, 8, 8)
                        .addComponent(bXoa1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbHSLoaiKhach1)
                            .addComponent(jLabel2)
                            .addComponent(lbMaLoaiKhach1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMLK)
                                    .addComponent(txtHSLK)
                                    .addComponent(txtTLK))
                                .addGap(20, 20, 20))))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMaLoaiKhach1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMLK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jLabel6)
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTLK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jLabel7)
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbHSLoaiKhach1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHSLK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bSua1)
                    .addComponent(bXoa1)
                    .addComponent(bThem1)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLayeredPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(274, 274, 274)
                .addComponent(bThoat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(274, 274, 274))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLayeredPane2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bThoat))
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

    private void bThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bThemActionPerformed
        // TODO add your handling code here:
        try{
            Connect a = new Connect();
            Connection conn = a.getConnection();
            PreparedStatement ps = conn.prepareStatement ("insert into LOAIPHONG values(?,?,?)");
            char []MLP=txtMLP.getText().toCharArray();
            if(txtMLP.getText().length() < 5){
                if(Character.isUpperCase(MLP[0])== false)
                {
                //error report and not save
                    JOptionPane.showMessageDialog(this,"Vui lòng nhập ký in hoa ở Mã Loại Phòng!!");
                    return;
                }
            } else {JOptionPane.showMessageDialog(this, "Bạn nhập quá 5 ký tự ở ô Mã phòng");
              return;
            }
            ps.setString(1,txtMLP.getText());
          /*  if(rbKND.isSelected()){
                ps1.setBoolean(2, true);
            }
            else
            {
                ps1.setBoolean(2, false);
            }
           */
            char []TLP=txtTLP.getText().toCharArray();
            if(txtTLP.getText().length() <=20){
                 for(int i=0; i<TLP.length; i++)
           //          if(Character.isUpperCase(TLP[0]) == 'P' && Character.isLowerCase(TLP[1]) == 'h' && Character.isLowerCase(TLP[2]) == 'ò' && Character.isLowerCase(TLP[3]) == 'n' && Character.isLowerCase(TLP[4]) == 'g'){
                if(Character.isUpperCase(TLP[i])==false  && Character.isWhitespace(TLP[i])==false){
                JOptionPane.showMessageDialog(this,"Vui lòng nhập ký tự in hoa ở Tên loại phòng!");
                return;
                }
            }else {JOptionPane.showMessageDialog(this, "Bạn nhập quá 20 ký tự ở Tên loại phòng!");
                return;
            }
            ps.setString(2,txtTLP.getText());
            char []DG=txtDonGia.getText().toCharArray();
            for(int i=0; i<DG.length; i++)
            if(Character.isDigit(DG[0])==false)
            {
                //error report and not save
                JOptionPane.showMessageDialog(this,"Vui lòng nhập ký tự số ở Đơn Giá!!");
                return;
            }
            ps.setString(3, txtDonGia.getText());
            int chk = ps.executeUpdate();
            if(chk>0){
                JOptionPane.showMessageDialog(this,"Thêm Thành Công");
            }
            else{
                JOptionPane.showMessageDialog(this,"Thêm Thất Bại");
                        }
            T.setRowCount(0);
            LoadData();
        }catch(Exception ex){
            System.out.println(ex.toString());
            }                      
    }//GEN-LAST:event_bThemActionPerformed

    private void bSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSuaActionPerformed
        // TODO add your handling code here:
        int ret = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn sửa không?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (ret != JOptionPane.YES_OPTION) {
            return;
        }
          try {
            Connect a = new Connect();
            Connection conn = a.getConnection();
            PreparedStatement pre = conn.prepareStatement ("Update LOAIPHONG set TenLoaiPhong=?,HeSoLoaiPhong=? where MaLoaiPhong=?");
            char []MLP=txtMLP.getText().toCharArray();
            if(Character.isUpperCase(MLP[0])==false)
            {
                //error report and not save
                JOptionPane.showMessageDialog(this,"Vui lòng nhập ký in hoa ở Mã Phòng!!");
                return;
            }
            pre.setString(3, txtMLP.getText());
            
            char []TLP=txtTLP.getText().toCharArray();
            if(txtTLP.getText().length() <0 && txtTLP.getText().length() >=20){
                 for(int i=0; i<TLP.length; i++)
           //          if(Character.isUpperCase(TLP[0]) == 'P' && Character.isLowerCase(TLP[1]) == 'h' && Character.isLowerCase(TLP[2]) == 'ò' && Character.isLowerCase(TLP[3]) == 'n' && Character.isLowerCase(TLP[4]) == 'g'){
                if(Character.isUpperCase(TLP[i]) == false  && Character.isWhitespace(TLP[i]) == false){
                JOptionPane.showMessageDialog(this,"Vui lòng nhập ký tự in hoa ở Tên loại phòng!");
                return;
                }
            }   else {JOptionPane.showMessageDialog(this, "Bạn nhập quá 20 ký tự ở Tên loại phòng!");
                    return;
                    }
            pre.setString(1, txtTLP.getText());
            
            char []DG=txtDonGia.getText().toCharArray();
            for(int i=0; i<DG.length; i++)
            if(Character.isDigit(DG[0])==false)
            {
                //error report and not save
                JOptionPane.showMessageDialog(this,"Vui lòng nhập ký tự số ở Đơn Giá!!");
                return;
            }
            pre.setString(2, txtDonGia.getText());
            
            pre.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_bSuaActionPerformed

    private void bXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bXoaActionPerformed
        // TODO add your handling code here:
         try {
            Connect a = new Connect();
            Connection conn = a.getConnection();
            PreparedStatement pre = conn.prepareStatement("delete LOAIPHONG where MaLoaiPhong=?");
            pre.setString(1,tbLP.getValueAt(tbLP.getSelectedRow(),0).toString());
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

    private void bThem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bThem1ActionPerformed
        // TODO add your handling code here:
    try{
            Connect a = new Connect();
            Connection conn = a.getConnection();
            PreparedStatement ps = conn.prepareStatement ("insert into LOAIKHACH values(?,?,?)");
            char []MLP=txtMLK.getText().toCharArray();
            if(Character.isUpperCase(MLP[0])==false)
            {
                //error report and not save
                JOptionPane.showMessageDialog(this,"Vui lòng nhập ký in hoa ở Mã loại khách!!");
                return;
            }
            ps.setString(1,txtMLK.getText());
            
            char []TLK=txtTLK.getText().toCharArray();
            if(txtTLK.getText().length() <0 && txtTLK.getText().length() >=20){
                 for(int i=0; i<TLK.length; i++)
                if(Character.isUpperCase(TLK[i]) == false  && Character.isWhitespace(TLK[i]) == false){
                JOptionPane.showMessageDialog(this,"Vui lòng nhập ký tự in hoa ở Tên loại khách!");
                return;
                }
            }   else {JOptionPane.showMessageDialog(this, "Bạn nhập quá 20 ký tự ở Tên loại khách!");
                    return;
                    }
            ps.setString(2,txtTLK.getText());
            char []DG=txtHSLK.getText().toCharArray();
            for(int i=0; i<DG.length; i++)
            if(txtMLP.getText().length() <=2){
            if(Character.isDigit(DG[0])==false)
            {
                //error report and not save
                JOptionPane.showMessageDialog(this,"Vui lòng nhập ký tự số ở Đơn Giá!!");
                return;
            }
            } JOptionPane.showMessageDialog(this, "Bạn đã nhập quá 2 ký tự ở ô Hệ số loại khách");
            ps.setString(3,txtHSLK.getText());
            int chk = ps.executeUpdate();
            if(chk>0){
                JOptionPane.showMessageDialog(this,"Thêm Thành Công");
            }
            else{
                JOptionPane.showMessageDialog(this,"Thêm Thất Bại");
                        }
        }catch(Exception ex){
            System.out.println(ex.toString());
             T1.setRowCount(0);
             LoadData();
            }                       
    }//GEN-LAST:event_bThem1ActionPerformed

    private void bSua1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSua1ActionPerformed
        // TODO add your handling code here:
        int ret = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn sửa không?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (ret != JOptionPane.YES_OPTION) {
            return;
        }
         try {
            Connect a = new Connect();
            Connection conn = a.getConnection();
            PreparedStatement pre = conn.prepareStatement ("Update LOAIKHACH set TenLoaiKhach=?,HeSoLoaiKhach=? where MaLoaiKhach=?");
            pre.setString(1, txtTLK.getText());
            pre.setString(2, txtHSLK.getText());
            pre.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_bSua1ActionPerformed

    private void bXoa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bXoa1ActionPerformed
        // TODO add your handling code here:
        try {
            Connect a = new Connect();
            Connection conn = a.getConnection();
            PreparedStatement pre = conn.prepareStatement("delete LOAIKHACH where MaLoaiKhach=?");
            pre.setString(1,tbLK.getValueAt(tbLK.getSelectedRow(),0).toString());
            if(JOptionPane.showConfirmDialog(this,"Xác Nhận Xóa?","Ðồng Ý",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
            {
                pre.executeUpdate();
                T1.setRowCount(0);
                LoadData();
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_bXoa1ActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThayDoiQuyDinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ThayDoiQuyDinh().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bSua;
    private javax.swing.JButton bSua1;
    private javax.swing.JButton bThem;
    private javax.swing.JButton bThem1;
    private javax.swing.JButton bThoat;
    private javax.swing.JButton bXoa;
    private javax.swing.JButton bXoa1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbHSLoaiKhach;
    private javax.swing.JLabel lbHSLoaiKhach1;
    private javax.swing.JLabel lbMaLoaiKhach;
    private javax.swing.JLabel lbMaLoaiKhach1;
    private javax.swing.JTable tbLK;
    private javax.swing.JTable tbLP;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtHSLK;
    private javax.swing.JTextField txtMLK;
    private javax.swing.JTextField txtMLP;
    private javax.swing.JTextField txtTLK;
    private javax.swing.JTextField txtTLP;
    // End of variables declaration//GEN-END:variables
}
