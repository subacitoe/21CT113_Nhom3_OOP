/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyThucPham;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Scanner;



/**
 *
 * @author SUBACITO
 */
public class ThucAnTuoi extends ThucPham implements Serializable {
    static Scanner sc = new Scanner(System.in);
    private Double NhietDoTuDong;
    private String IDTuDong; 

    public ThucAnTuoi(Double NhietDoTuDong, String IDTuDong) {
        super();
        this.NhietDoTuDong = NhietDoTuDong;
        this.IDTuDong = IDTuDong; 
    }
    public ThucAnTuoi()
    {
        super();
    }

    public Double getNhietDoTuDong() {
        return NhietDoTuDong;
    }

    public void setNhietDoTuDong(Double NhietDoTuDong) {
        this.NhietDoTuDong = NhietDoTuDong;
    }

    public String getIDTuDong() {
        return IDTuDong;
    }

    public void setIDTuDong(String IDTuDong) {
        this.IDTuDong = IDTuDong;
    }
    public void xuatTat()
    {
        super.xuat();
    }
    @Override
    public void input() {
        super.input();

    }
   @Override
   public String toString()
   {
       return super.toString() + "\t" + this.NhietDoTuDong +"\t\t"+ this.IDTuDong;
   }

    void setHSD(LocalDate parse) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void setNSX(LocalDate parse) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
