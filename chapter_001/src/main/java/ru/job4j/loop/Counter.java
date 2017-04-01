package ru.job4j.loop;

/**
* This class demonstrate loops.
*
* @author Kucyh Vasily (mailto:basil135@mail.ru)
* @version $Id$
* @since 02.04.2017
*/
public class Counter {

	/**
	* Method add return sum of all even numbers from start to finish.
	*
	* @param start is a start of the loop
	* @param finish is a finish of the loop
	* @return sum of all even numbers of loop from start to finish
	*/
	public int add(final int start, final int finish) {

		int result = 0;

		for (int count = start; count <= finish; count++) {

			if (count % 2 == 0) {
				result += count;
			}

		}

		return result;

	}

}
