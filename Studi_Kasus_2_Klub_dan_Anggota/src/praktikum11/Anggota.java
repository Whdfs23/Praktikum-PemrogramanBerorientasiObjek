/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum11;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */


// Kelas Anggota (Objek yang bisa independen)
class Anggota {
    private String nama;

    public Anggota(String nama) {
        this.nama = nama;
    }

    public void infoAnggota() {
        System.out.println("Nama Anggota: " + nama);
    }
}
