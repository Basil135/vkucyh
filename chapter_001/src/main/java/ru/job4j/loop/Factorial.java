package ru.job4j.loop;

/**
* This class calculates factorial.
*
* @author Kucyh Vasily (mailto:basil135@mail.ru)
* @version $Id$
* @since 02.04.2017
*/
public class Factorial {

	/**
	* This method calculates factorial.
	*
	* @param n is integer
	* @return result is factorial of n
	*/
	public int calc(final int n) {

		int result = 1;

		if (n > 1) {

			for (int count = 1; count <= n; count++) {
				result *= count;
			}

		}

		return result;

	}

}
