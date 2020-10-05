package stickman.model.entity;

import javafx.geometry.Rectangle2D;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import stickman.model.entity.collisions.CollisionHandler;
import stickman.model.entity.collisions.SurfaceCollisionHandler;

public class Platform implements Entity {
    private Rectangle view;

    private double xPos;
    private double yPos;
    private double width;
    private double height;

    private CollisionHandler colHand;
    private boolean toDelete;


    public Platform(double xPos, double yPos, double width, double height) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;

        this.view = new Rectangle(xPos, yPos, width, height);
        this.view.setFill(Paint.valueOf("PERU"));
        this.view.setStroke(Paint.valueOf("SEAGREEN"));
        this.view.setStrokeWidth(3);
        this.view.setViewOrder(100);

        this.colHand = new SurfaceCollisionHandler(this);
    }

    @Override
    public void tick(double gravity) {
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
    public void drawImg(double xViewportOffset, double yViewportOffset, Pane pane) {
        pane.getChildren().add(view);
    }

    @Override
    public boolean updateImg(double xViewportOffset, double yViewportOffset) {
        view.setTranslateX(-xViewportOffset);
        view.setTranslateY(-yViewportOffset);
        return true;
    }
    @Override
    public void clearView(Pane pane) {
        pane.getChildren().remove(this.view);
    }


    @Override
    public Rectangle2D getBounds() {
        return new Rectangle2D(this.xPos, this.yPos, this.width, this.height);
    }

    @Override
    public CollisionHandler getCollisionHandler() {
        return colHand;
    }

    @Override
    public void delete() {
        this.toDelete = true;
    }

    @Override
    public boolean toDelete() {
        return this.toDelete;
    }

}
