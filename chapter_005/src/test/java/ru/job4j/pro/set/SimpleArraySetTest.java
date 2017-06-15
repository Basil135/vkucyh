package ru.job4j.pro.set;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;


/**
 * This class uses for test class SimpleArraySet.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 15.06.2017
 */
public class SimpleArraySetTest {

    /**
     * method tests add to set twenty numbers without duplicate.
     */
    @Test
    public void whenAddTwentyDigitsToSetThenIteratorReturnThem() {

        SimpleArraySet<Integer> set = new SimpleArraySet<>();

        Integer[] testArray = {1, 2, 3, 4, 5, 6, 7, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 7};
        Integer[] expectedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        Integer[] actualArray = new Integer[20];

        for (Integer digit : testArray) {
            set.add(digit);
        }

        Iterator<Integer> it = set.iterator();

        int count = 0;

        while (it.hasNext()) {
            actualArray[count++] = it.next();
        }

        assertThat(actualArray, is(expectedArray));

    }

}
