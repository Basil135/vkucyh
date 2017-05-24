package ru.job4j.pro.generic;

/**
 * This class describes user.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 22.05.2017
 */
public class User extends Base {

    /**
     * parameter id is identification string.
     */
    private String id;

    /**
     * method getId return id.
     *
     * @return id
     */
    @Override
    public String getId() {
        return id;
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
     * method compare this with object o and return true if they equals.
     *
     * @param o is object to compare with
     * @return true if this equals to object o
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        return id != null ? id.equals(user.id) : user.id == null;
    }

    /**
     * method generate integer number from string id.
     *
     * @return integer number as hashcode
     */
    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

}
