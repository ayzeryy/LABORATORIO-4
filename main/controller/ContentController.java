package main.controller;

import java.util.*;
import main.model.*;

public class ContentController {
    private List<Content> contents;
    private User currentUser;

    public ContentController() {
        contents = new ArrayList<>();
    }

    public Content createContent(String type, Map<String, Object> data) {
        Content content = null;

        switch (type.toLowerCase()) {
            case "article":
                content = new Article((String) data.get("title"), (String) data.get("author"), (String) data.get("text"));
                break;
            case "video":
                content = new Video((String) data.get("title"), (String) data.get("author"),
                        (String) data.get("url"), (int) data.get("duration"), (String) data.get("resolution"));
                break;
            case "image":
                content = new Image((String) data.get("title"), (String) data.get("author"),
                        (String) data.get("filePath"), (String) data.get("dimensions"), (String) data.get("format"));
                break;
        }

        if (content != null) contents.add(content);
        return content;
    }

    public boolean editContent(String id, Map<String, Object> newData) {
        for (Content c : contents) {
            if (c.getId().equals(id)) {
                c.edit(newData);
                return true;
            }
        }
        return false;
    }

    public boolean deleteContent(String id) {
        return contents.removeIf(c -> c.getId().equals(id));
    }

    public boolean publishContent(String id) {
        for (Content c : contents) {
            if (c.getId().equals(id)) {
                c.publish();
                return true;
            }
        }
        return false;
    }

    public List<Content> searchContent(String keyword) {
        List<Content> result = new ArrayList<>();
        for (Content c : contents) {
            if (c.matchesKeyword(keyword)) result.add(c);
        }
        return result;
    }

    public List<Content> filterByType(String type) {
        List<Content> result = new ArrayList<>();
        for (Content c : contents) {
            if (c.getClass().getSimpleName().equalsIgnoreCase(type)) result.add(c);
        }
        return result;
    }

    public List<Content> getAllContents() { return contents; }

    public String generateReport() {
        StringBuilder report = new StringBuilder("📊 Reporte de contenidos:\n");
        for (Content c : contents) {
            report.append("- ").append(c.getTitle()).append(" (").append(c.getClass().getSimpleName()).append(")\n");
        }
        return report.toString();
    }

    public void setCurrentUser(User user) { this.currentUser = user; }
}
