package Stickman.model;

import Stickman.view.Layer;
import javafx.geometry.Rectangle2D;

public class Mushroom implements Entity {
    private String imgPath;

    private double xPos;
    private double yPos;


    private double height;
    private double width;

    private Layer layer;
    private int[] collisionFlags;

    public Mushroom(double xPos, double yPos, double height) {
        this.xPos = xPos;
        this.yPos = yPos;
        layer = Layer.FOREGROUND;
        this.imgPath = "mushroom.png";
        this.height = height;
        this.width = height*0.9;
        this.layer = Layer.FOREGROUND;
        this.collisionFlags = new int[] {0,0};
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
    public boolean hasImg() {
        return (this.getImgPath() != null);
    }

    @Override
    public void tick() {
        // Do nothing!
    }

    @Override
    public void collide(Entity entity) {
    }

    @Override
    public int[] getCollisionFlags() {
        return this.collisionFlags;
    }

    @Override
    public void setCollisionFlags(int x, int y) {
        this.collisionFlags[0] = x;
        this.collisionFlags[1] = y;
    }

}
