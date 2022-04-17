package com.giwrgosroupas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static java.lang.String.valueOf;

public class House {
    Scanner input = new Scanner(System.in);
    private ArrayList<String> houseInfo = new ArrayList<>();
    private static HashMap<Integer, ArrayList<ArrayList<String>>> housesOwned = new HashMap<>();

    //0-Municipality
    //1-House ID
    //2-TaxNumber
    //3-Adress
    //4-Rooms       int =
    //5-Ppl number      int >
    //6-Comfort
    //7-Internet    boolean
    //8-TV      boolean
    //9-Kitchen     boolean
    //10-Parking    boolean
    //11-View
    //12-Distance from metro    float >
    //13-Daily cost     float >
    //14-Garden     float =
    //15-Pool   float =
    //16-BBQ    boolean
    //17-floor  int =
    //18-Elevator   boolean
    //19-Balcony    boolean
    private String taxNumber;
    private int roomsNumber;
    private int peopleCanAccomodate;


    House(int taxNumber) {
        setMunicipality();
        setHouseID();
        this.taxNumber= valueOf(taxNumber);
        houseInfo.add(2, valueOf(taxNumber));
        setAddress();
        System.out.println("Number of rooms:");
        roomsNumber=setIntegers(4);
        System.out.println("People that can be accommodated:");
        peopleCanAccomodate=setIntegers(5);
        float levelOfComfort=(float) peopleCanAccomodate/roomsNumber;
        houseInfo.add(6, String.valueOf(levelOfComfort));
        System.out.println("Is Internet included? :");
        setBooleans(7);
        System.out.println("Is a TV included? :");
        setBooleans(8);
        System.out.println("Is a kitchen included? :");
        setBooleans(9);
        System.out.println("Is parking spot included? :");
        setBooleans(10);
        setView();
        System.out.println("Distance from nearest metro station:");
        setFloats(12);
        System.out.println("Daily cost:");
        setFloats(13);
        apartmentOrNotInput();
        System.out.println(houseInfo.toString());



    }

    private void setMunicipality() {
        String municipality="";
        System.out.println("Municipality: ");
        while (!(municipality = input.nextLine()).matches("[A-Za-z '.]{2,50}"))
            System.out.println("Municipality must be 2-50 letters, can also contain special characters .' .");
        houseInfo.add(0, municipality);
    }

    private void setHouseID() {
        String municipality = houseInfo.get(0).toUpperCase();
        String id = municipality.charAt(0) + "" + municipality.charAt(1) ;
        System.out.println("How many houses have you already inserted in the app?");
        String numberOfHouses;
        while (!(numberOfHouses = input.nextLine()).matches("([1-9][0-9]{0,2})|[0]")) {
            System.out.println("Provide a number 0-999!");
        }
        byte numberOfHousesByte = (byte) (Byte.parseByte(numberOfHouses) + 1);
        if (numberOfHouses.length() == 1)
            id = id + "000" + valueOf(numberOfHousesByte);
        else if (numberOfHouses.length() == 2)
            id = id + "00" + valueOf(numberOfHousesByte);
        else if (numberOfHouses.length() == 3)
            id = id + "0" + valueOf(numberOfHousesByte);

        houseInfo.add(1, id);
    }

    private void setAddress(){  //Address can have more than 1 word, also number like 1-3
        String address="";
        System.out.println("Address:");
        while(!(address=input.nextLine().trim()).matches("[A-Za-z]{2,30}[ ][0-9]{1,3}"))
            System.out.println("Address must be of format {Letters Number} (2-30 letters,1-3 numbers)");
        houseInfo.add(3,address);
    }



    private int setIntegers(int choice) {
        String num;
        while (!(num = input.nextLine().trim()).matches("[0-9]{1,}"))
            System.out.println("Provide a number!");
        houseInfo.add(choice, num);
    return Integer.parseInt(num);
}


    private void setBooleans(int choice){
        String bool;
        String menu="Type Y for yes and N for no!";
        while(!(bool=input.nextLine().trim().toUpperCase()).matches("[YN]"))
            System.out.println(menu);
        houseInfo.add(choice,bool);
    }

    private void setView(){
        String view="";
        String menu=("""
                Provide apartment view,select:
                    1. Road
                    2. Sea
                    3. Mountain
                    """);
        System.out.println(menu);
        while(!(view=input.nextLine().trim()).matches("[123]"))
            System.out.println(menu);

        houseInfo.add(11, view);
    }

    private void setFloats(int choice){   //maybe can be done with generics
        float num=0;
        boolean correct =false;
        do {
            try {
                do{
                    switch(choice) {
                        case 12,13:
                            correct= (num = Float.parseFloat(input.nextLine())) > 0;
                            if (correct) break;
                            System.out.println("Provide positive number!");
                            break;
                        case 14,15:
                            correct= (num = Float.parseFloat(input.nextLine())) >= 0;
                            if (correct) break;
                            System.out.println("Provide a number greater or equal than zero!");
                            break;
                    }
                    if (correct) break;
                }while(true);
            } catch (NumberFormatException nfe) {
                System.out.println("You didnt provide a number");
            }
            if(correct) break;
        }while(true);

        houseInfo.add(choice,String.valueOf(num));
    }

    private void apartmentOrNotInput(){
        System.out.println("Is the house an apartment?\nPress Y for yes, N for no!");
        String answer;
        while(!(answer = input.nextLine().trim().toUpperCase()).matches("[YN]"))
            System.out.println("Press Y for yes, N for no!");
        if (answer.equals("N")){
            System.out.println("Garden size in square meters (enter 0 if not included):");
            setFloats(14);
            System.out.println("Pool size in square meters (enter 0 if not included):");
            setFloats(15);
            System.out.println("Is BBQ included:");
            setBooleans(16);
        }else{
            System.out.println("Floor:");
            setIntegers(17);
            System.out.println("Is elevator included?");
            setBooleans(18);
            System.out.println("Is balcony included");
            setBooleans(19);

        }
    }
}

