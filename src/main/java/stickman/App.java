package stickman;

import javafx.application.Application;
import javafx.stage.Stage;
import stickman.model.GameEngine;
import stickman.model.StickmanEngine;
import stickman.view.GameWindow;

public class App extends Application {
    private final double WINDOW_WIDTH = 800;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GameEngine engine = new StickmanEngine("src/main/resources/configExample.json");

        GameWindow window = new GameWindow();
        window.assignEngine(engine);
        window.assignStage(primaryStage);

        window.setup(WINDOW_WIDTH);

        window.run();
    }
}
