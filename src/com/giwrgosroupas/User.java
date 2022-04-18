package com.giwrgosroupas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class User {
    private int taxNumber;
    Scanner input = new Scanner(System.in);

    // TaxNumber, 0 Name, 1 ID, 2 Adress, 3 E-mail
    public static  String[] userInfo = new String[4];
    public static HashMap<Integer, String[]> userMap = new HashMap<>();



    public int getTaxNumber() {
        return taxNumber;
    }

    public int setTaxNumber() {
        System.out.println("Enter your tax number.");

        do {
            String temp = input.nextLine();
            if (temp.length() == 9) {
                try {
                    taxNumber = Integer.parseInt(temp);
                    break;
                } catch (NumberFormatException exception) {
                    System.out.println("Your input contains non-number symbols.");
                }
            } else
                System.out.println("Tax number must be 9 numbers.");
        } while (true);

        return taxNumber;
    }

    public boolean userExists(int taxNumber){
        if (userMap.containsKey(taxNumber))
            return true;
        return false;
    }

    public void createUser() {
        System.out.println("User not found, enter your info below:");
        System.out.println("First and last name: ");
        createUserNameValidation();
        System.out.println("Your adress: ");
        createUserAddressValidation();
        System.out.println("ID number");
        createUserIdValidation();
        System.out.println("Email:");
        createUserEmailValidation();
        userMap.put(taxNumber, userInfo);
    }

    private void createUserNameValidation(){
        String name= input.nextLine().trim();
        while(!name.matches("\\b([A-Z][-a-z. ']+[ ]*){2,}")){        //regex for greek names [A-Za-z]{2,30}[ ][A-Za-z]{2,30}
            System.out.println("Each must start with capital letter and contain letters (A-Z,a-z) and characters (' . -) only! Try again.");
            name=input.nextLine().trim();
        }
        userInfo[0]= name;
    }

    private void createUserIdValidation() {
        String id= input.nextLine().trim();
        while(!id.matches("[A-Za-z]{2}[0-9]{6}")){
            System.out.println("ID must be of format LLNNNNNN (L=Capital letter, N=Number)");
            id=input.nextLine().trim();
        }
        userInfo[1]= id;
    }

    private void createUserAddressValidation(){
        String address= input.nextLine().trim();
        while(!address.matches("([A-Z][a-z.([-][A-Z])?]{1,30}[ ])[0-9]{1,3}")){
            System.out.println("Each word must start with capital letter, have length 2-31 letters, special characters (. -).\nA whitespace is required before numbers.");
            address=input.nextLine().trim();
        }
        userInfo[2]= address;
    }

    private void createUserEmailValidation() {

        String pwd =System.getProperty("user.dir");
        String email="";
        do {
            boolean correct = false;
            email = input.nextLine().trim();
            try (Scanner fileScanner = new Scanner(new File(pwd + "/topLevelDomains.txt"))){
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    correct = email.matches("[A-Za-z0-9][A-Za-z\"(),:;<>\\[\\]]{1,250}[A-Za-z0-9]+[@][A-Za-z0-9.-]{1,253}[.]" + line);
                    if (correct) break;
                }
            }
            catch (FileNotFoundException ex) {
                correct = email.matches("[A-Za-z0-9][A-Za-z\"(),:;<>\\[\\]]{1,250}[A-Za-z0-9]+[@][A-Za-z0-9.-]{1,253}[.][A-Za-z]{1,30}");
            }

            if (correct) break;
            System.out.println("Incorrect mail!");
            System.out.print("""
                    Mail must be of format Userspace@Address.Top
                    Userspace can have:
                        All letters and numbers
                        Special characters []<>:;"
                        First and last character can't be a special character
                        1-250 characters
                    Adress can have:
                        All letters and number
                        Special characters .-
                        1-253 characters
                    Top must be an existing top level domain
                        1-30 characters
                    """);
            System.out.println("Email:");
        }while (true);

        userInfo[3]= email;
    }
}
