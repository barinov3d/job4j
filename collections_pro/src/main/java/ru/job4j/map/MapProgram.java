package ru.job4j.map;

import java.util.*;

public class MapProgram {
    public static void main(String[] args) {
        Calendar calendar = new GregorianCalendar();
        User a = new User("Alex", 1, calendar);
        User b = new User("Alex", 1, calendar);
        Object object = new Object();
        Map<User, Object> map = new HashMap<>();
        map.put(a, object);
        map.put(b, object);
        System.out.println(map);
    }
}
