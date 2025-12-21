/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

/**
 *
 * @author LENOVO
 */
import model.Anggota;
import model.Buku;
import model.Peminjaman;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    public static <T> void simpanKeFile(String path, List<T> data) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(data);
            System.out.println("Data berhasil disimpan ke: " + path);
        } catch (IOException e) {
            System.err.println("Gagal menyimpan data ke file: " + path);
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> List<T> bacaDariFile(String path) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            return (List<T>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Gagal membaca data dari file: " + path);
            return new ArrayList<>();
        }
    }
}
