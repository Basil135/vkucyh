package ru.job4j.pro.iterator.array;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class implements iterator of double array.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 23.05.2017
 */
public class ArrayIterator implements Iterator<Integer> {

    /**
     * parameter index of column.
     */
    private int indexCol = 0;
    /**
     * parameter index of row.
     */
    private int indexRow = 0;
    /**
     * parameter doubleArray is double array.
     */
    private final Integer[][] doubleArray;

    /**
     * constructor of class.
     *
     * @param doubleArray is input double array
     */
    public ArrayIterator(final Integer[][] doubleArray) {
        this.doubleArray = doubleArray;
    }

    /**
     * method return true if doubleArray have next value.
     *
     * @return true if array have next value
     */
    @Override
    public boolean hasNext() {
        boolean result = true;

        if (indexRow == doubleArray.length - 1 && indexCol == doubleArray[indexRow].length) {
            result = false;
        }

        return result;
    }

    /**
     * method return Integer number of position indexCol and indexRow, then increment one of them.
     *
     * @return Integer number as value
     */
    @Override
    public Integer next() {

        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        Integer result;

        if (indexCol == doubleArray[indexRow].length) {
            indexCol = 0;
            indexRow++;
        }

        result = doubleArray[indexRow][indexCol++];

        return result;

    }

}
