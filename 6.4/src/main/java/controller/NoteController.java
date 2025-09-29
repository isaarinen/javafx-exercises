package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import model.Note;
import model.Notebook;

public class NoteController {
    @FXML
    private TextField titleField;

    @FXML
    private TextArea contentArea;

    @FXML
    private VBox notesBox;

    private final Notebook notebook = new Notebook();

    @FXML
    private void addNote() {
        String title = titleField.getText();
        String content = contentArea.getText();
        if (!title.isEmpty() && !content.isEmpty()) {
            Note note = new Note(title, content);
            notebook.addNote(note);
            displayNotes();
            titleField.clear();
            contentArea.clear();
        }
    }

    private void displayNotes() {
        notesBox.getChildren().clear();
        for (Note note : notebook.getNotes()) {
            Label label = new Label(note.getTitle() + ": " + note.getContent());
            notesBox.getChildren().add(label);
        }
    }
}