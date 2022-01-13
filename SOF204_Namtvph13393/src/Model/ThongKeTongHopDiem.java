package Model;

public class ThongKeTongHopDiem {
    private String TenCD;
    private int soLuongKH;
    private float diemMax;
    private float diemMin;
    private float diemTB;

    public ThongKeTongHopDiem() {
    }

    public ThongKeTongHopDiem(String TenCD, int soLuongKH, float diemMax, float diemMin, float diemTB) {
        this.TenCD = TenCD;
        this.soLuongKH = soLuongKH;
        this.diemMax = diemMax;
        this.diemMin = diemMin;
        this.diemTB = diemTB;
    }

    public String getTenCD() {
        return TenCD;
    }

    public void setTenCD(String TenCD) {
        this.TenCD = TenCD;
    }

    public int getSoLuongKH() {
        return soLuongKH;
    }

    public void setSoLuongKH(int soLuongKH) {
        this.soLuongKH = soLuongKH;
    }

    public float getDiemMax() {
        return diemMax;
    }

    public void setDiemMax(float diemMax) {
        this.diemMax = diemMax;
    }

    public float getDiemMin() {
        return diemMin;
    }

    public void setDiemMin(float diemMin) {
        this.diemMin = diemMin;
    }

    public float getDiemTB() {
        return diemTB;
    }

    public void setDiemTB(float diemTB) {
        this.diemTB = diemTB;
    }

    @Override
    public String toString() {
        return "ThongKeTongHopDiem{" + "TenCD=" + TenCD + ", soLuongKH=" + soLuongKH + ", diemMax=" + diemMax + ", diemMin=" + diemMin + ", diemTB=" + diemTB + '}';
    }
    
    
}
