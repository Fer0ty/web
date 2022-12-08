package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TableRow {
    final private double coordX;
    final private double coordY;
    final private double radius;
    final private Status status;
    final private Date time;

    public TableRow(double x, double y, double r, boolean isHit) {
        coordX = x;
        coordY = y;
        radius = r;
        status = isHit ? Status.HIT : Status.FAIL;
        time = new Date();
    }

    public double getX() {
        return coordX;
    }

    public double getY() {
        return coordY;
    }

    public double getR() {
        return radius;
    }

    public Status getStatus() {
        return status;
    }

    public String getTime() {
        DateFormat df = new SimpleDateFormat("dd.MM.yy HH:mm:ss");
        return df.format(time);
    }

    public enum Status {
        HIT,
        FAIL
    }
}