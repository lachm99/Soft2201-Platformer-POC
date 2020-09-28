package Stickman.view;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import Stickman.model.GameEngine;

public class BlockedBackground implements BackgroundDrawer {
    private Rectangle sky;
    private Rectangle floor;
    private ImageView mountains;
    private ImageView trees_1;
    private ImageView trees_2;
    private ImageView trees_3;

    private final double parallax = 0.8;

    private Pane pane;
    private GameEngine model;

    @Override
    public void draw(GameEngine model, Pane pane) {
        this.model = model;
        this.pane = pane;

        double width = pane.getWidth();
        double height = pane.getHeight();
        double floorHeight = model.getCurrentLevel().getFloorHeight();

        this.sky = new Rectangle(0, 0, width, height - floorHeight);
        sky.setFill(Paint.valueOf("LIGHTBLUE"));
        sky.setViewOrder(1000.0);

        this.floor = new Rectangle(0, height - floorHeight, width, floorHeight);
        floor.setFill(Paint.valueOf("GREEN"));
        floor.setViewOrder(500.0);

        pane.getChildren().addAll(sky, floor);

        this.mountains = new ImageView("landscape_0003_4_mountain.png");
        this.mountains.setPreserveRatio(true);
        this.mountains.setFitHeight(600);
        this.mountains.setY(height - mountains.getFitHeight());
        this.mountains.setViewOrder(990);

        this.trees_1 = new ImageView("landscape_0002_3_trees.png");
        this.trees_1.setPreserveRatio(true);
        this.trees_1.setFitHeight(600);
        this.trees_1.setY(height - trees_1.getFitHeight());
        this.trees_1.setViewOrder(980);

        this.trees_2 = new ImageView("landscape_0001_2_trees.png");
        this.trees_2.setPreserveRatio(true);
        this.trees_2.setFitHeight(600);
        this.trees_2.setY(height - trees_2.getFitHeight());
        this.trees_2.setViewOrder(970);

        this.trees_3 = new ImageView("landscape_0000_1_trees.png");
        this.trees_3.setPreserveRatio(true);
        this.trees_3.setFitHeight(600);
        this.trees_3.setY(height - trees_3.getFitHeight());
        this.trees_3.setViewOrder(960);

        pane.getChildren().addAll(mountains, trees_1, trees_2, trees_3);
    }

    @Override
    public void update(double xViewportOffset) {
        this.mountains.setX(-(xViewportOffset * 0.5*parallax));
        this.trees_1.setX(-(xViewportOffset * 0.8*parallax));
        this.trees_2.setX(-(xViewportOffset * 0.9*parallax));
        this.trees_3.setX(-(xViewportOffset * 1*parallax));
    }
}
