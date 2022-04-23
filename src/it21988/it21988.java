package it21988;

import it21988.User.Owner;
import it21988.User.Renter;
import it21988.User.User;

import static it21988.House.housesList;
import static it21988.User.Renter.renterExists;

public class it21988 {

    public static void main(String[] args) {

        new Initialize();

        if(args.length !=0){
            for (House house : housesList) {
                if(house.taxNumber()== 937961472 ||house.taxNumber()== 115207936 ||house.taxNumber()== 438041088 ||house.taxNumber()==784441766 || house.taxNumber()==474553789 || house.taxNumber()==361777935
                ||house.taxNumber()== 840802240 || house.taxNumber()==605840000){
                    House.printHouse(house);
                }
            }
        }
        System.out.println(User.usersMap.containsKey(132312312));

        System.out.println("""
        ######################
        # Welcome to JavaBnB #
        ######################
        """);

        new Menu();


    }
}
