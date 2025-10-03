/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responsi.Pegawai;

/**
 *
 * @author LENOVO
 */
public class Pegawai {
       private String namaPegawai;
    private long gaji; // Menggunakan long

    public Pegawai(String namaPegawai, long gaji) {
        this.namaPegawai = namaPegawai;
        this.gaji = gaji;
    }

    // Getter dan Setter
    public String getNamaPegawai() {
        return namaPegawai;
    }

    public void setNamaPegawai(String namaPegawai) {
        this.namaPegawai = namaPegawai;
    }

    public long getGaji() {
        return gaji;
    }

    public void setGaji(long gaji) {
        this.gaji = gaji;
    }

    // Metode ini diubah untuk mencetak "Gaji" bukan "Gaji Pokok".
    public void tampilkanInfo() {
        System.out.println("Nama Pegawai: " + this.namaPegawai);
        System.out.println("Gaji: " + this.gaji);
    }
}
