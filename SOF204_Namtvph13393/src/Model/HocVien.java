package Model;

public class HocVien {

    private String maHV;
    private String maKH;
    private String maNH;
    private Double diem;
    private String xepLoai;

    public HocVien() {
    }

    public HocVien(String maHV) {
        this.maHV = maHV;
    }

    public HocVien(String maHV, String maKH, String maNH, Double diem, String xepLoai) {
        this.maHV = maHV;
        this.maKH = maKH;
        this.maNH = maNH;
        this.diem = diem;
        this.xepLoai = xepLoai;
    }

   
    

    public HocVien(String maHV, String maKH, String maNH, Double diem) {
        this.maHV = maHV;
        this.maKH = maKH;
        this.maNH = maNH;
        this.diem = diem;
    }

    public String getMaHV() {
        return maHV;
    }

    public void setMaHV(String maHV) {
        this.maHV = maHV;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getMaNH() {
        return maNH;
    }

    public void setMaNH(String maNH) {
        this.maNH = maNH;
    }

    public Double getDiem() {
        return diem;
    }

    public void setDiem(Double diem) {
        this.diem = diem;
    }
    
    public String getXepLoai(Double diem) {
        String xl = null;
        if(diem == null){
            xl = "Học viên chưa có điểm";
        }else if (diem <= 5) {
            xl = "Yếu";
        } else if (diem <= 8) {
            xl = "Khá";
        } else {
            xl = "Giỏi";
        }
        return xl;
    }

    public void setXepLoai(String xepLoai) {
        this.xepLoai = xepLoai;
    }

    @Override
    public String toString() {
        return "HocVien{" + "maHV=" + maHV + ", maKH=" + maKH + ", maNH=" + maNH + ", diem=" + diem + ", xepLoai=" + xepLoai + '}'+"\n";
    }

}
