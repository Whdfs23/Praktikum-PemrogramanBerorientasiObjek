/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package praktikum3;

/**
 *
 * @author LENOVO
 */
public class Main {
    public static void main(String[]args) {
        Hewan Kucing = new Hewan("Amer", 4);
        Kucing.suara();
        Kucing.info();
        Kucing.berlari();
        
        Hewan Anjing = new Hewan ("Brown", 5);
        Anjing.suara();
        Anjing.info();
        Anjing.berlari();
      
    }
}
