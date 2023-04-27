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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;



public class Login extends JFrame implements ActionListener{
    static ArrayList<ThucAnTuoi> tat = new ArrayList<>();
    static ArrayList<ThucAnDaiNgay> tadn = new ArrayList<>();   
    static Scanner sc = new Scanner(System.in);
    JLabel l1, l2;
    JTextField tf1;
    JPasswordField tf2;
    JButton btn1;
    JFrame Menu;
    
    
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
     public static boolean hasObject(File f) {
        // thu doc xem co object nao chua
        FileInputStream fi;
        boolean check = true;
        try {
            fi = new FileInputStream(f);
            ObjectInputStream inStream = new ObjectInputStream(fi);
            if (inStream.readObject() == null) {
                check = false;
            }
            inStream.close();
 
        } catch (FileNotFoundException e) {
            check = false;
        } catch (IOException e) {
            check = false;
        } catch (ClassNotFoundException e) {
            check = false;
            e.printStackTrace();
        }
        return check;
    }
    
    public static void Write(ArrayList<ThucAnTuoi> tat)
    {
         try {
 
            File f = new File("data.dat");
            FileOutputStream fo;
            ObjectOutputStream oStream = null;
 
            // neu file chu ton tai thi tao file va ghi binh thuong
            if (!f.exists()) {
                fo = new FileOutputStream(f);
                oStream = new ObjectOutputStream(fo);
            } else { // neu file ton tai
 
                // neu chua co thi ghi binh thuong
                if (!hasObject(f)) {
                    fo = new FileOutputStream(f);
                    oStream = new ObjectOutputStream(fo);
                } else { // neu co roi thi ghi them vao
 
                    fo = new FileOutputStream(f, true);
 
                    oStream = new ObjectOutputStream(fo) {
                        protected void writeStreamHeader() throws IOException {
                            reset();
                        }
                    };
                }
            }
            System.out.println("Them du lieu thanh cong");
            System.out.println(tat);
            
            oStream.writeObject(tat);
            oStream.close();
 
        } catch (IOException e) {
        }
         
    }
    
        public static void Read() {
            try {
                File f = new File("data.dat");
                FileInputStream fis = new FileInputStream(f);
                ObjectInputStream inStream = new ObjectInputStream(fis);
                
                while (true) {
                    int i = 0;
                    ArrayList<ThucAnTuoi> tatLoaded = (ArrayList<ThucAnTuoi>) inStream.readObject();

                    tatLoaded.get(i).kiemTraHSD();
                    mainView.append(tatLoaded.get(i).toString() +"\n");
                    i++;
                }
            } catch (ClassNotFoundException | IOException e) {
            }
    }
    
   
    
    
      public static void Menu()
      {
        int n = 0;
        int _choice = 0;
        boolean state = true;
        String idCanTim;
        String idCanXoa;
        
                       
            
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
                  Read();
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

                  Write(tat);
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
       Read();
    }
    
     private static String Banner() {
        return String.format("%15s %30s %30s %30s %30s %30s %30s %30s %30s ", "ID", "Tên Thức Ăn", "Số Lượnng", "Giá Tiền", "NSX" , "HSD", "Trạng Thái", "Kho", "Công Ty");
    }
     
    
}

