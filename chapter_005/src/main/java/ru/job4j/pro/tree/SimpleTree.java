package ru.job4j.pro.tree;

/**
 * This class uses as interface for latest treelike classes.
 *
 * @author Kutsykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 20.08.2017
 *
 * @param <E> generic type for element of collection treelike
 */
public interface SimpleTree<E extends Comparable<E>> extends Iterable<E> {

    /**
     * method add child to parent of collection treelike.
     *
     * @param parent is entity of tree collection
     * @param child is entity of tree collection
     * @return result of action, true if successfully added
     */
    boolean add(E parent, E child);

}
