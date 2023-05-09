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
public class ListThucPham{
    ArrayList<ThucPham> listTP= new ArrayList<>() ; //
    public ListThucPham(ArrayList<ThucPham> listTP) {
        this.listTP = listTP;
    }
    public ListThucPham(){ listTP= new ArrayList<>();}

    public ArrayList<ThucPham> getListSM() {
        return listTP;
    }
     public void setListSM(ArrayList<ThucPham> listTP) {
        this.listTP = listTP;
    }
     
    public void nhapDS(int count){
            for(int i = 0; i < count; i++)
            {
                ThucPham x = new ThucPham();
                x.input();
                listTP.add(x);
            }
    }
    public int getSoLuongHere(int index){
        return listTP.get(index).getSoLuong();
    }
      public String getTenThucAnHere(int index){
        return listTP.get(index).getTenThucAn();
    }
    
    public double Total()
    {
        int sum = 0;
        for (ThucPham tp : listTP) {
            sum += tp.getGiaTien() * tp.getSoLuong();
        }
        return sum;
    }
    public void xuatDS(){
        for( ThucPham tp : listTP){
            tp.xuat();
        }
    }
}
