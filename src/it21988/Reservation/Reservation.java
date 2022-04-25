package it21988.Reservation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Reservation {
                    //House ID  //0. TaxNumber 1. Start date 2. End date
    public static Map<String, ArrayList<String[]>> reservations = new HashMap<>();
    public static LocalDate systemTime= LocalDate.now();

    public static  void showAvailableHouses(int taxNumber,LocalDate startDate,LocalDate endDate) {
    }

}
