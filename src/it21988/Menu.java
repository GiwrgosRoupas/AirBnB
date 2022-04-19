package it21988;

import java.util.Scanner;

import static java.lang.System.exit;

public class Menu {
    Menu() {
        byte choice;
        do {
            System.out.println("""
                    Press:
                        1. To insert house
                        2. To make reservation
                        3. To change or cancel reservation
                        4. Show Logs
                        5. Exit
                    """);
            choice=mainMenuInputValidation();
            mainMenuChoiceRedirect(choice);
        }while(choice!=5);
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
        switch (choice) {
            case 1 -> new InsertHouse();
            case 5 -> exit(0);
        }
    }
}
