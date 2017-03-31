package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test for class Point.
*
* @author Kucyh Vasily (mailto:basil135@mail.ru)
* @version $Id$
* @since 31.03.2017
*/
public class PointTest {

	/**
	* Test when return true.
	*/
	@Test
	public void whenTrueThenTrue() {

		boolean expectedValue;
		boolean actualValue;

		Point point = new Point(0, 2);

		expectedValue = true;
		actualValue = point.is(3, 2);

		assertThat(expectedValue, is(actualValue));

	}

	/**
	* Test when return false.
	*/
	@Test
	public void whenFalseThenFalse() {

		boolean expectedValue;
		boolean actualValue;

		Point point = new Point(3, 1);

		expectedValue = false;
		actualValue = point.is(1, 1);

		assertThat(expectedValue, is(actualValue));

	}

}
