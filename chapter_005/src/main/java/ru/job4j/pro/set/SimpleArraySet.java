package ru.job4j.pro.set;


import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class describes part of implementation of set with iterator.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 15.06.2017
 *
 * @param <E> is generic type
 */
public class SimpleArraySet<E> implements Iterable<E> {

    /**
     * parameter describes start length of array.
     */
    private int startLength = 8;
    /**
     * parameter describes pointer on last added element to array.
     */
    private int size = 0;
    /**
     * parameter array of elements of type E.
     */
    private E[] array = (E[]) new Object[startLength];

    /**
     * method add element to set.
     *
     * @param element is input element
     * @return true if input element has not been added to set earlier
     */
    public boolean add(E element) {

        if (duplicate(element)) {
            return false;
        }

        if (size < array.length - 1) {

            array[size++] = element;

        } else {

            array = growArray();

            array[size++] = element;

        }

        return true;

    }

    /**
     * method describes growth of array.
     *
     * @return new array with grow length
     */
    private E[] growArray() {

        E[] newArray = (E[]) new Object[array.length * 3 / 2 + 1];

        System.arraycopy(array, 0, newArray, 0, size);

        return newArray;

    }

    /**
     * method check array for duplicates.
     *
     * @param element is input element
     * @return true if input element has been added to set earlier
     */
    private boolean duplicate(E element) {

        boolean result = false;

        for (int count = 0; count <= size; count++) {

            if (element.equals(array[count])) {
                result = true;
            }

        }

        return result;

    }

    /**
     * method return iterator of set.
     *
     * @return iterator of set
     */
    @Override
    public Iterator<E> iterator() {
        return new SimpleSetIterator();
    }

    /**
     * inner class describes iterator.
     */
    private class SimpleSetIterator implements Iterator<E> {

        /**
         * parameter describes current pointer of iterator.
         */
        private int index = 0;

        /**
         * method check array have more elements.
         *
         * @return true if iterator can iterate array
         */
        @Override
        public boolean hasNext() {
            return index < size;
        }

        /**
         * method return element of array by index.
         *
         * @return element of array
         */
        @Override
        public E next() {

            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            return array[index++];

        }

    }

}