/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Praktikum11;

/**
 *
 * @author LENOVO
 */
public class Main_Tugas_11 {
    public static void main(String[] args) {
        // 1. Membuat objek Pengarang (Independen)
        Pengarang p1 = new Pengarang("Tere Liye");
        Pengarang p2 = new Pengarang("J.K. Rowling");
        Pengarang p3 = new Pengarang("Toshikazu Kawaguchi");
        
        // 2. Membuat objek Buku dengan referensi Pengarang (Agregasi)
        Buku buku1 = new Buku("Hujan", p1);
        Buku buku2 = new Buku("Harry Potter", p2);
        Buku buku3 = new Buku("Pulang", p1); // Satu pengarang untuk banyak buku
        Buku buku4 = new Buku("Sesuk", p1);
        Buku buku5 = new Buku("Kisah-Kisah Yang Baru Terungkap", p3);
        
        // 3. Membuat objek Perpustakaan (Komposisi)
        Perpustakaan perpus = new Perpustakaan();

        // 4. Menambahkan buku ke dalam perpustakaan
        perpus.tambahBuku(buku1);
        perpus.tambahBuku(buku2);
        perpus.tambahBuku(buku3);
        perpus.tambahBuku(buku4);
        perpus.tambahBuku(buku5);

        // 5. Menampilkan hasil akhir
        perpus.infoPerpustakaan();
    }
}