package ru.job4j.pro.generic;

/**
 * This class describes abstract store and operation with it.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 13.06.2017
 *
 * @param <T> is generic type extends Base type
 */
public abstract class AbstractStore<T extends Base> implements IStore<T> {

    /**
     * parameter sa is SimpleArray instance.
     */
    private SimpleArray<T> sa = new SimpleArray<>();

    /**
     * method add value to sa.
     *
     * @param value is value
     * @return true
     */
    @Override
    public boolean add(T value) {
        return sa.add(value);
    }

    /**
     * method updates srcValue to dstValue if srcValue exist in sa.
     *
     * @param srcValue is value need to be updated
     * @param dstValue is new value
     * @return true if srcValue successfully updated
     */
    @Override
    public boolean update(T srcValue, T dstValue) {

        for (int count = 0; count < sa.size(); count++) {

            if (sa.get(count).getId().equals(srcValue.getId())) {
                sa.update(count, dstValue);
                return true;
            }

        }

        return false;
    }

    /**
     * method remove value from sa.
     *
     * @param value is value need to be removed
     * @return true if value was successfully removed
     */
    @Override
    public boolean remove(T value) {
        return sa.remove(value);
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
    public T[] toArray(T[] input) {
        return sa.toArray(input);
    }

}
