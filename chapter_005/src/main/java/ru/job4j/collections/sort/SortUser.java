package ru.job4j.collections.sort;

import java.util.Comparator;
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

    /**
     * method sort list of users by hashcode.
     *
     * @param list is input list of users
     * @return sorted list of users
     */
    public List<User> sortHash(List<User> list) {

        list.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.hashCode() - o2.hashCode();
            }
        });

        List<User> result = list;

        return result;

    }

    /**
     * method sort list of users by length of name.
     *
     * @param list is input list of users
     * @return sorted list of users
     */
    public List<User> sortLength(List<User> list) {

        list.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().length() - o2.getName().length();
            }
        });

        List<User> result = list;

        return result;

    }

}
