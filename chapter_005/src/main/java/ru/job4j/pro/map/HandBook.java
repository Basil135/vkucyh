package ru.job4j.pro.map;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * This class describes collection like map.
 *
 * @author Kutsykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 30.07.2017
 *
 * @param <T> generic type of key
 * @param <V> generic type of value
 */
public class HandBook<T, V> {

    /**
     * parameter capacity is capacity of array hashTable.
     */
    private int capacity = 16;
    /**
     * parameter loadFactory is number of how much elements can contains array hashTable before resize.
     */
    private double loadFactory = 0.75;
    /**
     * parameter size is number of elements hashTable contains.
     */
    private int size = 0;
    /**
     * parameter hashTable is array of list of entity.
     */
    private List<Entity<T, V>>[] hashTable = new ArrayList[capacity];

    /**
     * method return size of HandBook collection.
     *
     * @return size as integer
     */
    public int getSize() {
        return size;
    }

    /**
     * method increase hashTable by two.
     *
     * @return new array of list of entity
     */
    private List<Entity<T, V>>[] resize() {

        capacity *= 2;

        size = 0;

        List<Entity<T, V>>[] newHashTable = new ArrayList[capacity];

        for (List<Entity<T, V>> entityList : hashTable) {

            if (entityList != null) {

                addToArray(newHashTable, entityList);

            }

        }

        return newHashTable;

    }

    /**
     * method add list of entity to array.
     *
     * @param array is input array to add
     * @param entityList is inout list of entity should be added
     */
    private void addToArray(List<Entity<T, V>>[] array, List<Entity<T, V>> entityList) {

        for (Entity<T, V> entity : entityList) {

            int position = entity.key.hashCode() % capacity;

            addToList(array, entity, position);

        }

    }

    /**
     * method add entity to list.
     *
     * @param array is input array of lists of entities
     * @param entity is input entity to add
     * @param position is position in array to add
     * @return true
     */
    private boolean addToList(List<Entity<T, V>>[] array, Entity<T, V> entity, int position) {

        if (array[position] != null) {

            for (Entity<T, V> currentEntity : array[position]) {

                if (currentEntity.key.equals(entity.key)) {

                    currentEntity.value = entity.value;

                    return true;

                }

            }

            array[position].add(entity);

            size++;

            return true;

        }

        array[position] = new ArrayList<>();

        array[position].add(entity);

        size++;

        return true;

    }

    /**
     * method insert key and value as entity to an array.
     *
     * @param key is input key
     * @param value isinout value
     * @return true
     */
    public boolean insert(T key, V value) {

        Entity<T, V> entity = new Entity<>(key, value);

        if (!(size < capacity * loadFactory)) {

            hashTable = resize();

        }

        return addToList(hashTable, entity, key.hashCode() % capacity);

    }

    /**
     * method return value by key from HandBook collection.
     *
     * @param key is input key
     * @return return value if exist
     */
    public V get(T key) {

        V result = null;

        int position = key.hashCode() % capacity;

        for (Entity<T, V> currentEntity : hashTable[position]) {

            if (currentEntity.key.equals(key)) {

                result = currentEntity.value;

            }

        }

        return result;

    }

    /**
     * method delete entity by key from HandBook.
     *
     * @param key is input key
     * @return true if HandBook contains entity with key equals input key
     */
    public boolean delete(T key) {

        int position = key.hashCode() % capacity;

        if (hashTable[position] != null) {

            for (Entity<T, V> currentEntity : hashTable[position]) {

                if (currentEntity.key.equals(key)) {

                    hashTable[position].remove(currentEntity);

                    size--;

                    return true;

                }

            }

        }

        return false;

    }

    /**
     * method return new iterator of HandBook class.
     *
     * @return iterator
     */
    public Iterator<V> iterator() {

        return new HandBookIterator();

    }

    /**
     * This inner class describes entity of entities from HandBook.
     *
     * @param <T> generic type of key
     * @param <V> generic type of value
     */
    private static class Entity<T, V> {

        /**
         * parameter key of generic type.
         */
        private T key;
        /**
         * parameter vslue of generic type.
         */
        private V value;

        /**
         * constructor of class entity.
         *
         * @param key is input key
         * @param value is input value
         */
        private Entity(T key, V value) {

            this.key = key;

            this.value = value;

        }

    }

    /**
     * This class describes iterator of HandBook collection.
     *
     */
    private class HandBookIterator implements Iterator<V> {
        /**
         * index of array hashTable.
         */
        private int index = 0;
        /**
         * iterator of list of hashTable by index.
         */
        private Iterator<Entity<T, V>> listIterator = hashTable[index].iterator();

        /**
         * method return true if HandBook collection have more elements.
         *
         * @return true if this element is not last
         */
        @Override
        public boolean hasNext() {

            while (index < capacity - 1 || listIterator.hasNext()) {

                if (hashTable[index] == null || !listIterator.hasNext()) {

                    if (hashTable[++index] == null) {

                        continue;

                    } else {

                        listIterator = hashTable[index].iterator();

                    }

                } else {

                    return true;

                }

            }

            return false;

        }

        /**
         * method return current element and move pointer to the next element.
         *
         * @return value of entity of HandBook collection
         */
        @Override
        public V next() {

            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            Entity<T, V> entity = listIterator.next();

            return entity.value;

        }

    }

}
