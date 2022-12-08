package utils.geometry;

public class Triangle extends Figure {
    Point p1;
    Point p2;
    Point p3;

    /**
     * @param p1 координата угла 1
     * @param p2 координата угла 2
     * @param p3 координата угла 3
     * */
    public Triangle(Point p1, Point p2, Point p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    /**
     * Вычисление площади треугольнка производится по формуле Герона.
     * */
    private double calcAreaOfTriangle(Point p1, Point p2, Point p3) {
        double a = calcDistance(p1, p2);
        double b = calcDistance(p2, p3);
        double c = calcDistance(p1, p3);
        double semiPer = (a + b + c) / 2;
        return Math.sqrt(semiPer*(semiPer-a)*(semiPer-b)*(semiPer-c));
    }

    private double calcSelfArea() {
        return calcAreaOfTriangle(this.p1, this.p2, this.p3);
    }

    /**
     * Вычисляет сумму площадей триугольников,
     * у которых две координаты совпадают с координатами основного треуголника
     * и одна координата совпадает с искомой координатой.
     * Найденная сума площадей сравнивается с площадью основного треугольника.
     * Если они равны, то точка находится в нутри области.
     * */
    public boolean checkPointInArea(Point p0) {
        //todo: погрешность
        double area = calcAreaOfTriangle(p0, p2, p3) + calcAreaOfTriangle(p1, p0, p3) + calcAreaOfTriangle(p1, p2, p0);
        return Math.abs(area - calcSelfArea()) < 0.00000001;
    }
}