package Stickman.view;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import Stickman.model.GameEngine;

public class BlockedBackground implements BackgroundDrawer {
    private Rectangle sky;
    private Rectangle floor;
    private ImageView tree;
    private ImageView tree2;

    private int treeX = 500;
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
        floor.setViewOrder(1000.0);

        pane.getChildren().addAll(sky, floor);

        this.tree = new ImageView("tree.png");
        this.tree2 = new ImageView("tree.png");

        this.tree.setX(treeX);
        this.tree2.setX(2*treeX);
        this.tree.setY(height - floorHeight - tree.getImage().getHeight());
        this.tree2.setY(height - floorHeight - tree.getImage().getHeight());

        this.tree.setViewOrder(1000.0);
        this.tree2.setViewOrder(1000.0);

        pane.getChildren().addAll(tree, tree2);
    }

    @Override
    public void update(double xViewportOffset) {
        this.tree.setX(treeX - xViewportOffset);
        this.tree2.setX(2*treeX - xViewportOffset);

    }
}
