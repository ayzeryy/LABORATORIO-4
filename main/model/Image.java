package main.model;

import java.util.*;

public class Image extends Content {
    private String filePath;
    private String dimensions;
    private String format;

    public Image(String title, String author, String filePath, String dimensions, String format) {
        super(title, author);
        this.filePath = filePath;
        this.dimensions = dimensions;
        this.format = format;
    }

    public String getFilePath() { return filePath; }
    public void setFilePath(String path) { this.filePath = path; }
    public String getDimensions() { return dimensions; }
    public String getFormat() { return format; }

    @Override
    public void display() {
        System.out.println("🖼 Imagen: " + getTitle());
        System.out.println("Ruta: " + filePath);
        System.out.println("Formato: " + format + " | Dimensiones: " + dimensions);
    }

    @Override
    public void publish() { System.out.println("Imagen publicada."); }
    @Override
    public void unpublish() { System.out.println("Imagen despublicada."); }
    @Override
    public boolean isPublished() { return true; }

    @Override
    public boolean matchesKeyword(String keyword) {
        return getTitle().toLowerCase().contains(keyword.toLowerCase());
    }

    @Override
    public List<String> getSearchableFields() {
        return Arrays.asList(getTitle(), filePath);
    }
}
