/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyThucPham;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author SUBACITO
 */
public class Bill extends ThucPham implements Serializable{
    ListThucPham listThucAn= new ListThucPham();
    private String mahd;
    private String trangThai;
    public Bill() {
        super();
    }
    public Bill(String tenThucAn, String idThucAn, int soLuong, Double giaTien, Date nsx, Date hsd, String mahd, ListThucPham listThucAn, String trangThai) {
        super(tenThucAn,  idThucAn,  soLuong,  giaTien,  nsx, hsd);
        this.mahd = mahd;
        this.listThucAn = listThucAn;
    }   
    
    public String getMahd() {
        return mahd;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }
    
     public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    public void nhapHD(int countHD, int countTAT)
    {
        for(int i = 0; i < countHD; i++)
        {
            sc.nextLine();
            System.out.println("Nhap Ma Hoa Don: "); this.mahd = sc.nextLine();
            System.out.println("-Thuc An - ");
            listThucAn.nhapDS(countTAT);
            System.out.println("Nhap Thanh Cong Hoa Don " + (i+1));
        }
        
    }
    

    public int getSoLuongBill_tp(int index)
    {
        return listThucAn.getSoLuongHere(index);
    }
    public String getTenThucAnBill_tp(int index) {
        return listThucAn.getTenThucAnHere(index);
    }
    
        public void xuatHD()
    {
        System.out.println("--------------------------------------------------");
        System.out.println("Ma hd: " + this.mahd);
        System.out.println("Ten" +"\t\t"+ "So luong" + "\t" + "Gia tien");
        listThucAn.xuatDS();
        System.out.println("Total: " + listThucAn.Total());     
        System.out.println("--------------------------------------------------");
        System.out.println(this.trangThai);

    }
    
   
    
}
