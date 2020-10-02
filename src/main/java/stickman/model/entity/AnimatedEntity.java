package stickman.model.entity;

import javafx.scene.image.ImageView;
import stickman.view.animation.AnimationState;

public interface AnimatedEntity extends Entity{

    void initAnimationStates(String assetDir);

    AnimationState getState();

    void setState(String key);

}
