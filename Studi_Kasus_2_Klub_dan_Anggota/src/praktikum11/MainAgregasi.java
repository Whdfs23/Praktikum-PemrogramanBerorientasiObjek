/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum11;

/**
 *
 * @author LENOVO
 */
public class MainAgregasi {
    public static void main(String[] args) {
        // Membuat objek Anggota secara terpisah (di luar Klub)
        Anggota anggota1 = new Anggota("Budi");
        Anggota anggota2 = new Anggota("Siti");
        
        // Membuat Klub
        Klub klubRenang = new Klub("Klub Renang");
        
        // Menambahkan anggota ke klub (Agregasi)
        klubRenang.tambahAnggota(anggota1);
        klubRenang.tambahAnggota(anggota2);
        
        klubRenang.infoKlub();
        
        // Pembuktian Agregasi: Anggota tetap bisa diakses meski di luar konteks klub
        System.out.println("\nCek eksistensi anggota di luar klub:");
        anggota1.infoAnggota();
    }
}