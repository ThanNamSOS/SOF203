package DAO;

import Model.HocVien;
import Model.NguoiHoc;
import com.toedter.calendar.JDateChooser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Util {

    private static String SELECT_MaHV_FROM_HOCVIEN = "SELECT MaHV FROM HocVien WHERE MaHV = ?";

    public static boolean checkGmail(JTextField txt) {
        if (!txt.getText().matches(".+@.+\\..+")) {
            txt.requestFocus();
            JOptionPane.showMessageDialog(null, "Mail sai định dạng mời nhập lại");
            return true;
        }
        return false;
    }

    public static boolean checkGmail2(JTextField txt, JLabel lbl) {
        if (!txt.getText().matches(".+@.+\\..+")) {
            txt.requestFocus();
            lbl.setText("EMail sai định dạng mời nhập lại");
            return true;
        } else {
            lbl.setText("");
        }
        return false;
    }

    public static boolean checkRongLbl(String data, JLabel jlb, String mss) {
        if (data.trim().isEmpty()) {
            jlb.setText(mss);
            return true;
        } else {
            jlb.setText("");
        }
        return false;
    }

    public static boolean checkRongJdate(JDateChooser data, JLabel lbl, String mss) {
        if (data.getDate() == null) {
            lbl.setText(mss);
            return true;
        } else {
            lbl.setText("");
        }
        return false;
    }

    public static boolean checkKhoangSo(String data, JLabel lbl, String mss) {
        try {
            float diem = Float.parseFloat(data);
            if (diem <= 0) {
                lbl.setText("* Thời lượng phải lớn hơn 0");
                lbl.setText(mss);
                return true;
            }
        } catch (Exception e) {
            lbl.setText("* Gía trị phải phải là số");
            return true;
        }
        return false;
    }

    public static boolean checkSoLBL(String data, JLabel lbl) {
        try {
            float diem = Float.parseFloat(data);
            if (diem < 0 || diem > 10) {
                lbl.setText("* điểm 0 - 10");
                return true;
            }
        } catch (Exception e) {
            lbl.setText("* Gía trị phải là số");
            return true;
        }
        return false;
    }

    public static boolean checkThoiLuongHocPhi(String data, JLabel lbl) {
        try {
            float thoiLuong = Float.parseFloat(data);
            if (thoiLuong < 0 ) {
                lbl.setText("* Gía trị phải lớn hơn 0");
                return true;
            }
        } catch (Exception e) {
            lbl.setText("* Gía trị phải là số");
            return true;
        }
        return false;
    }

    public static boolean checkDiemLBL(String data, JLabel lbl) {
        try {
            float diem = Float.parseFloat(data);
            if (data == null) {

                return false;
            } else {
                try {
                    if (diem < 0) {
                        lbl.setText("Giá trị phải lớn hơn 0");
                        return true;
                    }
                } catch (Exception e) {
                    lbl.setText("Giá trị phải là số");
                    return true;
                }
            }
        } catch (Exception e) {

        }
        return false;
    }

    public static boolean checkSizePass(String data, JLabel lbl) {
        try {
            int sizze = data.length();
            if (sizze < 3) {
                lbl.setText("* Mật khẩu phải trên 3 kí tự");
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
        return false;
    }

    public static boolean checkHoTenNhanVien(String ch, JLabel lbl) {
        try {
            for (int i = 0; i < ch.length(); i++) {
                if ((ch.charAt(i) >= 'a' && ch.charAt(i) <= 'z') || (ch.charAt(i) >= 'A' && ch.charAt(i) <= 'Z')) {
                    return false;
                } else {
                    lbl.setText("* Chỉ chứa alphabet và ký tự trắng");
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
        return false;
    }

    public static boolean checkMaNguoiHoc(String ch, JLabel lbl) {
        try {
            int sizze = ch.length();
            if (sizze < 7 || sizze > 7) {
                lbl.setText("* Mã người học Đúng 7 ký tự");
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
        return false;
    }

    public static boolean checkNgaySinhNguoiHoc(JDateChooser date, JLabel lbl) {
        try {
            Date dt = date.getDate();
            Calendar cal = Calendar.getInstance();
            cal.setTime(dt);
            if (cal.get(Calendar.YEAR) > 2005) {
                lbl.setText("Tuổi phải trên 16");
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
        return false;
    }

    public static boolean checkSizeMaCD(String data, JLabel lbl) {
        try {
            int sizze = data.length();
            if (sizze > 5 || sizze < 5) {
                lbl.setText("* Mã chuyên đề chỉ được 5 kí tự");
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
        return false;
    }

    public static boolean checkRongHinh(JLabel lbla, JLabel lbl) {
        try {
            if (lbla.getIcon() == null) {
                lbl.setText("* Chọn hình ảnh chuyên đề");
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
        return false;
    }
}
