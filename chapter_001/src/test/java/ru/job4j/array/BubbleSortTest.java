package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* This class tests BubbleSort class.
*
* @author Kucyh Vasily (mailto:basil135@mail.ru)
* @version $Id$
* @since 03.04.2017
*/
public class BubbleSortTest {

	/**
	* This method sorts array.
	*/
	@Test
	public void whenUnsortedArrayThenSortedArray() {

		BubbleSort sort = new BubbleSort();

		int[] testArray = {5, 4, 3, 2, 1};
		int[] expectedArray = {1, 2, 3, 4, 5};
		int[] actualArray = sort.sort(testArray);

		assertThat(actualArray, is(expectedArray));

	}

}
