package common;
import gameMemory.Point;

public class Util {

    public static Point calculateMemoryCordToPixel(int x, int y) {
        int offsetX = 251;
        int offsetY = 120;
        int widthCard = 64;
        int heightCard = 106;
        int spaceBetweenTwoCards = 14;
        int xFromCard = offsetX + (x - 1) * (widthCard + spaceBetweenTwoCards);
        int yFromCard = offsetY + (y - 1) * (heightCard + spaceBetweenTwoCards);
        return new Point(xFromCard, yFromCard);
    }

    public static int calculatePixelToCardCoordinate(double x, int offset, int cardSide) {

        int spaceBetweenTwoCards = 14;
        double result = x - offset;

        if (result <= 1) {
            return 0;
        }

        if (result < cardSide) {
            return 1;
        } else {
            result = result - cardSide - spaceBetweenTwoCards;
            if (result < cardSide) {
                return 2;
            } else {
                result = result - cardSide - spaceBetweenTwoCards;
                if (result < cardSide) {
                    return 3;
                } else {
                    result = result - cardSide - spaceBetweenTwoCards;
                    if (result < cardSide) {
                        return 4;
                    }
                }

                return 0;
            }
        }
    }
}
