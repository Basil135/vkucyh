package ru.job4j.profession;

/**
 * Class describes human.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 12.04.2017
 */
public class Human {

    /**
     * parameter name is the name of a human.
     */
    private String name;

    /**
     * constructor of a human.
     *
     * @param name is name of a human
     */
    public Human(String name) {
        this.name = name;
    }

    /**
     * method return name of a human.
     *
     * @return name of a human
     */
    public String getName() {
        return this.name;
    }

}
