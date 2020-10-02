package stickman.model.entity;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Platform implements Entity {
    private Rectangle view;

    private double xPos;
    private double yPos;
    private double width;
    private double height;

    private boolean solid = true;


    public Platform(double xPos, double yPos, double width, double height) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;

        this.view = new Rectangle(xPos, yPos, width, height);
        this.view.setFill(Paint.valueOf("INDIANRED"));
        this.view.setViewOrder(100);
        this.view.setOpacity(0.8);
    }

    @Override
    public void tick() {
        // Do nothing!
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
        pane.getChildren().add(view);
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
