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

public class Login extends JFrame implements ActionListener {
    JLabel l1, l2;
    JTextField tf1;
    JPasswordField tf2;
    JButton btn1;
    
    Login() {
        l1 = new JLabel("Username:");
        l1.setBounds(50, 50, 100, 30);
        l2 = new JLabel("Password:");
        l2.setBounds(50, 100, 100, 30);
        tf1 = new JTextField();
        tf1.setBounds(150, 50, 150, 30);
        tf2 = new JPasswordField();
        tf2.setBounds(150, 100, 150, 30);
        btn1 = new JButton("Login");
        btn1.setBounds(100, 150, 100, 30);
        btn1.addActionListener(this);
        add(l1);
        add(tf1);
        add(l2);
        add(tf2);
        add(btn1);
        setSize(400, 250);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        String username = tf1.getText();
        String password = tf2.getText();
        if (username.equals("admin") && password.equals("admin")) {
            JOptionPane.showMessageDialog(this, "Login Successful");
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password");
        }
    }
    
    public static void main(String[] args) {
        new Login();
    }
}

