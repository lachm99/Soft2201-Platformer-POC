package stickman.model.stage;

import stickman.model.entity.Bullet;
import stickman.model.entity.Entity;
import stickman.model.entity.Hero;
import stickman.view.background.BackgroundItem;

import java.util.ArrayList;
import java.util.List;

public abstract class Level {
    protected ArrayList<Entity> entities;
    protected Hero hero;
    protected Entity flag;
    protected final double width;
    protected final double height;
    protected final double floorHeight;

    protected double gravity;

    protected List<BackgroundItem> background;

    public Level(double width, double height, double floorHeight) {
        this.width = width;
        this.height = height;
        this.floorHeight = floorHeight;
        this.background = new ArrayList<>();
        this.entities = new ArrayList<>();
    }

    public void tick() {
        hero.getCollisionHandler().resetCollisionFlags();
        hero.applyGrav(gravity);
        for (Entity e : this.entities) {
            hero.checkHandleCollision(e);
            e.tick();
        }
        hero.tick();

    }

    public List<Entity> getEntities() {
        return this.entities;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public Hero getHero() {
        return this.hero;
    }

    public void setFlag(Entity flag) {
        this.flag = flag;
    }

    public Entity getFlag() {
        return this.flag;
    }

    public double getHeight() {
        return this.height;
    }

    public double getWidth() {
        return this.width;
    }

    public double getFloorHeight() {
        return this.floorHeight;
    }

    public void setGravity(double gravity) {
        this.gravity = gravity;
    }

    public double getGravity() {
        return this.gravity;
    }

    public List<BackgroundItem> getBackground() {
        return this.background;
    }

    public void moveRight() {
        this.getHero().moveRight();
    }

    public void moveLeft() {
        this.getHero().moveLeft();
    }

    public void stopMoving() {
        this.getHero().stopMoving();
    }

    public boolean heroJump() {
        if (getHero().getCollisionHandler().getCollisionFlagY() == 1) {
            getHero().setYVel( -(15 + getHero().getSizeMult()) * gravity);
            getHero().getCollisionHandler().setCollisionFlagY(0);
            return true;
        }
        return false;

    }

    public boolean heroShoot() {
        if (getHero().canShoot()) {
            System.out.println("Shoot!");
            this.entities.add(new Bullet(getHero()));
            return true;
        }
        return false;
    }
}
