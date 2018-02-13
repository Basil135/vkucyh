package ru.job4j.chapter002.multithreading.storage;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * This class describes simple user with minimum parameters.
 *
 * @author Kutsykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 13.02.2018
 */
@ThreadSafe
public class User {
    /**
     * parameter id of the user.
     */
    private final int id;
    /**
     * parameter amount of the user.
     */
    @GuardedBy("this")
    private int amount;

    /**
     * constructor of this class.
     *
     * @param id is inout id of the user
     * @param amount is amount of the user
     */
    public User(final int id, final int amount) {
        this.id = id;
        this.amount = amount;
    }

    /**
     * method return id of the user.
     *
     * @return id of this user
     */
    public int getId() {
        return id;
    }

    /**
     * method return amount of the user.
     *
     * @return amount of this user
     */
    public synchronized int getAmount() {
        return amount;
    }

    /**
     * method set amount to this user.
     *
     * @param amount is amount to set to this user
     */
    public synchronized void setAmount(final int amount) {
        this.amount = amount;
    }

    /**
     * method compare this user with object obj.
     *
     * @param obj is input object
     * @return true if this id equals to obj id
     */
    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj.getClass() == this.getClass()) {
            User temp = (User) obj;
            if (this.id == temp.id) {
                result = true;
            }
        }
        return result;
    }

    /**
     * method return hashcode.
     *
     * @return hashcode
     */
    @Override
    public int hashCode() {
        return 37 * (id + 1);
    }
}
