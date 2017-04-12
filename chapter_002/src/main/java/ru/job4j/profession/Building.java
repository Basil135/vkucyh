package ru.job4j.profession;

/**
 * This is simple class describes building.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 12.04.2017
 */
public class Building {

    /**
     * parameter name is name of a building.
     */
    private String name;

    /**
     * constructor for class Building.
     *
     * @param name is name of a building
     */
    public Building(String name) {
        this.name = name;
    }

    /**
     * method return name string of a building.
     *
     * @return string name of a building
     */
    public String getName() {
        return this.name;
    }

}
