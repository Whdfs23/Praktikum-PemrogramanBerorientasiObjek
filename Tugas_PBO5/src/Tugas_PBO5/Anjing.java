/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tugas_PBO5;

/**
 *
 * @author LENOVO
 */
public class Anjing extends Hewan {
    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Hewan ini adalah seekor anjing.");
    }

    public void suara() {
        System.out.println("Suara: Guk-Guk Woof-woof!");
    }
}
