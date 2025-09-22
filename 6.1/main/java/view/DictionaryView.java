package view;

import controller.DictionaryController;
import model.Dictionary;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class DictionaryView extends Application {

    public void start(Stage window) {
        Dictionary dictionary = new Dictionary();
        DictionaryController controller = new DictionaryController();

        controller.addEntry(dictionary, "hello", "A greeting");
        controller.addEntry(dictionary, "world", "The earth or globe");
        controller.addEntry(dictionary, "java", "A programming language");

        TextField wordField = new TextField();
        Button searchButton = new Button("Search");
        Label resultLabel = new Label();

        FlowPane layout = new FlowPane();
        layout.getChildren().add(wordField);
        layout.getChildren().add(searchButton);
        layout.getChildren().add(resultLabel);

        searchButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                String word = wordField.getText().toLowerCase();
                if (word == null || word.trim().isEmpty()) {
                    resultLabel.setText("Please enter a word.");
                } else {
                    String meaning = controller.getDefinition(dictionary, word.trim());
                    if (meaning != null) {
                        resultLabel.setText(meaning);
                    } else {
                        resultLabel.setText("Word not found.");
                    }
                }
            }
        });

        Scene scene = new Scene(layout);
        window.setTitle("Dictionary");
        window.setScene(scene);
        window.show();
    }
}