package main.model;

public abstract class User {
    private String username;
    private String password;
    private String email;

    public User(String username, String email) {
        this.username = username;
        this.email = email;
        this.password = "1234"; // temporal
    }

    public String getUsername() { return username; }
    public String getEmail() { return email; }

    public boolean authenticate(String password) {
        return this.password.equals(password);
    }

    public abstract boolean canPublish();
    public abstract boolean canDelete();
    public abstract boolean canEdit();
}
