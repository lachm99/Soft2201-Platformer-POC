package Stickman.model;

import java.util.List;

public interface Level {
    List<Entity> getEntities();
    void setHero(Hero h);
    Hero getHero();


    int getHeight();
    int getWidth();
    void setHeight(int height);
    void setWidth(int width);

    int getFloorHeight();
    void setFloorHeight(int floorHeight);

    double getGravity();
    void setGravity(double g);

    void tick();

    boolean jump();
    boolean moveLeft();
    boolean moveRight();
    boolean stopMoving();
}
