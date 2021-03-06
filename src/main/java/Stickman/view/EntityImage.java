package Stickman.view;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import Stickman.model.Entity;


public class EntityImage implements EntityView {
    private Entity entity;
    private ImageView img;
    private String imagePath;
    private boolean markedForDelete;

    EntityImage(Entity entity) {
        this.entity = entity;
        this.imagePath = entity.getImgPath();
        if (imagePath == null) {
            // This shouldn't happen!
        } else {
            this.img = new ImageView(entity.getImgPath());
            this.img.setViewOrder(getViewOrder(entity.getLayer()));
            update(0);
        }
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
        if (imagePath != null) {
            String newPath = entity.getImgPath();
            if (!imagePath.equals(newPath)) {
                imagePath = newPath;
                img.setImage(new Image(imagePath));
            }
            img.setX(entity.getX() - xViewportOffset);
            img.setY(entity.getY());
            img.setFitHeight(entity.getHeight());
            img.setFitWidth(entity.getWidth());
            img.setPreserveRatio(true);
        }
        markedForDelete = false;
    }

    @Override
    public boolean matchesEntity(Entity entity) {
        return this.entity.equals(entity);
    }

    @Override
    public void markForDelete() {
        this.markedForDelete = true;
    }

    @Override
    public Entity getEntity() {
        return this.entity;
    }

    @Override
    public Node getNode() {
        return this.img;
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
