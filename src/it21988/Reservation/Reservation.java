package it21988.Reservation;



import it21988.House.HouseCompare;
import org.jetbrains.annotations.NotNull;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import static it21988.House.House.housesList;
import static it21988.House.HouseCompare.getHouse;
import static it21988.User.Renter.housesRented;


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
    public static SortedSet<Reservation> reservationSet = new TreeSet<>();
    public long getReservationCost() {
        int houseDailyCost = 0;
        int index = Collections.binarySearch(housesList, getHouse(houseID), new HouseCompare());
        houseDailyCost=housesList.get(index).dailyCost();

        return startDateBooked.until(endDateBooked, ChronoUnit.DAYS)*houseDailyCost;
    }

    public static void replaceReservation(Reservation reservationToEdit, LocalDate[]  newDates){
        Reservation reservationToAdd = new Reservation(reservationToEdit.reservationID, reservationToEdit.houseID, reservationToEdit.taxNumber, newDates[0], newDates[1]);

        reservationSet.remove(reservationToEdit);

        reservationSet.add(reservationToAdd);


        ArrayList<Reservation> temp = null;
        boolean found = false;
        int taxNumber=0;
        for (Integer key : housesRented.keySet()){
            for (Reservation reservation: housesRented.get(key)){
                if (reservation.getReservationID().equals(reservationToEdit.reservationID)){
                    temp=housesRented.get(key);
                    found= true;
                    taxNumber=key;
                    break;
                }
            }
            if (found)
                break;

        }
        temp.remove(reservationToEdit);
        temp.add(new Reservation(reservationToEdit.reservationID, reservationToEdit.houseID, reservationToEdit.taxNumber, newDates[0], newDates[1]));
        housesRented.put(taxNumber, temp);



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
