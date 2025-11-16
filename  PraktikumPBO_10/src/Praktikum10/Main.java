/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Praktikum10;

/**
 *
 * @author LENOVO
 */
public class Main {
    public static void main(String[] args) {
        // Objek Penjumlahan
        OperasiHitung penjumlahan = new OperasiPenjumlahan();
        System.out.println("Penjumlahan: " + penjumlahan.hitung(20, 3)); // Output: 15
        
        // Objek Pengurangan
        OperasiHitung pengurangan = new OperasiPengurangan();
        System.out.println("Pengurangan: " + pengurangan.hitung(45, 15)); // Output: 5
    }
}
