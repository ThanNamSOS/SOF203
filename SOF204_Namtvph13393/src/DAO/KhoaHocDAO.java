package DAO;

import Model.ChuyenDe;
import Model.KhoaHoc;
import Model.NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class KhoaHocDAO {
    private static String SELECT_ALL_KHOAHOC = "SELECT [MaKH], [MaCD], [HocPhi], [ThoiLuong],[NgayKG], [GhiChu], [MaNV], [NgayTao] FROM KhoaHoc";
    private static String ADD_KHOAHOC_SQL = "INSERT INTO [dbo].[KhoaHoc] ([MaKH], [MaCD], [HocPhi], [ThoiLuong], [NgayKG], [GhiChu], [MaNV], [NgayTao]) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static String UPDATE_KHOAHOC_SQL = "UPDATE  [dbo].[KhoaHoc] SET  [MaCD] = ?, [HocPhi] = ?, [ThoiLuong] = ?, [NgayKG] = ?, [GhiChu] = ?, [MaNV] = ?, [NgayTao] = ?  WHERE [MaKH] = ?";
    private static String DELETE_KHOAHOC_SQL = "delete from [KhoaHoc] where [MaKH] = ?";
    private static String SELECT_ALL_MA_CHUYENDE =   "SELECT MaCD FROM ChuyenDe" ;
    private static String CheckTRUNG_KHOAHOC =   "SELECT MaKH FROM KhoaHoc WHERE MaKH = ?" ;
      private static String CHECKTRUNG_MANV = "SELECT MaNV FROM NhanVien WHERE MaNV = ?";      
            
            
    public static List<KhoaHoc> getListKhoaHoc(){
        List<KhoaHoc> lstKhoaHoc = new ArrayList<KhoaHoc>();
        try (Connection con = JDBC.getConnection();
                PreparedStatement stm = con.prepareStatement(SELECT_ALL_KHOAHOC)){
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {  
                NhanVien nv = NhanVienDao.getNhanVien(rs.getString(7));
                lstKhoaHoc.add(new KhoaHoc(rs.getString(1), 
                        rs.getString(2), 
                        rs.getFloat(3), 
                        rs.getInt(4), 
                        rs.getDate(5), 
                        rs.getString(6), 
                        nv, 
                        rs.getDate(8)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstKhoaHoc;
    }
    
    
    public static List<ChuyenDe> getListMaChuyenDe(){
        List<ChuyenDe> lstMaChuyenDe = new ArrayList<ChuyenDe>();
        try (Connection con = JDBC.getConnection();
                PreparedStatement stm = con.prepareStatement(SELECT_ALL_MA_CHUYENDE)){
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {  
                lstMaChuyenDe.add(new ChuyenDe(rs.getString(1)));
            }
        } catch (Exception e) {
        }
        return lstMaChuyenDe;
    }
    
    public static void addKhoaHoc(KhoaHoc khoaHoc){
        try (Connection con = JDBC.getConnection();
                PreparedStatement stm = con.prepareStatement(ADD_KHOAHOC_SQL)){
            stm.setString(1, khoaHoc.getMaKH());
            stm.setString(2, khoaHoc.getMaCD());
            stm.setFloat(3, khoaHoc.getHocPhi());
            stm.setInt(4, khoaHoc.getThoiLuong());
            stm.setDate(5, new java.sql.Date(khoaHoc.getNgayKhaiGiang().getTime()));
            stm.setString(6, khoaHoc.getGhiChu());
            stm.setString(7, khoaHoc.getNhanVien().getMaNV());
            stm.setDate(8,new java.sql.Date(khoaHoc.getNgayTao().getTime()));
            if(stm.executeUpdate() >0){
                JOptionPane.showMessageDialog(null, "Thêm khóa học thành công");
            }else{
                JOptionPane.showMessageDialog(null, "Thêm khóa học không thành công");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void updateKhoaHoc(KhoaHoc khoaHoc){
        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
        try (Connection con = JDBC.getConnection();
                PreparedStatement stm = con.prepareStatement(UPDATE_KHOAHOC_SQL)){
            stm.setString(1, khoaHoc.getMaCD());
            stm.setFloat(2, khoaHoc.getHocPhi());
            stm.setInt(3, khoaHoc.getThoiLuong());
            stm.setDate(4, new java.sql.Date(khoaHoc.getNgayKhaiGiang().getTime()));
            stm.setString(5, khoaHoc.getGhiChu());
            stm.setString(6, khoaHoc.getNhanVien().getMaNV());
            stm.setDate(7,new java.sql.Date(khoaHoc.getNgayTao().getTime()));
            stm.setString(8, khoaHoc.getMaKH());
            if(stm.executeUpdate() >0){
                JOptionPane.showMessageDialog(null, "Sửa thông tin khóa học thành công");
            }else{
                JOptionPane.showMessageDialog(null, "Sửa thông tin khóa học không thành công hoặc mã khóa học cần sửa sai...");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void delete_KhoaHoc(String maKH){
        try (Connection con = JDBC.getConnection();
                PreparedStatement stm = con.prepareStatement(DELETE_KHOAHOC_SQL)){
            stm.setString(1, maKH);
            if(stm.executeUpdate() >0){
                JOptionPane.showMessageDialog(null, "Xóa khóa học thành công");
            }else{
                JOptionPane.showMessageDialog(null, "Xóa khóa học không thành công");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
   public static boolean CheckTrung_KhoaHoc_Insert(String maKH,JLabel lbl){
       KhoaHoc khoahoc = null;
        try (Connection con = JDBC.getConnection();
                PreparedStatement stm = con.prepareStatement(CheckTRUNG_KHOAHOC)){
            stm.setString(1, maKH);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {   
                khoahoc = new KhoaHoc(rs.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
        if(khoahoc != null){
            lbl.setText("* Mã khóa học đã tồn tại");
            return true;
        }
        return false;
    }
   public static boolean CheckTrung_NhanVien_Insert(String maNV,JLabel lbl){
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
         if(nv == null){
             lbl.setText("Mã nhân viên không tồn tại trên hệ thống");
             return true;
         }
         return false;
    }
   
   public static boolean CheckTrung_KhoaHoc_Update(String maKH,JLabel lbl){
       KhoaHoc khoahoc = null;
        try (Connection con = JDBC.getConnection();
                PreparedStatement stm = con.prepareStatement(CheckTRUNG_KHOAHOC)){
            stm.setString(1, maKH);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {   
                khoahoc = new KhoaHoc(rs.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
        if(khoahoc == null){
            lbl.setText("* Mã khóa học không tồn tại trên hệ thống");
            return true;
        }
        return false;
    }
   
   
   
}
