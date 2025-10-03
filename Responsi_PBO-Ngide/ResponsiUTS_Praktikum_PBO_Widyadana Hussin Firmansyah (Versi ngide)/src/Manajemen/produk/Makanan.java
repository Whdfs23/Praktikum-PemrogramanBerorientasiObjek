/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manajemen.produk;

/**
 *
 * @author LENOVO
 */
public class Makanan extends Produk {
    private String tanggalKadaluarsa;
    public Makanan(String namaProduk, double harga, String tanggalKadaluarsa) {
        super(namaProduk, harga);
        this.tanggalKadaluarsa = tanggalKadaluarsa;
    }
    
    public String getTanggalKadaluarsa() {
        return this.tanggalKadaluarsa;
    }

    // OVERRIDING method dari superclass
    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo(); // Memanggil implementasi dari kelas Produk
        System.out.println("Tanggal Kadaluarsa: " + this.tanggalKadaluarsa);
    }
}
