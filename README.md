# Library Management System – Documentation
## 1.0 Clean Code Practices (with examples from my code)
### 1.1 Separation of Concerns
This project follows the separation of concerns principle by organizing code into clearly defined packages:
- `src/main/java/org.example.model` – Contains data models (`Book`, `User`).
- `src/main/java/org.example.service` – Contains business logic (`BookService`, `UserService`).
- `src/main/java/org.example` – Contains the application entry point (`Main`).
- `src/test/java/org.example` – Contains unit tests (`BookServiceTest`, `UserServiceTest`).

![Project Structure](/screenshot/projectStructure.png)

Why this is clean code:
Each class has a single responsibility, making the code easier to understand, test, and maintain.

### 1.2 Meaningful Method and Variable Names

Classes, methods, and variables use clear and descriptive names that explain their purpose without needing extra comments.

Examples from `BookService`:
- `createBook()`
- `borrowBook()`
- `returnBook()`
- `deleteBook()`
- `getAllBooks()`
- `searchBooks()`

Example:
```
public boolean borrowBook(User user, Book book)
```

These names clearly communicate the action being performed.
![Project Structure](/screenshot/returnBook.png)

### 1.3 Defensive Programming and Validation
The code checks for invalid conditions before performing operations to prevent unexpected behavior.
```
if (user.borrowedBooks.size() >= maxBorrowLimit) {
return false;
}

if (!books.contains(book)) {
return false;
}

if (!book.isAvailable) {
return false;
}
```
This ensures:
- Users cannot exceed the borrowing limit
- Books must exist in the catalog
- Only available books can be borrowed

![Project Structure](/screenshot/validation.png)

## 2.0 Project Explanation
### 2.1 What the Project Does
The Library Management System is a console-based Java application that manages books and users.

It allows:
- Creating users
- Creating books
- Borrowing and returning books
- Enforcing a maximum borrow limit
- Searching for books
- Deleting books from the catalog

### 2.2 How the Project Works
- Users are created using `UserService`.
- Books are created and managed using `BookService`.
- Books are stored in memory using a list.
- Borrowing rules are enforced through validation checks.
- Unit tests verify expected behaviors.
- The `Main` class demonstrates real usage of the system.

![Project Structure](/screenshot/runningMain.png)

### 2.3 Test Cases Used
#### BookServiceTest
The following scenarios are tested:
- Creating books.
- Borrowing and returning books.
- Borrowing beyond the allowed limit.
- Borrowing books not in the catalog.
- Returning books not borrowed by a user.
- Deleting books.
- Searching books by title or author.
- Retrieving all books.

![Project Structure](/screenshot/bookServiceTest.png)

#### UserServiceTest
- Verifies user creation
- Confirms name, user ID, and email values

![Project Structure](/screenshot/userServiceTest.png)

## 3.0 Dependencies
### 3.1 Required Dependencies
- Java Development Kit (JDK) – Core programming language
- JUnit 5 (Jupiter) – Unit testing framework

### 3.2 Dependency Sources
- Java SDK configured through IntelliJ
- JUnit 5 provided via project testing setup (JUnit Jupiter)

![Project Structure](/screenshot/dependency.png)

## 4.0 Problems Encountered During the QAP
During the QAP, I initially encountered difficulties structuring the project correctly, particularly with organizing packages for models, services, and tests. After reviewing best practices and adjusting the package layout, I was able to properly structure the project and ensure all components were correctly placed and functioning as expected.

## 5.0 Conclusion
This project demonstrates clean code principles, structured package organization, defensive programming, and unit testing using JUnit. The system is easy to understand, maintain, and extend.