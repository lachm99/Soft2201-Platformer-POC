package stickman.config;

import java.util.List;

public interface ConfigReader {

    boolean wasSuccessful();

    String getHeroSize();

    int getHeroXPos();

    int getHeroYPos();

    double getCloudVelocity();

    int getFlagX();

    List<Integer> getMushroomsX();

    List<Integer> getPlatformsX();

    List<Integer> getPlatformsY();

    List<Integer> getPlatformsLength();

    List<Integer> getEnemiesX();

    List<String> getEnemiesType();

}
