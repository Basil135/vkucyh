package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

/**
* This class is test for class Triangle.
*
* @author Kucyh Vasily (mailto:basil135@mail.ru)
* @version $Id$
* @since 01.04.2017
*/
public class TriangleTest {

	/**
	* This method is not calculate the area of triangle, because the triangle does not exist, result set negative one.
	*/
	@Test
	public void whenTriangleDoesNotExistThenNegativeOne() {

		Triangle triangle = new Triangle(new Point(2, 2), new Point(2, 2), new Point(2, 2));

		double expectedValue = -1D;
		double actualValue = triangle.area();

		assertThat(actualValue, is(expectedValue));

	}

	/**
	* This method is calculate the area of triangle.
	*/
	@Test
	public void whenTriangleExistThenAreaIsSet() {

		Triangle triangle = new Triangle(new Point(1, 2), new Point(1, 4), new Point(3, 4));

		double expectedValue = 2D;
		double actualValue = triangle.area();

		assertThat(actualValue, closeTo(expectedValue, 0.01));

	}

}
