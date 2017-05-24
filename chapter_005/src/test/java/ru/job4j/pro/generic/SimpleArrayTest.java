package ru.job4j.pro.generic;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * This class tests simpleArray class.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 23.05.2017
 */
public class SimpleArrayTest {

    /**
     * method tests all operations of class SimpleArray.
     */
    @Test
    public void whenDoAllOperationOfSimpleArrayThenExpectedArray() {

        SimpleArray<String> stringSimpleArray = new SimpleArray<>();

        stringSimpleArray.add("hello");
        stringSimpleArray.add("hello");
        stringSimpleArray.add("qwerty");
        stringSimpleArray.add("bye");

        stringSimpleArray.remove(3);
        stringSimpleArray.remove("qwerty");
        stringSimpleArray.update(1, "stranger");

        String[] expectedArray = {"hello", "stranger"};
        String[] actualArray = new String[1];
        actualArray= stringSimpleArray.toArray(actualArray);

        assertThat(actualArray, is(expectedArray));

        assertThat(stringSimpleArray.get(1), is("stranger"));

    }

}
