package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserServiceTest {
    @Test
    public void testCreateUser() {
        UserService userService = new UserService();
        User user = userService.createUser("Bob", "U002", "bob.example.com");
        Assertions.assertEquals("Bob", user.getName());
        Assertions.assertEquals("U002", user.getUserId());
        Assertions.assertEquals("bob.example.com", user.getEmail());
    }
}
