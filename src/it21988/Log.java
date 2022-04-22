package it21988;

import java.util.Locale;
import java.util.Scanner;
//provide returns
//provide finish, dont go to main userMenuChoice but previous userMenuChoice
//provide clear term
/*CHECK BEFORE CODING*/
//if they choose ownerEnter and no owner found ask if they want to register
//if they choose renterEnter and no owner found ask if they want to register with return to home
//if no house/reservation found provide appropriate message
public class Log {
    Scanner input =new Scanner(System.in);
    Log(){
        char choice='0';
        do {
            choice= userMenuChoice(1 ); /*Log Menu*/
            if(choice=='1'){
                choice=userMenuChoice(2);  /*Owner Menu*/
                if (choice==1){
                    ownerShowHouses();
                }else if(choice==2){
                    ownerShowRentedTime();
                }
            }else if (choice=='2'){
                choice=userMenuChoice(3);  /*Renter Menu*/
                if (choice==1){
                    renterShowReservations();
                }
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
                if(menuNum==1 || menuNum==2) {
                    correct = choiceChar == '1' || choiceChar == '2' || choiceChar == 'X';
                }else if (menuNum == 3) {
                    correct = choiceChar == '1' || choiceChar == 'X';
                }
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
            case 3 ->System.out.println("""
                       Select:
                           1. Your reservations list
                           X. Previous Menu
                       """);
            default -> {System.out.println("Wrong menuNum, check Log class!");
                System.exit(-1);}
        }
    }

    private void ownerShowHouses(){};
    private void ownerShowRentedTime(){};

    private void renterShowReservations(){};



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


