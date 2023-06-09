/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyThucPham;

/**
 *
 * @author MYPC
 */
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.*;

public class QuanLyThucPham extends JFrame implements ActionListener {

    static ArrayList<ThucAnTuoi> tat = new ArrayList<>();
    static ArrayList<ThucAnDaiNgay> tadn = new ArrayList<>();
    static ArrayList<Bill> listHoaDon = new ArrayList<>();

//==============================================================================
//==============================================================================
    static Scanner sc = new Scanner(System.in);
    private JLabel l1, l2;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JComboBox<String> accessComboBox;
    private JButton loginButton, registerButton;
    private JFrame Menu;

    static JTextArea mainView;

    public QuanLyThucPham() {

        super("Đăng nhập hoặc đăng ký");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        // Tạo label và field để nhập tên người dùng
        JLabel usernameLabel = new JLabel("Tên người dùng:");
        add(usernameLabel);
        usernameField = new JTextField(10);
        add(usernameField);

        // Tạo label và field để nhập mật khẩu
        JLabel passwordLabel = new JLabel("Mật khẩu:");
        add(passwordLabel);
        passwordField = new JPasswordField(10);
        add(passwordField);

        // Tạo combobox để chọn quyền truy cập
        JLabel accessLabel = new JLabel("Quyền truy cập:");
        add(accessLabel);
        accessComboBox = new JComboBox<String>(new String[]{"Nhân viên", "Quản trị viên"});
        add(accessComboBox);

        // Tạo nút đăng nhập và gắn hàm xử lý sự kiện cho nút này
        loginButton = new JButton("Đăng nhập");
        add(loginButton);
        loginButton.addActionListener(this);

        // Tạo nút đăng ký và gắn hàm xử lý sự kiện cho nút này
        registerButton = new JButton("Đăng ký");
        add(registerButton);
        registerButton.addActionListener(this);

        // Tạo GroupLayout và thiết lập các thành phần vào layout
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(usernameLabel)
                        .addComponent(passwordLabel)
                        .addComponent(accessLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(usernameField)
                        .addComponent(passwordField)
                        .addComponent(accessComboBox)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(loginButton)
                                .addComponent(registerButton)))
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(usernameLabel)
                        .addComponent(usernameField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(passwordLabel)
                        .addComponent(passwordField))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(accessLabel)
                        .addComponent(accessComboBox))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(loginButton)
                        .addComponent(registerButton))
        );

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerButton) {
            String username = usernameField.getText().trim();
            String password = new String(passwordField.getPassword()).trim();
            String role = ((String)accessComboBox.getSelectedItem()).trim();

            // Check if fields are empty
            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập cả tên đăng nhập và mật khẩu.");
                return;
            }

            // Register user
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("src\\QuanLyThucPham\\users.txt", true))) {
                writer.write(username + "//" + password + "//" + role);
                writer.newLine();
                JOptionPane.showMessageDialog(this, "Đăng Ký Thành Công");
                usernameField.setText("");
                passwordField.setText("");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Lỗi đăng ký người dùng: " + ex.getMessage());
            }

        } else if (e.getSource() == loginButton) {
            String username = usernameField.getText().trim();
            String password = new String(passwordField.getPassword()).trim();
            

            // Check if fields are empty
            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập cả tên đăng nhập và mật khẩu");
                return;
            }

            // Login user
            boolean found = false;
            try (BufferedReader reader = new BufferedReader(new FileReader("src\\QuanLyThucPham\\users.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split("//");
                    if (parts.length == 3 && parts[0].equals(username) && parts[1].equals(password)) {
                        found = true;
                        break;
                    }
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Lỗi đăng nhập: " + ex.getMessage());
            }

            if (found) {
                JOptionPane.showMessageDialog(this, "Đăng nhập thành công");
                dispose();
                init();
            }
            else {
                JOptionPane.showMessageDialog(this, "Sai tài khoản hoặc mật khẩu");
            }
        }
    }

//    public void actionPerformed(ActionEvent e) {
//        String username = usernameField.getText();
//        String password = passwordField.getText();
//        if (username.equals("") && password.equals("")) {
//            JOptionPane.showMessageDialog(this, "Đăng nhập thành công");
//            dispose();
//            init();
//
//        } else {
//            JOptionPane.showMessageDialog(this, "Sai tài khoản hoặc mật khẩu");
//        }
//    }
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

        JButton CreateBill = new JButton("Hóa Đơn");
        CreateBill.setBounds(1100, 200, 150, 40);
        menu.add(CreateBill);

        JLabel title = new JLabel("SUBACITO");

        mainView = new JTextArea("", 5, 50);
        JScrollPane scrollPane = new JScrollPane(mainView);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        scrollPane.setPreferredSize(new Dimension(1080, 600));
        mainView.setEditable(false);
        mainView.setLineWrap(true);
        mainView.setWrapStyleWord(true);
        mainView.setBounds(500,100,1080,600);
        
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
        menu.getContentPane().setBackground(new Color(153, 204, 255));
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
        // Nút tạo bill
        CreateBill.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                XuLyHoaDon();
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
                UpdateTat();
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
                UpdateTadn();
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

        // thêm nút check
        JButton CheckUpdatedTAT = new JButton("Kiểm tra");
        CheckUpdatedTAT.setBounds(VectorX / 2, VectorY - 50, 250, 30);
        UpdateTAT.add(CheckUpdatedTAT);

        // thêm nhập dữ liệu
// ========================================================================
        JTextField inputIdTATUpdate = new JTextField();
        inputIdTATUpdate.setBounds(VectorX, VectorY * 1, 250, 30);
        UpdateTAT.add(inputIdTATUpdate);

        JTextField inputNameTATUpdate = new JTextField();
        inputNameTATUpdate.setBounds(VectorX, VectorY * 2, 250, 30);
        UpdateTAT.add(inputNameTATUpdate);

        JTextField inputSlTATUpdate = new JTextField();
        inputSlTATUpdate.setBounds(VectorX, VectorY * 3, 250, 30);
        UpdateTAT.add(inputSlTATUpdate);

        JTextField inputCostTATUpdate = new JTextField();
        inputCostTATUpdate.setBounds(VectorX, VectorY * 4, 250, 30);
        UpdateTAT.add(inputCostTATUpdate);
//        ===============================================================================================       
        JTextField inputNsxTATDayUpdate = new JTextField();
        inputNsxTATDayUpdate.setBounds(VectorX, VectorY * 5, 50, 30);
        UpdateTAT.add(inputNsxTATDayUpdate);

        JTextField inputNsxTATMonthUpdate = new JTextField();
        inputNsxTATMonthUpdate.setBounds(VectorX + 100, VectorY * 5, 50, 30);
        UpdateTAT.add(inputNsxTATMonthUpdate);

        JTextField inputNsxTATYearUpdate = new JTextField();
        inputNsxTATYearUpdate.setBounds(VectorX + 200, VectorY * 5, 50, 30);
        UpdateTAT.add(inputNsxTATYearUpdate);
//        ===============================================================================================      
        JTextField inputHsdTATDayUpdate = new JTextField();
        inputHsdTATDayUpdate.setBounds(VectorX, VectorY * 6, 50, 30);
        UpdateTAT.add(inputHsdTATDayUpdate);

        JTextField inputHsdTATMonthUpdate = new JTextField();
        inputHsdTATMonthUpdate.setBounds(VectorX + 100, VectorY * 6, 50, 30);
        UpdateTAT.add(inputHsdTATMonthUpdate);

        JTextField inputHsdTATYearUpdate = new JTextField();
        inputHsdTATYearUpdate.setBounds(VectorX + 200, VectorY * 6, 50, 30);
        UpdateTAT.add(inputHsdTATYearUpdate);
//        ===============================================================================================             
        JTextField inputNhietDoTuDongUpdate = new JTextField();
        inputNhietDoTuDongUpdate.setBounds(VectorX, VectorY * 7, 250, 30);
        UpdateTAT.add(inputNhietDoTuDongUpdate);

        JTextField inputIDTuDongUpdate = new JTextField();
        inputIDTuDongUpdate.setBounds(VectorX, VectorY * 8, 250, 30);
        UpdateTAT.add(inputIDTuDongUpdate);

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

        CheckUpdatedTAT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < tat.size(); i++) {
                    if (inputIdTATUpdate.getText().equals(tat.get(i).getIdThucAn())) {
                        inputNameTATUpdate.setText(tat.get(i).getTenThucAn());
                        inputSlTATUpdate.setText(Integer.toString(tat.get(i).getSoLuong()));
                        inputCostTATUpdate.setText(Double.toString(tat.get(i).getGiaTien()));

                        inputNsxTATDayUpdate.setText(tat.get(i).getDayNsx());
                        inputNsxTATMonthUpdate.setText(tat.get(i).getMonthNsx());
                        inputNsxTATYearUpdate.setText(tat.get(i).getYearNsx());

                        inputHsdTATDayUpdate.setText(tat.get(i).getDayHsd());
                        inputHsdTATMonthUpdate.setText(tat.get(i).getMonthHsd());
                        inputHsdTATYearUpdate.setText(tat.get(i).getYearHsd());

                        inputNhietDoTuDongUpdate.setText(Double.toString(tat.get(i).getNhietDoTuDong()));
                        inputIDTuDongUpdate.setText(tat.get(i).getIDTuDong());
                    }

                }
            }
        });

        ConfirmUpdatedTAT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < tat.size(); i++) {
                    if (inputIdTATUpdate.getText().equals(tat.get(i).getIdThucAn())) {
                        tat.get(i).setTenThucAn(inputNameTATUpdate.getText());
                        tat.get(i).setSoLuong(Integer.parseInt(inputSlTATUpdate.getText()));
                        tat.get(i).setGiaTien(Double.parseDouble(inputCostTATUpdate.getText()));

                        tat.get(i).setNSX(Integer.parseInt(inputNsxTATYearUpdate.getText()), Integer.parseInt(inputNsxTATMonthUpdate.getText()), Integer.parseInt(inputNsxTATDayUpdate.getText()));
                        tat.get(i).setHSD(Integer.parseInt(inputHsdTATYearUpdate.getText()), Integer.parseInt(inputHsdTATMonthUpdate.getText()), Integer.parseInt(inputHsdTATDayUpdate.getText()));

                        tat.get(i).setNhietDoTuDong(Double.parseDouble(inputNhietDoTuDongUpdate.getText()));
                        tat.get(i).setIDTuDong(inputIDTuDongUpdate.getText());
                    }

                }
                UpdateTat();
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

        // thêm nút xác nhận
        JButton CheckUpdatedTADN = new JButton("Kiểm tra");
        CheckUpdatedTADN.setBounds(VectorX / 2, VectorY - 50, 250, 30);
        UpdateTADN.add(CheckUpdatedTADN);

        // thêm nhập dữ liệu
// ========================================================================
        JTextField inputIdTADNUpdate = new JTextField();
        inputIdTADNUpdate.setBounds(VectorX, VectorY * 1, 250, 30);
        UpdateTADN.add(inputIdTADNUpdate);

        JTextField inputNameTADNUpdate = new JTextField();
        inputNameTADNUpdate.setBounds(VectorX, VectorY * 2, 250, 30);
        UpdateTADN.add(inputNameTADNUpdate);

        JTextField inputSlTADNUpdate = new JTextField();
        inputSlTADNUpdate.setBounds(VectorX, VectorY * 3, 250, 30);
        UpdateTADN.add(inputSlTADNUpdate);

        JTextField inputCostTADNUpdate = new JTextField();
        inputCostTADNUpdate.setBounds(VectorX, VectorY * 4, 250, 30);
        UpdateTADN.add(inputCostTADNUpdate);

        //===============================================================================================       
        JTextField inputNsxTADNDayUpdate = new JTextField();
        inputNsxTADNDayUpdate.setBounds(VectorX, VectorY * 5, 50, 30);
        UpdateTADN.add(inputNsxTADNDayUpdate);

        JTextField inputNsxTADNMonthUpdate = new JTextField();
        inputNsxTADNMonthUpdate.setBounds(VectorX + 100, VectorY * 5, 50, 30);
        UpdateTADN.add(inputNsxTADNMonthUpdate);

        JTextField inputNsxTADNYearUpdate = new JTextField();
        inputNsxTADNYearUpdate.setBounds(VectorX + 200, VectorY * 5, 50, 30);
        UpdateTADN.add(inputNsxTADNYearUpdate);
        //===============================================================================================      
        JTextField inputHsdTADNDayUpdate = new JTextField();
        inputHsdTADNDayUpdate.setBounds(VectorX, VectorY * 6, 50, 30);
        UpdateTADN.add(inputHsdTADNDayUpdate);

        JTextField inputHsdTADNMonthUpdate = new JTextField();
        inputHsdTADNMonthUpdate.setBounds(VectorX + 100, VectorY * 6, 50, 30);
        UpdateTADN.add(inputHsdTADNMonthUpdate);

        JTextField inputHsdTADNYearUpdate = new JTextField();
        inputHsdTADNYearUpdate.setBounds(VectorX + 200, VectorY * 6, 50, 30);
        UpdateTADN.add(inputHsdTADNYearUpdate);
        //===============================================================================================   

        JTextField inputDoAmTADNUpdate = new JTextField();
        inputDoAmTADNUpdate.setBounds(VectorX, VectorY * 7, 250, 30);
        UpdateTADN.add(inputDoAmTADNUpdate);

        JTextField inputNhietDoKhoTADNUpdate = new JTextField();
        inputNhietDoKhoTADNUpdate.setBounds(VectorX, VectorY * 8, 250, 30);
        UpdateTADN.add(inputNhietDoKhoTADNUpdate);

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

        JLabel LabelNDKhoTADN = new JLabel("Nhiệt độ kho: ");
        LabelNDKhoTADN.setBounds(VectorX / 2, VectorY * 8, 250, 30);
        UpdateTADN.add(LabelNDKhoTADN);

        CheckUpdatedTADN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < tadn.size(); i++) {
                    if (inputIdTADNUpdate.getText().equals(tadn.get(i).getIdThucAn())) {
                        inputNameTADNUpdate.setText(tadn.get(i).getTenThucAn());
                        inputSlTADNUpdate.setText(Integer.toString(tadn.get(i).getSoLuong()));
                        inputCostTADNUpdate.setText(Double.toString(tadn.get(i).getGiaTien()));

                        inputNsxTADNDayUpdate.setText(tadn.get(i).getDayNsx());
                        inputNsxTADNMonthUpdate.setText(tadn.get(i).getMonthNsx());
                        inputNsxTADNYearUpdate.setText(tadn.get(i).getYearNsx());

                        inputHsdTADNDayUpdate.setText(tadn.get(i).getDayHsd());
                        inputHsdTADNMonthUpdate.setText(tadn.get(i).getMonthHsd());
                        inputHsdTADNYearUpdate.setText(tadn.get(i).getYearHsd());

                        inputDoAmTADNUpdate.setText(Double.toString(tadn.get(i).getDoAm()));
                        inputNhietDoKhoTADNUpdate.setText(Double.toString(tadn.get(i).getNhietDoKho()));

                    }

                }
            }
        });

        ConfirmUpdatedTADN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < tadn.size(); i++) {
                    if (inputIdTADNUpdate.getText().equals(tadn.get(i).getIdThucAn())) {
                        tadn.get(i).setTenThucAn(inputNameTADNUpdate.getText());
                        tadn.get(i).setSoLuong(Integer.parseInt(inputSlTADNUpdate.getText()));
                        tadn.get(i).setGiaTien(Double.parseDouble(inputCostTADNUpdate.getText()));

                        tadn.get(i).setNSX(Integer.parseInt(inputNsxTADNYearUpdate.getText()), Integer.parseInt(inputNsxTADNMonthUpdate.getText()), Integer.parseInt(inputNsxTADNDayUpdate.getText()));
                        tadn.get(i).setHSD(Integer.parseInt(inputHsdTADNYearUpdate.getText()), Integer.parseInt(inputHsdTADNMonthUpdate.getText()), Integer.parseInt(inputHsdTADNDayUpdate.getText()));

                        tadn.get(i).setDoAm(Double.parseDouble(inputDoAmTADNUpdate.getText()));
                        tadn.get(i).setNhietDoKho(Double.parseDouble(inputNhietDoKhoTADNUpdate.getText()));
                    }

                }
                UpdateTadn();
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
               UpdateTat();
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
                UpdateTadn();
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
        DocTadn();
        DocTat();
        Menu();
        XuatTat();
    }

     public static void XuLyHoaDon()
    {
//        listHoaDon listHoaDon = new listHoaDon();
        int ch=-1;
        int SoLuongThucAn = 0;
        boolean state = true;
        while(state)
        {
            System.out.println("\n\t\t\t\t=========== Danh Sach Hoa Don ===========");
            System.out.println("\t\t\t\t1. Nhap Hoa Don");
            System.out.println("\t\t\t\t2. Xuat Hoa Don");
            System.out.println("\t\t\t\t3. Thoat");
            
            ch = sc.nextInt();
            switch (ch) {
                case 1: 
                    System.out.println("So Luong Thuc An: "); SoLuongThucAn = sc.nextInt();
                    inputDSHD(1,1,SoLuongThucAn); 
                    break;
                    
                case 2: 
//                    System.out.println("So luong thuc an da nhap: " + SoLuongThucAn);
                    UpdateTP(SoLuongThucAn);   
                    break;
                case 3:
                    UpdateTadn();
                    UpdateTat();
                    state = false; 
                    break;
            }
        }
           
    }
     
     public static void inputDSHD(int countDSHD, int countHD, int countTA){
        for(int i = 0; i < countDSHD; i++)
        {
            Bill hoaDon = new Bill();
            hoaDon.nhapHD(countHD, countTA);
            listHoaDon.add(hoaDon);            
        }
    }

    public static void UpdateTP(int SoLuongThucAn){
     
        for(int j = 0; j < listHoaDon.size(); j++)
        {
            if(!"Thanh Cong".equals(listHoaDon.get(j).getTrangThai()))
            {
                for(int e = 0; e < SoLuongThucAn; e++)
                {
                    System.out.println("So Luong thu " + (e+1) + ": "  + listHoaDon.get(j).getSoLuongBill_tp(e));

        //                Thức ăn tươi
                    for(int k = 0; k < tat.size(); k++)
                    {
        //                    Check so luong va tu dong tru vao tat
                        if( tat.get(k).getTenThucAn().equals(listHoaDon.get(j).getTenThucAnBill_tp(e))  &&  tat.get(k).getSoLuong() - listHoaDon.get(j).getSoLuongBill_tp(e) >= 0)
                        {
                            tat.get(k).setSoLuong(tat.get(k).getSoLuong() - listHoaDon.get(j).getSoLuongBill_tp(e)); 
                                
                        }
                    }
//                    Thức Ăn dài ngày
                    for(int k = 0; k < tadn.size(); k++)
                    {
        //                    Check so luong va tu dong tru vao tat
                        if( tadn.get(k).getTenThucAn().equals(listHoaDon.get(j).getTenThucAnBill_tp(e))  &&  tadn.get(k).getSoLuong() - listHoaDon.get(j).getSoLuongBill_tp(e) >= 0)
                        {
                            tadn.get(k).setSoLuong(tadn.get(k).getSoLuong() - listHoaDon.get(j).getSoLuongBill_tp(e)); 
                                
                        }
                    }
                    
                }
                listHoaDon.get(j).setTrangThai("Thanh Cong");
            }
    
            listHoaDon.get(j).xuatHD();
        }
        
    }

    private static String BannerTat() {
        return "  " + "ID" +"\t"+ "Tên Thức Ăn"+ "\t"+ "Số Lượnng"+"\t"+ "Giá Tiền"+"\t"+ "NSX"+"\t"+ "HSD"+"\t"+ "Trạng Thái"+"\t"+ "Nhiệt độ tủ đông"+"\t"+ "ID Tủ Đông";
    }

   private static String BannerTadn() {
        return "  " + "ID"+"\t"+"Tên Thức Ăn"+"\t"+"Số Lượnng"+"\t"+ "Giá Tiền"+"\t"+ "NSX"+"\t"+ "HSD"+"\t"+"Trạng Thái"+"\t"+"Độ ẩm"+"\t"+ "Nhiệt độ kho";
    }
   private static void GhiTat()
   {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src\\QuanLyThucPham\\ThucAnTuoi.txt", true))) {
             for (ThucAnTuoi thucAn : tat) {
                 String line = thucAn.getIdThucAn() + ","
                    + thucAn.getTenThucAn() + ","
                    + thucAn.getSoLuong() + ","
                    + thucAn.getGiaTien() + ","
                    + thucAn.getDayHsd() + ","
                    + thucAn.getMonthHsd() + ","
                    + thucAn.getYearHsd() + ","     
                         
                    + thucAn.getDayNsx()+ ","
                    + thucAn.getMonthNsx()+ ","
                    + thucAn.getYearNsx()+ ","
                    + thucAn.getNhietDoTuDong()+ ","
                    + thucAn.getIDTuDong();
                    
                writer.write(line);
                writer.newLine();
            }
        } 
        catch (IOException ex) {
            System.out.println( ex.getMessage());
        }
   }
   
   private static void DocTat()
   {
        try (BufferedReader reader = new BufferedReader(new FileReader("src\\QuanLyThucPham\\ThucAnTuoi.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                ThucAnTuoi thucAn = new ThucAnTuoi();
                thucAn.setIdThucAn(fields[0]);
                thucAn.setTenThucAn(fields[1]);
                thucAn.setSoLuong(Integer.parseInt(fields[2]));
                thucAn.setGiaTien(Double.valueOf(fields[3]));
                thucAn.setHSD(Integer.parseInt(fields[6]),Integer.parseInt(fields[5]),Integer.parseInt(fields[4]));
                thucAn.setNSX(Integer.parseInt(fields[9]),Integer.parseInt(fields[8]),Integer.parseInt(fields[7]));
                thucAn.setIDTuDong(fields[11].toString());
                thucAn.setNhietDoTuDong(Double.valueOf(fields[10]));
                tat.add(thucAn);
            }
            if(tat != null )
            {
                System.out.println("Dữ liệu thức ăn tươi load thành công! ");
            }
            else{
                System.out.println("Dữ liệu thức ăn tươi trống");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
   }
   private static void UpdateTat()
   {
       try (BufferedWriter writer = new BufferedWriter(new FileWriter("src\\QuanLyThucPham\\ThucAnTuoi.txt", false))) {
           writer.write("");
           System.out.println("Xoa du lieu thanh cong!");
       } catch (IOException ex) {
           System.out.println("Co loi xay ra: " + ex.getMessage());
       }
       GhiTat();
   }
   private static void GhiTadn()
   {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src\\QuanLyThucPham\\ThucAnDaiNgay.txt", true))) {
             for (ThucAnDaiNgay thucAn : tadn) {
                 String line = thucAn.getIdThucAn() + ","
                    + thucAn.getTenThucAn() + ","
                    + thucAn.getSoLuong() + ","
                    + thucAn.getGiaTien() + ","
                    + thucAn.getDayHsd() + ","
                    + thucAn.getMonthHsd() + ","
                    + thucAn.getYearHsd() + ","     
                         
                    + thucAn.getDayNsx()+ ","
                    + thucAn.getMonthNsx()+ ","
                    + thucAn.getYearNsx()+ ","
                    + thucAn.getNhietDoKho()+ ","
                    + thucAn.getDoAm();
                    
                writer.write(line);
                writer.newLine();
            }
        } 
        catch (IOException ex) {
            System.out.println( ex.getMessage());
        }
   }
   private static void DocTadn()
   {
        try (BufferedReader reader = new BufferedReader(new FileReader("src\\QuanLyThucPham\\ThucAnDaiNgay.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                ThucAnDaiNgay thucAn = new ThucAnDaiNgay();
                thucAn.setIdThucAn(fields[0]);
                thucAn.setTenThucAn(fields[1]);
                thucAn.setSoLuong(Integer.parseInt(fields[2]));
                thucAn.setGiaTien(Double.valueOf(fields[3]));
                thucAn.setHSD(Integer.parseInt(fields[6]),Integer.parseInt(fields[5]),Integer.parseInt(fields[4]));
                thucAn.setNSX(Integer.parseInt(fields[9]),Integer.parseInt(fields[8]),Integer.parseInt(fields[7]));
                thucAn.setNhietDoKho(Double.valueOf(fields[11]));
                thucAn.setDoAm(Double.valueOf(fields[10]));
                tadn.add(thucAn);
            }
            if(tat != null )
            {
                System.out.println("Dữ liệu thức ăn dai ngay load thành công! ");
            }
            else{
                System.out.println("Dữ liệu thức ăn dai ngay trống");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
   }
   private static void UpdateTadn()
   {
       try (BufferedWriter writer = new BufferedWriter(new FileWriter("src\\QuanLyThucPham\\ThucAnDaiNgay.txt", false))) {
           writer.write("");
           System.out.println("Xoa du lieu thanh cong!");
       } catch (IOException ex) {
           System.out.println("Co loi xay ra: " + ex.getMessage());
       }
       GhiTadn();
   }

}
