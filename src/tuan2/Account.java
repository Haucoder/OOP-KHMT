package tuan2;

import java.text.NumberFormat;
import java.util.Locale;

public class Account {
    // Các thuộc tính
    private long accountNumber;
    private String accountName;
    private double balance;
    
    // Hằng số lãi suất
    private static final double INTEREST_RATE = 0.035;

    // Constructor mặc định
    public Account() {
        this.accountNumber = 0;
        this.accountName = "";
        this.balance = 0.0;
    }

    // Constructor đầy đủ tham số
    public Account(long accountNumber, String accountName, double balance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = balance;
    }
    
    // Constructor với 2 đối số
    public Account(long accountNumber, String accountName) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = 50.0; // Số tiền mặc định là 50
    }

    // Các phương thức get, set
    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Phương thức toString định dạng tiền tệ
    @Override
    public String toString() {
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
        return String.format("Account{accountNumber=%d, accountName='%s', balance=%s}", 
                             accountNumber, accountName, currencyFormat.format(balance));
    }

    // Phương thức nạp tiền
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        } else {
            System.out.println("Số tiền nạp không hợp lệ.");
        }
    }

    // Phương thức rút tiền
    public void withdraw(double amount, double fee) {
        if (amount > 0 && (amount + fee) <= this.balance) {
            this.balance -= (amount + fee);
        } else {
            System.out.println("Số tiền rút không hợp lệ hoặc không đủ số dư.");
        }
    }

    // Phương thức đáo hạn
    public void mature() {
        this.balance += this.balance * INTEREST_RATE;
    }

    // Phương thức chuyển khoản
    public void transfer(Account toAccount, double amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
            toAccount.deposit(amount);
        } else {
            System.out.println("Số tiền chuyển không hợp lệ hoặc không đủ số dư.");
        }
    }

    // Phương thức main để chạy chương trình
    public static void main(String[] args) {
        // Tạo các tài khoản
        Account acc1 = new Account(22674241, "Nguyen Phuoc Hau", 1000.0);
        Account acc2 = new Account(123456, "Nguyen Trung Hieu");

        // Hiển thị thông tin ban đầu của các tài khoản
        System.out.println("Thông tin ban đầu của các tài khoản:");
        System.out.println(acc1);
        System.out.println(acc2);

        // Nạp tiền vào tài khoản acc1
        acc1.deposit(500.0);
        System.out.println("\nSau khi nạp tiền vào tài khoản 22674241:");
        System.out.println(acc1);

        // Rút tiền từ tài khoản acc2
        acc2.withdraw(30.0, 2.0);
        System.out.println("\nSau khi rút tiền từ tài khoản 123456:");
        System.out.println(acc2);

        // Chuyển tiền từ acc1 sang acc2
        acc1.transfer(acc2, 200.0);
        System.out.println("\nSau khi chuyển tiền từ 22674241 sang 123456:");
        System.out.println(acc1);
        System.out.println(acc2);

        // Đáo hạn cho acc1
        acc1.mature();
        System.out.println("\nSau khi đáo hạn cho tài khoản 22674241:");
        System.out.println(acc1);
    }
}


