package stickman.view;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
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

    private Timeline timeline;

    private double xViewportOffset = 0.0;
    private double yViewportOffset = 0.0;
    private static final double VIEWPORT_MARGIN = 280.0;
    private static final double VIEWPORT_MARGIN_Y = 200;


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
    public void setup(double width, double height) {
        this.stage.setTitle(engine.getGameTitle());
        this.pane = new Pane();
        this.width = width;
        this.height = height;
        this.stage.setScene(new Scene(pane, this.width, this.height));
        this.stage.getScene().setOnKeyPressed(engine.getInputHandler()::handlePressed);
        this.stage.getScene().setOnKeyReleased(engine.getInputHandler()::handleReleased);

        initScene();
    }

    public void initScene() {
        this.pane.getChildren().clear();
        // Initialise background items onto the pane
        for (BackgroundItem bg : engine.getCurrentLevel().getBackground()) {
            bg.draw(this.pane);
        }

        for (Entity e : engine.getCurrentLevel().getEntities()) {
            e.drawImg(xViewportOffset, yViewportOffset, this.pane);
        }
    }

    /**
     * Called once. Shows the window and starts the Loop - calls runNextFrame every frame indefinitely.
     */
    public void run() {
        this.stage.show();

        this.timeline = new Timeline(new KeyFrame(Duration.millis(17),
                t -> this.runNextFrame()));
        this.timeline.setCycleCount(Timeline.INDEFINITE);
        this.timeline.play();
    }

    /**
     * Private method called every frame. Gets the Game Engine to tick, then renders updated Game to display.
     */
    private void runNextFrame() {
        this.checkGameState();
        this.engine.tick();
        this.render(this.engine);
    }

    private void checkGameState() {
        if (this.engine.getEndState() == 1) {
            this.timeline.stop();
            Text winMsg = new Text("GAME WON");
            winMsg.setTextAlignment(TextAlignment.CENTER);
            winMsg.setFont(new Font(48));
            winMsg.setFill(Color.SALMON);
            StackPane end = new StackPane();
            end.getChildren().add(winMsg);
            Scene scene = new Scene(end, this.width, this.height, Color.BLACK);
            stage.setScene(scene);
        } else if (this.engine.getEndState() == -1) {
            this.timeline.stop();
            Text loseMsg = new Text("GAME LOST");
            loseMsg.setTextAlignment(TextAlignment.CENTER);
            loseMsg.setFont(new Font(48));
            loseMsg.setFill(Color.SALMON);
            StackPane end = new StackPane();
            end.getChildren().add(loseMsg);
            Scene scene = new Scene(end, this.width, this.height, Color.BLACK);
            stage.setScene(scene);
        }
    }

    private void render(GameEngine engine) {
        updateViewportOffset();

        for (BackgroundItem bg : engine.getCurrentLevel().getBackground()) {
            bg.update(xViewportOffset, yViewportOffset);
        }
        for (Entity e: List.copyOf(engine.getCurrentLevel().getEntities())) {
            // Clear and remove all entities that have been marked for delete.
            if (e.toDelete()) {
                engine.getCurrentLevel().getEntities().remove(e);
                e.clearView(this.pane);
                continue;
            }
            // Update the images- and if that fails, draw them first.
            if (!e.updateImg(xViewportOffset, yViewportOffset)) {
                e.drawImg(xViewportOffset, yViewportOffset, pane);
            }
        }
    }

    private void updateViewportOffset() {
        double heroStageX = engine.getCurrentLevel().getHero().getX();
        double heroStageY = engine.getCurrentLevel().getHero().getY();

        double heroWindowX = heroStageX - xViewportOffset;
        double heroWindowY =  heroStageY - yViewportOffset;


        if (heroWindowX < VIEWPORT_MARGIN) {
            if (xViewportOffset >= 0) { // Don't go further left than the start of the level
                xViewportOffset -= VIEWPORT_MARGIN - heroWindowX;
                if (xViewportOffset < 0) {
                    xViewportOffset = 0;
                }
            }
        } else if (heroWindowX > width - VIEWPORT_MARGIN) { // Increase offset, until edge of window is edge of stage.
            if (heroStageX < engine.getCurrentLevel().getWidth() - VIEWPORT_MARGIN) {
                xViewportOffset += heroWindowX - (width - VIEWPORT_MARGIN);
            }
        }

        if (heroWindowY < VIEWPORT_MARGIN_Y) {
            if (yViewportOffset >= 0) {
                yViewportOffset -= VIEWPORT_MARGIN_Y - heroWindowY;
            } if (yViewportOffset < 0) {
                yViewportOffset = 0;
            }
        } else if (heroWindowY > height - VIEWPORT_MARGIN_Y) {
            if (heroStageY < engine.getCurrentLevel().getHeight() - VIEWPORT_MARGIN_Y/2.5) {
                yViewportOffset += heroWindowY - (height - VIEWPORT_MARGIN_Y);
            }
        }
    }

    public Pane getPane() {
        return this.pane;
    }
}
