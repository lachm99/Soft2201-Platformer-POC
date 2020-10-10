package stickman.input;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import stickman.model.GameEngine;

import java.net.URL;
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

        URL mediaUrl = getClass().getResource("/jump.wav");
        String jumpURL = mediaUrl.toExternalForm();

        Media sound = new Media(jumpURL);
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        sounds.put("jump", mediaPlayer);


        URL mediaUrl2 = getClass().getResource("/shoot.wav");
        String shootURL = mediaUrl2.toExternalForm();

        Media sound2 = new Media(shootURL);
        MediaPlayer mediaPlayer2 = new MediaPlayer(sound2);
        sounds.put("shoot", mediaPlayer2);

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
                if (engine.getCurrentLevel().heroJump()) {
                    MediaPlayer jumpPlayer = sounds.get("jump");
                    jumpPlayer.stop();
                    jumpPlayer.play();
                }
                return;
            case SPACE:
                if (engine.getCurrentLevel().heroShoot()) {
                    MediaPlayer shootPlayer = sounds.get("shoot");
                    shootPlayer.stop();
                    shootPlayer.play();
                };
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
