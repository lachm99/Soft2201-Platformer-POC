package stickman.input;

import javafx.scene.input.KeyEvent;
import stickman.model.GameEngine;
import stickman.model.StickmanEngine;

public class StickmanInputHandler implements KeyboardInputHandler{
    private final GameEngine engine;

    public StickmanInputHandler(StickmanEngine stickmanEngine) {
        this.engine = stickmanEngine;
    }

    @Override
    public void handlePressed(KeyEvent keyEvent) {

    }

    @Override
    public void handleReleased(KeyEvent keyEvent) {

    }
}
