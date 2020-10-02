package stickman.model.stage;

import stickman.config.Config;
import stickman.model.entity.*;
import stickman.view.background.Floor;
import stickman.view.background.Landscape;

public class FirstLevelFactory implements LevelFactory {
    private Level l;

    private final int WIDTH = 1800;
    private final int HEIGHT = 600;
    private final int FLOOR_HEIGHT = 500;

    // Initial construction, before adding extra components
    public FirstLevelFactory() {
        this.l = new FirstLevel(WIDTH, HEIGHT, FLOOR_HEIGHT);
        // Add background and scenery
        l.getBackground().add(new Landscape(this.l));
        l.getBackground().add(new Floor(this.l));

        // Add invisible level barriers.
        l.getEntities().add(new Barrier(0, FLOOR_HEIGHT, WIDTH, 10));
        l.getEntities().add(new Barrier(0, 0, -10, HEIGHT));
        l.getEntities().add(new Barrier(WIDTH, 0, 10, HEIGHT));

        // Set initial gravity value
        l.setGravity(1);
    }

    @Override
    public void makeFromConfig(Config config) {
        Hero h = new Hero();
        h.initAnimationStates();
        h.setSize(config.getHeroSize());
        h.setX(config.getHeroXPos());
        h.setY(config.getHeroYPos());
        l.setHero(h);

        for (int i=0; i < config.getPlatformsX().size(); i++) {
            l.getEntities().add(new Platform(
                    config.getPlatformsX().get(i),
                    config.getPlatformsY().get(i),
                    config.getPlatformsLength().get(i),
                    32));
        }
        for (int i=0; i < config.getMushroomsX().size(); i++) {
            l.getEntities().add(new Mushroom(
                    config.getMushroomsX().get(i),
                    l.getFloorHeight()));
        }

        l.setFlag(new Flag(config.getFlagX(), l.getFloorHeight()));
    }

    @Override
    public void makePreset() {
        l.setGravity(0.6);
        Hero h = new Hero();
        h.initAnimationStates();
        h.setSize("normal");

        h.setX(100);
        h.setY(100);
        l.setHero(h);
    }

    @Override
    public Level getLevel() {
        return this.l;
    }
}
