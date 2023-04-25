/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyThucPham;

/**
 *
 * @author MYPC
 */

import javax.swing.*;
import java.awt.event.*;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;



public class Login extends JFrame implements ActionListener{
    static Scanner sc = new Scanner(System.in);
    JLabel l1, l2;
    JTextField tf1;
    JPasswordField tf2;
    JButton btn1;
    
    JFrame Menu;
    
    
    
    
    Login() {
//        banner Right
            int setDefaultRightX = 420;
            int setDefaultRightY = 145;
//        banner Left

        
        
        l1 = new JLabel("Tên đăng nhập: ");
        l1.setBounds(setDefaultRightX-100, setDefaultRightY+50, 100, 30);
        l2 = new JLabel("Mật khẩu: ");
        l2.setBounds(setDefaultRightX-100, setDefaultRightY+100, 100, 30);
        tf1 = new JTextField();
   
        tf1.setBounds(setDefaultRightX, setDefaultRightY+50, 250, 30);
        tf2 = new JPasswordField();
        tf2.setBounds(setDefaultRightX, setDefaultRightY+100, 250, 30);
        btn1 = new JButton("Đăng nhập");
        btn1.setBounds(setDefaultRightX, setDefaultRightY+150, 250, 50);
        btn1.addActionListener(this);
        add(l1);
        add(tf1);
        add(l2);
        add(tf2);
        add(btn1);
        setSize(750, 577);
        setLayout(null);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
    
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
   
    

    public void actionPerformed(ActionEvent e) {
        String username = tf1.getText();
        String password = tf2.getText();
        if (username.equals("admin") && password.equals("admin")) {
            JOptionPane.showMessageDialog(this, "Đăng nhập thành công");
            dispose();
            init();
            
            
        } else {
            JOptionPane.showMessageDialog(this, "Sai tài khoản hoặc mật khẩu");
        }
    }
    
    public static void SaveDataTat(ArrayList<ThucAnTuoi> tat)
    {
       try {
            FileOutputStream fos = new FileOutputStream("data.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(tat);
            oos.close();
//            fos.close();
            System.out.println("Luu tru du lieu thanh cong.");
        } catch (IOException e) {
            e.printStackTrace();
        }
         
    }
    
      public static void LoadDataTat()
    {  
         try {
                     FileInputStream fis = new FileInputStream("data.dat");
                     ObjectInputStream ois = new ObjectInputStream(fis);
                     ArrayList<ThucAnTuoi> tatLoad = (ArrayList<ThucAnTuoi>) ois.readObject();
                     ois.close();
                     fis.close();

                     // hiển thị kết quả
                     for (int i = 0; i < tatLoad.size(); i++) {
                         tatLoad.get(i).kiemTraHSD();
                         System.out.println(tatLoad.get(i).toString());
                         System.out.println();
                     }
                 } catch (IOException | ClassNotFoundException e) {
                     e.printStackTrace();
                 }
    }
    
      public static void Menu()
      {

        ArrayList<ThucAnTuoi> tat = new ArrayList<>();
        ArrayList<ThucAnDaiNgay> tadn = new ArrayList<>();    
        int n = 0;
        int _choice = 0;
        boolean state = true;
        String idCanTim;
        String idCanXoa;
        
                        
//            Database loai1
            ThucAnTuoi demo = new ThucAnTuoi();
            demo.setIdThucAn("A01");
            demo.setTenThucAn("A01");
            demo.setSoLuong(3);
            demo.setGiaTien(100000.0);
            demo.setNSX(2023,04,20);
            demo.setHSD(2023,04,21);
            demo.setIdKho("Kho Bien Hoa");
            demo.setIdCtyNhap("Hai San Vung Tau");
            tat.add(demo);
            
//            
            ThucAnTuoi demo2 = new ThucAnTuoi();
            demo2.setIdThucAn("A02");
            demo2.setTenThucAn("A02");
            demo2.setSoLuong(4);
            demo2.setGiaTien(200000.0);
            demo2.setNSX(2023,04,20);
            demo2.setHSD(2023,04,25);
            demo2.setIdKho("Kho Ha Noi");
            demo2.setIdCtyNhap("Hai San Vung Tau");
            tat.add(demo2);
        JFrame menu = new JFrame();

        JButton b = new JButton("Xem");
        b.setBounds(100, 100, 100, 40);
       
        
        JLabel title = new JLabel("SUBACITO");
        title.setBounds(100, 50, 100, 30);
        
        JTextArea mainView = new JTextArea(20, 20);
        mainView.setEditable(false);
        mainView.setBounds(100, 150, 1200, 500);
        mainView.append(Banner()+"\n");
        
        menu.add(title);
        menu.add(b);
        menu.add(mainView);

        menu.setSize(1500, 780);
        menu.setLayout(null);  
        menu.setVisible(true);  
        menu.setResizable(false);
        menu.setLocationRelativeTo(null);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
//          System.out.println(tat.get(1).toString());
        
          b.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  mainView.setText(null);
                  mainView.append(Banner()+"\n");
                  for(int i = 0; i < tat.size(); i++)
                  {
                    tat.get(i).kiemTraHSD();
                    mainView.append(tat.get(i).toString() + "\n");
                  }
              }
          });
        
//        while(state)
//        {
//            System.out.println("1. Nhap thong tin thuc pham!");
//            System.out.println("2. Xuat thong tin thuc pham!");
//            System.out.println("3. Tim thong tin thuc pham ID!");
//            System.out.println("4. Xoa thong tin thuc pham theo ID!");
//            System.out.println("Lua chon cua ban: "); _choice = sc.nextInt();
//            
//            
//            switch(_choice)
//            {
//                case 1:
//                    int _loaiTP = 0;
//                    System.out.println("Nhap so luong thuc pham: "); n = sc.nextInt();
//                    for(int i = 0; i < n; i++)
//                    {
//                        System.out.println("Thong tin thuc pham thu " + (i+1));
//                        System.out.println("1. Thuc an tuoi!");
//                        System.out.println("2. Thuc an dai ngay!");
//                        _loaiTP = sc.nextInt();
//                         if(_loaiTP == 1)
//                        {
//                            ThucAnTuoi Tat = new ThucAnTuoi();
//                            Tat.input();
//                            tat.add(Tat);
//                        }
////                         if(_loaiTP == 2)
////                        {
////                            ThucAnDaiNgay Tadn = new ThucAnDaiNgay();
////                            Tadn.input();
////                            tadn.add(Tadn);
////                        }
//                    
//                    }
//                    SaveDataTat(tat);
//                    break;
//                case 2:
//                    System.out.println("---Thong tin---");
//                    Banner();
//                    for (int i = 0; i < tat.size(); i++) {
//                        tat.get(i).kiemTraHSD();
//                        System.out.println(tat.get(i).toString());
//                       }
//    
//                    break;
//                case 3:
//                    
//                    System.out.println("Nhap id can tim: "); sc.nextLine();
//                    idCanTim = sc.nextLine();
//                    System.out.println("---Thong tin---");
//                    Banner();
//                    for (int i = 0; i < tat.size(); i++) {
//                       if(tat.get(i).getIdThucAn().equals(idCanTim)){
//                            System.out.println(tat.get(i).toString());
//                       }
//                    }
//                    break;
//                case 4:
//                    System.out.println("Nhap id can xoa: "); sc.nextLine();
//                    idCanXoa = sc.nextLine();
//                    System.out.println("---Thong tin---");
//                     for (int i = 0; i < tat.size(); i++) {
//                       if(tat.get(i).getIdThucAn().equals(idCanXoa))
//                            tat.remove(i);
//                    }
//                    break;
//                case 5:
//                    Banner();
//                LoadDataTat();
//                    
//            }
//        }
      }
    
   
    public static void init() 
    {
       Menu();        
    }
    
     private static String Banner() {
        return String.format("%15s %30s %30s %30s %30s %30s %30s %30s %30s ", "ID", "Ten Thuc An", "So Luong", "Gia Tien", "NSX" , "HSD", "Trang Thai", "Kho", "Cong Ty");
    }
     
     
     
    public static void main(String[] args) {
        new Login();    
    }
    
}

