package ru.job4j.pro.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class describes linked list collection.
 *
 * @param <E> is generic type
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 23.05.2017
 */
public class LinkedList<E> implements Iterable<E> {

    /**
     * parameter first is link to first element of collection.
     */
    private Node<E> first;
    /**
     * parameter last is link to last element of collection.
     */
    private Node<E> last;
    /**
     * parameter size is size of collection.
     */
    private int size = 0;

    /**
     * method add to collection element.
     *
     * @param element is input element
     * @return true
     */
    public boolean add(E element) {
        if (first == null) {
            Node<E> newNode = new Node<>();
            newNode.value = element;
            first = newNode;
            last = newNode;
            size++;
        } else {
            Node<E> newNode = new Node<>();
            last.next = newNode;
            newNode.prev = last;
            newNode.value = element;
            last = newNode;
            size++;
        }
        return true;
    }

    /**
     * method get element by index.
     *
     * @param index is index of element
     * @return element
     */
    public E get(int index) {
        if (index > 0 && index < size) {
            Node<E> newNode = first;
            for (int count = 0; count <= index; count++) {
                newNode = newNode.next;
                if (count == index) {
                    return newNode.value;
                }
            }
        }
        throw new IndexOutOfBoundsException();
    }

    /**
     * method return iterator of list.
     *
     * @return instance of ListIterator
     */
    @Override
    public Iterator<E> iterator() {
        return new ListIterator<>();
    }

    /**
     * inner class describes node of collection.
     *
     * @param <E> is generic type
     */
    private class Node<E> {

        private Node<E> prev;

        private Node<E> next;

        private E value;

    }

    /**
     * inner class describes iterator of list.
     *
     * @param <E> is generic type
     */
    private class ListIterator<E> implements Iterator<E> {

        /**
         * parameter index is number of element from collection.
         */
        private int index = 0;
        /**
         * parameter currentNode is node index number of element from collection.
         */
        private Node<E> currentNode = (Node<E>) first;
        /**
         * parameter currentValue is value of currentNode.
         */
        private E currentValue;

        /**
         * method return true if iterator can iterate.
         *
         * @return true if iterator can iterate
         */
        @Override
        public boolean hasNext() {
            return index < size;
        }

        /**
         * method return element by index.
         *
         * @return element
         */
        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (currentNode == null) {
                currentNode = (Node<E>) first;
            }
            currentValue = currentNode.value;
            currentNode = currentNode.next;
            index++;
            return currentValue;
        }

    }

}
