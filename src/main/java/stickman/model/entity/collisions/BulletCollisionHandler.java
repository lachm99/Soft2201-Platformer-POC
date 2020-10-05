package stickman.model.entity.collisions;

import stickman.model.entity.Entity;

public class BulletCollisionHandler implements CollisionHandler {
    private final Entity e;

    private int collisionFlagX;
    private int collisionFlagY;

    private boolean solid;

    public BulletCollisionHandler(Entity e) {
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
        return e.getBounds().intersects(e2.getBounds());
    }

    @Override
    public void handleCollision(Entity e2) {
        this.reactToCollision(e2);
        e2.getCollisionHandler().reactToCollision(this.e);
    }

    @Override
    public void reactToCollision(Entity e2) {
        if (e2.getCollisionHandler().getSolid()) {
            e.delete();
            return;
        }
    }
}
