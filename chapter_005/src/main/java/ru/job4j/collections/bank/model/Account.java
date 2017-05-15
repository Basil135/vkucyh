package ru.job4j.collections.bank.model;

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

    /**
     * method check this account equals to o.
     *
     * @param o is input account
     * @return true if this account equals to o
     */
    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Account account = (Account) o;

        if (Double.compare(account.value, value) != 0) {
            return false;
        }

        return requisites == account.requisites;

    }

    /**
     * method return integer number describes this account.
     *
     * @return integer number
     */
    @Override
    public int hashCode() {

        int result;
        long temp;

        temp = Double.doubleToLongBits(value);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (int) (requisites ^ (requisites >>> 32));

        return result;

    }

}
