package stickman.model.entity;

public interface CollisionEntity extends Entity {
    CollisionHandler getCollisionHandler();

    void checkHandleCollision(Entity e);

}
