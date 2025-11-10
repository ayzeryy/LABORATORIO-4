package main.model;

import java.util.*;

public class Article extends Content {
    private String text;
    private int wordCount;

    public Article(String title, String author, String text) {
        super(title, author);
        this.text = text;
        this.wordCount = text.split("\\s+").length;
    }

    public String getText() { return text; }
    public void setText(String text) {
        this.text = text;
        this.wordCount = text.split("\\s+").length;
    }

    public int getWordCount() { return wordCount; }

    @Override
    public void display() {
        System.out.println("📄 Artículo: " + getTitle());
        System.out.println("Autor: " + getAuthor());
        System.out.println("Contenido: " + text);
    }

    @Override
    public void publish() { System.out.println("Artículo publicado."); }
    @Override
    public void unpublish() { System.out.println("Artículo despublicado."); }
    @Override
    public boolean isPublished() { return true; }

    @Override
    public boolean matchesKeyword(String keyword) {
        return getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
               text.toLowerCase().contains(keyword.toLowerCase());
    }

    @Override
    public List<String> getSearchableFields() {
        return Arrays.asList(getTitle(), text);
    }
}
