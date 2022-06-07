package data;

import java.util.LinkedList;
import java.util.List;

public enum UnitOfMeasure {
    CENTIMETERS,
    PCS,
    LITERS,
    MILLILITERS,
    MILLIGRAMS;

    public static String nameList() {
        String nameList = "";
        for (UnitOfMeasure measure : values()) {
            nameList += measure.name() + ", ";
        }
        return nameList.substring(0, nameList.length()-2);
    }
    public static List<String> toListString() {
        List<String> list = new LinkedList<>();
        list.add("CENTIMETERS");
        list.add("PCS");
        list.add("LITERS");
        list.add("MILLILITERS");
        list.add("MILLIGRAMS");

        return list;
    }
}
