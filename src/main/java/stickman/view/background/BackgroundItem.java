package stickman.view.background;

import javafx.scene.layout.Pane;

public interface BackgroundItem {
    void draw(Pane windowPane);

    void update(double xViewportOffset, double yViewportOffset);
}
