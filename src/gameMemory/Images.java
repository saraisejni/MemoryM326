package gameMemory;

import javafx.scene.image.Image;

public class Images {

    public static Image load(Cardcolor cardcolor) {

        String path = null;

        switch (cardcolor) {
            case GREEN : {
                path = "../bilder/green.jpg";
                break;
            }
            case BROWN : {
                path = "../bilder/brown.jpg";
                break;
            }
            case PURPLE : {
                path = "../bilder/purple.jpg";
                break;
            }
            case DARKBLUE : {
                path = "../bilder/darkblue.jpg";
                break;
            }
            case YELLOW : {
                path = "../bilder/yellow.jpg";
                break;
            }
            case LIGHTBLUE : {
                path = "../bilder/lightblue.jpg";
                break;
            }
            case RED : {
                path = "../bilder/red.jpg";
                break;
            }
            case ORANGE : {
                path = "../bilder/orange.jpg";
                break;
            }
        }
        if (path == null) {
            throw new RuntimeException("No image found for: " + cardcolor);
        }

        return new Image(Images.class.getResourceAsStream(path));
    }

    public static Image loadCover() {
        return new Image(Images.class.getResourceAsStream("../bilder/white.png"));
    }
}