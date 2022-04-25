package it21988.User;

import static it21988.User.User.usersMap;

public class Renter extends User {

    public static boolean renterExists(int taxNumber){
        if (userExists(taxNumber))
            return !usersMap.get(taxNumber)[3].equals("-");
        return false;
    }

    public static void createRenter(int taxNumber){
        usersMap.put(taxNumber, new String[]{User.inputName(), User.inputIdNum(), "-", User.inputEmail()});
        System.out.println("Account created with Renter access.");
    }

    public static void createRenterOwnerExists(int taxNumber){
        String[] temp=usersMap.get(taxNumber);
        temp[3]=inputEmail();
        usersMap.put(taxNumber, temp);
        System.out.println("Account upgraded to full access");
    }

}
