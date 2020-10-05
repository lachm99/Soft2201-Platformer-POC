package stickman.model.entity.collisions;

import stickman.model.entity.Entity;

public class SurfaceCollisionHandler implements CollisionHandler {
    private final Entity e;

    private int collisionFlagX;
    private int collisionFlagY;

    private boolean solid;

    public SurfaceCollisionHandler(Entity e) {
        this.e = e;
        this.collisionFlagX = 0;
        this.collisionFlagY = 0;
        this.solid = true;
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
        // This doesn't collide with anything - objects collide with it!
        return false;
    }

    @Override
    public void handleCollision(Entity e2) {
        // Any colliding entity will handle its own behaviour.
    }

    @Override
    public void reactToCollision(Entity e2) {
        // Doesn't react. Stays static and immovable.
    }
}
