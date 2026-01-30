package org.example;

import java.util.ArrayList;
import java.util.List;

public class BookService {
    private final int maxBorrowLimit;
    private final List<Book> books = new ArrayList<>();

    public BookService(int maxBorrowLimit) {
        this.maxBorrowLimit = maxBorrowLimit;
    }

    // Create book
    public Book createBook(String title, String author, String isbn) {
        Book book = new Book(title, author, isbn, true);
        books.add(book);

        return  book;
    }

    // Borrow book
    public boolean borrowBook(User user, Book book) {
        if (user.borrowedBooks.size() >= maxBorrowLimit) {
            System.out.println("User has reached the maximum borrow limit.");
            return false;
        }

        if (!books.contains(book)) {
            System.out.println("Book not found in the catalog.");
            return false;
        }

        if (!book.isAvailable) {
            System.out.println("Book is not available for borrowing.");
            return false;
        }

        book.setAvailable(false);
        user.borrowedBooks.add(book);
        System.out.println("User " + user.getName() + " borrowed " + book.getTitle());
        return true;
    }

    // Return book
    public boolean returnBook(User user, Book book) {
        if (!books.contains(book)) {
            System.out.println("Book not found in the catalog.");
            return false;
        }

        if (!user.borrowedBooks.contains(book)) {
            System.out.println("This book was not borrowed by " + user.getName() + ".");
            return false;
        }

        book.setAvailable(true);
        user.borrowedBooks.remove(book);

        System.out.println(book.getTitle()  + " has been returned successfully by " + user.getName());
        return true;
    }

    // Delete book from catalog
    public boolean deleteBook(Book book) {
        if (books.contains(book)) {
            books.remove(book);
            System.out.println("Book " + book.getTitle() + " has been deleted from the catalog.");
            return true;
        } else {
            System.out.println("Book " + book.getTitle() + " not found in the catalog.");
            return false;
        }
    }

    // Get all books
    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    // Search books by title or author
    public List<Book> searchBooks(String query) {
        List<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                    book.getAuthor().toLowerCase().contains(query.toLowerCase())) {
                results.add(book);
            } else {
                System.out.println("No match found for book: " + query);
            }
        }

        System.out.println("Search results for \"" + query + "\":");
        for (Book book : results) {
            System.out.println(book);
        }
        return results;
    }
}
