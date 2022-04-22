package it21988;

import lombok.Data;

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

    public void printHouse(House house){            //comf  cost                   dfm
        System.out.printf("House ID | Municipality | Adress | Rooms | People | Comfort | Internet | TV | Kitchen | Parking | View | Nearest Metro | Cost | Garden | Pool | BBQ | Floor | Elevator | Balcony");
        System.out.printf("#-8%s | %-20s | %-20s | %-3d | %-3d | %-3f | %-4s | %-4s | %-4s | %-4s | %-6s | %-4f | %-4f | %-3f | %-3f | %-4s | %-3f| %-4s | %-4s"
                        ,
                house.houseID, house.municipality, house.address, house.roomsNumber, house.pplNumber,
                house.comfortLevel, house.dailyCost, house.hasInternet, house.hasTV, house.hasKitchen, house.hasParking,
        house.view, house.distanceFromMetro, house.garden, house.pool, house.hasBBQ, house.floor, house.hasElevator, house.hasBalcony);
    }
}
