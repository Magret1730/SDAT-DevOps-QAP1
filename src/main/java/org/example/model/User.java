package org.example.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Model class representing a User in the library system.
 */
public class User {
    public String name;
    public String userId;
    public String email;
    public final List<Book> borrowedBooks;

    /**
     * Constructor to initialize a User object.
     *
     * @param name Name of the user.
     * @param userId Unique identifier for the user.
     * @param email Email address of the user.
     */
    public User(String name, String userId, String email) {
        this.name = name;
        this.userId = userId;
        this.email = email;
        this.borrowedBooks = new ArrayList<>();
    }

    /**
     * Getter for name.
     *
     * @return Name of the user.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for name.
     *
     * @param name Name of the user.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for userId.
     *
     * @return Unique identifier of the user.
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Setter for userId.
     *
     * @param userId Unique identifier of the user.
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Getter for email.
     *
     * @return Email address of the user.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter for email.
     *
     * @param email Email address of the user.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * String representation of the User object.
     *
     * @return String describing the user.
     */
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", userId='" + userId + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
