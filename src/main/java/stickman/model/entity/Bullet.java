package stickman.model.entity;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Bullet implements VelocityEntity {
    private Rectangle view;
    private double width = 16;
    private double height = 16;

    private double xPos;
    private double yPos;

    private double xVel;
    private double yVel;

    private double dir;

    private boolean drawn;

    private boolean solid = true;


    public Bullet(Hero h) {
        if (h.getDir() > 0) {
            this.xVel = 8;
            this.xPos = h.getX() + h.getWidth();
        } else {
            this.xVel = -8;
            this.xPos = h.getX() - width;
        }
        yPos = h.getY() + h.getHeight()/3;
        this.view = new Rectangle(xPos, yPos, width, height);
        this.view.setOpacity(0.6);
        this.view.setViewOrder(50);
        this.view.setFill(Paint.valueOf("DARKSLATEBLUE"));
        this.drawn = false;
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
    public void tick() {
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
    public void drawImg(double viewportOffset, Pane pane) {
        pane.getChildren().add(this.view);
    }

    @Override
    public boolean updateImg(double viewportOffset) {
        if (!drawn) {
            drawn = true;
            return false;
        }
        view.setX(this.getX() - viewportOffset);
        return true;
    }


    @Override
    public boolean getSolid() {
        return this.solid;
    }
}
