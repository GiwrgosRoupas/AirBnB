package com.giwrgosroupas;



public class InsertHouse {


    int taxNumber;
    InsertHouse(){
        var user=new User();
        taxNumber=user.setTaxNumber();
        if (!(user.userExists(taxNumber)))
                user.createUser();
        insertHouse();
    }

    private void insertHouse(){
        System.out.println("Provide the following info to insert a house.");
        House house=new House(taxNumber);
        System.out.println("House with ID #"+house.houseInfo[1]+" inserted. Owner info:"+User.userInfo[0]+", "+ taxNumber);
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
