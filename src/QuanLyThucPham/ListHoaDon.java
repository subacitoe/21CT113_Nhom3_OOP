/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyThucPham;

import java.util.ArrayList;


/**
 *
 * @author SUBACITO
 */
public class ListHoaDon {
    ArrayList<Bill> listHoaDon = new ArrayList<>();    
    ThucAnTuoi tat = new ThucAnTuoi();
      public ArrayList<Bill> getListHoaDon() {
        return listHoaDon;
    }

    public void setListHoaDon(ArrayList<Bill> listHoaDon) {
        this.listHoaDon = listHoaDon;
    }

    public ListHoaDon() {
    }

    public ListHoaDon(ArrayList<Bill> listHoaDon) {
        this.listHoaDon = listHoaDon;
    }

    public void NhapDS(int countDSHD, int countHD, int countTA){
        for(int i = 0; i < countDSHD; i++)
        {
            Bill hoaDon = new Bill();
            hoaDon.nhapHD(countHD, countTA);
                listHoaDon.add(hoaDon);            
        }
    }
    public void XuatDS(){
        int i=0;
        for(Bill hoaDon : listHoaDon){
            i+=1;
            System.out.println("----- Hoa Don Thu "+(i));
            hoaDon.xuatHD();
        }
        
    }
}
