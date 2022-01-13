package Model;

import java.util.Date;

public class KhoaHoc {
    private String maKH;
    private String maCD;
    private float hocPhi;
    private int thoiLuong;
    private Date ngayKhaiGiang;
    private String ghiChu;
    private NhanVien nhanVien;
    private Date ngayTao;

    public KhoaHoc() {
    }
    public KhoaHoc(String maKH) {
          this.maKH = maKH;
    }
     public KhoaHoc(Date ngayKhaiGiang) {
          this.ngayTao = ngayKhaiGiang;
    }
    
    public KhoaHoc(String maKH, String maCD, float hocPhi, int thoiLuong, Date ngayKhaiGiang, String ghiChu, NhanVien nhanVien, Date ngayTao) {
        this.maKH = maKH;
        this.maCD = maCD;
        this.hocPhi = hocPhi;
        this.thoiLuong = thoiLuong;
        this.ngayKhaiGiang = ngayKhaiGiang;
        this.ghiChu = ghiChu;
        this.nhanVien = nhanVien;
        this.ngayTao = ngayTao;
    }
public int getYear(Date ngayKhaiGiang) {
        return ngayKhaiGiang.getYear();
    }
    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getMaCD() {
        return maCD;
    }

    public void setMaCD(String maCD) {
        this.maCD = maCD;
    }

    public float getHocPhi() {
        return hocPhi;
    }

    public void setHocPhi(float hocPhi) {
        this.hocPhi = hocPhi;
    }

    public int getThoiLuong() {
        return thoiLuong;
    }

    public void setThoiLuong(int thoiLuong) {
        this.thoiLuong = thoiLuong;
    }

    public Date getNgayKhaiGiang() {
        return ngayKhaiGiang;
    }

    public void setNgayKhaiGiang(Date ngayKhaiGiang) {
        this.ngayKhaiGiang = ngayKhaiGiang;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    @Override
    public String toString() {
        return maKH  ;
    }
    public String toStringYear() {
        return ngayKhaiGiang+""  ;
    }
}
