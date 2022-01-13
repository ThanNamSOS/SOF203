package Model;

import java.util.Date;

public class ThongKeSLNguoiHoc {
        private int namDK;
        private int soLuong;
        private Date ngayDauTien;
        private Date ngayCuoiCung;

    public ThongKeSLNguoiHoc(int namDK) {
        this.namDK = namDK;
    }
    public ThongKeSLNguoiHoc() {
     this.namDK = namDK;
    }

    public ThongKeSLNguoiHoc(int namDK, int soLuong, Date ngayDauTien, Date ngayCuoiCung) {
        this.namDK = namDK;
        this.soLuong = soLuong;
        this.ngayDauTien = ngayDauTien;
        this.ngayCuoiCung = ngayCuoiCung;
    }

    public int getNamDK() {
        return namDK;
    }

    public void setNamDK(int namDK) {
        this.namDK = namDK;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Date getNgayDauTien() {
        return ngayDauTien;
    }

    public void setNgayDauTien(Date ngayDauTien) {
        this.ngayDauTien = ngayDauTien;
    }

    public Date getNgayCuoiCung() {
        return ngayCuoiCung;
    }

    public void setNgayCuoiCung(Date ngayCuoiCung) {
        this.ngayCuoiCung = ngayCuoiCung;
    }

    @Override
    public String toString() {
        return namDK+"";
    }
        
}
