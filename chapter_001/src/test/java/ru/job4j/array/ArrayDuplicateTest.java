package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* This class tests ArrayDuplicate class.
*
* @author Kucyh Vasily (mailto:basil135@mail.ru)
* @version $Id$
* @since 04.04.2017
*/
public class ArrayDuplicateTest {

	/**
	* This method tests array without duplicates.
	*/
	@Test
	public void whenArrayWithNoDuplicateThenReturnArray() {

		ArrayDuplicate ad = new ArrayDuplicate();

		String[] testArray = {"hello", "My name", "just wait", "no no no", "oh my god", "yes"};
		String[] expectedArray = {"hello", "My name", "just wait", "no no no", "oh my god", "yes"};
		String[] actualArray = ad.remove(testArray);

		assertThat(actualArray, is(expectedArray));

	}

	/**
	* This method test array that have one word and many dulpicates of it.
	*/
	@Test
	public void whenInputArrayHaveJustDuplicaateValuesThenReturnOneStringArray() {

		ArrayDuplicate ad = new ArrayDuplicate();

		String[] testArray = {"java", "java", "java", "java", "java", "java"};
		String[] expectedArray = {"java"};
		String[] actualArray = ad.remove(testArray);

		assertThat(actualArray, is(expectedArray));

	}

	/**
	* This method tests array that have a few duplicates.
	*/
	@Test
	public void whenInputArrayHaveAFiewDuplicateThenReturnArrayWithoutDuplicates() {

		ArrayDuplicate ad = new ArrayDuplicate();

		String[] testArray = {"hello", "java", "hello", "count", "dog and cat", "hello"};
		String[] expectedArray = {"hello", "java", "count", "dog and cat"};
		String[] actualArray = ad.remove(testArray);

		assertThat(actualArray, is(expectedArray));

	}

	/**
	* This method tests array contains of just one word.
	*/
	public void whenArrayHaveOneWordThenOneWord() {

		ArrayDuplicate ad = new ArrayDuplicate();

		String[] testArray = {"test"};
		String[] expectedArray = {"test"};
		String[] actualArray = ad.remove(testArray);

		assertThat(actualArray, is(expectedArray));

	}

	/**
	* This method test empty array.
	*/
	public void whenEmptyArrayThenEmptyArray() {

		ArrayDuplicate ad = new ArrayDuplicate();

		String[] testArray = {};
		String[] expectedArray = {};
		String[] actualArray = ad.remove(testArray);

		assertThat(actualArray, is(expectedArray));

	}

}
