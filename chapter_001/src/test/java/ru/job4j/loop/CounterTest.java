package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* This class test Counter class.
*
* @author Kucyh Vasily (mailto:basil135@mail.ru)
* @version $Id$
* @since 02.04.2017
*/
public class CounterTest {

	/**
	* This method add even numbers from one to ten.
	*/
	@Test
	public void whenFromOneToTenThenThirty() {

		Counter counter = new Counter();

		int expectedValue = 30;
		int actualValue = counter.add(1, 10);

		assertThat(expectedValue, is(actualValue));

	}

}
