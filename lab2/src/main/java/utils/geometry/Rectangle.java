package utils.geometry;

import static java.lang.Math.abs;

public class Rectangle extends Figure {
    final private Point p1;
    final private Point p2;

    /**
     * @param p1 точка первого угла
     * @param p2 точка противоположного угла, находящаяся на одной диагонали с первой точкой
     * */
    public Rectangle(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    public boolean checkPointInArea(Point p0) {
        boolean xInRange = abs(p0.x()-p1.x()) + abs(p0.x()-p2.x()) == abs(p1.x()-p2.x());
        boolean yInRange = abs(p0.y()-p1.y()) + abs(p0.y()-p2.y()) == abs(p1.y()-p2.y());
        return xInRange && yInRange;
    }
}