package ru.job4j.test;

/**
* This class merge two arrays.
*
* @author Kucykh Vasily (mailto:basil135@mail.ru)
* @version $Id$
* @since 04.04.2017
*/
public class Merge {

	/**
	* This method merge two arrays and return an array.
	*
	* @param firstArray ia one of two input array
	* @param secondArray is second array of two input array
	* @return an array of merge
	*/
	public int[] merge(int[] firstArray, int[] secondArray) {

		int length = firstArray.length + secondArray.length;
		int pointerOfFirstArray = 0;
		int pointerOfSecondArray = 0;

		int[] result = new int[length];

		for (int counter = 0; counter < length; counter++) {

			if (pointerOfFirstArray < firstArray.length && pointerOfSecondArray < secondArray.length) {

				if (firstArray[pointerOfFirstArray] < secondArray[pointerOfSecondArray]) {

					result[counter] = firstArray[pointerOfFirstArray++];

				} else {

					result[counter] = secondArray[pointerOfSecondArray++];

				}

			} else {

				if (pointerOfFirstArray >= firstArray.length) {

					result[counter] = secondArray[pointerOfSecondArray++];

				} else {

					result[counter] = firstArray[pointerOfFirstArray++];

				}

			}

		}

		return result;

	}

}
