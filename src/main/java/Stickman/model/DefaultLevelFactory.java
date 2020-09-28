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
        l.setGravity(-0.9);
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
        for (Object m : config.getMushrooms()) {
            JSONObject mushroom = (JSONObject) m;
            double x = Double.parseDouble(mushroom.get("xPos").toString());
            double y = Double.parseDouble(mushroom.get("yPos").toString());

            level.getEntities().add(new Mushroom(x, level.getHeight() - y - 20));
        }

        return false;
    }
}
