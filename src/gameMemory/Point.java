package gameMemory;

public class Point {
    private final int x;
    private final int y;

    public Point(double x, double y) {
        this.x = (int) x;
        this.y = (int) y;
    }
    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

}
