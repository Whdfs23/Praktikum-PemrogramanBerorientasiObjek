/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum9;

/**
 *
 * @author LENOVO
 */
abstract class Kendaraan {
    // Metode abstrak (tanpa implementasi)
    abstract void berjalan(); 
    // Metode dengan implementasi (metode biasa)
    void info() { 
        System.out.println("Ini adalah kendaraan."); 
    }
}
