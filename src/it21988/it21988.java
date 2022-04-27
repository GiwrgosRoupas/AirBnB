package it21988;

import it21988.Reservation.Reservation;
import it21988.User.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import static it21988.House.housesList;
import static it21988.Reservation.Reservation.reservationList;

public class it21988 {

    public static void main(String[] args) {


        new Initialize();
        Scanner input=new Scanner(System.in);


        if(args.length !=0){
            String id="";
            String current;
            int count = 0;
            for (House house :housesList){
                    System.out.println(count +"\t"+house.houseID());
                    count++;
            }

            DateTimeFormatter dtf =DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDate startDate=LocalDate.parse("2022/08/06",dtf);
            LocalDate endDate=LocalDate.parse("2022/08/20",dtf);
            reservationList.add(new Reservation("YO0001", startDate, endDate, 123456789));
            System.out.println(reservationList.get(0).getStartDateBooked());

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
