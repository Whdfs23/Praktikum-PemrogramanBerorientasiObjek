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

public class Anggota implements Serializable {
    private static final long serialVersionUID = 1L;
    private String idAnggota;
    private String nama;

    public Anggota(String id, String nama) {
        this.idAnggota = id;
        this.nama = nama;
    }

    public Anggota getAnggota() {
        return this;
    }

    public void infoSingkat() {
        System.out.println("Anggota: " + nama + " (ID: " + idAnggota + ")");
    }

    public String getNama() {
        return nama;
    }

    public String getId() {
        return idAnggota;
    }
}
