package ru.job4j.collections.sort;

/**
 * This class describes simple user with name and age.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 10.05.2017
 */
public class User implements Comparable<User> {

    /**
     * @param name is name of user.
     */
    private String name;
    /**
     * @param age is age of user.
     */
    private final int age;

    /**
     * constructor of class User.
     *
     * @param name is name of an user
     * @param age is age of an user
     */
    public User(final String name, final int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * method return age of an user.
     *
     * @return age of an user
     */
    public int getAge() {
        return age;
    }

    /**
     * method compare this user with user o by age.
     *
     * @param o is user to compare with
     * @return number that show us this user older then user o or not
     */
    @Override
    public int compareTo(User o) {
        return this.age - o.getAge();
    }

}
