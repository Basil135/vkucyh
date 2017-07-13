package ru.job4j.pro.map;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * This class describes the difference of overriding hashcode and equals.
 *
 * @author Kutsykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 13.07.2017
 */
public class SimpleMapUser {

    /**
     * main method.
     *
     * @param args input args
     */
    public static void main(String[] args) {

        User user1 = new User("Vasily", 1, new GregorianCalendar(1989, 03, 26));
        User user2 = new User("Vasily", 1, new GregorianCalendar(1989, 03, 26));

        Map<User, Object> simpleMap = new HashMap<>();

        simpleMap.put(user1, "user1");
        simpleMap.put(user2, "user2");

        System.out.println(simpleMap);

    }

}
