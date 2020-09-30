package Stickman.view;

import Stickman.model.Entity;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;


public class EntityShape implements EntityView {
    private Entity entity;
    private Shape shape;
    private boolean markedForDelete;

    EntityShape(Entity entity) {
        this.entity = entity;
        this.shape = new Rectangle(entity.getX(), entity.getY(), entity.getWidth(), entity.getHeight());
        this.shape.setStroke(Color.RED);
        this.shape.setFill(null);

        this.shape.setViewOrder(getViewOrder(entity.getLayer()));
        update(0);

        markedForDelete = false;
    }

    private double getViewOrder(Layer layer) {
        switch (layer) {
            case BACKGROUND: return 100.0;
            case FOREGROUND: return 50.0;
            case EFFECT: return 25.0;
            default: throw new IllegalStateException("Javac doesn't understand how enums work so now I have to exist");
        }
    }

    @Override
    public void update(double xViewportOffset) {
        shape.relocate(entity.getX() - xViewportOffset, entity.getY());
        markedForDelete = false;
    }

    @Override
    public boolean matchesEntity(Entity entity) {
        return this.entity.equals(entity);
    }

    @Override
    public void markForDelete() {
//        this.markedForDelete = true;
    }

    @Override
    public Entity getEntity() {
        return this.entity;
    }

    @Override
    public Node getNode() {
        return this.shape;
    }

    @Override
    public void setLayer(Layer layer) {
        this.getEntity().setLayer(layer);
    }

    @Override
    public boolean isMarkedForDelete() {
        return this.markedForDelete;
    }
}
