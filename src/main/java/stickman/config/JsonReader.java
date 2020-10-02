package stickman.config;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonReader implements ConfigReader {
    private boolean success;
    private JSONObject configJson;
    private JSONArray heroPos;
    private JSONArray platformsPos;
    private JSONArray mushroomsPos;
    private JSONArray enemies;

    public JsonReader(String filePath) {
        success = false;
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(filePath)) {
            Object obj = jsonParser.parse(reader);
            this.configJson = (JSONObject) obj;

            this.heroPos = (JSONArray) configJson.get("heroPos");
            this.platformsPos = (JSONArray) configJson.get("platformsPos");
            this.mushroomsPos = (JSONArray) configJson.get("mushroomsPos");
            this.enemies = (JSONArray) configJson.get("enemies");

            success = true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean wasSuccessful() {
        return this.success;
    }

    @Override
    public String getHeroSize() {
        return (String) configJson.get("heroSize");
    }

    @Override
    public int getHeroXPos() {
        return Integer.parseInt((String) heroPos.get(0));
    }

    @Override
    public int getHeroYPos() {
        return Integer.parseInt((String) heroPos.get(1));
    }

    @Override
    public double getCloudVelocity() {
        return Double.parseDouble((String) configJson.get("cloudVelocity"));
    }

    @Override
    public int getFlagX() {
        return Integer.parseInt((String) configJson.get("flagPos"));
    }

    @Override
    public List<Integer> getMushroomsX() {
        List<Integer> mushroomsX = new ArrayList<Integer>();
        for (Object m : mushroomsPos) {
            mushroomsX.add(Integer.parseInt((String) m));
        }
        return mushroomsX;
    }

    @Override
    public List<Integer> getPlatformsX() {
        List<Integer> platformsX = new ArrayList<Integer>();
        for (Object pObj : platformsPos) {
            JSONObject p = (JSONObject) pObj;
            platformsX.add(Integer.parseInt((String) p.get("xPos")));
        }
        return platformsX;
    }

    @Override
    public List<Integer> getPlatformsY() {
        List<Integer> platformsY = new ArrayList<Integer>();
        for (Object pObj : platformsPos) {
            JSONObject p = (JSONObject) pObj;
            platformsY.add(Integer.parseInt((String) p.get("yPos")));
        }
        return platformsY;
    }

    @Override
    public List<Integer> getPlatformsLength() {
        List<Integer> platformsLength = new ArrayList<Integer>();
        for (Object pObj : platformsPos) {
            JSONObject p = (JSONObject) pObj;
            platformsLength.add(Integer.parseInt((String) p.get("length")));
        }
        return platformsLength;
    }


    @Override
    public List<Integer> getEnemiesX() {
        List<Integer> enemiesX = new ArrayList<Integer>();
        for (Object eObj : enemies) {
            JSONObject e = (JSONObject) eObj;
            enemiesX.add(Integer.parseInt((String) e.get("xPos")));
        }
        return enemiesX;
    }

    @Override
    public List<String> getEnemiesType() {
        List<String> enemiesType = new ArrayList<String>();
        for (Object eObj : enemies) {
            JSONObject e = (JSONObject) eObj;
            enemiesType.add((String) e.get("type"));
        }
        return enemiesType;
    }

}
