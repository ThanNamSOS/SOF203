package Polypro;

import DAO.ChuyenDeDAO;
import DAO.Util;
import Model.ChuyenDe;
import Model.NhanVien;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class ChuyenDeJFrame extends javax.swing.JFrame {

    DefaultTableModel modelTB = new DefaultTableModel();
    List<ChuyenDe> listChuyenDe = ChuyenDeDAO.getListChuyenDe();
    NhanVien nv;
    
    
    private JFileChooser choice;
     private final String path = "IMG_SQL\\IMG\\";
     private final String imgType = "png";
    public ChuyenDeJFrame(NhanVien nv) {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        modelTB = (DefaultTableModel) tblTableCD.getModel();
        loadTable();
        nv = nv;
        String cv = nv.getVaiTro()==true?"Nhân viên": "Trưởng phòng";
        if(cv.equalsIgnoreCase("Nhân viên")){
            btnXoa.setEnabled(false);
        }
        choice = new JFileChooser("C:\\Users\\Admin\\OneDrive\\Máy tính\\SOF204_DA_MAU\\Lab_SOF204\\SOF204_Namtvph13393\\IMG_SQL\\IMG");
        choice.setFileFilter(new FileNameExtensionFilter("Image File", "jpg", "png"));
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
    }
    
    public void loadTable() {
        modelTB.setRowCount(0);
        for (ChuyenDe x : listChuyenDe) {
            modelTB.addRow(new Object[]{x.getMaCD(), x.getTenCD(), x.getHocPhi(), x.getThoiLuong(),x.getImg(), x.getMoTa()});
        }
        tblTableCD.setModel(modelTB);
    }
    
    public ChuyenDe getChuyenDe() {
        ChuyenDe chuyenDe = null;
        try {
        String maCD = txtMaChuyenDe.getText();
        String tenCD = txtTenCD.getText();
        float hocPhi = Float.parseFloat(txtHocPhi.getText());
        int thoiLuong = Integer.parseInt(txtThoiLuong.getText());
        String imgName = null;
        String ghiChu = txtMoTA.getText();
        if (lblHinhAnh.getIcon() != null) {
            int index = tblTableCD.getSelectedRow();
            if (index == -1) {
                imgName = saveImage(((ImageIcon) lblHinhAnh.getIcon()).getImage(), getOriginalImageName(choice.getSelectedFile()));
                System.out.println("img 1: "+imgName);
            } else {
                System.out.println("img null");
                imgName = ChuyenDeDAO.getListChuyenDe().get(index).getImg();
            }
        }
        chuyenDe = new ChuyenDe(maCD, tenCD, hocPhi, thoiLuong,imgName, ghiChu);
        
        } catch (Exception e) {
            e.printStackTrace();
        }
         return chuyenDe;
    }
    
    
    public void showFrom(int index){
        ChuyenDe chuyenDe = listChuyenDe.get(index);
        txtMaChuyenDe.setText(chuyenDe.getMaCD());
        txtTenCD.setText(chuyenDe.getTenCD());
        txtHocPhi.setText(String.valueOf(chuyenDe.getHocPhi()));
        txtThoiLuong.setText(String.valueOf(chuyenDe.getThoiLuong()));
        lblHinhAnh.setIcon(chuyenDe.getImg()!= null ? getHinhAnh(chuyenDe.getImg()) : null);
        txtMoTA.setText(chuyenDe.getMoTa());
    }
    public void showFrom(ChuyenDe chuyenDe){
        txtMaChuyenDe.setText(chuyenDe.getMaCD());
        txtTenCD.setText(chuyenDe.getTenCD());
        txtHocPhi.setText(String.valueOf(chuyenDe.getHocPhi()));
        txtThoiLuong.setText(String.valueOf(chuyenDe.getThoiLuong()));
        lblHinhAnh.setIcon(chuyenDe.getImg()!= null ? getHinhAnh(chuyenDe.getImg()) : null);
        txtMoTA.setText(chuyenDe.getMoTa());
    }
    
    public void clearFrom(){
        txtMaChuyenDe.setText("");
       txtTenCD.setText("");
       txtThoiLuong.setText("");
       txtHocPhi.setText("");
       txtMoTA.setText("");
       txtTimKiem.setText("");
       
       lblMaCD.setText("");
       lblTenCD.setText("");
       lblHocPhi.setText("");
       lblThoiLuong.setText(null);
       lblTimKiem.setText(null);
       lblHinhAnh.setIcon(null);
       lblHinh.setText(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tabPane = new javax.swing.JTabbedPane();
        pnCapNhat = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMaChuyenDe = new javax.swing.JTextField();
        txtThoiLuong = new javax.swing.JTextField();
        txtTenCD = new javax.swing.JTextField();
        txtHocPhi = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMoTA = new javax.swing.JTextArea();
        btnTimKiem = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        lblMaCD = new javax.swing.JLabel();
        lblTenCD = new javax.swing.JLabel();
        lblThoiLuong = new javax.swing.JLabel();
        lblHocPhi = new javax.swing.JLabel();
        lblTimKiem = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblHinhAnh = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btnback = new javax.swing.JButton();
        btnfirst = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        lblHinh = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTableCD = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("QUẢN LÝ CHUYÊN ĐỀ");

        pnCapNhat.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Mã chuyên đề");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Tên chuyên đề");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Thời lượng");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Học phí");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Mô tả");

        txtThoiLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtThoiLuongActionPerformed(evt);
            }
        });

        txtMoTA.setColumns(20);
        txtMoTA.setRows(5);
        jScrollPane1.setViewportView(txtMoTA);

        btnTimKiem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TaiLieu/Hinh/Search.png"))); // NOI18N
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        lblMaCD.setForeground(new java.awt.Color(204, 51, 0));
        lblMaCD.setText(" ");

        lblTenCD.setForeground(new java.awt.Color(204, 102, 0));
        lblTenCD.setText(" ");

        lblThoiLuong.setForeground(new java.awt.Color(204, 102, 0));
        lblThoiLuong.setText(" ");

        lblHocPhi.setForeground(new java.awt.Color(204, 102, 0));
        lblHocPhi.setText(" ");

        lblTimKiem.setForeground(new java.awt.Color(153, 153, 0));
        lblTimKiem.setText(" ");

        jPanel3.setBackground(new java.awt.Color(0, 0, 204));
        jPanel3.setForeground(new java.awt.Color(0, 0, 204));

        lblHinhAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblHinhAnhMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHinhAnh, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHinhAnh, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Ảnh chuyên đề");

        jPanel4.setBackground(new java.awt.Color(0, 255, 204));

        btnThem.setBackground(new java.awt.Color(255, 51, 0));
        btnThem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TaiLieu/Hinh/Add.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.setToolTipText("Thêm chuyên đề mới");
        btnThem.setPreferredSize(new java.awt.Dimension(65, 30));
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(255, 51, 0));
        btnSua.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TaiLieu/Hinh/Upload.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.setToolTipText("Sửa thông tin chuyên đề");
        btnSua.setPreferredSize(new java.awt.Dimension(57, 30));
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnNew.setBackground(new java.awt.Color(255, 51, 0));
        btnNew.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnNew.setForeground(new java.awt.Color(255, 255, 255));
        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TaiLieu/Hinh/Refresh.png"))); // NOI18N
        btnNew.setText("Mới");
        btnNew.setToolTipText("Làm mới thông tin trên from");
        btnNew.setPreferredSize(new java.awt.Dimension(83, 30));
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(255, 51, 0));
        btnXoa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TaiLieu/Hinh/Delete.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.setToolTipText("Xóa chuyên đề");
        btnXoa.setPreferredSize(new java.awt.Dimension(55, 30));
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(0, 255, 204));

        btnback.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TaiLieu/Hinh/back.png"))); // NOI18N
        btnback.setText("jButton4");
        btnback.setPreferredSize(new java.awt.Dimension(50, 45));
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
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

        btnLast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/TaiLieu/Hinh/last.png"))); // NOI18N
        btnLast.setPreferredSize(new java.awt.Dimension(50, 40));
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(btnfirst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnback, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLast, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnfirst, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnback, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnLast, btnNext, btnback, btnfirst});

        lblHinh.setForeground(new java.awt.Color(204, 102, 0));
        lblHinh.setText(" ");

        javax.swing.GroupLayout pnCapNhatLayout = new javax.swing.GroupLayout(pnCapNhat);
        pnCapNhat.setLayout(pnCapNhatLayout);
        pnCapNhatLayout.setHorizontalGroup(
            pnCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCapNhatLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnCapNhatLayout.createSequentialGroup()
                        .addGroup(pnCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnCapNhatLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                                .addGroup(pnCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(pnCapNhatLayout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnCapNhatLayout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(pnCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtThoiLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblThoiLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(pnCapNhatLayout.createSequentialGroup()
                                        .addGroup(pnCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3))
                                        .addGap(18, 18, 18)
                                        .addGroup(pnCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtMaChuyenDe, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblMaCD, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblTenCD, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtTenCD, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(pnCapNhatLayout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtHocPhi, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblHocPhi, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(pnCapNhatLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)))
                        .addGroup(pnCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnCapNhatLayout.createSequentialGroup()
                                .addGap(121, 121, 121)
                                .addGroup(pnCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(pnCapNhatLayout.createSequentialGroup()
                                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnTimKiem))))
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnCapNhatLayout.createSequentialGroup()
                        .addGap(38, 479, Short.MAX_VALUE)
                        .addGroup(pnCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnCapNhatLayout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addGap(16, 16, 16))))
                        .addGap(109, 109, 109))))
        );
        pnCapNhatLayout.setVerticalGroup(
            pnCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnCapNhatLayout.createSequentialGroup()
                .addGroup(pnCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnCapNhatLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(lblMaCD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaChuyenDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addComponent(lblTenCD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTenCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(lblThoiLuong)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtThoiLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(24, 24, 24)
                        .addComponent(lblHocPhi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtHocPhi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(pnCapNhatLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblHinh)
                .addGap(19, 19, 19)
                .addGroup(pnCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnCapNhatLayout.createSequentialGroup()
                        .addComponent(lblTimKiem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTimKiem))))
                .addGroup(pnCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnCapNhatLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnCapNhatLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(pnCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        tabPane.addTab("Cập nhật", pnCapNhat);

        tblTableCD.setForeground(new java.awt.Color(51, 0, 153));
        tblTableCD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "MÃ CD", "TÊN CD", "HỌC PHÍ", "THỜI LƯỢNG", "HÌNH ẢNH", "MÔ TẢ"
            }
        ));
        tblTableCD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTableCDMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblTableCD);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(251, Short.MAX_VALUE))
        );

        tabPane.addTab("Danh sách", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(360, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(240, 240, 240))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(tabPane, javax.swing.GroupLayout.PREFERRED_SIZE, 769, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tabPane, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        try {
            if (Util.checkRongLbl(txtMaChuyenDe.getText(), lblMaCD, "Bạn chưa nhập mã chuyên đề")
                ||Util.checkSizeMaCD(txtMaChuyenDe.getText(), lblMaCD)
                || Util.checkRongLbl(txtTenCD.getText(), lblTenCD, "Bạn chưa nhập tên chuyên đề")
                ||Util.checkHoTenNhanVien(txtTenCD.getText(), lblTenCD)
                || Util.checkRongLbl(txtThoiLuong.getText(), lblThoiLuong, "Bạn chưa nhập thời lượng chuyên đề")
                || Util.checkThoiLuongHocPhi(txtThoiLuong.getText(), lblThoiLuong)
                || Util.checkRongLbl(txtHocPhi.getText(), lblHocPhi, "Bạn chưa nhập học phí chuyên đề")
                || Util.checkThoiLuongHocPhi(txtHocPhi.getText(), lblHocPhi)
                || Util.checkRongHinh(lblHinhAnh, lblHinh)
                ) {
            return;
        } 
        if(ChuyenDeDAO.insert_ChuyenDe_byMaCD(txtMaChuyenDe.getText(), lblMaCD))return;
        
        ChuyenDe chuyenDe = getChuyenDe();
        ChuyenDeDAO.insert_ChuyenDe(chuyenDe);
         listChuyenDe = ChuyenDeDAO.getListChuyenDe();
         loadTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        if (Util.checkRongLbl(txtTimKiem.getText(), lblTimKiem, "Nhập mã chuyên đề cần tìm")) {
            return;
        }
        ChuyenDe chuyenDe = ChuyenDeDAO.searchChuyenDe(txtTimKiem.getText());
        if(chuyenDe != null){
            showFrom(chuyenDe);
        }else{
            lblTimKiem.setText("Mã chuyên đề không tồn tại");
        }
        
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        if (Util.checkRongLbl(txtMaChuyenDe.getText(), lblMaCD, "Nhập mã chuyên đề cần xóa")) {
            return;
        }
        if(ChuyenDeDAO.insert_ChuyenDe_byMaCD_delete(txtMaChuyenDe.getText(), lblMaCD))return;
        ChuyenDe cd = getChuyenDe();
        int xacNhan = JOptionPane.showConfirmDialog(this, "Xác nhân xóa chuyên đề mã: "+ txtMaChuyenDe.getText(),"Xác nhận" ,JOptionPane.YES_NO_OPTION);
        if(xacNhan == JOptionPane.YES_OPTION){
            ChuyenDeDAO.delete_ChuyenDe(txtMaChuyenDe.getText());
         listChuyenDe = ChuyenDeDAO.getListChuyenDe();
         loadTable();
         clearFrom();
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if (Util.checkRongLbl(txtMaChuyenDe.getText(), lblMaCD, "Bạn chưa nhập mã chuyên đề")
                ||Util.checkSizeMaCD(txtMaChuyenDe.getText(), lblMaCD)
                || Util.checkRongLbl(txtTenCD.getText(), lblTenCD, "Bạn chưa nhập tên chuyên đề")
                ||Util.checkHoTenNhanVien(txtTenCD.getText(), lblTenCD)
                || Util.checkRongLbl(txtThoiLuong.getText(), lblThoiLuong, "Bạn chưa nhập thời lượng chuyên đề")
                || Util.checkThoiLuongHocPhi(txtThoiLuong.getText(), lblThoiLuong)
                || Util.checkRongLbl(txtHocPhi.getText(), lblHocPhi, "Bạn chưa nhập học phí chuyên đề")
                || Util.checkThoiLuongHocPhi(txtHocPhi.getText(), lblHocPhi)
                || Util.checkRongHinh(lblHinhAnh, lblHinh)
                ) {
            return;
        } 
        if(ChuyenDeDAO.update_ChuyenDe_byMaCD(txtMaChuyenDe.getText(), lblMaCD))return;
        
        ChuyenDe chuyenDe = getChuyenDe();
        ChuyenDeDAO.update_ChuyenDe(chuyenDe);
        listChuyenDe = ChuyenDeDAO.getListChuyenDe();
         loadTable();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void tblTableCDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTableCDMouseClicked
 
       tblTableCD.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent a){
                 if (a.getClickCount() == 2){
                int index =  tblTableCD.getSelectedRow();
                showFrom(index);
                tabPane.setSelectedIndex(0);
                }
            }

        });
    }//GEN-LAST:event_tblTableCDMouseClicked

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        clearFrom();
       
    }//GEN-LAST:event_btnNewActionPerformed

    private void lblHinhAnhMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHinhAnhMousePressed
        if (choice.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = choice.getSelectedFile();
            System.out.println("file" +file);
            try {
                lblHinhAnh.setIcon(new ImageIcon(ImageIO.read(file).getScaledInstance(lblHinhAnh.getWidth(), lblHinhAnh.getHeight(), Image.SCALE_SMOOTH)));
            } catch (IOException e) {
                System.out.println("Erro HinhAnhMousePressed");
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_lblHinhAnhMousePressed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        int index = ChuyenDeDAO.getListChuyenDe().size()-1;
        if (index > 0) {
            tblTableCD.setRowSelectionInterval(index, index);
            showFrom(index);
        }
    }//GEN-LAST:event_btnLastActionPerformed

    private void txtThoiLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtThoiLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtThoiLuongActionPerformed

    private void btnfirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfirstActionPerformed
        if (modelTB.getRowCount() > 0) {
            tblTableCD.setRowSelectionInterval(0, 0);
            showFrom(0);
        }
    }//GEN-LAST:event_btnfirstActionPerformed

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        int index = tblTableCD.getSelectedRow();
        if (index > 0) {
            index--;
            tblTableCD.setRowSelectionInterval(index, index);
            showFrom(ChuyenDeDAO.getListChuyenDe().get(index));
        }
    }//GEN-LAST:event_btnbackActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        int index = tblTableCD.getSelectedRow();
        if (index < ChuyenDeDAO.getListChuyenDe().size() - 1) {
            index++;
            tblTableCD.setRowSelectionInterval(index, index);
            showFrom(ChuyenDeDAO.getListChuyenDe().get(index));
        }
    }//GEN-LAST:event_btnNextActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ChuyenDeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ChuyenDeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ChuyenDeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ChuyenDeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ChuyenDeJFrame().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnback;
    private javax.swing.JButton btnfirst;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblHinh;
    private javax.swing.JLabel lblHinhAnh;
    private javax.swing.JLabel lblHocPhi;
    private javax.swing.JLabel lblMaCD;
    private javax.swing.JLabel lblTenCD;
    private javax.swing.JLabel lblThoiLuong;
    private javax.swing.JLabel lblTimKiem;
    private javax.swing.JPanel pnCapNhat;
    private javax.swing.JTabbedPane tabPane;
    private javax.swing.JTable tblTableCD;
    private javax.swing.JTextField txtHocPhi;
    private javax.swing.JTextField txtMaChuyenDe;
    private javax.swing.JTextArea txtMoTA;
    private javax.swing.JTextField txtTenCD;
    private javax.swing.JTextField txtThoiLuong;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
 private Icon getHinhAnh(String hinhAnh) {
        return new ImageIcon(path + hinhAnh);
    }
    private String getOriginalImageName(File file) {
        return file.getName().split("\\.")[0];
    }
    private String saveImage(Image image, String name) {
        BufferedImage img = new BufferedImage(lblHinhAnh.getWidth(), lblHinhAnh.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = img.createGraphics();
        g2d.drawImage(image, 0, 0, null);
        g2d.dispose();

        File saveImg = new File(path + name + "." + imgType);

        try {
            ImageIO.write(img, imgType, saveImg);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return saveImg.getName();
    }

}
