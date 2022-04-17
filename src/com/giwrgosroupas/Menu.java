package com.giwrgosroupas;

import java.util.Scanner;

import static java.lang.System.exit;

public class Menu {

    Menu() {
        helloMessage();
        mainMenu();
    }

    private void helloMessage() {
        System.out.println("######################");
        System.out.println("# Welcome to JavaBnB #");
        System.out.println("######################");
    }

    private void mainMenu() {
        System.out.println("Press:");
        System.out.println("\t1. To insert house");
        System.out.println("\t2. To make reservation");
        System.out.println("\t3. To change or cancel reservation");
        System.out.println("\t4. Show Logs");
        System.out.println("\t5. Exit");
        byte choice=mainMenuInputValidation();
        mainMenuChoiceRedirect(choice);

    }


    private byte mainMenuInputValidation(){
        var input= new Scanner(System.in);

        byte choice=0;
        do{
            try{
                choice=Byte.parseByte(input.nextLine());
                if (choice<=0 || choice >5)
                    System.out.println("Number must be in range 1-5");
            }catch(NumberFormatException ex){
                System.out.println("Didn't provide a number");
            }
        }while (choice<=0 || choice>5);
        return choice;
    }

    private void mainMenuChoiceRedirect(byte choice){
        switch(choice) {
            case 1:
                new InsertHouse();
        }
    }

//    public void ownerOrRenter() {
//        var scanner = new Scanner(System.in);
//        String input;
//        char answer= ' ';
//        do {
//            System.out.println("To enter as owner press O, to enter as renter press R.");
//            input = scanner.nextLine();
//            if (input.length() == 1) {
//                answer = input.toUpperCase().charAt(0);
//            } else
//                System.out.println("Too many arguments!");
//
//            if(answer=='O' || answer=='R')
//                break;
//            else
//                System.out.println("Wrong character!");
//        } while (true);
//
//        switch (answer) {
//            case 'O':
//                ownerMenu();
//            case 'R':
//                renterMenu();
//            default:
//                System.out.println("Wrong character!");
//        }
//    }
//
//    private void ownerMenu() {
//
//    }
//
//    private void renterMenu() {
//    }

}
