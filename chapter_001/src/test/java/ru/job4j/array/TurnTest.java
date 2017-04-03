package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* This class tests class Turn.
*
* @author Kucyh Vasily (mailto:basil135@mail.ru)
* @version $Id$
* @since 03.04.2017
*/
public class TurnTest {

	/**
	* This method tests an array 1, 2, 3, 4, 5 and return 5, 4, 3, 2, 1.
	*/
	@Test
	public void whenConsistentlyFromOneToFiveThenFromFiveToOne() {

		Turn turn = new Turn();

		int[] testValue = {1, 2, 3, 4, 5};
		int[] expectedValue = {5, 4, 3, 2, 1};
		int[] actualValue = turn.back(testValue);

		assertThat(actualValue, is(expectedValue));

	}

	/**
	* This method tests an array 4, 1, 6, 2 and return 2, 6, 1, 4.
	*/
	@Test
	public void whenArrayIsFourOneSixTwoThenTwoSixOneFour() {

		Turn turn = new Turn();

		int[] testValue = {4, 1, 6, 2};
		int[] expectedValue = {2, 6, 1, 4};
		int[] actualValue = turn.back(testValue);

		assertThat(actualValue, is(expectedValue));

	}

}
