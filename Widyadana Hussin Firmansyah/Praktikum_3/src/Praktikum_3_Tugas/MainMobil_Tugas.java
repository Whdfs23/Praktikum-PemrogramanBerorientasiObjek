/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Praktikum_3_Tugas;

/**
 *
 * @author LENOVO
 */
public class MainMobil_Tugas {
    public static void main(String[] args) {
        Mobil mobil1 = new Mobil("Toyota", "Land Cruiser", 2020, "Hitam");
        Mobil mobil2 = new Mobil("Toyota", "Supra", 2000, "Silver");
        Mobil mobil3 = new Mobil("Nissan", "Grand Livina ",2010, "Hitam");
        
        
     
        mobil1.displayInfo();
        mobil1.startEngine();
        
        mobil2.displayInfo();
        mobil2.startEngine();
        
        mobil3.displayInfo();
        mobil3.startEngine();
        
        mobil1.ubahWarna("Silver");
        mobil1.displayInfo();
        mobil2.ubahWarna("Putih");
        mobil2.displayInfo();
        
    }

}
