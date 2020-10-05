package stickman.model;

import stickman.input.KeyboardInputHandler;
import stickman.model.stage.Level;

public interface GameEngine {

    void tick();

    void initLevel();

    String getGameTitle();

    KeyboardInputHandler getInputHandler();

    Level getCurrentLevel();

    int getEndState();

    boolean toReset();

    void setToReset();
}
