package Stickman.model;

import Stickman.view.Layer;
import javafx.geometry.Rectangle2D;

public interface Entity {

    double getX();
    double getY();
    boolean setX(double x);
    boolean setY(double y);

    int[] getCollisionFlags();
    void setCollisionFlags(int x, int y);

    double getHeight();
    double getWidth();

    Layer getLayer();
    void setLayer(Layer layer);

    boolean hasImg();
    String getImgPath();
    void setImgPath(String imgPath);

    void tick();

    void collide(Entity entity);
}
