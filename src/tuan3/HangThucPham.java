package tuan3;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class HangThucPham {
    private final String maHang;
    private String tenHang;
    private double donGia;
    private Date ngaySanXuat;
    private Date ngayHetHan;

    // Constructor đầy đủ tham số
    public HangThucPham(String maHang, String tenHang, double donGia, Date ngaySanXuat, Date ngayHetHan) {
        this.maHang = (maHang != null && !maHang.isEmpty()) ? maHang : "Unknown";
        setTenHang(tenHang);
        setDonGia(donGia);
        setNgaySanXuat(ngaySanXuat);
        setNgayHetHan(ngayHetHan);
    }

    // Constructor với mã hàng
    public HangThucPham(String maHang) {
        this(maHang, "Unknown", 0, new Date(), new Date());
    }

    // Getter và Setter
    public String getMaHang() {
        return maHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        if (tenHang != null && !tenHang.isEmpty()) {
            this.tenHang = tenHang;
        } else {
            this.tenHang = "Unknown";
        }
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        if (donGia > 0) {
            this.donGia = donGia;
        } else {
            this.donGia = 0;
        }
    }

    public Date getNgaySanXuat() {
        return ngaySanXuat;
    }

    public void setNgaySanXuat(Date ngaySanXuat) {
        if (ngaySanXuat != null) {
            this.ngaySanXuat = ngaySanXuat;
        } else {
            this.ngaySanXuat = new Date();
        }
    }

    public Date getNgayHetHan() {
        return ngayHetHan;
    }

    public void setNgayHetHan(Date ngayHetHan) {
        if (ngayHetHan != null && ngayHetHan.after(ngaySanXuat)) {
            this.ngayHetHan = ngayHetHan;
        } else {
            this.ngayHetHan = new Date();
        }
    }

    // Phương thức kiểm tra hết hạn
    public boolean daHetHan() {
        Date now = new Date();
        return now.after(this.ngayHetHan);
    }

    // Phương thức toString
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        DecimalFormat df = new DecimalFormat("#,###.00");

        return "Mã hàng: " + maHang + "\n"
             + "Tên hàng: " + tenHang + "\n"
             + "Đơn giá: " + df.format(donGia) + " VND\n"
             + "Ngày sản xuất: " + sdf.format(ngaySanXuat) + "\n"
             + "Ngày hết hạn: " + sdf.format(ngayHetHan) + "\n"
             + "Hết hạn: " + (daHetHan() ? "Có" : "Không");
    }

    // Kiểm nghiệm theo kiểu menu
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HangThucPham hang = null;

        while (true) {
            System.out.println("=== Menu ===");
            System.out.println("1. Tạo hàng thực phẩm mới");
            System.out.println("2. Kiểm tra hàng đã hết hạn");
            System.out.println("3. Hiển thị thông tin hàng thực phẩm");
            System.out.println("4. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Xóa bộ đệm

            switch (choice) {
                case 1:
                    // Nhập thông tin hàng thực phẩm
                    System.out.print("Nhập mã hàng: ");
                    String maHang = scanner.nextLine();

                    System.out.print("Nhập tên hàng: ");
                    String tenHang = scanner.nextLine();

                    System.out.print("Nhập đơn giá: ");
                    double donGia = scanner.nextDouble();
                    scanner.nextLine();  // Xóa bộ đệm

                    System.out.print("Nhập ngày sản xuất (dd/MM/yyyy): ");
                    String ngaySX = scanner.nextLine();

                    System.out.print("Nhập ngày hết hạn (dd/MM/yyyy): ");
                    String ngayHH = scanner.nextLine();

                    try {
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        Date ngaySanXuat = sdf.parse(ngaySX);
                        Date ngayHetHan = sdf.parse(ngayHH);

                        hang = new HangThucPham(maHang, tenHang, donGia, ngaySanXuat, ngayHetHan);
                        System.out.println("Hàng thực phẩm đã được tạo.");
                    } catch (Exception e) {
                        System.out.println("Lỗi định dạng ngày. Vui lòng nhập đúng định dạng dd/MM/yyyy.");
                    }
                    break;

                case 2:
                    if (hang == null) {
                        System.out.println("Bạn chưa tạo hàng thực phẩm.");
                    } else {
                        System.out.println("Hàng thực phẩm đã hết hạn: " + (hang.daHetHan() ? "Có" : "Không"));
                    }
                    break;

                case 3:
                    if (hang == null) {
                        System.out.println("Bạn chưa tạo hàng thực phẩm.");
                    } else {
                        System.out.println(hang);
                    }
                    break;

                case 4:
                    System.out.println("Thoát chương trình.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Chọn sai. Vui lòng chọn lại.");
            }
        }
    }
}

