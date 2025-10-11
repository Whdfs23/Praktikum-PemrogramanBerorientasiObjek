/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main.Responsi;
import Responsi.Pegawai.PegawaiKontrak;
import Responsi.Pegawai.PegawaiTetap;
import Responsi.Produk.Elektronik;
import Responsi.Produk.Makanan;
/**
 *
 * @author LENOVO
 */
public class Main {
    public static void main(String[] args) {

        System.out.println("1. Output Produk");
        Elektronik produk1 = new Elektronik("Laptop", 15000000L, 2); // 'L' karena saya menggunakan tipe data 'long'.
        produk1.tampilkanInfo();

        System.out.println(); 

        System.out.println("2. Output Pegawai");
        PegawaiTetap pegawai1 = new PegawaiTetap("Widyadana Hussin Firmansyah", 5000000L, 1000000L);
        pegawai1.tampilkanInfo();

        System.out.println();
        
        System.out.println("3. Output Polimorfisme");
        Makanan produk2 = new Makanan("Snack", 15000L, "2023-12-30");
        produk2.tampilkanInfo();
        
        System.out.println();
        
        PegawaiKontrak pegawai2 = new PegawaiKontrak("Andi", 3000000L, 12);
        pegawai2.tampilkanInfo();
    }
}
