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

public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isBorrowed;
    private Member borrowedBy;
    private LocalDate dueDate;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isBorrowed = false;
        this.borrowedBy = null;
        this.dueDate = null;
    }

    // Getter
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public boolean isBorrowed() { return isBorrowed; }
    public Member getBorrowedBy() { return borrowedBy; }
    public LocalDate getDueDate() { return dueDate; }

    // Setter
    public void setBorrowed(boolean borrowed) { isBorrowed = borrowed; }
    public void setBorrowedBy(Member member) { borrowedBy = member; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }

    @Override
    public String toString() {
        String status = isBorrowed ? "Dipinjam" : "Tersedia";
        return String.format("'%s' oleh %s (ISBN: %s) - %s", title, author, isbn, status);
    }
}