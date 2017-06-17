package ru.job4j.pro.set;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertThat;

import static org.hamcrest.core.Is.is;

/**
 * This class tests SimpleLinkedSet class.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 17.06.2017
 */
public class SimpleLinkedSetTest {

    /**
     * method tests set of Integer.
     */
    @Test
    public void whenAddTwentyIntegersToSetThenAllElementsAreSortInSetIgnoringDuplicates() {

        SimpleLinkedSet<Integer> set = new SimpleLinkedSet<>();

        Integer[] testArray = {2, 1, 5, 5, 2, 14, 6, 9, 12, 53, 12, 7, 31, 2, 17, 56, 14, 92, 44, 15};

        for (Integer num : testArray) {
            set.add(num);
        }

        Integer[] expectedArray = {1, 2, 5, 6, 7, 9, 12, 14, 15, 17, 31, 44, 53, 56, 92};

        Integer[] actualArray = new Integer[15];

        Iterator<Integer> iter = set.iterator();

        int index = 0;

        while (iter.hasNext()) {
            actualArray[index++] = iter.next();
        }

        assertThat(actualArray, is(expectedArray));

    }

    /**
     * method tests set of strings.
     */
    @Test
    public void whenAddTwentyStringsToSetThenAllElementsAreSortInSetIgnoringDuplicates() {

        SimpleLinkedSet<String> set = new SimpleLinkedSet<>();

        String[] testArray = {"2", "1", "5", "5", "2", "14", "6", "9", "12", "53", "12", "7", "31", "2", "17", "56", "14", "92", "44", "15"};

        for (String str : testArray) {
            set.add(str);
        }

        String[] expectedArray = {"1", "2", "5", "6", "7", "9", "12", "14", "15", "17", "31", "44", "53", "56", "92"};

        String[] actualArray = new String[15];

        Iterator<String> iter = set.iterator();

        int index = 0;

        while (iter.hasNext()) {
            actualArray[index++] = iter.next();
        }

        assertThat(actualArray, is(expectedArray));

    }

}
