package Stickman.model;

import Stickman.view.Layer;
import javafx.geometry.Rectangle2D;

import java.util.ArrayList;
import java.util.Arrays;

public class Mushroom implements Entity {
    private String imgPath;

    private double xPos;
    private double yPos;

    private double height;
    private double width;

    private Layer layer;

    public Mushroom(double xPos, double yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
        layer = Layer.FOREGROUND;
        this.imgPath = "mushroom.png";
        this.height = 30;
        this.width = 18;
    }


    @Override
    public double getX() {
        return this.xPos;
    }

    @Override
    public double getY() {
        return this.yPos;
    }

    @Override
    public boolean setX(double x) {
        this.xPos = x;
        return true;
    }

    @Override
    public boolean setY(double y) {
        this.yPos = y;
        return true;
    }

    @Override
    public double getHeight() {
        return this.height;
    }

    @Override
    public double getWidth() {
        return this.width;
    }

    @Override
    public Layer getLayer() {
        return this.layer;
    }

    @Override
    public void setLayer(Layer layer) {
        this.layer = layer;
    }

    @Override
    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    @Override
    public String getImgPath() {
        return this.imgPath;
    }

    @Override
    public void tick() {
        // Do nothing!
    }

    @Override
    public Rectangle2D getBoundary() {
        return null;
    }

    @Override
    public boolean intersects(Entity s) {
        return false;
    }

}
