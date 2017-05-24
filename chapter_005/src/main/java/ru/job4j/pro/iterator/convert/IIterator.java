package ru.job4j.pro.iterator.convert;

import java.util.Iterator;

/**
 * This interface describes action convert from Iterator of iterators of integer.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 23.05.2017
 */
public interface IIterator {

    /**
     * method convert iterator of iterators of integer to iterator of integer.
     *
     * @param it input iterator of iterators of integer
     * @return iterator of integer
     */
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it);

}
