package org.example;

public class UserService {
    public User createUser(String name, String userId, String email) {
//        System.out.println("Creating user: " + name + " (ID: " + userId + ", Email: " + email + ")");
        return new User(name, userId, email);
    }
}
