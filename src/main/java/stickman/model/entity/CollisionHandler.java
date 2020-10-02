package stickman.model.entity;

public class CollisionHandler {
    private VelocityEntity e;

    private int collisionFlagX;
    private int collisionFlagY;

    public CollisionHandler(VelocityEntity e) {
        this.e = e;
        this.collisionFlagX = 0;
        this.collisionFlagY = 0;
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

    public void resetCollisionFlags() {
        this.collisionFlagX = 0;
        this.collisionFlagY = 0;
    }

    public boolean updateIntersectX(Entity s) {
        if (!s.getSolid()) {
            return false;
        }
        if (e.getX() + e.getWidth() + e.getXVel() > s.getX() &&
                e.getX() + e.getXVel() < s.getX() + s.getWidth() &&
                e.getY() + e.getHeight() > s.getY() &&
                e.getY() < s.getY() + s.getHeight()) {
            if (e.getXVel() > 0) {
                this.collisionFlagX = 1;
                e.setX(s.getX() - e.getWidth());
            } else {
                this.collisionFlagX = -1;
                e.setX(s.getX() + s.getWidth());
            }
            // System.out.println("X Collision: " + collisionFlagX);
            return true;
        }
        return false;
    }

    public boolean updateIntersectY(Entity s) {
        if (!s.getSolid()) {
            return false;
        }
        if (e.getX() + e.getWidth()  > s.getX() &&
                e.getX() < s.getX() + s.getWidth() &&
                e.getY() + e.getHeight() + e.getYVel() > s.getY() &&
                e.getY() + e.getYVel() < s.getY() + s.getHeight()) {
            if (e.getYVel() > 0) {
                this.collisionFlagY = 1;
                e.setY(s.getY() - e.getHeight());

            } else {
                this.collisionFlagY = -1;
                e.setY(s.getY() + s.getHeight());
            }
            // System.out.println("Y Collision: " + collisionFlagY);
            return true;
        }
        return false;
    }

}
