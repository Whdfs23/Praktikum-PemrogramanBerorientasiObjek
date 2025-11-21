/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ManajemenPerpustakaan;

/**
 *
 * @author LENOVO
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        // Tambahkan beberapa buku & anggota awal (opsional)
        library.addBook(new Book("Python Crash Course", "Eric Matthes", "978-1593279288"));
        library.addBook(new Book("Clean Code", "Robert C. Martin", "978-0132350884"));
        library.addMember(new Member("Andi", "M001"));

        int choice;
        do {
            System.out.println("\n=== Sistem Perpustakaan ===");
            System.out.println("1. Lihat Daftar Buku");
            System.out.println("2. Daftar Anggota Baru");
            System.out.println("3. Pinjam Buku");
            System.out.println("4. Kembalikan Buku");
            System.out.println("5. Lihat Buku Dipinjam Anggota");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu (1-6): ");
            
            choice = scanner.nextInt();
            scanner.nextLine(); // Konsumsi newline

            switch (choice) {
                case 1:
                    library.listAllBooks();
                    break;

                case 2:
                    System.out.print("Nama anggota: ");
                    String name = scanner.nextLine();
                    System.out.print("ID anggota: ");
                    String id = scanner.nextLine();
                    library.addMember(new Member(name, id));
                    System.out.println("✅ Anggota " + name + " berhasil didaftarkan!");
                    break;

                case 3:
                    System.out.print("ID Anggota: ");
                    String memberId = scanner.nextLine();
                    System.out.print("ISBN Buku: ");
                    String isbn = scanner.nextLine();
                    library.borrowBook(memberId, isbn);
                    break;

                case 4:
                    System.out.print("ID Anggota: ");
                    memberId = scanner.nextLine();
                    System.out.print("ISBN Buku: ");
                    isbn = scanner.nextLine();
                    library.returnBook(memberId, isbn);
                    break;

                case 5:
                    System.out.print("ID Anggota: ");
                    memberId = scanner.nextLine();
                    Member member = library.findMemberById(memberId);
                    if (member != null) {
                        System.out.println("\nBuku yang dipinjam oleh " + member.getName() + ":");
                        if (member.getBorrowedBooks().isEmpty()) {
                            System.out.println("- Tidak ada buku yang dipinjam.");
                        } else {
                            for (Book b : member.getBorrowedBooks()) {
                                System.out.println("  • " + b.getTitle() + " (Due: " + b.getDueDate() + ")");
                            }
                        }
                    } else {
                        System.out.println("❌ Anggota tidak ditemukan!");
                    }
                    break;

                case 6:
                    System.out.println("Terima kasih telah menggunakan Sistem Perpustakaan!");
                    break;

                default:
                    System.out.println("⚠️  Pilihan tidak valid. Silakan coba lagi.");
            }

        } while (choice != 6);

        scanner.close();
    }
}