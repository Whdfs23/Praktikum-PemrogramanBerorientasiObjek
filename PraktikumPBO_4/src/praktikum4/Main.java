/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum4;

/**
 *
 * @author LENOVO
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("--- Penerapan Enkapsulasi (Langkah 1-3) ---");
        Kendaraan mobil = new Kendaraan("Toyota", 150, "Bensin");
        System.out.println("Nama Kendaraan: " + mobil.getNama());
        System.out.println("Jenis Mesin: " + mobil.jenisMesin);
        mobil.setNama("Daihatsu");
        System.out.println("\nNama baru: " + mobil.getNama());

        System.out.println("\n--- Penerapan Akses Modifier (Langkah 4-6) ---");
        Mobil mobilBaru = new Mobil("Honda", 180, "Bensin", 4);
        mobilBaru.tampilkanInfoKendaraan();
        mobilBaru.tampilkanInfoMobil();
        System.out.println("\nJenis Mesin (akses langsung): " + mobilBaru.jenisMesin);
    }
}
