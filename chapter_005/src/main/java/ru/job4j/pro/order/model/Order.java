package ru.job4j.pro.order.model;

import java.util.Objects;

/**
 * This class describes data of order like volume and price.
 *
 * @author Kutsykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 28.01.2018
 */
public class Order {

    /**
     * parameter volume of order.
     */
    private final String volume;
    /**
     * parameter price of order.
     */
    private final String price;

    /**
     * constructor of this class.
     *
     * @param volume is volume of order
     * @param price is price of order
     */
    public Order(String volume, String price) {
        this.price = price;
        this.volume = volume;
    }

    /**
     * method return volume of order.
     *
     * @return volume
     */
    public String getVolume() {
        return volume;
    }

    /**
     * method return price of order.
     *
     * @return price
     */
    public String getPrice() {
        return price;
    }

    /**
     * method compare two objects.
     *
     * @param o is object to compare this
     * @return true if this equals o
     */
    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Order order = (Order) o;

        return Objects.equals(price, order.price);

    }

    /**
     * method return hashCode number of instance.
     *
     * @return hash code number
     */
    @Override
    public int hashCode() {
        return Objects.hash(price);
    }

    /**
     * method return string of instance of this class.
     *
     * @return string of instance
     */
    @Override
    public String toString() {
        return volume + "@" + price;
    }
}
