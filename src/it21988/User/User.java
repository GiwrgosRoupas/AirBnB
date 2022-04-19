package it21988.User;


import java.util.HashMap;
import java.util.Map;

public record User(String name, String id, String address, String email) {
    public static Map<Integer,User> usersMap = new HashMap<>();


}
