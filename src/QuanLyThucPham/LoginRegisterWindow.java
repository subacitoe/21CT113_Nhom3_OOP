/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyThucPham;

/**
 *
 * @author MYPC
 */
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class LoginRegisterWindow extends JFrame implements ActionListener {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JComboBox<String> accessComboBox;
    private JButton loginButton;
    private JButton registerButton;
    private ArrayList<User> userList;

    public LoginRegisterWindow() {
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
        accessComboBox = new JComboBox<String>(new String[]{"Người dùng", "Quản trị viên"});
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

        // Tạo danh sách để lưu trữ thông tin người dùng
        userList = new ArrayList<User>();
    }

    // Xử lý sự kiện khi nút đăng nhập hoặc đăng ký được nhấn
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            // Lấy thông tin người dùng từ các field
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            // Kiểm tra thông tin đăng nhập
            boolean found = false;
            for (User user : userList) {
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    JOptionPane.showMessageDialog(this, "Đăng nhập thành công!");
                    found = true;
                    break;
                }
            }
            if (!found) {
                JOptionPane.showMessageDialog(this, "Tên người dùng hoặc mật khẩu không chính xác!");
            }
        } else if (e.getSource() == registerButton) {
            // Lấy thông tin người dùng từ các field
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            String access = (String) accessComboBox.getSelectedItem();

            // Thêm người dùng vào danh sách
            userList.add(new User(username, password, access));
            JOptionPane.showMessageDialog(this, "Đăng ký thành công!");
        }
    }

// Class User để lưu trữ thông tin người dùng
    private class User {

        private String username;
        private String password;
        private String access;

        public User(String username, String password, String access) {
            this.username = username;
            this.password = password;
            this.access = access;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        public String getAccess() {
            return access;
        }
    }

    public static void main(String[] args) {
        LoginRegisterWindow window = new LoginRegisterWindow();
        window.setVisible(true);
    }
}
