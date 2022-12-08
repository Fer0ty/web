package utils.geometry;

public class DoubleCoordinate implements Coordinate {
    private double value;

    public DoubleCoordinate(double value) {
        this.value = value;
    }

    public double get() {
        return value;
    }

    public void set(double newValue) {
        this.value = newValue;
    }
}