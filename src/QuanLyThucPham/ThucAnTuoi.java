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
    private String idKho;
    private String idCtyNhap; 

    public ThucAnTuoi(String idKho, String idCtyNhap) {
        super();
        this.idKho = idKho;
        this.idCtyNhap = idCtyNhap;
    }

    public ThucAnTuoi() {
        super();
    }

    public String getIdKho() {
        return idKho;
    }

    public void setIdKho(String idKho) {
        this.idKho = idKho;
    }

    public String getIdCtyNhap() {
        return idCtyNhap;
    }

    public void setIdCtyNhap(String idCtyNhap) {
        this.idCtyNhap = idCtyNhap;
    }

    @Override
    public void input()
    {
        super.input();
        sc.nextLine();
        System.out.println("Nhap Kho: "); idKho = sc.nextLine();
        System.out.println("Nhap Cty: "); idCtyNhap = sc.nextLine();

    }
    
   @Override
   public String toString()
   {
       return super.toString() + String.format("%30s %30s ", this.idKho, this.idCtyNhap);
   }
    
}
