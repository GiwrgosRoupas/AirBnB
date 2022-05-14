package it21988.Reservation;

public class IllegalCurrentDateEqualityException extends Throwable {

    public IllegalCurrentDateEqualityException(){
        System.out.println("Starting date must be at least one day after current date!");
    }
}
