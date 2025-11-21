/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

/**
 *
 * @author LENOVO
 */
public class Main {
    public static void main(String[] args) {
        // Jalankan GUI di thread EDT (Event Dispatch Thread)
        javax.swing.SwingUtilities.invokeLater(MarketplaceGUI::new);
    }
}