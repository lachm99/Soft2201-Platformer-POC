package stickman.model.entity;

import javafx.geometry.Rectangle2D;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import stickman.model.entity.collisions.BulletCollisionHandler;
import stickman.model.entity.collisions.CollisionHandler;

public class Bullet implements VelocityEntity {
    private Rectangle view;
    private double width;
    private double height;

    private double xPos;
    private double yPos;

    private double xVel;
    private double yVel;

    private double dir;

    private boolean drawn;

    private boolean toDelete;

    private CollisionHandler colHand;


    public Bullet(Hero h) {
        width = h.getWidth()/4;
        height = h.getHeight()/6;

        if (h.getDir() > 0) {
            this.xVel = 8;
            this.xPos = h.getX() + h.getWidth();
        } else {
            this.xVel = -8;
            this.xPos = h.getX() - width;
        }
        yPos = h.getY() + h.getHeight()/2;
        this.view = new Rectangle(xPos, yPos, width, height);
        this.view.setOpacity(0.9);
        this.view.setViewOrder(10);
        this.view.setFill(Paint.valueOf("BLACK"));
        this.drawn = false;
        this.colHand = new BulletCollisionHandler(this);
    }


    @Override
    public void setXVel(double xVel) {
        this.xVel = xVel;
    }

    @Override
    public double getXVel() {
        return this.xVel;
    }

    @Override
    public void setYVel(double yVel) {
        this.yVel = yVel;
    }

    @Override
    public double getYVel() {
        return this.yVel;
    }

    @Override
    public void tick(double gravity) {
        this.xPos += this.xVel;
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
        if (!drawn) {
            drawn = true;
            return false;
        }
        view.setX(this.getX() -xViewportOffset);
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
