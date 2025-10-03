/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manajemen.pegawai;

/**
 *
 * @author LENOVO
 */
public class PegawaiKontrak extends Pegawai{
    private int lamaKontrak; 
    public PegawaiKontrak(String namaPegawai, double gaji, int lamaKontrak) {
        super(namaPegawai, gaji);
        this.lamaKontrak = lamaKontrak;
    }
    
    public int getLamaKontrak() {
        return this.lamaKontrak;
    }
    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Lama Kontrak: " + this.lamaKontrak + " bulan");
    }
}
