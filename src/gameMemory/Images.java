package gameMemory;

import javafx.scene.image.Image;

public class Images {

    public static Image load(Cardcolor cardcolor) {

        String path = null;

        switch (cardcolor) {
            case GREEN :{
                path = "../bilder/green.jpg";
            }
            case BROWN : {
                path = "../bilder/brown.jpg";
            }
            case PURPLE : {
                path = "../bilder/purple.jpg";
            }
            case DARKBLUE : {
                path = "../bilder/darkblue.jpg";
            }
            case YELLOW : {
                path = "../bilder/yellow.jpg";
            }
            case LIGHTBLUE : {
                path = "../bilder/lightblue.jpg";
            }
            case RED : {
                path = "../bilder/red.jpg";
            }
            case ORANGE : {
                path = "../bilder/orange.jpg";
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
