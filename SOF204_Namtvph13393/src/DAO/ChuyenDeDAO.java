package DAO;

import Model.ChuyenDe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ChuyenDeDAO{
    private final static String SELECT_ALL_CHUYENDE = "select [MaCD], [TenCD], [HocPhi], [ThoiLuong],[Hinh],  [MoTa] from ChuyenDe";
     private final static String INSERT_CHUYENDE = "INSERT [dbo].[ChuyenDe] ([MaCD], [TenCD], [HocPhi], [ThoiLuong], [Hinh],[MoTa]) VALUES (?,?, ?,?, ?,?)";
     private final static String UPDATE_CHUYENDE = "{CALL update_ChuyenDe(?,?,?,?,?,?)}";
     private final static String DELETE_CHUYENDE = "{CALL delete_ChuyenDe(?)}";
     private final static String SEARCH_CHUYENDE = "select [MaCD], [TenCD], [HocPhi], [ThoiLuong],[Hinh], [MoTa] from ChuyenDe WHERE MaCD = ?";
     private final static String SELECT_CHUYENDE_MACD = "SELECT MaCD FROM ChuyenDe where MaCD = ?";

  
    public static List<ChuyenDe> getListChuyenDe(){
        List<ChuyenDe> listChuyenDe = new ArrayList<>();
        try (Connection con = JDBC.getConnection();
                PreparedStatement stm = con.prepareStatement(SELECT_ALL_CHUYENDE)){
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                listChuyenDe.add(new ChuyenDe(rs.getString(1), rs.getString(2), rs.getFloat(3), rs.getInt(4),rs.getString(5), rs.getString(6)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listChuyenDe;
    }
    
    public static void insert_ChuyenDe(ChuyenDe chuyenDe){
        try(Connection con = JDBC.getConnection();
                PreparedStatement stm = con.prepareStatement(INSERT_CHUYENDE)) {
            stm.setString(1, chuyenDe.getMaCD());
            stm.setString(2, chuyenDe.getTenCD());
            stm.setFloat(3, chuyenDe.getHocPhi());
            stm.setInt(4, chuyenDe.getThoiLuong());
            stm.setString(5, chuyenDe.getImg());
            stm.setString(6, chuyenDe.getMoTa());
            if(stm.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "Thêm chuyên đề thành công");
            }else{
                 JOptionPane.showMessageDialog(null, "Thêm chuyên đề không thành công");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void update_ChuyenDe(ChuyenDe chuyenDe){
        try(Connection con = JDBC.getConnection();
                PreparedStatement stm = con.prepareStatement(UPDATE_CHUYENDE)) {
            stm.setString(1, chuyenDe.getTenCD());
            stm.setFloat(2, chuyenDe.getHocPhi());
            stm.setInt(3, chuyenDe.getThoiLuong());
            stm.setString(4, chuyenDe.getMoTa());
            stm.setString(5, chuyenDe.getImg());
            stm.setString(6, chuyenDe.getMaCD());
            if(stm.executeUpdate() > 0){
                JOptionPane.showMessageDialog(null, "Sửa chuyên đề thành công");
            }else{
                 JOptionPane.showMessageDialog(null, "Sửa chuyên đề không thành công");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void delete_ChuyenDe(String maCD){
        try(Connection con = JDBC.getConnection();
                PreparedStatement stm = con.prepareStatement(DELETE_CHUYENDE)) {
            stm.setString(1, maCD);
            if(stm.executeUpdate() >= 0){
                JOptionPane.showMessageDialog(null, "Xóa chuyên đề thành công");
            }else{
                 JOptionPane.showMessageDialog(null, "Xóa chuyên đề không thành công");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static boolean insert_ChuyenDe_byMaCD(String maCD, JLabel jlab){
        ChuyenDe chuyenDe = null;
        try(Connection con = JDBC.getConnection();
                PreparedStatement stm = con.prepareStatement(SELECT_CHUYENDE_MACD)) {
            stm.setString(1, maCD);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                chuyenDe = new ChuyenDe(rs.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(chuyenDe != null){
            jlab.setText("Mã chuyên đề đã tồn tại");
            return true;
        }
        jlab.setText("");
        return false;
    }
    public static boolean update_ChuyenDe_byMaCD(String maCD, JLabel jlab){
        ChuyenDe chuyenDe = null;
        try(Connection con = JDBC.getConnection();
                PreparedStatement stm = con.prepareStatement(SELECT_CHUYENDE_MACD)) {
            stm.setString(1, maCD);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                chuyenDe = new ChuyenDe(rs.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(chuyenDe == null){
            jlab.setText("Mã chuyên đề không tồn tại trên hệ thống");
            return true;
        }
        jlab.setText("");
        return false;
    }
    public static boolean insert_ChuyenDe_byMaCD_delete(String maCD, JLabel jlab){
        ChuyenDe chuyenDe = null;
        try(Connection con = JDBC.getConnection();
                PreparedStatement stm = con.prepareStatement(SELECT_CHUYENDE_MACD)) {
            stm.setString(1, maCD);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                chuyenDe = new ChuyenDe(rs.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(chuyenDe == null){
            jlab.setText("Mã chuyên đề không tồn tại trên hệ thống");
            return true;
        }
        jlab.setText("");
        return false;
    }
    
    public static ChuyenDe searchChuyenDe(String maCD){
        ChuyenDe chuyenDe = null;
        try(Connection con = JDBC.getConnection();
                PreparedStatement stm = con.prepareStatement(SEARCH_CHUYENDE)) {
            stm.setString(1, maCD);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                chuyenDe = new ChuyenDe(rs.getString(1), rs.getString(2), rs.getFloat(3), rs.getInt(4), rs.getString(5),rs.getString(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return chuyenDe;
    }

    
}
