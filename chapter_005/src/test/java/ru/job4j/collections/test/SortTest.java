package ru.job4j.collections.test;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * This class tests class Sort.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 17.05.2017
 */
public class SortTest {

    /**
     * method tests input array will be right refactor and sort by ascending order.
     */
    @Test
    public void whenInputArrayOfStringSortByAscendingOrderThenRightArray() {

        Sort sort = new Sort();

        String[] testArray = {"K1", "K1\\S1\\SS1", "K2\\S1\\SS1", "K1\\S2"};
        String[] expectedArray = {"K1", "K1\\S1", "K1\\S1\\SS1", "K1\\S2", "K2", "K2\\S1", "K2\\S1\\SS1"};
        String[] actualArray = sort.sortArray(testArray, Sort.Order.asc);

        assertThat(actualArray, is(expectedArray));

    }

    /**
     * method tests input array will be right refactor and sort by descending order.
     */
    @Test
    public void whenInputArrayOfStringSortByDescendingOrderThenRightArray() {

        Sort sort = new Sort();

        String[] testArray = {"K1", "K1\\S1\\SS1", "K2\\S1\\SS1", "K1\\S2"};
        String[] expectedArray = {"K2", "K2\\S1", "K2\\S1\\SS1", "K1", "K1\\S2", "K1\\S1", "K1\\S1\\SS1"};
        String[] actualArray = sort.sortArray(testArray, Sort.Order.desc);

        assertThat(actualArray, is(expectedArray));

    }

}
