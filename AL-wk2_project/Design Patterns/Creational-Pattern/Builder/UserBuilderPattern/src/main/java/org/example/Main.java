package org.example;

public class Main {
    public static void main(String[] args) {
        User newUser = UserBuilder.builder()
                .firstName("Kingsley")
                .lastName("Acquah")
                .email("kingsleyacquah@gmail.com")
                .build();
        System.out.println(newUser);
    }
}