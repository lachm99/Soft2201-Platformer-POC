package stickman.model.entity;

import stickman.view.animation.*;

import java.util.HashMap;
import java.util.Map;

public class Hero extends Entity implements CollisionEntity, VelocityEntity, AnimatedEntity {
    private Map<String, AnimationState> animationStates;
    private String animationState;
    private double xVel;
    private double yVel;

    public Hero() {
        initAnimationStates("Hero");
    }

    @Override
    public void initAnimationStates(String assetDir) {
        this.animationStates = new HashMap<>();
        this.animationStates.put("Idle_Right", new IdleRight(this.getClass().toString()));
        this.animationStates.put("Idle_Left", new IdleLeft(this.getClass().toString()));
        this.animationStates.put("Walk_Right", new WalkRight(this.getClass().toString()));
        this.animationStates.put("Walk_Left", new WalkLeft(this.getClass().toString()));

    }


    @Override
    public void setXVel(double xVel) {
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
    public void animate() {
        this.animationStates.get(this.animationState).animate();
    }
}
