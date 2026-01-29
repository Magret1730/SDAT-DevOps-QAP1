package org.example;

import java.util.ArrayList;
import java.util.List;

public class BookService {
    private static final int MAX_BORROW_LIMIT = 2;
    private static final List<Book> books = new ArrayList<>();

    // Create book
    public static Book createBook(String title, String author, String isbn) {
        System.out.println("Creating book: " + title + " by " + author + " (ISBN: " + isbn + ")");
        Book book = new Book(title, author, isbn, true);
        books.add(book);

        return  book;
    }

    // Borrow book
    public static boolean borrowBook(User user, Book book) {
        if (user.borrowedBooks.size() >= MAX_BORROW_LIMIT) {
            System.out.println("User has reached the maximum borrow limit.");
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
    public static boolean returnBook(User user, Book book) {
        if (!user.borrowedBooks.contains(book)) {
            System.out.println("This book was not borrowed by " + user.getName() + ".");
            return false;
        }

        book.setAvailable(true);
        user.borrowedBooks.remove(book);

        System.out.println(book.getTitle() + " has been returned successfully by " + user.getName());
        return true;
    }

    // Delete book from catalog
    public static boolean deleteBook(Book book) {
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
    public static List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }
}
