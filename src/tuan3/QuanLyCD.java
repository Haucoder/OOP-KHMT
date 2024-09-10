package tuan3;

import java.util.Scanner;
import java.util.Arrays;

public class QuanLyCD {
    private CD[] danhSachCD;
    private int soLuongCD;

    public QuanLyCD(int kichThuoc) {
        danhSachCD = new CD[kichThuoc];
        soLuongCD = 0;
    }

    // Thêm 1 CD vào danh sách nếu mã không trùng và còn chỗ
    public boolean themCD(CD cd) {
        if (soLuongCD < danhSachCD.length) {
            for (int i = 0; i < soLuongCD; i++) {
                if (danhSachCD[i].getMaCD() == cd.getMaCD()) {
                    return false;  // Trùng mã CD
                }
            }
            danhSachCD[soLuongCD] = cd;
            soLuongCD++;
            return true;  // Thêm thành công
        }
        return false;  // Mảng đầy
    }

    // Tính tổng số CD
    public int tinhSoLuongCD() {
        return soLuongCD;
    }

    // Tính tổng giá thành của các CD
    public double tinhTongGiaThanh() {
        double tong = 0;
        for (int i = 0; i < soLuongCD; i++) {
            tong += danhSachCD[i].getGiaThanh();
        }
        return tong;
    }

    // Sắp xếp danh sách giảm dần theo giá thành
    public void sapXepTheoGiaThanhGiamDan() {
        Arrays.sort(danhSachCD, 0, soLuongCD, (cd1, cd2) -> Double.compare(cd2.getGiaThanh(), cd1.getGiaThanh()));
    }

    // Sắp xếp danh sách tăng dần theo tựa CD
    public void sapXepTheoTuaCDTangDan() {
        Arrays.sort(danhSachCD, 0, soLuongCD, (cd1, cd2) -> cd1.getTuaCD().compareTo(cd2.getTuaCD()));
    }

    // Xuất toàn bộ danh sách CD
    public void xuatDanhSachCD() {
        for (int i = 0; i < soLuongCD; i++) {
            System.out.println(danhSachCD[i]);
        }
    }
}

