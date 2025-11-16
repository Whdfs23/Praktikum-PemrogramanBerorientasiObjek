/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Praktikum_10;

/**
 *
 * @author LENOVO
 */
public class Main_Tugas10{
    public static void main(String[] args) {
        Pembayaran elektronik = new Elektronik();
        Pembayaran makanan = new Makanan();

        double hargaElektronik = 2000000;
        double hargaMakanan = 50000;     

        System.out.println("Pajak Elektronik: Rp" + elektronik.hitungPajak(hargaElektronik));
        System.out.println("Pajak Makanan: Rp" + makanan.hitungPajak(hargaMakanan));
    }
}
