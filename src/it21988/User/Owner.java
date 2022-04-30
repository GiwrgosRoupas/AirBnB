package it21988.User;

import it21988.House.House;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Owner extends User {

    public static Map<Integer, ArrayList<House>> housesOwned = new HashMap<>();

    public static void addToHousesOwned(Integer taxNumber, House house){
        ArrayList<House> temp = new ArrayList<>();
        if ((!housesOwned.containsKey(taxNumber)) || housesOwned.get(taxNumber).isEmpty()){
            temp.add(house);
            housesOwned.put(taxNumber,temp);
        }else {
            temp=housesOwned.get(taxNumber);
            temp.add(house);
            housesOwned.put(taxNumber,temp);
        }
    }
    public static boolean ownerExists(int taxNumber) {
        if (userExists(taxNumber))
            return !usersMap.get(taxNumber)[2].equals("-");
        return false;
    }
    public static void createOwner(int taxNumber) {
        usersMap.put(taxNumber, new String[]{User.inputName(), User.inputIdNum(), User.inputAddress(), "-"});
        System.out.println("Account created with Owner access.");
    }
    public static void createOwnerRenterExists(int taxNumber) {
        String[] temp = usersMap.get(taxNumber);
        temp[2] = inputAddress();
        usersMap.put(taxNumber, temp);
        System.out.println("Account upgraded to full access");
    }
}
