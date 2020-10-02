package stickman.model;

import stickman.config.Config;
import stickman.input.KeyboardInputHandler;
import stickman.input.StickmanInputHandler;
import stickman.model.stage.FirstLevelFactory;
import stickman.model.stage.Level;
import stickman.model.stage.LevelFactory;

public class StickmanEngine implements GameEngine {
    private String gameTitle;
    private Config config;
    private KeyboardInputHandler inputHandler;

    private Level currentLevel;

    public StickmanEngine(String configFile) {
        this.gameTitle = "Stickman!";
        this.inputHandler = new StickmanInputHandler(this);

        LevelFactory lf = new FirstLevelFactory();

        this.config = new Config();
        if (config.readJson(configFile)) {
            lf.makeFromConfig(config);
        } else {
            lf.makePreset();
        }

        this.currentLevel = lf.getLevel();

    }

    @Override
    public String getGameTitle(){
        return this.gameTitle;
    }

    @Override
    public KeyboardInputHandler getInputHandler() {
        return this.inputHandler;
    }

    @Override
    public Level getCurrentLevel() {
        return this.currentLevel;
    }

    @Override
    public void tick() {
        this.currentLevel.tick();
    }
}
