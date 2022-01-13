package DAO;

import Model.NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class NhanVienDao {
    private static String SELECT_ALL_NHANVIEN = "SELECT * FROM NhanVien";
    private static String SELECT_ALL_NHANVIEN_MANV = "SELECT * FROM NhanVien WHERE MaNV = ?";
    private static String UPDATE_NHANVIEN_BYID = "update NhanVien set MatKhau = ? where MaNV = ?";
    private static String INSERT_NHANVIEN_SQL = "INSERT INTO [dbo].[NhanVien] ([MaNV], [MatKhau], [HoTen], [VaiTro]) VALUES (?, ?,?, ?)";
    private static String UPDATE_NHANVIEN_MANV = "UPDATE NhanVien SET [MatKhau] = ?, [HoTen]=?, [VaiTro]=? WHERE [MaNV] = ?";
    private static String DELETE_NHANVIEN_MANV = "{CALL DELETE_NHANVIEN(?)}";
    private static String SELECT_NHANVIEN_MANV = "SELECT * FROM NhanVien WHERE MaNV = ?";
    private static String CHECKTRUNG_MANV = "SELECT MaNV FROM NhanVien WHERE MaNV = ?";
    
    
    public static List<NhanVien> getListNhanVien(){
        List<NhanVien> listNV = new ArrayList<>();
        try (Connection con = JDBC.getConnection();
                PreparedStatement stm = con.prepareStatement(SELECT_ALL_NHANVIEN)){
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {                
                listNV.add(new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getBoolean(4)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNV;
    }
    
    public static void ResetPass(String maNV, String pass){
        try (Connection con = JDBC.getConnection();
                PreparedStatement stm = con.prepareStatement(UPDATE_NHANVIEN_BYID)){
            stm.setString(1, pass);
            stm.setString(2, maNV);
            if(stm.executeUpdate()> 0){
                JOptionPane.showMessageDialog(null, "Đổi mật khẩu thành công");
            }else{
                JOptionPane.showMessageDialog(null, "Đổi mật khẩu không thành công");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static NhanVien getNhanVien(String maNV){
        NhanVien nv = null;
        try (Connection con = JDBC.getConnection();
                PreparedStatement stm = con.prepareStatement(SELECT_ALL_NHANVIEN_MANV)){
            stm.setString(1, maNV);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {      
                nv = new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getBoolean(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nv;
    }
    
    public static void addNhanVien(NhanVien nv){
         try (Connection con = JDBC.getConnection();
                PreparedStatement stm = con.prepareStatement(INSERT_NHANVIEN_SQL)){
            stm.setString(1, nv.getMaNV());
            stm.setString(2, nv.getMatKhau());
            stm.setString(3, nv.getHoTen());
            stm.setBoolean(4, nv.getVaiTro());
            if(stm.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "Thêm nhân viên thành công");
            }else{
                JOptionPane.showMessageDialog(null, "Thêm nhân viên không thành công");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void update_NhanVien(NhanVien nv){
         try (Connection con = JDBC.getConnection();
                PreparedStatement stm = con.prepareStatement(UPDATE_NHANVIEN_MANV)){
            stm.setString(1, nv.getMatKhau());
            stm.setString(2, nv.getHoTen());
            stm.setBoolean(3, nv.getVaiTro());
            stm.setString(4, nv.getMaNV());
            if(stm.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "Sửa thông tin nhân viên thành công");
            }else{
                JOptionPane.showMessageDialog(null, "Sửa thông tin nhân viên không thành công");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void delete_NhanVien(String maNV){
         try (Connection con = JDBC.getConnection();
                PreparedStatement stm = con.prepareStatement(DELETE_NHANVIEN_MANV)){
            stm.setString(1, maNV);
            if(stm.executeUpdate()>0){
                JOptionPane.showMessageDialog(null, "Xóa nhân viên thành công");
            }else{
                JOptionPane.showMessageDialog(null, "Xóa nhân viên không thành công");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static NhanVien search_NhanVien(String maNV){
        NhanVien nv = null;
         try (Connection con = JDBC.getConnection();
                PreparedStatement stm = con.prepareStatement(SELECT_NHANVIEN_MANV)){
            stm.setString(1, maNV);
            ResultSet rs = stm.executeQuery();
             while (rs.next()) {                 
                 nv = new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getBoolean(4));
             }
        } catch (Exception e) {
            e.printStackTrace();
        }
         return nv;
    }
    
    public static boolean CheckTrung_NhanVien(String maNV){
        NhanVien nv = null;
         try (Connection con = JDBC.getConnection();
                PreparedStatement stm = con.prepareStatement(CHECKTRUNG_MANV)){
            stm.setString(1, maNV);
            ResultSet rs = stm.executeQuery();
             while (rs.next()) {                 
                 nv = new NhanVien(rs.getString(1));
             }
        } catch (Exception e) {
            e.printStackTrace();
        }
         if(nv != null){
             JOptionPane.showMessageDialog(null, "Mã nhân viên đã tồn tại mời bạn nhập mã khác.");
             return true;
         }
         return false;
    }
//    public static void main(String[] args) {
//        System.out.println(search_NhanVien("NoPT"));
//    }
}
