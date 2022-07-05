package gameMemory;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class WelcomeScene extends Scene {

    private static HBox rootNode = new HBox();
    private Image image = new Image(this.getClass().getResourceAsStream("../bilder/lightbulb.png"));

    public WelcomeScene(Navigator navigator) {
        super(rootNode);


        Canvas canvas = new Canvas(Const.CANVAS_WIDTH, Const.CANVAS_HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.rgb(32, 46, 66));
        gc.rect(0, 0, Const.CANVAS_WIDTH, Const.CANVAS_HEIGHT);
        gc.fill();
        gc.setFill(Color.rgb(255, 255, 255));
        gc.setFont(new Font("JejuGothic", 36));
        gc.fillText("WELCOME TO THE MEMORY", 150, 152);
        gc.setFill(Color.rgb(255, 255, 255));
        gc.setFont(new Font("Jaldi", 26));
        gc.fillText("choose a game mode", 217, 331);


        rootNode.getChildren().add(canvas);

        this.setOnKeyPressed((e) -> {
            if (e.getCode() == KeyCode.SPACE) {
                navigator.navigateTo(SceneType.GAME);
            }
        });
    }
}