package stickman.view.animation;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;

public class IdleLeft extends AnimationState {

    public IdleLeft(String assetDir) {
        super(assetDir);
        this.imageView = new ImageView(assetDir.concat("\\").concat("Idle.png"));
        this.imageView.setScaleX(-1); // Flips the image.
        this.height = imageView.getFitHeight();
        this.width = this.height; // Sprites will always be square.
        this.frames = (int) (this.width / this.height);

    }

    @Override
    public void animate() {
        double x = (frames - this.index) * (width - 1);
        imageView.setViewport(new Rectangle2D(x, 0, width, height));
    }
}
