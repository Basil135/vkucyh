package ru.job4j.collections.bank;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * This class describes operation with accounts of any user.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 12.05.2017
 */
public class Bank {

    /**
     * collection map of user as key and list of accounts as value.
     */
    private Map<User, List<Account>> client = new HashMap<>();
    /**
     * parameter list is list of accounts.
     */
    private List<Account> list = new LinkedList<>();

    /**
     * method add user to map client.
     *
     * @param user is user
     */
    public void addUser(User user) {
        client.put(user, list);
    }

    /**
     * method delete user from map client.
     *
     * @param user is user
     */
    public void deleteUser(User user) {
        client.remove(user);
    }

    /**
     * method add account to list of accounts to user of map client.
     *
     * @param user is user as key of the map client
     * @param account is account as value of list of accounts from map client
     */
    public void addAccountToUser(User user, Account account) {
        client.get(user).add(account);
    }

    /**
     * method delete account from list of accounts from user.
     *
     * @param user is key of map client
     * @param account is value of list of accounts in map client
     */
    public void deleteAccountFromUser(User user, Account account) {
        client.get(user).remove(account);
    }

    /**
     * method return list of accounts of user.
     *
     * @param user is user as key of map client
     * @return list of accounts of user
     */
    public List<Account> getUserAccounts(User user) {
        return client.get(user);
    }

    /**
     * method transfer amount money from srcAccount of srcUser to dstAccount of dstUser.
     *
     * @param srcUser is user who transfer money
     * @param srcAccount is account of srcUser
     * @param dstUser is user who take the amount money
     * @param dstAccount is account of dstUser
     * @param amount is amount money
     * @return true if transfer was successfully
     */
    public boolean transferMoney(User srcUser, Account srcAccount, User dstUser, Account dstAccount, double amount) {

        boolean result = false;

        if (client.containsKey(srcUser) && client.containsKey(dstUser)) {

            if (client.get(srcUser).contains(srcAccount) && client.get(dstUser).contains(dstAccount)) {

                int index = client.get(srcUser).indexOf(srcAccount);

                if (client.get(srcUser).get(index).getValue() >= amount) {

                    result = true;

                    client.get(srcUser).get(index).setValue(client.get(srcUser).get(index).getValue() - amount);

                    index = client.get(dstUser).indexOf(dstAccount);

                    client.get(dstUser).get(index).setValue(client.get(dstUser).get(index).getValue() + amount);

                }

            }
        }

        return result;

    }

    /**
     * method transfer amount money from user's srcAccount to user's dstAccount.
     *
     * @param user is user who transfer and take money
     * @param srcAccount is account transfer money from
     * @param dstAccount is account transfer money to
     * @param amount is amount of money
     * @return true if was successfully
     */
    public boolean transferMoney(User user, Account srcAccount, Account dstAccount, double amount) {

        return transferMoney(user, srcAccount, user, dstAccount, amount);

    }

}