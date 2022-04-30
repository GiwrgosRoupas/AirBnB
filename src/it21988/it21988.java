package it21988;

import it21988.Reservation.Reservation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static it21988.Reservation.Reservation.reservationSet;
import static it21988.User.Renter.housesRented;

public class it21988 {
    public static final String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";// BLACK
    public static final String RED_BACKGROUND_BRIGHT = "\033[0;101m";// RED
    public static final String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";// GREEN
    public static final String YELLOW_BACKGROUND_BRIGHT = "\033[0;103m";// YELLOW
    public static final String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";// BLUE
    public static final String PURPLE_BACKGROUND_BRIGHT = "\033[0;105m"; // PURPLE
    public static final String CYAN_BACKGROUND_BRIGHT = "\033[0;106m";  // CYAN
    public static final String WHITE_BACKGROUND_BRIGHT = "\033[0;107m";   // WHITE
    public static final String[] colours={"\u001B[0m","\u001B[30m","\u001B[31m","\u001B[32m","\u001B[33m","\u001B[34m","\u001B[35m","\u001B[36m","\u001B[37m"};

    public static void main(String[] args) {


        new Initialize();
        Scanner input=new Scanner(System.in);

        if(args.length !=0){
//


            // CHECK IF ALL RESERVATIONS ARE CORRECT DATE-WISE PER HOUSE
            for (Reservation res :reservationSet){
                for (Reservation reservation :reservationSet){
                    if(res.getStartDateBooked().isAfter(reservation.getStartDateBooked())&& res.getEndDateBooked().isBefore(reservation.getEndDateBooked())) {
                        if(res.getHouseID().equals(reservation.getHouseID())) {
                            System.out.println("WTF homie");
                        }
                    }
                }
            }
        }


        System.out.println("""
        ######################
        # Welcome to JavaBnB #
        ######################
        """);

        new Menu(input);

        input.close();
    }
}
