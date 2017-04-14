package ru.job4j.tracker.start;

import ru.job4j.tracker.models.Item;

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
     * parameter index is index of array items.
     */
    private int index = 0;
    /**
     * parameter size is started size of array items.
     */
    private int size = 0;
    /**
     * parameter items is array of Item.
     */
    private Item[] items = new Item[8];

    /**
     * method return length of array items.
     *
     * @return length of array items
     */
    public int size() {
        return size;
    }

    /**
     * method add item to array items.
     *
     * @param item is item to put to array
     * @return item that put to array
     */
    public Item add(Item item) {

        item.setId(String.valueOf(id++));

        if (index < items.length) {
            items[index++] = item;
            size++;
        } else {

            Item[] newItems = new Item[items.length * 2];
            System.arraycopy(items, 0, newItems, 0, items.length);
            items = newItems;
            items[index++] = item;
            size++;

        }

        return item;

    }

    /**
     * method update an item of array items.
     *
     * @param item is input item
     */
    public void update(Item item) {

        for (int count = 0; count < items.length; count++) {

            if (items[count].getId().equals(item.getId())) {
                items[count] = item;
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

        for (int count = 0; count < this.size(); count++) {

            if (items[count].getId().equals(item.getId())) {
                System.arraycopy(items, count + 1, items, count, items.length - count - 1);
                items[items.length - 1] = null;
                size--;
                break;
            }

        }

    }

    /**
     * method return array items.
     *
     * @return array items
     */
    public Item[] findAll() {

        Item[] result = new Item[this.size()];

        for (int count = 0; count < this.size(); count++) {
            result[count] = items[count];
        }

        return result;

    }

    /**
     * method return array of items that name of item equals key.
     *
     * @param key is input string as name of an item
     * @return array of items
     */
    public Item[] findByName(String key) {

        int size = 0;
        int index = 0;

        for (int count = 0; count < this.size(); count++) {
            if (items[count].getName().equals(key)) {
                size++;
            }
        }

        Item[] result = new Item[size];

        for (int count = 0; count < items.length; count++) {

            if (items[count] == null) {
                break;
            }

            if (items[count].getName().equals(key)) {

                    result[index++] = items[count];

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

        for (int count = 0; count < items.length; count++) {

            if (items[count].getId().equals(id)) {
                result = items[count];
                break;
            }

        }

        return result;

    }

}