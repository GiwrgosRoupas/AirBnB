package it21988;

import java.util.ArrayList;
import java.util.List;

public record House(String municipality,
                    String houseID,
                    int taxNumber,
                    String address,
                    byte roomsNumber,
                    byte pplNumber,
                    float comfortLevel,
                    String hasInternet,
                    String hasTV,
                    String hasKitchen,
                    String hasParking,
                    String view,
                    float distanceFromMetro,
                    float dailyCost,
                    float garden,
                    float pool,
                    String hasBBQ,
                    byte floor,
                    String hasElevator,
                    String hasBalcony) {

    public static List<House> housesList = new ArrayList<>();
}
