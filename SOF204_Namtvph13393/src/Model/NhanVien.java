package Model;

public class NhanVien {
    private String maNV;
    private String matKhau;
    private String hoTen;
    private boolean vaiTro;

    public NhanVien() {
    }

    public NhanVien(String maNV, String matKhau, String hoTen, boolean vaiTro) {
        this.maNV = maNV;
        this.matKhau = matKhau;
        this.hoTen = hoTen;
        this.vaiTro = vaiTro;
    }

    public NhanVien(String maNV,String hoTen) {
        this.maNV = maNV;
        this.hoTen = hoTen;
    }
    public NhanVien(String maNV) {
        this.maNV = maNV;
    }
    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public boolean getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(boolean vaiTro) {
        this.vaiTro = vaiTro;
    }

    @Override
    public String toString() {
        return "NhanVien{" + "maNV=" + maNV + ", matKhau=" + matKhau + ", hoTen=" + hoTen + ", vaiTro=" + vaiTro + '}';
    }
}
