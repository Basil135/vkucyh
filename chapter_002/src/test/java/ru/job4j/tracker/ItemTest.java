package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * This class tests all methods from Item class.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 12.04.2017
 */
public class ItemTest {

    /**
     * method tests getName.
     */
    @Test
    public void whenNameIsExampleThenGetNameIsExample() {

        Item item = new Item(null, null, null, 0, null);

        item.setName("example");

        String expectedValue = "example";
        String actualValue = item.getName();

        assertThat(actualValue, is(expectedValue));

    }

    /**
     * method tests getDescription.
     */
    @Test
    public void whenDescriptionIsTestItemThenGetDescriptionIsTestItem() {

        Item item = new Item(null, null, null, 0, null);

        item.setDescription("test item");

        String expectedValue = "test item";
        String actualValue = item.getDescription();

        assertThat(actualValue, is(expectedValue));

    }

    /**
     * method tests getId.
     */
    @Test
    public void whenIdIsOneThenGetIdIsOne() {

        Item item = new Item(null, null, null, 0, null);

        item.setId("1");

        String expectedValue = "1";
        String actualValue = item.getId();

        assertThat(actualValue, is(expectedValue));

    }

    /**
     * method tests getCreation.
     */
    @Test
    public void whenCreationDateIs100000ThenGetCreationIs100000() {

        Item item = new Item(null, null, null, 0, null);

        item.setCreationDate(100000);

        long expectedValue = 100000;
        long actualValue = item.getCreationDate();

        assertThat(actualValue, is(expectedValue));

    }

    /**
     * method tests getComments.
     */
    @Test
    public void whenCommentsAreThenGetCommentIsEqualsToInputComments() {

        String[] testValues = {"comment one", "comment two"};

        Item item = new Item(null, null, null, 0, null);

        item.setComments(testValues);

        String[] expectedValue = testValues;
        String[] actualValue = item.getComments();

        assertThat(actualValue, is(expectedValue));

    }

    /**
     * method tests constructor.
     */
    @Test
    public void whenConstructorIsAddValuesThenEqualsAsSetValues() {

        String[] testValues = {"comment"};

        Item expectedItem = new Item(null, null, null, 0, null);
        Item actualItem  = new Item("name", "1", "description", 20, testValues);

        expectedItem.setName("name");
        expectedItem.setId("1");
        expectedItem.setDescription("description");
        expectedItem.setCreationDate(20);
        expectedItem.setComments(testValues);

        assertEquals(expectedItem, actualItem);
        //assertThat(actualItem, is(expectedItem));

    }

}
