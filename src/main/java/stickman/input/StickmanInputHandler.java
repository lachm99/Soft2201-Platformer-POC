package stickman.input;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.MediaPlayer;
import stickman.model.GameEngine;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StickmanInputHandler implements KeyboardInputHandler{
    private final GameEngine engine;

    private boolean left = false;
    private boolean right = false;

    private Set<KeyCode> pressedKeys = new HashSet<>();

    private Map<String, MediaPlayer> sounds = new HashMap<>();


    public StickmanInputHandler(GameEngine engine) {
        this.engine = engine;
    }

    @Override
    public void handlePressed(KeyEvent keyEvent) {
        if (pressedKeys.contains(keyEvent.getCode())) {
            return;
        } else {
            pressedKeys.add(keyEvent.getCode());
        }

        switch (keyEvent.getCode()) {
            case LEFT:
                this.left = true;
                break;
            case RIGHT:
                this.right = true;
                break;
            case UP:
                // engine.getCurrentLevel().heroJump();
                return;
            case SPACE:
                // engine.getCurrentLevel().heroShoot();
                return;
            default:
                return;
        }


        if (right ^ left) {
            if (right) {
                engine.getCurrentLevel().moveRight();
            } else {
                engine.getCurrentLevel().moveLeft();
            }
        } else {
            engine.getCurrentLevel().stopMoving();
        }

    }

    @Override
    public void handleReleased(KeyEvent keyEvent) {
        pressedKeys.remove(keyEvent.getCode());

        switch (keyEvent.getCode()) {
            case LEFT:
                this.left = false;
                break;
            case RIGHT:
                this.right = false;
                break;
            default:
                return;
        }

        if (right ^ left) {
            if (right) {
                engine.getCurrentLevel().moveRight();
            } else {
                engine.getCurrentLevel().moveLeft();
            }
        } else {
            engine.getCurrentLevel().stopMoving();
        }
    }
}
