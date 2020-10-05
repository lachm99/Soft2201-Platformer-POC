package stickman.model.entity;

import javafx.geometry.Rectangle2D;
import javafx.scene.layout.Pane;
import stickman.model.entity.collisions.CollisionHandler;
import stickman.model.entity.collisions.SurfaceCollisionHandler;

public class Barrier implements Entity {
    private double width;
    private double height;

    private double xPos;
    private double yPos;

    private CollisionHandler colHand;
    private boolean toDelete;


    public Barrier(double xPos, double yPos, double width, double height) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;
        this.colHand = new SurfaceCollisionHandler(this);
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
        // Invisible
    }

    @Override
    public boolean updateImg(double xViewportOffset, double yViewportOffset) {
        // INvisible
        return true;
    }
    @Override
    public void clearView(Pane pane) {
        // Invisible - nothing to clear!
    }


    @Override
    public void tick(double gravity) {
        // Static - does not do anything.
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
