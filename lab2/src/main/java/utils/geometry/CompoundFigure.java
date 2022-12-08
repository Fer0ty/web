package utils.geometry;

import java.util.Arrays;
import java.util.List;

public class CompoundFigure extends Figure {
    final private List<Figure> figures;

    public CompoundFigure(Figure ...figures) {
        this.figures = Arrays.asList(figures);
    }

    public boolean checkPointInArea(Point p0) {
        boolean inArea = false;
        for (Figure figure : figures) {
            inArea = inArea || figure.checkPointInArea(p0);
        }
        return inArea;
    }
}