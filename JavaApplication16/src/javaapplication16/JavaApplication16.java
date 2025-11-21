/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication16;

/**
 *
 * @author LENOVO
 */
abstract class BangunDatar {
    // Abstract method: WAJIB di-override, tanpa isi
    abstract double hitungLuas();

    void info() {
        System.out.println("Ini adalah sebuah bangun datar.");
    }
}

class Lingkaran extends BangunDatar {
    double r;
    
    @Override
    double hitungLuas() {
        return Math.PI * r * r;
    }
}