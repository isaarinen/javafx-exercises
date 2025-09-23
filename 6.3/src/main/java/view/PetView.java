package view;

import controller.PetController;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.Pet;

public class PetView extends Application {
    private static final int CANVAS_SIZE = 400;
    private static final double PET_SPEED = 2.5;

    private Canvas canvas;
    private GraphicsContext gc;
    private Image petImage;
    private Pet pet;
    private PetController controller;

    private Double mouseX = null, mouseY = null;
    private AnimationTimer timer;

    @Override
    public void start(Stage stage) {
        petImage = new Image(getClass().getResourceAsStream("/pet.png"));        pet = new Pet(CANVAS_SIZE / 2.0, CANVAS_SIZE / 2.0);
        controller = new PetController(pet);

        canvas = new Canvas(CANVAS_SIZE, CANVAS_SIZE);
        gc = canvas.getGraphicsContext2D();

        canvas.setOnMouseMoved(this::onMouseMoved);
        canvas.setOnMouseExited(e -> { mouseX = null; mouseY = null; });

        StackPane root = new StackPane(canvas);
        Scene scene = new Scene(root, CANVAS_SIZE, CANVAS_SIZE);
        stage.setTitle("Virtual Pet");
        stage.setScene(scene);
        stage.show();

        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (mouseX != null && mouseY != null) {
                    controller.movePetTowards(mouseX, mouseY, PET_SPEED);
                    if (Math.abs(pet.getX() - mouseX) < 1 && Math.abs(pet.getY() - mouseY) < 1) {
                        mouseX = null; mouseY = null;
                    }
                }
                draw();
            }
        };
        timer.start();
    }

    private void onMouseMoved(MouseEvent event) {
        mouseX = event.getX();
        mouseY = event.getY();
    }

    private static final double PET_WIDTH = 64;
    private static final double PET_HEIGHT = 64;

    private void draw() {
        gc.clearRect(0, 0, CANVAS_SIZE, CANVAS_SIZE);
        gc.drawImage(
            petImage,
            pet.getX() - PET_WIDTH / 2,
            pet.getY() - PET_HEIGHT / 2,
            PET_WIDTH,
            PET_HEIGHT
        );
    }
}