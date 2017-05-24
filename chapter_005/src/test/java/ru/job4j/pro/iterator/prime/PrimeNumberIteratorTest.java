package ru.job4j.pro.iterator.prime;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * This class tests PrimeNumberIterator class.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 23.05.2017
 */
public class PrimeNumberIteratorTest {

    /**
     * method tests array have five prime numbers.
     */
    @Test
    public void whenArrayHaveFivePrimeNumbersThenReturnFiveNumbers() {

        int[] testArray = {1, 2, 3, 4, 5, 6, 7, 8};

        PrimeNumbersIterator iterator = new PrimeNumbersIterator(testArray);

        List<Integer> expectedList = new ArrayList<>();
        List<Integer> actualList = new ArrayList<>();

        expectedList.add(1);
        expectedList.add(2);
        expectedList.add(3);
        expectedList.add(5);
        expectedList.add(7);

        while (iterator.hasNext()) {
            actualList.add(iterator.next());
        }

        assertThat(actualList, is(expectedList));

    }

}
