/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hirearki_Pewarian;

/**
 *
 * @author LENOVO
 */
public class SepedaMotor extends KendaraanDarat {
    String jenisMesin;
    public SepedaMotor(String nama, int jumlahRoda, String jenisMesin) {
        super(nama, jumlahRoda);
        this.jenisMesin = jenisMesin;
    }

    public void infoMotor() {
        System.out.println("Sepeda motor ini menggunakan mesin: " + this.jenisMesin);
    }
}