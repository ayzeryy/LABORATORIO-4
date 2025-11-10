package main.model;

public class Administrator extends User {

    public Administrator(String username, String email) {
        super(username, email);
    }

    @Override
    public boolean canPublish() { return true; }

    @Override
    public boolean canDelete() { return true; }

    @Override
    public boolean canEdit() { return true; }

    public void deleteContent(Content content) {
        System.out.println("Contenido eliminado: " + content.getTitle());
    }
}
