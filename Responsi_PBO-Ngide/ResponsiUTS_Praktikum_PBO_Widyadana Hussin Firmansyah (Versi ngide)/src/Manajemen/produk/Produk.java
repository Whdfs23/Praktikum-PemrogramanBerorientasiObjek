/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manajemen.produk;

import java.text.NumberFormat;
import java.util.Locale;
/**
 *
 * @author LENOVO
 */
public class Produk {
    private String namaProduk;
    private double harga;

    // CONSTRUCTOR: Method khusus yang dipanggil saat objek dibuat.
    // Fungsinya untuk menginisialisasi nilai awal atribut. [cite: 633]
    public Produk(String namaProduk, double harga) {
        this.namaProduk = namaProduk;
        this.harga = harga;
    }

    // GETTER: Method public untuk MENGAMBIL nilai atribut private.
    public String getNamaProduk() {
        return namaProduk;
    }

    // SETTER: Method public untuk MENGUBAH nilai atribut private.
    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        // Kita bisa menambahkan validasi di sini, contoh: harga tidak boleh negatif.
        if (harga > 0) {
            this.harga = harga;
        }
    }
    
    // Utility method untuk format Rupiah (tambahan untuk membuat output lebih bagus)
    protected String formatRupiah(double nominal) {
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
        return formatRupiah.format(nominal);
    }

    // METHOD: Perilaku atau fungsi yang dimiliki oleh objek.
    // Method ini akan di-override oleh kelas turunan.
    public void tampilkanInfo() {
        System.out.println("Nama Produk: " + this.namaProduk);
        System.out.println("Harga: " + formatRupiah(this.harga));
    }
}
