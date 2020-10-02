package stickman.view.animation;
import javafx.scene.image.ImageView;

public abstract class AnimationState {
    protected String assetDir;
    protected ImageView imageView;
    protected double width;
    protected double height;
    protected int frames;
    protected int index;

    public AnimationState(String assetDir) {
        this.assetDir = assetDir;
        this.index = 0;
    }

    public abstract void animate();
}
