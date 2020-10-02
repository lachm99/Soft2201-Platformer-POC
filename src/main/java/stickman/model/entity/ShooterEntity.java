package stickman.model.entity;

public interface ShooterEntity extends Entity {
    void enableShooting();

    void disableShooting();

    boolean canShoot();
}
