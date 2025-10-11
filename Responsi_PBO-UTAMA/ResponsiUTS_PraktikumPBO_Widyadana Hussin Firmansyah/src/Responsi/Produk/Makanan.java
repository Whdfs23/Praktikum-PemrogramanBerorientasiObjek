/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responsi.Produk;

/**
 *
 * @author LENOVO
 */
public class Makanan extends Produk {
    private String tanggalKadaluarsa;

    public Makanan(String namaProduk, long harga, String tanggalKadaluarsa) {
        super(namaProduk, harga); 
        this.tanggalKadaluarsa = tanggalKadaluarsa;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo(); 
        System.out.println("Tanggal Kadaluarsa: " + this.tanggalKadaluarsa);
    } 
}
