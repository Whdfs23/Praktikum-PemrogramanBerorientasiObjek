/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author LENOVO
 */
import util.Transaksi;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Peminjaman implements Transaksi, Serializable {
    private static final long serialVersionUID = 1L;
    private String idPeminjaman;
    private Anggota anggota;
    private List<Buku> daftarBuku; // Komposisi: peminjaman tidak ada tanpa buku
    private LocalDate tanggalPinjam;
    private boolean aktif = true;

    public Peminjaman(String id, Anggota anggota) {
        this.idPeminjaman = id;
        this.anggota = anggota;
        this.daftarBuku = new ArrayList<>();
        this.tanggalPinjam = LocalDate.now();
    }

    public void tambahBuku(Buku buku) {
        daftarBuku.add(buku);
    }

    public int getJumlahBuku() {
        return daftarBuku.size();
    }

    public String getIdPeminjaman() {
        return idPeminjaman;
    }

    public Anggota getAnggota() {
        return this.anggota;
    }

    @Override
    public void pinjam() {
        System.out.println("Meminjam " + daftarBuku.size() + " buku oleh " + anggota.getNama());
        aktif = true;
    }

    @Override
    public void kembalikan() {
        System.out.println("Mengembalikan " + daftarBuku.size() + " buku.");
        aktif = false;
    }

    @Override
    public boolean isDipinjam() {
        return aktif;
    }

    public void infoPeminjaman() {
        System.out.println("ID Peminjaman: " + idPeminjaman);
        anggota.infoSingkat();
        System.out.println("Tanggal Pinjam: " + tanggalPinjam);
        System.out.println("Buku yang Dipinjam:");
        daftarBuku.forEach(b -> b.tampilkanInfo());
    }
}
