package ru.job4j.chapter002.multithreading.storage;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.ArrayList;
import java.util.List;

/**
 * This class describes storage of users with simple methods to manage.
 *
 * @author Kutsyikh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 13.02.2018
 */
@ThreadSafe
public class UserStorage {
    /**
     * parameter describes storage of users.
     */
    @GuardedBy("this")
    private List<User> users = new ArrayList<>();

    /**
     * method add user to storage.
     *
     * @param user is user to add
     * @return true if user successfully added
     */
    public synchronized boolean addUser(final User user) {
        return users.add(user);
    }

    /**
     * method update existing user to new user.
     *
     * @param user is new user
     * @return true if existing user successfully updated
     */
    public synchronized boolean updateUser(final User user) {
        boolean result = false;
        int index = users.indexOf(user);
        if (index != -1) {
            users.set(index, user);
            result = true;
        }
        return result;
    }

    /**
     * method delete existing user.
     *
     * @param user is user we need to delete
     * @return true if user successfully deleted
     */
    public synchronized boolean deleteUser(final User user) {
        return users.remove(user);
    }

    /**
     * method transfer amount from user with id=fromId to user with id=toId.
     *
     * @param fromId is id of user we need to get amount
     * @param toId is id of user we need to add amount
     * @param amount is amount we need to manage
     * @return true if we successfully transfer amount
     */
    public synchronized boolean transfer(final int fromId, final int toId, final int amount) {
        boolean result = false;
        User from = null;
        User to = null;
        for (User user : users) {
            if (user.getId() == fromId) {
                from = user;
            }
            if (user.getId() == toId) {
                to = user;
            }
            if (from != null && to != null) {
                break;
            }
        }
        if (from != null && to != null) {
            int currentAmount = from.getAmount();
            if (currentAmount >= amount) {
                from.setAmount(currentAmount - amount);
                currentAmount = to.getAmount();
                to.setAmount(currentAmount + amount);
                result = true;
            }
        }
        return result;
    }

    /**
     * method return user with id=id.
     *
     * @param id is input id
     * @return user with id=id
     */
    public synchronized User getUser(int id) {
        int index = users.indexOf(new User(id, 0));
        if (index != -1) {
            return users.get(index);
        }
        return null;
    }
}
