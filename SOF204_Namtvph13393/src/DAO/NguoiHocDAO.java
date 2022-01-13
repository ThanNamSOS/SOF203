package DAO;

import Model.NguoiHoc;
import Model.NhanVien;
import Polypro.NguoiHocJFrame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class NguoiHocDAO {
    private static String SELECT_ALL_NGUOIHOC = "select [MaNH], [HoTen],  NgaySinh, [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV],  [NgayDK] from NguoiHoc";
    private static String INSERT_NGUOIHOC = "INSERT [NguoiHoc] ([MaNH], [HoTen], [NgaySinh], [GioiTinh], [DienThoai], [Email], [GhiChu], [MaNV], [NgayDK]) VALUES (?, ?, ?, ?,?, ?, ?, ?,?)";
    private static String UPDATE_NGUOIHOC1 = "UPDATE [NguoiHoc] SET [HoTen] = ?, [NgaySinh] = ?, [GioiTinh] = ?, [DienThoai] = ?, [Email] = ?, [GhiChu] = ?, [MaNV] = ?, [NgayDK]  = ? WHERE MaNH = ?";
    private static String DELETE_NGUOIHOC2 = "{CALL delete_NguoiHoc(?)}";
    private static String SELECT_MANH_FROM_NGUOIHOC = "select MaNH FROM NguoiHoc WHERE MaNH = ?";
    private static String SELECT_MANV_FROM_NGUOIHOC = "{CALL SELECT_MANV_FROM_NGUOIHOC(?)}";
    private static String SELECT_NGUOIHOC = "select * from NguoiHoc where MaNH = ?";
    
    private static String CHECKMANV_NGUOIHOC = "SELECT MaNV FROM NhanVien WHERE MaNV = ?";
    
    
    
    public static List<NguoiHoc> getListNguoiHoc(){
        List<NguoiHoc> listNH = new ArrayList<>();
        try (Connection con = JDBC.getConnection();
                PreparedStatement stm = con.prepareStatement(SELECT_ALL_NGUOIHOC)){
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {                
                listNH.add(new NguoiHoc(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getDate(3),
                        rs.getBoolean(4), 
                        rs.getString(5), 
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getDate(9)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNH;
    }
    
    public static void insert_NguoiHoc(NguoiHoc nguoiHoc){
        try (Connection con = JDBC.getConnection();
                PreparedStatement stm = con.prepareStatement(INSERT_NGUOIHOC)){
            stm.setString(1, nguoiHoc.getMaNH());
            stm.setString(2, nguoiHoc.getHoTen());
            stm.setDate(3, new java.sql.Date( nguoiHoc.getNgaySinh().getTime()));
            stm.setBoolean(4, nguoiHoc.isGioiTinh());
            stm.setString(5, nguoiHoc.getSdt());
            stm.setString(6, nguoiHoc.getEmail());
            stm.setString(7, nguoiHoc.getGhiChu());
            stm.setString(8, nguoiHoc.getMaNV());
            stm.setDate(9 ,new java.sql.Date( nguoiHoc.getNgayDangKy().getTime()));
            if(stm.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "Thêm người học thành công");
            }else{
                JOptionPane.showMessageDialog(null, "Thêm người học không thành công");
            }
            
        } catch (Exception e) {
        }
    }
    
    public static void update_NguoiHoc(NguoiHoc nguoiHoc){
        try (Connection con = JDBC.getConnection();
                PreparedStatement stm = con.prepareStatement(UPDATE_NGUOIHOC1)){
            stm.setString(1, nguoiHoc.getHoTen());
            stm.setDate(2, new java.sql.Date( nguoiHoc.getNgaySinh().getTime()));
            stm.setBoolean(3, nguoiHoc.isGioiTinh());
            stm.setString(4, nguoiHoc.getSdt());
            stm.setString(5, nguoiHoc.getEmail());
            stm.setString(6, nguoiHoc.getGhiChu());
            stm.setString(7, nguoiHoc.getMaNV());
            stm.setDate(8 ,new java.sql.Date( nguoiHoc.getNgayDangKy().getTime()));
            stm.setString(9, nguoiHoc.getMaNH());            
            if(stm.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "Cập nhật thông tin người học thành công");
            }else{
                JOptionPane.showMessageDialog(null, "Cập nhật thông tin người học không thành công");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void delete_NguoiHoc(String maNH){
        try (Connection con = JDBC.getConnection();
                PreparedStatement stm = con.prepareStatement(DELETE_NGUOIHOC2)){
            stm.setString(1, maNH);
            if(stm.executeUpdate() >=0){
                JOptionPane.showMessageDialog(null, "Xóa thông tin người học thành công");
            }else{
                JOptionPane.showMessageDialog(null, "Xóa thông tin người học không thành công");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public static NguoiHoc search_NguoiHoc(String maNH){
        NguoiHoc nguoiHoc = null;
        try (Connection con = JDBC.getConnection();
                PreparedStatement stm = con.prepareStatement(SELECT_NGUOIHOC)){
            stm.setString(1, maNH);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {                
                nguoiHoc = new NguoiHoc(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getBoolean(4),  rs.getString(5),  rs.getString(6), rs.getString(7), rs.getString(8), rs.getDate(9));
            }
           
        } catch (Exception e) {
        }
        return nguoiHoc;
    }
    
    public static boolean CheckMaNV_From(String manv){
        NhanVien nv = null;
        try (Connection con = JDBC.getConnection();
                PreparedStatement stm = con.prepareStatement(CHECKMANV_NGUOIHOC)){
            stm.setString(1, manv);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {                
                nv = new NhanVien(rs.getString(1));
            }
           
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
        if(nv != null){
            NguoiHocJFrame.lblMaNV.setText("");
            return false;
        }else{
            NguoiHocJFrame.lblMaNV.setText("Mã nhân viên không tồn tại trên hệ thống");
            return true;
        }
    }

    
    public static boolean CheckTrung_Insert(String maNH){
        NguoiHoc nguoiHoc = null;
        try (Connection con = JDBC.getConnection();
                PreparedStatement stm = con.prepareStatement(SELECT_NGUOIHOC)){
            stm.setString(1, maNH);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {                
                nguoiHoc = new NguoiHoc(rs.getString(1));
            }
           
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
        if(nguoiHoc != null){
            NguoiHocJFrame.lblThongBaoMaNH.setText("Mã người học đã tồn tại - nhập mã khác");
            return true;
        }
        NguoiHocJFrame.lblThongBaoMaNH.setText("");
        return false;
    }
    public static boolean CheckTrung_Update(String maNH){
        NguoiHoc nguoiHoc = null;
        try (Connection con = JDBC.getConnection();
                PreparedStatement stm = con.prepareStatement(SELECT_NGUOIHOC)){
            stm.setString(1, maNH);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {                
                nguoiHoc = new NguoiHoc(rs.getString(1));
            }
           
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
        if(nguoiHoc == null){
            NguoiHocJFrame.lblThongBaoMaNH.setText("Mã người học không tồn tại trên hệ thống");
            return true;
        }
        NguoiHocJFrame.lblThongBaoMaNH.setText("");
        return false;
    }
    
    
}
