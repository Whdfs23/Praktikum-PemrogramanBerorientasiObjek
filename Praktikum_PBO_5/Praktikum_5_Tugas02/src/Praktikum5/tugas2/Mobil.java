/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Praktikum5.tugas2;

/**
 *
 * @author LENOVO
 */
public class Mobil extends KendaraanDarat {
    int jumlahPintu;

    @Override
    public void tampilkanInfo() {
        tampilkanInfoDarat();
        System.out.println("Jumlah Pintu: " + jumlahPintu);
    }
}
