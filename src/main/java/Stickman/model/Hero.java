package Stickman.model;

import Stickman.view.Layer;
import javafx.geometry.Rectangle2D;

public class Hero implements Entity {
    private String size;
    private String imgPath;

    private double xPos;
    private double yPos;
    private double xVel;
    private double yVel;

    private double height;
    private double width;

    private Layer layer;

    public Hero() {
        this.size = "normal";
        this.xPos = 0;
        this.yPos = 0;
    }

    public String getSize() {
        return this.size;
    }

    public void setSize(String size) {
        this.size = size;
        if (size.equalsIgnoreCase("large")) {
            this.height = 90;
        } else {
            this.height = 40;
        }
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
        this.xPos += this.xVel;
        this.yPos += this.yVel;
    }

    @Override
    public Rectangle2D getBoundary() {
        return null;
    }

    @Override
    public boolean intersects(Entity s) {
        return false;
    }

    @Override
    public void setXVel(double xVel) {
        this.xVel = xVel;
    }

    @Override
    public double getXVel() {
        return xVel;
    }

    @Override
    public void setYVel(double yVel) {
        this.yVel = yVel;
    }

    @Override
    public double getYVel() {
        return yVel;
    }
}
