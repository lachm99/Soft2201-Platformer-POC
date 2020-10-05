package stickman.model.entity.collisions;

import stickman.model.entity.Bullet;
import stickman.model.entity.BlueEnemy;
import stickman.model.entity.Enemy;
import stickman.model.entity.Entity;

public class EnemyCollisionHandler implements CollisionHandler{
    private final Enemy e;

    private int collisionFlagX;
    private int collisionFlagY;

    private boolean toCollideOnX;
    private boolean toCollideOnY;

    private boolean solid;

    public EnemyCollisionHandler(Enemy e) {
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
        // Checks if the hero WILL collide with the given entity - considering heros current position and
        // velocity.
        this.toCollideOnX = (e.getX() + e.getWidth() + e.getXVel() > e2.getX() &&
                e.getX() + e.getXVel() < e2.getX() + e2.getWidth() &&
                e.getY() + e.getHeight() > e2.getY() &&
                e.getY() < e2.getY() + e2.getHeight());
        this.toCollideOnY = (e.getX() + e.getWidth() > e2.getX() &&
                e.getX() < e2.getX() + e2.getWidth() &&
                e.getY() + e.getHeight() + e.getYVel() > e2.getY() &&
                e.getY() + e.getYVel() < e2.getY() + e2.getHeight());
        return (toCollideOnX || toCollideOnY);
    }

    @Override
    public void handleCollision(Entity e2) {
        // React to the collision, and tell the other entity to react.
        this.reactToCollision(e2);
        e2.getCollisionHandler().reactToCollision(this.e);
    }

    @Override
    public void reactToCollision(Entity e2) {
        if (e2 instanceof Bullet) {
            e.delete();
            e2.delete();
        }
        // An entity will call this if it the collision needs to impact the Enemy.
        // Currently, only called by the Enemy when it collides with something else.
        if (!e2.getCollisionHandler().getSolid()) {
            return;
        }
        if (toCollideOnX) {
            if (e.getXVel() > 0) {
                this.collisionFlagX = 1;
                e.setX(e2.getX() - e.getWidth());
            } else {
                this.collisionFlagX = -1;
                e.setX(e2.getX() + e2.getWidth());
            }
            e.setXVel(-e.getXVel());
            if (e.getXVel() > 0 ) {
                e.setState("Walk_Right");
            } if (e.getXVel() < 0) {
                e.setState("Walk_Left");
            }
        } else if (toCollideOnY) {
            if (e.getYVel() > 0) {
                this.collisionFlagY = 1;
                e.setY(e2.getY() - e.getHeight());
                e.setYVel(0);
            } else {
                this.collisionFlagY = -1;
                e.setY(e2.getY() + e2.getHeight());
                e.setYVel(0);
            }
        }
    }

}
