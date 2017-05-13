package ru.job4j.collections.bank;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * This class tests all methods of class Account.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 13.05.2017
 */
public class AccountTest {

    /**
     * method tests methods setValue and getValue.
     */
    @Test
    public void whenValueIsTwentyAndThirtyThenGetValueIsTwentyAndThirty() {

        Account testAccount = new Account(0, 1234567890);

        testAccount.setValue(20.30);

        double expectedValue = 20.30;
        double actualValue = testAccount.getValue();

        assertThat(actualValue, is(expectedValue));

    }

    /**
     * method tests method getRequisites.
     */
    @Test
    public void whenRequisitesAreOneTwoThreeFourThenGetRequisitesAreOneTwoThreeFour() {

        Account testAccount = new Account(0, 1234);

        long expectedValue = 1234;
        long actualValue = testAccount.getRequisites();

        assertThat(actualValue, is(expectedValue));

    }

}
