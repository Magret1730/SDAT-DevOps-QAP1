package org.example.service;

import org.example.model.User;

/**
 * Service class for managing users in the library system.
 * Includes methods for creating users.
 */
public class UserService {
    /**
     * Create a new user.
     *
     * @param name Name of the user.
     * @param userId Unique identifier for the user.
     * @param email Email address of the user.
     * @return The created User object.
     */
    public User createUser(String name, String userId, String email) {
        return new User(name, userId, email);
    }
}
