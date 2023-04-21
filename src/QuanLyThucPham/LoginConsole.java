/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyThucPham;

/**
 *
 * @author MYPC
 */
import java.util.Scanner;

public class LoginConsole {
    
    public static void main(String[] args) {
        
        // Khai báo đối tượng Scanner để đọc dữ liệu từ người dùng
        Scanner scanner = new Scanner(System.in);
        
        // Hiển thị thông báo cho người dùng yêu cầu đăng nhập
        System.out.println("Please enter your username and password:");
        
        // Yêu cầu người dùng nhập tên đăng nhập và mật khẩu
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        
        // Kiểm tra thông tin đăng nhập
        if (username.equals("admin") && password.equals("admin")) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed. Please try again.");
        }
    }
}

