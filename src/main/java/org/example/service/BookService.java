package org.example.service;

import org.example.model.Book;
import org.example.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Service class for managing books in the library system.
 * Includes methods for creating, borrowing, returning, deleting, and searching books.
 * Also enforces a maximum borrow limit per user.
 */
public class BookService {
    private final int maxBorrowLimit;
    private final List<Book> books = new ArrayList<>();

    /**
     * Constructor to initialize BookService with a maximum borrow limit.
     * @param maxBorrowLimit Maximum number of books a user can borrow.
     */
    public BookService(int maxBorrowLimit) {
        this.maxBorrowLimit = maxBorrowLimit;
    }

    /**
     * Create a new book and add it to the catalog.
     *
     * @param title Title of the book.
     * @param author Author of the book.
     * @param isbn ISBN of the book.
     * isAvailable Availability status of the book.
     * @return The created Book object.
     */
    public Book createBook(String title, String author, String isbn) {
        Book book = new Book(title, author, isbn, true);
        books.add(book);

        return  book;
    }

    /**
     * Borrow a book for a user if within borrow limit and book is available.
     *
     * @param user The user borrowing the book.
     * @param book The book to be borrowed.
     * @return True if the book was successfully borrowed, false otherwise.
     */
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

    /**
     * Return a borrowed book for a user.
     *
     * @param user The user returning the book.
     * @param book The book to be returned.
     * @return True if the book was successfully returned, false otherwise.
     */
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

    /**
     * Delete a book from the catalog.
     *
     * @param book The book to be deleted.
     * @return True if the book was successfully deleted, false otherwise.
     */
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

    /**
     * Get a list of all books in the catalog.
     *
     * @return List of all Book objects.
     */
    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    /**
     * Search for books by title or author.
     *
     * @param query The search query (title or author).
     * @return List of Book objects that match the search query.
     */
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
