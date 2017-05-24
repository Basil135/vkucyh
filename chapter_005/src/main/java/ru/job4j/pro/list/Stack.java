package ru.job4j.pro.list;

/**
 * This class describes collection stack.
 *
 * @param <E> is generic type
 *
 * @author Kucykh Vasily (mailto:basil135@mail.ru)
 * @version $Id$
 * @since 23.05.2017
 */
public class Stack<E> {

    /**
     * parameter last is link to last element of collection.
     */
    private Node<E> last;

    /**
     * method add element to collection.
     *
     * @param element is input element
     * @return true
     */
    public boolean push(E element) {

        Node<E> newNode = new Node<E>();

        newNode.prev = last;
        newNode.value = element;

        last = newNode;

        return true;

    }

    /**
     * method return value of last node and delete it.
     *
     * @return value
     */
    public E pop() {

        E result;

        result = last.value;

        last = last.prev;

        return result;

    }

    /**
     * method return true if stack have no elements.
     *
     * @return true if stack is empty
     */
    public boolean isEmpty() {
        return last == null;
    }

    /**
     * inner class describes node of the stack.
     *
     * @param <E> is generic type
     */
    private class Node<E> {

        /**
         * parameter prev is link to previous node.
         */
        private Node<E> prev;
        /**
         * parameter value is value of node.
         */
        private E value;

    }

}
