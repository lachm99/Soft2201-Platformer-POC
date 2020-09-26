package Stickman.model;

public class Model implements GameEngine{
    private Level currentLevel;
    private Config config;

    public Model(String configFile) {
        this.config = new Config(configFile);

        LevelFactory lf = new DefaultLevelFactory();
        this.currentLevel = lf.make(this.config);
    }


    @Override
    public Level getCurrentLevel() {
        return this.currentLevel;
    }

    @Override
    public void startLevel() {

    }

    @Override
    public boolean jump() {
        return this.getCurrentLevel().jump();
    }

    @Override
    public boolean moveLeft() {
        return this.getCurrentLevel().moveLeft();
    }

    @Override
    public boolean moveRight() {
        return this.getCurrentLevel().moveRight();
    }

    @Override
    public boolean stopMoving() {
        return this.getCurrentLevel().stopMoving();
    }

    @Override
    public void tick() {
         this.getCurrentLevel().tick();
    }
}
