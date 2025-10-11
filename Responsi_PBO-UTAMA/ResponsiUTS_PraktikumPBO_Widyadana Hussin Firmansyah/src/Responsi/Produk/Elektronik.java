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
    private int garansi; 
    public Elektronik(String namaProduk, long harga, int garansi) {
        super(namaProduk, harga); 
        this.garansi = garansi;
    }
    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo(); 
        System.out.println("Garansi: " + this.garansi + " tahun");
    } 
}
