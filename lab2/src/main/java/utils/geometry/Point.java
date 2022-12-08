package utils.geometry;

public class Point {
    final private Coordinate coordX;
    final private Coordinate coordY;

    public Point(double x, double y) {
        this.coordX = new DoubleCoordinate(x);
        this.coordY = new DoubleCoordinate(y);
    }

    public Point(double x, Coordinate coordY) {
        this.coordX = new DoubleCoordinate(x);
        this.coordY = coordY;
    }

    public Point(Coordinate coordX, double y) {
        this.coordX = coordX;
        this.coordY = new DoubleCoordinate(y);
    }

    public Point(Coordinate coordX, Coordinate coordY) {
        this.coordX = coordX;
        this.coordY = coordY;
    }

    public double x() {
        return coordX.get();
    }

    public double y() {
        return coordY.get();
    }
}