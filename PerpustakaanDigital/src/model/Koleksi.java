/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.io.Serializable; 

/**
 *
 * @author LENOVO
 */
public abstract class Koleksi implements Serializable { // ← tambahkan implements Serializable
    private static final long serialVersionUID = 1L;
    protected String id;
    protected String judul;

    public Koleksi(String id, String judul) {
        this.id = id;
        this.judul = judul;
    }

    // Abstract method
    public abstract String getTipe();

    // Concrete method
    public void tampilkanInfo() {
        System.out.println("ID: " + id + " | Judul: " + judul);
    }

    // Getter
    public String getId() { return id; }
    public String getJudul() { return judul; }
}