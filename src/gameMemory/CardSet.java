package gameMemory;
import common.RandomListPicker;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CardSet {

    private final RandomListPicker<Cardcolor> cardColorSet = new RandomListPicker<>(new LinkedList<>(
            Arrays.asList(Cardcolor.BROWN, Cardcolor.BROWN, Cardcolor.DARKBLUE, Cardcolor.GREEN,
                    Cardcolor.LIGHTBLUE, Cardcolor.ORANGE, Cardcolor.PURPLE, Cardcolor.RED, Cardcolor.YELLOW,
                    Cardcolor.DARKBLUE, Cardcolor.GREEN, Cardcolor.LIGHTBLUE, Cardcolor.ORANGE, Cardcolor.PURPLE,
                    Cardcolor.RED, Cardcolor.YELLOW)));

    private List<Card> cards = new ArrayList<>();

    public void handout() {
        for (int y = 1; y <= 4; y++) {
            for (int x = 1; x <= 4; x++) {
                cards.add(new Card(cardColorSet.pick(), x, y));
            }
        }
    }

    public void draw(GraphicsContext gc) {
        for (Card card : cards) {
            card.draw(gc);
        }
    }

    public Card getCard(int x, int y) {
        for (Card card : cards) {
            if (card.getX() == x & card.getY() == y) {
                return card;
            }
        }

        throw new RuntimeException("No card found on: " + x + ", " + y);
    }

    public boolean areTwoCardsUncover() {
        int counter = 0;
        for (Card card : cards) {
            if (card.   isUncovered()) {
                counter++;
                if (counter == 2) {
                    return true;
                }
            }
        }
        return false;
    }

    public ArrayList getUncoveredCards() {
        ArrayList<Card> uncovoredCards = new ArrayList<>();
        for (Card card : cards) {
            if (card.isUncovered()) {
                uncovoredCards.add(card);
            }
        }
        return uncovoredCards;
    }

    public void coverAll() {
        for (Card card : cards) {
            if (card.isPaired() == false) {
                card.cover();
            }
        }
    }
}
