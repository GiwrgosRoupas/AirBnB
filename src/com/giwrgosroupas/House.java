package com.giwrgosroupas;

import java.util.*;

import static java.lang.String.valueOf;

public class House {
    Scanner input = new Scanner(System.in);
    public  String[] houseInfo = new String[21];
    public static ArrayList<String[]> housesList= new ArrayList<>();       //contains houses housesList<houseInfo[]>
    private static HashMap<Integer, ArrayList<String[]>> housesOwned = new HashMap<>(); //contains list of house, key is taxNumber
    //houseInfo
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
    //14-IsApartment    "Dedicated House"-"Apartment"
    //15-Garden     float =
    //16-Pool   float =
    //17-BBQ    boolean
    //18-floor  int =
    //19-Elevator   boolean
    //20-Balcony    boolean
    private String taxNumber;

    private int roomsNumber;
    private int peopleCanAccomodate;


    House(int taxNumber) {
        setMunicipality();
        this.taxNumber= valueOf(taxNumber);
        houseInfo[2]=valueOf(taxNumber);
        setHouseID();
        setAddress();
        System.out.print("Number of rooms: ");
        roomsNumber=setIntegers(4);
        System.out.print("People that can be accommodated: ");
        peopleCanAccomodate=setIntegers(5);
        float levelOfComfort=(float) peopleCanAccomodate/roomsNumber;
        houseInfo[6]=String.valueOf(levelOfComfort);
        System.out.print("Is Internet included? ");
        setBooleans(7);
        System.out.print("Is a TV included? ");
        setBooleans(8);
        System.out.print("Is a kitchen included? ");
        setBooleans(9);
        System.out.print("Is parking spot included? ");
        setBooleans(10);
        setView();
        System.out.print("Distance from nearest metro station: ");
        setFloats(12);
        System.out.print("Daily cost: ");
        setFloats(13);
        apartmentOrNotInput();
        housesList.add(houseInfo);
//        housesOwned.put(taxNumber,housesList);
//        String[] houseInfoSecond={"1","2","3","1","2","3","1","2","3","1","2","3","1","2","3","1","2","3","1","2","3"};
//        housesList.add(houseInfoSecond);
//        housesOwned.put(taxNumber,housesList);

//        String test=housesOwned.get(taxNumber).get(1)[1];
        ArrayList<String[]> tempList = new ArrayList<String[]>();
        for (String[] array: housesList ){      //isws na mporei na diavazei mono to teleutaio, afou kathe fora pernaei apo edw
            if (array[2].equals(String.valueOf(taxNumber)))
                tempList.add(array);
            housesOwned.put(taxNumber,tempList);
        }
        allHousesPrinter();
    }

    private void setMunicipality() {
        String municipality="";
        System.out.print("Municipality: ");
        while (!(municipality = input.nextLine()).matches("[A-Z][A-Za-z '.]{2,50}"))
            System.out.println("Municipality must be 2-50 letters, can also contain special characters .' .");
        houseInfo[0]= municipality;
    }

    private void setHouseID() {
        String municipality = houseInfo[0].toUpperCase();
        String id = municipality.charAt(0) + "" + municipality.charAt(1) ;
        byte counter=-1;

        if (!housesList.isEmpty()){
            for(int i=0; i<housesList.size();i++){
                if(id.equals(housesList.get(i)[0].substring(0,2).toUpperCase()))
                    counter++;
            }
        }
        counter++;
        if (valueOf(counter).length() == 1)
            id = id + "000" + counter;
        else if (valueOf(counter).length() == 2)
            id = id + "00" + counter;
        else if (valueOf(counter).length() == 3)
            id = id + "0" + counter;
        else
            id = id + counter;
        houseInfo[1]=id;
    }

    private void setAddress(){  //Address can have more than 1 word, also number like 1-3
        String address="";
        System.out.print("House address:");
        while(!(address=input.nextLine().trim()).matches("([A-Z][a-z.([-][A-Z])?]{1,30}[ ])[0-9]{1,3}"))
            System.out.println("Each word must start with capital letter, have length 2-31 letters, special characters (. -).\nA whitespace is required before numbers.");
        houseInfo[3]=address;
    }


    private int setIntegers(int choice) {   //maybe can be done with generics
        int num = 0;
        boolean correct = false;
        do {
            try {
                do {
                    switch (choice) {
                        case 4, 5:
                            correct = (num = Integer.parseInt(input.nextLine())) > 0;
                            if (correct) break;
                            System.out.println("Provide positive number!");
                            break;
                        case 18:
                            correct = (num = Integer.parseInt(input.nextLine())) >= 0;
                            if (correct) break;
                            System.out.println("Provide a number greater or equal than zero!");
                            break;
                    }
                } while (!correct);
            } catch (NumberFormatException nfe) {
                System.out.println("You didnt provide a number");
            }
        } while (!correct);

        houseInfo[choice]= valueOf(num);
        return num;
    }


    private void setBooleans(int choice){
        String bool;
        while(!(bool=input.nextLine().trim().toUpperCase()).matches("[YN]"))
            System.out.println("Type Y for yes and N for no!");
        houseInfo[choice]=bool;
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

        houseInfo[11]=view;
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
                        case 15,16:
                            correct= (num = Float.parseFloat(input.nextLine())) >= 0;
                            if (correct) break;
                            System.out.println("Provide a number greater or equal than zero!");
                            break;
                    }
                }while(!correct);
            } catch (NumberFormatException nfe) {
                System.out.println("You didnt provide a number");
            }
        }while(!correct);

        houseInfo[choice]=String.valueOf(num);
    }

    private void apartmentOrNotInput(){
        System.out.println("Is the house an apartment?\nPress Y for yes, N for no!");
        String answer;
        while(!(answer = input.nextLine().trim().toUpperCase()).matches("[YN]"))
            System.out.println("Press Y for yes, N for no!");
        if (answer.equals("N")){
            houseInfo[14]="Dedicated House";
            System.out.println("Garden size in square meters (enter 0 if not included):");
            setFloats(15);
            System.out.println("Pool size in square meters (enter 0 if not included):");
            setFloats(16);
            System.out.println("Is BBQ included:");
            setBooleans(17);
        }else{
            houseInfo[14]="Apartment";
            System.out.println("Floor:");
            setIntegers(18);
            System.out.println("Is elevator included?");
            setBooleans(19);
            System.out.println("Is balcony included");
            setBooleans(20);

        }
    }

    public void housesOwnedPrinter(int taxNumber){
            for (int i=0;i<housesOwned.get(taxNumber).size();i++){
                for (int j=0;j<21;j++){
                    System.out.print(housesOwned.get(taxNumber).get(i)[j] +"||");
                }
                System.out.println();
            }
        }
    public  void allHousesPrinter(){
        for (String[] house : housesList){
            for(String elem : house)
                System.out.print(elem + "\t| ");
            System.out.println();
        }
    }

    }


