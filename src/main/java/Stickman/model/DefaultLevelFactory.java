package Stickman.model;

import Stickman.view.Layer;

public class DefaultLevelFactory implements LevelFactory {
    private Level level;

    @Override
    public Level make(Config config) {
        this.level = initLevel();
        Hero h = createHero(config);
        h.setX(config.getHeroXPos());
        h.setY(level.getHeight() - config.getHeroYPos());
        this.level.setHero(h);


        return this.level;
    }

    @Override
    public Level initLevel() {
        Level l = new DefaultLevel();
        l.setHeight(600);
        l.setWidth(800);
        l.setFloorHeight(50);
        l.setGravity(-1);
        return l;
    }

    @Override
    public Hero createHero(Config config) {
        Hero h = new Hero();
        if (!config.getHeroSize().equalsIgnoreCase("normal")) {
            if (config.getHeroSize().equalsIgnoreCase("large")) {
                h.setSize("large");
            }
        }
        else {
            h.setSize("normal");

        }

        h.setImgPath("ch_stand1.png");
        h.setLayer(Layer.FOREGROUND);

        return h;
    }

    @Override
    public boolean assembleLevel() {
        return false;
    }
}
