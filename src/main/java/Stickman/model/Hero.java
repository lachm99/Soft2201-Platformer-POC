package Stickman.model;

import Stickman.view.Layer;
import javafx.geometry.Rectangle2D;

import java.util.ArrayList;
import java.util.Arrays;

public class Hero implements MovableEntity {
    private String size;
    private double strength;

    private ArrayList<String> walkLeftImg;
    private ArrayList<String> faceLeftImg;
    private ArrayList<String> walkRightImg;
    private ArrayList<String> faceRightImg;

    private String imgPath;
    private int frameIndex;
    private int picIndex;
    private int imgList;

    private double xPos;
    private double yPos;
    private double xVel;
    private double yVel;

    private double height;
    private double width;

    private Layer layer;
    private boolean grounded;

    private int[] collisionFlags;

    public Hero() {
        this.size = "normal";
        this.strength = 1;
        this.xPos = 0;
        this.yPos = 0;
        this.walkLeftImg = new ArrayList<String>(Arrays.asList("ch_walk5.png",
                "ch_walk6.png",
                "ch_walk7.png",
                "ch_walk8.png"));
        this.faceLeftImg = new ArrayList<String>(Arrays.asList("ch_stand4.png",
                "ch_stand5.png",
                "ch_stand6.png"));

        this.walkRightImg = new ArrayList<String>(Arrays.asList("ch_walk1.png",
                "ch_walk2.png",
                "ch_walk3.png",
                "ch_walk4.png"));
        this.faceRightImg = new ArrayList<String>(Arrays.asList("ch_stand1.png",
                "ch_stand2.png",
                "ch_stand3.png"));
        this.imgList = 3;
        this.collisionFlags = new int[] {0,0};
    }

    public String getSize() {
        return this.size;
    }

    public void setSize(String size) {
        this.size = size;
        if (size.equalsIgnoreCase("large")) {
            this.height = 136;
            this.width = 80;
            this.strength = 5;
        } else {
            this.height = 50;
            this.width = 30;
            this.strength = 2;
        }
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
        if (this.getImgPath() != null) {
            return true;
        }
        return false;
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
    public void tick() {
        if (this.collisionFlags[1] != -1) {
            this.yPos += this.yVel;
        }
        this.xPos += this.xVel;
        animate();
    }

    @Override
    public void collide(Entity entity) {

    }

    private void animate() {
        if (frameIndex++ %15 == 0) {
            this.picIndex ++;
        }
        if (imgList == 0) {
            setImgPath(walkLeftImg.get(picIndex%walkLeftImg.size()));
        } else if (imgList == 1) {
            setImgPath(walkRightImg.get(picIndex%walkRightImg.size()));
        } else if (imgList == 2) {
            setImgPath(faceLeftImg.get(picIndex%faceLeftImg.size()));
        } else if (imgList == 3) {
            setImgPath(faceRightImg.get(picIndex%faceRightImg.size()));
        }
    }

    public boolean willIntersectX(Entity s) {
        if (xPos + width + xVel > s.getX() &&
                xPos + xVel < s.getX() + s.getWidth() &&
                yPos + height > s.getY() &&
                yPos < s.getY() + s.getHeight()) {
            return true;
        }
        return false;
    }

    public boolean willIntersectY(Entity s) {
        if (xPos + width  > s.getX() &&
                xPos < s.getX() + s.getWidth() &&
                yPos + height + yVel > s.getY() &&
                yPos + yVel < s.getY() + s.getHeight()) {
            return true;
        }
        return false;
    }

    @Override
    public void setXVel(double xVel) {
        this.xVel = xVel;
    }

    @Override
    public double getXVel() {
        return xVel;
    }

    @Override
    public void setYVel(double yVel) {
        this.yVel = yVel;
    }

    @Override
    public double getYVel() {
        return yVel;
    }

    @Override
    public void moveLeft() {
        this.setXVel(-4);
        imgList = 0;
    }

    @Override
    public void moveRight() {
        this.setXVel(4);
        imgList = 1;
    }

    @Override
    public void stopMoving() {
        if (this.xVel < 0) {
            imgList = 2;
        } else {
            imgList = 3;
        }
        this.setXVel(0);
    }

    public double getStrength() {
        return this.strength;
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
