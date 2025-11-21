/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pegawai;

/**
 *
 * @author LENOVO
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("--- Data Pegawai Biasa ---");
        // Membuat objek Pegawai biasa
        Pegawai staff = new Pegawai("Budi", 5000000);
        staff.tampilkanInfo();

        System.out.println("\n--- Data Dosen ---");
        // Membuat objek Dosen
        Dosen dosenA = new Dosen("Dr. Ani", 7000000, "Basis Data");
        dosenA.tampilkanInfo();
    }
}
