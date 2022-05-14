package it21988.House;



import java.util.ArrayList;
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

    public static void printHouse( House house){
        if (house.floor==-5){
            String type="Dedicated";
            System.out.printf("House ID | Municipality   | Adress                | Rooms | People | Comfort | Daily Cost | Internet | TV    | Kitchen | Parking | View     | Nearest Metro  | Garden | Pool | BBQ   | Type%n");
            System.out.printf("#%s  | %-14s | %-21s | %-5d | %-6d | %-7.2f | %-10d\u20ac | %-8s | %-3s   | %-7s | %-7s | %-8s | %-14d | %-6d | %-3d  | %-5s | %s%n",
                    house.houseID, house.municipality, house.address, house.roomsNumber, house.pplNumber,
                    house.comfortLevel, house.dailyCost, house.hasInternet, house.hasTV, house.hasKitchen, house.hasParking,
                    house.view, house.distanceFromMetro, house.garden, house.pool, house.hasBBQ, type);
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        }else {
            String type="Apartment";
            System.out.printf("House ID | Municipality   | Adress                | Rooms | People | Comfort | Daily Cost | Internet | TV    | Kitchen | Parking | View     | Nearest Metro  | Floor  | Elevator | Balcony | Type%n");
            System.out.printf("#%s  | %-14s | %-21s | %-5d | %-6d | %-7.2f | %-10d\u20ac | %-8s | %-3s   | %-7s | %-7s | %-8s | %-14d | %-6d | %-7s  | %-7s | %s%n",
                    house.houseID, house.municipality, house.address, house.roomsNumber, house.pplNumber,
                    house.comfortLevel, house.dailyCost, house.hasInternet, house.hasTV, house.hasKitchen, house.hasParking,
                    house.view, house.distanceFromMetro, house.floor, house.hasElevator, house.hasBalcony, type);
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }
    }
}

