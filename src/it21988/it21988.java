package it21988;

import it21988.Reservation.Reservation;
import it21988.User.User;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static it21988.Reservation.Reservation.reservationSet;
import static it21988.User.Renter.housesRented;
import static it21988.User.User.usersMap;

public class it21988 {


    public static void main(String[] args)  {


        new Initialize();
        Scanner input=new Scanner(System.in);


        System.out.println("""
        ######################
        # Welcome to JavaBnB #
        ######################
        """);

        new Menu(input);

        input.close();
    }
}
