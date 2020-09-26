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
        this.entities.add(h);
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
        updateHero();
    }

    private void updateHero() {
        hero.tick();
        System.out.println(hero.getY());
        System.out.println(hero.getHeight());
        System.out.println(height - floorHeight);

        if (hero.getY() + hero.getHeight() > height - floorHeight) {
            hero.setY(height - floorHeight - hero.getHeight());
            hero.setYVel(0);
        } else {
            hero.setYVel(hero.getYVel() - gravity);
        }
        if (hero.getX() < 0) {
            hero.setXVel(0);
            hero.setX(0);
        } else if (hero.getX() + hero.getWidth() > width) {
            hero.setXVel(0);
            hero.setX(width - hero.getWidth());
        }
    }

    @Override
    public boolean jump() {
        if (this.getHero().getYVel() == 0) {
            this.getHero().setYVel(-10);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean moveLeft() {
        if (this.getHero().getX() <= 0) {
            System.out.println("NO!");
            return false;
        } else {
            this.getHero().setXVel(-1);
            return true;
        }
    }

    @Override
    public boolean moveRight() {
        if (this.getHero().getX() + this.getHero().getWidth() >= this.width) {
            return false;
        } else {
            this.getHero().setXVel(1);
            return true;
        }
    }

    @Override
    public boolean stopMoving() {
        this.getHero().setXVel(0);
        return true;
    }
}
