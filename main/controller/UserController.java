package main.controller;

import java.util.*;
import main.model.*;

public class UserController {
    private List<User> users;
    private User authenticatedUser;

    public UserController() {
        users = new ArrayList<>();
    }

    public User registerUser(String type, String username, String email) {
        User user = null;
        if (type.equalsIgnoreCase("admin")) {
            user = new Administrator(username, email);
        } else if (type.equalsIgnoreCase("editor")) {
            user = new Editor(username, email);
        }
        if (user != null) users.add(user);
        return user;
    }

    public boolean login(String username, String password) {
        for (User u : users) {
            if (u.getUsername().equals(username) && u.authenticate(password)) {
                authenticatedUser = u;
                return true;
            }
        }
        return false;
    }

    public void logout() { authenticatedUser = null; }

    public User getCurrentUser() { return authenticatedUser; }

    public boolean hasPermission(String action) {
        if (authenticatedUser == null) return false;
        switch (action.toLowerCase()) {
            case "publish": return authenticatedUser.canPublish();
            case "delete": return authenticatedUser.canDelete();
            case "edit": return authenticatedUser.canEdit();
        }
        return false;
    }
}
