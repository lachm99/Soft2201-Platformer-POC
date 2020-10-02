package stickman.view.background;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import stickman.model.stage.Level;

public class Floor implements BackgroundItem{
    private Rectangle walkLayer;
    private Rectangle sideLayer;

    public Floor(Level l) {
        this.walkLayer = new Rectangle(0, l.getFloorHeight(), l.getWidth(), 70);
        this.walkLayer.setFill(Paint.valueOf("OLIVEDRAB"));
        this.walkLayer.setViewOrder(100);

        this.sideLayer = new Rectangle(0, l.getFloorHeight() - 10, l.getWidth(), 30);
        this.sideLayer.setFill(Paint.valueOf("OLIVE"));
        this.sideLayer.setViewOrder(90);

    }

    @Override
    public void draw(Pane windowPane) {
        windowPane.getChildren().addAll(walkLayer, sideLayer);
    }

    @Override
    public void update(double viewportOffset) {
        //
    }
}
