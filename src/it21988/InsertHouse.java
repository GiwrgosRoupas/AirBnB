package it21988;


import it21988.User.Owner;
import it21988.User.User;

import java.util.Scanner;

import static it21988.House.housesList;
import static it21988.User.User.*;
import static java.lang.String.valueOf;

public class InsertHouse {

    Scanner input = new Scanner(System.in);
    int taxNumber;
    InsertHouse(){
        taxNumber= inputTaxNumber();
        if(!Owner.ownerExists(taxNumber)) {
            if(userExists(taxNumber)) {
                System.out.print("Account already exists as Renter, to get Owner access provide ");
                Owner.createOwnerRenterExists(taxNumber);
            }
        }else {
            System.out.println("Provide the following info to register as Owner.");
            Owner.createOwner(taxNumber);
        }


        createHouse();
        input.close();
    }

    private void createHouse(){
        System.out.println("Provide the following info to insert a house.");
        String isApartment=inputBoolean(0);
        final String municipality=inputMunicipality();
        final String id=setHouseID(municipality);
        final byte roomsNumber =inputBytes(4);
        final byte pplNumber=inputBytes(5);
        final float comfortLevel= (float) pplNumber/roomsNumber;
        housesList.add(new House(
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
                inputFloat(12),
                inputFloat(13),
                isApartment.equals("No")? inputFloat(14) : -1,
                isApartment.equals("No")? inputFloat(15) : -1,
                isApartment.equals("No") ? inputBoolean(16) : null,
                isApartment.equals("Yes")? inputBytes(17) : -5,
                isApartment.equals("Yes")? inputBoolean(18) : null,
                isApartment.equals("Yes")? inputBoolean(19) : null
        ));
        System.out.println("House with ID #"+id+" inserted. Owner info: "+ User.usersMap.get(taxNumber)[0]+", "+ taxNumber +".");
    }

    private String inputMunicipality() {
        String municipality;
        System.out.print("Municipality: ");

        while (!(municipality = input.nextLine()).matches("[A-Z][A-Za-z '.]{2,50}")) {
            System.out.println("Municipality must be 2-50 letters, can also contain special characters .' .");
            System.out.print("Municipality: ");
        }
        return municipality;
    }

    private String setHouseID(String municipality) {
        String id = Character.toUpperCase(municipality.charAt(0)) + "" + Character.toUpperCase(municipality.charAt(1));
        byte counter=-1;

        if (!housesList.isEmpty()){
            for (House house : housesList) {
                if (id.equals(house.municipality().substring(0, 2).toUpperCase()))
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

        return id;
    }

    private String inputAddress(){  //Address can have more than 1 word, also number like 1-3
        String address;
        System.out.print("House address: ");
        while(!(address=input.nextLine().trim()).matches("([A-Z][a-z.([-][A-Z])?]{1,30}[ ])[0-9]{1,3}")) {
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


    private byte inputBytes(int attribute) {   //maybe can be done with generics
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
                System.out.println("You didnt provide a number");
            }
        } while (!correct);

        return num;
    }

    private float inputFloat(int attribute){   //maybe can be done with generics
        float num=0;
        boolean correct =false;
        do {
            try {
                do{
                    switch (attribute) {
                        case 12, 13 -> {
                            System.out.print(attribute ==12 ?"Distance from nearest metro station: ":
                                    "Daily cost: ");
                            correct = (num = Float.parseFloat(input.nextLine())) > 0;
                            if (correct) break;
                            System.out.println("Provide positive number!");
                        }
                        case 14, 15 -> {
                            System.out.print(attribute ==14 ? "Garden size in square meters (enter 0 if not included): "
                                    :"Pool size in square meters (enter 0 if not included): ");
                            correct = (num = Float.parseFloat(input.nextLine())) >= 0;
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
