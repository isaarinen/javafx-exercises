package model;

import java.util.ArrayList;
import java.util.List;

public class Notebook {
    private final List<Note> notes = new ArrayList<>();

    public void addNote(Note note) {
        notes.add(note);
    }

    public List<Note> getNotes() {
        return new ArrayList<>(notes);
    }
}