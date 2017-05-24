package ru.job4j.pro.generic;

/**
 * This class describes store of roles.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 22.05.2017
 */
public class RoleStore implements IStore<Role> {

    /**
     * parameter sa is instance of SimpleArray class.
     */
    private SimpleArray<Role> sa = new SimpleArray<>();

    /**
     * method add added role to store sa.
     *
     * @param value is value
     * @return true.
     */
    @Override
    public boolean add(Role value) {
        return sa.add(value);
    }

    /**
     * method update updated srcRole by dstRole.
     *
     * @param srcValue is value need to be updated
     * @param dstValue is new value
     * @return true if srcRole was updated
     */
    @Override
    public boolean update(Role srcValue, Role dstValue) {
        for (int count = 0; count < sa.size(); count++) {

            if (sa.get(count).getId().equals(srcValue.getId())) {
                sa.update(count, dstValue);
                return true;
            }

        }

        return false;

    }

    /**
     * method remove from sa Role value if exist.
     *
     * @param value is value need to be removed
     * @return true if value deleted from sa
     */
    @Override
    public boolean remove(Role value) {
        return sa.remove(value);
    }

    /**
     * method return array of Roles.
     *
     * @return array of roles
     */
    public Object[] toArray() {
        return sa.toArray();
    }

    /**
     * method return array of roles as array of input type.
     *
     * @param input is input array.
     * @return array
     */
    public Role[] toArray(Role[] input) {
        return sa.toArray(input);
    }

}
