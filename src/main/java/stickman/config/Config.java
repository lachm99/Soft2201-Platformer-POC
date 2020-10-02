package stickman.config;

import java.util.List;

public class Config {
    private String heroSize;
    private int heroXPos;
    private int heroYPos;
    private double cloudVelocity;
    private int flagX;
    private List<Integer> mushroomsX;
    private List<Integer> platformsX;
    private List<Integer> platformsY;
    private List<Integer> platformsLength;
    private List<Integer> enemiesX;
    private List<String> enemiesType;

    public boolean readJson(String filePath) {
        JsonReader j = new JsonReader(filePath);
        if (!j.wasSuccessful()) {
            return false;
        }
        this.heroSize = j.getHeroSize();
        this.heroXPos = j.getHeroXPos();
        this.heroYPos = j.getHeroYPos();
        this.cloudVelocity = j.getCloudVelocity();
        this.flagX = j.getFlagX();
        this.mushroomsX = j.getMushroomsX();
        this.platformsX = j.getPlatformsX();
        this.platformsLength = j.getPlatformsLength();
        this.platformsY = j.getPlatformsY();
        this.enemiesX = j.getEnemiesX();
        this.enemiesType = j.getEnemiesType();
        return true;
    }

    public String getHeroSize() {
        return heroSize;
    }

    public int getHeroXPos() {
        return heroXPos;
    }

    public int getHeroYPos() {
        return heroYPos;
    }

    public double getCloudVelocity() {
        return cloudVelocity;
    }

    public int getFlagX() {
        return flagX;
    }

    public List<Integer> getMushroomsX() {
        return mushroomsX;
    }

    public List<Integer> getPlatformsX() {
        return platformsX;
    }

    public List<Integer> getPlatformsY() {
        return platformsY;
    }

    public List<Integer> getPlatformsLength() {
        return platformsLength;
    }

    public List<Integer> getEnemiesX() {
        return enemiesX;
    }

    public List<String> getEnemiesType() {
        return enemiesType;
    }
}
