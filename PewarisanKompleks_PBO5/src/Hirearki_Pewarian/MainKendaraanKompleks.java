/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hirearki_Pewarian;

/**
 *
 * @author LENOVO
 */
public class MainKendaraanKompleks {
    public static void main(String[] args) {
        System.out.println("Informasi Mobil");
        Mobil mobilBaru = new Mobil("Land Rover", 4, 4);
        mobilBaru.infoUmum();
        mobilBaru.infoDarat();
        mobilBaru.infoMobil();
        
        System.out.println();
        
        SepedaMotor motorBaru = new SepedaMotor("Vario", 2, "160cc");
        System.out.println("Info Sepeda Motor");
        motorBaru.infoUmum();   
        motorBaru.infoDarat(); 
        motorBaru.infoMotor();  
    }
}

