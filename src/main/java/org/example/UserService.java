package org.example;

public class UserService {
    public User createUser(String name, String userId, String email) {
        return new User(name, userId, email);
    }
}
