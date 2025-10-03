/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manajemen.produk;

/**
 *
 * @author LENOVO
 */
public class Elektronik extends Produk {
    
    private int garansi; // dalam tahun

    public Elektronik(String namaProduk, double harga, int garansi) {
        super(namaProduk, harga);
        this.garansi = garansi;
    }
    
    public int getGaransi() {
        return this.garansi;
    }
    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo(); 
        System.out.println("Garansi: " + this.garansi + " tahun");
    }
}
