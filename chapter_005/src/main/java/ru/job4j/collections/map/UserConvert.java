package ru.job4j.collections.map;

import java.util.HashMap;
import java.util.List;

/**
 * This class contains method that convert list of users to HashMap of users.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 08.05.2017
 */
public class UserConvert {

    /**
     * method convert List of users to HashMap of users.
     *
     * @param list is input List of users
     * @return HashMap of users
     */
    public HashMap<Integer, User> process(List<User> list) {

        HashMap<Integer, User> result = new HashMap<>();

        for (User user : list) {
            result.put(user.getId(), user);
        }

        return result;

    }

}
