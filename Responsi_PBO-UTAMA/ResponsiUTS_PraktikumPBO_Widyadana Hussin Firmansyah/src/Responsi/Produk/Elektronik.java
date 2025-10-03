/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responsi.Produk;

/**
 *
 * @author LENOVO
 */
public class Elektronik extends Produk{
    private int garansi; // dalam tahun
    public Elektronik(String namaProduk, long harga, int garansi) {
        super(namaProduk, harga); // Memanggil constructor Produk dengan tipe data long
        this.garansi = garansi;
    }
    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo(); // Menampilkan Nama dan Harga
        System.out.println("Garansi: " + this.garansi + " tahun");
    } 
}
