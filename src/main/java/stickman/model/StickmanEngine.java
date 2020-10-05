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
    private int lives;
    private int endGame;
    private boolean toReset;

    public StickmanEngine(String configFile) {
        this.gameTitle = "Stickman!";
        this.inputHandler = new StickmanInputHandler(this);
        this.config = new Config();
        config.readJson(configFile);

        this.endGame = 0;
        this.toReset = false;
        this.lives = 3;
        initLevel();
    }

    @Override
    public void initLevel() {
        LevelFactory lf = new FirstLevelFactory();
        lf.makeFromConfig(config);
        this.currentLevel = lf.getLevel();
    }

    private void resetHero() {
        this.currentLevel.getHero().stopMoving();
        this.currentLevel.getHero().setYVel(0);
        this.currentLevel.getHero().setX(this.config.getHeroXPos());
        this.currentLevel.getHero().setY(this.currentLevel.getHeight() - this.config.getHeroYPos() - this.currentLevel.getHero().getHeight());
        this.currentLevel.getHero().setToReset(false);
        this.currentLevel.getHero().disableShooting();
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
        this.currentLevel.moveEntities();
        this.currentLevel.handleCollisions();
        this.checkEndState();
    }

    private void checkEndState() {
        if (this.currentLevel.getHero().getToReset()) {
            if (--lives <= 0) {
                this.endGame = -1;
            } else {
                resetHero();
            }
        }
        if (this.currentLevel.getHero().getHasWon()) {
            this.endGame = 1;
        }
    }

    @Override
    public boolean toReset() {
        return this.toReset;
    }

    @Override
    public void setToReset() {
        this.toReset = true;
    }

    @Override
    public int getEndState() {
        return this.endGame;
    }

}
