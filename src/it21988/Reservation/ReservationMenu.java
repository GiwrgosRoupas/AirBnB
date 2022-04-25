package it21988.Reservation;

import java.time.LocalDate;
import java.util.Scanner;

public class ReservationMenu {

    Scanner input;
    public ReservationMenu(Scanner input){
        this.input=input;

        // Reservation.showAvailableHouses();
    }





    private void inputMakeReservationOrNot() {
        Byte choice = 0;
        do{
            System.out.println("""
                Press:
                1. Make reservation
                2. Previous Menu
                """);
        try {
            choice = Byte.parseByte(input.nextLine().trim());
            if (choice == 1){
                makeReservation();
                break;
            }
        } catch (NumberFormatException nfe) {}
        finally{
            System.out.println("Wrong input.");
        }
        }while (true);
    }

    private void inputCriteria(){
        System.out.println("Start date");
        LocalDate startDate;
        LocalDate endDate;
    }


    private void makeReservation() {};
}
