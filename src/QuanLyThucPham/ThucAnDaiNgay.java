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
public class ThucAnDaiNgay extends ThucPham implements Serializable{
    private Double DoAm;
    private Double NhietDoKho;

    public ThucAnDaiNgay(Double DoAm, Double NhietDoKho) {
        super();
        this.DoAm = DoAm;
        this.NhietDoKho = NhietDoKho;
    }
    public ThucAnDaiNgay() {
        super();
    }

    public Double getDoAm() {
        return DoAm;
    }

    public void setDoAm(Double DoAm) {
        this.DoAm = DoAm;
    }

    public Double getNhietDoKho() {
        return NhietDoKho;
    }

    public void setNhietDoKho(Double NhietDoKho) {
        this.NhietDoKho = NhietDoKho;
    }

     public void xuatTat()
    {
        super.xuat();
    }
    @Override
    public String toString() {
        return super.toString() + "\t" + this.DoAm + "\t" +this.NhietDoKho;
    }
    
    public void input() {
        super.input();
        System.out.println("DoAm: ");
        DoAm = sc.nextDouble();
        System.out.println("NhietDoKho: ");
        NhietDoKho = sc.nextDouble();
 
    }
    
    
}
