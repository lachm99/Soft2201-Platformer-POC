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
        hero.setYVel(hero.getYVel() - gravity);
        collisions();
        hero.tick();
//        hero.setYVel(hero.getYVel() + gravity);

//        for (Entity collisionCand : List.copyOf(entities)) {
//            if (collisionCand.intersects(hero)) {
//                collisionCand.collide(hero);
//                hero.collide(collisionCand);
//            }
//        }
    }

    private void collisions() {
        hero.setCollisionFlags(0, 0);
        for (Entity e : entities) {
            // Check if solid??g
            if (hero.willIntersectX(e)) {
                if (hero.getX() < e.getX()) {
                    hero.setCollisionFlags(1, hero.getCollisionFlags()[1]);
                    hero.setX(e.getX() - hero.getWidth());
                } else {
                    hero.setCollisionFlags(-1, hero.getCollisionFlags()[1]);
                    hero.setX(e.getX() + e.getWidth());
                }
            }
            // If vertical collision
            if (hero.willIntersectY(e)) {
                if (hero.getY() < e.getY()) {
                    hero.setCollisionFlags(hero.getCollisionFlags()[0], -1);
                    hero.setY(e.getY() - hero.getHeight());
                    hero.setYVel(0);
                } else {
                    hero.setCollisionFlags(hero.getCollisionFlags()[0], 1);
                    hero.setY(e.getY() + e.getHeight());
                    hero.setYVel(0);
                }
            }
        }

    }

    @Override
    public boolean jump() {
        if (hero.getCollisionFlags()[1] == -1) {
            this.getHero().setYVel(-10 * this.getHero().getStrength());
            this.getHero().setCollisionFlags(this.getHero().getCollisionFlags()[0], 0 );
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean moveLeft() {
        if (hero.getCollisionFlags()[0] == -1) {
            return false;
        }
        hero.moveLeft();
        return true;
    }

    @Override
    public boolean moveRight() {
        if (hero.getCollisionFlags()[0] == 1) {
            return false;
        }
        hero.moveRight();
        return true;
    }

    @Override
    public boolean stopMoving() {
        this.getHero().stopMoving();
        return true;
    }
}
