package ru.job4j.chapter002.multithreading.list;

/**
 * This class describes simple (cut) collection list.
 *
 * @author Kutsykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 21.02.2018
 *
 * @param <E> is generic type.
 */
public interface MyList<E> extends Iterable<E> {
    /**
     * method add element e to the collection.
     *
     * @param e is input element
     * @return true if e successfully added to the collection
     */
    boolean add(E e);

    /**
     * method add element e to the collection by index.
     *
     * @param index is integer number describes position at the collection
     * @param e is input element
     * @return true if element successfully added to the collection
     */
    boolean add(int index, E e);

    /**
     * method delete element e from the collection.
     *
     * @param e is input element we need to delete
     * @return true if element e successfully deleted
     */
    boolean delete(E e);

    /**
     * method delete element from the collection by the index.
     *
     * @param index is input index we need to delete
     * @return true if element successfully deleted
     */
    boolean delete(int index);

    /**
     * method get element from collection by the index.
     *
     * @param index is input index
     * @return return element of the collection by the index
     */
    E get(int index);

    /**
     * method return size of the collection.
     *
     * @return integer number as size of the collection.
     */
    int size();

    /**
     * method return collection as array.
     *
     * @return array
     */
    Object[] toArray();
}
