package ru.job4j.test;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* This class tests SubString class.
*
* @author Kucykh Vasily (mailto:basil135@mail.ru)
* @version $Id$
* @since 05.04.2017
*/
public class SubStringTest {

	/**
	* return true because input strings are identical.
	*/
	@Test
	public void whenOriginAndSubAreEqualsThenTrue() {

		SubString substr = new SubString();

		String origin = "Hello, my favorite language of programming is Java!";
		String sub = "Hello, my favorite language of programming is Java!";

		boolean expectedValue = true;
		boolean actualValue = substr.contains(origin, sub);

		assertThat(actualValue, is(expectedValue));

	}

	/**
	* return false because origin string does not contain substring.
	*/
	@Test
	public void whenOriginDoesNotContainSubThenFalse() {

		SubString substr = new SubString();

		String origin = "Hello, my favorite language of programming is Java!";
		String sub = "I hate pascal";

		boolean expectedValue = false;
		boolean actualValue = substr.contains(origin, sub);

		assertThat(actualValue, is(expectedValue));

	}

	/**
	* return false because origin string cannot contains substring.
	*/
	@Test
	public void whenOriginLengthIsLessThenSubLengthThenFalse() {

		SubString substr = new SubString();

		String origin = "I think, I can write in assembler";
		String sub = "I think, I can write in assembler. No it's just a joke";

		boolean expectedValue = false;
		boolean actualValue = substr.contains(origin, sub);

		assertThat(actualValue, is(expectedValue));

	}

	/**
	* return true because origin string contains substring.
	*/
	@Test
	public void whenOriginContainsSubThenTrue() {

		SubString substr = new SubString();

		String origin = "I know that, I don't know anything";
		String sub = "I don't know";

		boolean expectedValue = true;
		boolean actualValue = substr.contains(origin, sub);

		assertThat(actualValue, is(expectedValue));

	}

	/**
	* return false because origin string does not contain all substring.
	*/
	@Test
	public void whenOriginContainsPartOfTheSubThenFalse() {

		SubString substr = new SubString();

		String origin = "Someday I start learn brainFuck. That was horrible";
		String sub = "That was horrible, I thought that I will die.";

		boolean expectedValue = false;
		boolean actualValue = substr.contains(origin, sub);

		assertThat(actualValue, is(expectedValue));

	}

	/**
	* return false because one of the input strings is null.
	*/
	@Test
	public void whenOriginIsNullThenFalse() {

		SubString substr = new SubString();

		String origin = null;
		String sub = "I should stop do this";

		boolean expectedValue = false;
		boolean actualValue = substr.contains(origin, sub);

		assertThat(actualValue, is(expectedValue));

	}

	/**
	* return false because one of the input strings is null.
	*/
	@Test
	public void whenSubIsNullThenFalse() {

		SubString substr = new SubString();

		String origin = "I know that I must complete test";
		String sub = null;

		boolean expectedValue = false;
		boolean actualValue = substr.contains(origin, sub);

		assertThat(actualValue, is(expectedValue));

	}

	/**
	* return false because all of the input strings are null.
	*/
	@Test
	public void whenOriginIsNullAndSubIsNullThenFalse() {

		SubString substr = new SubString();

		String origin = null;
		String sub = null;

		boolean expectedValue = false;
		boolean actualValue = substr.contains(origin, sub);

		assertThat(actualValue, is(expectedValue));

	}

	/**
	* return true because input strings are identical.
	*/
	@Test
	public void whenOriginAndSubAreEqualsThenContainsHashIsTrue() {

		SubString substr = new SubString();

		String origin = "Hello, my favorite language of programming is Java!";
		String sub = "Hello, my favorite language of programming is Java!";

		boolean expectedValue = true;
		boolean actualValue = substr.containsHash(origin, sub);

		assertThat(actualValue, is(expectedValue));

	}

	/**
	* return false because origin string does not contain substring.
	*/
	@Test
	public void whenOriginDoesNotContainSubThenContainsHashIsFalse() {

		SubString substr = new SubString();

		String origin = "Hello, my favorite language of programming is Java!";
		String sub = "I hate pascal";

		boolean expectedValue = false;
		boolean actualValue = substr.containsHash(origin, sub);

		assertThat(actualValue, is(expectedValue));

	}

	/**
	* return false because origin string cannot contains substring.
	*/
	@Test
	public void whenOriginLengthIsLessThenSubLengthThenContainsHashIsFalse() {

		SubString substr = new SubString();

		String origin = "I think, I can write in assembler";
		String sub = "I think, I can write in assembler. No it's just a joke";

		boolean expectedValue = false;
		boolean actualValue = substr.containsHash(origin, sub);

		assertThat(actualValue, is(expectedValue));

	}

	/**
	* return true because origin string contains substring.
	*/
	@Test
	public void whenOriginContainsSubThenContainsHashIsTrue() {

		SubString substr = new SubString();

		String origin = "I know that, I don't know anything";
		String sub = "I don't know";

		boolean expectedValue = true;
		boolean actualValue = substr.containsHash(origin, sub);

		assertThat(actualValue, is(expectedValue));

	}

	/**
	* return false because origin string does not contain all substring.
	*/
	@Test
	public void whenOriginContainsPartOfTheSubThenContainsHashIsFalse() {

		SubString substr = new SubString();

		String origin = "Someday I start learn brainFuck. That was horrible";
		String sub = "That was horrible, I thought that I will die.";

		boolean expectedValue = false;
		boolean actualValue = substr.containsHash(origin, sub);

		assertThat(actualValue, is(expectedValue));

	}

	/**
	* return false because one of the input strings is null.
	*/
	@Test
	public void whenOriginIsNullThenContainsHashIsFalse() {

		SubString substr = new SubString();

		String origin = null;
		String sub = "I should stop do this";

		boolean expectedValue = false;
		boolean actualValue = substr.containsHash(origin, sub);

		assertThat(actualValue, is(expectedValue));

	}

	/**
	* return false because one of the input strings is null.
	*/
	@Test
	public void whenSubIsNullThenContainsHashIsFalse() {

		SubString substr = new SubString();

		String origin = "I know that I must complete test";
		String sub = null;

		boolean expectedValue = false;
		boolean actualValue = substr.containsHash(origin, sub);

		assertThat(actualValue, is(expectedValue));

	}

	/**
	* return false because all of the input strings are null.
	*/
	@Test
	public void whenOriginIsNullAndSubIsNullThenContainsHashIsFalse() {

		SubString substr = new SubString();

		String origin = null;
		String sub = null;

		boolean expectedValue = false;
		boolean actualValue = substr.containsHash(origin, sub);

		assertThat(actualValue, is(expectedValue));

	}

}
