package Polypro;

import DAO.HocVienDAO;
import DAO.Util;
import Model.HocVien;
import Model.KhoaHoc;
import Model.NguoiHoc;
import Model.NhanVien;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jdk.nashorn.internal.ir.BreakNode;

public class HocVienJFrame extends javax.swing.JFrame {

    DefaultTableModel model_table = new DefaultTableModel();
    DefaultComboBoxModel<KhoaHoc> cbx_khoaHoc = new DefaultComboBoxModel<>();

    List<HocVien> lstHocVien = HocVienDAO.getlstHocVien();
    List<KhoaHoc> lstMaKhoaHoc = HocVienDAO.getMaKH();
    NhanVien nv;

    public HocVienJFrame(NhanVien nhanVien) {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        nv = nhanVien;
        String cv = nv.getVaiTro() == true ? "Nhân viên" : "Trưởng phòng";
        if (cv.equalsIgnoreCase("Nhân viên")) {
            btnXoa.setEnabled(false);
        }
        model_table = (DefaultTableModel) tblHocVien.getModel();
        loadDataToTable();
        cbx_khoaHoc = (DefaultComboBoxModel) cbxMaKhoaHoc.getModel();
        loadCBXKhoaHoc();
    }

    public void loadCBXKhoaHoc() {
        cbx_khoaHoc.removeAllElements();
        for (KhoaHoc x : lstMaKhoaHoc) {
            cbx_khoaHoc.addElement(x);
        }
    }

    public void loadDataToTable() {
        model_table.setRowCount(0);
        for (HocVien x : lstHocVien) {
            model_table.addRow(new Object[]{x.getMaHV(), x.getMaKH(), x.getMaNH(), x.getDiem(), x.getXepLoai(x.getDiem())});
        }
        tblHocVien.setModel(model_table);
    }

    public void showFrom(int index) {
        txtMaHV.setText(String.valueOf(tblHocVien.getValueAt(index, 0)));
        cbx_khoaHoc.setSelectedItem(String.valueOf(tblHocVien.getValueAt(index, 1)));
        txtMaNguoiHoc.setText(String.valueOf(tblHocVien.getValueAt(index, 2)));
        txtDiem.setText(String.valueOf(tblHocVien.getValueAt(index, 3)));
        lblHocLuc.setText(String.valueOf(tblHocVien.getValueAt(index, 4)));
    }

    public HocVien getHocVien() {
        HocVien hv = null;
        String mahv = txtMaHV.getText();
        String maKH = cbxMaKhoaHoc.getSelectedItem().toString();
        String maNH = txtMaNguoiHoc.getText();
        Double diem = null;
        if (txtDiem.getText().isEmpty()) {
            diem = null;
        } else {
            diem = new Double(txtDiem.getText());
        }
        hv = new HocVien(mahv, maKH, maNH, diem);
        return hv;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        pnHocVien = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblHocLuc = new javax.swing.JLabel();
        txtMaHV = new javax.swing.JTextField();
        cbxMaKhoaHoc = new javax.swing.JComboBox<>();
        txtMaNguoiHoc = new javax.swing.JTextField();
        txtDiem = new javax.swing.JTextField();
        btnTimkiem = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        lblMaHV = new javax.swing.JLabel();
        lblMaNguoiHoc = new javax.swing.JLabel();
        lblDiem = new javax.swing.JLabel();
        lblTimKiem = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnNewFrom = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnfirst = new javax.swing.JButton();
        btnback = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHocVien = new javax.swing.JTable();
        btnUpdate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("QUẢN LÝ HỌC VIÊN");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Mã học viên:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Mã khóa học");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Mã Người Học");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Điểm");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Xếp loại hiện tại:");

        lblHocLuc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblHocLuc.setText("Học Lực");

        txtMaHV.setMinimumSize(new java.awt.Dimension(5, 20));
        txtMaHV.setPreferredSize(new java.awt.Dimension(5, 20));

        cbxMaKhoaHoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnTimkiem.setBackground(new java.awt.Color(255, 102, 0));
        btnTimkiem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnTimkiem.setForeground(new java.awt.Color(255, 255, 255));
        btnTimkiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TaiLieu/Hinh/Search.png"))); // NOI18N
        btnTimkiem.setText("Tìm kiếm");
        btnTimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimkiemActionPerformed(evt);
            }
        });

        txtTimKiem.setToolTipText("Nhập mã nhân viên cần tìm");

        lblMaHV.setForeground(new java.awt.Color(153, 102, 0));
        lblMaHV.setText(" ");

        lblMaNguoiHoc.setForeground(new java.awt.Color(153, 102, 0));
        lblMaNguoiHoc.setText(" ");

        lblDiem.setForeground(new java.awt.Color(153, 153, 0));
        lblDiem.setText(" ");

        lblTimKiem.setForeground(new java.awt.Color(153, 153, 0));
        lblTimKiem.setText(" ");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 395, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 282, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(153, 255, 153));

        btnNewFrom.setBackground(new java.awt.Color(204, 153, 0));
        btnNewFrom.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnNewFrom.setForeground(new java.awt.Color(255, 255, 255));
        btnNewFrom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TaiLieu/Hinh/Refresh.png"))); // NOI18N
        btnNewFrom.setText("LÀM MỚI");
        btnNewFrom.setToolTipText("Làm mới From thông tin");
        btnNewFrom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewFromActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(204, 153, 0));
        btnXoa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TaiLieu/Hinh/Delete.png"))); // NOI18N
        btnXoa.setText("XÓA");
        btnXoa.setToolTipText("Xóa học viên khỏi danh sách");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(204, 153, 0));
        btnSua.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TaiLieu/Hinh/Upload.png"))); // NOI18N
        btnSua.setText("SỬA");
        btnSua.setToolTipText("Sửa thông tin học viên");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnThem.setBackground(new java.awt.Color(204, 153, 0));
        btnThem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TaiLieu/Hinh/Add.png"))); // NOI18N
        btnThem.setText("THÊM");
        btnThem.setToolTipText("Thêm học viên vào danh sách");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnfirst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TaiLieu/Hinh/first.png"))); // NOI18N
        btnfirst.setText("jButton3");
        btnfirst.setPreferredSize(new java.awt.Dimension(50, 45));
        btnfirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfirstActionPerformed(evt);
            }
        });

        btnback.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TaiLieu/Hinh/back.png"))); // NOI18N
        btnback.setText("jButton4");
        btnback.setPreferredSize(new java.awt.Dimension(50, 45));
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });

        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TaiLieu/Hinh/next.png"))); // NOI18N
        btnNext.setText("jButton2");
        btnNext.setPreferredSize(new java.awt.Dimension(50, 45));
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnLast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TaiLieu/Hinh/last.png"))); // NOI18N
        btnLast.setPreferredSize(new java.awt.Dimension(50, 40));
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(btnXoa)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnNewFrom))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(btnThem)
                            .addGap(11, 11, 11)
                            .addComponent(btnSua)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnfirst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnback, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnNewFrom, btnSua, btnThem, btnXoa});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSua)
                    .addComponent(btnThem))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoa)
                    .addComponent(btnNewFrom))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLast, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnfirst, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnback, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnLast, btnNext, btnback, btnfirst});

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(26, 26, 26)
                        .addComponent(lblHocLuc, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(123, 123, 123)
                                .addComponent(lblMaHV, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(46, 46, 46)
                                .addComponent(txtMaHV, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(90, 90, 90)
                                .addComponent(txtDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(39, 39, 39)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxMaKhoaHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(lblMaNguoiHoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtMaNguoiHoc, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(46, 46, 46)
                                .addComponent(lblDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(90, 90, 90)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnTimkiem)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cbxMaKhoaHoc, lblDiem, txtDiem, txtMaHV, txtMaNguoiHoc});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblMaHV)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(5, 5, 5))
                            .addComponent(txtMaHV, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTimKiem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnTimkiem)
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(cbxMaKhoaHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addComponent(lblMaNguoiHoc)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(txtMaNguoiHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addComponent(lblDiem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(txtDiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(lblHocLuc))))
                        .addGap(50, 50, 50))))
        );

        pnHocVien.addTab("Cập nhật", jPanel1);

        tblHocVien.setForeground(new java.awt.Color(51, 0, 204));
        tblHocVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã HỌC VIÊN", "MÃ KHÓA HỌC", "MÃ NGƯỜI HỌC", "ĐIỂM", "XẾP LOẠI HỌC LỰC"
            }
        ));
        tblHocVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHocVienMouseClicked(evt);
            }
        });
        tblHocVien.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                tblHocVienComponentHidden(evt);
            }
        });
        jScrollPane1.setViewportView(tblHocVien);

        btnUpdate.setText("Cập nhật dữ liệu");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(647, Short.MAX_VALUE)
                .addComponent(btnUpdate)
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(btnUpdate)
                .addContainerGap())
        );

        pnHocVien.addTab("Danh Sách", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(311, 311, 311)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnHocVien, javax.swing.GroupLayout.PREFERRED_SIZE, 773, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnHocVien))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblHocVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHocVienMouseClicked
        tblHocVien.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent a) {
                if (a.getClickCount() == 2) {
                    int index = tblHocVien.getSelectedRow();
                    showFrom(index);
                    pnHocVien.setSelectedIndex(0);
                }
            }

        });
    }//GEN-LAST:event_tblHocVienMouseClicked

    private void btnTimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimkiemActionPerformed
        if (Util.checkRongLbl(txtTimKiem.getText(), lblTimKiem, "* Nhập mã học viên vào ô tìm kiếm")) {
            return;
        }
        HocVien hv = HocVienDAO.search_HocVien(txtTimKiem.getText());
        if (hv == null) {
            JOptionPane.showMessageDialog(this, "Mã học viên không tồn tại mời bạn nhập lại mã");
        } else {
            JOptionPane.showMessageDialog(this, "Đã tìm thấy học viên mã: " + txtTimKiem.getText());
            txtMaHV.setText(hv.getMaHV());
            cbx_khoaHoc.setSelectedItem(hv.getMaKH());
            txtMaNguoiHoc.setText(hv.getMaNH());
            txtDiem.setText(String.valueOf(hv.getDiem()));
            lblHocLuc.setText(hv.getXepLoai(hv.getDiem()));
        }
    }//GEN-LAST:event_btnTimkiemActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        lstHocVien = HocVienDAO.getlstHocVien();
        loadDataToTable();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        btnLast.setEnabled(true);
        btnNext.setEnabled(true);
        int index = tblHocVien.getSelectedRow();
        if(index == 0){
            btnback.setEnabled(false);
            btnfirst.setEnabled(false);
            return;
        }
        if (index > 0) {
            index--;
            tblHocVien.setRowSelectionInterval(index, index);
            showFrom(index);
        }
    }//GEN-LAST:event_btnbackActionPerformed

    private void btnfirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfirstActionPerformed
        btnLast.setEnabled(true);
        btnNext.setEnabled(true);
        int index = tblHocVien.getSelectedRow();
        if(index == 0){
            btnback.setEnabled(false);
            btnfirst.setEnabled(false);
            return;
        }
        if (model_table.getRowCount() > 0) {
            tblHocVien.setRowSelectionInterval(0, 0);
            showFrom(0);
        }
    }//GEN-LAST:event_btnfirstActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        btnback.setEnabled(true);
            btnfirst.setEnabled(true);
        int index = HocVienDAO.getlstHocVien().size() - 1;
        if(index == HocVienDAO.getlstHocVien().size() - 1){
            btnLast.setEnabled(false);
            btnNext.setEnabled(false);
            return;
        }
        if (index > 0) {
            tblHocVien.setRowSelectionInterval(index, index);
            showFrom(index);
        }
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        btnback.setEnabled(true);
            btnfirst.setEnabled(true);
        int index = tblHocVien.getSelectedRow();
        if(index == HocVienDAO.getlstHocVien().size() - 1){
            btnLast.setEnabled(false);
            btnNext.setEnabled(false);
            return;
        }
        if (index < HocVienDAO.getlstHocVien().size() - 1) {
            index++;
            tblHocVien.setRowSelectionInterval(index, index);
            showFrom(index);
        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (Util.checkRongLbl(txtMaHV.getText(), lblMaHV, "* Nhập mã học viên")
                || Util.checkRongLbl(txtMaNguoiHoc.getText(), lblMaNguoiHoc, "* Nhập mã người học")) {
            return;
        }
        NguoiHoc nh = HocVienDAO.check_MaNguoiHoc(txtMaNguoiHoc.getText());
        if (nh == null) {
            lblMaNguoiHoc.setText("* Mã người học không tồn tại");
            return;
        }
        HocVien hv = getHocVien();
        for (HocVien x : lstHocVien) {
            if (x.getMaHV().equalsIgnoreCase(hv.getMaHV())) {
                lblMaHV.setText("* Mã học viên đã tồn tại");
                return;
            }
        }
        if (!txtDiem.getText().isEmpty()) {
            if (Util.checkSoLBL(txtDiem.getText(), lblDiem)) {
                return;
            }
        }
        HocVienDAO.addHocVien(hv);
        lstHocVien = HocVienDAO.getlstHocVien();
        loadDataToTable();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if (Util.checkRongLbl(txtMaHV.getText(), lblMaHV, "* Nhập mã học viên")
                || Util.checkRongLbl(txtMaNguoiHoc.getText(), lblMaNguoiHoc, "* Nhập mã người học")) {
            return;
        }
        NguoiHoc nh = HocVienDAO.check_MaNguoiHoc(txtMaNguoiHoc.getText());
        if (nh == null) {
            lblMaNguoiHoc.setText("* Mã người học không tồn tại");
            return;
        }
        HocVien hv = getHocVien();
        if (!txtDiem.getText().isEmpty()) {
            if (Util.checkSoLBL(txtDiem.getText(), lblDiem)) {
                return;
            }
        }
        HocVienDAO.update_HocVien(hv);
        lstHocVien = HocVienDAO.getlstHocVien();
        loadDataToTable();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        if (Util.checkRongLbl(txtMaHV.getText(), lblMaHV, "* Nhập mã học viên")) {
            return;
        }
        HocVienDAO.delete_HocVien(txtMaHV.getText());
        lstHocVien = HocVienDAO.getlstHocVien();
        loadDataToTable();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnNewFromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewFromActionPerformed
        txtMaHV.setText("");
        txtMaNguoiHoc.setText("");
        txtTimKiem.setText("");
        txtDiem.setText("");
        lblHocLuc.setText("...");
        lblDiem.setText("");
        lblMaHV.setText("");
        lblMaNguoiHoc.setText("");
    }//GEN-LAST:event_btnNewFromActionPerformed

    private void tblHocVienComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tblHocVienComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_tblHocVienComponentHidden

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
            java.util.logging.Logger.getLogger(HocVienJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HocVienJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HocVienJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HocVienJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new HocVienJFrame().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNewFrom;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimkiem;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnback;
    private javax.swing.JButton btnfirst;
    private javax.swing.JComboBox<String> cbxMaKhoaHoc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDiem;
    private javax.swing.JLabel lblHocLuc;
    private javax.swing.JLabel lblMaHV;
    private javax.swing.JLabel lblMaNguoiHoc;
    private javax.swing.JLabel lblTimKiem;
    private javax.swing.JTabbedPane pnHocVien;
    private javax.swing.JTable tblHocVien;
    private javax.swing.JTextField txtDiem;
    private javax.swing.JTextField txtMaHV;
    private javax.swing.JTextField txtMaNguoiHoc;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
