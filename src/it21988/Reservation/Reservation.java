package it21988.Reservation;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Reservation {


    String houseID;
    LocalDate startDateBooked;
    LocalDate endDateBooked;
    int taxNumber;

    Scanner input;
    public Reservation(String houseID, LocalDate startDateBooked, LocalDate endDateBooked, int taxNumber) {
        this.houseID = houseID;
        this.startDateBooked = startDateBooked;
        this.endDateBooked = endDateBooked;
        this.taxNumber = taxNumber;

    }
    public static List<Reservation> reservationList = new ArrayList<Reservation>();
    public static LocalDate systemTime= LocalDate.now();

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





}
