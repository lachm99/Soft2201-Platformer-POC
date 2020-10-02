package stickman.model.entity;

import javafx.scene.layout.Pane;

public interface Entity {

    public double getX();

    public double getY();

    public double getWidth();

    public double getHeight();

    public void setX(double xPos);

    public void setY(double yPos);

    public void setWidth(double width);

    public void setHeight(double height);

    public void drawImg(double viewportOffset, Pane pane);

    public void updateImg(double viewportOffset);

    public void tick();

}
