package stickman.model.entity;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import stickman.model.entity.collisions.CollisionHandler;
import stickman.model.entity.collisions.HeroCollisionHandler;
import stickman.view.animation.*;

import java.util.HashMap;
import java.util.Map;

public class Hero implements VelocityEntity, AnimatedEntity, ShooterEntity {
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
    private int winState;

    private CollisionHandler colHand;
    private boolean toDelete;
    private boolean toReset;
    private boolean hasWon;


    public Hero() {
        this.imgView = new ImageView();
        this.colHand = new HeroCollisionHandler(this);
        this.canShoot = false;
        this.dir = 1;
        this.toReset = false;
        this.winState = 0;
        this.initAnimationStates();
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
    public void tick(double gravity) {
        updateX();
        updateY(gravity);
    }

    private void updateX() {
        this.xPos += this.xVel;
    }

    private void updateY(double gravity) {
        this.yPos += this.yVel;
        this.getCollisionHandler().setCollisionFlagY(0);
        this.yVel += gravity;
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
    public void drawImg(double xViewportOffset, double yViewportOffset, Pane pane) {
        animationStates.get(this.animationState).update(imgView);
        pane.getChildren().add(this.imgView);
    }

    @Override
    public boolean updateImg(double xViewportOffset, double yViewportOffset) {
        this.animationStates.get(this.animationState).update(imgView);
        imgView.setX(this.xPos - xViewportOffset);
        imgView.setY(this.yPos - yViewportOffset);
        return true;
    }

    @Override
    public void clearView(Pane pane) {
        pane.getChildren().remove(this.imgView);
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
    public CollisionHandler getCollisionHandler() {
        return this.colHand;
    }

    @Override
    public boolean toDelete() {
        return this.toDelete;
    }

    @Override
    public void delete() {
        this.toDelete = true;
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

    @Override
    public Rectangle2D getBounds() {
        return new Rectangle2D(this.xPos, this.yPos, this.width, this.height);
    }

    public void setHasWon(boolean hasWon) {
        this.hasWon = hasWon;
    }

    public boolean getHasWon() {
        return this.hasWon;
    }

    public void setToReset(boolean toReset) {
        this.toReset = toReset;
    }

    public boolean getToReset() {
        return this.toReset;
    }
}
