package model;

import java.util.HashMap;

public class Dictionary {
    private HashMap<String, String> dictionary;

    public Dictionary() {
        dictionary = new HashMap<>();
    }
    public void addEntry(String word, String definition) {
        dictionary.put(word, definition);
    }
    public String getDefinition(String word) {
        return dictionary.get(word);
    }
    public void removeEntry(String word) {
        dictionary.remove(word);
    }
}
