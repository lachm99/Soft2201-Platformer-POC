package Stickman.model;

import Stickman.view.Layer;
import javafx.geometry.Rectangle2D;

public interface Entity {

    double getX();
    double getY();
    boolean setX(double x);
    boolean setY(double y);

    void setXVel(double xVel);
    double getXVel();
    void setYVel(double xVel);
    double getYVel();



    double getHeight();
    double getWidth();

    Layer getLayer();
    void setLayer(Layer layer);

    String getImgPath();
    void setImgPath(String imgPath);


    void tick();

    Rectangle2D getBoundary();
    boolean intersects(Entity s);

}
