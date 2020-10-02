package stickman.model.entity;

public class CollisionHandler {
    private VelocityEntity e;

    private int collisionFlagX;
    private int collisionFlagY;

    public CollisionHandler(VelocityEntity e) {
        this.e = e;
    }

    public int getCollisionFlagX() {
        return this.collisionFlagX;
    }

    public int getCollisionFlagY() {
        return this.collisionFlagY;
    }

    public void setCollisionFlagX(int dir) {
        this.collisionFlagX = dir;
    }

    public void setCollisionFlagY(int dir) {
        this.collisionFlagY = dir;
    }

    public boolean willIntersectX(Entity s) {
        if (e.getX() + e.getWidth() + e.getXVel() > s.getX() &&
                e.getX() + e.getXVel() < s.getX() + s.getWidth() &&
                e.getY() + e.getHeight() > s.getY() &&
                e.getY() < s.getY() + s.getHeight()) {
            return true;
        }
        return false;
    }

    public boolean willIntersectY(Entity s) {
        if (e.getX() + e.getWidth()  > s.getX() &&
                e.getX() < s.getX() + s.getWidth() &&
                e.getY() + e.getHeight() + e.getYVel() > s.getY() &&
                e.getY() + e.getYVel() < s.getY() + s.getHeight()) {
            return true;
        }
        return false;
    }



}
