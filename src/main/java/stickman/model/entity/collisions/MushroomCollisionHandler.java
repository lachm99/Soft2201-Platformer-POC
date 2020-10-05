package stickman.model.entity.collisions;

import stickman.model.entity.Entity;
import stickman.model.entity.Hero;
import stickman.model.entity.Mushroom;

public class MushroomCollisionHandler implements CollisionHandler {
    private final Mushroom e;

    private int collisionFlagX;
    private int collisionFlagY;

    private boolean solid;

    public MushroomCollisionHandler(Mushroom e) {
        this.e = e;
        this.collisionFlagX = 0;
        this.collisionFlagY = 0;
        this.solid = false;
    }

    @Override
    public boolean getSolid() {
        return this.solid;
    }

    @Override
    public int getCollisionFlagX() {
        return this.collisionFlagX;
    }


    @Override
    public int getCollisionFlagY() {
        return this.collisionFlagY;
    }

    public void setCollisionFlagX(int dir) {
        this.collisionFlagX = dir;
    }

    @Override
    public void setCollisionFlagY(int dir) {
        this.collisionFlagY = dir;
    }

    @Override
    public void resetCollisionFlags() {
        this.collisionFlagX = 0;
        this.collisionFlagY = 0;
    }

    @Override
    public boolean collidesWith(Entity e2) {
        // Simple aabb collision test
        return e.getBounds().intersects(e2.getBounds());
    }

    @Override
    public void handleCollision(Entity e2) {
        // React to the collision. The other entity need take no action of its own.
        this.reactToCollision(e2);
    }

    @Override
    public void reactToCollision(Entity e2) {
        // Only viable reaction is to be consumed if the hero picks up - and enable its shooting.
        if (e2 instanceof Hero) {
            if (!((Hero) e2).canShoot()) {
                ((Hero) e2).enableShooting();
                this.e.delete();
            }
        }
    }

}
