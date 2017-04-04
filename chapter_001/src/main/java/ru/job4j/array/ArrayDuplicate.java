package ru.job4j.array;

import java.util.Arrays;

/**
* This class deletes all duplicates from an array.
*
* @author Kucyh Vasily (mailto:basil135@mail.ru)
* @version $Id$
* @since 04.04.2017
*/
public class ArrayDuplicate {

	/**
	* This method return an array without duplicates.
	*
	* @param array that input
	* @return array withot duplicates
	*/
	public String[] remove(String[] array) {

		int size = array.length;
		String temp;
		int countDuplicates = 0;

		for (int i = 0; i < size - countDuplicates; i++) {

			for (int j = size - countDuplicates - 1; j > i; j--) {

				if (array[i].equals(array[j])) {

					temp = array[j];

					for (int shift = j; shift < size - countDuplicates - 1; shift++) {
						array[shift] = array[shift + 1];
					}

					array[size - countDuplicates - 1] = temp;
					countDuplicates++;

				}

			}

		}

		return Arrays.copyOf(array, size - countDuplicates);

	}

}
