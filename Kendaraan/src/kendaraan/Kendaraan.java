/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kendaraan;

/**
 *
 * @author LENOVO
 */
// Kelas Mobil 'adalah sebuah' Kendaraan
    
public abstract class Kendaraan {
    
    protected String model;

    public Kendaraan(String model) {
        this.model = model;
    }
    public abstract void bergerak();
}