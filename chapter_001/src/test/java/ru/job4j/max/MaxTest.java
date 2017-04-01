package ru.job4j.max;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
*Test Max class.
*
* @author Kucyh Vasily (mailto:basil135@mail.ru)
* @version $Id$
* @since 31.03.2017
*/
public class MaxTest {

	/**
	* The method returns the second number, because numbers identical.
	*/
	@Test
	public void whenMaxTwoAndTwoThenTwo() {

		final int expectedValue;
		final int actualValue;

		Max max = new Max();

		expectedValue = 2;
		actualValue = max.max(2, 2);

		assertThat(expectedValue, is(actualValue));

	}

	/**
	* The method returns the most large number from two numbers, where the second number is large then first.
	*/
	@Test
	public void whenMaxTwoAndFourThenFour() {

		final int expectedValue;
		final int actualValue;

		Max max = new Max();

		expectedValue = 4;
		actualValue = max.max(2, 4);

		assertThat(expectedValue, is(actualValue));

	}

	/**
	* The method returns the most large number from two numbers, where the first number is large then second.
	*/
	@Test
	public void whenFourAndTwoThenFour() {

		final int expectedValue;
		final int actualValue;

		Max max = new Max();

		expectedValue = 4;
		actualValue = max.max(4, 2);

		assertThat(expectedValue, is(actualValue));

	}

	/**
	* The method return the largest value from three numbers.
	*/
	public void whenOneAndTwoAndThreeThenThree() {

		final int expectedValue;
		final int actualValue;

		Max max = new Max();

		expectedValue = 3;
		actualValue = max.max(1, 2, 3);

		assertThat(expectedValue, is(actualValue));

	}
}
