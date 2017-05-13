package ru.job4j.collections.bank;

/**
 * This class describes account of bank.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 */
public class Account {

    /**
     * @param value is how much money at this account.
     */
    private double value;
    /**
     * @param requisites is long nuber of account.
     */
    private final long requisites;

    /**
     * constructor of Account.
     *
     * @param value is value of maney on this account
     * @param requisites is requisites of this account
     */
    public Account(final double value, final long requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    /**
     * method return value of money at the account.
     *
     * @return value of money
     */
    public double getValue() {
        return value;
    }

    /**
     * method set value of money.
     *
     * @param value is value of money
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * method return requisites of the account.
     *
     * @return requisites of the account
     */
    public long getRequisites() {
        return requisites;
    }

}
