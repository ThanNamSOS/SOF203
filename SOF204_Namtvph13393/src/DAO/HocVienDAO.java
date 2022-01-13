package DAO;

import Model.HocVien;
import Model.KhoaHoc;
import Model.NguoiHoc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class HocVienDAO {
    private static String SELECT_ALL_HOCVIEN = "SELECT * FROM HocVien";
    private static String SELECT_HOCVIEN_BYmaHV = "SELECT * FROM HocVien WHERE MaHV = ?";
    private static String UPDATE_HOCVIEN = "UPDATE HocVien set MaKH = ?, MaNH = ?, Diem = ? where MaHV = ?";
    private static String DELETE_HOCVIEN = "delete from HocVien where MaHV = ?";
    private static String SELECT_MA_KHOAHOC = "SELECT MaKH FROM KhoaHoc";
    private static String INSERT_HOCVIEN = "INSERT INTO HocVien (MaHV, MaKH, MaNH, Diem) VALUES (?,?,?,?)";
    private static String SELECT_MaNH_FROM_HOCVIEN = "SELECT MaNH FROM NguoiHoc WHERE MaNH = ?";        
            
            
    
    public static List<HocVien> getlstHocVien(){
        List<HocVien> lstHocVien = new ArrayList<>();
        try(Connection con = JDBC.getConnection();
                PreparedStatement stm = con.prepareStatement(SELECT_ALL_HOCVIEN)) {
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                HocVien hv = new HocVien();
                String x = hv.getXepLoai(rs.getDouble(4));
                Double ob = (Double)rs.getObject(4);
                lstHocVien.add(new HocVien(rs.getString(1), rs.getString(2), rs.getString(3),ob,x));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstHocVien;
    }
    
    public static List<KhoaHoc> getMaKH(){
        List<KhoaHoc> lstMaKH= new ArrayList<>();
        try(Connection con = JDBC.getConnection();
                PreparedStatement stm = con.prepareStatement(SELECT_MA_KHOAHOC)) {
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                lstMaKH.add(new KhoaHoc(rs.getString(1)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstMaKH;
    }
    
    public static void addHocVien(HocVien hocVien){
        try(Connection con = JDBC.getConnection();
                PreparedStatement stm = con.prepareStatement(INSERT_HOCVIEN)) {
            stm.setString(1, hocVien.getMaHV());
            stm.setString(2, hocVien.getMaKH());
            stm.setString(3, hocVien.getMaNH());
            stm.setObject(4, hocVien.getDiem());
            if(stm.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "Thêm học viên thành công...");
            }else{
                JOptionPane.showMessageDialog(null, "Thêm học viên không thành công...");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void delete_HocVien(String maHV){
        try(Connection con = JDBC.getConnection();
                PreparedStatement stm = con.prepareStatement(DELETE_HOCVIEN)) {
            stm.setString(1, maHV);
            if(stm.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "Xóa học viên thành công...");
            }else{
                JOptionPane.showMessageDialog(null, "Xóa học viên không thành công...");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void update_HocVien(HocVien hocVien){
        try(Connection con = JDBC.getConnection();
                PreparedStatement stm = con.prepareStatement(UPDATE_HOCVIEN)) {
            stm.setString(1, hocVien.getMaKH());
            stm.setString(2, hocVien.getMaNH());
            stm.setObject(3, hocVien.getDiem());
            stm.setString(4, hocVien.getMaHV());
            if(stm.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "Cập nhật thông tin học viên thành công...");
            }else{
                JOptionPane.showMessageDialog(null, "Cập nhật thông tin học viên không thành công...");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static HocVien search_HocVien(String maHV){
        HocVien hv = null;
        try(Connection con = JDBC.getConnection();
                PreparedStatement stm = con.prepareStatement(SELECT_HOCVIEN_BYmaHV)) {
            stm.setString(1, maHV);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {         
                hv = new HocVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hv;
    }
    
    public static NguoiHoc check_MaNguoiHoc(String maNH){
        NguoiHoc nh = null;
        try(Connection con = JDBC.getConnection();
                PreparedStatement stm = con.prepareStatement(SELECT_MaNH_FROM_HOCVIEN)) {
            stm.setString(1, maNH);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {         
                nh = new NguoiHoc(rs.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nh;
    }
    
    public static void main(String[] args) {
        System.out.println(getlstHocVien().toString());
    }
}
