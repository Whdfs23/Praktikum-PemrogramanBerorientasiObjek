/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Praktikum5.tugas2;

/**
 *
 * @author LENOVO
 */
public class MainTugas2 {
    public static void main(String[] args) {
        System.out.println("--- Informasi Mobil ---");
        Mobil mobil = new Mobil();
        mobil.nama = "Honda Jazz";
        mobil.kecepatan = 160;
        mobil.jumlahRoda = 4;
        mobil.jumlahPintu = 4;
        mobil.tampilkanInfo();
        System.out.println();

        System.out.println("--- Informasi Sepeda Motor ---");
        SepedaMotor motor = new SepedaMotor();
        motor.nama = "Suzuki Satria F150";
        motor.kecepatan = 140;
        motor.jumlahRoda = 2;
        motor.jenisMesin = "4-tak";
        motor.tampilkanInfo();
    }
}
