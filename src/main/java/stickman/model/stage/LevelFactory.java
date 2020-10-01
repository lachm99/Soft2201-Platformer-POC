package stickman.model.stage;

import stickman.config.Config;

public interface LevelFactory {
    void makeFromConfig(Config config);

    void makePreset();

    Level getLevel();
}
