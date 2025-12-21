package Main;

import model.*;
import util.FileManager;
import java.util.*;

public class PerpustakaanApp {
    private static List<Buku> daftarBuku = new ArrayList<>();
    private static List<Anggota> daftarAnggota = new ArrayList<>();
    private static List<Peminjaman> riwayatPeminjaman = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        muatData();

        if (daftarBuku.isEmpty()) {
            inisialisasiDataAwal();
        }

        int pilihan;
        do {
            tampilkanMenu();
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1 -> tambahBuku();
                case 2 -> tambahAnggota();
                case 3 -> buatPeminjaman();
                case 4 -> tampilkanDaftarBuku();
                case 5 -> tampilkanDaftarAnggota();
                case 6 -> tampilkanRiwayatPeminjaman();
                case 7 -> kembalikanBuku();
                case 0 -> System.out.println("Terima kasih sudah menggunakan sistem ini! Data disimpan otomatis.");
                default -> System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);

        simpanData();
    }

    private static void muatData() {
        System.out.println("Memuat data dari file...");
        daftarBuku = FileManager.bacaDariFile("data/buku.ser");
        daftarAnggota = FileManager.bacaDariFile("data/anggota.ser");
        riwayatPeminjaman = FileManager.bacaDariFile("data/peminjaman.ser");
    }

    private static void simpanData() {
        System.out.println("Menyimpan data...");
        FileManager.simpanKeFile("data/buku.ser", daftarBuku);
        FileManager.simpanKeFile("data/anggota.ser", daftarAnggota);
        FileManager.simpanKeFile("data/peminjaman.ser", riwayatPeminjaman);
    }

    private static void inisialisasiDataAwal() {
        System.out.println("Mengisi data awal...");

        daftarBuku.add(new Buku("B01", "Dasar Pemrograman Java", "Budi Raharjo", 2020));
        daftarBuku.add(new Buku("B02", "Struktur Data dan Algoritma", "Samsul Arifin", 2021));
        daftarBuku.add(new Buku("B03", "Database Systems", "Abraham Silberschatz", 2019));
        daftarBuku.add(new Buku("B04", "Clean Code", "Robert C. Martin", 2008));
        daftarBuku.add(new Buku("B05", "Head First Design Patterns", "Eric Freeman", 2004));
        daftarBuku.add(new Buku("B06", "Effective Java", "Joshua Bloch", 2018));
        daftarBuku.add(new Buku("B07", "Java: The Complete Reference", "Herbert Schildt", 2022));
        daftarBuku.add(new Buku("B08", "Learning Python", "Mark Lutz", 2013));

        daftarAnggota.add(new Anggota("A01", "Widyadana Hussin Firmansyah"));
        daftarAnggota.add(new Anggota("A02", "Andi Wijaya"));
        daftarAnggota.add(new Anggota("A03", "Budi Santoso"));
        daftarAnggota.add(new Anggota("A04", "Citra Dewi"));
        daftarAnggota.add(new Anggota("A05", "Dewa Putra"));
        daftarAnggota.add(new Anggota("A06", "Eka Prasetya"));
        daftarAnggota.add(new Anggota("A07", "Fajar Nugraha"));
        daftarAnggota.add(new Anggota("A08", "Gina Lestari"));
        daftarAnggota.add(new Anggota("A09", "Hendra Wijaya"));
        daftarAnggota.add(new Anggota("A10", "Intan Permata"));
        daftarAnggota.add(new Anggota("A11", "Joko Susanto"));
        daftarAnggota.add(new Anggota("A12", "Kiki Ramadhan"));
        daftarAnggota.add(new Anggota("A13", "Lina Marlina"));
        daftarAnggota.add(new Anggota("A14", "Mira Ananda"));
        daftarAnggota.add(new Anggota("A15", "Nanda Pratama"));
        daftarAnggota.add(new Anggota("A16", "Oki Setiawan"));

        System.out
                .println(daftarBuku.size() + " buku dan " + daftarAnggota.size() + " anggota berhasil diinisialisasi.");
    }

    private static void tampilkanMenu() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("     SELAMAT DATANG DI SISTEM MANAJEMEN PERPUSTAKAAN DIGITAL");
        System.out.println("=".repeat(50));
        System.out.println("1. Tambah Buku");
        System.out.println("2. Tambah Anggota");
        System.out.println("3. Buat Peminjaman");
        System.out.println("4. Tampilkan Daftar Buku");
        System.out.println("5. Tampilkan Daftar Anggota");
        System.out.println("6. Tampilkan Riwayat Peminjaman");
        System.out.println("7. Kembalikan Buku");
        System.out.println("0. Keluar");
        System.out.print("Pilih menu: ");
    }

    private static void tambahBuku() {
        System.out.print("ID Buku (contoh: B99): ");
        String id = scanner.nextLine().trim();
        System.out.print("Judul: ");
        String judul = scanner.nextLine();
        System.out.print("Pengarang: ");
        String pengarang = scanner.nextLine();
        System.out.print("Tahun Terbit: ");
        int tahun = Integer.parseInt(scanner.nextLine());
        daftarBuku.add(new Buku(id, judul, pengarang, tahun));
        System.out.println("Buku berhasil ditambahkan!");
    }

    private static void tambahAnggota() {
        System.out.print("ID Anggota (contoh: A99): ");
        String id = scanner.nextLine().trim();
        System.out.print("Nama Lengkap: ");
        String nama = scanner.nextLine();
        daftarAnggota.add(new Anggota(id, nama));
        System.out.println("Anggota berhasil ditambahkan!");
    }

    private static void buatPeminjaman() {
        if (daftarAnggota.isEmpty() || daftarBuku.isEmpty()) {
            System.out.println("Belum ada anggota atau buku!");
            return;
        }

        System.out.println("\nDaftar Anggota:");
        for (int i = 0; i < daftarAnggota.size(); i++) {
            System.out.printf("%2d. %s (ID: %s)\n", i + 1, daftarAnggota.get(i).getNama(),
                    daftarAnggota.get(i).getId());
        }
        System.out.print("Pilih anggota (nomor): ");
        try {
            int idxA = scanner.nextInt() - 1;
            scanner.nextLine();
            if (idxA < 0 || idxA >= daftarAnggota.size()) {
                System.out.println("Nomor anggota tidak valid.");
                return;
            }

            Anggota anggota = daftarAnggota.get(idxA);
            Peminjaman pinjam = new Peminjaman("P" + (riwayatPeminjaman.size() + 1), anggota);

            System.out.println("\nDaftar Buku:");
            for (int i = 0; i < daftarBuku.size(); i++) {
                System.out.printf("%2d. %s\n", i + 1, daftarBuku.get(i).getJudul());
            }
            System.out.print("Pilih buku (pisahkan dengan koma, contoh: 1,3,5): ");
            String input = scanner.nextLine();
            String[] pilihan = input.split(",");

            for (String p : pilihan) {
                try {
                    int idxB = Integer.parseInt(p.trim()) - 1;
                    if (idxB >= 0 && idxB < daftarBuku.size()) {
                        pinjam.tambahBuku(daftarBuku.get(idxB));
                    }
                } catch (NumberFormatException e) {
                }
            }

            if (pinjam.getJumlahBuku() == 0) {
                System.out.println("Tidak ada buku yang dipilih.");
                return;
            }

            pinjam.pinjam();
            riwayatPeminjaman.add(pinjam);
            System.out.println("Peminjaman berhasil dibuat!");
        } catch (Exception e) {
            System.out.println("Input tidak valid.");
            scanner.nextLine();
        }
    }

    private static void tampilkanDaftarBuku() {
        if (daftarBuku.isEmpty()) {
            System.out.println("Belum ada buku.");
            return;
        }
        System.out.println("\nDAFTAR BUKU:");
        for (Buku b : daftarBuku) {
            b.infoLengkap();
            System.out.println("-".repeat(40));
        }
    }

    private static void tampilkanDaftarAnggota() {
        if (daftarAnggota.isEmpty()) {
            System.out.println("Belum ada anggota.");
            return;
        }
        System.out.println("\nDAFTAR ANGGOTA:");
        for (int i = 0; i < daftarAnggota.size(); i++) {
            Anggota a = daftarAnggota.get(i);
            System.out.println((i + 1) + ". " + a.getNama() + " (ID: " + a.getId() + ")");
        }
    }

    private static void tampilkanRiwayatPeminjaman() {
        if (riwayatPeminjaman.isEmpty()) {
            System.out.println("Belum ada riwayat peminjaman.");
            return;
        }
        System.out.println("\nRIWAYAT PEMINJAMAN:");
        for (Peminjaman p : riwayatPeminjaman) {
            p.infoPeminjaman();
            System.out.println("=".repeat(50));
        }
    }

    private static void kembalikanBuku() {
        if (riwayatPeminjaman.isEmpty()) {
            System.out.println("Belum ada peminjaman.");
            return;
        }

        // Filter hanya peminjaman yang masih aktif (belum dikembalikan)
        List<Peminjaman> peminjamanAktif = new ArrayList<>();
        for (Peminjaman p : riwayatPeminjaman) {
            if (p.isDipinjam()) {
                peminjamanAktif.add(p);
            }
        }

        if (peminjamanAktif.isEmpty()) {
            System.out.println("Tidak ada buku yang sedang dipinjam.");
            return;
        }

        System.out.println("\nDaftar Peminjaman Aktif:");
        for (int i = 0; i < peminjamanAktif.size(); i++) {
            Peminjaman p = peminjamanAktif.get(i);
            System.out.printf("%d. %s (ID: %s) - %s\n",
                    i + 1,
                    p.getAnggota().getNama(),
                    p.getAnggota().getId(),
                    p.getIdPeminjaman());
        }

        System.out.print("Pilih peminjaman untuk dikembalikan (nomor): ");
        try {
            int idx = scanner.nextInt() - 1;
            scanner.nextLine(); // konsumsi newline
            if (idx >= 0 && idx < peminjamanAktif.size()) {
                peminjamanAktif.get(idx).kembalikan();
                System.out.println("Pengembalian berhasil dicatat!");
            } else {
                System.out.println("Nomor tidak valid.");
            }
        } catch (Exception e) {
            System.out.println("Input tidak valid.");
            scanner.nextLine();
        }
    }
}
