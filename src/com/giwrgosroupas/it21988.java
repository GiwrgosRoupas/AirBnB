package com.giwrgosroupas;

import java.util.ArrayList;
import java.util.HashMap;

public class it21988 {

    public static void main(String[] args) {

        // For Owners
        // TaxNumber, {House_ID}
        var housesOwned= new HashMap<Integer,ArrayList<Integer>>();
        // For Renters
        // TaxNumber, {House_ID}
        var reservationsMade= new HashMap<Integer,ArrayList<Integer>>();

        //Xreiazomai ena collection pou periexei ola ta spitia
        //sta kelia [0], [1] periexei hmeromhni
        var houses = new ArrayList<House>();
        var menu = new Menu();

    }
}
