/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pegawai;

/**
 *
 * @author LENOVO
 */
public class Pegawai {
    // Ini adalah kelas 'induk' atau 'superclass'
    // Kita buat private agar terjaga (enkapsulasi),
    // tapi 'protected' juga bisa agar kelas anak bisa akses langsung.
    // Di sini saya pakai private saja biar lebih aman.
    private String nama;
    private double gaji;

    // Constructor untuk Pegawai
    public Pegawai(String nama, double gaji) {
        this.nama = nama;
        this.gaji = gaji;
    }

    // Method dasar yang dimiliki semua pegawai
    public void tampilkanInfo() {
        System.out.println("Nama   : " + this.nama);
        System.out.println("Gaji   : Rp " + this.gaji);
    }
}
