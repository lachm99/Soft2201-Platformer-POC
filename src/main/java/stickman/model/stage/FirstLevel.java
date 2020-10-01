package stickman.model.stage;

import stickman.view.background.Landscape;

public class FirstLevel extends Level {

    public FirstLevel(double width, double height, double floorHeight) {
        super(width, height, floorHeight);
        this.background.add(new Landscape(this));
    }

    @Override
    public void tick() {

    }
}
