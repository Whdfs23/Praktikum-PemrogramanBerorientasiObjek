/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pbo_3;

/**
 *
 * @author LENOVO
 */
public class Mobil { 
    private String pabrikan;
    private String tipe;
    private int tahunProduksi;
    private String warnaCat;

    public Mobil (String pabrikan, String tipe, int tahunProduksi, String warnaCat) {
        this.pabrikan = pabrikan;
        this.tipe = tipe;
        this.tahunProduksi = tahunProduksi;
        this.warnaCat = warnaCat;
    }

    public String getPabrikan() {
        return pabrikan;
    }

    public void setPabrikan(String pabrikan) {
        this.pabrikan = pabrikan;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public int getTahunProduksi() {
        return tahunProduksi;
    }

    public void setTahunProduksi(int tahunProduksi) {
        this.tahunProduksi = tahunProduksi;
    }

    public String getWarnaCat() {
        return warnaCat;
    }

    public void setWarnaCat(String warnaCat) {
        this.warnaCat = warnaCat;
    }

    public void tampilkanDetail() {
        System.out.println("Detail Kendaraan:");
        System.out.println("Pabrikan: " + pabrikan);
        System.out.println("Tipe: " + tipe);
        System.out.println("Tahun: " + tahunProduksi);
        System.out.println("Warna: " + warnaCat);
    }
    
    public void mulaiMesin() {
        System.out.println("Mesin " + pabrikan + " menyala.");
    }
}

