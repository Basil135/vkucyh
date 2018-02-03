package ru.job4j.pro.order.controller;

import ru.job4j.pro.order.model.BookOrder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * This class describes order map entity.
 *
 * @author Kutsykh Vasily (mailto:basil135@mqil.ru)
 * @version $Id$
 * @since 28.01.2018
 */
public class OrderMap {
    /**
     * this parameter is map of string as book name and list of BookOrder as order of book by name.
     */
    private final Map<String, List<BookOrder>> map = new HashMap<>();
    /**
     * method add order to map.
     *
     * @param bookName name of book that order to
     * @param bookOrder order of book as class BookOrder
     */
    public void addOrder(final String bookName, final BookOrder bookOrder) {
        List<BookOrder> list = map.get(bookName);
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(bookOrder);
        map.put(bookName, list);
    }
    /**
     * method delete order from map.
     *
     * @param bookName is name of book
     * @param bookOrder is order of book to delete
     */
    public void deleteOrder(final String bookName, final BookOrder bookOrder) {
        List<BookOrder> list = map.get(bookName);
        if (list != null) {
            list.remove(bookOrder);
            map.put(bookName, list);
        }
    }
    /**
     * method generate set of string as book name from map.
     *
     * @return set of string
     */
    public Set<String> getBookNames() {
        return map.keySet();
    }
    /**
     * method return map.
     *
     * @return map
     */
    public Map<String, List<BookOrder>> getMap() {
        return map;
    }
}
