package stickman.model.entity.collisions;

import stickman.model.entity.Entity;

public interface CollisionHandler {

    boolean getSolid();

    int getCollisionFlagX();
    int getCollisionFlagY();
    void setCollisionFlagX(int dir);
    void setCollisionFlagY(int dir);
    void resetCollisionFlags();

    boolean collidesWith(Entity e2);

    void handleCollision(Entity e2);

    void reactToCollision(Entity e2);
}
