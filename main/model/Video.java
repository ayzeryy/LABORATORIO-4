package main.model;

import java.util.*;

public class Video extends Content {
    private String url;
    private int duration;
    private String resolution;

    public Video(String title, String author, String url, int duration, String resolution) {
        super(title, author);
        this.url = url;
        this.duration = duration;
        this.resolution = resolution;
    }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
    public int getDuration() { return duration; }
    public String getResolution() { return resolution; }

    @Override
    public void display() {
        System.out.println("🎥 Video: " + getTitle());
        System.out.println("URL: " + url);
        System.out.println("Duración: " + duration + "s");
        System.out.println("Resolución: " + resolution);
    }

    @Override
    public void publish() { System.out.println("Video publicado."); }
    @Override
    public void unpublish() { System.out.println("Video despublicado."); }
    @Override
    public boolean isPublished() { return true; }

    @Override
    public boolean matchesKeyword(String keyword) {
        return getTitle().toLowerCase().contains(keyword.toLowerCase());
    }

    @Override
    public List<String> getSearchableFields() {
        return Arrays.asList(getTitle(), url);
    }
}
