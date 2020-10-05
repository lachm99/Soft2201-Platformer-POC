package stickman.model.entity;

import stickman.view.animation.*;
import java.util.HashMap;

// A blue ghost that jumps - initially from left to right.
public class BlueEnemy extends Enemy {
    public BlueEnemy(double xPos, double yPos, double sizeMult) {
        super(xPos, yPos, sizeMult);
        this.dir = -1;
        this.setXVel(-0.5);
    }

    @Override
    public void initAnimationStates() {
        this.animationStates = new HashMap<>();
        this.animationStates.put("Idle_Right", new IdleRight("BlueEnemy"));
        this.animationStates.put("Idle_Left", new IdleLeft("BlueEnemy"));
        this.animationStates.put("Walk_Right", new WalkRight("BlueEnemy"));
        this.animationStates.put("Walk_Left", new WalkLeft("BlueEnemy"));
        this.setState("Walk_Left");
        this.animationStates.get(this.animationState).update(imgView);

        this.imgView.setFitHeight(sizeMult * this.imgView.getViewport().getHeight());
        this.imgView.setFitWidth(sizeMult * this.imgView.getViewport().getWidth());
        this.height = this.imgView.getFitHeight();
        this.width = this.imgView.getFitWidth();
    }

    @Override
    protected void updateY(double gravity) {
        this.yPos += this.yVel;
        // If on the ground, jump a bit.
        if (this.getCollisionHandler().getCollisionFlagY() == 1) {
            this.setYVel(-gravity * 10);
        }
        this.getCollisionHandler().setCollisionFlagY(0);
        this.yVel += gravity/2;
    }
}
