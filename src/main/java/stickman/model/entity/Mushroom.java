package stickman.model.entity;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Mushroom implements Entity {
    private Rectangle view;

    private double xPos;
    private double yPos;
    private double WIDTH = 32;
    private double HEIGHT = 32;

    private boolean solid = false;


    public Mushroom(double xPos, double yPos) {
        this.xPos = xPos;
        this.yPos = yPos - HEIGHT; // Account for mushroom size offset from floor

        this.view = new Rectangle(xPos, this.yPos, WIDTH, HEIGHT);
        this.view.setFill(Paint.valueOf("CORNFLOWERBLUE"));
        this.view.setOpacity(0.6);
        this.view.setViewOrder(50);
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
        return this.WIDTH;
    }

    @Override
    public double getHeight() {
        return this.HEIGHT;
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
        this.WIDTH = width;
    }

    @Override
    public void setHeight(double height) {
        this.HEIGHT = height;
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

