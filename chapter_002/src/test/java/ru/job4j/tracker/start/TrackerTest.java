package ru.job4j.tracker.start;

import org.junit.Test;
import ru.job4j.tracker.controller.Tracker;
import ru.job4j.tracker.models.Item;

import java.util.ArrayList;
import java.util.List;

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

        Item element = new Item("example", null, null);
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

        Item elementOne = new Item("name", null, null);
        Item elementTwo = new Item("name", null, null);

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

        Item elementOne = new Item("name", null, null);
        Item elementTwo = new Item("example", null, null);

        Tracker tracker = new Tracker();

        tracker.add(elementOne);
        elementTwo.setId("1");
        elementOne.setId("1");
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

        Item elementOne = new Item("example", null, null);
        Item elementTwo = new Item("example", null, null);

        Tracker tracker = new Tracker();

        tracker.add(elementOne);
        tracker.add(elementTwo);
        tracker.delete(elementOne);

        List<Item> expectedItem = new ArrayList<>();
        expectedItem.add(elementTwo);

        List<Item> actualItem = tracker.findByName("example");

        assertThat(actualItem, is(expectedItem));

    }

    /**
     * method tests findAll.
     */
    @Test
    public void whenFindAllThenReturnAll() {

        Item elementOne = new Item("example", null, null);
        Item elementTwo = new Item("example", null, null);

        Tracker tracker = new Tracker();

        tracker.add(elementOne);
        tracker.add(elementTwo);

        List<Item> expectedItem = new ArrayList<>();
        expectedItem.add(elementOne);
        expectedItem.add(elementTwo);

        List<Item> actualItem = tracker.findAll();

        assertThat(actualItem, is(expectedItem));

    }

    /**
     * method tests findByName.
     */
    @Test
    public void whenFindByNameThenReturnAnArray() {

        Item elementOne = new Item("example", null, null);
        Item elementTwo = new Item("example", null, null);
        Item elementThree = new Item("name", null, null);
        Item elementFour = new Item("something", null, null);
        Item elementFive = new Item("just", null, null);
        Item elementSix = new Item("example", null, null);
        Item elementSeven = new Item("lamp", null, null);
        Item elementEight = new Item("name", null, null);
        Item elementNine = new Item("example", null, null);
        Item elementTen = new Item("example", null, null);

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

        List<Item> expectedItem = new ArrayList<>();
        expectedItem.add(elementOne);
        expectedItem.add(elementTwo);
        expectedItem.add(elementSix);
        expectedItem.add(elementNine);
        expectedItem.add(elementTen);

        List<Item> actualItem = tracker.findByName("example");

        assertThat(actualItem, is(expectedItem));

    }

}