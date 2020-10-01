package stickman.view;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import stickman.input.KeyboardInputHandler;
import stickman.model.GameEngine;

public class GameWindow {
    private GameEngine engine;
    private Stage stage;
    private Pane pane;
    private double width;
    private double height;

    /**
     * Constructs a new GameWindow
     */
    public GameWindow() {
    }

    /**
     * Assigns the GameEngine that this window will be hosting.
     * @param engine
     */
    public void assignEngine(GameEngine engine) {
        this.engine = engine;
    }


    /**
     * Assigns the Stage that this window will be displaying on.
     * @param stage
     */
    public void assignStage(Stage stage) {
        this.stage = stage;
    }

    /**
     * Sets up a GameWindow that has been initialised with a particular game engine, preparing for display.
     * @param width - the width of the desired display window. Independent of the size of the game stage.
     */
    public void setup(double width) {
        this.stage.setTitle(engine.getGameTitle());
        this.pane = new Pane();
        this.width = width;
        this.height = engine.getCurrentLevel().getHeight();


        this.stage.setScene(new Scene(pane, this.width, this.height));

        this.stage.getScene().setOnKeyPressed(engine.getInputHandler()::handlePressed);
        this.stage.getScene().setOnKeyReleased(engine.getInputHandler()::handleReleased);


        // Initialise the background onto the pane
        engine.getCurrentLevel().getBackground().get(0).draw(pane);

    }

    /**
     * Called once. Shows the window and starts the Loop - calls runNextFrame every frame indefinitely.
     */
    public void run() {
        this.stage.show();

        Timeline timeline;
        timeline = new Timeline(new KeyFrame(Duration.millis(17),
                t -> this.runNextFrame()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    /**
     * Private method called every frame. Gets the Game Engine to tick, then renders updated Game to display.
     */
    private void runNextFrame() {
        this.engine.tick();
        this.render(this.engine);
    }

    private void render(GameEngine engine) {
    }

    public Pane getPane() {
        return this.pane;
    }
}
