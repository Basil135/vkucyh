package ru.job4j.pro.generic;

import java.util.Arrays;

/**
 * This class is simple array collection with generic type T.
 *
 * @param <T> is generic type
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 23.05.2017
 */
public class SimpleArray<T> {

    /**
     * parameter capacity is first capacity of array of elements.
     */
    private int capacity = 16;
    /**
     * parameter index is index of array.
     */
    private int index = 0;
    /**
     * parameter array of elements of Type T.
     */
    private T[] array = (T[]) new Object[capacity];

    /**
     * method return size of the collection.
     *
     * @return index
     */
    public int size() {
        return index;
    }

    /**
     * method add value to array.
     *
     * @param value is input value
     * @return return true
     */
    public boolean add(T value) {

        if (index < array.length) {
            array[index++] = value;
        } else {
            T[] newArray = (T[]) new Object[array.length * 3 / 2 + 1];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
            array[index++] = value;
        }

        return true;

    }

    /**
     * method update value by index.
     *
     * @param index is index of element we need to update
     * @param value is final value we updated
     * @return true if value was successfully updated
     */
    public boolean update(int index, T value) {

        boolean result = false;

        if (index < this.index && index >= 0) {
            this.array[index] = value;
        }

        return result;

    }

    /**
     * method remove element by index.
     *
     * @param index is index of element we need to remove
     * @return true if element was successfully removed
     */
    public boolean remove(int index) {

        boolean result = false;

        if (index < this.index && index >= 0) {
            System.arraycopy(this.array, index + 1, this.array, index, this.index - index);
            this.index--;
            result = true;
        }

        if (index == this.array.length - 1) {
            this.array[index--] = null;
        }

        return result;

    }

    /**
     * method remove value by value, if input value equals to value from array then this value will be removed.
     *
     * @param value is input value
     * @return true if value was successfully removed
     */
    public boolean remove(T value) {

        boolean result = false;

        for (int count = 0; count < this.index; count++) {
            if (this.array[count].equals(value)) {
                remove(count);
                result = true;
                break;
            }
        }

        return result;

    }

    /**
     * method return value by index.
     *
     * @param index is input index
     * @return element by index
     */
    public T get(int index) {

        T result = null;

        if (index < this.array.length && index >= 0) {
            result = array[index];
        }

        return result;

    }

    /**
     * method return array of type T.
     *
     * @param input is input array
     * @return array of type T
     */
    public T[] toArray(T[] input) {
        trimToSize();
        if (size() <= input.length) {
            System.arraycopy(this.array, 0, input, 0, this.array.length);
        } else {
            input = Arrays.copyOf(this.array, this.array.length, (Class<? extends T[]>) input.getClass());
        }
        return input;
    }

    /**
     * method return array of Object.
     *
     * @return array
     */
    public Object[] toArray() {
        return this.array;
    }

    /**
     * method cut array by index.
     */
    public void trimToSize() {
        T[] newArray = (T[]) new Object[this.index];
        System.arraycopy(this.array, 0, newArray, 0, index);
        this.array = newArray;
    }

}
