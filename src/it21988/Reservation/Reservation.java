package it21988.Reservation;

//import it21988.HouseCompare;

import it21988.House;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.*;
import java.util.TreeSet;
import static it21988.House.housesList;
//import static it21988.HouseCompare.getHouse;

public class Reservation implements Comparable<Reservation>{

    String reservationID;
    String houseID;
    LocalDate startDateBooked;
    LocalDate endDateBooked;
    int taxNumber;
    int cost;

    Scanner input;
    public Reservation(String reservationID,String houseID, int taxNumber, LocalDate startDateBooked, LocalDate endDateBooked) {
        this.houseID = houseID;
        this.startDateBooked = startDateBooked;
        this.endDateBooked = endDateBooked;
        this.taxNumber = taxNumber;
        this.reservationID=reservationID;

    }
    public static TreeSet<Reservation> reservationSet = new TreeSet<>();
    public static LocalDate systemTime= LocalDate.now();


    public int getReservationCost() {
        int houseDailyCost = 0;
        for (House house : housesList){
            if (houseID.equals(house.houseID())){
                houseDailyCost=house.dailyCost();
                break;
            }
        }
        return endDateBooked.compareTo(startDateBooked)*houseDailyCost;
    }

    public String getReservationID(){
        return reservationID;
    }

    public String getHouseID() {
        return houseID;
    }
    public LocalDate getStartDateBooked() {
        return startDateBooked;
    }

    public LocalDate getEndDateBooked() {
        return endDateBooked;
    }

    public int getTaxNumber() {
        return taxNumber;
    }


    @Override
    public int compareTo(@NotNull Reservation o) {
        return o.reservationID.compareTo(reservationID);
    }



}
