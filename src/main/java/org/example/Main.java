package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

        // Creates two users
        String name = "Alice Smith";
        String userId = "001";
        String email = "alice.smith@example.com";

        String name2 = "Bob Johnson";
        String userId2 = "002";
        String email2 = "bob.johnson@example.com";

        User user1 = UserService.createUser(name, userId, email);
        User user2 = UserService.createUser(name2, userId2, email2);

        System.out.println("User 1: " + user1);
        System.out.println("User 2: " + user2);

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

        Book book1 = BookService.createBook(title1, author1, isbn1);
        Book book2 = BookService.createBook(title2, author2, isbn2);
        Book book3 = BookService.createBook(title3, author3, isbn3);
        Book book4 = BookService.createBook(title4, author4, isbn4);
        Book book5 = BookService.createBook(title5, author5, isbn5);
        Book book6 = BookService.createBook(title6, author6, isbn6);

        System.out.println("Book 1: " + book1);
        System.out.println("Book 2: " + book2);
        System.out.println("Book 3: " + book3);
        System.out.println("Book 4: " + book4);
        System.out.println("Book 5: " + book5);
        System.out.println("Book 6: " + book6);
    }
}
