package ru.job4j.pro.iterator.convert;

import java.util.Iterator;

/**
 * This class implements Iterator class and return instance of IteratorOfIterators class.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 23.05.2017
 */
public class IteratorConvert implements IIterator {

    /**
     * method input Iterator of iterators and return instance of IteratorOfIterators class.
     *
     * @param it input iterator of iterators of integer
     * @return instance of IteratorOfIterators class
     */
    @Override
    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new IteratorOfIterators(it);
    }

}
