package stickman.model.entity;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Flag implements Entity {
    private Rectangle view;
    private double width = 32;
    private double height = 384;

    private double xPos;
    private double yPos;

    private boolean solid = false;


    public Flag(double xPos, double yPos) {
        this.xPos = xPos;
        this.yPos = yPos - height;
        this.view = new Rectangle(xPos, this.yPos, width, height);
        this.view.setOpacity(0.6);
        this.view.setViewOrder(50);
        this.view.setFill(Paint.valueOf("LIGHTCORAL"));
    }


    @Override
    public void tick() {
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
        pane.getChildren().add(this.view);
    }

    @Override
    public boolean updateImg(double viewportOffset) {
        view.setTranslateX(-viewportOffset);
        return true;
    }


    @Override
    public boolean getSolid() {
        return this.solid;
    }
}
