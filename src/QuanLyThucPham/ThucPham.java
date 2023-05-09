/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyThucPham;

/**
 *
 * @author SUBACITO
 */
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class ThucPham implements Serializable {

    static Scanner sc = new Scanner(System.in);
//    Khai-bao
    private String tenThucAn;
    private String idThucAn;
    private int soLuong;
    private Double giaTien;
    private Date nsx, hsd;
    private String trangThai;

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
//Consrtuctor thamso

    public ThucPham(String tenThucAn, String idThucAn, int soLuong, Double giaTien, Date nsx, Date hsd) {
        this.tenThucAn = tenThucAn;
        this.idThucAn = idThucAn;
        this.soLuong = soLuong;
        this.giaTien = giaTien;
        this.nsx = nsx;
        this.hsd = hsd;
    }
//Consrtuctor default

    public ThucPham() {
    }
//    Getter va Setter

    public String getTenThucAn() {
        return tenThucAn;
    }

    public void setTenThucAn(String tenThucAn) {
        this.tenThucAn = tenThucAn;
    }

    public String getIdThucAn() {
        return idThucAn;
    }

    public void setIdThucAn(String idThucAn) {
        this.idThucAn = idThucAn;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(Double giaTien) {
        this.giaTien = giaTien;
    }

    public Date getNsx() {
        return nsx;
    }

    public void setNsx(Date nsx) {
        this.nsx = nsx;
    }

    public Date getHsd() {
        return hsd;
    }

    public void setHsd(Date hsd) {
        this.hsd = hsd;
    }
//NSX

    public void setNSX(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        this.nsx = calendar.getTime();
    }

    public String getDayNsx() {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd");
        String dayNSX = simpleDateFormat.format(nsx);
        return dayNSX;
    }

    public String getMonthNsx() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM");
        String monthNSX = simpleDateFormat.format(nsx);
        return monthNSX;
    }

    public String getYearNsx() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
        String yearNSX = simpleDateFormat.format(nsx);
        return yearNSX;
    }

//HSD
    public void setHSD(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        this.hsd = calendar.getTime();
    }

    public String getDayHsd() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd");
        String dayHsd = simpleDateFormat.format(hsd);
        return dayHsd;
    }

    public String getMonthHsd() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM");
        String monthHsd = simpleDateFormat.format(hsd);
        return monthHsd;
    }

    public String getYearHsd() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
        String yearHsd = simpleDateFormat.format(hsd);
        return yearHsd;
    }

    public void kiemTraHSD() {

        Date today = new Date();
        today.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String st = simpleDateFormat.format(today);
        if (this.getHsd().compareTo(today) < 0) {
//            System.out.print("Hien tai: " + st + ", thuc pham da het han! ");
            setTrangThai("Hết hạn");
        } else {
//            System.out.print("Hien tai: " + st + ", thuc pham van con han ");
            setTrangThai("Còn hạn");
        }

    }

    public void xuat()
    { 
        System.out.println(this.tenThucAn + "\t\t" + this.soLuong + "\t\t" + this.giaTien + " * " + this.soLuong );
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String date1 = simpleDateFormat.format(nsx);
        String date2 = simpleDateFormat.format(hsd);
        return "  "+ this.idThucAn +"\t"+ this.tenThucAn+"\t"+ this.soLuong+"\t"+ this.giaTien+"\t"+ date1+"\t"+ date2+"\t"+ this.trangThai;

    }
  
      public void input() {
        sc.nextLine();
        System.out.println("Nhap ten: ");
        tenThucAn = sc.nextLine();
        System.out.println("Nhap so luong:");
        soLuong = sc.nextInt();
        System.out.println("Nhap gia tien: ");
        giaTien = sc.nextDouble();
    }

}
