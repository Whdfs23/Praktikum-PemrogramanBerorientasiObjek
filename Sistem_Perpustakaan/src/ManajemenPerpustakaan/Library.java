/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ManajemenPerpustakaan;

/**
 *
 * @author LENOVO
 */
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<Member> members;

    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public Book findBookByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    public Member findMemberById(String memberId) {
        for (Member member : members) {
            if (member.getMemberId().equals(memberId)) {
                return member;
            }
        }
        return null;
    }

    public void listAllBooks() {
        System.out.println("\n=== Daftar Buku di Perpustakaan ===");
        if (books.isEmpty()) {
            System.out.println("Tidak ada buku.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    public void borrowBook(String memberId, String isbn) {
        Member member = findMemberById(memberId);
        Book book = findBookByIsbn(isbn);

        if (member == null) {
            System.out.println("❌ Member dengan ID " + memberId + " tidak ditemukan!");
            return;
        }
        if (book == null) {
            System.out.println("❌ Buku dengan ISBN " + isbn + " tidak ditemukan!");
            return;
        }

        member.borrowBook(book);
    }

    public void returnBook(String memberId, String isbn) {
        Member member = findMemberById(memberId);
        Book book = findBookByIsbn(isbn);

        if (member == null || book == null) {
            System.out.println("❌ Data tidak valid!");
            return;
        }

        member.returnBook(book);
    }
}
