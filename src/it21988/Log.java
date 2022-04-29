package it21988;

import it21988.Reservation.Reservation;
import it21988.User.User;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

import static it21988.House.housesList;
import static it21988.House.printHouse;
import static it21988.Reservation.Reservation.reservationSet;
import static it21988.it21988.*;

//CHANGE THE PROMPT TO GO BACK WITH 3 NOT X, null string bug
//provide returns
//provide finish, dont go to main userMenuChoice but previous userMenuChoice
//provide clear term
/*CHECK BEFORE CODING*/
//if they choose ownerEnter and no owner found ask if they want to register
//if they choose renterEnter and no owner found ask if they want to register with return to home
//if no house/reservation found provide appropriate message
public class Log {
    Scanner input;
    private final int taxNumber;
    Log(Scanner input){
        this.input = input;
        taxNumber= User.inputTaxNumber();
        char choice='0';
        do {
            choice= userMenuChoice(1 ); /*Log Menu*/
            if(choice=='1'){
                do {
                    choice = userMenuChoice(2);  /*Owner Menu*/
                    if (choice == '1')
                        ownerShowHouses();
                    else if (choice == '2')
                        ownerShowRentedTime();
                }while (choice!='X');
            }else if (choice=='2'){                         /*Renter Menu*/
                renterShowReservations();
            }
        }while (choice!='X');

    }




    private char userMenuChoice(int menuNum) {  //1-Log Menu    //2-Owner Menu  //3-Renter Menu

        String choice =" ";
        char choiceChar='q';
        boolean correct = false;

        do {
            menuPrompt(menuNum);
            if (choice.length() == 1) {
                choiceChar = input.nextLine().trim().toUpperCase().charAt(0);
                correct = choiceChar == '1' || choiceChar == '2' || choiceChar == 'X';
            } else {
                System.out.println("Too many characters!");
            }
        } while (!correct);
        return choiceChar;
    }

    private void menuPrompt(int menuNum){
        switch(menuNum) {
            case 1 ->System.out.println("""
                       Press:
                           1. To enter as Owner
                           2. To enter as Renter
                           X. Previous Menu
                       """);
            case 2 ->System.out.println("""
                       Select:
                           1. Your houses
                           2. See rented time for a house
                           X. Previous Menu
                       """);
        }
    }

    private void ownerShowHouses(){
        int counter=0;
        for (House house : housesList){
            if (house.taxNumber()==taxNumber) {
                House.printHouse(house);
                counter++;
            }
        }
        if (counter==0) {System.out.println("No houses found.");}
    }

    private void ownerShowRentedTime(){


        //        String answer;
//        do {
//        System.out.println("Type a house ID or press enter to see all houses.");
//        System.out.print("House ID: #");
//        answer=input.nextLine();
//        if(answer.toUpperCase().trim().matches("[[A-Z]{2}[0-9]{4}")){
//
//        }
        }

    private void renterShowReservations(){
        int totalCost = 0;
        for (Reservation reservation : reservationSet){
            if (reservation.getTaxNumber()==taxNumber){
                System.out.println(ANSI_BLUE+"House ID: #"+ANSI_RESET+
                        reservation.getHouseID() +
                        ANSI_GREEN+"\tDates: "+reservation.getStartDateBooked()+ANSI_RESET+
                        " - "+reservation.getEndDateBooked()+
                        ANSI_RED+"\tCost: "+ ANSI_RESET+ reservation.getReservationCost());
                totalCost+= reservation.getReservationCost();
            }
        }
        System.out.println("Total cost: "+ totalCost+"\u20ac");

    }


    //    Log(){
//        final int taxNumber=User.inputTaxNumber();
//        if(enterAsOwner()){
//            char userMenuChoice;
//            do {
//                ownerMenu();
//            }while ((userMenuChoice = ownerMenuChoice().charAt(0)) != 'X');
//        }else
//            renterMenu();
//    }
//
//    private char enterAsOwner(){
//
//        String inputString;
//        char answer= ' ';
//        do {
//            System.out.println("To enter as owner press O, to enter as renter press R!");
//            inputString = input.nextLine();
//            if (inputString.length() == 1) {
//                answer = inputString.toUpperCase().charAt(0);
//                switch (answer) {
//                    case 'O' -> asOwner=true;
//                    case 'R' -> return answer;
//                    case 'X' -> return answer;
//                    default -> System.out.println("Wrong character!");
//                }
//            }
//            else
//                System.out.println("Too many arguments!");
//        } while (!(answer=='O' || answer=='R'));
//        return asOwner;
//    }
//
//    private String ownerMenuChoice(){
//        String string;
//        do{
//            System.out.println("""
//                    Press:
//                        1. To see all your houses
//                        2. See rented time for a house
//                        X. Previous Menu
//                    """);
//            string=input.nextLine().trim().toUpperCase();
//        }while(!string.matches("[12X]"));
//        return string;
//    }
//
//    private void ownerMenu(){
//        char userMenuChoice =ownerMenuChoice().charAt(0);
//
//    }
//
//    private void renterMenu(){}

}


