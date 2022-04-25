package it21988.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public abstract  class User {

    public static Map<Integer, String[]> usersMap= new HashMap<>();
    //                  taxNumber  0-Name  1-ID  2-Address  3-Email
    static Scanner input = new Scanner(System.in);

    public static int inputTaxNumber(){
        int taxNumber;
        while(true){
            System.out.print("Enter your tax number: ");
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
        }
        return taxNumber;
    }

    public static boolean userExists(int taxNumber){
        return User.usersMap.containsKey(taxNumber);
    }

//    public static void createUser(int taxNumber, boolean createOwner){
//
//        if(createOwner) {
//            var user = new UserRecord(inputName(), inputIdNum(), inputAddress(), null);
//            User.usersMap.put(taxNumber,user);
//        }else {
//            var user = new UserRecord(inputName(), inputIdNum(),null, inputEmail());
//            User.usersMap.put(taxNumber,user);
//        }
//
//    }

    public static String inputName() {
        System.out.print("Full name: ");
        String name = input.nextLine().trim();
        while (!name.matches("\\b([A-Z][-a-z. ']+[ ]*){2,}")){        //regex for greek names [A-Za-z]{2,30}[ ][A-Za-z]{2,30}
            System.out.println("Each word must start with capital letter and contain letters (A-Z,a-z) and characters (' . -) only! Try again.");
            System.out.print("Full name: ");
            name = input.nextLine().trim();
        }
        return name;
    }

    public static String inputIdNum() {
        System.out.print("ID number: ");
        String id= input.nextLine().trim();
        while(!id.matches("[A-Za-z]{2}[0-9]{6}")){
            System.out.println("ID must be of format LLNNNNNN (L=Capital letter, N=Number)");
            System.out.print("ID number: ");
            id=input.nextLine().trim();
        }
        return id;
    }

    public static String inputAddress(){
        System.out.print("Address: ");
        String address= input.nextLine().trim();
        while(!address.matches("([A-Z][a-z]{1,29}[-.]? ){1,3}[1-9]\\d{0,2}")){
            System.out.println("Each word must start with capital letter, have length 2-30 letters, special characters (. -).\nA whitespace is required before numbers and after symbols.");
            System.out.print("Address: ");
            address=input.nextLine().trim();
        }
        return address;
    }

    public static String inputEmail() {

        String pwd =System.getProperty("user.dir");
        String email;
        do {
            boolean correct = false;
            System.out.print("Email: ");
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
            System.out.println("Email: ");
        }while (true);

        return email;
    }

//        private void ownerOrRenter() {
//        boolean isOwner=false;
//
//
//        if(answer=='O')
//            isOwner=true;
//    }
}
