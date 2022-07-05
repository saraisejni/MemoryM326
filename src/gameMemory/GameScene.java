package gameMemory;
import common.Util;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class GameScene extends Scene {

    private static final HBox rootNode = new HBox();
    private final CardSet cardSet = new CardSet();
    private Navigator navigator;
    private boolean userIsBlockedToMemoriseOpenCards = false;
    private Player currentPlayer = Player.A;
    private int scorePlayerOne = 0;
    private int scorePlayerTwo = 0;
    private Image image = new Image(this.getClass().getResourceAsStream("../bilder/border.png"));
    boolean b = false;

    public GameScene(Navigator navigator) {
        super(rootNode);

        this.navigator = navigator;

        Canvas canvas = new Canvas(Const.CANVAS_WIDTH, Const.CANVAS_HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        rootNode.getChildren().add(canvas);
        drawHeader(gc);
        cardSet.handout();
        drawMemory(gc);


        this.setOnMouseClicked((MouseEvent event) -> {
            if (event.getButton() != MouseButton.PRIMARY) {
                return;
            }

            if (userIsBlockedToMemoriseOpenCards) {
                return;
            }

            int offsetX = 251;
            int offsetY = 120;
            int widthCard = 64;
            int heightCard = 106;
            int x = Util.calculatePixelToCardCoordinate(event.getX(), offsetX, widthCard);
            int y = Util.calculatePixelToCardCoordinate(event.getY(), offsetY, heightCard);
            if (x == 0 || y == 0) {
                return;
            }

            Card card = cardSet.getCard(x, y);
            if (card.isPaired() || card.isUncovered()) {
                return;
            } else {
                card.setStatus(Status.UNCOVERED);
            }

            if (cardSet.areTwoCardsUncover()) {
                Card card1 = (Card) cardSet.getUncoveredCards().get(0);
                Card card2 = (Card) cardSet.getUncoveredCards().get(1);
                if (card1.getCardcolor().equals(card2.getCardcolor())) {
                    card1.setStatus(Status.PAIRED);
                    card2.setStatus(Status.PAIRED);
                    score();
                } else {
                    changePlayer();
                }

                userIsBlockedToMemoriseOpenCards = true;

                ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);
                executor.schedule(() -> {
                    userIsBlockedToMemoriseOpenCards = false;
                    cardSet.coverAll();
                    drawMemory(gc);
                }, 1, TimeUnit.SECONDS);
            }
            drawMemory(gc);
            if (checkIfGameOver()) {
                navigator.navigateTo(SceneType.GAMEOVER);
            }

        });
    }

    private boolean checkIfGameOver() {
        if (scorePlayerOne + scorePlayerTwo >= 8) {
            return true;
        } return false;
    }

    private void score() {
        if (currentPlayer == Player.A) {
            scorePlayerOne++;
        } else {
            scorePlayerTwo++;
        }
    }

    private void changePlayer() {
        if (currentPlayer == Player.A) {
            currentPlayer = Player.B;
        } else {
            currentPlayer = Player.A;

        }

    }

    private void drawMemory(GraphicsContext gc) {
        drawBackground(gc);
        drawHeader(gc);
        drawScore(gc);
        drawCurrentPlayerSelection(gc);
        cardSet.draw(gc);
    }

    private void drawCurrentPlayerSelection(GraphicsContext gc) {
        if (currentPlayer == Player.A) {
            gc.drawImage(image, 20, 30);
        } else {
            gc.drawImage(image, 600, 30);
        }
    }

    private void drawBackground(GraphicsContext gc) {
        gc.setFill(Color.rgb(32, 46, 66));
        gc.rect(0, 0, Const.CANVAS_WIDTH, Const.CANVAS_HEIGHT);
        gc.fill();
    }

    private void drawScore(GraphicsContext gc) {
        gc.setFill(Color.rgb(255, 255, 255));
        gc.setFont(new Font("Goudy Old Style", 20));
        gc.fillText("Score: " + scorePlayerOne, 50, 100);
        gc.setFill(Color.rgb(255, 255, 255));
        gc.setFont(new Font("Goudy Old Style", 20));
        gc.fillText("Score: " + scorePlayerTwo, 620, 100);
    }

    private void drawHeader(GraphicsContext gc) {
        gc.setFill(Color.rgb(255, 255, 255));
        gc.setFont(new Font("Jaldi", 27));
        gc.fillText("timer", 260, 60);
        gc.setFill(Color.rgb(255, 255, 255));
        gc.setFont(new Font("Jaldi", 27));
        gc.fillText("Spieler 1", 50, 60);
        gc.setFill(Color.rgb(255, 255, 255));
        gc.setFont(new Font("Jaldi", 27));
        gc.fillText("Spieler 2", 620, 60);

    }
}