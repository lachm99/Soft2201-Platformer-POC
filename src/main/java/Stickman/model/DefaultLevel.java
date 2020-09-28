package Stickman.model;

import java.util.ArrayList;
import java.util.List;

public class DefaultLevel implements Level {
    private List<Entity> entities;
    private Hero hero;

    private int height;
    private int width;
    private int floorHeight;
    private double gravity;


    // Default constructor. Only called by factory method, which will go on to populate these fields.
    public DefaultLevel() {
        this.entities = new ArrayList<Entity>();
        this.hero = null;
        this.height = 0;
        this.width = 0;
        this.floorHeight = 0;
        this.gravity = 0;
    }

    @Override
    public List<Entity> getEntities() {
        return this.entities;
    }

    @Override
    public Hero getHero() {
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
    public int getFloorHeight() {
        return this.floorHeight;
    }

    @Override
    public double getGravity() {
        return this.gravity;
    }

    @Override
    public void setHero(Hero h) {
        this.hero = h;
        this.entities.add(h);
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
    public void setFloorHeight(int floorHeight) {
        this.floorHeight = floorHeight;
    }


    @Override
    public void setGravity(double g) {
        this.gravity = g;
    }




    @Override
    public void tick() {
        for (Entity e:entities) {
            e.tick();
        }
        updateHero();
    }

    private void updateHero() {
        // Check vertical movement/collsion
        // TODO check platform collision also
        if (hero.getY() + hero.getHeight() > height - floorHeight) {
            hero.setY(height - floorHeight - hero.getHeight());
            hero.setYVel(0);
        } else {
            hero.setYVel(hero.getYVel() - gravity);
        }

        // Check horizontal boundary.
        if (hero.getX() < 0) {
            stopMoving();
        } else if (hero.getX() + hero.getWidth() > width) {
            stopMoving();
        }
    }

    @Override
    public boolean jump() {
        if (getHero().getY() + getHero().getHeight() >= height - floorHeight) {
            this.getHero().setYVel(-15);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean moveLeft() {
        // Don't move left if out of bounds
        if (this.getHero().getX() < 0) {
            return false;
        } else {
            this.getHero().moveLeft();
            return true;
        }
    }

    @Override
    public boolean moveRight() {
        // Don't move right if out of bounds.
        if (this.getHero().getX() + this.getHero().getWidth() > this.width) {
            return false;
        } else {
            this.getHero().moveRight();
            return true;
        }
    }

    @Override
    public boolean stopMoving() {
        this.getHero().stopMoving();
        return true;
    }
}
