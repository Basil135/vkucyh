package ru.job4j.collections.test;

/**
 * This class describes department of the company.
 *
 * @author Kucykh Vasily (mailto:bail135@mail.ru)
 * @version $Id$
 * @since 17.05.2017
 */
public class Department {

    /**
     * parameter name is name of the department.
     */
    private final String name;

    /**
     * constructor of this class.
     *
     * @param name is name of this department
     */
    public Department(final String name) {
        this.name = name;
    }

    /**
     * method return name of this department.
     *
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * method compare this department with object o and return true if they are equals.
     *
     * @param o is object we need compare to
     * @return true if this department equals to o
     */
    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Department that = (Department) o;

        return name.equals(that.name);

    }

    /**
     * method generate an integer number describes this department.
     *
     * @return integer number
     */
    @Override
    public int hashCode() {
        return name.hashCode();
    }

}