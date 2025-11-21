/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Praktikum11;

/**
 *
 * @author LENOVO
 */
public class MainKomposisi {
    public static void main(String[] args) {
        Perpustakaan perpus = new Perpustakaan();
        
        // Membuat objek buku dan menambahkannya ke perpustakaan
        perpus.tambahBuku(new Buku("Pemrograman Java"));
        perpus.tambahBuku(new Buku("Algoritma Dasar"));
        
        perpus.infoPerpustakaan();
    }
}