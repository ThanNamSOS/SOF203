package Polypro;

import DAO.NguoiHocDAO;
import DAO.Util;
import Model.NguoiHoc;
import Model.NhanVien;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class NguoiHocJFrame extends javax.swing.JFrame {

    DefaultTableModel table_model = new DefaultTableModel();

    List<NguoiHoc> listNguoiHoc = NguoiHocDAO.getListNguoiHoc();
    NhanVien nv;
    public NguoiHocJFrame(NhanVien nhanVien) {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        table_model = (DefaultTableModel) tblDanhSachNH.getModel();
        loadDataToTable();
        nv = nhanVien;
        String cv = nv.getVaiTro()==true?"Nhân viên": "Trưởng phòng";
        if(cv.equalsIgnoreCase("Nhân viên")){
            btnXoa.setEnabled(false);
        }
    }

    public void loadDataToTable() {
        table_model.setRowCount(0);
        for (NguoiHoc x : listNguoiHoc) {
            String gt = x.isGioiTinh()?"Nam":"Nữ";
            table_model.addRow(new Object[]{x.getMaNH(), x.getHoTen(), x.getNgaySinh(),gt, x.getSdt(), x.getEmail(), x.getGhiChu(),
                x.getMaNV(), x.getNgayDangKy()
            });
        }
        tblDanhSachNH.setModel(table_model);
    }

    public NguoiHoc getNguoiHoc() {
        NguoiHoc nguoiHoc = null;
        String maNH = txtMaNH.getText();
        String hoTen = txtHoTen.getText();
        Date ngaySinh = JdateNgaySinh.getDate();
        boolean gioiTinh = rdoNam.isSelected();
        String sdt = txtSDT.getText();
        String email = txtEmail.getText();
        String ghiChu = txtGhiChu.getText();
        String maNV = txtMaNV.getText();
        Date ngayDangKy = JdateNgayDK.getDate();
        nguoiHoc = new NguoiHoc(maNH, hoTen, ngaySinh, gioiTinh, sdt, email, ghiChu, maNV, ngayDangKy);
        return nguoiHoc;
    }

    public void showFrom(int index) {
        NguoiHoc nguoiHoc = listNguoiHoc.get(index);
        txtMaNH.setText(nguoiHoc.getMaNH());
        txtHoTen.setText(nguoiHoc.getHoTen());
        JdateNgaySinh.setDate(nguoiHoc.getNgaySinh());
        if(nguoiHoc.isGioiTinh() == true){
            rdoNam.setSelected(true);
        }else{
            rdoNu.setSelected(true);
        }
        txtSDT.setText(nguoiHoc.getSdt());
        txtEmail.setText(nguoiHoc.getEmail());
        txtGhiChu.setText(nguoiHoc.getGhiChu());
        txtMaNV.setText(nguoiHoc.getMaNV());
        JdateNgayDK.setDate(nguoiHoc.getNgayDangKy());
    }
    public void showFrom(NguoiHoc nguoiHoc) {
        txtMaNH.setText(nguoiHoc.getMaNH());
        txtHoTen.setText(nguoiHoc.getHoTen());
        JdateNgaySinh.setDate(nguoiHoc.getNgaySinh());
        if(nguoiHoc.isGioiTinh() == true){
            rdoNam.setSelected(true);
        }else{
            rdoNu.setSelected(true);
        }
        txtSDT.setText(nguoiHoc.getSdt());
        txtEmail.setText(nguoiHoc.getEmail());
        txtGhiChu.setText(nguoiHoc.getGhiChu());
        txtMaNV.setText(nguoiHoc.getMaNV());
        JdateNgayDK.setDate(nguoiHoc.getNgayDangKy());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        pnNguoiHoc = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtMaNH = new javax.swing.JTextField();
        txtHoTen = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        JdateNgaySinh = new com.toedter.calendar.JDateChooser();
        txtEmail = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtGhiChu = new javax.swing.JTextArea();
        txtMaNV = new javax.swing.JTextField();
        JdateNgayDK = new com.toedter.calendar.JDateChooser();
        lblThongBaoMaNH = new javax.swing.JLabel();
        lblHoTen = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblSDT = new javax.swing.JLabel();
        lblMaNV = new javax.swing.JLabel();
        lblNgayDangKy = new javax.swing.JLabel();
        lblNgaySinh = new javax.swing.JLabel();
        lblTimKiem = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnSua = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JToggleButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDanhSachNH = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Mã người học:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Họ tên:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Ngày sinh:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Giới tính:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Điện thoại");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Email");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Ghi chú");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Mã nhân viên");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Ngày đăng ký");

        buttonGroup1.add(rdoNam);
        rdoNam.setText("Nam");

        buttonGroup1.add(rdoNu);
        rdoNu.setText("Nữ");

        txtGhiChu.setColumns(20);
        txtGhiChu.setRows(5);
        jScrollPane2.setViewportView(txtGhiChu);

        lblThongBaoMaNH.setForeground(new java.awt.Color(153, 153, 0));
        lblThongBaoMaNH.setText(" ");

        lblHoTen.setForeground(new java.awt.Color(153, 153, 0));
        lblHoTen.setText(" ");

        lblEmail.setForeground(new java.awt.Color(153, 153, 0));
        lblEmail.setText(" ");

        lblSDT.setForeground(new java.awt.Color(153, 153, 0));
        lblSDT.setText(" ");

        lblMaNV.setForeground(new java.awt.Color(153, 153, 0));
        lblMaNV.setText(" ");

        lblNgayDangKy.setForeground(new java.awt.Color(153, 153, 0));
        lblNgayDangKy.setText(" ");

        lblNgaySinh.setForeground(new java.awt.Color(153, 153, 0));
        lblNgaySinh.setText(" ");

        lblTimKiem.setForeground(new java.awt.Color(153, 153, 0));
        lblTimKiem.setText(" ");

        jPanel3.setBackground(new java.awt.Color(102, 255, 102));

        btnSua.setBackground(new java.awt.Color(153, 102, 0));
        btnSua.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TaiLieu/Hinh/Upload.png"))); // NOI18N
        btnSua.setText("SỬA");
        btnSua.setToolTipText("Sửa thông tin người học");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnNew.setBackground(new java.awt.Color(153, 102, 0));
        btnNew.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnNew.setForeground(new java.awt.Color(255, 255, 255));
        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TaiLieu/Hinh/Refresh.png"))); // NOI18N
        btnNew.setText("LÀM MỚI");
        btnNew.setToolTipText("Làm mới from thông tin");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnThem.setBackground(new java.awt.Color(153, 102, 0));
        btnThem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TaiLieu/Hinh/Add.png"))); // NOI18N
        btnThem.setText("THÊM");
        btnThem.setToolTipText("Thêm người học mới");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(153, 102, 0));
        btnXoa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TaiLieu/Hinh/Delete.png"))); // NOI18N
        btnXoa.setText("XÓA");
        btnXoa.setToolTipText("Xóa người học khỏi danh sác");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        txtTimKiem.setToolTipText("Nhập mã nhân viên muốn tìn");
        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });

        btnTimKiem.setBackground(new java.awt.Color(153, 102, 0));
        btnTimKiem.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnTimKiem.setForeground(new java.awt.Color(255, 255, 255));
        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TaiLieu/Hinh/Search.png"))); // NOI18N
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.setPreferredSize(new java.awt.Dimension(113, 33));
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnThem, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnXoa))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSua, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnNew))))
                .addGap(0, 36, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnNew, btnSua, btnThem, btnXoa});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnThem)
                        .addGap(16, 16, 16)
                        .addComponent(btnXoa))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(btnSua)
                        .addGap(16, 16, 16)
                        .addComponent(btnNew)))
                .addGap(49, 49, 49))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnTimKiem, txtTimKiem});

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JdateNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rdoNam)
                                .addGap(18, 18, 18)
                                .addComponent(rdoNu))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lblSDT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                                .addComponent(txtSDT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblThongBaoMaNH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMaNH, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(122, 122, 122)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(JdateNgayDK, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblNgayDangKy, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(419, 419, 419)
                                .addComponent(lblTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblThongBaoMaNH)
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaNH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblMaNV)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(13, 13, 13)
                        .addComponent(lblNgayDangKy, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JdateNgayDK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNgaySinh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(JdateNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdoNam)
                            .addComponent(rdoNu)
                            .addComponent(jLabel5))
                        .addGap(29, 29, 29)
                        .addComponent(lblSDT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(17, 17, 17)
                        .addComponent(lblEmail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblTimKiem)))
                .addGap(0, 0, 0))
        );

        pnNguoiHoc.addTab("Cập nhật", jPanel1);

        tblDanhSachNH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "MÃ", "HO TEN", "NGAY SINH", "GIOI TINH", "DIEN THOAI", "EMAIL", "GHI CHU", "MA NV", "NGAY DK"
            }
        ));
        tblDanhSachNH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachNHMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDanhSachNH);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 161, Short.MAX_VALUE))
        );

        pnNguoiHoc.addTab("Danh sách", jPanel2);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("QUẢN LÝ NGƯỜI HỌC");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(233, 233, 233)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnNguoiHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 772, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(pnNguoiHoc))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblDanhSachNHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachNHMouseClicked
        tblDanhSachNH.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent a) {
                if (a.getClickCount() == 2) {
                    int index = tblDanhSachNH.getSelectedRow();
                    showFrom(index);
                    pnNguoiHoc.setSelectedIndex(0);
                }
            }

        });
        
    }//GEN-LAST:event_tblDanhSachNHMouseClicked

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        if (Util.checkRongLbl(txtMaNH.getText(), lblThongBaoMaNH, "* Nhập mã người học muốn xóa")) {
            return;
        }
        NguoiHoc nguoiHoc = getNguoiHoc();
        
        int chooice = JOptionPane.showConfirmDialog(this,"Xác nhận xóa người học mã: "+txtMaNH.getText(),"Delete", JOptionPane.YES_NO_OPTION);
        if(chooice == JOptionPane.YES_OPTION){
            NguoiHocDAO.delete_NguoiHoc(nguoiHoc.getMaNH());
            listNguoiHoc = NguoiHocDAO.getListNguoiHoc();
            loadDataToTable();
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if (Util.checkRongLbl(txtMaNH.getText(), lblThongBaoMaNH, "* Bạn chưa nhập mã người học")
            || Util.checkRongLbl(txtHoTen.getText(), lblHoTen, "* Bạn chưa nhập tên người học")
            || Util.checkRongJdate(JdateNgaySinh, lblNgaySinh, "* Bạn chưa nhập ngày sinh ")
            || Util.checkRongLbl(txtSDT.getText(), lblSDT, "* Bạn chưa nhập SDT người học")
            || Util.checkRongLbl(txtEmail.getText(), lblEmail, "* Bạn chưa nhập Email người học")
            || Util.checkGmail2(txtEmail, lblEmail)
            || Util.checkRongLbl(txtMaNV.getText(), lblMaNV, "* Bạn chưa nhập mã nhân viên ")
            || Util.checkRongJdate(JdateNgayDK, lblNgayDangKy, "* Bạn chưa nhập ngày đăng ký")) {
            return;
        }
        NguoiHoc nguoiHoc = getNguoiHoc();
         if(NguoiHocDAO.CheckTrung_Update(nguoiHoc.getMaNH()))return;
         if(NguoiHocDAO.CheckMaNV_From(nguoiHoc.getMaNV()))return;
            NguoiHocDAO.update_NguoiHoc(nguoiHoc);
            listNguoiHoc = NguoiHocDAO.getListNguoiHoc();
            loadDataToTable();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (Util.checkRongLbl(txtMaNH.getText(), lblThongBaoMaNH, "* Bạn chưa nhập mã người học")
                || Util.checkMaNguoiHoc(txtMaNH.getText(), lblThongBaoMaNH)
            || Util.checkRongLbl(txtHoTen.getText(), lblHoTen, "* Bạn chưa nhập tên người học")
            || Util.checkHoTenNhanVien(txtHoTen.getText(), lblHoTen)
            || Util.checkRongJdate(JdateNgaySinh, lblNgaySinh, "* Bạn chưa nhập ngày sinh ")
            || Util.checkNgaySinhNguoiHoc(JdateNgaySinh, lblNgaySinh)
            || Util.checkRongLbl(txtSDT.getText(), lblSDT, "* Bạn chưa nhập SDT người học")
            || Util.checkRongLbl(txtEmail.getText(), lblEmail, "* Bạn chưa nhập Email người học")
            || Util.checkGmail2(txtEmail, lblEmail)
            || Util.checkRongLbl(txtMaNV.getText(), lblMaNV, "* Bạn chưa nhập mã nhân viên ")
            || Util.checkRongJdate(JdateNgayDK, lblNgayDangKy, "* Bạn chưa nhập ngày đăng ký")
                
                
                ) {
            return;
        }
        NguoiHoc nguoiHoc = getNguoiHoc();
        if(NguoiHocDAO.CheckTrung_Insert(nguoiHoc.getMaNH()))return;
        if(NguoiHocDAO.CheckMaNV_From(nguoiHoc.getMaNV()))return;
            
            NguoiHocDAO.insert_NguoiHoc(nguoiHoc);
            listNguoiHoc = NguoiHocDAO.getListNguoiHoc();
            loadDataToTable();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        lblThongBaoMaNH.setText("");
        lblHoTen.setText("");
        lblSDT.setText("");
        lblNgayDangKy.setText("");
        lblNgaySinh.setText("");
        lblEmail.setText("");
        lblMaNV.setText("");
        
        txtMaNH.setText("");
        txtHoTen.setText("");
        txtSDT.setText("");
        JdateNgayDK.setDate(null);
        JdateNgaySinh.setDate(null);
        txtEmail.setText("");
        txtMaNV.setText("");
        txtGhiChu.setText("");
        rdoNam.setSelected(true);
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        if (Util.checkRongLbl(txtTimKiem.getText(), lblTimKiem, "* Mời bạn nhập mã người học cần tìm")) {
            return;
        }
        NguoiHoc nguoiHoc = NguoiHocDAO.search_NguoiHoc(txtTimKiem.getText());
        if(NguoiHocDAO.search_NguoiHoc(txtTimKiem.getText()) == null){
            lblTimKiem.setText("Mã người học không tồn tại...");
            return;
        }
        showFrom(nguoiHoc);
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemActionPerformed

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
            java.util.logging.Logger.getLogger(NguoiHocJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NguoiHocJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NguoiHocJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NguoiHocJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new NguoiHocJFrame().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser JdateNgayDK;
    private com.toedter.calendar.JDateChooser JdateNgaySinh;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JToggleButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblHoTen;
    public static javax.swing.JLabel lblMaNV;
    private javax.swing.JLabel lblNgayDangKy;
    private javax.swing.JLabel lblNgaySinh;
    private javax.swing.JLabel lblSDT;
    public static javax.swing.JLabel lblThongBaoMaNH;
    private javax.swing.JLabel lblTimKiem;
    private javax.swing.JTabbedPane pnNguoiHoc;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable tblDanhSachNH;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextArea txtGhiChu;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaNH;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
