package stickman.config;

import java.util.List;

public class Config {
    private String heroSize;
    private int mapHeight;
    private int floorHeight;
    private int heroXPos;
    private int heroYPos;
    private double cloudVelocity;
    private int flagX;
    private int flagY;
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
        this.mapHeight = j.getMapHeight();
        this.floorHeight = j.getFloorHeight();
        this.heroXPos = j.getHeroXPos();
        this.heroYPos = j.getHeroYPos();
        this.cloudVelocity = j.getCloudVelocity();
        this.flagX = j.getFlagX();
        this.flagY = j.getFlagY();
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

    public int getMapHeight() {
        return this.mapHeight;
    }

    public int getFloorHeight() {
        return this.floorHeight;
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

    public int getFlagY() {
        return flagY;
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
