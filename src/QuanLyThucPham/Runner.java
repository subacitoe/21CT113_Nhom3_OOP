/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyThucPham;

/**
 *
 * @author SUBACITO
 */
import java.util.Scanner;
public class Runner {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        ThucPham tp[] = null;
        int n = 0;
        int _choice = 0;
        boolean state = true;
        String idCanTim;
        String idCanXoa;
        
        while(state)
        {
            System.out.println("1. Nhap thong tin thuc pham!");
            System.out.println("2. Xuat thong tin thuc pham!");
            System.out.println("3. Tim thong tin thuc pham ID!");
            System.out.println("4. Xoa thong tin thuc pham theo ID!");
            System.out.println("Lua chon cua ban: "); _choice = sc.nextInt();
            
            switch(_choice)
            {
                case 1:
                    int _loaiTP = 0;
                    System.out.println("Nhap so luong thuc pham: "); n = sc.nextInt();
                    tp = new ThucPham[n];
                    
                    for(int i = 0; i < n; i++)
                    {
                        System.out.println("Thong tin thuc pham thu " + (i+1));
                        System.out.println("1. Thuc an tuoi!");
                        System.out.println("2. Thuc an dai ngay!");
                        _loaiTP = sc.nextInt();
                        
                        if(_loaiTP == 1)
                        {
                            tp[i] = new ThucAnTuoi();
                        }
                        tp[i].input();
                    }
                    break;
                case 2:
                    for(int i = 0; i < n; i++)
                    {
                        System.out.println("Thong tin thuc an");
                        System.out.println(tp[i].toString());
                        tp[i].kiemTraHSD();
                    }
                    break;
                case 3:
                    
                    System.out.println("Nhap id can tim: "); sc.nextLine();
                    idCanTim = sc.nextLine();
                    for (int i = 0; i < n; i++) {
                        if(tp[i].getIdThucAn().equals(idCanTim))
                        {
                            System.out.println("Thang cong!");
                            System.out.println(tp[i].toString());
                        }
                        else
                            System.out.println("Khong Tim Thay!");
                    }
                    break;
                case 4:
                    System.out.println("Nhap id can xoa: "); sc.nextLine();
                    idCanXoa = sc.nextLine();
                    for (int i = 0; i < n; i++) {
                        if(tp[i].getIdThucAn().equals(idCanXoa))
                        {
                            System.out.println("Da Xoa Thang cong: ");
                            System.out.print(tp[i].toString());
                            tp[i] = null;
                            System.out.println(tp[i].toString());
                        }
                        else
                            System.out.println("Khong Tim Thay!");
                    }
                    break;
            }
        }
    }
}
