package it21988;

import it21988.User.User;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import static it21988.House.housesList;

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
