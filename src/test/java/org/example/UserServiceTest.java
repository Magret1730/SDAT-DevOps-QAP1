package org.example;

import org.example.model.User;
import org.example.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test class for UserService.
 * Includes tests for creating users.
 */
public class UserServiceTest {
    /**
     * Test creating a user.
     */
    @Test
    public void testCreateUser() {
        UserService userService = new UserService();
        User user = userService.createUser("Bob", "U002", "bob.example.com");
        Assertions.assertEquals("Bob", user.getName());
        Assertions.assertEquals("U002", user.getUserId());
        Assertions.assertEquals("bob.example.com", user.getEmail());
    }
}
