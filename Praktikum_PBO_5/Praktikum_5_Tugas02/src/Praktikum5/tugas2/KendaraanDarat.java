/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Praktikum5.tugas2;

/**
 *
 * @author LENOVO
 */
public class KendaraanDarat extends Kendaraan  {
    int jumlahRoda;

    public void tampilkanInfoDarat() {
        super.tampilkanInfo();
        System.out.println("Jumlah Roda: " + jumlahRoda);
    }
}
