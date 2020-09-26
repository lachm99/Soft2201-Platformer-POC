package Stickman.model;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;

public interface Entity {

    void setImg(String imgPath);

    void update();

    void render();

    Rectangle2D getBoundary();

    boolean intersects(Entity s);
}
