package stickman.model.entity;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import stickman.view.animation.*;

import java.util.HashMap;
import java.util.Map;

public class Hero implements VelocityEntity, AnimatedEntity, GravityEntity, CollisionEntity, ShooterEntity {
    private Map<String, AnimationState> animationStates;
    private String animationState;
    private ImageView imgView;
    private double sizeMult;

    private double width;
    private double height;

    private double xPos;
    private double yPos;
    private double xVel;
    private double yVel;
    private int dir;

    private boolean canShoot;

    private CollisionHandler colHand;
    private boolean solid = true;


    public Hero() {
        this.imgView = new ImageView();
        this.colHand = new CollisionHandler(this);
        this.canShoot = true;
        this.dir = 1;
    }

    public void setSize(String size) {
        if (size.equalsIgnoreCase("large")) {
            this.sizeMult = 4;
        } else if (size.equalsIgnoreCase("tiny")) {
            this.sizeMult = 1;
        } else {
            this.sizeMult = 2;
        }
        this.imgView.setFitHeight(sizeMult * this.imgView.getViewport().getHeight());
        this.imgView.setFitWidth(sizeMult * this.imgView.getViewport().getWidth());

        this.height = this.imgView.getFitHeight();
        this.width = this.imgView.getFitWidth();
    }

    public double getSizeMult() {
        return this.sizeMult;
    }

    @Override
    public void initAnimationStates() {
        this.animationStates = new HashMap<>();
        this.animationStates.put("Idle_Right", new IdleRight("Hero"));
        this.animationStates.put("Idle_Left", new IdleLeft("Hero"));
        this.animationStates.put("Walk_Right", new WalkRight("Hero"));
        this.animationStates.put("Walk_Left", new WalkLeft("Hero"));
        this.setState("Idle_Right");
        this.animationStates.get(this.animationState).update(imgView);
    }

    @Override
    public void setXVel(double xVel) {
        if (xVel < 0) {
            this.dir = -1;
        } else if (xVel > 0) {
            this.dir = 1;
        }
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
        this.updateX();
        this.updateY();
    }

    private void updateX() {
        if (Math.signum(colHand.getCollisionFlagX()) != Math.signum(this.xVel)) {
            this.xPos += this.xVel;
        }
    }

    private void updateY() {
        if (Math.signum(colHand.getCollisionFlagY()) != Math.signum(this.yVel)) {
            this.yPos += this.yVel;
        } else {
            this.yVel = 0;
        }
    }

    @Override
    public AnimationState getState() {
        return this.animationStates.get(this.animationState);
    }

    @Override
    public void setState(String key) {
        if (animationStates.containsKey(key)) {
            this.animationState = key;
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
        animationStates.get(this.animationState).update(imgView);
        pane.getChildren().add(this.imgView);
    }

    @Override
    public boolean updateImg(double viewportOffset) {
        this.animationStates.get(this.animationState).update(imgView);
        imgView.setX(this.xPos - viewportOffset);
        imgView.setY(this.yPos);
        return true;
    }

    public void moveLeft() {
        this.setXVel(-5);
        this.setState("Walk_Left");
    }

    public void moveRight() {
        this.setXVel(5);
        this.setState("Walk_Right");
    }

    public void stopMoving() {
        if (this.getXVel() < 0) {
            this.setState("Idle_Left");
        } else {
            this.setState("Idle_Right");
        }
        this.setXVel(0);
    }

    @Override
    public void applyGrav(double gravity) {
        this.yVel += gravity;
    }

    @Override
    public void checkHandleCollision(Entity e) {
        if (!this.equals(e)) {
            colHand.updateIntersectX(e);
            colHand.updateIntersectY(e);
        }
    }

    @Override
    public CollisionHandler getCollisionHandler() {
        return this.colHand;
    }

    @Override
    public boolean getSolid() {
        return this.solid;
    }

    @Override
    public void enableShooting() {
        this.canShoot = true;
    }

    @Override
    public void disableShooting() {
        this.canShoot = false;
    }

    @Override
    public boolean canShoot() {
        return this.canShoot;
    }

    public int getDir() {
        return this.dir;
    }
}
