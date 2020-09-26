package Stickman.model;

import Stickman.view.Layer;
import javafx.geometry.Rectangle2D;

public interface Entity {

    double getX();
    double getY();
    boolean setX(double x);
    boolean setY(double y);

    double getHeight();
    double getWidth();

    Layer getLayer();
    void setLayer(Layer layer);

    String getImgPath();
    void setImgPath(String imgPath);


    void update();

    Rectangle2D getBoundary();
    boolean intersects(Entity s);

}
