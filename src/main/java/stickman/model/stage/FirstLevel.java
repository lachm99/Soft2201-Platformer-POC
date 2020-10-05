package stickman.model.stage;

import stickman.model.entity.Bullet;
import stickman.model.entity.Entity;

import java.util.List;

public class FirstLevel extends Level {

    public FirstLevel(double width, double height, double floorHeight) {
        super(width, height, floorHeight);
    }

    @Override
    public void moveEntities() {
        for (Entity e : List.copyOf(entities)) {
            e.tick(this.gravity);
            if (e.getX() > width || e.getX() + e.getWidth() < 0) {
                e.delete();
            }
        }
    }

    @Override
    public void handleCollisions() {
        // This is a loop that will only check each pair of entities once.
        for (int i=0; i < entities.size(); i++) {
            Entity e1 = entities.get(i);
            for (int j=i+1; j < entities.size(); j++) {
                Entity e2 = entities.get(j);
                // Check collisions both ways, since some objects will actively collide differently to how they are
                // passively collided with.
                if (e1.getCollisionHandler().collidesWith(e2)) {
                    e1.getCollisionHandler().handleCollision(e2);
                }
                if (e2.getCollisionHandler().collidesWith(e1)) {
                    e2.getCollisionHandler().handleCollision(e1);
                }
            }
        }
    }


    @Override
    public void moveRight() {
        this.getHero().moveRight();
    }

    @Override
    public void moveLeft() {
        this.getHero().moveLeft();
    }

    @Override
    public void stopMoving() {
        this.getHero().stopMoving();
    }

    @Override
    public boolean heroJump() {
        if (getHero().getCollisionHandler().getCollisionFlagY() == 1) {
            getHero().setYVel( -(20 - getHero().getSizeMult()) / this.getGravity());
            getHero().getCollisionHandler().setCollisionFlagY(0);
            return true;
        }
        return false;

    }

    @Override
    public boolean heroShoot() {
        if (getHero().canShoot()) {
            this.entities.add(new Bullet(getHero()));
            return true;
        }
        return false;
    }


}
