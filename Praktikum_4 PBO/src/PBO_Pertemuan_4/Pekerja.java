/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PBO_Pertemuan_4;
/**
 *
 * @author acer
 */
// Kelas Pekerja mewarisi kelas Manusia
public class Pekerja extends Manusia {
    // Atribut tambahan untuk kelas Pekerja
    private double gaji;

    // Constructor yang sesuai dengan panggilan di Main.java
    public Pekerja(String nama, int usia, String pekerjaan, double gaji) {
        // Memanggil constructor dari kelas induk (Manusia)
        super(nama, usia, pekerjaan);
        // Menginisialisasi atribut 'gaji'
        this.gaji = gaji;
    }

    // Metode getter dan setter untuk atribut 'gaji'
    public double getGaji() {
        return gaji;
    }

    public void setGaji(double gaji) {
        this.gaji = gaji;
    }

    // Override metode toString() untuk menambahkan informasi gaji
    @Override
    public String toString() {
        // Memanggil toString() dari kelas induk dan menambahkan gaji
        return super.toString() + ", Gaji: " + gaji;
    }
}
