package ru.job4j.collections.map;

/**
 * This class describes user.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 08.05.2017
 */
public class User {

    /**
     * parameter id is id of a user.
     */
    private final int id;
    /**
     * parameter name is name of a user.
     */
    private String name;
    /**
     * parameter city is where from the user.
     */
    private String city;

    /**
     * constructor of class User.
     *
     * @param id is id of a user
     * @param name is name of a user
     * @param city is where from the user
     */
    public User(final int id, final String name, final String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    /**
     * method return id of a user.
     *
     * @return id of a user
     */
    public int getId() {
        return id;
    }

}
