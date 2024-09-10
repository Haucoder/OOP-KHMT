package tuan3;

import java.util.Arrays;
import java.util.Scanner;

public class SinhVien {
    private int maSinhVien;  // Mã sinh viên là số nguyên
    private String hoTen;    // Họ tên
    private String diaChi;   // Địa chỉ
    private String soDienThoai;  // Số điện thoại 7 chữ số

    // Constructor mặc định
    public SinhVien() {
        this.maSinhVien = 0;
        this.hoTen = "";
        this.diaChi = "";
        this.soDienThoai = "";
    }

    // Constructor có tham số
    public SinhVien(int maSinhVien, String hoTen, String diaChi, String soDienThoai) {
        this.maSinhVien = maSinhVien;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        setSoDienThoai(soDienThoai);
    }

    // Getter và Setter
    public int getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(int maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        if (soDienThoai != null && soDienThoai.length() == 7 && soDienThoai.matches("\\d+")) {
            this.soDienThoai = soDienThoai;
        } else {
            this.soDienThoai = "0000000";  // Số điện thoại mặc định
        }
    }

    // Override phương thức toString
    @Override
    public String toString() {
        return "Mã SV: " + maSinhVien + ", Họ tên: " + hoTen + ", Địa chỉ: " + diaChi + ", Số ĐT: " + soDienThoai;
    }
}

