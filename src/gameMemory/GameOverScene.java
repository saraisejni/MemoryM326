package gameMemory;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class GameOverScene extends Scene {
    private static final HBox rootNode = new HBox();

    public GameOverScene(Navigator navigator) {
        super(rootNode);

        Canvas canvas = new Canvas(Const.CANVAS_WIDTH, Const.CANVAS_HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.rgb(88, 138, 147));
        gc.rect(0, 0, Const.CANVAS_WIDTH, Const.CANVAS_HEIGHT);
        gc.setFill(Color.rgb(255, 255, 255));
        gc.setFont(new Font("Georgia", 100));
        gc.fillText("GAME-OVER!", 310, 150);


        rootNode.getChildren().add(canvas);
    }
}
