import gameMemory.*;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Memory");
        primaryStage.setWidth(Const.CANVAS_WIDTH);
        primaryStage.setHeight(Const.CANVAS_HEIGHT);
        primaryStage.setResizable(false);

        Navigator navigator = new Navigator(primaryStage);
        navigator.registerScene(SceneType.WELCOME, new WelcomeScene(navigator));
        navigator.registerScene(SceneType.GAME, new GameScene(navigator));
        navigator.registerScene(SceneType.GAMEOVER, new GameOverScene(navigator));
        navigator.navigateTo(SceneType.WELCOME);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
