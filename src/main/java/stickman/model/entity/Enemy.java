package stickman.model.entity;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import stickman.model.entity.collisions.CollisionHandler;
import stickman.model.entity.collisions.EnemyCollisionHandler;
import stickman.view.animation.*;

import java.util.Map;

public abstract class Enemy implements VelocityEntity, AnimatedEntity {
    protected Map<String, AnimationState> animationStates;
    protected String animationState;
    protected ImageView imgView;
    protected double sizeMult;

    protected double width;
    protected double height;

    protected double xPos;
    protected double yPos;
    protected double xVel;
    protected double yVel;
    protected int dir;

    protected CollisionHandler colHand;
    protected boolean toDelete;

    public Enemy(double xPos, double yPos, double sizeMult) {
        this.sizeMult = sizeMult;
        this.imgView = new ImageView();
        this.initAnimationStates();

        this.xPos = xPos;
        this.yPos = yPos - this.height; // Account for floorheight
        this.colHand = new EnemyCollisionHandler(this);
    }


    @Override
    public abstract void initAnimationStates();


    @Override
    public void setXVel(double xVel) {
        if (xVel < 0) {
            this.dir = -1;
        } else if (xVel > 0) {
            this.dir = 1;
        }
        this.xVel = xVel;
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

    protected void updateX() {
        this.xPos += this.xVel;
    }

    protected abstract void updateY(double gravity);


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
    public double getSizeMult() {
        return this.sizeMult;
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
    public void drawImg(double viewportOffset, double yViewportOffset, Pane pane) {
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
    public Rectangle2D getBounds() {
        return new Rectangle2D(this.xPos, this.yPos, this.width, this.height);
    }
}
