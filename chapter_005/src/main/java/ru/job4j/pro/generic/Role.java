package ru.job4j.pro.generic;

/**
 *
 * This class describes role.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 22.05.2017
 */
public class Role extends Base {

    /**
     * parameter id is identification string.
     */
    private String id;

    /**
     * method return id.
     *
     * @return id
     */
    @Override
    public String getId() {
        return this.id;
    }

    /**
     * method set id.
     *
     * @param id is identification string
     */
    @Override
    public void setId(String id) {
        this.id = id;
    }

    /**
     * method compare this to object o and return true if they equals.
     *
     * @param o is input object to compare with
     * @return true if this and o are equals
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        return id != null ? id.equals(role.id) : role.id == null;
    }

    /**
     * method generate integer number from id.
     *
     * @return integer number as hashcode
     */
    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
