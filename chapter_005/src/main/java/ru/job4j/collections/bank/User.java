package ru.job4j.collections.bank;

/**
 * This class describes user of bank.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 11.05.2017
 */
public class User {

    /**
     * parameter name is name of a user.
     */
    private final String name;
    /**
     * parameter passport is passport data of a user.
     */
    private final String passport;

    /**
     * constructor of class User.
     *
     * @param name is name of the user
     * @param passport is passport data of the user
     */
    public User(final String name, final String passport) {
        this.name = name;
        this.passport = passport;
    }

    /**
     * method return name of the user.
     *
     * @return name of the user
     */
    public String getName() {
        return name;
    }

    /**
     * method return passport data of the user.
     *
     * @return passport data of the user
     */
    public String getPassport() {
        return passport;
    }

    /**
     * method compare this user with user o.
     *
     * @param o is user to compare this user
     * @return true if this user is equal to user o
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

        if (!name.equals(user.name)) {
            return false;
        }

        return passport.equals(user.passport);
    }

    /**
     * method return integer number describes this user.
     *
     * @return integer number
     */
    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + passport.hashCode();
        return result;
    }

}
