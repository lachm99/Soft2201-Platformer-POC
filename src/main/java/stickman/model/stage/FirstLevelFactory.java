package stickman.model.stage;

import stickman.config.Config;
import stickman.model.entity.*;
import stickman.view.background.Floor;
import stickman.view.background.Landscape;

public class FirstLevelFactory implements LevelFactory {
    private Level l;

    private final int WIDTH = 1800;

    // Initial construction, before adding extra components
    public FirstLevelFactory() {
    }

    @Override
    public void makeFromConfig(Config config) {
        this.l = new FirstLevel(WIDTH, config.getMapHeight(), config.getMapHeight()- config.getFloorHeight());
        setGravity(0.8);
        addBackground();
        addBounds();
        Hero h = new Hero();
        h.setSize(config.getHeroSize());
        h.setX(config.getHeroXPos());
        h.setY(l.getHeight() - config.getHeroYPos() - h.getHeight());

        l.setHero(h);

        for (int i=0; i < config.getPlatformsX().size(); i++) {
            l.getEntities().add(new Platform(
                    config.getPlatformsX().get(i),
                    l.getHeight() - config.getPlatformsY().get(i),
                    config.getPlatformsLength().get(i),
                    32));
        }
        for (int i=0; i < config.getMushroomsX().size(); i++) {
            l.getEntities().add(new Mushroom(
                    config.getMushroomsX().get(i),
                    l.getFloorHeight()));
        }

        for (int i=0; i < config.getEnemiesX().size(); i++) {
            if (config.getEnemiesType().get(i).equalsIgnoreCase("blue")) {
                l.getEntities().add(new BlueEnemy(config.getEnemiesX().get(i),
                        l.getFloorHeight(),
                        1.5));
            } else if (config.getEnemiesType().get(i).equalsIgnoreCase("red")) {
                l.getEntities().add(new RedEnemy(config.getEnemiesX().get(i),
                        l.getFloorHeight(),
                        2));
            } else {
                // Invalid enemy type.
                continue;
            }
        }
        l.setFlag(new Flag(config.getFlagX(), l.getHeight() - config.getFlagY()));
    }


    @Override
    public void addBackground() {
        // Add background and scenery
        l.getBackground().add(new Landscape(this.l));
        l.getBackground().add(new Floor(this.l));
    }

    @Override
    public void addBounds() {
        // Add invisible level barriers.
        l.getEntities().add(new Barrier(0, l.getFloorHeight(), WIDTH, 10));
        l.getEntities().add(new Barrier(0, 0, WIDTH, 10));
        l.getEntities().add(new Barrier(0, 0, 10, l.getHeight()));
        l.getEntities().add(new Barrier(WIDTH - 10, 0, 10, l.getHeight()));
    }

    @Override
    public void setGravity(double gravity) {
        // Set initial gravity value
        l.setGravity(gravity);
    }


    @Override
    public void makePreset() {
        setGravity(0.8);
        addBackground();
        addBounds();
        Hero h = new Hero();
        h.setSize("normal");
        h.setX(100);
        h.setY(100);
        l.setHero(h);

        for (int i=0; i < 6; i++) {
            l.getEntities().add(new Platform(
                    64 + 256*i,
                    l.floorHeight/2,
                    128,
                    32));
        }
        for (int i=0; i < 4; i++) {
            l.getEntities().add(new Mushroom(
                    256 + 512*i,
                    l.getFloorHeight()));
        }

        l.setFlag(new Flag(getLevel().width - 128, l.getFloorHeight()));
    }

    @Override
    public Level getLevel() {
        return this.l;
    }
}
