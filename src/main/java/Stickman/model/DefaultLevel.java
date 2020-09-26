package Stickman.model;

import java.util.ArrayList;
import java.util.List;

public class DefaultLevel implements Level {
    private List<Entity> entities;
    private Entity hero;

    private int height;
    private int width;
    private int floorHeight;
    private double gravity;

    public DefaultLevel() {
        this.entities = new ArrayList<Entity>();
        this.hero = null;
    }

    @Override
    public List<Entity> getEntities() {
        return this.entities;
    }

    @Override
    public void setHero(Hero h) {
        this.hero = h;
    }

    @Override
    public Entity getHero() {
        return this.hero;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getFloorHeight() {
        return this.floorHeight;
    }

    @Override
    public void setFloorHeight(int floorHeight) {
        this.floorHeight = floorHeight;
    }

    @Override
    public double getGravity() {
        return this.gravity;
    }

    @Override
    public void setGravity(double g) {
        this.gravity = g;
    }

    @Override
    public void tick() {

    }

    @Override
    public boolean jump() {
        return false;
    }

    @Override
    public boolean moveLeft() {
        return false;
    }

    @Override
    public boolean moveRight() {
        return false;
    }

    @Override
    public boolean stopMoving() {
        return false;
    }
}
