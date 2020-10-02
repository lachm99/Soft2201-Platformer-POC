package stickman.view;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import stickman.model.GameEngine;
import stickman.model.entity.Entity;
import stickman.view.background.BackgroundItem;

import java.util.List;

public class GameWindow {
    private GameEngine engine;
    private Stage stage;
    private Pane pane;
    private double width;
    private double height;

    private double viewportOffset = 0.0;
    private static final double VIEWPORT_MARGIN = 280.0;


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

        // Initialise background items onto the pane
        for (BackgroundItem bg : engine.getCurrentLevel().getBackground()) {
            bg.draw(this.pane);
        }

        for (Entity e : engine.getCurrentLevel().getEntities()) {
            e.drawImg(0, this.pane);
        }
        engine.getCurrentLevel().getHero().drawImg(viewportOffset, pane);


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
        updateViewportOffset();

        for (BackgroundItem bg : engine.getCurrentLevel().getBackground()) {
            bg.update(viewportOffset);
        }
        for (Entity e: List.copyOf(engine.getCurrentLevel().getEntities())) {
            // Delete entities that have exited the stage bounds
            if (e.getX() > engine.getCurrentLevel().getWidth() + e.getWidth() || e.getX() < - Math.abs(e.getWidth())) {
                engine.getCurrentLevel().getEntities().remove(e);
                continue;
            }
            // Update the images- and if that fails, draw them first.
            if (!e.updateImg(viewportOffset)) {
                e.drawImg(viewportOffset, pane);
            }
        }
        engine.getCurrentLevel().getHero().updateImg(viewportOffset);
    }

    private void updateViewportOffset() {
        double heroStageX = engine.getCurrentLevel().getHero().getX();
        double heroWindowX = heroStageX - viewportOffset;

        if (heroWindowX < VIEWPORT_MARGIN) {
            if (viewportOffset >= 0) { // Don't go further left than the start of the level
                viewportOffset -= VIEWPORT_MARGIN - heroWindowX;
                if (viewportOffset < 0) {
                    viewportOffset = 0;
                }
            }
        } else if (heroWindowX > width - VIEWPORT_MARGIN) { // Increase offset, until edge of window is edge of stage.
            if (heroStageX < engine.getCurrentLevel().getWidth() - VIEWPORT_MARGIN) {
                viewportOffset += heroWindowX - (width - VIEWPORT_MARGIN);
            }
        }
    }

    public Pane getPane() {
        return this.pane;
    }
}
