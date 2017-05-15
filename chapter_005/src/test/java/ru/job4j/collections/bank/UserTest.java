package ru.job4j.collections.bank;

import org.junit.Test;
import ru.job4j.collections.bank.model.User;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * This class tests class class User.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 13.05.2017
 */
public class UserTest {

    /**
     * method tests method getName.
     */
    @Test
    public void whenUserWithNameBorisThenGetNameIsBoris() {

        User testUser = new User("Boris", "any passport data");

        String expectedValue = "Boris";
        String actualValue = testUser.getName();

        assertThat(actualValue, is(expectedValue));

    }

    /**
     * method tests method getPassport.
     */
    @Test
    public void whenUserWithPassportAnyPassportDataThenGetPassportAnyPassportData() {

        User testUser = new User("Boris", "any passport data");

        String expectedValue = "any passport data";
        String actualValue = testUser.getPassport();

        assertThat(actualValue, is(expectedValue));

    }

    /**
     * method tests method hashcode.
     */
    @Test
    public void whenUserWithNameAAndPassportBThenHashcode2081() {

        User testUser = new User("A", "B");

        int expectedValue = 2081;
        int actualValue = testUser.hashCode();

        assertThat(actualValue, is(expectedValue));

    }

    /**
     * method tests method equals with positive equals.
     */
    @Test
    public void whenTwoSameUsersThenEqualsAreTrue() {

        User firstTestUser = new User("Boris", "any passport data");
        User secondTestUser = new User("Boris", "any passport data");

        boolean expectedValue = true;
        boolean actualValue = firstTestUser.equals(secondTestUser);

        assertThat(expectedValue, is(actualValue));

    }

    /**
     * method tests method equals with negative equals.
     */
    @Test
    public void whenTwoDifferentUsersThenEqualsFalse() {

        User firstTestUser = new User("Boris", "any passport data");
        User secondTestUser = new User("Basil", "any passport data");

        boolean expectedValue = false;
        boolean actualValue = firstTestUser.equals(secondTestUser);

        assertThat(expectedValue, is(actualValue));

    }

}