package Stickman.model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Config implements ConfigReader {
    private String stickmanSize;
    private double cloudSpeed;
    private JSONArray stickmanPos;
    private JSONArray platforms;
    private JSONArray mushroomsPos;
    private JSONArray enemies;
    private JSONArray flagPos;


    public Config(String configFile) {
        readConfig(configFile);
    }

    @Override
    public void readConfig(String filePath) {
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(filePath)) {
            Object obj = jsonParser.parse(reader);
            JSONObject configJson = (JSONObject) obj;

            this.stickmanSize = (String) configJson.get("stickmanSize");
            this.stickmanPos = (JSONArray) configJson.get("stickmanPos");

            this.cloudSpeed = Double.parseDouble((String)configJson.get("cloudSpeed"));

            this.platforms = (JSONArray) configJson.get("platforms");
            this.mushroomsPos = (JSONArray) configJson.get("mushroomsPos");
            this.enemies = (JSONArray) configJson.get("enemies");
            this.flagPos = (JSONArray) configJson.get("flagPos");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return;
    }


    public String getHeroSize() {
        return this.stickmanSize;
    }

    public double getHeroXPos() {
        return Double.parseDouble(this.stickmanPos.get(0).toString());
    }

    public double getHeroYPos() {
        return Double.parseDouble(this.stickmanPos.get(1).toString());
    }

    public double getCloudSpeed() {
        return this.cloudSpeed;
    }

}
