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
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Login extends JFrame implements ActionListener {

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
        l1.setBounds(setDefaultRightX - 100, setDefaultRightY + 50, 100, 30);
        l2 = new JLabel("Mật khẩu: ");
        l2.setBounds(setDefaultRightX - 100, setDefaultRightY + 100, 100, 30);
        tf1 = new JTextField();

        tf1.setBounds(setDefaultRightX, setDefaultRightY + 50, 250, 30);
        tf2 = new JPasswordField();
        tf2.setBounds(setDefaultRightX, setDefaultRightY + 100, 250, 30);
        btn1 = new JButton("Đăng nhập");
        btn1.setBounds(setDefaultRightX, setDefaultRightY + 150, 250, 50);
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

    public static void XuatTat() {
        mainView.setText(null);
        mainView.append(BannerTat() + "\n");
        for (int i = 0; i < tat.size(); i++) {
            tat.get(i).kiemTraHSD();
            mainView.append(tat.get(i).toString() + "\n");
        }
    }

    public static void XuatTadn() {
        mainView.setText(null);
        mainView.append(BannerTadn() + "\n");
        for (int i = 0; i < tadn.size(); i++) {
            tadn.get(i).kiemTraHSD();
            mainView.append(tadn.get(i).toString() + "\n");
        }
    }

    public static void Menu() {
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

        JButton DeleteTatBtn = new JButton("Xóa TAT");
        DeleteTatBtn.setBounds(1100, 100, 150, 40);
        menu.add(DeleteTatBtn);

        JButton UpdateTatBtn = new JButton("Sửa TAT");
        UpdateTatBtn.setBounds(1100, 150, 150, 40);
        menu.add(UpdateTatBtn);

        JButton addTadnBtn = new JButton("Thêm");
        addTadnBtn.setBounds(1290, 50, 150, 40);

        JButton DeleteTADNBtn = new JButton("Xóa TADN");
        DeleteTADNBtn.setBounds(1290, 100, 150, 40);
        menu.add(DeleteTADNBtn);

        JButton UpdateTADNBtn = new JButton("Sửa TADN");
        UpdateTADNBtn.setBounds(1290, 150, 150, 40);
        menu.add(UpdateTADNBtn);

        JLabel title = new JLabel("SUBACITO");
//        title.setBounds(100, 50, 100, 30);

        mainView = new JTextArea("", 5, 50);
        JScrollPane scrollPane = new JScrollPane(mainView);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(1080, 600));
        mainView.setEditable(false);
//        mainView.setBounds(1000, 150, 1050, 30);
//        mainView.append(BannerTat()+"\n");
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

//nút update TAT
        UpdateTatBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateTAT();
            }

        });
////nút update TADN
        UpdateTADNBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateTADN();
            }

        });

        //nút xóa TAT 
        DeleteTatBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteTAT();
            }

        });

        //nút xóa TADN
        DeleteTADNBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteTADN();
            }

        });

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
                XuatTat();
            }
        });
        // Nút xem TADN
        c.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                XuatTadn();
            }
        });
    }

    public static void MenuAddTAT() {
        int VectorX = 10 * 30;
        int VectorY = 60;
        JFrame MenuAddTat = new JFrame("Thêm thức ăn tươi");
        JButton ConfirmInserted = new JButton("Xác nhận");
        ConfirmInserted.setBounds(VectorX / 2, VectorY * 9, 250, 30);
        MenuAddTat.add(ConfirmInserted);

        JLabel LabelIdTAT = new JLabel("ID: ");
        LabelIdTAT.setBounds(VectorX / 2, VectorY * 1, 250, 30);
        MenuAddTat.add(LabelIdTAT);

        JLabel LabelNameTAT = new JLabel("Tên thực phẩm: ");
        LabelNameTAT.setBounds(VectorX / 2, VectorY * 2, 250, 30);
        MenuAddTat.add(LabelNameTAT);

        JLabel LabelSlTAT = new JLabel("Số lượng: ");
        LabelSlTAT.setBounds(VectorX / 2, VectorY * 3, 250, 30);
        MenuAddTat.add(LabelSlTAT);

        JLabel LabelCostTAT = new JLabel("Giá: ");
        LabelCostTAT.setBounds(VectorX / 2, VectorY * 4, 250, 30);
        MenuAddTat.add(LabelCostTAT);

        JLabel LabelNsxTAT = new JLabel("Ngày sản xuất: ");
        LabelNsxTAT.setBounds(VectorX / 2, VectorY * 5, 250, 30);
        MenuAddTat.add(LabelNsxTAT);

        JLabel LabelHsdTAT = new JLabel("Hạn sử dụng: ");
        LabelHsdTAT.setBounds(VectorX / 2, VectorY * 6, 250, 30);
        MenuAddTat.add(LabelHsdTAT);

        JLabel LabelKhoTAT = new JLabel("Nhiệt độ tủ đông: ");
        LabelKhoTAT.setBounds(VectorX / 2, VectorY * 7, 250, 30);
        MenuAddTat.add(LabelKhoTAT);

        JLabel LabelCtyTAT = new JLabel("ID Tủ đông: ");
        LabelCtyTAT.setBounds(VectorX / 2, VectorY * 8, 250, 30);
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
        JTextField inputNhietDoTuDong = new JTextField();
        inputNhietDoTuDong.setBounds(VectorX, VectorY * 7, 250, 30);
        MenuAddTat.add(inputNhietDoTuDong);

        JTextField inputIDTuDong = new JTextField();
        inputIDTuDong.setBounds(VectorX, VectorY * 8, 250, 30);
        MenuAddTat.add(inputIDTuDong);

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

                double StringInputKhoTAT = Double.parseDouble(inputNhietDoTuDong.getText());
                String StringInputCtyTAT = inputIDTuDong.getText();

                ThucAnTuoi Tat = new ThucAnTuoi();
                Tat.setIdThucAn(StringInputIdTAT);
                Tat.setTenThucAn(StringInputNameTAT);
                Tat.setSoLuong(NumberInputSlTAT);
                Tat.setGiaTien(NumerInputCostTAT);
                Tat.setNSX(InputNsxTATYear, InputNsxTATMonth, InputNsxTATDay);
                Tat.setHSD(InputHsdTATYear, InputHsdTATMonth, InputHsdTATDay);
                Tat.setNhietDoTuDong(StringInputKhoTAT);
                Tat.setIDTuDong(StringInputCtyTAT);
                tat.add(Tat);

                MenuAddTat.dispose();
            }
        });
    }

    public static void MenuAddTADN() {
        int VectorX = 10 * 30;
        int VectorY = 60;
        JFrame MenuAddTADN = new JFrame("Thêm thức dài ngày");
        JButton ConfirmInsertedTADN = new JButton("Xác nhận");
        ConfirmInsertedTADN.setBounds(VectorX / 2, VectorY * 9, 250, 30);
        MenuAddTADN.add(ConfirmInsertedTADN);

        JTextField inputIdTADN = new JTextField();
        inputIdTADN.setBounds(VectorX, VectorY * 1, 250, 30);
        MenuAddTADN.add(inputIdTADN);

        JTextField inputNameTADN = new JTextField();
        inputNameTADN.setBounds(VectorX, VectorY * 2, 250, 30);
        MenuAddTADN.add(inputNameTADN);

        JTextField inputSlTADN = new JTextField();
        inputSlTADN.setBounds(VectorX, VectorY * 3, 250, 30);
        MenuAddTADN.add(inputSlTADN);

        JTextField inputCostTADN = new JTextField();
        inputCostTADN.setBounds(VectorX, VectorY * 4, 250, 30);
        MenuAddTADN.add(inputCostTADN);

        //===============================================================================================       
        JTextField inputNsxTADNDay = new JTextField();
        inputNsxTADNDay.setBounds(VectorX, VectorY * 5, 50, 30);
        MenuAddTADN.add(inputNsxTADNDay);

        JTextField inputNsxTADNMonth = new JTextField();
        inputNsxTADNMonth.setBounds(VectorX + 100, VectorY * 5, 50, 30);
        MenuAddTADN.add(inputNsxTADNMonth);

        JTextField inputNsxTADNYear = new JTextField();
        inputNsxTADNYear.setBounds(VectorX + 200, VectorY * 5, 50, 30);
        MenuAddTADN.add(inputNsxTADNYear);
        //===============================================================================================      
        JTextField inputHsdTADNDay = new JTextField();
        inputHsdTADNDay.setBounds(VectorX, VectorY * 6, 50, 30);
        MenuAddTADN.add(inputHsdTADNDay);

        JTextField inputHsdTADNMonth = new JTextField();
        inputHsdTADNMonth.setBounds(VectorX + 100, VectorY * 6, 50, 30);
        MenuAddTADN.add(inputHsdTADNMonth);

        JTextField inputHsdTADNYear = new JTextField();
        inputHsdTADNYear.setBounds(VectorX + 200, VectorY * 6, 50, 30);
        MenuAddTADN.add(inputHsdTADNYear);
        //===============================================================================================   

        JTextField inputDoAmTADN = new JTextField();
        inputDoAmTADN.setBounds(VectorX, VectorY * 7, 250, 30);
        MenuAddTADN.add(inputDoAmTADN);

        JTextField inputNhietDoKhoTADN = new JTextField();
        inputNhietDoKhoTADN.setBounds(VectorX, VectorY * 8, 250, 30);
        MenuAddTADN.add(inputNhietDoKhoTADN);

        JLabel LabelIdTADN = new JLabel("ID: ");
        LabelIdTADN.setBounds(VectorX / 2, VectorY * 1, 250, 30);
        MenuAddTADN.add(LabelIdTADN);

        JLabel LabelNameTADN = new JLabel("Tên thực phẩm: ");
        LabelNameTADN.setBounds(VectorX / 2, VectorY * 2, 250, 30);
        MenuAddTADN.add(LabelNameTADN);

        JLabel LabelSlTADN = new JLabel("Số lượng: ");
        LabelSlTADN.setBounds(VectorX / 2, VectorY * 3, 250, 30);
        MenuAddTADN.add(LabelSlTADN);

        JLabel LabelCostTADN = new JLabel("Giá: ");
        LabelCostTADN.setBounds(VectorX / 2, VectorY * 4, 250, 30);
        MenuAddTADN.add(LabelCostTADN);

        JLabel LabelNsxTADN = new JLabel("Ngày sản xuất: ");
        LabelNsxTADN.setBounds(VectorX / 2, VectorY * 5, 250, 30);
        MenuAddTADN.add(LabelNsxTADN);

        JLabel LabelHsdTADN = new JLabel("Hạn sử dụng: ");
        LabelHsdTADN.setBounds(VectorX / 2, VectorY * 6, 250, 30);
        MenuAddTADN.add(LabelHsdTADN);

        JLabel LabelDoAmTADN = new JLabel("Độ ẩm: ");
        LabelDoAmTADN.setBounds(VectorX / 2, VectorY * 7, 250, 30);
        MenuAddTADN.add(LabelDoAmTADN);

        JLabel LabelNDKhoTAT = new JLabel("Nhiệt độ kho: ");
        LabelNDKhoTAT.setBounds(VectorX / 2, VectorY * 8, 250, 30);
        MenuAddTADN.add(LabelNDKhoTAT);

        ConfirmInsertedTADN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String StringInputIdTADN = inputIdTADN.getText();
                String StringInputNameTADN = inputNameTADN.getText();
                int NumberInputSlTADN = Integer.parseInt(inputSlTADN.getText());
                double NumerInputCostTADN = Double.parseDouble(inputCostTADN.getText());

                int InputNsxTADNDay = Integer.parseInt(inputNsxTADNDay.getText());
                int InputNsxTADNMonth = Integer.parseInt(inputNsxTADNMonth.getText());
                int InputNsxTADNYear = Integer.parseInt(inputNsxTADNYear.getText());

                int InputHsdTADNDay = Integer.parseInt(inputHsdTADNDay.getText());
                int InputHsdTADNMonth = Integer.parseInt(inputHsdTADNMonth.getText());
                int InputHsdTADNYear = Integer.parseInt(inputHsdTADNYear.getText());

                double StringInputDoAmTADN = Double.parseDouble(inputDoAmTADN.getText());
                double InputNhietDoKhoTADN = Double.parseDouble(inputNhietDoKhoTADN.getText());

                ThucAnDaiNgay Tadn = new ThucAnDaiNgay();
                Tadn.setIdThucAn(StringInputIdTADN);
                Tadn.setTenThucAn(StringInputNameTADN);
                Tadn.setSoLuong(NumberInputSlTADN);
                Tadn.setGiaTien(NumerInputCostTADN);
                Tadn.setNSX(InputNsxTADNYear, InputNsxTADNMonth, InputNsxTADNDay);
                Tadn.setHSD(InputHsdTADNYear, InputHsdTADNMonth, InputHsdTADNDay);
                Tadn.setDoAm(StringInputDoAmTADN);
                Tadn.setNhietDoKho(InputNhietDoKhoTADN);
                tadn.add(Tadn);
                MenuAddTADN.dispose();
            }
        });

        MenuAddTADN.setSize(600, 650);
        MenuAddTADN.setLayout(null);
        MenuAddTADN.setVisible(true);
        MenuAddTADN.setResizable(false);
        MenuAddTADN.setLocationRelativeTo(null);

    }
//Update TAT

    public static void UpdateTAT() {
        int VectorX = 10 * 30;
        int VectorY = 60;
        JFrame UpdateTAT = new JFrame("Sửa thông tin thức ăn tươi");

        // thêm nút xác nhận
        JButton ConfirmUpdatedTAT = new JButton("Xác nhận");
        ConfirmUpdatedTAT.setBounds(VectorX / 2, VectorY * 9, 250, 30);
        UpdateTAT.add(ConfirmUpdatedTAT);

        // thêm nhập dữ liệu
// ========================================================================
        JTextField inputIdTAT = new JTextField();
        inputIdTAT.setBounds(VectorX, VectorY * 1, 250, 30);
        UpdateTAT.add(inputIdTAT);

        JTextField inputNameTAT = new JTextField();
        inputNameTAT.setBounds(VectorX, VectorY * 2, 250, 30);
        UpdateTAT.add(inputNameTAT);

        JTextField inputSlTAT = new JTextField();
        inputSlTAT.setBounds(VectorX, VectorY * 3, 250, 30);
        UpdateTAT.add(inputSlTAT);

        JTextField inputCostTAT = new JTextField();
        inputCostTAT.setBounds(VectorX, VectorY * 4, 250, 30);
        UpdateTAT.add(inputCostTAT);
//        ===============================================================================================       
        JTextField inputNsxTATDay = new JTextField();
        inputNsxTATDay.setBounds(VectorX, VectorY * 5, 50, 30);
        UpdateTAT.add(inputNsxTATDay);

        JTextField inputNsxTATMonth = new JTextField();
        inputNsxTATMonth.setBounds(VectorX + 100, VectorY * 5, 50, 30);
        UpdateTAT.add(inputNsxTATMonth);

        JTextField inputNsxTATYear = new JTextField();
        inputNsxTATYear.setBounds(VectorX + 200, VectorY * 5, 50, 30);
        UpdateTAT.add(inputNsxTATYear);
//        ===============================================================================================      
        JTextField inputHsdTATDay = new JTextField();
        inputHsdTATDay.setBounds(VectorX, VectorY * 6, 50, 30);
        UpdateTAT.add(inputHsdTATDay);

        JTextField inputHsdTATMonth = new JTextField();
        inputHsdTATMonth.setBounds(VectorX + 100, VectorY * 6, 50, 30);
        UpdateTAT.add(inputHsdTATMonth);

        JTextField inputHsdTATYear = new JTextField();
        inputHsdTATYear.setBounds(VectorX + 200, VectorY * 6, 50, 30);
        UpdateTAT.add(inputHsdTATYear);
//        ===============================================================================================             
        JTextField inputNhietDoTuDong = new JTextField();
        inputNhietDoTuDong.setBounds(VectorX, VectorY * 7, 250, 30);
        UpdateTAT.add(inputNhietDoTuDong);

        JTextField inputIDTuDong = new JTextField();
        inputIDTuDong.setBounds(VectorX, VectorY * 8, 250, 30);
        UpdateTAT.add(inputIDTuDong);

        // thêm label
        JLabel LabelIdTAT = new JLabel("ID: ");
        LabelIdTAT.setBounds(VectorX / 2, VectorY * 1, 250, 30);
        UpdateTAT.add(LabelIdTAT);

        JLabel LabelNameTAT = new JLabel("Tên thực phẩm: ");
        LabelNameTAT.setBounds(VectorX / 2, VectorY * 2, 250, 30);
        UpdateTAT.add(LabelNameTAT);

        JLabel LabelSlTAT = new JLabel("Số lượng: ");
        LabelSlTAT.setBounds(VectorX / 2, VectorY * 3, 250, 30);
        UpdateTAT.add(LabelSlTAT);

        JLabel LabelCostTAT = new JLabel("Giá: ");
        LabelCostTAT.setBounds(VectorX / 2, VectorY * 4, 250, 30);
        UpdateTAT.add(LabelCostTAT);

        JLabel LabelNsxTAT = new JLabel("Ngày sản xuất: ");
        LabelNsxTAT.setBounds(VectorX / 2, VectorY * 5, 250, 30);
        UpdateTAT.add(LabelNsxTAT);

        JLabel LabelHsdTAT = new JLabel("Hạn sử dụng: ");
        LabelHsdTAT.setBounds(VectorX / 2, VectorY * 6, 250, 30);
        UpdateTAT.add(LabelHsdTAT);

        JLabel LabelKhoTAT = new JLabel("Nhiệt độ tủ đông: ");
        LabelKhoTAT.setBounds(VectorX / 2, VectorY * 7, 250, 30);
        UpdateTAT.add(LabelKhoTAT);

        JLabel LabelCtyTAT = new JLabel("ID Tủ đông: ");
        LabelCtyTAT.setBounds(VectorX / 2, VectorY * 8, 250, 30);
        UpdateTAT.add(LabelCtyTAT);

        ConfirmUpdatedTAT.addActionListener(new ActionListener() {
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

                double StringInputKhoTAT = Double.parseDouble(inputNhietDoTuDong.getText());
                String StringInputCtyTAT = inputIDTuDong.getText();

                ThucAnTuoi Tat = new ThucAnTuoi();
                Tat.setIdThucAn(StringInputIdTAT);
                Tat.setTenThucAn(StringInputNameTAT);
                Tat.setSoLuong(NumberInputSlTAT);
                Tat.setGiaTien(NumerInputCostTAT);
                Tat.setNSX(InputNsxTATYear, InputNsxTATMonth, InputNsxTATDay);
                Tat.setHSD(InputHsdTATYear, InputHsdTATMonth, InputHsdTATDay);
                Tat.setNhietDoTuDong(StringInputKhoTAT);
                Tat.setIDTuDong(StringInputCtyTAT);
                tat.add(Tat);

                UpdateTAT.dispose();
            }
        });

        UpdateTAT.setSize(600, 650);
        UpdateTAT.setLayout(null);
        UpdateTAT.setVisible(true);
        UpdateTAT.setResizable(false);
        UpdateTAT.setLocationRelativeTo(null);
    }

//Update TADN
    public static void UpdateTADN() {
        int VectorX = 10 * 30;
        int VectorY = 60;
        JFrame UpdateTADN = new JFrame("Sửa thông tin thức ăn dài ngày");

        // thêm nút xác nhận
        JButton ConfirmUpdatedTADN = new JButton("Xác nhận");
        ConfirmUpdatedTADN.setBounds(VectorX / 2, VectorY * 9, 250, 30);
        UpdateTADN.add(ConfirmUpdatedTADN);

        // thêm nhập dữ liệu
// ========================================================================
        JTextField inputIdTADN = new JTextField();
        inputIdTADN.setBounds(VectorX, VectorY * 1, 250, 30);
        UpdateTADN.add(inputIdTADN);

        JTextField inputNameTADN = new JTextField();
        inputNameTADN.setBounds(VectorX, VectorY * 2, 250, 30);
        UpdateTADN.add(inputNameTADN);

        JTextField inputSlTADN = new JTextField();
        inputSlTADN.setBounds(VectorX, VectorY * 3, 250, 30);
        UpdateTADN.add(inputSlTADN);

        JTextField inputCostTADN = new JTextField();
        inputCostTADN.setBounds(VectorX, VectorY * 4, 250, 30);
        UpdateTADN.add(inputCostTADN);

        //===============================================================================================       
        JTextField inputNsxTADNDay = new JTextField();
        inputNsxTADNDay.setBounds(VectorX, VectorY * 5, 50, 30);
        UpdateTADN.add(inputNsxTADNDay);

        JTextField inputNsxTADNMonth = new JTextField();
        inputNsxTADNMonth.setBounds(VectorX + 100, VectorY * 5, 50, 30);
        UpdateTADN.add(inputNsxTADNMonth);

        JTextField inputNsxTADNYear = new JTextField();
        inputNsxTADNYear.setBounds(VectorX + 200, VectorY * 5, 50, 30);
        UpdateTADN.add(inputNsxTADNYear);
        //===============================================================================================      
        JTextField inputHsdTADNDay = new JTextField();
        inputHsdTADNDay.setBounds(VectorX, VectorY * 6, 50, 30);
        UpdateTADN.add(inputHsdTADNDay);

        JTextField inputHsdTADNMonth = new JTextField();
        inputHsdTADNMonth.setBounds(VectorX + 100, VectorY * 6, 50, 30);
        UpdateTADN.add(inputHsdTADNMonth);

        JTextField inputHsdTADNYear = new JTextField();
        inputHsdTADNYear.setBounds(VectorX + 200, VectorY * 6, 50, 30);
        UpdateTADN.add(inputHsdTADNYear);
        //===============================================================================================   

        JTextField inputDoAmTADN = new JTextField();
        inputDoAmTADN.setBounds(VectorX, VectorY * 7, 250, 30);
        UpdateTADN.add(inputDoAmTADN);

        JTextField inputNhietDoKhoTADN = new JTextField();
        inputNhietDoKhoTADN.setBounds(VectorX, VectorY * 8, 250, 30);
        UpdateTADN.add(inputNhietDoKhoTADN);

        // thêm label
        JLabel LabelIdTADN = new JLabel("ID: ");
        LabelIdTADN.setBounds(VectorX / 2, VectorY * 1, 250, 30);
        UpdateTADN.add(LabelIdTADN);

        JLabel LabelNameTADN = new JLabel("Tên thực phẩm: ");
        LabelNameTADN.setBounds(VectorX / 2, VectorY * 2, 250, 30);
        UpdateTADN.add(LabelNameTADN);

        JLabel LabelSlTADN = new JLabel("Số lượng: ");
        LabelSlTADN.setBounds(VectorX / 2, VectorY * 3, 250, 30);
        UpdateTADN.add(LabelSlTADN);

        JLabel LabelCostTADN = new JLabel("Giá: ");
        LabelCostTADN.setBounds(VectorX / 2, VectorY * 4, 250, 30);
        UpdateTADN.add(LabelCostTADN);

        JLabel LabelNsxTADN = new JLabel("Ngày sản xuất: ");
        LabelNsxTADN.setBounds(VectorX / 2, VectorY * 5, 250, 30);
        UpdateTADN.add(LabelNsxTADN);

        JLabel LabelHsdTADN = new JLabel("Hạn sử dụng: ");
        LabelHsdTADN.setBounds(VectorX / 2, VectorY * 6, 250, 30);
        UpdateTADN.add(LabelHsdTADN);

        JLabel LabelDoAmTADN = new JLabel("Độ ẩm: ");
        LabelDoAmTADN.setBounds(VectorX / 2, VectorY * 7, 250, 30);
        UpdateTADN.add(LabelDoAmTADN);

        JLabel LabelNDKhoTAT = new JLabel("Nhiệt độ kho: ");
        LabelNDKhoTAT.setBounds(VectorX / 2, VectorY * 8, 250, 30);
        UpdateTADN.add(LabelNDKhoTAT);

        ConfirmUpdatedTADN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String StringInputIdTADN = inputIdTADN.getText();
                String StringInputNameTADN = inputNameTADN.getText();
                int NumberInputSlTADN = Integer.parseInt(inputSlTADN.getText());
                double NumerInputCostTADN = Double.parseDouble(inputCostTADN.getText());

                int InputNsxTADNDay = Integer.parseInt(inputNsxTADNDay.getText());
                int InputNsxTADNMonth = Integer.parseInt(inputNsxTADNMonth.getText());
                int InputNsxTADNYear = Integer.parseInt(inputNsxTADNYear.getText());

                int InputHsdTADNDay = Integer.parseInt(inputHsdTADNDay.getText());
                int InputHsdTADNMonth = Integer.parseInt(inputHsdTADNMonth.getText());
                int InputHsdTADNYear = Integer.parseInt(inputHsdTADNYear.getText());

                double StringInputDoAmTADN = Double.parseDouble(inputDoAmTADN.getText());
                double InputNhietDoKhoTADN = Double.parseDouble(inputNhietDoKhoTADN.getText());

                ThucAnDaiNgay Tadn = new ThucAnDaiNgay();
                Tadn.setIdThucAn(StringInputIdTADN);
                Tadn.setTenThucAn(StringInputNameTADN);
                Tadn.setSoLuong(NumberInputSlTADN);
                Tadn.setGiaTien(NumerInputCostTADN);
                Tadn.setNSX(InputNsxTADNYear, InputNsxTADNMonth, InputNsxTADNDay);
                Tadn.setHSD(InputHsdTADNYear, InputHsdTADNMonth, InputHsdTADNDay);
                Tadn.setDoAm(StringInputDoAmTADN);
                Tadn.setNhietDoKho(InputNhietDoKhoTADN);
                tadn.add(Tadn);
                UpdateTADN.dispose();
            }
        });

        UpdateTADN.setSize(600, 650);
        UpdateTADN.setLayout(null);
        UpdateTADN.setVisible(true);
        UpdateTADN.setResizable(false);
        UpdateTADN.setLocationRelativeTo(null);
    }

//Xóa TAT
    public static void DeleteTAT() {
        int VectorX = 10 * 30;
        int VectorY = 60;
        JFrame DeleteTAT = new JFrame("Xóa thức ăn tươi");

//thêm nút xóa
        JButton ConfirmDeletedTAT = new JButton("Xác nhận");
        ConfirmDeletedTAT.setBounds(VectorX - 150, VectorY + 100, 100, 30);
        DeleteTAT.add(ConfirmDeletedTAT);

//thêm nhập dữ liệu
        JTextField inputDeletelTAT = new JTextField();
        inputDeletelTAT.setBounds(VectorX - 100, VectorY * 1, 150, 30);
        DeleteTAT.add(inputDeletelTAT);

//thêm lable
        JLabel LabelCtyTAT = new JLabel("ID Thức ăn tươi: ");
        LabelCtyTAT.setBounds(VectorX - 200, VectorY * 1, 250, 30);
        DeleteTAT.add(LabelCtyTAT);

        ConfirmDeletedTAT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String StringInputDeleteIdTAT = inputDeletelTAT.getText();
                for (int i = 0; i < tat.size(); i++) {
                    if (tat.get(i).getIdThucAn().equals(StringInputDeleteIdTAT)) {
                        tat.remove(i);
                    }
                }
                DeleteTAT.dispose();
            }
        });

        DeleteTAT.setSize(400, 280);
        DeleteTAT.setLayout(null);
        DeleteTAT.setVisible(true);
        DeleteTAT.setResizable(false);
        DeleteTAT.setLocationRelativeTo(null);
    }

    //Xóa TADN
    public static void DeleteTADN() {
        int VectorX = 10 * 30;
        int VectorY = 60;
        JFrame DeleteTADN = new JFrame("Xóa thức ăn dài ngày");

//thêm nút xóa
        JButton ConfirmDeletedTADN = new JButton("Xác nhận");
        ConfirmDeletedTADN.setBounds(VectorX - 150, VectorY + 100, 100, 30);
        DeleteTADN.add(ConfirmDeletedTADN);

//thêm nhập dữ liệu
        JTextField inputDeletelTADN = new JTextField();
        inputDeletelTADN.setBounds(VectorX - 100, VectorY * 1, 150, 30);
        DeleteTADN.add(inputDeletelTADN);

//thêm lable
        JLabel LabelCtyTADN = new JLabel("ID Thức ăn tươi: ");
        LabelCtyTADN.setBounds(VectorX - 200, VectorY * 1, 250, 30);
        DeleteTADN.add(LabelCtyTADN);

        ConfirmDeletedTADN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String StringInputDeleteIdTADN = inputDeletelTADN.getText();
                for (int i = 0; i < tadn.size(); i++) {
                    if (tadn.get(i).getIdThucAn().equals(StringInputDeleteIdTADN)) {
                        tadn.remove(i);
                    }
                }
                DeleteTADN.dispose();
            }
        });

        DeleteTADN.setSize(400, 280);
        DeleteTADN.setLayout(null);
        DeleteTADN.setVisible(true);
        DeleteTADN.setResizable(false);
        DeleteTADN.setLocationRelativeTo(null);
    }

    public static void init() {
        Menu();
        XuatTat();

    }

    private static String BannerTat() {
        return String.format("%15s %30s %30s %30s %30s %30s %30s %30s %30s ", "ID", "Tên Thức Ăn", "Số Lượnng", "Giá Tiền", "NSX", "HSD", "Trạng Thái", "Nhiệt độ tủ đông", "ID Tủ Đông");
    }

    private static String BannerTadn() {
        return String.format("%15s %30s %30s %30s %30s %30s %30s %30s %30s ", "ID", "Tên Thức Ăn", "Số Lượnng", "Giá Tiền", "NSX", "HSD", "Trạng Thái", "Độ ẩm", "Nhiệt độ kho");
    }

}
