package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* This class tests class Piant.
*
* @author Kucyh Vasily (mailto:basil135@mail.ru)
* @version $Id$
* @since 02.04.2017
*/
public class PaintTest {

	/**
	* This method tests piramid with two rows.
	*/
	@Test
	public void whenPiramidWithHeightTwoThenStringWithTwoRows() {

		Paint paint = new Paint();

		String expectedValue = String.format(" ^ %s^^^", System.getProperty("line.separator"));
		String actualValue = paint.piramid(2);

		assertThat(actualValue, is(expectedValue));

	}

	/**
	* This method tests piramid with three rows.
	*/
	@Test
	public void whenPiramidWithHeightThreeThenStringWithThreeRows() {

		Paint paint = new Paint();

		String expectedValue = String.format("  ^  %s ^^^ %s^^^^^", System.getProperty("line.separator"), System.getProperty("line.separator"));
		String actualValue = paint.piramid(3);

		assertThat(actualValue, is(expectedValue));

	}

}
