package stickman.input;
import javafx.scene.input.KeyEvent;

public interface KeyboardInputHandler {
    public void handlePressed(KeyEvent keyEvent);
    public void handleReleased(KeyEvent keyEvent);
}
