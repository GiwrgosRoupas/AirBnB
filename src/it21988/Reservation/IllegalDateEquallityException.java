package it21988.Reservation;

public class IllegalDateEquallityException extends Throwable {
    public IllegalDateEquallityException() {
        System.out.println("End date must be at least 1 day after starting date.");
    }
}
