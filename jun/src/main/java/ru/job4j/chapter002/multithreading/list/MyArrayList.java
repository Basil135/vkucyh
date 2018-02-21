package ru.job4j.chapter002.multithreading.list;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class describes thread safe arrayList collection.
 *
 * @author Kutsykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 21.02.2018
 *
 * @param <E> is generic type
 */
@ThreadSafe
public class MyArrayList<E> implements MyList<E> {
    /**
     * parameter size of the collection.
     */
    @GuardedBy("this")
    private int size = 0;
    /**
     * parameter start capacity describes start capacity of the collection.
     */
    private int capacity;
    /**
     * parameter describes multшplier of the length old array.
     */
    private double  multiplier;
    /**
     * parameter array of the objects to store the data.
     */
    @GuardedBy("this")
    private Object[] array;

    /**
     * method resize the array to new length.
     */
    private synchronized void resize() {
        Double length = array.length * multiplier;
        Object[] newArray = new Object[new BigDecimal(length).intValue()];
        System.arraycopy(array, 0, newArray, 0, array.length);
        this.array = newArray;
    }

    /**
     * constructor of this class.
     */
    public MyArrayList() {
        this.capacity = 8;
        this.multiplier = 1.5;
        this.array = new Object[capacity];
    }

    /**
     * constructor of this class.
     *
     * @param capacity is input capacity
     * @param multyplier is input multiplier
     */
    public MyArrayList(final int capacity, final double multyplier) {
        this.capacity = capacity;
        this.multiplier = multyplier;
        this.array = new Object[capacity];
    }

    /**
     * method add the element e to the collection.
     *
     * @param e is input element
     * @return true if e is successfully added
     */
    @Override
    public synchronized boolean add(E e) {
        if (size < this.array.length) {
            array[size++] = e;
        } else {
            resize();
            add(e);
        }
        return true;
    }

    /**
     * method add the element e to the collection by the index.
     *
     * @param index is integer number describes position at the collection
     * @param e is input element
     * @return true if e successfully added
     */
    @Override
    public synchronized boolean add(int index, E e) {
        if (index < this.array.length && index > -1) {
            if (size >= array.length) {
                resize();
            }
            System.arraycopy(array, index, array, index + 1, size - index);
            size++;
            array[index] = e;
            return true;
        } else {
            return false;
        }
    }

    /**
     * method delete element e from the collection.
     *
     * @param e is input element we need to delete
     * @return true if element e successfully deleted
     */
    @Override
    public synchronized boolean delete(E e) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(e)) {
                return delete(i);
            }
        }
        return false;
    }

    /**
     * method delete element from collection by the index.
     *
     * @param index is input index we need to delete
     * @return true if element successfully deleted
     */
    @Override
    public synchronized boolean delete(int index) {
        if (index > -1 && index < size) {
            if (index == size - 1) {
                array[index] = null;
                size--;
                return true;
            }
            int length = size - index;
            System.arraycopy(array, index + 1, array, index, length);
            size--;
            array[array.length - 1] = null;
            return true;
        } else {
            return false;
        }
    }

    /**
     * method get element from the collection by the index.
     *
     * @param index is input index
     * @return element
     */
    @Override
    public synchronized E get(int index) {
        if (index < size && index > -1) {
            return (E) array[index];
        }
        throw new IndexOutOfBoundsException();
    }

    /**
     * method return size of the collection.
     *
     * @return size of the collection
     */
    @Override
    public synchronized int size() {
        return this.size;
    }

    /**
     * method return iterator of the collection.
     *
     * @return iterator of the collection
     */
    @Override
    public synchronized Iterator<E> iterator() {
        return new MyIterator<>();
    }

    /**
     * method return collection as array.
     *
     * @return array
     */
    @Override
    public Object[] toArray() {
        return Arrays.copyOf(array, size);
    }

    /**
     * This inner non static class describes iterator of the collection.
     *
     * @param <E> is generic type
     */
    private class MyIterator<E> implements Iterator<E> {
        /**
         * parameter index is current index of the iterator.
         */
        @GuardedBy("this")
        private int index = 0;

        /**
         * method return true if iterator have more elements.
         *
         * @return true if iterator have more elements
         */
        @Override
        public synchronized boolean hasNext() {
            return index < size;
        }

        /**
         * method return current element of the collection.
         *
         * @return current element
         */
        @Override
        public synchronized E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return (E) array[index++];
        }
    }
}
