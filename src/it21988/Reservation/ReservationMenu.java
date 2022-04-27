package it21988.Reservation;

import it21988.House;
import it21988.InsertHouse;

import java.awt.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

import static it21988.House.housesList;
import static it21988.House.printHouse;
import static it21988.Reservation.Reservation.reservationList;

public class ReservationMenu {

    Scanner input;
    ArrayList<String> housesNotAvailable;
    public ReservationMenu(Scanner input){
        this.input=input;
        housesNotAvailable= new ArrayList<>();
        int choice=0;
        //inputMakeReservationOrNot();
        LocalDate[] dates=setDate();
        //byte pplNumber=inputPplNumber();
        //String municipality=inputMunicipality();
        getNotAvailableHousesByDate(dates[0],dates[1]);
        getNotAvailableHousesByPeopleNumber(inputPplNumber(),inputWantsToSeeBigger());
        getNotAvailableHousesByMunicipality(inputMunicipality());
        showAvailableHouses();
        // Reservation.showAvailableHouses();
    }




    private LocalDate[] setDate(){
        ArrayList<String> housesNotAvailable = new ArrayList<>();
        LocalDate systemTime= LocalDate.now();
        LocalDate startDate =null;
        LocalDate endDate =null;
        String inputStartDate= null;
        String inputEndDate=null;
        boolean correct=false;
        do {
            correct=true;
            System.out.print("Provide the dates,\nStart: ");
            try {
                inputStartDate=input.nextLine();
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                startDate= LocalDate.parse(inputStartDate, dtf);
                if (startDate.isEqual(systemTime) || startDate.isBefore(systemTime))
                    throw new IllegalStateException();
                System.out.print("End: ");

                inputEndDate=input.nextLine();
                endDate= LocalDate.parse(inputEndDate, dtf);
                if (endDate.isEqual(systemTime) || endDate.isBefore(systemTime))
                    throw new IllegalStateException();

            }catch (DateTimeParseException e) {
                System.out.println("Date format must be DD/MM/YYYY");
                correct=false;
            }catch (IllegalStateException e) {
                System.out.println("Starting date must be at least one day after current date!");
                correct=false;
            }
        }while (!correct);

        return new LocalDate[]{startDate, endDate};
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
            }
        } catch (NumberFormatException nfe) {System.out.println("Wrong input.");}

        }while (choice==1);
    }

    private void showAvailableHouses(){
        for (House house : housesList){
            if (!housesNotAvailable.contains(house.houseID())){
                System.out.println("House ID: #" + house.houseID()+"\nDaily cost: "+house.dailyCost()+"\\u20ac\n");
            }
        }
    }

    /*
    * Checks for every house if it not available at specified date,
    * if it's not available puts it in the list.
    * */

    private void getNotAvailableHousesByDate(LocalDate startDate,LocalDate endDate) {

        for (Reservation reservation : reservationList){
            if (startDate.isBefore(reservation.getStartDateBooked()) && endDate.isBefore(reservation.getStartDateBooked()) || (startDate.isAfter(reservation.getEndDateBooked()) && endDate.isAfter(reservation.getEndDateBooked())) ){
                housesNotAvailable.remove(reservation.getHouseID());
            }else{
                housesNotAvailable.add(reservation.getHouseID()); //housesNotAvailable maybe TreeSet or Set or Map
            }
        }
    }

    private void getNotAvailableHousesByPeopleNumber(byte pplNumber, boolean wantsToSeeBigger){ // add functionality to see also houses with more ppl
        if (wantsToSeeBigger){
            for (House house :housesList){
                if (house.pplNumber()<pplNumber-1 || house.pplNumber()>pplNumber+1){
                    housesNotAvailable.add(house.houseID());
                }
            }
        }else {
            for (House house : housesList) {
                if (house.pplNumber() != pplNumber) {
                    housesNotAvailable.add(house.houseID());
                }
            }
        }
    }

    private void getNotAvailableHousesByMunicipality(String municipality){
        for (House house : housesList){
            if (!house.municipality().equals(municipality)){
                housesNotAvailable.add(house.houseID());
            }
        }
    }


    private void makeReservation() {};


    public  byte inputPplNumber() {
        byte num = 0;
        boolean correct = false;
        do {
            try {
                do {
                    System.out.print("Number of people: ");
                    correct = (num = Byte.parseByte(input.nextLine())) > 0;
                    if (correct) break;
                    System.out.println("Provide positive whole number!");
                } while (!correct);
            } catch (NumberFormatException nfe) {
                System.out.println("You didnt provide a number or too big number (max. 127).");
            }
        } while (!correct);

        return num;
    }

    private String inputMunicipality() {
        System.out.print("Municipality: ");
        String municipality;

        while (!(municipality = input.nextLine()).trim().matches("[A-Z][A-Za-z '.]{2,50}")) {
            System.out.println("Municipality must be 2-50 letters, can also contain special characters .' .");
            System.out.print("Municipality: ");
        }
        return municipality;
    }

    private boolean inputWantsToSeeBigger() {
        String answer;
        do {
            System.out.println("Include houses bigger/ smaller by 1 person?");
        }while(!(answer=input.nextLine().trim().toUpperCase()).matches("[YN]"));

        return answer.equals("Y") ? true : false;
    }
}
