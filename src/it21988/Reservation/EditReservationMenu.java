package it21988.Reservation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Scanner;

import static it21988.Reservation.MakeReservationMenu.setDate;
import static it21988.Reservation.Reservation.replaceReservation;
import static it21988.Reservation.Reservation.reservationSet;

public class EditReservationMenu {

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy").withResolverStyle(ResolverStyle.LENIENT);

    Scanner input;
    Reservation reservationToEdit;
    public EditReservationMenu(Scanner input){
        this.input = input;
        inputReservationID();
        inputChangeOrCancelReservation();
    }
    public void inputReservationID(){
        String reservationID=null;
        boolean correct=false;
        do {
            System.out.print("Reservation ID: ");
            reservationID= input.nextLine().trim();
            for (Reservation reservation : reservationSet) {
                if (reservation.getReservationID().equals(reservationID)){
                    reservationToEdit=reservation;
                    correct = true;
                    break;
                }
            }
            if(!correct)
                System.out.println("Reservation ID must be of format LLYYYYNNNNN (L= letter, YYYY= year of first day, N= number)");
        }while (!correct);

    }

    private void inputChangeOrCancelReservation() {

        String choice;
        do {
            System.out.println("""
                Press:
                    1. To edit a reservation date
                    2. To cancel a reservation
                    """);
            choice = input.nextLine().trim().toUpperCase();
        } while (!choice.matches("[12]"));
        switch (choice.charAt(0)) {
            case '1' -> editReservation();
            case '2' -> cancelReservation();
        }
    }

    private void editReservation(){
        System.out.println("Current reservation, start date: "+ dtf.format(reservationToEdit.startDateBooked)+"  ,end date: "+ dtf.format(reservationToEdit.endDateBooked)+" .");
        boolean datesAreAvailable = false;
        LocalDate[] newDates;
        String choice="N";
        do {
            newDates= setDate(input);
            datesAreAvailable = checkReservationDatesAreAvailable(reservationToEdit, newDates);
            if (!datesAreAvailable) {
                System.out.println("Dates not available, try again?");
                choice = input.nextLine().trim().toUpperCase();
            }

        }while (choice.charAt(0)=='Y');
        if (datesAreAvailable)
            replaceReservation(reservationToEdit,newDates);
    }

    private boolean checkReservationDatesAreAvailable(Reservation reservationToEdit,LocalDate[] newDates) {
        boolean datesAreAvailable=false;
        for (Reservation reservation : reservationSet){
            if (reservation.getHouseID().equals(reservationToEdit.getHouseID()) && reservation!=reservationToEdit){
                if (newDates[0].isBefore(reservation.getStartDateBooked()) && newDates[1].isBefore(reservation.getStartDateBooked())
                        || (newDates[0].isAfter(reservation.getEndDateBooked()) && newDates[1].isAfter(reservation.getEndDateBooked())) ){
                    System.out.println("To ekane true");
                    datesAreAvailable=true;
                }else {
                    System.out.println("To ekane false");
                    datesAreAvailable=false;
                    return false;
                }
            }
        }

        return datesAreAvailable;
    }
    private void cancelReservation(){

    }

}
