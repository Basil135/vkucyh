package ru.job4j.pro.iterator.even;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class describes iterator of even numbers at array.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 23.05.2017
 */
public class EvenIterator implements Iterator<Integer> {

    /**
     * parameter array is array of numbers.
     */
    private final int[] array;
    /**
     * parameter index is position of element in the array.
     */
    private int index = 0;

    /**
     * constructor of this class.
     *
     * @param array is input array
     */
    public EvenIterator(final int[] array) {
        this.array = array;
    }

    /**
     * method return true if array contains even numbers from index to the end.
     *
     * @return true if array have another even numbers
     */
    @Override
    public boolean hasNext() {

        boolean result = false;

        while (index < array.length && !result) {

            if (!(array[index] % 2 == 0)) {
                index++;
            } else {
                result = true;
            }

        }

        return result;
    }

    /**
     * method return next even number from array.
     *
     * @return even number
     */
    @Override
    public Integer next() {

        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        return array[index++];

    }

}