package stickman.config;

import java.util.List;

public interface ConfigReader {

    boolean wasSuccessful();

    int getMapHeight();

    int getFloorHeight();

    String getHeroSize();

    int getHeroXPos();

    int getHeroYPos();

    double getCloudVelocity();

    int getFlagX();

    int getFlagY();

    List<Integer> getMushroomsX();

    List<Integer> getPlatformsX();

    List<Integer> getPlatformsY();

    List<Integer> getPlatformsLength();

    List<Integer> getEnemiesX();

    List<String> getEnemiesType();

}
