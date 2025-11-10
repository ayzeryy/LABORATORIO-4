package main.model;

import java.util.*;
import main.interfaces.Publishable;
import main.interfaces.Searchable;

public abstract class Content implements Publishable, Searchable {
    private String id;
    private String title;
    private String author;
    private Date creationDate;
    private Date lastModified;
    private boolean published;
    private List<Category> categories;

    public Content(String title, String author) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.author = author;
        this.creationDate = new Date();
        this.lastModified = new Date();
        this.published = false;
        this.categories = new ArrayList<>();
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; this.lastModified = new Date(); }
    public String getAuthor() { return author; }

    public void addCategory(Category category) { categories.add(category); }
    public void removeCategory(Category category) { categories.remove(category); }
    public List<Category> getCategories() { return categories; }

    public abstract void display();

    public void edit(Map<String, Object> newData) {
        if (newData.containsKey("title")) setTitle((String) newData.get("title"));
    }
}
