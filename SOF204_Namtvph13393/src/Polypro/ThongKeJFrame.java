package Polypro;

import DAO.HocVienDAO;
import DAO.ThongKeDao;
import Model.KhoaHoc;
import Model.NhanVien;
import Model.ThongKeBangDiem;
import Model.ThongKeDoanhThu;
import Model.ThongKeSLNguoiHoc;
import Model.ThongKeTongHopDiem;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ThongKeJFrame extends javax.swing.JFrame {

    DefaultTableModel model_tblSLnguoiHoc = new DefaultTableModel();
    DefaultTableModel model_tblBangDiem = new DefaultTableModel();
    DefaultTableModel model_tblTongHopDiem = new DefaultTableModel();
    DefaultTableModel model_tbldoanhThu = new DefaultTableModel();

    DefaultComboBoxModel<KhoaHoc> model_cbxKH = new DefaultComboBoxModel<>();
    
    List<ThongKeSLNguoiHoc> listThongKeSLNguoiHoc = ThongKeDao.getListSL_NguoiHoc();
    List<ThongKeBangDiem> listThongKeBangDiem = ThongKeDao.getListBangDiem();
    List<KhoaHoc> listMaKH = HocVienDAO.getMaKH();
    List<ThongKeBangDiem> listBangDiem_MaKh = null;
    List<ThongKeTongHopDiem> listTongHopDiem = ThongKeDao.getListTongHopDiem();
    List<ThongKeDoanhThu> listDoanhThu = ThongKeDao.getListThongKeDoanhThu();
    
    NhanVien nv;
    public ThongKeJFrame(NhanVien nhanVien) {
        initComponents();
        nv = nhanVien;
        String cv = nv.getVaiTro()==true?"Nhân viên": "Trưởng phòng";
        if(cv.equalsIgnoreCase("Nhân viên")){
            JtabPbDoanhThu.setVisible(false);
        }else{
            model_tbldoanhThu = (DefaultTableModel) tblDoanhThu.getModel();
            loadTableDoanhThu();
        }
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        model_tblSLnguoiHoc = (DefaultTableModel) tblSLNguoiHoc.getModel();
        LoadFromNguoiHoc();

        model_tblBangDiem = (DefaultTableModel) tblBangDiem.getModel();
        LoadFromBangDiem();
        model_cbxKH = (DefaultComboBoxModel) cbxKhoaHoc.getModel();
        LoadCbxKhoaHoc();

        model_tblTongHopDiem = (DefaultTableModel) tblTongHopDiem.getModel();
        LoadTableTongHopDiem();
    }

    public void LoadFromNguoiHoc() {
        model_tblSLnguoiHoc.setRowCount(0);
        for (ThongKeSLNguoiHoc x : listThongKeSLNguoiHoc) {
            model_tblSLnguoiHoc.addRow(new Object[]{x.getNamDK(), x.getSoLuong(), x.getNgayDauTien(), x.getNgayCuoiCung()});
        }
        tblSLNguoiHoc.setModel(model_tblSLnguoiHoc);
    }

    public void LoadFromBangDiem() {
        model_tblBangDiem.setRowCount(0);
        for (ThongKeBangDiem x : listThongKeBangDiem) {
            model_tblBangDiem.addRow(new Object[]{x.getMaHV(), x.getHoten(), x.getDiem(), x.getXepLoai(x.getDiem())});
        }
        tblBangDiem.setModel(model_tblBangDiem);
    }

    public void LoadFromBangDiem(List<ThongKeBangDiem> list) {
        model_tblBangDiem.setRowCount(0);
        for (ThongKeBangDiem x : list) {
            model_tblBangDiem.addRow(new Object[]{x.getMaHV(), x.getHoten(), x.getDiem(), x.getXepLoai(x.getDiem())});
        }
        tblBangDiem.setModel(model_tblBangDiem);
    }

      public void LoadTableDoanhThu(List<ThongKeDoanhThu> list) {
        model_tbldoanhThu.setRowCount(0);
        for (ThongKeDoanhThu x : list) {
            model_tbldoanhThu.addRow(new Object[]{x.getTenCD(), x.getSoKH(), x.getSoHV(), x.getDoanhThu(), x.getCaoNhat(), x.getThapNhat(), x.getDoanhThuTB()});
        }
        tblDoanhThu.setModel(model_tbldoanhThu);
    }
      
    public void LoadCbxKhoaHoc() {
        model_cbxKH.removeAllElements();
        for (KhoaHoc x : listMaKH) {
            model_cbxKH.addElement(x);
        }
    }

    public void LoadTableTongHopDiem() {
        model_tblTongHopDiem.setRowCount(0);
        for (ThongKeTongHopDiem x : listTongHopDiem) {
            model_tblTongHopDiem.addRow(new Object[]{x.getTenCD(), x.getSoLuongKH(), x.getDiemMax(), x.getDiemMin(), x.getDiemTB()});
        }
        tblTongHopDiem.setModel(model_tblTongHopDiem);
    }
    public void loadTableDoanhThu(){
        model_tbldoanhThu.setRowCount(0);
        for (ThongKeDoanhThu x : listDoanhThu) {
            model_tbldoanhThu.addRow(new Object[]{x.getTenCD(),x.getYear(),x.getSoKH(),x.getSoHV(),x.getDoanhThu(),x.getThapNhat(),x.getCaoNhat(),x.getDoanhThuTB()});
        }
        tblDoanhThu.setModel(model_tbldoanhThu);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tabPnDoanhThu = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSLNguoiHoc = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBangDiem = new javax.swing.JTable();
        cbxKhoaHoc = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTongHopDiem = new javax.swing.JTable();
        JtabPbDoanhThu = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblDoanhThu = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("THỐNG KÊ");

        tabPnDoanhThu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabPnDoanhThuMouseClicked(evt);
            }
        });

        tblSLNguoiHoc.setForeground(new java.awt.Color(0, 0, 255));
        tblSLNguoiHoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "NĂM", "SỐ NGƯỜI HỌC", "ĐẦU TIÊN", "SAU CÙNG"
            }
        ));
        jScrollPane1.setViewportView(tblSLNguoiHoc);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 133, Short.MAX_VALUE))
        );

        tabPnDoanhThu.addTab("Người học", jPanel1);

        tblBangDiem.setForeground(new java.awt.Color(0, 0, 204));
        tblBangDiem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "MÃ NGƯỜI HỌC", "HỌ VÀ TÊN", "ĐIỂM", "XẾP LOẠI"
            }
        ));
        jScrollPane2.setViewportView(tblBangDiem);

        cbxKhoaHoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxKhoaHoc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxKhoaHocItemStateChanged(evt);
            }
        });

        jLabel2.setText("Khóa học:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbxKhoaHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(288, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxKhoaHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(41, 41, 41)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabPnDoanhThu.addTab("Bảng điểm", jPanel2);

        tblTongHopDiem.setForeground(new java.awt.Color(0, 0, 204));
        tblTongHopDiem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "CHUYÊN ĐỀ", "TỔNG SỐ HỌC VIÊN", "ĐIỂM CAO NHẤT", "ĐIỂM THẤP NHẤT", "ĐIỂM TB"
            }
        ));
        jScrollPane3.setViewportView(tblTongHopDiem);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 81, Short.MAX_VALUE))
        );

        tabPnDoanhThu.addTab("Tổng hợp điểm", jPanel3);

        JtabPbDoanhThu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JtabPbDoanhThuMouseClicked(evt);
            }
        });

        tblDoanhThu.setForeground(new java.awt.Color(0, 0, 204));
        tblDoanhThu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "TÊN CHUYÊN ĐỀ", "Năm", "SỐ KH", "SỐ HV", "DOANH THU", "THẤP NHẤT", "CAO NHẤT", "TB"
            }
        ));
        jScrollPane5.setViewportView(tblDoanhThu);

        javax.swing.GroupLayout JtabPbDoanhThuLayout = new javax.swing.GroupLayout(JtabPbDoanhThu);
        JtabPbDoanhThu.setLayout(JtabPbDoanhThuLayout);
        JtabPbDoanhThuLayout.setHorizontalGroup(
            JtabPbDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JtabPbDoanhThuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 712, Short.MAX_VALUE)
                .addContainerGap())
        );
        JtabPbDoanhThuLayout.setVerticalGroup(
            JtabPbDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE)
        );

        tabPnDoanhThu.addTab("Doanh thu", JtabPbDoanhThu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabPnDoanhThu)
            .addGroup(layout.createSequentialGroup()
                .addGap(268, 268, 268)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(tabPnDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxKhoaHocItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxKhoaHocItemStateChanged
        KhoaHoc khoaHoc = (KhoaHoc) model_cbxKH.getSelectedItem();
        listBangDiem_MaKh = ThongKeDao.getListBangDiem_MaKH(khoaHoc);
        LoadFromBangDiem(listBangDiem_MaKh);
    }//GEN-LAST:event_cbxKhoaHocItemStateChanged

    private void tabPnDoanhThuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabPnDoanhThuMouseClicked
    }//GEN-LAST:event_tabPnDoanhThuMouseClicked

    private void JtabPbDoanhThuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JtabPbDoanhThuMouseClicked
    }//GEN-LAST:event_JtabPbDoanhThuMouseClicked

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
            java.util.logging.Logger.getLogger(ThongKeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThongKeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThongKeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThongKeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ThongKeJFrame().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JtabPbDoanhThu;
    private javax.swing.JComboBox<String> cbxKhoaHoc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane tabPnDoanhThu;
    private javax.swing.JTable tblBangDiem;
    private javax.swing.JTable tblDoanhThu;
    private javax.swing.JTable tblSLNguoiHoc;
    private javax.swing.JTable tblTongHopDiem;
    // End of variables declaration//GEN-END:variables
}
