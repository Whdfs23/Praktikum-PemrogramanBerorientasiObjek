/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Praktikum11;
import java.util.ArrayList;
import java.util.List;


public class Perpustakaan {
    private List<Buku> daftarBuku; 

    public Perpustakaan() {
        this.daftarBuku = new ArrayList<>();
    }

    public void tambahBuku(Buku buku) {
        daftarBuku.add(buku);
    }

    public void infoPerpustakaan() {
        System.out.println("KOLEKSI BUKU PERPUSTAKAAN ");
        if (daftarBuku.isEmpty()) {
            System.out.println("Perpustakaan kosong.");
        } else {
            for (Buku buku : daftarBuku) {
                buku.infoBuku();
            }
        }
        System.out.println("============================"); //sebagai hiasan saja
    }
}
