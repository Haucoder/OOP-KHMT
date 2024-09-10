package tuan3;
import java.util.Scanner;
public class QuanLyCDTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QuanLyCD quanLyCD = new QuanLyCD(100);  // Giới hạn danh sách tối đa 100 CD

        int chon;
        do {
            System.out.println("===== Menu =====");
            System.out.println("1. Thêm CD");
            System.out.println("2. Xuất danh sách CD");
            System.out.println("3. Tính tổng số CD");
            System.out.println("4. Tính tổng giá thành");
            System.out.println("5. Sắp xếp giảm dần theo giá thành");
            System.out.println("6. Sắp xếp tăng dần theo tựa CD");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            chon = scanner.nextInt();

            switch (chon) {
                case 1:
                    System.out.print("Nhập mã CD: ");
                    int maCD = scanner.nextInt();
                    scanner.nextLine();  // Xóa bộ đệm

                    System.out.print("Nhập tựa CD: ");
                    String tuaCD = scanner.nextLine();

                    System.out.print("Nhập ca sỹ: ");
                    String caSy = scanner.nextLine();

                    System.out.print("Nhập số bài hát: ");
                    int soBaiHat = scanner.nextInt();

                    System.out.print("Nhập giá thành: ");
                    double giaThanh = scanner.nextDouble();

                    CD cd = new CD(maCD, tuaCD, caSy, soBaiHat, giaThanh);
                    if (quanLyCD.themCD(cd)) {
                        System.out.println("Thêm CD thành công.");
                    } else {
                        System.out.println("Thêm CD thất bại (trùng mã hoặc mảng đầy).");
                    }
                    break;

                case 2:
                    quanLyCD.xuatDanhSachCD();
                    break;

                case 3:
                    System.out.println("Tổng số CD: " + quanLyCD.tinhSoLuongCD());
                    break;

                case 4:
                    System.out.println("Tổng giá thành: " + quanLyCD.tinhTongGiaThanh());
                    break;

                case 5:
                    quanLyCD.sapXepTheoGiaThanhGiamDan();
                    System.out.println("Đã sắp xếp giảm dần theo giá thành.");
                    break;

                case 6:
                    quanLyCD.sapXepTheoTuaCDTangDan();
                    System.out.println("Đã sắp xếp tăng dần theo tựa CD.");
                    break;

                case 0:
                    System.out.println("Thoát chương trình.");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (chon != 0);

        scanner.close();
    }
}

