/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kendaraan;

/**
 *
 * @author LENOVO
 */
public class Mobil extends Kendaraan {
    public Mobil(String model) {
        super(model);
    }
    @Override
    public void bergerak() {
        System.out.println("Mobil " + this.model + " melaju di jalan tol.");
    }
}
