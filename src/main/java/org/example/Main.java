package org.example;

import org.example.model.Book;
import org.example.model.User;
import org.example.service.BookService;
import org.example.service.UserService;

/**
 * Main class to demonstrate the library management system.
 */
public class Main {
    /**
     * Main method to run the library management system demonstration.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        UserService userService = new UserService();
        BookService bookService = new BookService(2); // Max borrow limit set to 5

        // Creates two users
        String name = "Alice Smith";
        String userId = "001";
        String email = "alice.smith@example.com";

        String name2 = "Bob Johnson";
        String userId2 = "002";
        String email2 = "bob.johnson@example.com";

        User user1 = userService.createUser(name, userId, email);
        User user2 = userService.createUser(name2, userId2, email2);

        System.out.println("Creating user: " + user1.getName() + " (ID: " + user1.getUserId() + ", Email: " + user1.getEmail() + ")");
        System.out.println("Creating user: " + user2.getName() + " (ID: " + user2.getUserId() + ", Email: " + user2.getEmail() + ")");

        System.out.println();
        System.out.println("-----------------------");

        // Creates six books
        String title1 = "To Kill a Mockingbird";
        String author1 = "Harper Lee";
        String isbn1 = "978-0-06-112008-4";

        String title2 = "1984";
        String author2 = "George Orwell";
        String isbn2 = "978-0-452-28423-4";

        String title3 = "The Great Gatsby";
        String author3 = "F. Scott Fitzgerald";
        String isbn3 = "978-0-7432-7356-5";

        String title4 = "The Hobbit";
        String author4 = "J.R.R. Tolkien";
        String isbn4 = "978-0-618-00221-3";

        String title5 = "The Da Vinci Code";
        String author5 = "Dan Brown";
        String isbn5 = "978-0-385-50420-8";

        String title6 = "The Los Angeles";
        String author6 = "Stuart Kaminsky";
        String isbn6 = "978-0-345-40412-5";

        Book book1 = bookService.createBook(title1, author1, isbn1);
        Book book2 = bookService.createBook(title2, author2, isbn2);
        Book book3 = bookService.createBook(title3, author3, isbn3);
        Book book4 = bookService.createBook(title4, author4, isbn4);
        Book book5 = bookService.createBook(title5, author5, isbn5);
        Book book6 = bookService.createBook(title6, author6, isbn6);

        System.out.println("Creating book: " + book1.getTitle() + " by " + book1.getAuthor() + " (ISBN: " + book1.getIsbn() + ")");
        System.out.println("Creating book: " + book2.getTitle() + " by " + book2.getAuthor() + " (ISBN: " + book2.getIsbn() + ")");
        System.out.println("Creating book: " + book3.getTitle() + " by " + book3.getAuthor() + " (ISBN: " + book3.getIsbn() + ")");
        System.out.println("Creating book: " + book4.getTitle() + " by " + book4.getAuthor() + " (ISBN: " + book4.getIsbn() + ")");
        System.out.println("Creating book: " + book5.getTitle() + " by " + book5.getAuthor() + " (ISBN: " + book5.getIsbn() + ")");
        System.out.println("Creating book: " + book6.getTitle() + " by " + book6.getAuthor() + " (ISBN: " + book6.getIsbn() + ")");

        System.out.println();
        System.out.println("-----------------------");

        // Borrow books
        bookService.borrowBook(user1, book1);
        bookService.borrowBook(user2, book2);

        System.out.println();
        System.out.println("-----------------------");

        // Return books
        bookService.returnBook(user1, book1);
        bookService.returnBook(user2, book2);

        System.out.println();
        System.out.println("-----------------------");

        // Testing borrow limit and status
        bookService.borrowBook(user1, book3);
        bookService.borrowBook(user1, book4);
        bookService.borrowBook(user1, book5);
        bookService.returnBook(user1, book6);

        // Return borrowed books
        bookService.returnBook(user1, book3);
        bookService.returnBook(user1, book4);

        System.out.println();
        System.out.println("-----------------------");

        // Get all books
        for (Book book : bookService.getAllBooks()) {
            System.out.println(book);
        }

        System.out.println();
        System.out.println("-----------------------");

        // Delete a book
        bookService.deleteBook(book6);

        System.out.println();
        System.out.println("-----------------------");

        // Get all books
        for (Book book : bookService.getAllBooks()) {
            System.out.println(book);
        }

        System.out.println();
        System.out.println("-----------------------");

        // Search books by title or author
        bookService.searchBooks(book1.getTitle());
        bookService.searchBooks(book2.getAuthor());
    }
}
