package utils.geometry;

public class Circle extends Figure {
    private Point centre;
    private Coordinate radius;
    private double start;
    private double stop;

    /**
     * @param centre точка центра окружности
     * @param radius радиус окружности
     * */
    public Circle(Point centre, double radius) {
        this(centre, new DoubleCoordinate(radius));
    }

    /**
     * @param start угол начала сегмента окружности в радианах
     * @param stop угол окончания сегмента окружности в радианах
     * */
    public Circle(Point centre, double radius, double start, double stop) {
        this(centre, new DoubleCoordinate(radius), start, stop);
    }

    /**
     * @param centre точка центра окружности
     * @param radius радиус окружности
     * */
    public Circle(Point centre, Coordinate radius) {
        this(centre, radius, 0d, Math.PI*2);
    }

    /**
     * @param centre точка центра окружности
     * @param radius радиус окружности
     * @param start угол начала сегмента окружности в радианах
     * @param stop угол окончания сегмента окружности в радианах
     * */
    public Circle(Point centre, Coordinate radius, double start, double stop) {
        this.centre = centre;
        this.radius = radius;
        if (start < stop && start >= 0d && stop <= Math.PI*2) {
            this.start = start;
            this.stop = stop;
        } else {
            this.start = 0d;
            this.stop = Math.PI*2;
        }
    }

    /**
     * Вычисляет координату x, проверяемой точки, относительно центра окружности.
     * @param p0 проверяемая точка
     * @return координату x в системе отсчета с началом координат в центре окружности
     * */
    private double calcDeltaX(Point p0) {
        return p0.x() - centre.x();
    }

    /**
     * Вычисляет координату y, проверяемой точки, относительно центра окружности.
     * @param p0 проверяемая точка
     * @return координату y в системе отсчета с началом координат в центре окружности
     * */
    private double calcDeltaY(Point p0) {
        return p0.y() - centre.y();
    }

    private double calcCorner(Point p0) {
        double arccos = Math.acos(calcDeltaX(p0)/calcDistance(centre, p0));
        return calcDeltaY(p0) > 0 ? arccos : Math.PI*2 - arccos;
    }

    private boolean pointInCirclePart(Point p0) {
        double corner = calcCorner(p0);
        return start <= corner && corner <= stop;
    }

    private boolean pointInCircle(Point p0) {
        return calcDistance(centre, p0) <= radius.get();
    }

    @Override
    public boolean checkPointInArea(Point p0) {
        return pointInCircle(p0) && pointInCirclePart(p0);
    }
}