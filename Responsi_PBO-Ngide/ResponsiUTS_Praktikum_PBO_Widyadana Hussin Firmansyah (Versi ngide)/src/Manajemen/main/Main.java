/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manajemen.main;
import Manajemen.pegawai.PegawaiKontrak;
import Manajemen.pegawai.PegawaiTetap;
import Manajemen.produk.Elektronik;
import Manajemen.produk.Makanan;
import Manajemen.produk.Produk;

/**
 *
 * @author LENOVO
 */
 public class Main {
    public static void main(String[] args) {
        System.out.println("===== SISTEM MANAJEMEN PRODUK DAN PEGAWAI =====");

        System.out.println("\n--- Informasi Produk ---");

        Elektronik laptop = new Elektronik("Laptop Gaming ROG", 15000000, 2);
        Makanan snack = new Makanan("Keripik Kentang", 15000, "2025-12-30");
        
        laptop.tampilkanInfo();
        System.out.println("------------------------");
        snack.tampilkanInfo();

        System.out.println("\n--- Informasi Pegawai ---");
        
        PegawaiTetap pegawai1 = new PegawaiTetap("Budi Sanjaya", 5000000, 1000000);
        PegawaiKontrak pegawai2 = new PegawaiKontrak("Andi Pratama", 3000000, 12);

        pegawai1.tampilkanInfo();
        System.out.println("------------------------");
        pegawai2.tampilkanInfo();

        System.out.println("\n\n--- Demonstrasi Polimorfisme ---");
        Produk[] keranjangBelanja = new Produk[2];
        keranjangBelanja[0] = new Elektronik("Smartphone Flagship", 20000000, 1);
        keranjangBelanja[1] = new Makanan("Cokelat Batang", 25000, "2026-08-17");

        for (Produk item : keranjangBelanja) {
            System.out.println("------------------------");
            item.tampilkanInfo();
        }
    }
}
