package stickman.view.animation;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;

public class WalkRight extends AnimationState{

    public WalkRight(String assetDir) {
        super(assetDir);
        this.imageView = new ImageView(assetDir.concat("\\").concat("Idle.png"));
        this.height = imageView.getFitHeight();
        this.width = this.height; // Sprites will always be square.
        this.frames = (int) (this.width / this.height);
    }

    @Override
    public void animate() {
        double x = this.index * width;
        imageView.setViewport(new Rectangle2D(x, 0, width, height));
    }
}
