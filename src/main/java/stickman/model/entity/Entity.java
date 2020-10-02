package stickman.model.entity;

import javafx.scene.layout.Pane;

public interface Entity {

    double getX();

    double getY();

    double getWidth();

    double getHeight();

    void setX(double xPos);

    void setY(double yPos);

    void setWidth(double width);

    void setHeight(double height);

    void drawImg(double viewportOffset, Pane pane);

    boolean updateImg(double viewportOffset);

    boolean getSolid();

    void tick();

}
