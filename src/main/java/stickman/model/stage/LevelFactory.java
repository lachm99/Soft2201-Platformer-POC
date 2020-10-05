package stickman.model.stage;

import stickman.config.Config;

public interface LevelFactory {
    void addBackground();

    void addBounds();

    void setGravity(double gravity);

    void makeFromConfig(Config config);

    void makePreset();

    Level getLevel();
}
