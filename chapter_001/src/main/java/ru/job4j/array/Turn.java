package ru.job4j.array;

/**
* This class have a metho turn back an array.
*
* @author Kucyh Vasily (mailto:basil135@mail.ru)
* @version $Id$
* @since 03.04.2017
*/
public class Turn {

	/**
	* this method turn back an array.
	*
	* @param array is an array that should be turn back
	* @return result is the result of turned back array
	*/
	public int[] back(int[] array) {

		int temp;

		for (int count = 0; count < array.length / 2; count++) {

			temp = array[count];
			array[count] = array[array.length - 1 - count];
			array[array.length - 1 - count] = temp;

		}

		return array;

	}

}
