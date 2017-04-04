package ru.job4j.array;

/**
* This class rotates an array.
*
* @author Kucyh Vasily (mailto:basil135@mail.ru)
* @version $Id$
* @since 03.04.2017
*/
public class RotateArray {

	/**
	* This method rotates an array.
	*
	* @param array is the input array
	* @return rotated array
	*/
	public int[][] rotate(int[][] array) {

		int temp;
		int size;

		for (int i = 0; i < array.length / 2; i++) {

			size = array.length - i - 1;

			for (int j = i; j < array.length - i - 1; j++) {

					temp = array[i][j];
					array[i][j] = array[size][i];
					array[size][i] = array[array.length - i - 1][size];
					array[array.length - i - 1][size] = array[j][array.length - i - 1];
					array[j][array.length - i - 1] = temp;
					size--;

			}

		}

		return array;

	}

}
