package org.example;

public class BookService {
    private static final int MAX_BORROW_LIMIT = 2;

    public static Book createBook(String title, String author, String isbn) {
        System.out.println("Creating book: " + title + " by " + author + " (ISBN: " + isbn + ")");
        return new Book(title, author, isbn, true);
    }

    public static void borrowBook(User user, Book book) {
        if (user.borrowedBooks.size() >= MAX_BORROW_LIMIT) {
            System.out.println("User has reached the maximum borrow limit.");
            return;
        }

        if (!book.isAvailable) {
            System.out.println("Book is not available for borrowing.");
            return;
        }

        book.setAvailable(false);
        user.borrowedBooks.add(book);
        System.out.println("User " + user.getName() + " borrowed " + book.getTitle());
    }

    public static void returnBook(User user, Book book) {
        if (!user.borrowedBooks.contains(book)) {
            System.out.println("This book was not borrowed by the " + user.getName() + ".");
            return;
        }

        book.setAvailable(true);
        user.borrowedBooks.remove(book);

        System.out.println(book.getTitle() + " has been returned successfully by " + user.getName());
    }
}
