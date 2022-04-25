package it21988;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;



public record House (String municipality,
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
                    int distanceFromMetro,
                    int dailyCost,
                    int garden,       //if garden=-5 means house is apartment
                    int pool,
                    String hasBBQ,
                    byte floor,     //if floor=-5 means house is dedicated
                    String hasElevator,
                    String hasBalcony) {

    public static List<House> housesList = new ArrayList<>();

    public static void printHouse(@NotNull House house){
        if (house.floor==-5){
            String type="Dedicated";
            System.out.printf("House ID | Municipality   | Adress                | Rooms | People | Comfort | Daily Cost | Internet | TV    | Kitchen | Parking | View     | Nearest Metro  | Garden | Pool | BBQ   | Type%n");
            System.out.printf("#%s  | %-14s | %-21s | %-5d | %-6d | %-7.2f | %-10d | %-8s | %-3s   | %-7s | %-7s | %-8s | %-14d | %-6d | %-3d  | %-5s | %s%n",
                    house.houseID, house.municipality, house.address, house.roomsNumber, house.pplNumber,
                    house.comfortLevel, house.dailyCost, house.hasInternet, house.hasTV, house.hasKitchen, house.hasParking,
                    house.view, house.distanceFromMetro, house.garden, house.pool, house.hasBBQ, type);
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        }else {
            String type="Apartment";
            System.out.printf("House ID | Municipality   | Adress                | Rooms | People | Comfort | Daily Cost | Internet | TV    | Kitchen | Parking | View     | Nearest Metro  | Floor  | Elevator | Balcony | Type%n");
            System.out.printf("#%s  | %-14s | %-21s | %-5d | %-6d | %-7.2f | %-10d | %-8s | %-3s   | %-7s | %-7s | %-8s | %-14d | %-6d | %-7s  | %-7s | %s%n",
                    house.houseID, house.municipality, house.address, house.roomsNumber, house.pplNumber,
                    house.comfortLevel, house.dailyCost, house.hasInternet, house.hasTV, house.hasKitchen, house.hasParking,
                    house.view, house.distanceFromMetro, house.floor, house.hasElevator, house.hasBalcony, type);
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }
    }

}

class HouseCompare implements Comparator<House>{
    public int compare(House h1, House h2) {
        return h1.houseID().equals(h2.houseID())?0:-1;
    }
    public static House getHouse(String id){
        return new House("", id, 0,"", (byte) 0, (byte) 0, 0,"","","","", "",
                0, 0, 0, 0, "", (byte) 0, "", "");
    }

}
