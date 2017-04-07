package ru.job4j.test;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* This class tests Merge class.
*
* @author Kucykh Vasily (mailto:basil135@mail.ru)
* @version $Id$
* @since 04.04.2017
*/
public class MergeTest {

	/**
	* This method tests when two arrays same length.
	*/
	@Test
	public void whenTwoInputArraysWithTheSameLengthThenArrayWithDoubleLength() {

		Merge merge = new Merge();

		int[] firstArray = {0, 2, 4, 6, 8};
		int[] secondArray = {1, 3, 5, 7, 9};
		int[] expectedArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] actualArray = merge.merge(firstArray, secondArray);

		assertThat(actualArray, is(expectedArray));

	}

	/**
	* This method tests two same arrays.
	*/
	@Test
	public void whenTwoArraysWithTheSameElementsThenCorrectArray() {

		Merge merge = new Merge();

		int[] array = {1, 2, 3};
		int[] expectedArray = {1, 1, 2, 2, 3, 3};
		int[] actualArray = merge.merge(array, array);

		assertThat(actualArray, is(expectedArray));

	}

	/**
	* This method tests when first array's length is greater than second's.
	*/
	@Test
	public void whenTheFirstArrayIsGreaterThanTheSecondArrayThenCorrectArray() {

		Merge merge = new Merge();

		int[] firstArray = {1, 5, 9};
		int[] secondArray = {2, 4, 6, 7, 22, 43};
		int[] expectedArray = {1, 2, 4, 5, 6, 7, 9, 22, 43};
		int[] actualArray = merge.merge(firstArray, secondArray);

		assertThat(actualArray, is(expectedArray));

	}

	/**
	* This method tests when the second array's length is greater than first's.
	*/
	@Test
	public void whenTheSecondArrayIsGreaterThanTheFirstArrayThenCorrectArray() {

		Merge merge = new Merge();

		int[] firstArray = {1, 5, 7, 12, 15, 23, 78};
		int[] secondArray = {2, 76, 99};
		int[] expectedArray = {1, 2, 5, 7, 12, 15, 23, 76, 78, 99};
		int[] actualArray = merge.merge(firstArray, secondArray);

		assertThat(actualArray, is(expectedArray));

	}

}
