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
}
