package stickman.model.entity;

public interface CollisionEntity extends Entity {
    int getCollisionFlagX();
    int getCollisionFlagY();
    void setCollisionFlagX(int dir);
    void setCollisionFlagY(int dir);

    boolean willIntersectX(Entity e);

    boolean willIntersectY(Entity e);

}
