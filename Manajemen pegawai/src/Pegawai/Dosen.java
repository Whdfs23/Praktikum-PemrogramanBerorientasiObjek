/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pegawai;

/**
 *
 * @author LENOVO
 */
 // Ini adalah kelas 'anak' atau 'subclass' yang mewarisi Pegawai
public class Dosen extends Pegawai {
    // Atribut tambahan yang hanya dimiliki Dosen
    private String mataKuliah;

    /**
     * Constructor untuk Dosen.
     * Kita harus memanggil constructor induknya (Pegawai)
     * menggunakan 'super()'.
     */
    public Dosen(String nama, double gaji, String mataKuliah) {
        // 'super(nama, gaji)' ini memanggil constructor Pegawai
        // untuk mengisi atribut nama dan gaji.
        super(nama, gaji);
        
        // Mengisi atribut spesifik milik Dosen
        this.mataKuliah = mataKuliah;
    }

    /**
     * Kita bisa 'menimpa' (Override) method tampilkanInfo()
     * milik induknya agar lebih spesifik untuk Dosen.
     */
    @Override
    public void tampilkanInfo() {
        // Panggil dulu method 'tampilkanInfo()' asli dari Pegawai
        // agar kita tidak perlu menulis ulang kode untuk nama dan gaji.
        super.tampilkanInfo();
        
        // Tambahkan info spesifik milik Dosen
        System.out.println("Mengajar: " + this.mataKuliah);
    }
}
