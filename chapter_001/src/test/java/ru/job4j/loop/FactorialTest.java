package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* This class test Factorial.
*
* @author Kucyh Vasily (mailto:basil135@mail.ru)
* @version $Id$
* @since 02.04.2017
*/
public class FactorialTest {

	/**
	* This method test factorial of zero.
	*/
	@Test
	public void whenFactorialZeroThenOne() {

		Factorial fac = new Factorial();

		int expectedValue = 1;
		int actualValue = fac.calc(0);

		assertThat(expectedValue, is(actualValue));

	}

	/**
	* This metho test factorial of five.
	*/
	@Test
	public void whenFactorialFiveThenOneHundredTwenty() {

		Factorial fac = new Factorial();

		int expectedValue = 120;
		int actualValue = fac.calc(5);

		assertThat(expectedValue, is(actualValue));

	}

}
