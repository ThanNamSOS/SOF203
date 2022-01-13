package Model;

public class ThongKeBangDiem {
    private String maHV;
    private String hoten;
    private Double diem;
    private String xepLoai;

    public ThongKeBangDiem() {
    }

    public ThongKeBangDiem(String maHV, String hoten, Double diem) {
        this.maHV = maHV;
        this.hoten = hoten;
        this.diem = diem;
        this.xepLoai = xepLoai;
    }

    public String getMaHV() {
        return maHV;
    }

    public void setMaHV(String maHV) {
        this.maHV = maHV;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public Double getDiem() {
        return diem;
    }

    public void setDiem(Double diem) {
        this.diem = diem;
    }

    public String getXepLoai(Double diem) {
         if(diem == null){
            return "chưa đăng kí khóa học nào";
        }else if(diem <5){
            return "Yếu";
        }else if(diem <8){
            return "Khá";
        }else{
            return "Giỏi";
        }
    }

    public void setXepLoai(String xepLoai) {
        this.xepLoai = xepLoai;
    }

    @Override
    public String toString() {
        return "ThongKeBangDiem{" + "maHV=" + maHV + ", hoten=" + hoten + ", diem=" + diem + ", xepLoai=" + xepLoai + '}';
    }
    
    
}
