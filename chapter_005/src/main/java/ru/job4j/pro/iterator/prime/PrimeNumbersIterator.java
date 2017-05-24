package ru.job4j.pro.iterator.prime;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class describes iterator of prime numbers in the array.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 */
public class PrimeNumbersIterator implements Iterator<Integer> {
    /**
     * parameter array is array of numbers.
     */
    private final int[] array;
    /**
     * is index at the aray.
     */
    private int index = 0;

    /**
     * constructor of this class.
     *
     * @param array is input array
     */
    public PrimeNumbersIterator(final int[] array) {
        this.array = array;
    }

    /**
     * method return true if array contains another prime numbers.
     *
     * @return true if another prime numbers exist
     */
    @Override
    public boolean hasNext() {

        boolean result = false;

        while (!result && index < array.length) {

            if (prime(array[index])) {
                result = true;
            } else {
                index++;
            }

        }

        return result;

    }

    /**
     * method return Integer number.
     *
     * @return Integer number
     */
    @Override
    public Integer next() {

        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        return array[index++];

    }

    /**
     * method tests integer number input to prime number.
     *
     * @param input is input integer number
     * @return true if input value is prime number
     */
    private boolean prime(final int input) {

        boolean result = true;

        if (input == 1 || input == 2) {
            return true;
        }

        for (int count = 2; count < input; count++) {
            if (input % count == 0) {
                result = false;
                break;
            }
        }

        return result;

    }

}
