package ru.job4j.tracker.controller;

import ru.job4j.tracker.models.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * This class describes tracker.
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 12.04.2017
 */
public class Tracker {

    /**
     * parameter id is numeric id of item.
     */
    private int id = 1;
    /**
     * parameter items is list of items.
     */
    private List<Item> items = new ArrayList<>();

    /**
     * method return length of array items.
     *
     * @return length of list of items
     */
    public int size() {
        return this.items.size();
    }

    /**
     * method add item to list of items.
     *
     * @param item is item to put to list
     * @return item that put to list
     */
    public Item add(Item item) {

        item.setId(String.valueOf(id++));

        items.add(item);

        return item;

    }

    /**
     * method update an item to list of items.
     *
     * @param item is input item
     */
    public void update(Item item) {

        for (Item counter : this.items) {

            int index = this.items.lastIndexOf(counter);

            if (counter.getId().equals(item.getId())) {
                this.items.set(index, item);
                break;
            }

        }

    }

    /**
     * method delete one item that equals input item.
     *
     * @param item is input item
     */
    public void delete(Item item) {

        items.remove(item);

    }

    /**
     * method return list of items.
     *
     * @return list of items
     */
    public List<Item> findAll() {

        return items;

    }

    /**
     * method return list of items that name of item equals key.
     *
     * @param key is input string as name of an item
     * @return list of items
     */
    public List<Item> findByName(String key) {

        List<Item> result = new ArrayList<>();

        for (Item item : this.items) {

            if (item.getName().equals(key)) {
                result.add(item);
            }

        }

        return result;

    }

    /**
     * method find item from items that item id is equals to input id.
     *
     * @param id is input string id
     * @return item that item's id is equals to input id
     */
    public Item findById(String id) {

        Item result = null;

        for (Item item : this.items) {

            if (item.getId().equals(id)) {
                result = item;
                break;
            }

        }

        return result;

    }

}