package Stickman.view;


import Stickman.model.Entity;
import javafx.scene.Node;
import javafx.scene.image.ImageView;

public interface EntityView {

    Entity getEntity();

    ImageView getImageView();

    void setLayer(Layer layer);

    void update(double xViewportOffset);

    boolean matchesEntity(Entity entity);

    void markForDelete();

    boolean isMarkedForDelete();

}
