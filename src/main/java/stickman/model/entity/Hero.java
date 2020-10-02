package stickman.model.entity;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import stickman.view.animation.*;

import java.util.HashMap;
import java.util.Map;

public class Hero implements VelocityEntity, AnimatedEntity {
    private Map<String, AnimationState> animationStates;
    private String animationState;
    private ImageView imgView;

    private double width;
    private double height;

    private double xPos;
    private double yPos;
    private double xVel;
    private double yVel;

    private CollisionHandler collisionHandler;


    public Hero() {
        initAnimationStates("Hero");
        this.collisionHandler = new CollisionHandler(this);
    }

    @Override
    public void initAnimationStates(String assetDir) {
        this.animationStates = new HashMap<>();
        this.animationStates.put("Idle_Right", new IdleRight("Hero"));
        this.animationStates.put("Idle_Left", new IdleLeft("Hero"));
        this.animationStates.put("Walk_Right", new WalkRight("Hero"));
        this.animationStates.put("Walk_Left", new WalkLeft("Hero"));
        this.setState("Idle_Right");
        this.imgView = new ImageView();
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
        this.setX(this.getX() + this.xVel);
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
    public void updateImg(double viewportOffset) {
        this.animationStates.get(this.animationState).update(imgView);
        imgView.setX(this.xPos - viewportOffset);
        imgView.setY(this.yPos);
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

}
