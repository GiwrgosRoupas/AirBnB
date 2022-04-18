package com.giwrgosroupas;

import java.util.ArrayList;
import java.util.HashMap;

import static com.giwrgosroupas.User.userInfo;
import static com.giwrgosroupas.User.userMap;

public class it21988{

    public static void main(String[] args) {

        if(args.length!=0 && args[0].equals("-dbg")){
            User.userInfo[0]="Giwrgos Roupas";
            User.userInfo[1]="AI683883";
            User.userInfo[2]="Yrkanias 1-3";
            User.userInfo[3]="degen1997@gmail.com";
            String[] array={"Panagiotis Panagiwtou","KL984375" ,"Agiou Eustratiou 1","papaki@papaki.com"};
            userMap.put(123456789,userInfo);
            userMap.put(215345698,array);
        }


        // For Owners
        // TaxNumber, {House_ID}
        var housesOwned= new HashMap<Integer,ArrayList<Integer>>();
        // For Renters
        // TaxNumber, {House_ID}
        var reservationsMade= new HashMap<Integer,ArrayList<Integer>>();

        var houses = new ArrayList<House>();
        var menu = new Menu();

    }
}
