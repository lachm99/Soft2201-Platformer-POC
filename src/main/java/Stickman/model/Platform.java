package Stickman.model;

import Stickman.view.Layer;
import javafx.geometry.Rectangle2D;

public class Platform implements Entity {
    private String imgPath;

    private double xPos;
    private double yPos;

    private double height;
    private double width;
    private Layer layer;
    private int[] collisionFlags;


    public Platform(double x, double y, double len) {
        this.xPos = x;
        this.yPos = y;
        this.height = 15;
        this.width = len;
        this.layer = Layer.FOREGROUND;
        this.imgPath = null;
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
    public boolean hasImg() {
        return (false);
    }


    @Override
    public String getImgPath() {
        return this.imgPath;
    }

    @Override
    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    @Override
    public void tick() {
        //nothing
    }

    @Override
    public void collide(Entity entity) {
        entity.setY(this.yPos - entity.getHeight());
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
