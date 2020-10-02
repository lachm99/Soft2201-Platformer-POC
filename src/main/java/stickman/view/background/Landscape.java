package stickman.view.background;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import stickman.model.stage.Level;

public class Landscape implements BackgroundItem{
    private ImageView mountains;
    private ImageView trees_1;
    private ImageView trees_2;
    private ImageView trees_3;

    private double parallax;

    public Landscape(Level l) {
        this.mountains = new ImageView("landscape_0003_4_mountain.png");
        this.mountains.setPreserveRatio(true);
        this.mountains.setFitHeight(l.getHeight() / 0.8);
        this.mountains.setY(l.getHeight() - mountains.getFitHeight());
        this.mountains.setViewOrder(990);

        this.trees_1 = new ImageView("landscape_0002_3_trees.png");
        this.trees_1.setPreserveRatio(true);
        this.trees_1.setFitHeight(l.getHeight() / 0.8);
        this.trees_1.setY(l.getHeight() - mountains.getFitHeight());
        this.trees_1.setViewOrder(980);

        this.trees_2 = new ImageView("landscape_0001_2_trees.png");
        this.trees_2.setPreserveRatio(true);
        this.trees_2.setFitHeight(l.getHeight() / 0.8);
        this.trees_2.setY(l.getHeight() - mountains.getFitHeight());
        this.trees_2.setViewOrder(970);

        this.trees_3 = new ImageView("landscape_0000_1_trees.png");
        this.trees_3.setPreserveRatio(true);
        this.trees_3.setFitHeight(l.getHeight() / 0.8);
        this.trees_3.setY(l.getHeight() - mountains.getFitHeight());
        this.trees_3.setViewOrder(960);

        this.parallax = 0.95;

    }

    @Override
    public void draw(Pane windowPane) {
        windowPane.getChildren().addAll(mountains, trees_1, trees_2, trees_3);
    }

    @Override
    public void update(double viewportOffset) {
        this.mountains.setX(-(viewportOffset * 0.2*parallax));
        this.trees_1.setX(-(viewportOffset * 0.6*parallax));
        this.trees_2.setX(-(viewportOffset * 0.8*parallax));
        this.trees_3.setX(-(viewportOffset * 0.95*parallax));
    }
}
