package stickman.view.background;

import javafx.scene.layout.Pane;

public interface BackgroundItem {
    void draw(Pane windowPane);

    void update(int viewportOffset);
}
