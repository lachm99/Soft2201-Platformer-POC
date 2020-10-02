package stickman.model.stage;

import stickman.config.Config;
import stickman.model.entity.Hero;
import stickman.view.background.Landscape;

public class FirstLevelFactory implements LevelFactory {
    private Level l;

    private final int WIDTH = 1800;
    private final int HEIGHT = 600;
    private final int FLOOR_HEIGHT = 50;

    public FirstLevelFactory() {
        this.l = new FirstLevel(WIDTH, HEIGHT, FLOOR_HEIGHT);
    }

    @Override
    public void makeFromConfig(Config config) {
        // For the moment, ignore config
        this.makePreset();
    }

    @Override
    public void makePreset() {
        l.getBackground().add(new Landscape(this.l));

        Hero h = new Hero();
        h.setX(64);
        h.setY(200);
        l.setHero(h);
    }

    @Override
    public Level getLevel() {
        return this.l;
    }
}
