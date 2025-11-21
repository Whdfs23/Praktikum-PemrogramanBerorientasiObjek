/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hirearki_Pewarian;

/**
 *
 * @author LENOVO
 */
public class KendaraanDarat extends Kendaraan {
    int jumlahRoda;

    public KendaraanDarat(String nama, int jumlahRoda) {
        super(nama); // Memanggil constructor superclass
        this.jumlahRoda = jumlahRoda;
    }

    public void infoDarat() {
        System.out.println("Kendaraan darat ini memiliki " + jumlahRoda + " roda.");
    }
}