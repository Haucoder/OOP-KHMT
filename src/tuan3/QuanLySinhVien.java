package tuan3;
import java.util.Scanner;
import java.util.Arrays;

public class QuanLySinhVien {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số lượng sinh viên: ");
        int N = scanner.nextInt();
        scanner.nextLine();  // Xóa bộ đệm

        SinhVien[] danhSachSV = new SinhVien[N];

        // Nhập thông tin sinh viên
        for (int i = 0; i < N; i++) {
            System.out.println("Nhập thông tin sinh viên thứ " + (i + 1) + ":");

            System.out.print("Mã sinh viên: ");
            int maSinhVien = scanner.nextInt();
            scanner.nextLine();  // Xóa bộ đệm

            System.out.print("Họ tên: ");
            String hoTen = scanner.nextLine();

            System.out.print("Địa chỉ: ");
            String diaChi = scanner.nextLine();

            System.out.print("Số điện thoại (7 chữ số): ");
            String soDienThoai = scanner.nextLine();

            // Khởi tạo sinh viên và thêm vào danh sách
            danhSachSV[i] = new SinhVien(maSinhVien, hoTen, diaChi, soDienThoai);
        }

        // Sắp xếp danh sách sinh viên theo mã sinh viên
        Arrays.sort(danhSachSV, (sv1, sv2) -> Integer.compare(sv1.getMaSinhVien(), sv2.getMaSinhVien()));

        // Xuất danh sách sinh viên đã sắp xếp
        System.out.println("Danh sách sinh viên sau khi sắp xếp theo mã sinh viên:");
        for (SinhVien sv : danhSachSV) {
            System.out.println(sv);
        }

        scanner.close();
    }
}
