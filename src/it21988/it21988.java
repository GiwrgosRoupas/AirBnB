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
