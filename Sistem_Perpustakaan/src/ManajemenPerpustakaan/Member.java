/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ManajemenPerpustakaan;

/**
 *
 * @author LENOVO
 */
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private String memberId;
    private List<Book> borrowedBooks;

    public Member(String name, String memberId) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() { return name; }
    public String getMemberId() { return memberId; }
    public List<Book> getBorrowedBooks() { return new ArrayList<>(borrowedBooks); }

    public boolean borrowBook(Book book) {
        if (book.isBorrowed()) {
            System.out.println("❌ Buku '" + book.getTitle() + "' sudah dipinjam!");
            return false;
        }

        book.setBorrowed(true);
        book.setBorrowedBy(this);
        book.setDueDate(LocalDate.now().plusDays(14)); // 2 minggu
        borrowedBooks.add(book);
        System.out.println("✅ " + name + " berhasil meminjam '" + book.getTitle() + "'");
        return true;
    }

    public boolean returnBook(Book book) {
        if (!borrowedBooks.contains(book)) {
            System.out.println("❌ Anda tidak meminjam buku ini!");
            return false;
        }

        borrowedBooks.remove(book);
        book.setBorrowed(false);
        book.setBorrowedBy(null);

        // Cek keterlambatan
        LocalDate today = LocalDate.now();
        if (today.isAfter(book.getDueDate())) {
            long daysLate = ChronoUnit.DAYS.between(book.getDueDate(), today);
            long fine = daysLate * 1000; // Rp1.000/hari
            System.out.println("⚠️  Buku dikembalikan terlambat! Denda: Rp" + fine);
        } else {
            System.out.println("✅ Buku dikembalikan tepat waktu.");
        }
        return true;
    }
}
