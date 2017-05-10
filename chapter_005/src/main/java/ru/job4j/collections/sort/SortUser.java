package ru.job4j.collections.sort;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * This class sort users.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 10.05.2017
 */
public class SortUser {

    /**
     * method sort list of users by age and return TreeSet of User.
     *
     * @param users is input list of users
     * @return sorted TreeSet of users
     */
    public Set<User> sort(List<User> users) {

        Set<User> result = new TreeSet<>();

        for (User user : users) {
            result.add(user);
        }

        return result;

    }

}
