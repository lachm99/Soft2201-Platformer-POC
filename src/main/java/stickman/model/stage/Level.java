package stickman.model.stage;

import stickman.view.background.BackgroundItem;

import java.util.ArrayList;
import java.util.List;

public abstract class Level {
    // private ArrayList<Entity> entities;
    protected final double width;
    protected final double height;
    protected final double floorHeight;

    protected double gravity;

    protected List<BackgroundItem> background;

    public Level(double width, double height, double floorHeight) {
        this.width = width;
        this.height = height;
        this.floorHeight = floorHeight;
        this.background = new ArrayList<BackgroundItem>();
    }

    public abstract void tick();

    public double getHeight() {
        return this.height;
    }

    public double getWidth() {
        return this.width;
    }

    public double getFloorHeight() {
        return this.floorHeight;
    }

    public double getGravity() {
        return this.gravity;
    }

    public List<BackgroundItem> getBackground() {
        return this.background;
    }

}
