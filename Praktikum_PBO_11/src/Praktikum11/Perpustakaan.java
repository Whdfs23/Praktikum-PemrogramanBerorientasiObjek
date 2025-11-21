/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Praktikum11;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
class Perpustakaan {
    private List<Buku> bukuList;

    public Perpustakaan() {
        // Inisialisasi list buku terjadi saat Perpustakaan dibuat
        this.bukuList = new ArrayList<>();
    }

    public void tambahBuku(Buku buku) {
        bukuList.add(buku);
    }

    public void infoPerpustakaan() {
        System.out.println("--- Info Perpustakaan ---");
        for (Buku buku : bukuList) {
            buku.infoBuku();
        }
    }
}