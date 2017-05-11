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

    /**
     * method tests method sortLength.
     */
    @Test
    public void whenListOfUsersWithDifferentNamesThenSortLengthSortsUsersByLengthOfName() {

        SortUser sort = new SortUser();

        List<User> test = new LinkedList<>();

        User basil = new User("Basil", 27);
        User alex = new User("Alex", 31);
        User sam = new User("Sam", 33);

        test.add(basil);
        test.add(alex);
        test.add(sam);

        List<User> expected = new LinkedList<>();

        expected.add(sam);
        expected.add(alex);
        expected.add(basil);

        List<User> actual = sort.sortLength(test);

        assertThat(actual, is(expected));

    }

    /**
     * method tests method sortHash.
     */
    @Test
    public void whenListOfUsersWithDifferentNamesAndAgesThenSortHashSortsUsersByHashcode() {

        SortUser sort = new SortUser();

        List<User> test = new LinkedList<>();

        User basil = new User("Basil", 27);
        User alex = new User("Alex", 31);
        User sam = new User("Sam", 33);

        test.add(basil);
        test.add(alex);
        test.add(sam);

        List<User> expected = new LinkedList<>();

        expected.add(sam);
        expected.add(alex);
        expected.add(basil);

        List<User> actual = sort.sortHash(test);

        assertThat(actual, is(expected));

    }

}
