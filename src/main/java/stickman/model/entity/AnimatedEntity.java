package stickman.model.entity;

import stickman.view.animation.AnimationState;

public interface AnimatedEntity {

    void initAnimationStates(String assetDir);

    AnimationState getState();

    void setState(String key);

    void animate();
}
