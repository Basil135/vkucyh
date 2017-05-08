package ru.job4j.collections.convert;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * This class is test class of Convert class.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 07.05.2017
 */
public class ConvertTest {

    /**
     * method tests double array convert to list of integers.
     */
    @Test
    public void whenArrayToListThenWrightList() {

        Convert convert = new Convert();

        int[][] testArray = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        List<Integer> expectedList = new ArrayList<>();
        List<Integer> actualList = convert.toList(testArray);

        for (int count = 1; count < 10; count++) {
            expectedList.add(count);
        }

        assertThat(actualList, is(expectedList));

    }

    /**
     * method tests that list of seven integers convert to double array of integers with three rows.
     */
    @Test
    public void whenListOfSevenIntegersThenDoubleArrayOfNineIntegersInThreeRows() {

        Convert convert = new Convert();

        List<Integer> testList = new ArrayList<>();

        for (int count = 1; count < 8; count++) {
            testList.add(count);
        }

        int[][] expectedArray = {{1, 2, 3}, {4, 5, 6}, {7, 0, 0}};
        int[][] actualArray = convert.toArray(testList, 3);

        assertThat(actualArray, is(expectedArray));

    }

    /**
     * method tests that list of fifteen integers convert to double array of integers with four rows.
     */
    @Test
    public void whenListOfFifteenIntegersThenSixteenIntegersInFourRows() {

        Convert convert = new Convert();

        List<Integer> testList = new ArrayList<>();

        for (int count = 1; count < 16; count++) {
            testList.add(count);
        }

        int[][] expectedArray = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 0}};
        int[][] actualArray = convert.toArray(testList, 4);

        assertThat(actualArray, is(expectedArray));

    }

}
