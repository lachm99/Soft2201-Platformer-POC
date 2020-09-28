package Stickman.model;

public interface LevelFactory {

    Level make(Config config);

    Level initLevel();

    Hero createHero(Config config);
    boolean assembleLevel(Config config);

}
