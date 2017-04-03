package ru.job4j.array;

/**
* Class BubbleSort implements bubble sort.
*
* @author Kucyh Vasily (mailto:basil135@mail.ru)
* @version $Id$
* @since 03.04.2017
*/
public class BubbleSort {

	/**
	* Method sort.
	*
	* @param array is input array
	* @return sorted array
	*/
	public int[] sort(int[] array) {

		int temp;

		for (int i = array.length; i > 0; i--) {

			for (int j = 1; j < i; j++) {

				if (array[j - 1] > array[j]) {

					temp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = temp;

				}

			}

		}

		return array;

	}

}
