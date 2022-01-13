package DAO;

import Model.KhoaHoc;
import Model.NguoiHoc;
import Model.ThongKeBangDiem;
import Model.ThongKeDoanhThu;
import Model.ThongKeSLNguoiHoc;
import Model.ThongKeTongHopDiem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ThongKeDao {
    private final static String INSERT_NGUOIHOC = "SELECT YEAR(NgayDK)as nam, COUNT( MaNH) AS Soluong,min(NgayDK) as ngaydauten, MAX(NgayDK)as ngaycuoi FROM NguoiHoc GROUP BY YEAR(NgayDK);";
    private final static String INSERT_BANGDIEM = " select NguoiHoc.MaNH,HoTen,Diem from NguoiHoc join HocVien on HocVien.MaNH = NguoiHoc.MaNH";
    private final static String SELECT_BANGDIEM_MaKH = "{CALL SELECT_MAkh(?)}";
    private final static String SELECT_TONGHOP_BANGDIEM = "exec SELECT_TongHopDiem";
    private final static String SELECT_TONGHOP_DOANHTHU = "exec SELECT_TK_DoanhThu";
    private final static String SELECT_YEAR_DOANHTHU = "select distinct YEAR(KhoaHoc.NgayKG) from KhoaHoc";
            
            
            
    public static List<ThongKeSLNguoiHoc> getListSL_NguoiHoc(){
        List<ThongKeSLNguoiHoc> listNguoiHoc = new ArrayList<>();
        try (Connection con = JDBC.getConnection();
                PreparedStatement stm = con.prepareStatement(INSERT_NGUOIHOC)){
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {                
                listNguoiHoc.add(new ThongKeSLNguoiHoc(rs.getInt(1),rs.getInt(2), rs.getDate(3), rs.getDate(4)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNguoiHoc;
    }
     public static List<ThongKeBangDiem> getListBangDiem(){
        List<ThongKeBangDiem> listBangDiem = new ArrayList<>();
        try (Connection con = JDBC.getConnection();
                PreparedStatement stm = con.prepareStatement(INSERT_BANGDIEM)){
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {  
                listBangDiem.add(new ThongKeBangDiem(rs.getString(1), rs.getString(2), (Double) rs.getObject(3)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listBangDiem;
    }
     
     public static List<ThongKeBangDiem> getListBangDiem_MaKH(KhoaHoc khoaHoc){
        List<ThongKeBangDiem> listBangDiem_MaKH = new ArrayList<>();
        try (Connection con = JDBC.getConnection();
                PreparedStatement stm = con.prepareStatement(SELECT_BANGDIEM_MaKH)){
            stm.setString(1, khoaHoc.getMaKH());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {  
                listBangDiem_MaKH.add(new ThongKeBangDiem(rs.getString(1), rs.getString(2), (Double) rs.getObject(3)));
            }
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return listBangDiem_MaKH;
    }
     
     
    public static List<ThongKeTongHopDiem> getListTongHopDiem(){
        List<ThongKeTongHopDiem> listBangDiem_TongHopDiem = new ArrayList<>();
        try (Connection con = JDBC.getConnection();
                PreparedStatement stm = con.prepareStatement(SELECT_TONGHOP_BANGDIEM)){
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {  
                listBangDiem_TongHopDiem.add(new ThongKeTongHopDiem(rs.getString(1), rs.getInt(2), rs.getFloat(3), rs.getFloat(4), rs.getFloat(5)));
            }
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return listBangDiem_TongHopDiem;
    }
   
    public static List<ThongKeDoanhThu> getListThongKeDoanhThu(){
        List<ThongKeDoanhThu> ListThongKeDoanhThu = new ArrayList<>();
        try (Connection con = JDBC.getConnection();
                PreparedStatement stm = con.prepareStatement(SELECT_TONGHOP_DOANHTHU)){
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {  
                ListThongKeDoanhThu.add(new ThongKeDoanhThu(
                        rs.getString(1), 
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4), 
                        rs.getFloat(5), 
                        rs.getFloat(6), 
                        rs.getFloat(7), 
                        rs.getFloat(8)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListThongKeDoanhThu;
    }
    public static List<KhoaHoc>  getListYearNguoiHoc(){
        ArrayList list = new ArrayList<>();
        try (Connection con = JDBC.getConnection();
                PreparedStatement stm = con.prepareStatement(SELECT_YEAR_DOANHTHU)){
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {  
                rs.getInt(1);
                    list.add(rs.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public static void main(String[] args) {
            System.out.println(getListThongKeDoanhThu().toString());
    }
}
