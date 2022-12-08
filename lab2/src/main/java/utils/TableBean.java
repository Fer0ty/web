package utils;

import java.util.ArrayList;
import java.util.List;

public class TableBean {
    final List<TableRow> list;

    public TableBean() {
        list = new ArrayList<>();
    }

    public void add(TableRow added_item) {
        list.add(added_item);
    }

    public void clear() {
        list.clear();
    }

    public String getPointsAsText() {
        StringBuilder pointData = new StringBuilder();
        for (TableRow tr : list) {
            pointData.append(tr.getX()).append(" ").append(tr.getY()).append(" ").append(tr.getR()).append(" ");
        }
        return pointData.toString().trim();
    }

    public List<TableRow> asList() {
        return list;
    }
}
