package ru.job4j.pro.generic;

/**
 * This interface describes store.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 22.05.2017
 * @param <T> is generic type
 */
public interface IStore<T extends Base> {

    /**
     * method add to store value.
     *
     * @param value is value
     * @return true
     */
    boolean add(T value);

    /**
     * method update srcValue to dstValue.
     *
     * @param srcValue is value need to be updated
     * @param dstValue is new value
     * @return true if scrValue was updated
     */
    boolean update(T srcValue, T dstValue);

    /**
     * method remove value from store.
     *
     * @param value is value need to be removed
     * @return true if value was removed
     */
    boolean remove(T value);

}
