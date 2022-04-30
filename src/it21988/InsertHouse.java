package it21988;


import it21988.House.House;
import it21988.House.HouseCompare;
import it21988.User.Owner;
import it21988.User.User;

import java.util.Collections;
import java.util.Scanner;

import static it21988.House.House.housesList;
import static it21988.House.HouseCompare.getHouse;
import static it21988.User.Owner.addToHousesOwned;
import static it21988.User.Owner.createOwner;
import static it21988.User.User.inputTaxNumber;
import static it21988.User.User.userExists;

public class InsertHouse {

    static Scanner input;
    int taxNumber;
    int index;
    InsertHouse(Scanner input){

        this.input=input;
        taxNumber= inputTaxNumber();
        if(userExists(taxNumber)) {
            if (!Owner.ownerExists(taxNumber)) {
                System.out.print("Account already exists as Renter, to get Owner access provide ");
                Owner.createOwnerRenterExists(taxNumber);
            }
        } else {
            System.out.println("Provide the following info to register as Owner.");
            createOwner(taxNumber);
        }
        createHouse();
        int count=0;
        for (House house :housesList){
            System.out.println(count +"\t"+house.houseID());
            count++;
        }
    }

    private void createHouse(){
        System.out.println("Provide the following info to insert a house.");
        String isApartment=inputBoolean(0);
        final String municipality=inputMunicipality();
        final String id=setHouseID(municipality);
        final byte roomsNumber =inputBytes(4);
        final byte pplNumber=inputBytes(5);
        final float comfortLevel= (float) pplNumber/roomsNumber;
        housesList.add(Math.min(index-1, housesList.size()),
                new House(
                municipality,
                id,
                taxNumber,
                inputAddress(),
                roomsNumber,
                pplNumber,
                comfortLevel,
                inputBoolean(7),
                inputBoolean(8),
                inputBoolean(9),
                inputBoolean(10),
                inputView(),
                inputInt(12),
                inputInt(13),
                isApartment.equals("No")? inputInt(14) : -1,
                isApartment.equals("No")? inputInt(15) : -1,
                isApartment.equals("No") ? inputBoolean(16) : null,
                isApartment.equals("Yes")? inputBytes(17) : -5,
                isApartment.equals("Yes")? inputBoolean(18) : null,
                isApartment.equals("Yes")? inputBoolean(19) : null
        ));
        addToHousesOwned(taxNumber,housesList.get(Math.min(index-1, housesList.size())));
        System.out.println("House with ID #"+id+" inserted. Owner info: "+ User.usersMap.get(taxNumber)[0]+", "+ taxNumber +".");
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



    private String setHouseID(String municipality) {

        int counter=0;
        String id = (municipality.charAt(0)+""+municipality.charAt(1)+"0000").toUpperCase();

        index = Collections.binarySearch(housesList, getHouse(id), new HouseCompare());
        System.out.println(index);
        if(index>=0) {
            while (index<housesList.size()) {
                if (housesList.get(index).houseID().substring(0, 2).equals(id.substring(0, 2)))
                    counter++;
                else {
                    counter++;
                    break;
                }
                    index++;
            }
            id= id.charAt(0)+""+id.charAt(1)+""+String.format("%04d",counter);
            index++;
        }else {
            index=1;
        }

        return id;
    }

    private String inputAddress(){  //Address can have more than 1 word, also number like 1-3
        String address;
        System.out.print("House address: ");
        while(!(address=input.nextLine().trim()).matches("([A-Z][a-z]{1,29}[-.]? ){1,3}[1-9]\\d{0,2}")) {
            System.out.println("Each word must start with capital letter, have length 2-31 letters, special characters (. -).\nA whitespace is required before numbers.");
            System.out.print("House address: ");
        }
        return address;
    }

    private String inputBoolean(int attribute){
        String answer;
        do {
            switch (attribute) {
                case 0-> System.out.println("Is the house an apartment? (Y/N): ");
                case 7 -> System.out.print("Internet access (Y/N): ");
                case 8 -> System.out.print("Is TV included? (Y/N): ");
                case 9 -> System.out.print("Is Kitchen included? (Y/N): ");
                case 10 -> System.out.print("Is parking spot available? (Y/N): ");
                case 16 -> System.out.print("Is BBQ included? (Y/N): ");
                case 18 -> System.out.print("Does the apartment have elevator? (Y/N): ");
                case 19 -> System.out.print("Does the apartment have balcony? (Y/N): ");
                default -> {
                    System.out.println("WrongAttribute");
                    System.exit(-1);
                }
            }
        }while(!(answer=input.nextLine().trim().toUpperCase()).matches("[YN]"));

        return answer.equals("Y") ? "Yes" : "No";
    }


    private  byte inputBytes(int attribute) {   //maybe can be done with generics
        byte num=0;
        boolean correct = false;
        do {
            try {
                do {
                    switch (attribute) {
                        case 4, 5 -> {      //rooms, pplNumber
                            System.out.print( attribute==4? "Number of rooms: " :
                                    "Number of people that can be accommodated: ");
                            correct = (num = Byte.parseByte(input.nextLine())) > 0;
                            if (correct) break;
                            System.out.println("Provide positive whole number!");
                        }
                        case 17 -> {        //floor
                            System.out.print("Floor: ");
                            correct = (num = Byte.parseByte(input.nextLine())) >= -2;
                            if (correct) break;
                            System.out.println("Provide a whole number greater or equal than -2!");
                        }
                        default -> {
                            System.out.println("Wrong attribute");
                            System.exit(-1);
                        }
                    }
                } while (!correct);
            } catch (NumberFormatException nfe) {
                System.out.println("You didnt provide a number or too big number (max. 127).");
            }
        } while (!correct);

        return num;
    }

    private int inputInt(int attribute){
        int num=0;
        boolean correct =false;
        do {
            try {
                do{
                    switch (attribute) {
                        case 12, 13 -> {
                            System.out.print(attribute ==12 ?"Distance from nearest metro station: ":
                                    "Daily cost: ");
                            correct = (num = Integer.parseInt(input.nextLine())) > 0;
                            if (correct) break;
                            System.out.println("Provide positive number!");
                        }
                        case 14, 15 -> {
                            System.out.print(attribute ==14 ? "Garden size in square meters (enter 0 if not included): "
                                    :"Pool size in square meters (enter 0 if not included): ");
                            correct = (num = Integer.parseInt(input.nextLine())) >= 0;
                            if (correct) break;
                            System.out.println("Provide a number greater or equal than zero!");
                        }
                        default -> {
                            System.out.println("Wrong attribute");
                            System.exit(-1);
                        }
                    }
                }while(!correct);
            } catch (NumberFormatException nfe) {
                System.out.println("You didnt provide a number");
            }
        }while(!correct);
        return num;
    }

    private String inputView(){
        String view;
        String menu=("""
                Provide apartment view,select:
                    1. Road
                    2. Sea
                    3. Mountain
                    """);
        System.out.println(menu);
        while(!(view=input.nextLine().trim()).matches("[123]"))
            System.out.println(menu);

        return view;
    }

}
