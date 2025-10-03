/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responsi.Pegawai;

/**
 *
 * @author LENOVO
 */
public class PegawaiKontrak extends Pegawai {
    private int lamaKontrak; // dalam bulan

    public PegawaiKontrak(String namaPegawai, long gaji, int lamaKontrak) {
        super(namaPegawai, gaji);
        this.lamaKontrak = lamaKontrak;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo(); // Menampilkan Nama dan Gaji
        System.out.println("Lama Kontrak: " + this.lamaKontrak + " bulan");
    }
}