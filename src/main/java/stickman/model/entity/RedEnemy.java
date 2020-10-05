package stickman.model.entity;

import stickman.view.animation.*;
import java.util.HashMap;

// A Red ghost that floats - initially from right to right.
public class RedEnemy extends Enemy {

    public RedEnemy(double xPos, double yPos, double sizeMult) {
        super(xPos, yPos, sizeMult);
        this.dir = 1;
        this.setXVel(0.5);
    }


    @Override
    public void initAnimationStates() {
        this.animationStates = new HashMap<>();
        this.animationStates.put("Idle_Right", new IdleRight("RedEnemy"));
        this.animationStates.put("Idle_Left", new IdleLeft("RedEnemy"));
        this.animationStates.put("Walk_Right", new WalkRight("RedEnemy"));
        this.animationStates.put("Walk_Left", new WalkLeft("RedEnemy"));
        this.setState("Walk_Right");
        this.animationStates.get(this.animationState).update(imgView);

        this.imgView.setFitHeight(sizeMult * this.imgView.getViewport().getHeight());
        this.imgView.setFitWidth(sizeMult * this.imgView.getViewport().getWidth());
        this.height = this.imgView.getFitHeight();
        this.width = this.imgView.getFitWidth();
    }

    @Override
    protected void updateY(double gravity) {
        this.yPos += this.yVel;
        this.yVel += gravity;
    }

}
