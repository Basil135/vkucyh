package ru.job4j.pro.iterator.convert;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class describes iterator.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 23.05.2017
 */
public class IteratorOfIterators implements Iterator<Integer> {

    /**
     * parameter iterator of iterators.
     */
    private final Iterator<Iterator<Integer>> input;
    /**
     * parameter iterator of integer.
     */
    private Iterator<Integer> currentIterator = null;

    /**
     * constructor of this class.
     *
     * @param input input iterator of iterators of integer
     */
    public IteratorOfIterators(final Iterator<Iterator<Integer>> input) {
        this.input = input;
    }

    /**
     * method return true if currentIterator hasNext is true.
     *
     * @return true if currentElements have next elements
     */
    @Override
    public boolean hasNext() {

        initCurrentIterator();

        return this.currentIterator.hasNext();

    }

    /**
     * method return integer number and goes to next element of current number.
     *
     * @return integer number
     */
    @Override
    public Integer next() {

        initCurrentIterator();

        if (!currentIterator.hasNext()) {
            throw new NoSuchElementException();
        }

        return currentIterator.next();

    }

    /**
     * method assign iterator of integer from input to currentIterator.
     */
    private void initCurrentIterator() {

        if (this.currentIterator == null || !this.currentIterator.hasNext()) {

            if (this.input.hasNext()) {
                this.currentIterator = this.input.next();
            }

        }

    }

}
