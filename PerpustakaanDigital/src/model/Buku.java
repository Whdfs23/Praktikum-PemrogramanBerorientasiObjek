/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.io.Serializable;
/**
 *
 * @author LENOVO
 */
public class Buku extends Koleksi implements Serializable {
    private static final long serialVersionUID = 1L;
    private String pengarang;
    private int tahunTerbit;

    public Buku(String id, String judul, String pengarang, int tahunTerbit) {
        super(id, judul);
        this.pengarang = pengarang;
        this.tahunTerbit = tahunTerbit;
    }

    @Override
    public String getTipe() {
        return "Buku";
    }

    public void infoLengkap() {
        tampilkanInfo();
        System.out.println("Pengarang: " + pengarang + " | Tahun: " + tahunTerbit);
    }

    // Getter
    public String getPengarang() { return pengarang; }
}