package ru.job4j.tracker.start;

import org.junit.Test;
import ru.job4j.tracker.controller.StubInput;
import ru.job4j.tracker.controller.Tracker;
import ru.job4j.tracker.ui.StartUI;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * This class tests StartUI class.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 14.04.2017
 */
public class StartUITest {

    /**
     * method tests add to tracker at StartUI with stub input.
     */
    @Test
    public void whenAddItemThenFindAllReturnSameItem() {

        String[] answers = {"0", "name", "description", "6"};

        Tracker tracker = new Tracker();

        String[] expectedArray = {"name", "description"};
        String[] actualArray = new String[2];

        StubInput input = new StubInput(answers);

        new StartUI(input, tracker).init();

        actualArray[0] = tracker.findAll()[0].getName();
        actualArray[1] = tracker.findAll()[0].getDescription();

        assertThat(actualArray, is(expectedArray));

    }

    /**
     * method tests find by id in tracker at StartUI with stub input.
     */
    @Test
    public void whenAddItemThenGetByIdReturnSameItem() {

        String[] answers = {"0", "name", "description", "6"};

        Tracker tracker = new Tracker();

        String[] expectedItem = {"name", "description"};
        String[] actualItem = new String[2];

        StubInput input = new StubInput(answers);

        new StartUI(input, tracker).init();

        actualItem[0] = tracker.findById("1").getName();
        actualItem[1] = tracker.findById("1").getDescription();

        assertThat(actualItem, is(expectedItem));

    }

    /**
     * method tests find by name in tracker at StartUI with stub input.
     */
    @Test
    public void whenAddItemThenGetByNameReturnSameItem() {

        String[] answers = {"0", "name", "description", "6"};

        Tracker tracker = new Tracker();

        String[] expectedArray = {"name", "description"};
        String[] actualArray = new String[2];

        StubInput input = new StubInput(answers);

        new StartUI(input, tracker).init();

        actualArray[0] = tracker.findByName("name")[0].getName();
        actualArray[1] = tracker.findByName("name")[0].getDescription();

        assertThat(actualArray, is(expectedArray));

    }

    /**
     * method tests delete from tracker at StartUI with stub input.
     */
    @Test
    public void whenAddTwoSameItemsAndDeleteOneThenFindAllReturnOneItem() {

        String[] answers = {"0", "name", "description", "0", "name1", "description1", "3", "1", "6"};

        Tracker tracker = new Tracker();

        String[] expected = {"name1", "description1"};
        String[] actual = new String[2];

        StubInput input = new StubInput(answers);

        new StartUI(input, tracker).init();

        actual[0] = tracker.findAll()[0].getName();
        actual[1] = tracker.findAll()[0].getDescription();

        assertThat(actual, is(expected));

    }

    /**
     * method tests update item in tracker at StartUI with stub input.
     */
    @Test
    public void whenAddOneItemAndUpdateThenFindAllReturnOneUpdatedItem() {

        String[] answers = {"0", "name", "description", "2", "1", "0", "example", "6"};

        Tracker tracker = new Tracker();

        String[] expected = {"example", "description"};
        String[] actual = new String[2];

        StubInput input = new StubInput(answers);

        new StartUI(input, tracker).init();

        actual[0] = tracker.findAll()[0].getName();
        actual[1] = tracker.findAll()[0].getDescription();

        assertThat(actual, is(expected));

    }

}
