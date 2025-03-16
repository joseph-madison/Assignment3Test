package com.coderscampus.assignment3test;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class UserLoginApplication {
    public static void main(String[] args) {
        UserService userService = new UserService();
        try (Scanner scanner = new Scanner(System.in)) {
			try {
			    List<User> users = userService.loadUsersFromFile("data.txt");
			    int attempts = 0;

			    while (attempts < 5) {
			        System.out.print("Enter username: ");
			        String username = scanner.nextLine();
			        System.out.print("Enter password: ");
			        String password = scanner.nextLine();
			        User loggedInUser = userService.validateLogin(username, password, users);
			        if (loggedInUser != null) {
			            System.out.println("Welcome " + loggedInUser.getName());
			            return;
			        } else {
			            System.out.println("Invalid login, please try again.");
			            attempts++;
			        }
			    }
			    System.out.println("Too many failed login attempts, you are now locked out.");
			} catch (IOException e) {
			    System.out.println("An error occurred while reading the user data: " + e.getMessage());
			}
		}
    }
}
