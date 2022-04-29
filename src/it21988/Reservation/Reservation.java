package it21988.Reservation;

//import it21988.HouseCompare;

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

    public int setReservationID(String houseID){
        int counter=0;
        String id=houseID.substring(0,2);
        for (Reservation reservation : reservationSet){
            if(reservation.getReservationID().substring(0,2).equals(id)){
                counter++;
            }

        }

        return 0;
    }

    public int getReservationCost(String houseID) {

        return 0;
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
