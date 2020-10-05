package stickman.model.entity;

public interface VelocityEntity extends Entity {
    void setXVel(double xVel);

    double getXVel();

    void setYVel(double yVel);

    double getYVel();

    void tick(double gravity);
}
