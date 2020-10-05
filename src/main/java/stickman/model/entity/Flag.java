package stickman.model.entity;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import stickman.model.entity.collisions.CollisionHandler;
import stickman.model.entity.collisions.FlagCollisionHandler;

public class Flag implements Entity {
    private ImageView view;
    private double width = 32;
    private double height = 128;

    private double xPos;
    private double yPos;

    private CollisionHandler colHand;
    private boolean toDelete;


    public Flag(double xPos, double yPos) {
        this.xPos = xPos;
        this.yPos = yPos - height;
        this.view = new ImageView("flag.png");
        view.setX(xPos);
        view.setY(yPos - height);
        this.view.setViewOrder(50);
        this.colHand = new FlagCollisionHandler(this);
    }


    @Override
    public void tick(double gravity) {
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
        pane.getChildren().add(this.view);
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

    @Override
    public void delete() {
        this.toDelete = true;
    }
    
    @Override
    public boolean toDelete() {
        return this.toDelete;
    }

}
