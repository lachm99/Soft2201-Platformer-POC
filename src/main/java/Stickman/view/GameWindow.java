package Stickman.view;

import Stickman.input.KeyboardInputHandler;
import Stickman.model.Hero;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import Stickman.model.Entity;
import Stickman.model.GameEngine;

import java.util.ArrayList;
import java.util.List;

public class GameWindow {
    private final int width;
    private final int height;
    private Scene scene;
    private Pane pane;
    private GameEngine model;
    private List<EntityView> entityViews;
    private EntityView heroView;
    private BackgroundDrawer backgroundDrawer;

    private double xViewportOffset = 0.0;
    private static final double VIEWPORT_MARGIN = 280.0;

    public GameWindow(GameEngine model, int width) {
        this.model = model;
        this.pane = new Pane();
        this.width = width;
        this.height = model.getCurrentLevel().getHeight();
        this.scene = new Scene(pane, this.width, this.height);

        this.entityViews = new ArrayList<>();

        KeyboardInputHandler keyboardInputHandler = new KeyboardInputHandler(model);

        scene.setOnKeyPressed(keyboardInputHandler::handlePressed);
        scene.setOnKeyReleased(keyboardInputHandler::handleReleased);

        this.backgroundDrawer = new BlockedBackground();
        this.heroView = new EntityImage(model.getCurrentLevel().getHero());

        backgroundDrawer.draw(model, pane);
        pane.getChildren().add(this.heroView.getNode());
    }

    public Scene getScene() {
        return this.scene;
    }

    public void run() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(17),
                t -> this.draw()));

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void draw() {
        model.tick();

        List<Entity> entities = model.getCurrentLevel().getEntities();

        for (EntityView entityView: entityViews) {
            entityView.markForDelete();
        }

        updateXViewportOffset();
        backgroundDrawer.update(xViewportOffset);
        heroView.update(xViewportOffset);


        for (Entity entity: entities) {
            boolean notFound = true;
            for (EntityView view: entityViews) {
                if (view.matchesEntity(entity)) {
                    notFound = false;
                    view.update(xViewportOffset);
                }
            }
            if (notFound) {
                if (entity.hasImg()) {
                    EntityView eImg = new EntityImage(entity);
                    entityViews.add(eImg);
                    pane.getChildren().add(eImg.getNode());
                }
                EntityView eWireFrame = new EntityShape(entity);
                entityViews.add(eWireFrame);
                pane.getChildren().add(eWireFrame.getNode());
            }
        }

        for (EntityView entityView: entityViews) {
            if (entityView.isMarkedForDelete()) {
                pane.getChildren().remove(entityView.getNode());
            }
        }
        entityViews.removeIf(EntityView::isMarkedForDelete);
    }


    public void updateXViewportOffset() {
        double heroStageX = heroView.getEntity().getX();
        double heroWindowX = heroStageX - xViewportOffset;

        if (heroWindowX < VIEWPORT_MARGIN) {
            if (xViewportOffset >= 0) { // Don't go further left than the start of the level
                xViewportOffset -= VIEWPORT_MARGIN - heroWindowX;
                if (xViewportOffset < 0) {
                    xViewportOffset = 0;
                }
            }
        } else if (heroWindowX > width - VIEWPORT_MARGIN) {
            if (heroStageX < model.getCurrentLevel().getWidth() - VIEWPORT_MARGIN) {
                xViewportOffset += heroWindowX - (width - VIEWPORT_MARGIN);
            }
        }
    }
}
