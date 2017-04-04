package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* This class tests RotateArray.
*
* @author Kucyh Vasily (mailto:basil135@mail.ru)
* @version $Id$
* @since 03.04.2017
*/
public class RotateArrayTest {

	/**
	* This method tests squared array with four length.
	*/
	@Test
	public void whenFourLengthArrayThenRotatedArray() {

		RotateArray rotateArray = new RotateArray();

		int[][] testArray = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
		int[][] expectedArray = {{13, 9, 5, 1}, {14, 10, 6, 2}, {15, 11, 7, 3}, {16, 12, 8, 4}};
		int[][] actualArray = rotateArray.rotate(testArray);

		assertThat(actualArray, is(expectedArray));

	}

	/**
	* This method tests squared array with three length.
	*/
	@Test
	public void whenThreeLengthArrayThenRotatedArray() {

		RotateArray rotateArray = new RotateArray();

		int[][] testArray = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		int[][] expectedArray = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
		int[][] actualArray = rotateArray.rotate(testArray);

		assertThat(actualArray, is(expectedArray));

	}

	/**
	* This method tests squared array with two length.
	*/
	@Test
	public void whenTwoLengthArrayThenRotatedArray() {

		RotateArray rotateArray = new RotateArray();

		int[][] testArray = {{1, 2}, {3, 4}};
		int[][] expectedArray = {{3, 1}, {4, 2}};
		int[][] actualArray = rotateArray.rotate(testArray);

		assertThat(actualArray, is(expectedArray));

	}

	/**
	* This method tests squared array with five length.
	*/
	@Test
	public void whenFiveLengthArrayThenRotatedArray() {

		RotateArray rotateArray = new RotateArray();

		int[][] testArray = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
		int[][] expectedArray = {{21, 16, 11, 6, 1}, {22, 17, 12, 7, 2}, {23, 18, 13, 8, 3}, {24, 19, 14, 9, 4}, {25, 20, 15, 10, 5}};
		int[][] actualArray = rotateArray.rotate(testArray);

		assertThat(actualArray, is(expectedArray));
	}

}
