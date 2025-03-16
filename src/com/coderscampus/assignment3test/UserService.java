package com.coderscampus.assignment3test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    public List<User> loadUsersFromFile (String filePath) throws IOException {
        List<User> users = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 3) {
                users.add(new User(parts[0].trim(), parts[1].trim(), parts[2].trim()));
            }
        }
        reader.close();
        return users;
    }

    public User validateLogin(String inputUsername, String inputPassword, List<User> users) {
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(inputUsername) &&
                user.getPassword().equals(inputPassword)) {
                return user;
            }
        }
        return null;
    }
}
