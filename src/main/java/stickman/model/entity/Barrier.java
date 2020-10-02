package stickman.model.entity;

import javafx.scene.layout.Pane;

public class Barrier implements Entity {
    private double width;
    private double height;

    private double xPos;
    private double yPos;

    private boolean solid = true;

    public Barrier(double xPos, double yPos, double width, double height) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;
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
    public double getWidth() {
        return this.width;
    }

    @Override
    public double getHeight() {
        return this.height;
    }

    @Override
    public void setX(double xPos) {
        this.xPos = xPos;
    }

    @Override
    public void setY(double yPos) {
        this.yPos = yPos;
    }

    @Override
    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public void drawImg(double viewportOffset, Pane pane) {
        // invisible! do not draw
    }

    @Override
    public boolean updateImg(double viewportOffset) {
        // Invisible!
        return true;
    }

    @Override
    public void tick() {
        // Static - does not do anything.
    }

    @Override
    public boolean getSolid() {
        return this.solid;
    }
}
