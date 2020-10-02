package stickman.view.animation;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class IdleLeft extends AnimationState {

    public IdleLeft(String assetDir) {
        super(assetDir);
        this.spriteStrip = new Image(assetDir.concat("/").concat("Idle.png"));
        this.height = spriteStrip.getHeight();
        this.width = spriteStrip.getWidth(); // Strip width for whole spritestrip.
        this.frames = (int) (this.width / this.height);
    }

    @Override
    public void updateSpriteFrame(ImageView imgView) {
        if (imgView.getImage() == null || !imgView.getImage().equals(this.spriteStrip)) {
            imgView.setScaleX(-1);
            imgView.setImage(this.spriteStrip);
            this.index = 0;
        }
        double x = (frames - index%frames) * height;
        imgView.setViewport(new Rectangle2D(x - height, 0, height, height));
    }
}
