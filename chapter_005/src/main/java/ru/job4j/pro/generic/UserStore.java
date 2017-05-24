package ru.job4j.pro.generic;

/**
 * This class describes store of users.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 23.05.2017
 */
public class UserStore implements IStore<User> {

    /**
     * parameter sa is a simple array collection.
     */
    private SimpleArray<User> sa = new SimpleArray<>();

    /**
     * method add user to collection.
     *
     * @param user is input user
     * @return true
     */
    @Override
    public boolean add(User user) {
        return sa.add(user);
    }

    /**
     * method update srcUser by dstUser.
     *
     * @param srcUser is user we need to update
     * @param dstUser is final user
     * @return true if srcUser was successfully updated
     */
    @Override
    public boolean update(User srcUser, User dstUser) {

        for (int count = 0; count < sa.size(); count++) {

            if (sa.get(count).getId().equals(srcUser.getId())) {
                sa.update(count, dstUser);
                return true;
            }

        }

        return false;

    }

    /**
     * method remove user from collection.
     *
     * @param user is user we need to remove
     * @return true if user was successfully removed
     */
    @Override
    public boolean remove(User user) {
        return sa.remove(user);
    }

    /**
     * method return Object array of users.
     *
     * @return array
     */
    public Object[] toArray() {
        return sa.toArray();
    }

    /**
     * method return User array of users.
     *
     * @param input is input array
     * @return array
     */
    public User[] toArray(User[] input) {
        return sa.toArray(input);
    }

}
