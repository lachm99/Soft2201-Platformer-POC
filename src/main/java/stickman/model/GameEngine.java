package stickman.model;

import stickman.input.KeyboardInputHandler;
import stickman.model.stage.Level;

public interface GameEngine {

    void tick();

    String getGameTitle();

    KeyboardInputHandler getInputHandler();

    Level getCurrentLevel();

}
