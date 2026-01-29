package org.example;

public class BookService {
    public static Book createBook(String title, String author, String isbn) {
        return new Book(title, author, isbn, true);
    }
}
