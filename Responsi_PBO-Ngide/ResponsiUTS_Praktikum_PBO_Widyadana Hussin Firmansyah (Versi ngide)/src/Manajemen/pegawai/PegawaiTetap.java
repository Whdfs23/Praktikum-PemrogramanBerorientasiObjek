/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manajemen.pegawai;

/**
 *
 * @author LENOVO
 */
public class PegawaiTetap extends Pegawai{
    private double tunjangan;

    public PegawaiTetap(String namaPegawai, double gaji, double tunjangan) {
        super(namaPegawai, gaji);
        this.tunjangan = tunjangan;
    }
    
    public double getTunjangan() {
        return this.tunjangan;
    }
    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Tunjangan: " + formatRupiah(this.tunjangan));
        double totalGaji = getGaji() + this.tunjangan;
        System.out.println("Total Gaji: " + formatRupiah(totalGaji));
    }
}
