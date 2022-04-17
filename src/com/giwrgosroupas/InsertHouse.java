package com.giwrgosroupas;

import java.util.HashMap;

public class InsertHouse {

    boolean userNotExists;
    int taxNumber;
    InsertHouse(){
        var user=new User();
        taxNumber=user.setTaxNumber();
        userNotExists =user.userNotExists(taxNumber);
        if (!userNotExists)
                user.createUser();

        insertHouse();
    }

    private void insertHouse(){
        System.out.println("Provide the following info to insert a house.");
        House house=new House(taxNumber);

    }





//    private void ownerOrRenter() {
//        boolean isOwner=false;
//        var scanner = new Scanner(System.in);
//        String input;
//        char answer= ' ';
//        do {
//            System.out.println("To enter as owner press O, to enter as renter press R!");
//            input = scanner.nextLine();
//            if (input.length() == 1)
//                answer = input.toUpperCase().charAt(0);
//            else
//                System.out.println("Too many arguments!");
//
//            if(answer=='O' || answer=='R')
//                break;
//            else
//                System.out.println("Wrong character!");
//        } while (true);
//
//        if(answer=='O')
//            isOwner=true;
//    }
}
