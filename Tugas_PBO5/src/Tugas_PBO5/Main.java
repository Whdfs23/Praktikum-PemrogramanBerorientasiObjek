/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas_PBO5;

/**
 *
 * @author LENOVO
 */
public class Main {
    public static void main(String[] args) {
        Kucing kucing = new Kucing();
        kucing.nama = "Amer";
        kucing.jenis = "Rumahan";
        kucing.tampilkanInfo();
        kucing.suara();

        System.out.println();

        Anjing anjing = new Anjing();
        anjing.nama = "Debi";
        anjing.jenis = "Sheperd";
        anjing.tampilkanInfo();
        anjing.suara();
    }
}
