/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Praktikum5.tugas2;

/**
 *
 * @author LENOVO
 */
public class SepedaMotor extends KendaraanDarat {
    String jenisMesin;

    @Override
    public void tampilkanInfo() {
        tampilkanInfoDarat();
        System.out.println("Jenis Mesin: " + jenisMesin);
    }
}
