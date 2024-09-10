package tuan2;

import java.util.Scanner;

public class VehicleTaxMannager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Vehicel[] vehicles = new Vehicel[3];
        int choice;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Nhập thông tin và tạo các đối tượng xe");
            System.out.println("2. Xuất bảng kê khai tiền thuế trước bạ của các xe");
            System.out.println("3. Thoát");
            System.out.print("Chọn một tùy chọn (1-3): ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Xóa bộ đệm

            switch (choice) {
                case 1:
                    for (int i = 0; i < vehicles.length; i++) {
                        System.out.println("\nNhập thông tin cho xe " + (i + 1) + ":");
                        System.out.print("Trị giá xe: ");
                        double price = scanner.nextDouble();
                        System.out.print("Dung tích xylanh: ");
                        int cylinderCapacity = scanner.nextInt();
                        scanner.nextLine(); // Xóa bộ đệm

                        vehicles[i] = new Vehicel(price, cylinderCapacity);
                    }
                    break;

                case 2:
                    System.out.println("\nBảng kê khai tiền thuế trước bạ của các xe:");
                    System.out.println(String.format("%-15s %-15s %-15s", "Trị giá xe", "Dung tích xylanh", "Tiền thuế"));
                    for (Vehicel vehicle : vehicles) {
                        if (vehicle != null) {
                            System.out.println(vehicle.toString());
}
                    }
                    break;

                case 3:
                    System.out.println("Thoát chương trình.");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại.");
            }
        } while (choice != 3);

        scanner.close();
    }
}

