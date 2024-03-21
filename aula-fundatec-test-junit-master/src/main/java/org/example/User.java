package org.example;

public class User {
    private int age;
    public User(String age) {
        try {
            this.age = Integer.parseInt(age);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Age must be a integer.");
        }
    }
}
