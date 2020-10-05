package stickman.model.entity;

import javafx.geometry.Rectangle2D;
import javafx.scene.layout.Pane;
import stickman.model.entity.collisions.CollisionHandler;

public interface Entity {

    double getX();

    double getY();

    double getWidth();

    double getHeight();

    void setX(double xPos);

    void setY(double yPos);

    void setWidth(double width);

    void setHeight(double height);

    void drawImg(double xViewportOffset, double yViewportOffset, Pane pane);

    boolean updateImg(double xViewportOffset, double yViewportOffset);

    void clearView(Pane pane);

    void tick(double gravity);

    Rectangle2D getBounds();

    CollisionHandler getCollisionHandler();

    void delete();

    boolean toDelete();

}
