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

        // Bagian 1: Output Produk
        System.out.println("1. Output Produk");
        Elektronik produk1 = new Elektronik("Laptop", 15000000L, 2); // 'L' menandakan tipe data long
        produk1.tampilkanInfo();

        System.out.println(); // Baris kosong sebagai pemisah

        // Bagian 2: Output Pegawai
        System.out.println("2. Output Pegawai");
        // Ganti "Budi" dengan nama Anda
        PegawaiTetap pegawai1 = new PegawaiTetap("Budi", 5000000L, 1000000L);
        pegawai1.tampilkanInfo();

        System.out.println(); // Baris kosong sebagai pemisah

        // Bagian 3: Output Polimorfisme
        System.out.println("3. Output Polimorfisme");
        Makanan produk2 = new Makanan("Snack", 15000L, "2023-12-30");
        produk2.tampilkanInfo();
        
        System.out.println(); // Baris kosong untuk memisahkan output Snack dan Andi
        
        PegawaiKontrak pegawai2 = new PegawaiKontrak("Andi", 3000000L, 12);
        pegawai2.tampilkanInfo();
    }
}
