package stickman.view.animation;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class WalkRight extends AnimationState{

    public WalkRight(String assetDir) {
        super(assetDir);
        this.spriteStrip = new Image(assetDir.concat("/").concat("Walk.png"));
        this.height = spriteStrip.getHeight();
        this.width = spriteStrip.getWidth(); // Strip width for whole spritestrip.
        this.frames = (int) (this.width / this.height);

    }

    @Override
    public void updateSpriteFrame(ImageView imgView) {
        if (imgView.getImage() == null || !imgView.getImage().equals(this.spriteStrip)) {
            imgView.setScaleX(1);
            imgView.setImage(this.spriteStrip);
            this.index = 0;
        }
        double x = (index%frames) * height;
        imgView.setViewport(new Rectangle2D(x, 0, height, height));
    }
}
