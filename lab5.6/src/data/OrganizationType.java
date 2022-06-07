package data;

import java.util.LinkedList;
import java.util.List;

public enum OrganizationType {
    COMMERCIAL,
    TRUST,
    OPEN_JOINT_STOCK_COMPANY;

    /**
     * Создает великолепно чудесный список значений перечисления в стрингах
     */
    public static String nameList() {
        String nameList = "";
        for (OrganizationType organized : values()) {
            nameList += organized.name() + ", ";
        }
        return nameList.substring(0, nameList.length()-2);
    }
    public static List<String> toListString() {
        List<String> list = new LinkedList<String>();
        list.add("COMMERCIAL");
        list.add("TRUST");
        list.add("OPEN_JOINT_STOCK_COMPANY");

        return list;
    }
}
