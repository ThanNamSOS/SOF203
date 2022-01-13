package Model;

public class ChuyenDe {
//    [MaCD], [TenCD], [HocPhi], [ThoiLuong], [Hinh], [MoTa]
    private String maCD;
    private String tenCD;
    private float hocPhi;
    private int thoiLuong;
    private String img;
    private String moTa;

    public ChuyenDe() {
    }

    public ChuyenDe(String maCD, String tenCD, float hocPhi, int thoiLuong, String img, String moTa) {
        this.maCD = maCD;
        this.tenCD = tenCD;
        this.hocPhi = hocPhi;
        this.thoiLuong = thoiLuong;
        this.img = img;
        this.moTa = moTa;
    }

    public ChuyenDe(String maCD) {
        this.maCD = maCD;
    }
    
    public String getMaCD() {
        return maCD;
    }

    public void setMaCD(String maCD) {
        this.maCD = maCD;
    }

    public String getTenCD() {
        return tenCD;
    }

    public void setTenCD(String tenCD) {
        this.tenCD = tenCD;
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



    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return  maCD;
    }
    
    
}
