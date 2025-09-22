/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PBO_Pertemuan_4;

/**
 *
 * @author acer
 */
public class Main {
    public static void main(String[] args){
        Pekerja pekerja1 = new Pekerja("Budi", 30, "Software Engineer", 7500000.0);
        System.out.println("Informasi Awal: " + pekerja1.toString());

        // 3. Ubah nama pekerja menggunakan metode setter dan tampilkan ulang
        pekerja1.setNama("Budi Santoso");
        System.out.println("Informasi Setelah Nama Diubah: " + pekerja1.toString());

        // 4. Coba akses langsung atribut dari objek pekerja
        System.out.println("\n--- Percobaan Mengakses Atribut Langsung ---");
        
        // Akses langsung atribut 'nama' (gagal karena private)
        // System.out.println("Nama: " + pekerja1.nama); // Ini akan menyebabkan error kompilasi
        System.out.println("Akses pekerja1.nama: GAGAL (Atribut 'nama' bersifat private)");

        // Akses langsung atribut 'usia' (berhasil karena protected dalam package yang sama)
        System.out.println("Akses pekerja1.usia: " + pekerja1.usia);

        // Akses langsung atribut 'gaji' (gagal karena private)
        // System.out.println("Gaji: " + pekerja1.gaji); // Ini akan menyebabkan error kompilasi
        System.out.println("Akses pekerja1.gaji: GAGAL (Atribut 'gaji' bersifat private)");
    }
}
