package main.interfaces;

import java.util.List;

public interface Searchable {
    boolean matchesKeyword(String keyword);
    List<String> getSearchableFields();
}
