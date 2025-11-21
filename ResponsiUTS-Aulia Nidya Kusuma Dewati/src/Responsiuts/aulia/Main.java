/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responsiuts.aulia;

/**
 *
 * @author LENOVO
 */

//class produk
abstract class Produk {
    private String namaProduk;
    private double harga;

    public Produk(String namaProduk, double harga) {
        this.namaProduk = namaProduk;
        this.harga = harga;
    }

    abstract String tampilkanInfo();

    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
    }

    public String getNamaProduk() {
        return this.namaProduk;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public double getHarga() {
        return this.harga;
    }
}

//class pegawai
abstract class Pegawai {
    private String namaPegawai;
    private String gaji;

    public Pegawai(String namaPegawai, String gaji) {
        this.namaPegawai = namaPegawai;
        this.gaji = gaji;
    }

    abstract String tampilkanInfo();

    public void setNamaPegawai(String namaPegawai) {
        this.namaPegawai = namaPegawai;
    }

    public String getNamaPegawai() {
        return this.namaPegawai;
    }

    public void setGaji(String gaji) {
        this.gaji = gaji;
    }

    public String getGaji() {
        return this.gaji;
    }
}

class Elektronik extends Produk {
    private int garansi;

    public Elektronik(String namaProduk, double harga, int garansi) {
        super(namaProduk, harga);
        this.garansi = garansi;
    }

    public void setGaransi(int garansi) {
        this.garansi = garansi;
    }

    public int getGaransi() {
        return this.garansi;
    }

    @Override
    public String tampilkanInfo() {
        return "Nama Produk: " + getNamaProduk() + 
               "\nHarga: " + getHarga() + 
               "\nGaransi: " + garansi + " tahun";
    }
}

class Makanan extends Produk {
    private String tanggalKadaluarsa;

    public Makanan(String namaProduk, double harga, String tanggalKadaluarsa) {
        super(namaProduk, harga);
        this.tanggalKadaluarsa = tanggalKadaluarsa;
    }

    public void setTanggalKadaluarsa(String tanggalKadaluarsa) {
        this.tanggalKadaluarsa = tanggalKadaluarsa;
    }

    public String getTanggalKadaluarsa() {
        return this.tanggalKadaluarsa;
    }

    @Override
    public String tampilkanInfo() {
        return "Nama Produk: " + getNamaProduk() + 
               "\nHarga: " + getHarga() + 
               "\nTanggal Kadaluarsa: " + tanggalKadaluarsa;
    }
}

class PegawaiTetap extends Pegawai {
    private String tunjangan;

    public PegawaiTetap(String namaPegawai, String gaji, String tunjangan) {
        super(namaPegawai, gaji);
        this.tunjangan = tunjangan;
    }

    public void setTunjangan(String tunjangan) {
        this.tunjangan = tunjangan;
    }

    public String getTunjangan() {
        return this.tunjangan;
    }

    @Override
    public String tampilkanInfo() {
        return "Nama Pegawai: " + getNamaPegawai() + 
               "\nGaji: " + getGaji() + 
               "\nTunjangan: " + tunjangan;
    }
}

class PegawaiKontrak extends Pegawai {
    private String lamaKontrak;

    public PegawaiKontrak(String namaPegawai, String gaji, String lamaKontrak) {
        super(namaPegawai, gaji);
        this.lamaKontrak = lamaKontrak;
    }

    public void setLamaKontrak(String lamaKontrak) {
        this.lamaKontrak = lamaKontrak;
    }

    public String getLamaKontrak() {
        return this.lamaKontrak;
    }

    @Override
    public String tampilkanInfo() {
        return "Nama Pegawai: " + getNamaPegawai() + 
               "\nGaji: " + getGaji() + 
               "\nLama Kontrak: " + lamaKontrak;
    }
}

public class Main {
    public static void main(String[] args) {
        // 1. Output Produk Elektronik
        System.out.println("=== OUTPUT PRODUK ===");
        Produk elektronik = new Elektronik("Laptop ASUS Vivobook", 15000000, 2);
        System.out.println(elektronik.tampilkanInfo());
        System.out.println();

        System.out.println("=== OUTPUT PEGAWAI TETAP ===");
        Pegawai pegawaiTetap = new PegawaiTetap("Aulia Nidya Kusuma Dewati", "5.000.000", "1.000.000");
        System.out.println(pegawaiTetap.tampilkanInfo());
        System.out.println();

        System.out.println("=== OUTPUT POLIMORFISME ===");
        Produk makanan = new Makanan("Snack Roti Coklat", 15000, "2025-12-31");
        System.out.println(makanan.tampilkanInfo());
        System.out.println();

        Pegawai pegawaiKontrak = new PegawaiKontrak("Andi Saputra", "3.000.000", "6 bulan");
        System.out.println(pegawaiKontrak.tampilkanInfo());
    }
}