package stickman.model.entity;

import javafx.scene.image.ImageView;
import stickman.view.animation.AnimationState;

public interface AnimatedEntity extends Entity{

    void initAnimationStates();

    AnimationState getState();

    void setState(String key);

    void setSize(String size);

    double getSizeMult();

}
