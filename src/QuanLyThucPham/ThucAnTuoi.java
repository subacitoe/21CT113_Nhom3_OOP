/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyThucPham;

import java.io.Serializable;




/**
 *
 * @author SUBACITO
 */
public class ThucAnTuoi extends ThucPham implements Serializable {
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


   @Override
   public String toString()
   {
       return super.toString() + String.format("%30s %30s ", this.NhietDoTuDong, this.IDTuDong);
   }
    
}
