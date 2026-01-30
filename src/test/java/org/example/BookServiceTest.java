package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BookServiceTest {

    @Test
    public void testCreateBook() {
        BookService bookService = new BookService(2);
        Book book = bookService.createBook("1984", "George Orwell", "1234567890");

        Assertions.assertEquals("1984", book.getTitle());
        Assertions.assertEquals("George Orwell", book.getAuthor());
        Assertions.assertEquals("1234567890", book.getIsbn());
        Assertions.assertTrue(book.isAvailable());
    }

    @Test
    public void testBorrowAndReturnBook() {
        BookService bookService = new BookService(2);
        User user = new User("Alice", "U001", "alice@example.com");
        Book book = bookService.createBook("1984", "George Orwell", "1234567890");
        Book book2 = bookService.createBook("1984", "George Orwell", "1234567890");
        Book book3 = bookService.createBook("The Great Gatsby", "F. Scott Fitzgerald", "0987654321");

        boolean borrowResult = bookService.borrowBook(user, book);
        Assertions.assertTrue(borrowResult);
        Assertions.assertFalse(book.isAvailable());
        Assertions.assertEquals(1, user.borrowedBooks.size());

        boolean returnResult = bookService.returnBook(user, book);
        Assertions.assertTrue(returnResult);
        Assertions.assertTrue(book.isAvailable());
        Assertions.assertEquals(0, user.borrowedBooks.size());

        // Test borrowing beyond limit
        bookService.borrowBook(user, book);
        bookService.borrowBook(user, book2);
        boolean borrowBeyondLimit = bookService.borrowBook(user, book3);
        Assertions.assertFalse(borrowBeyondLimit);
    }

    @Test
    public void testDeleteBook() {
        BookService bookService = new BookService(2);
        Book book = bookService.createBook("1984", "George Orwell", "1234567890");

        boolean deleteResult = bookService.deleteBook(book);
        Assertions.assertTrue(deleteResult);
    }

    @Test
    public void testGetAllBooks() {
        BookService bookService = new BookService(2);
        Book book1 = bookService.createBook("1984", "George Orwell", "1234567890");
        Book book2 = bookService.createBook("The Great Gatsby", "F. Scott Fitzgerald", "0987654321");

        Assertions.assertEquals(2, bookService.getAllBooks().size());
        Assertions.assertTrue(bookService.getAllBooks().contains(book1));
        Assertions.assertTrue(bookService.getAllBooks().contains(book2));
    }

    @Test
    public void testSearchBooks() {
        BookService bookService = new BookService(2);
        Book book1 = bookService.createBook("1984", "George Orwell", "1234567890");
        Book book2 = bookService.createBook("The Great Gatsby", "F. Scott Fitzgerald", "0987654321");

        Assertions.assertEquals(1, bookService.searchBooks("1984").size());
        Assertions.assertEquals(1, bookService.searchBooks("F. Scott Fitzgerald").size());
    }
}
