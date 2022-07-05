package gameMemory;
import common.Util;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Card {

    private final Cardcolor cardcolor;
    private Status status = Status.COVERED;
    private final int x;
    private final int y;

    public Card(Cardcolor cardcolor, int x, int y) {
        this.cardcolor = cardcolor;
        this.x = x;
        this.y = y;
    }

    public void draw(GraphicsContext gc){
        Point upperLeftCornerOfCardInPixel = Util.calculateMemoryCordToPixel(x, y);

        Image cardImage = null;
        if (status == Status.COVERED) {
            cardImage = Images.loadCover();
        } else {
            cardImage = Images.load(cardcolor);
        }

        gc.drawImage(cardImage, upperLeftCornerOfCardInPixel.getX(), upperLeftCornerOfCardInPixel.getY());
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Cardcolor getCardcolor() {
        return this.cardcolor;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public boolean isCovered() {
        return status == Status.COVERED;
    }

    public boolean isPaired() {
        return status == Status.PAIRED;
    }

    public void cover() {
        status = Status.COVERED;
    }

    public boolean isUncovered() {
        return status == Status.UNCOVERED;
    }
}
