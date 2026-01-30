package org.example.model;

/**
 * Model class representing a Book in the library system.
 */
public class Book {
    public String title;
    public String author;
    public String isbn;
    public boolean isAvailable;

    /**
     * Constructor to initialize a Book object.
     *
     * @param title Title of the book.
     * @param author Author of the book.
     * @param isbn ISBN of the book.
     * @param isAvailable Availability status of the book.
     */
    public Book(String title, String author, String isbn, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = isAvailable;
    }

    /**
     * Getter for title.
     *
     * @return Title of the book.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Setter for title.
     *
     * @param title Title of the book.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Getter for author.
     *
     * @return Author of the book.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Setter for author.
     *
     * @param author Author of the book.
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Getter for ISBN.
     *
     * @return ISBN of the book.
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Setter for ISBN.
     *
     * @param isbn ISBN of the book.
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Getter for availability status.
     *
     * @return True if the book is available, false otherwise.
     */
    public boolean isAvailable() {
        return isAvailable;
    }

    /**
     * Setter for availability status.
     *
     * @param available Availability status of the book.
     */
    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    /**
     * String representation of the Book object.
     *
     * @return String describing the book.
     */
    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
