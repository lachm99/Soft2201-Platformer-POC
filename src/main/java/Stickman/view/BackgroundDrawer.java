package Stickman.view;

import javafx.scene.layout.Pane;
import Stickman.model.GameEngine;

public interface BackgroundDrawer {
    void draw(GameEngine model, Pane pane);
    void update(double xViewportOffset);
}
