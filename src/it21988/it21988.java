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
    public static final String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";// BLACK
    public static final String RED_BACKGROUND_BRIGHT = "\033[0;101m";// RED
    public static final String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";// GREEN
    public static final String YELLOW_BACKGROUND_BRIGHT = "\033[0;103m";// YELLOW
    public static final String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";// BLUE
    public static final String PURPLE_BACKGROUND_BRIGHT = "\033[0;105m"; // PURPLE
    public static final String CYAN_BACKGROUND_BRIGHT = "\033[0;106m";  // CYAN
    public static final String WHITE_BACKGROUND_BRIGHT = "\033[0;107m";   // WHITE
    public static final String[] colours={"\u001B[0m","\u001B[30m","\u001B[31m","\u001B[32m","\u001B[33m","\u001B[34m","\u001B[35m","\u001B[36m","\u001B[37m"};

    public static void main(String[] args) throws IOException {


        new Initialize();
        Scanner input=new Scanner(System.in);
        BufferedWriter writer=new BufferedWriter(new FileWriter("renterNames.txt"));
        for (Integer key : usersMap.keySet()){
            if (usersMap.get(key)[0].equals(" null")){
                writer.write(key+"\n");
                System.out.println(key);
            }
        }
        writer.close();

        System.out.println("""
        ######################
        # Welcome to JavaBnB #
        ######################
        """);

        new Menu(input);

        input.close();
    }
}
