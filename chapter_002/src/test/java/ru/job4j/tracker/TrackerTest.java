package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * This class tests all method from Tracker.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 12.04.2017
 */
public class TrackerTest {

    /**
     * method tests add element.
     */
    @Test
    public void whenAddOneElementThenThisElementAdd() {

        Item element = new Item("example", "1", null, 0, null);
        Tracker tracker = new Tracker();

        Item expectedItem = element;
        Item actualItem = tracker.add(element);

        assertEquals(expectedItem, actualItem);

    }

    /**
     * method tests changing array items.
     */
    @Test
    public void whenAddTwoElementsThenSizeEqualsTwo() {

        Item elementOne = new Item("name", "1", null, 0, null);
        Item elementTwo = new Item("name", "2", null, 0, null);

        Tracker tracker = new Tracker();

        tracker.add(elementOne);
        tracker.add(elementTwo);

        int expectedValue = 2;
        int actualValue = tracker.size();

        assertThat(actualValue, is(expectedValue));

    }

    /**
     * method tests update and findById.
     */
    @Test
    public void whenUpdateThenFindById() {

        Item elementOne = new Item("name", "1", null, 0, null);
        Item elementTwo = new Item("example", "1", null, 0, null);

        Tracker tracker = new Tracker();

        tracker.add(elementOne);
        tracker.update(elementTwo);

        Item expectedItem = elementTwo;
        Item actualItem = tracker.findById("1");

        assertEquals(expectedItem, actualItem);

    }

    /**
     * method tests delete and findByName.
     */
    @Test
    public void whenDeleteThenFindByName() {

        Item elementOne = new Item("example", "1", null, 0, null);
        Item elementTwo = new Item("example", "2", null, 0, null);

        Tracker tracker = new Tracker();

        tracker.add(elementOne);
        tracker.add(elementTwo);
        tracker.delete(elementOne);

        Item[] expectedItem = {elementTwo};
        Item[] actualItem = tracker.findByName("example");

        assertThat(actualItem, is(expectedItem));

    }

    /**
     * method tests findAll.
     */
    @Test
    public void whenFindAllThenReturnAll() {

        Item elementOne = new Item("example", "1", null, 0, null);
        Item elementTwo = new Item("example", "2", null, 0, null);

        Tracker tracker = new Tracker();

        tracker.add(elementOne);
        tracker.add(elementTwo);

        Item[] expectedItem = {elementOne, elementTwo};
        Item[] actualItem = tracker.findAll();

        assertThat(actualItem, is(expectedItem));

    }

    /**
     * method tests findByName.
     */
    @Test
    public void whenFindByNameThenReturnAnArray() {

        Item elementOne = new Item("example", "1", null, 0, null);
        Item elementTwo = new Item("example", "2", null, 0, null);
        Item elementThree = new Item("name", "3", null, 0, null);
        Item elementFour = new Item("something", "4", null, 0, null);
        Item elementFive = new Item("just", "5", null, 0, null);
        Item elementSix = new Item("example", "6", null, 0, null);
        Item elementSeven = new Item("lamp", "7", null, 0, null);
        Item elementEight = new Item("name", "8", null, 0, null);
        Item elementNine = new Item("example", "9", null, 0, null);
        Item elementTen = new Item("example", "10", null, 0, null);

        Tracker tracker = new Tracker();

        tracker.add(elementOne);
        tracker.add(elementTwo);
        tracker.add(elementThree);
        tracker.add(elementFour);
        tracker.add(elementFive);
        tracker.add(elementSix);
        tracker.add(elementSeven);
        tracker.add(elementEight);
        tracker.add(elementNine);
        tracker.add(elementTen);

        Item[] expectedItem = {elementOne, elementTwo, elementSix, elementNine, elementTen};
        Item[] actualItem = tracker.findByName("example");

        assertThat(actualItem, is(expectedItem));

    }

}