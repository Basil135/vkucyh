package ru.job4j.max;

/**
* Class max for find maximum value.
*
* @author Kucyh Vasily (mailto:basil135@mail.ru)
* @version $Id$
* @since 31.03.2017
*/
public class Max {

	/**
	* Method return max value.
	*
	* @param first is the first integer number
	* @param second is the second integer number
	* @return integer that is maximum from two numbers
	*/
	public int max(final int first, final int second) {
		return first > second ? first : second;
	}

	/**
	* This method return maximum number from three numbers.
	*
	* @param first is the first number
	* @param second is the second number
	* @param third is the third number
	* @return maximum value
	*/
	public int max(final int first, final int second, final int third) {
		return max(max(first, second), third);
	}

}
