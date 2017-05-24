package ru.job4j.pro.iterator.even;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * This class tests EvenIterator class.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 23.05.2017
 */
public class EvenIteratorTest {

    /**
     * method tests array have two even numbers.
     */
    @Test
    public void whenArrayHaveTwoEvenNumbersThenReturnTwoNumbers() {

        int index = 0;

        int[] testArray = {1, 3, 2, 8, 5, 9, 7};

        EvenIterator iterator = new EvenIterator(testArray);

        int[] expectedArray = {2, 8};
        int[] actualArray = new int[2];

        while (iterator.hasNext()) {
            actualArray[index++] = iterator.next();
        }

        assertThat(actualArray, is(expectedArray));

    }

    /**
     * method tests an array have zero even numbers.
     */
    @Test
    public void whenArrayHaveNoEvenNumbersThenReturnNullArray() {

        int[] testArray = {1, 3, 13, 15, 5, 9, 7};

        EvenIterator iterator = new EvenIterator(testArray);

        List<Integer> expectedList = new ArrayList<>();
        List<Integer> actualList = new ArrayList<>();

        while (iterator.hasNext()) {
            actualList.add(iterator.next());
        }

        assertThat(actualList, is(expectedList));

    }

}