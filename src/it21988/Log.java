package it21988;

import it21988.House.House;
import it21988.Reservation.Reservation;
import it21988.User.User;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Scanner;

import static it21988.House.House.printHouse;
import static it21988.Reservation.Reservation.reservationSet;
import static it21988.User.Owner.housesOwned;
import static it21988.User.Renter.housesRented;


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

        if (housesOwned.get(taxNumber).isEmpty()) {
            System.out.println("No houses found.");
        }else {
            ArrayList<House> temp = housesOwned.get(taxNumber);
            for (House house : temp) {
                printHouse(house);
            }
        }
    }

    private void ownerShowRentedTime() {
        System.out.print("Enter house ID: ");
        String houseId;
        long totalRentedTime=0;
        while(!(houseId=input.nextLine()).matches("[A-Z]{2}[0-9]{4}")){
            System.out.println("House ID must be of format LLNNNN (L= letter, N= number) and exist.");
        }
        for (Reservation reservation :reservationSet){
            if (reservation.getHouseID().equals(houseId)){
                totalRentedTime+= reservation.getStartDateBooked().until(reservation.getEndDateBooked(), ChronoUnit.DAYS);
            }
        }
        System.out.println("Total rented time for #"+houseId+" is "+ totalRentedTime+" days");
    }

    private void renterShowReservations(){
        int totalCost = 0;
        if(!housesRented.containsKey(taxNumber)){
            System.out.println("No reservations found.");
        }else if (housesRented.get(taxNumber).isEmpty()){
            System.out.println("No reservations found.");
        }else{
            ArrayList<Reservation> temp = housesRented.get(taxNumber);
            for(Reservation reservation : temp){
                System.out.println("Reservation ID: #"+
                        reservation.getReservationID()
                        +"\tDates: "+reservation.getStartDateBooked()+
                        " - "+reservation.getEndDateBooked()
                        +"\tCost: "+ + reservation.getReservationCost()+"\033[0m");
                totalCost+= reservation.getReservationCost();
            }
            System.out.println("Total cost: "+ totalCost+"\u20ac");
        }
    }
}


