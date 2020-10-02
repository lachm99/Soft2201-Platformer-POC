package stickman.view.animation;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class AnimationState {
    protected String assetDir;
    protected Image spriteStrip;
    protected double width;
    protected double height;
    protected int frames;
    protected int tickCount;
    protected int index;

    public AnimationState(String assetDir) {
        this.assetDir = assetDir;
        this.tickCount = 0;
        this.index = 0;
    }

    public void update(ImageView imgView) {
        tickCount++;
        if (tickCount % 3 == 0) {
            this.index ++;
            updateSpriteFrame(imgView);
        }
    }

    public abstract void updateSpriteFrame(ImageView imgView);
}
