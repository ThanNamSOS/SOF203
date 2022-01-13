package Model;

public class ThongKeDoanhThu {
    private String tenCD;
    private int year;
    private int soKH;
    private int soHV;
    private float doanhThu;
    private float thapNhat;
    private float caoNhat;
    private float doanhThuTB;

    public ThongKeDoanhThu() {
    }

    public ThongKeDoanhThu(String tenCD, int year, int soKH, int soHV, float doanhThu, float thapNhat, float caoNhat, float doanhThuTB) {
        this.tenCD = tenCD;
        this.year = year;
        this.soKH = soKH;
        this.soHV = soHV;
        this.doanhThu = doanhThu;
        this.thapNhat = thapNhat;
        this.caoNhat = caoNhat;
        this.doanhThuTB = doanhThuTB;
    }

    

    public String getTenCD() {
        return tenCD;
    }

    public void setTenCD(String tenCD) {
        this.tenCD = tenCD;
    }

    public int getSoKH() {
        return soKH;
    }

    public void setSoKH(int soKH) {
        this.soKH = soKH;
    }

    public int getSoHV() {
        return soHV;
    }

    public void setSoHV(int soHV) {
        this.soHV = soHV;
    }

    public float getDoanhThu() {
        return doanhThu;
    }

    public void setDoanhThu(float doanhThu) {
        this.doanhThu = doanhThu;
    }

    public float getThapNhat() {
        return thapNhat;
    }

    public void setThapNhat(float thapNhat) {
        this.thapNhat = thapNhat;
    }

    public float getCaoNhat() {
        return caoNhat;
    }

    public void setCaoNhat(float caoNhat) {
        this.caoNhat = caoNhat;
    }

    public float getDoanhThuTB() {
        return doanhThuTB;
    }

    public void setDoanhThuTB(float doanhThuTB) {
        this.doanhThuTB = doanhThuTB;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "ThongKeDoanhThu{" + "tenCD=" + tenCD + ", year=" + year + ", soKH=" + soKH + ", soHV=" + soHV + ", doanhThu=" + doanhThu + ", thapNhat=" + thapNhat + ", caoNhat=" + caoNhat + ", doanhThuTB=" + doanhThuTB + '}';
    }

   
}
