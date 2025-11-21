/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pbo_3;

/**
 *
 * @author LENOVO
 */
public class Main {
    public static void main(String[] args) {
    Mobil mobil1 = new Mobil("Lamborghini", "Aventador SJV Roadster", 2020, "Biru");
    Mobil mobil2 = new Mobil ("BMW", "e36", 1997, "Abu-abu");
    Mobil mobil3 = new Mobil("Ferrari", "F40", 1990, "Merah");

    mobil1.tampilkanDetail();
    System.out.println();
    mobil2.tampilkanDetail();
    System.out.println();
    mobil3.tampilkanDetail();
    System.out.println();

    mobil1.mulaiMesin();
    mobil2.mulaiMesin();
    mobil3.mulaiMesin();
    System.out.println();

    System.out.println("-Perubahan Data-");
    System.out.println("Mengubah warna mobil menjadi hijau.");
        
    mobil1.setWarnaCat("Hijau");
        
    System.out.println("Mengubah tahun rilis mobil menjadi 2019.");
    mobil1.setTahunProduksi(2019);

    mobil1.tampilkanDetail();
   }
}

