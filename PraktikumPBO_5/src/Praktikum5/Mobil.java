/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Praktikum5;

/**
 *
 * @author LENOVO
 */
class Mobil extends Kendaraan {
    int jumlahPintu;
    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo(); // Memanggil metode dari kelas Kendaraan
        System.out.println("Jumlah Pintu: " + jumlahPintu);
    }
}
