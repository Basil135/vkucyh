package ru.job4j.pro.iterator.array;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * This class tests ArrayIterator class.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 23.05.2017
 */
public class ArrayIteratorTest {

    /**
     * method tests Iterator of double array.
     */
    @Test
    public void whenDoubleArrayIterateThenRightIterator() {

        Integer[][] testArray = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        ArrayIterator arrayIterator = new ArrayIterator(testArray);

        int index = 0;

        int[] expectedValue = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] actualValue = new int[9];

        while (arrayIterator.hasNext()) {
            actualValue[index++] = arrayIterator.next();
        }

        assertThat(actualValue, is(expectedValue));

    }

}
