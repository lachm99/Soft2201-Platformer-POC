package Stickman.model;

import javafx.geometry.Rectangle2D;

public interface Entity {

    double getX();

    double getY();

    boolean setX(double x);

    boolean setY(double y);

    void setImg(String imgPath);

    void update();

    Rectangle2D getBoundary();

    boolean intersects(Entity s);
}
