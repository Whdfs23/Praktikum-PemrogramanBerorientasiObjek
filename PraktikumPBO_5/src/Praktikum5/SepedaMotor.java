/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Praktikum5;

/**
 *
 * @author LENOVO
 */
class SepedaMotor extends Kendaraan {
    String jenisMesin;
    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo(); // Memanggil metode dari kelas Kendaraan
        System.out.println("Jenis Mesin: " + jenisMesin);
    }
}
