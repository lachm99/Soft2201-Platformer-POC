package stickman.model.stage;

import stickman.model.entity.Entity;
import stickman.model.entity.Flag;
import stickman.model.entity.Hero;
import stickman.view.background.BackgroundItem;

import java.util.ArrayList;
import java.util.List;

public abstract class Level {
    protected ArrayList<Entity> entities;
    protected Hero hero;
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

    public abstract void moveEntities();

    public abstract void handleCollisions();

    public abstract void moveRight();

    public abstract void moveLeft();

    public abstract void stopMoving();

    public abstract boolean heroJump();

    public abstract boolean heroShoot();

    public List<Entity> getEntities() {
        return this.entities;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
        this.entities.add(hero);
    }

    public Hero getHero() {
        return this.hero;
    }

    public void setFlag(Flag flag) {
        this.entities.add(flag);
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

}
