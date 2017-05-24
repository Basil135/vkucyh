package ru.job4j.pro.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class describes collection ArrayList.
 *
 * @param <E> is generic type
 */
public class ArrayList<E> implements Iterable<E> {

    /**
     * parameter capacity is start capacity of arrayElements array.
     */
    private int capacity = 16;
    /**
     * parameter size is size of collection.
     */
    private int size = 0;
    /**
     * parameter arrayElement is array of Objects.
     */
    private Object[] arrayElements = new Object[capacity];

    /**
     * method add element to array.
     *
     * @param element is input element
     * @return true
     */
    public boolean add(E element) {

        if (this.size < this.arrayElements.length) {
            this.arrayElements[this.size++] = element;
        } else {
            Object[] newArrayElements = new Object[this.arrayElements.length * 3 / 2 + 1];
            System.arraycopy(this.arrayElements, 0, newArrayElements, 0, this.size);
            this.arrayElements = newArrayElements;
            this.arrayElements[this.size++] = element;
        }

        return true;
    }

    /**
     * method get element from array by index.
     *
     * @param index is input number
     * @return element
     */
    public E get(int index) {
        return (E) this.arrayElements[index];
    }

    /**
     * method return iterator as instance of ArrayIterator class.
     *
     * @return iterator
     */
    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator();
    }

    /**
     * this class describes iterator of array.
     */
    private class ArrayIterator implements Iterator<E> {

        /**
         * parameter index is current element of iterator.
         */
        private int index = 0;

        /**
         * method return true if iterator have more elements.
         *
         * @return
         */
        @Override
        public boolean hasNext() {
            return this.index < size;
        }

        /**
         * method return this index element of array and increase index.
         *
         * @return index element of array
         */
        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return (E) arrayElements[index++];
        }

    }

}