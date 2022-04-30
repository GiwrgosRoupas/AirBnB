package it21988.House;

import it21988.House.House;

import java.util.Comparator;

public class HouseCompare implements Comparator<House> {
    public int compare(House h1, House h2) {
        return h1.houseID().compareTo(h2.houseID());
    }

    public static House getHouse(String id) {
        return new House("", id, 0, "", (byte) 0, (byte) 0, 0, "", "", "", "", "",
                0, 0, 0, 0, "", (byte) 0, "", "");
    }
}
