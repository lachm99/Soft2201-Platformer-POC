package Stickman.model;

import javafx.geometry.Rectangle2D;

public class Hero implements Entity {
    private String size;

    private double xPos;
    private double yPos;
    private double xVel;
    private double yVel;

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
    }


    @Override
    public double getX() {
        return 0;
    }

    @Override
    public double getY() {
        return 0;
    }

    @Override
    public boolean setX(double x) {
        return false;
    }

    @Override
    public boolean setY(double y) {
        return false;
    }

    @Override
    public void setImg(String imgPath) {

    }

    @Override
    public void update() {

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
