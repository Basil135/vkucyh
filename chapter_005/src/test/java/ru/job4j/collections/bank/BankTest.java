package ru.job4j.collections.bank;

import org.junit.Test;
import ru.job4j.collections.bank.exceptions.UnknownAccountException;
import ru.job4j.collections.bank.exceptions.UnknownUserException;
import ru.job4j.collections.bank.model.Account;
import ru.job4j.collections.bank.model.Bank;
import ru.job4j.collections.bank.model.User;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertTrue;

/**
 * This class tests all methods of class Bank.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 13.05.2017
 */
public class BankTest {

    /**
     * method tests methods addUser, addAccount, getUserAccounts.
     *
     * @throws UnknownUserException if there is no user at this collection
     */
    @Test
    public void whenAddUserThenMapHaveThisUser() throws UnknownUserException {

        User testUser = new User("Boris", "any passport data");

        Account testAccount = new Account(0, 1234567890);

        Bank bank = new Bank();

        bank.addUser(testUser);

        bank.addAccountToUser(testUser, testAccount);

        List<Account> expectedList = new LinkedList<>();

        expectedList.add(testAccount);

        List<Account> actualList = bank.getUserAccounts(testUser);

        assertThat(actualList, is(expectedList));

    }

    /**
     * method tests method transferMoney from one user's account to another with positive outcome.
     *
     * @throws UnknownUserException if there is no user at this collection
     * @throws UnknownAccountException if there is no account at this collection
     */
    @Test
    public void whenUserTransferMoneyFromOneAccountToAnotherAccountThenTrue() throws UnknownUserException, UnknownAccountException {

        User testUser = new User("Boris", "any passport data");

        Account testFirstAccount = new Account(45.42, 1234567890);
        Account testSecondAccount = new Account(0, 987654321);

        Bank bank = new Bank();

        bank.addUser(testUser);

        bank.addAccountToUser(testUser, testFirstAccount);
        bank.addAccountToUser(testUser, testSecondAccount);

        double amount = 13.13;

        boolean expectedValue = true;
        boolean actualValue = bank.transferMoney(testUser, testFirstAccount, testSecondAccount, amount);

        assertThat(actualValue, is(expectedValue));

        assertFalse(testFirstAccount.getValue() == 45.42);
        assertFalse(testSecondAccount.getValue() == 0);

        assertTrue(testFirstAccount.getValue() == 32.29);
        assertTrue(testSecondAccount.getValue() == 13.13);

    }

    /**
     * method tests method deleteAccountFromUser and deleteUser.
     *
     * @throws UnknownAccountException if there is no account at this collection
     * @throws UnknownUserException if there is no user at this collection
     */
    @Test (expected = UnknownAccountException.class)
    public void whenUserTransferMoneyFromOneAccountToAnotherThenFalse() throws UnknownUserException, UnknownAccountException {

        User testUser = new User("Boris", "any passport data");

        Account testFirstAccount = new Account(45.42, 1234567890);
        Account testSecondAccount = new Account(0, 987654321);

        Bank bank = new Bank();

        bank.addUser(testUser);

        bank.addAccountToUser(testUser, testFirstAccount);
        bank.addAccountToUser(testUser, testSecondAccount);

        bank.deleteAccountFromUser(testUser, testSecondAccount);

        double amount = 13.13;

        boolean expectedValue = false;
        boolean actualValue = bank.transferMoney(testUser, testFirstAccount, testSecondAccount, amount);

        assertThat(actualValue, is(expectedValue));

        assertTrue(testFirstAccount.getValue() == 45.42);
        assertTrue(testSecondAccount.getValue() == 0);

        assertFalse(testFirstAccount.getValue() == 32.29);
        assertFalse(testSecondAccount.getValue() == 13.13);

        bank.addAccountToUser(testUser, testSecondAccount);

        bank.deleteUser(testUser);

        actualValue = bank.transferMoney(testUser, testFirstAccount, testSecondAccount, amount);

        assertThat(actualValue, is(expectedValue));

        assertTrue(testFirstAccount.getValue() == 45.42);
        assertTrue(testSecondAccount.getValue() == 0);

        assertFalse(testFirstAccount.getValue() == 32.29);
        assertFalse(testSecondAccount.getValue() == 13.13);

    }

}
