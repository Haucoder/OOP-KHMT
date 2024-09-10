package tuan2;

import java.util.Scanner;

class Vehicel {
    // Attributes
    private double price;
    private int cylinderCapacity;

    // Constructor mặc định
    public Vehicel() {
        this.price = 0.0;
        this.cylinderCapacity = 0;
    }

    // Constructor với tham số
    public Vehicel(double price, int cylinderCapacity) {
        this.price = price;
        this.cylinderCapacity = cylinderCapacity;
    }

    // Getter và Setter
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCylinderCapacity() {
        return cylinderCapacity;
    }

    public void setCylinderCapacity(int cylinderCapacity) {
        this.cylinderCapacity = cylinderCapacity;
    }

    // Phương thức tính thuế trước bạ
    public double calculateTax() {
        if (cylinderCapacity < 100) {
            return price * 0.01;
        } else if (cylinderCapacity <= 200) {
            return price * 0.03;
        } else {
            return price * 0.05;
        }
    }

    // Phương thức toString
    @Override
    public String toString() {
        return String.format("%-15.2f %-15d %-15.2f", price, cylinderCapacity, calculateTax());
    }
}



