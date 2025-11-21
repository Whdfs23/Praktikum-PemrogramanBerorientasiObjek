/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kendaraan;

/**
 *
 * @author LENOVO
 */
public class SepedaMotor extends Kendaraan{
    
public SepedaMotor(String model) {
        super(model);
    }
    @Override
    public void bergerak() {
        System.out.println("Sepeda Motor " + this.model + " menyalip di kemacetan.");
    }
}
