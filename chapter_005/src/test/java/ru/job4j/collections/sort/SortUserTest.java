package ru.job4j.collections.sort;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * This class test SortUser class.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 10.05.2017
 */
public class SortUserTest {

    /**
     * method tests method sort at SortUser class.
     */
    @Test
    public void whenListOfUserContainsofFiveUsersThenSortByAge() {

        SortUser sort = new SortUser();

        User din = new User("Din", 23);
        User sam = new User("Sam", 15);
        User john = new User("John", 31);
        User sara = new User("Sara", 25);
        User greg = new User("Greg", 28);

        List<User> users = new LinkedList<>();

        users.add(din);
        users.add(sam);
        users.add(john);
        users.add(sara);
        users.add(greg);

        Set<User> expectedSet = new TreeSet<>();

        expectedSet.add(sam);
        expectedSet.add(din);
        expectedSet.add(sara);
        expectedSet.add(greg);
        expectedSet.add(john);

        Set<User> actualSet = sort.sort(users);

        assertThat(actualSet, is(expectedSet));

    }

}
