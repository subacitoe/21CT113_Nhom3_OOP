/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyThucPham;

/**
 *
 * @author MYPC
 */

import java.awt.Dimension;
import java.awt.FlowLayout;
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
    static ArrayList<ThucAnTuoi> tat = new ArrayList<>();
    static ArrayList<ThucAnDaiNgay> tadn = new ArrayList<>();   
    
    static JTextArea mainView;
    
    
   
    
    
    
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
                        mainView.append(tatLoad.get(i).toString() +"\n");
                     }
                 } catch (IOException | ClassNotFoundException e) {
                     e.printStackTrace();
                 }
    }
    
    
      public static void Menu()
      {
        int n = 0;
        int _choice = 0;
        boolean state = true;
        String idCanTim;
        String idCanXoa;
        
                        
//            Database loai1
//            ThucAnTuoi demo = new ThucAnTuoi();
//            demo.setIdThucAn("A01");
//            demo.setTenThucAn("A01");
//            demo.setSoLuong(3);
//            demo.setGiaTien(100000.0);
//            demo.setNSX(2023,04,20);
//            demo.setHSD(2023,04,21);
//            demo.setIdKho("Kho Bien Hoa");
//            demo.setIdCtyNhap("Hai San Vung Tau");
//            tat.add(demo);
//            
////            
//            ThucAnTuoi demo2 = new ThucAnTuoi();
//            demo2.setIdThucAn("A02");
//            demo2.setTenThucAn("A02");
//            demo2.setSoLuong(4);
//            demo2.setGiaTien(200000.0);
//            demo2.setNSX(2023,04,20);
//            demo2.setHSD(2023,04,25);
//            demo2.setIdKho("Kho Ha Noi");
//            demo2.setIdCtyNhap("Hai San Vung Tau");
//            tat.add(demo2);
//            SaveDataTat(tat);
            
        JFrame menu = new JFrame("Quản Lý Thực Phẩm");
        
        JButton b = new JButton("Thức ăn tươi");
        b.setBounds(1100, 0, 150, 40);
        
        JButton c = new JButton("Thức ăn dài ngày");
        c.setBounds(1290, 0, 150, 40);
        
        JButton addTatBtn = new JButton("Thêm");
        addTatBtn.setBounds(1100, 50, 150, 40);
        
        JButton addTadnBtn = new JButton("Thêm");
        addTadnBtn.setBounds(1290, 50, 150, 40);
        
       
        
        JLabel title = new JLabel("SUBACITO");
//        title.setBounds(100, 50, 100, 30);
        
        mainView = new JTextArea("", 5, 50);
        JScrollPane scrollPane = new JScrollPane(mainView);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(1080, 600));
        mainView.setEditable(false);
//        mainView.setBounds(1000, 150, 1050, 30);
        mainView.append(Banner()+"\n");
        mainView.setLineWrap(true);
        mainView.setWrapStyleWord(true);
        menu.add(title);
        menu.add(b);
        menu.add(c);
        menu.add(addTatBtn);
        menu.add(addTadnBtn);
        menu.add(scrollPane);
        menu.pack();

        
        menu.setSize(1500, 780);
        menu.setLayout(null);  
        menu.setVisible(true);  
        menu.setResizable(false);
        menu.setLocationRelativeTo(null);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
       
        
        
       
        
// Nút thêm TAT
            addTatBtn.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  MenuAddTAT();
              }
          });
// Nút thêm TADN
            addTadnBtn.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  MenuAddTADN();
              }
          });
            
// Nút xem TAT
          b.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  mainView.setText(null);
                  mainView.append(Banner() + "\n");
                  LoadDataTat();
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
////                LoadDataTat();
//                    
//            }
//        }
      }
    public static void MenuAddTAT()
    {
        int VectorX = 10*30;
        int VectorY = 60;
        JFrame MenuAddTat = new JFrame("Thêm thức ăn tươi");
        JButton ConfirmInserted = new JButton("Xác nhận");
        ConfirmInserted.setBounds(VectorX/2, VectorY * 9, 250, 30);
        MenuAddTat.add(ConfirmInserted);
        
        JLabel LabelIdTAT = new JLabel("ID: ");
        LabelIdTAT.setBounds(VectorX/2, VectorY * 1, 250, 30);
        MenuAddTat.add(LabelIdTAT);
        
        JLabel LabelNameTAT = new JLabel("Tên thực phẩm: ");
        LabelNameTAT.setBounds(VectorX/2, VectorY * 2, 250, 30);
        MenuAddTat.add(LabelNameTAT);
        
        JLabel LabelSlTAT = new JLabel("Số lượng: ");
        LabelSlTAT.setBounds(VectorX/2, VectorY * 3, 250, 30);
        MenuAddTat.add(LabelSlTAT);
        
        JLabel LabelCostTAT = new JLabel("Giá: ");
        LabelCostTAT.setBounds(VectorX/2, VectorY * 4, 250, 30);
        MenuAddTat.add(LabelCostTAT);
        
        JLabel LabelNsxTAT = new JLabel("Ngày sản xuất: ");
        LabelNsxTAT.setBounds(VectorX/2, VectorY * 5, 250, 30);
        MenuAddTat.add(LabelNsxTAT);
        
        JLabel LabelHsdTAT = new JLabel("Hạn sử dụng: ");
        LabelHsdTAT.setBounds(VectorX/2, VectorY * 6, 250, 30);
        MenuAddTat.add(LabelHsdTAT);
        
        JLabel LabelKhoTAT = new JLabel("Kho: ");
        LabelKhoTAT.setBounds(VectorX/2, VectorY * 7, 250, 30);
        MenuAddTat.add(LabelKhoTAT);
        
        JLabel LabelCtyTAT = new JLabel("Công ty: ");
        LabelCtyTAT.setBounds(VectorX/2, VectorY * 8, 250, 30);
        MenuAddTat.add(LabelCtyTAT);
// ========================================================================
        
        JTextField inputIdTAT = new JTextField();
        inputIdTAT.setBounds(VectorX, VectorY * 1, 250, 30);
        MenuAddTat.add(inputIdTAT);
        
        JTextField inputNameTAT = new JTextField();
        inputNameTAT.setBounds(VectorX, VectorY * 2, 250, 30);
        MenuAddTat.add(inputNameTAT);
        
        JTextField inputSlTAT = new JTextField();
        inputSlTAT.setBounds(VectorX, VectorY * 3, 250, 30);
        MenuAddTat.add(inputSlTAT);
        
        JTextField inputCostTAT = new JTextField();
        inputCostTAT.setBounds(VectorX, VectorY * 4, 250, 30);
        MenuAddTat.add(inputCostTAT);
//        ===============================================================================================       
        JTextField inputNsxTATDay = new JTextField();
        inputNsxTATDay.setBounds(VectorX, VectorY * 5, 50, 30);
        MenuAddTat.add(inputNsxTATDay);
        
        JTextField inputNsxTATMonth = new JTextField();
        inputNsxTATMonth.setBounds(VectorX + 100, VectorY * 5, 50, 30);
        MenuAddTat.add(inputNsxTATMonth);
        
        JTextField inputNsxTATYear = new JTextField();
        inputNsxTATYear.setBounds(VectorX + 200, VectorY * 5, 50, 30);
        MenuAddTat.add(inputNsxTATYear);
//        ===============================================================================================      
        JTextField inputHsdTATDay = new JTextField();
        inputHsdTATDay.setBounds(VectorX, VectorY * 6, 50, 30);
        MenuAddTat.add(inputHsdTATDay);
        
        JTextField inputHsdTATMonth = new JTextField();
        inputHsdTATMonth.setBounds(VectorX + 100, VectorY * 6, 50, 30);
        MenuAddTat.add(inputHsdTATMonth);
        
        JTextField inputHsdTATYear = new JTextField();
        inputHsdTATYear.setBounds(VectorX + 200, VectorY * 6, 50, 30);
        MenuAddTat.add(inputHsdTATYear);
//        ===============================================================================================             
        JTextField inputKhoTAT = new JTextField();
        inputKhoTAT.setBounds(VectorX, VectorY * 7, 250, 30);
        MenuAddTat.add(inputKhoTAT);
        
        JTextField inputCtyTAT = new JTextField();
        inputCtyTAT.setBounds(VectorX, VectorY * 8, 250, 30);
        MenuAddTat.add(inputCtyTAT);
        
        
        MenuAddTat.setSize(600, 650);
        MenuAddTat.setLayout(null);  
        MenuAddTat.setVisible(true);  
        MenuAddTat.setResizable(false);
        MenuAddTat.setLocationRelativeTo(null);
        
        
//         
            ConfirmInserted.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  String StringInputIdTAT = inputIdTAT.getText();
                  String StringInputNameTAT = inputNameTAT.getText();
                  int NumberInputSlTAT = Integer.parseInt(inputSlTAT.getText());
                  double NumerInputCostTAT = Double.parseDouble(inputCostTAT.getText());
                  
                  int InputNsxTATDay = Integer.parseInt(inputNsxTATDay.getText());
                  int InputNsxTATMonth = Integer.parseInt(inputNsxTATMonth.getText());
                  int InputNsxTATYear = Integer.parseInt(inputNsxTATYear.getText());
                  
                  int InputHsdTATDay = Integer.parseInt(inputHsdTATDay.getText());
                  int InputHsdTATMonth = Integer.parseInt(inputHsdTATMonth.getText());
                  int InputHsdTATYear = Integer.parseInt(inputHsdTATYear.getText());
                  
                  String StringInputKhoTAT = inputKhoTAT.getText();
                  String StringInputCtyTAT = inputCtyTAT.getText();
                  
   
                  
                  ThucAnTuoi Tat = new ThucAnTuoi();
                  Tat.setIdThucAn(StringInputIdTAT);
                  Tat.setTenThucAn(StringInputNameTAT);
                  Tat.setSoLuong(NumberInputSlTAT);
                  Tat.setGiaTien(NumerInputCostTAT);
                  Tat.setNSX(InputNsxTATYear,InputNsxTATMonth,InputNsxTATDay);
                  Tat.setHSD(InputHsdTATYear,InputHsdTATMonth,InputHsdTATDay);
                  Tat.setIdKho(StringInputKhoTAT);
                  Tat.setIdCtyNhap(StringInputCtyTAT);
                  tat.add(Tat);
                  
                  SaveDataTat(tat);
//                  try {
//                      FileOutputStream fos = new FileOutputStream("data.dat");
//                      ObjectOutputStream oos = new ObjectOutputStream(fos);
//                      oos.writeObject(new tatInserted);
//                      oos.close();
//                      System.out.println("Luu tru du lieu thanh cong.");
//                  } catch (IOException y) {
//                      y.printStackTrace();
//                  }
                  MenuAddTat.dispose();
              }
          });
    }
     public static void MenuAddTADN()
    {
        int VectorX = 10*30;
        int VectorY = 60;
        JFrame MenuAddTADN = new JFrame("Thêm thức dài ngày");
        
        JTextField inputIdTADN = new JTextField();
        inputIdTADN.setBounds(VectorX, VectorY * 1, 250, 30);
        MenuAddTADN.add(inputIdTADN);
        
        JTextField inputNameTDN = new JTextField();
        inputNameTDN.setBounds(VectorX, VectorY * 2, 250, 30);
        MenuAddTADN.add(inputNameTDN);
        
        JTextField inputSlTADN = new JTextField();
        inputSlTADN.setBounds(VectorX, VectorY * 3, 250, 30);
        MenuAddTADN.add(inputSlTADN);
        
        JTextField inputCostTADN = new JTextField();
        inputCostTADN.setBounds(VectorX, VectorY * 4, 250, 30);
        MenuAddTADN.add(inputCostTADN);
        
        JTextField inputNsxTADN = new JTextField();
        inputNsxTADN.setBounds(VectorX, VectorY * 5, 250, 30);
        MenuAddTADN.add(inputNsxTADN);
        
        JTextField inputHsdTADN = new JTextField();
        inputHsdTADN.setBounds(VectorX, VectorY * 6, 250, 30);
        MenuAddTADN.add(inputHsdTADN);
        
        JTextField inputKhoTADN = new JTextField();
        inputKhoTADN.setBounds(VectorX, VectorY * 7, 250, 30);
        MenuAddTADN.add(inputKhoTADN);
        
        JTextField inputCtyTADN = new JTextField();
        inputCtyTADN.setBounds(VectorX, VectorY * 8, 250, 30);
        MenuAddTADN.add(inputCtyTADN);
        
        MenuAddTADN.setSize(600, 600);
        MenuAddTADN.setLayout(null);  
        MenuAddTADN.setVisible(true);  
        MenuAddTADN.setResizable(false);
        MenuAddTADN.setLocationRelativeTo(null);
        
    }
   
    public static void init() 
    {
       Menu();    
    }
    
     private static String Banner() {
        return String.format("%15s %30s %30s %30s %30s %30s %30s %30s %30s ", "ID", "Tên Thức Ăn", "Số Lượnng", "Giá Tiền", "NSX" , "HSD", "Trạng Thái", "Kho", "Công Ty");
    }
     
    
}

