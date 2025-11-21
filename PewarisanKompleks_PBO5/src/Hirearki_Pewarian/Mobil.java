/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hirearki_Pewarian;

/**
 *
 * @author LENOVO
 */
public class Mobil extends KendaraanDarat {
    int jumlahPintu;

    public Mobil(String nama, int jumlahRoda, int jumlahPintu) {
        super(nama, jumlahRoda);
        this.jumlahPintu = jumlahPintu;
    }

    public void infoMobil() {
        System.out.println("Mobil ini memiliki " + jumlahPintu + " pintu.");
    }
}
