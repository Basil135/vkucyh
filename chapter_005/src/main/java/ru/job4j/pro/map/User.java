package ru.job4j.pro.map;

import java.util.Calendar;


/**
 * This class describes simple user with few parameters and one constructor.
 *
 * @author Kutsykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 12.07.2017
 */
public class User {

    /**
     * parameter name is name of this user.
     */
    private String name;
    /**
     * parameter children is number of children of this user.
     */
    private int children;
    /**
     * parameter birthday is birthday of this user.
     */
    private Calendar birthday;

    /**
     * simple constructor for User.
     *
     * @param name is name of this user
     * @param children is number of children of this user
     * @param birthday is birthday of this user
     */
    public User(final String name, final int children, final Calendar birthday) {

        this.name = name;
        this.children = children;
        this.birthday = birthday;

    }

    /**
     * method return integer as describe object.
     *
     * @return integer
     */
    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + children;
        result = 31 * result + birthday.hashCode();
        return result;
    }

}
