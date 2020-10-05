package stickman.model.entity;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import stickman.model.entity.collisions.CollisionHandler;
import stickman.model.entity.collisions.MushroomCollisionHandler;

public class Mushroom implements Entity {
    private ImageView view;

    private double xPos;
    private double yPos;
    private double width = 32;
    private double height = 32;

    private boolean toDelete;

    private CollisionHandler colHand;


    public Mushroom(double xPos, double yPos) {
        this.xPos = xPos;
        this.yPos = yPos - height; // Account for mushroom size offset from floor

        this.view = new ImageView("Mushroom.png");
        this.view.setViewOrder(90);
        this.view.setX(this.xPos);
        this.view.setY(this.yPos);

        this.colHand = new MushroomCollisionHandler(this);
    }

    @Override
    public void tick(double gravity) {
        // Do nothing!
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
        view.setTranslateX(-xViewportOffset);
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

    public void delete() {
        this.toDelete = true;
    }

    public boolean toDelete() {
        return this.toDelete;
    }
}

