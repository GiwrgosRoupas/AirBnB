package it21988;

import it21988.Reservation.Reservation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static it21988.House.housesList;
import static it21988.Reservation.Reservation.reservationSet;
import static it21988.User.Owner.housesOwned;
import static it21988.User.User.usersMap;

public class it21988 {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String[] colours={"\u001B[0m","\u001B[30m","\u001B[31m","\u001B[32m","\u001B[33m","\u001B[34m","\u001B[35m","\u001B[36m","\u001B[37m"};

    public static void main(String[] args) throws IOException {


        new Initialize();
        Scanner input=new Scanner(System.in);
        BufferedWriter houseIDFile = new BufferedWriter(new FileWriter("houseIDs.txt"));
        for (House house: housesList){
            houseIDFile.write(house.houseID()+"\n");

        }
        houseIDFile.close();

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
        for (Integer key: housesOwned.keySet()) {
            housesOwned.get(key).get(0);
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
