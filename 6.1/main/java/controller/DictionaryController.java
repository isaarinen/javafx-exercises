package controller;

import view.DictionaryView;
import model.Dictionary;

public class DictionaryController {
    public void addEntry(Dictionary dictionary, String word, String definition) {
        dictionary.addEntry(word, definition);
    }
    public String getDefinition(Dictionary dictionary, String word) {
        return dictionary.getDefinition(word);
    }
    public void removeEntry(Dictionary dictionary, String word) {
        dictionary.removeEntry(word);
    }
}
