package Stickman.model;

import Stickman.view.Layer;
import org.json.simple.JSONObject;

public class DefaultLevelFactory implements LevelFactory {
    private Level level;

    @Override
    public Level make(Config config) {
        this.level = initLevel();

        Hero h = createHero(config);
        this.level.setHero(h);

        assembleLevel(config);

        return this.level;
    }

    @Override
    public Level initLevel() {
        Level l = new DefaultLevel();
        l.setHeight(600);
        l.setWidth(1200);
        l.setFloorHeight(50);
        l.setGravity(-0.85);
        return l;
    }

    @Override
    public Hero createHero(Config config) {
        Hero h = new Hero();
        if (!config.getHeroSize().equalsIgnoreCase("normal")) {
            if (config.getHeroSize().equalsIgnoreCase("large")) {
                h.setSize("large");
            }
        } else {
            h.setSize("normal");
        }

        h.setX(config.getHeroXPos());
        h.setY(level.getHeight() - config.getHeroYPos());
        h.setImgPath("ch_stand1.png");
        h.setLayer(Layer.FOREGROUND);

        return h;
    }

    @Override
    public boolean assembleLevel(Config config) {
        // Add mushrooms at floor height, based on config.
        for (Object m : config.getMushrooms()) {
            JSONObject mushroom = (JSONObject) m;
            double x = Double.parseDouble(mushroom.get("xPos").toString());
            double height = Double.parseDouble(mushroom.get("height").toString());
            level.getEntities().add(new Mushroom(x, level.getHeight() - level.getFloorHeight() - height, height));
        }
        // Add platforms as specified
        for (Object p : config.getPlatforms()) {
            JSONObject platform = (JSONObject) p;
            double x = Double.parseDouble(platform.get("xPos").toString());
            double y = Double.parseDouble(platform.get("yPos").toString());
            double len = Double.parseDouble(platform.get("length").toString());

            level.getEntities().add(new Platform(x, level.getHeight() - y, len));
        }

        // Add invisible barriers that the player collides with (floor, edges etc.)
        level.getEntities().add(new Barrier(-10,0, level.getHeight(), 10));
        level.getEntities().add(new Barrier(level.getWidth(),0, level.getHeight(), 10));
        level.getEntities().add(new Barrier(0,level.getHeight() - level.getFloorHeight(), 10, level.getWidth()));





        return false;
    }
}
