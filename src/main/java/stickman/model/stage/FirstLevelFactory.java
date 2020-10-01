package stickman.model.stage;

import stickman.config.Config;

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
    }

    @Override
    public void makePreset() {
    }

    @Override
    public Level getLevel() {
        return this.l;
    }
}
