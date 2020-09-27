package Stickman.model;

public interface MovableEntity extends Entity {
    void setXVel(double xVel);
    double getXVel();
    void setYVel(double xVel);
    double getYVel();

    void moveRight();
    void moveLeft();
    void stopMoving();

}
