package main.model;

public class Editor extends User {

    public Editor(String username, String email) {
        super(username, email);
    }

    @Override
    public boolean canPublish() { return false; }

    @Override
    public boolean canDelete() { return false; }

    @Override
    public boolean canEdit() { return true; }
}
