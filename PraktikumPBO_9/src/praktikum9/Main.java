/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum9;

/**
 *
 * @author LENOVO
 */
public class Main { 
    public static void main(String[] args) { 
     // Membuat objek dari kelas turunan
            Kendaraan mobil = new Mobil();  
            Kendaraan sepeda = new Sepeda();  

        // Memanggil metode pada objek mobil
        mobil.berjalan(); 
        mobil.info(); 
      // Memanggil metode pada objek sepeda
        sepeda.berjalan(); 
        sepeda.info(); 
    }
 } 