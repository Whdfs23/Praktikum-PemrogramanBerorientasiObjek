/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas_5;

/**
 *
 * @author LENOVO
 */
public class MainTugas1 {
    public static void main(String[] args) {
        System.out.println("--- Informasi Kucing ---");
        Kucing kucing = new Kucing();
        kucing.nama = "Ciko";
        kucing.jenis = "Anggora";
        kucing.tampilkanInfo();
        System.out.println();

        System.out.println("--- Informasi Anjing ---");
        Anjing anjing = new Anjing();
        anjing.nama = "Boby";
        anjing.jenis = "Golden Retriever";
        anjing.tampilkanInfo();
    }
}
